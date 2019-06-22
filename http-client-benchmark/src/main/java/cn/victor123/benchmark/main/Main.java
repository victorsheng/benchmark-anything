package cn.victor123.benchmark.main;

import cn.victor123.benchmark.benchmark.ClientBenchMark;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Main {


  public static void main(String[] args) throws RunnerException {
    long s = System.currentTimeMillis();
    Options opt = new OptionsBuilder()
//        .include(OkHttpClientt.class.getSimpleName())
//        .include(UnirestHttpClient.class.getSimpleName())
//        .include(JdkHttpClient.class.getSimpleName())
//        .include(ApacheHttpClient.class.getSimpleName())
        .include(ClientBenchMark.class.getSimpleName())
        .resultFormat(ResultFormatType.JSON)
        .result(s + "-result.csv")
        .forks(1)
        .build();

    new Runner(opt).run();
  }

}
