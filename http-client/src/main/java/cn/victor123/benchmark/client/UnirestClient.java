package cn.victor123.benchmark.client;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import java.util.Map;
import java.util.Map.Entry;


public class UnirestClient extends AbstractClient {

  @Override
  public String getMethod(String accessUrl, Map<String, String> headerMap) throws Exception {
    GetRequest getRequest = Unirest.get(accessUrl);
    if (headerMap != null) {
      for (Entry<String, String> stringStringEntry : headerMap.entrySet()) {
        getRequest.header(stringStringEntry.getKey(), stringStringEntry.getValue());
      }
    }
    HttpResponse<String> response = getRequest
        .asString();
    String body = response.getBody();
    return body;
  }
}
