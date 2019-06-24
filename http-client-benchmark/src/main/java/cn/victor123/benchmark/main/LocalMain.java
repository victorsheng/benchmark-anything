package cn.victor123.benchmark.main;

import cn.victor123.benchmark.benchmark.ClientBenchMark;
import cn.victor123.benchmark.constant.Constant;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.profile.PausesProfiler;
import org.openjdk.jmh.profile.StackProfiler;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class LocalMain {


  public static void main(String[] args) throws RunnerException {

    //本地配置
    Constant.i = new Constant("localhost", "3000", "mock");
    long s = System.currentTimeMillis();
    Options opt = new OptionsBuilder()
        .include(ClientBenchMark.class.getSimpleName())
        .resultFormat(ResultFormatType.JSON)
        .addProfiler(GCProfiler.class)
        .addProfiler(StackProfiler.class)
        .addProfiler(PausesProfiler.class)
        .result("result/" + s + "-result.csv")
        .forks(1)
        .build();

    new Runner(opt).run();
  }

}
