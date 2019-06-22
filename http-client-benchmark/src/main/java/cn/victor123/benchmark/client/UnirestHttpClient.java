package cn.victor123.benchmark.client;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import java.io.File;
import java.util.Map;
import java.util.Map.Entry;


public class UnirestHttpClient extends AbstractClient {

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

  @Override
  public String postMethod(String accessUrl, Map<String, String> headerMap, File file)
      throws Exception {

    HttpResponse<String> response = Unirest.post(accessUrl)
        .field("file", new File(file.getAbsolutePath()))
        .asString();
    String body = response.getBody();
    return body;
  }
}
