package cn.victor123.benchmark.client;

import cn.victor123.benchmark.constant.Constant;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;


public class UnirestClient extends AbstractClient {

  @Override
  public String getMethod(String url) throws Exception {
    HttpResponse<String> response = Unirest.get(Constant.LOCALHOST_GET_URL)
        .asString();
    String body = response.getBody();
    return body;
  }
}
