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
import org.openjdk.jmh.runner.options.TimeValue;

public class ServerMain {


  public static void main(String[] args) throws RunnerException {

    //本地配置
    Constant.i = new Constant("localhost", "3000", "");

    long s = System.currentTimeMillis();
    Options opt = new OptionsBuilder()
        .include(ClientBenchMark.class.getSimpleName())
        .measurementTime(TimeValue.seconds(5))
        .measurementIterations(5)
        .warmupTime(TimeValue.seconds(5))
        .warmupIterations(5)
        .resultFormat(ResultFormatType.JSON)
        .addProfiler(GCProfiler.class)
        .addProfiler(StackProfiler.class)
        .addProfiler(PausesProfiler.class)
        .jvmArgsAppend()
        .result(s + "-result.csv")
        .forks(2)
        .build();

    new Runner(opt).run();
  }

}
