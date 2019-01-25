package cn.victor123.benchmark.multithread;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class MultiThreadTest {

  @Threads(1)
  @Benchmark
  public void run1(){

  }

  @Threads(2)
  @Benchmark
  public void run2(){

  }

  @Threads(4)
  @Benchmark
  public void run4(){

  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(MultiThreadTest.class.getSimpleName())
        .forks(1)
        .build();

    new Runner(opt).run();
  }
}
