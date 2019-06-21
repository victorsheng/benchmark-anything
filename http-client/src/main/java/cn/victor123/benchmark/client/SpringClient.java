package cn.victor123.benchmark.client;

import cn.victor123.benchmark.constant.Constant;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

public class SpringClient extends AbstractClient {


  RestTemplate restTemplate = new RestTemplate();
  
  @Override
  public String getMethod(Map<String, String> headerMap) throws Exception {
    String result = restTemplate.getForObject(Constant.LOCALHOST_GET_URL, String.class);
    return result;
  }
}
