package cn.victor123.benchmark.read.bm;

import cn.victor123.benchmark.read.DataGenerator;
import cn.victor123.benchmark.read.FileReader;
import java.io.File;
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

@Deprecated
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.MILLISECONDS)
public class ReadBenchMark {


  @Param({
      "cn.victor123.benchmark.read.impl.BufferedInputStreamFileReader",
      "cn.victor123.benchmark.read.impl.InDirectBufferFileChannelReader",
      "cn.victor123.benchmark.read.impl.InputStreamFileReader",
      "cn.victor123.benchmark.read.impl.MultiMmapFileReader",
  })
  private String className;

  private FileReader fileReader;

  @Param({
//      "32", "64", "128", "256",
      "" + 1024, "" + 1024 * 2, "" + 1024 * 4, "" + 1024 * 8,
      "" + 1024 * 16, "" + 1024 * 32, "" + 1024 * 64, "" + 1024 * 128,
  })
  private int fileSize;

  @Param({"2000",})
  private int bufferSize;

  @Setup
  public void init()
      throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    Class<?> aClass = Class.forName(className);
    Constructor<?> constructor = aClass.getConstructor(null);
    fileReader = (FileReader) constructor.newInstance(null);

  }

  @Benchmark
  public void test(Blackhole bh) throws Exception {
    String gen = DataGenerator.gen(fileSize);
    bh.consume(fileReader.read(gen, bufferSize));
    bh.consume(new File(gen).delete());
  }

}
