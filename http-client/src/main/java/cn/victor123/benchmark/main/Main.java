package cn.victor123.benchmark.main;

import cn.victor123.benchmark.benchmark.ClientBenchMark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Main {


  public static void main(String[] args) throws RunnerException {
    Options opt = new OptionsBuilder()
//        .include(OkHttpClientt.class.getSimpleName())
//        .include(UnirestHttpClient.class.getSimpleName())
//        .include(JdkHttpClient.class.getSimpleName())
//        .include(ApacheHttpClient.class.getSimpleName())
        .include(ClientBenchMark.class.getSimpleName())
        .forks(1)
        .build();

    new Runner(opt).run();
  }

}
