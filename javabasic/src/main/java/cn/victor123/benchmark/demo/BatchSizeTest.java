package cn.victor123.benchmark.demo;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;


public class BatchSizeTest {


  @Benchmark
  @Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
  @Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
  public void defaultBatchSize() {
    // this method was intentionally left blank.
  }

  @Benchmark
  @Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1)
  @Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 1)
  public void batchSize1() {
    // this method was intentionally left blank.
  }

  @Benchmark
  @Warmup(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 2)
  @Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS, batchSize = 2)
  public void batchSize2() {
    // this method was intentionally left blank.
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(BatchSizeTest.class.getSimpleName())
        .forks(1)
        .build();

    new Runner(opt).run();
  }
}