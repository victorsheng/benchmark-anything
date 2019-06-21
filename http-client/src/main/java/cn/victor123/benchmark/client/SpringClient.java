package cn.victor123.benchmark.client;

import java.util.Map;
import org.springframework.web.client.RestTemplate;

public class SpringClient extends AbstractClient {


  RestTemplate restTemplate = new RestTemplate();

  @Override
  public String getMethod(String accessUrl, Map<String, String> headerMap) throws Exception {
    String result = restTemplate.getForObject(accessUrl, String.class);
    return result;
  }
}
