package cn.victor123.benchmark.FalseSharing;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Group;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * 伪共享测试
 */
public class FalseSharingTest1 {

  @State(Scope.Group)
  public static class StateBaseline {

    long[] arrays = new long[24];
  }

  @Benchmark
  @Fork(1)
  @Group("conflict")
  public void w1(StateBaseline s, Blackhole bh) {

    bh.consume(s.arrays[2] += 1);
  }

  @Benchmark
  @Fork(1)
  @Group("conflict")
  public void w2(StateBaseline s, Blackhole bh) {
    bh.consume(s.arrays[1] += 1);
  }

  @Benchmark
  @Fork(1)
  @Group("noconflict")
  public void w3(StateBaseline s, Blackhole bh) {
    bh.consume(s.arrays[8] += 1);
  }


  @Benchmark
  @Fork(1)
  @Group("noconflict")
  public void w4(StateBaseline s, Blackhole bh) {
    bh.consume(s.arrays[15] += 1);
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(FalseSharingTest1.class.getSimpleName())
        .threads(Runtime.getRuntime().availableProcessors())
        .build();

    new Runner(opt).run();
  }

}
