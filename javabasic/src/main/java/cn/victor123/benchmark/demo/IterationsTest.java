package cn.victor123.benchmark.demo;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * 默认10次迭代
 */
public class IterationsTest {


  @Benchmark
  @Warmup(iterations = 0, time = 1, timeUnit = TimeUnit.SECONDS)
  @Measurement( time = 1, timeUnit = TimeUnit.SECONDS)
  public void defaultIterations() {
    // this method was intentionally left blank.
  }

  @Benchmark
  @Warmup(iterations = 0, time = 1, timeUnit = TimeUnit.SECONDS)
  @Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
  public void Iterations1() {
    // this method was intentionally left blank.
  }

  @Benchmark
  @Warmup(iterations = 0, time = 1, timeUnit = TimeUnit.SECONDS)
  @Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
  public void Iterations2() {
    // this method was intentionally left blank.
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(IterationsTest.class.getSimpleName())
        .forks(1)
        .build();

    new Runner(opt).run();
  }
}