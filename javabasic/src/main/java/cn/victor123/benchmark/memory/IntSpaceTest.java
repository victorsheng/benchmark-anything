package cn.victor123.benchmark.memory;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

//@Fork(value = 1,jvmArgs =("-XX:-UseCompressedOops"))
@Fork(value = 1, jvmArgsAppend = "-XX:+UseCompressedOops")
@Warmup(iterations = 1)
@Measurement(iterations = 1)
public class IntSpaceTest {

  @Benchmark
  public void test(Blackhole bh) {
    int result = 0;
    bh.consume(result);
  }

  @Benchmark
  public void test2(Blackhole bh) {
    Integer result = new Integer(0);
    bh.consume(result);
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(IntSpaceTest.class.getSimpleName())
        .addProfiler(GCProfiler.class)
        .build();
    new Runner(opt).run();
  }

  /**
   * GCProfiler统计的是  堆内存申请的空间
   Benchmark                                             Mode  Cnt          Score   Error   Units
   IntSpaceTest.test                                    thrpt       379843062.150           ops/s
   IntSpaceTest.test:·gc.alloc.rate                     thrpt              ≈ 10⁻⁴          MB/sec
   IntSpaceTest.test:·gc.alloc.rate.norm                thrpt              ≈ 10⁻⁶            B/op
   IntSpaceTest.test:·gc.count                          thrpt                 ≈ 0          counts
   IntSpaceTest.test2                                   thrpt       140977816.281           ops/s
   IntSpaceTest.test2:·gc.alloc.rate                    thrpt            1432.332          MB/sec
   IntSpaceTest.test2:·gc.alloc.rate.norm               thrpt              16.000            B/op
   IntSpaceTest.test2:·gc.churn.PS_Eden_Space           thrpt            1086.472          MB/sec
   IntSpaceTest.test2:·gc.churn.PS_Eden_Space.norm      thrpt              12.137            B/op
   IntSpaceTest.test2:·gc.churn.PS_Survivor_Space       thrpt               0.166          MB/sec
   IntSpaceTest.test2:·gc.churn.PS_Survivor_Space.norm  thrpt               0.002            B/op
   IntSpaceTest.test2:·gc.count                         thrpt               2.000          counts
   IntSpaceTest.test2:·gc.time                          thrpt               3.000              ms
   */


}
