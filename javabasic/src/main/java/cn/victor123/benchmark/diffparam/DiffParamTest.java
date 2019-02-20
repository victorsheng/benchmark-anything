package cn.victor123.benchmark.diffparam;

import java.math.BigInteger;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@Fork(1)
@State(Scope.Benchmark)
public class DiffParamTest {

  private int[] array;

  @Param({"same", "diff"})
  private String type;

  @Setup
  public void init() {
    array = new int[100];
    if ("same".equals(type)) {
      for (int i = 0; i < 100; i++) {
        array[i] = 1;
      }
    } else {
      for (int i = 0; i < 100; i++) {
        array[i] = i;
      }
    }
  }

  @Benchmark
  public void test(Blackhole bh) {
    for (int i : array) {
      bh.consume(new BigInteger("" + i));
    }
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(DiffParamTest.class.getSimpleName())
        .threads(Runtime.getRuntime().availableProcessors())
        .build();

    new Runner(opt).run();
  }


}
