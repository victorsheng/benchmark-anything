package cn.victor123.benchmark.client;

import cn.victor123.benchmark.constant.Constant;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

public class JdkClientClient extends AbstractClient {


  @Override
  public String getMethod(String accessUrl, Map<String, String> headerMap) throws Exception {
    URL getUrl = new URL(accessUrl);
    HttpURLConnection urlConnection = (HttpURLConnection) getUrl.openConnection();
    urlConnection.setRequestMethod("GET");// 设置请求方法

    if (headerMap != null) {
      for (Entry<String, String> stringStringEntry : headerMap.entrySet()) {
        urlConnection.setRequestProperty(stringStringEntry.getKey(), stringStringEntry.getValue());
      }
    }


    String responseMessage = urlConnection.getResponseMessage();
    return responseMessage;
  }
}
