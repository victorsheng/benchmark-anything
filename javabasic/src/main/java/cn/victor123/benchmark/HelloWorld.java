package cn.victor123.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * 最简单的JMH例子
 */
public class HelloWorld {

  @Benchmark
  public void wellHelloThere() {
    // this method was intentionally left blank.
    System.out.println("Hello World.");
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(HelloWorld.class.getSimpleName())
        .forks(1)
        .build();

    new Runner(opt).run();
  }
}