package cn.victor123.benchmark.demo;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Timeout;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * 默认10次迭代
 *
 * timeout不好使 -to <time> Timeout for benchmark iteration. After reaching this timeout, JMH
 * will try to interrupt the running tasks. Non-cooperating benchmarks may ignore this timeout.
 * (default: 10 min) 超时了会interrupt,如果不配合那么久没有用
 *
 * 怀疑是bug:https://stackoverflow.com/questions/50003967/jmh-timeout-doesnt-interrupt
 */
public class TimeOutTest {


  @Benchmark
  @Warmup(iterations = 0, time = 1, timeUnit = TimeUnit.SECONDS)
  @Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
  public void sleep2ms() throws InterruptedException {
    TimeUnit.MILLISECONDS.sleep(2);
    // this method was intentionally left blank.
  }


  @Benchmark
  @Warmup(iterations = 0, time = 1, timeUnit = TimeUnit.SECONDS)
  @Timeout(time = 1, timeUnit = TimeUnit.SECONDS)
  @Measurement(iterations = 1, time = 1, timeUnit = TimeUnit.SECONDS)
  public void sleep4sTimeout2s() throws InterruptedException {
    TimeUnit.SECONDS.sleep(4);
    // this method was intentionally left blank.
  }



  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
        .include(TimeOutTest.class.getSimpleName())
        .forks(1)
        .build();

    new Runner(opt).run();
  }
}