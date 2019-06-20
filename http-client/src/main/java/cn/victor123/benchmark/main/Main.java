package cn.victor123.benchmark.main;

import cn.victor123.benchmark.benchmark.ClientBenchMark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Main {


  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
//        .include(OkHttpClientClient.class.getSimpleName())
//        .include(UnirestClient.class.getSimpleName())
//        .include(JdkClientClient.class.getSimpleName())
//        .include(ApacheClientClient.class.getSimpleName())
        .include(ClientBenchMark.class.getSimpleName())
        .forks(1)
        .build();

    new Runner(opt).run();
  }

}
