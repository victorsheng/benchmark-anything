package cn.victor123.benchmark.lock;

import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@Fork(1)
@Threads(2)
@Warmup(iterations = 4)
@Measurement(iterations = 4)
public class SumTest2 extends SumTest {

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(SumTest2.class.getSimpleName())
        .build();

    new Runner(opt).run();
  }


}
