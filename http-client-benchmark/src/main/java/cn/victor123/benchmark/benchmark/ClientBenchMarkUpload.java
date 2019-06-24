package cn.victor123.benchmark.benchmark;


import cn.victor123.benchmark.constant.Constant;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;


public class ClientBenchMarkUpload extends ClientBenchMark {


  @Benchmark
  public void post_upload_210KB(Blackhole bh) throws Exception {
    bh.consume(abstractClient.postMethod(Constant.i.getUpload_url(), headerMap, smallFile));
  }


  @Benchmark
  public void post_upload_420KB(Blackhole bh) throws Exception {
    bh.consume(abstractClient.postMethod(Constant.i.getUpload_url(), headerMap, largeFile));
  }


}
