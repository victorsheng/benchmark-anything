package cn.victor123.benchmark;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
public class CopyBenchmark {

  @Param({"/Users/victor/tennis/match6.0.mp4"})
//  @Param({"/Users/victor/Downloads/IMG_2844.MOV"})
  private String inputPath;

  private StreamConvert streamConvert;

  @Param({"cn.victor123.benchmark.impl.ApacheCommonImpl",
      "cn.victor123.benchmark.impl.JdkChannelImpl"})
  private String className;

  @Setup
  public void init()
      throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    Class<?> aClass = Class.forName(className);
    Constructor<?> constructor = aClass.getConstructor(null);
    streamConvert = (StreamConvert) constructor.newInstance(null);

  }

  @Benchmark
  public void test1(Blackhole bh) throws IOException {
    File tempFile = File.createTempFile("hhhh", "kkkk");
    try (FileInputStream fileInputStream = new FileInputStream(
        inputPath);) {
//      tempFile.deleteOnExit();
      FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
      streamConvert.copy(fileInputStream, fileOutputStream, 1024);
      bh.consume(fileOutputStream);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      tempFile.delete();
    }
  }


  public static void main(String[] args) throws RunnerException {
    if (args == null || args.length < 1) {
      throw new RunnerException("args wrong");
    }

    Options opt = new OptionsBuilder()
        .include(CopyBenchmark.class.getSimpleName())
        .forks(1)
        .param("inputPath", args[0].split(","))
        .build();

    new Runner(opt).run();
  }


}
