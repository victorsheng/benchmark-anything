package cn.victor123.benchmark.read.main;

import cn.victor123.benchmark.read.bm.ReadBenchMark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class ReadMain {

  public static void main(String[] args) throws RunnerException {

    Options opt = new OptionsBuilder()
        .include(ReadBenchMark.class.getSimpleName())
        .forks(1)
        .build();

    new Runner(opt).run();
  }

}
