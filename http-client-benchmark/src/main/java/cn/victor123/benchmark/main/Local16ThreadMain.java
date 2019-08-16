package cn.victor123.benchmark.main;

import cn.victor123.benchmark.benchmark.ClientBenchMark;
import cn.victor123.benchmark.constant.Constant;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Local16ThreadMain {


  public static void main(String[] args) throws RunnerException {

    //本地配置
    Constant.i = new Constant("localhost", "3000", "mock");
    long s = System.currentTimeMillis();
    Options opt = new OptionsBuilder()
        .include("ClientBenchMarkGET")
        .resultFormat(ResultFormatType.JSON)
        .result("result/" + s + "-result.csv")
        .forks(1)
        .threads(16)
        .build();

    new Runner(opt).run();
  }

}
