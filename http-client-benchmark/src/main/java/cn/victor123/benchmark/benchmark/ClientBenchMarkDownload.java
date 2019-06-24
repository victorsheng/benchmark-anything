package cn.victor123.benchmark.benchmark;


import cn.victor123.benchmark.constant.Constant;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;


public class ClientBenchMarkDownload extends ClientBenchMark {

  @Benchmark
  public void download_small(Blackhole bh) throws Exception {
    bh.consume(abstractClient.getMethod(Constant.i.getDownload_small_url(), headerMap));
  }

  @Benchmark
  public void download_mid(Blackhole bh) throws Exception {
    bh.consume(abstractClient.getMethod(Constant.i.getDownload_mid_url(), headerMap));
  }

  @Benchmark
  public void download_large(Blackhole bh) throws Exception {
    bh.consume(abstractClient.getMethod(Constant.i.getDownload_large_url(), headerMap));
  }


}
