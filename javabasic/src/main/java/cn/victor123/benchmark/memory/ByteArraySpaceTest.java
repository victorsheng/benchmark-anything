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

@Fork(value = 1,jvmArgs =("-XX:-UseCompressedOops"))
//@Fork(value = 1,jvmArgsAppend = "-XX:+UseCompressedOops")
@Warmup(iterations = 1)
@Measurement(iterations = 1)
public class ByteArraySpaceTest {

  @Benchmark
  public void test(Blackhole bh) {
    byte[] bytes = new byte[0];
    bh.consume(bytes);
  }

  @Benchmark
  public void test2(Blackhole bh) {
    byte[] bytes = new byte[1];
    bh.consume(bytes);
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(ByteArraySpaceTest.class.getSimpleName())
        .addProfiler(GCProfiler.class)
        .build();
    new Runner(opt).run();
  }

  /**
   +UseCompressedOops或者默认
   Benchmark                                       Mode  Cnt          Score          Error   Units
   ByteArraySpaceTest.test                                    thrpt   20  272714096.966 ±  3569342.444   ops/s
   ByteArraySpaceTest.test:·gc.alloc.rate                     thrpt   20       2771.045 ±       36.716  MB/sec
   ByteArraySpaceTest.test:·gc.alloc.rate.norm                thrpt   20         16.000 ±        0.001    B/op
   ByteArraySpaceTest.test:·gc.churn.PS_Eden_Space            thrpt   20       2770.939 ±      100.563  MB/sec
   ByteArraySpaceTest.test:·gc.churn.PS_Eden_Space.norm       thrpt   20         15.999 ±        0.543    B/op
   ByteArraySpaceTest.test:·gc.churn.PS_Survivor_Space        thrpt   20          0.126 ±        0.041  MB/sec
   ByteArraySpaceTest.test:·gc.churn.PS_Survivor_Space.norm   thrpt   20          0.001 ±        0.001    B/op
   ByteArraySpaceTest.test:·gc.count                          thrpt   20        295.000                 counts
   ByteArraySpaceTest.test:·gc.time                           thrpt   20        187.000                     ms
   ByteArraySpaceTest.test2                                   thrpt   20  242135157.077 ± 19593901.659   ops/s
   ByteArraySpaceTest.test2:·gc.alloc.rate                    thrpt   20       3689.736 ±      297.792  MB/sec
   ByteArraySpaceTest.test2:·gc.alloc.rate.norm               thrpt   20         24.000 ±        0.001    B/op
   ByteArraySpaceTest.test2:·gc.churn.PS_Eden_Space           thrpt   20       3695.510 ±      339.487  MB/sec
   ByteArraySpaceTest.test2:·gc.churn.PS_Eden_Space.norm      thrpt   20         24.036 ±        1.106    B/op
   ByteArraySpaceTest.test2:·gc.churn.PS_Survivor_Space       thrpt   20          0.106 ±        0.029  MB/sec
   ByteArraySpaceTest.test2:·gc.churn.PS_Survivor_Space.norm  thrpt   20          0.001 ±        0.001    B/op
   ByteArraySpaceTest.test2:·gc.count                         thrpt   20        282.000                 counts
   ByteArraySpaceTest.test2:·gc.time                          thrpt   20        188.000                     ms

   -UseCompressedOops
   Benchmark                                         Mode  Cnt          Score   Error   Units
   ByteArraySpaceTest.test                                    thrpt       102302399.576           ops/s
   ByteArraySpaceTest.test:·gc.alloc.rate                     thrpt            1558.375          MB/sec
   ByteArraySpaceTest.test:·gc.alloc.rate.norm                thrpt              24.000            B/op
   ByteArraySpaceTest.test:·gc.churn.PS_Eden_Space            thrpt            1089.544          MB/sec
   ByteArraySpaceTest.test:·gc.churn.PS_Eden_Space.norm       thrpt              16.780            B/op
   ByteArraySpaceTest.test:·gc.churn.PS_Survivor_Space        thrpt               0.146          MB/sec
   ByteArraySpaceTest.test:·gc.churn.PS_Survivor_Space.norm   thrpt               0.002            B/op
   ByteArraySpaceTest.test:·gc.count                          thrpt               2.000          counts
   ByteArraySpaceTest.test:·gc.time                           thrpt               2.000              ms
   ByteArraySpaceTest.test2                                   thrpt       134707091.967           ops/s
   ByteArraySpaceTest.test2:·gc.alloc.rate                    thrpt            2735.910          MB/sec
   ByteArraySpaceTest.test2:·gc.alloc.rate.norm               thrpt              32.000            B/op
   ByteArraySpaceTest.test2:·gc.churn.PS_Eden_Space           thrpt            2277.638          MB/sec
   ByteArraySpaceTest.test2:·gc.churn.PS_Eden_Space.norm      thrpt              26.640            B/op
   ByteArraySpaceTest.test2:·gc.churn.PS_Survivor_Space       thrpt               0.166          MB/sec
   ByteArraySpaceTest.test2:·gc.churn.PS_Survivor_Space.norm  thrpt               0.002            B/op
   ByteArraySpaceTest.test2:·gc.count                         thrpt               3.000          counts
   ByteArraySpaceTest.test2:·gc.time                          thrpt               2.000              ms
   */
}
