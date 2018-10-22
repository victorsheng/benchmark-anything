package cn.victor123.benchmark;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)

public class Integerquals {

  @Benchmark
  public boolean test1() {
    Integer b1 = 400;
    int b2 = 400;
    return b1 == b2;
  }

  @Benchmark
  public boolean test2() {
    Integer b1 = 400;
    int b2 = 400;
    return b1.equals(b2);
  }


  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(Integerquals.class.getSimpleName())
        .forks(1)
        .build();

    new Runner(opt).run();
  }

  public static void main2(String[] args) {
    Integer b1 = 400;
    int b2 = 400;
    System.out.println(b1 == b2);
    System.out.println(b1.equals(b2));
  }


}
