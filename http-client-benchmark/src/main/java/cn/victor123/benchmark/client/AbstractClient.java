package cn.victor123.benchmark.client;

import java.io.File;
import java.util.Map;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;


@State(Scope.Benchmark)
public abstract class AbstractClient {

  public abstract String getMethod(String accessUrl, Map<String, String> headerMap)
      throws Exception;

  public abstract String postMethod(String accessUrl, Map<String, String> headerMap, File file)
      throws Exception;

}
