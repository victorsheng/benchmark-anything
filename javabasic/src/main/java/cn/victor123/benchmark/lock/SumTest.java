package cn.victor123.benchmark.lock;

import java.util.concurrent.atomic.AtomicInteger;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;


@Fork(1)
@Warmup(iterations = 4)
@Measurement(iterations = 4)
public class SumTest {

  @State(Scope.Benchmark)
  public static class TestState {

    int i = 0;

    volatile int i1 = 0;

    int i2 = 0;

    Integer i3 = 0;

    volatile Integer i4 = 0;

    Integer i5 = 0;

    AtomicInteger i6 = new AtomicInteger(0);

    volatile AtomicInteger i7 = new AtomicInteger(0);

    final AtomicInteger i8 = new AtomicInteger(0);


    public synchronized void addI2() {
      i2 += 1;
    }

    public synchronized void addI5() {
      i5 += 1;
    }


    @TearDown
    public void finish() {
      final StringBuilder sb = new StringBuilder("TestState report{");
      sb.append("i=").append(i);
      sb.append(", i1=").append(i1);
      sb.append(", i2=").append(i2);
      sb.append(", i3=").append(i3);
      sb.append(", i4=").append(i4);
      sb.append(", i5=").append(i5);
      sb.append(", i6=").append(i6);
      sb.append(", i7=").append(i7);
      sb.append('}');
      System.out.println(sb);
    }

  }


  @Benchmark
  public void test(TestState t) {
    t.i += 1;
  }

  @Benchmark
  public void test1(TestState t) {
    t.i1 += 1;
  }

  @Benchmark
  public void test2(TestState t) {
    t.addI2();
  }

  @Benchmark
  public void test3(TestState t) {
    t.i3 += 1;
  }

  @Benchmark
  public void test4(TestState t) {
    t.i4 += 1;
  }

  @Benchmark
  public void test5(TestState t) {
    t.addI5();
  }

  @Benchmark
  public void test6(TestState t) {
    t.i6.incrementAndGet();
  }

  @Benchmark
  public void test7(TestState t) {
    t.i7.incrementAndGet();
  }

  @Benchmark
  public void test8(TestState t) {
    t.i8.incrementAndGet();
  }

  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(SumTest.class.getSimpleName())
        .build();

    new Runner(opt).run();
  }

  @Threads(2)
  public static class Thread2 extends SumTest {

  }

  @Threads(4)
  public static class Thread4 extends SumTest {

  }

  @Threads(8)
  public static class Thread8 extends SumTest {

  }

  @Threads(16)
  public static class Thread16 extends SumTest {

  }

  @Threads(32)
  public static class Thread32 extends SumTest {

  }

  @Threads(64)
  public static class Thread64 extends SumTest {

  }


}
