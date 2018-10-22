package cn.victor123.benchmark;

import java.time.Instant;
import java.util.Date;
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
public class TimeGenerate {


  @Benchmark
  public long date0() {
    return System.currentTimeMillis() / 1000;
  }

  @Benchmark
  public long date() {
    return new Date().getTime() / 1000;
  }

  @Benchmark
  public long date2() {
    return Instant.now().getEpochSecond();
  }

  public void base() {
    TimeGenerate t = new TimeGenerate();
    System.out.println(t.date());
    System.out.println(t.date2());
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(TimeGenerate.class.getSimpleName())
        .warmupIterations(5)
        .measurementIterations(5)
        .forks(1)
        .build();

    new Runner(opt).run();
  }
}


