package cn.victor123.benchmark.benchmark;


import cn.victor123.benchmark.constant.Constant;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;


public class ClientBenchMarkGET  extends ClientBenchMark {

  @Benchmark
  public void get_return_now(Blackhole bh) throws Exception {
    bh.consume(abstractClient.getMethod(Constant.i.getNow_url(), headerMap));
  }

  @Benchmark
  public void get_return_sleep5ms(Blackhole bh) throws Exception {
    bh.consume(abstractClient.getMethod(Constant.i.getSleep5_url(), headerMap));
  }



}
