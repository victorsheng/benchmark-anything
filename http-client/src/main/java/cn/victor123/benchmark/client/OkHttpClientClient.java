package cn.victor123.benchmark.client;

import cn.victor123.benchmark.constant.Constant;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;


public class OkHttpClientClient extends AbstractClient {

  private OkHttpClient client = new OkHttpClient();


  @Override
  public String getMethod(Map<String, String> headerMap) throws Exception {
    Builder url = new Builder()
        .url(Constant.LOCALHOST_GET_URL);

    if (headerMap != null) {
      for (Entry<String, String> stringStringEntry : headerMap.entrySet()) {
        url.addHeader(stringStringEntry.getKey(), stringStringEntry.getValue());
      }
    }

    Request request = url
        .get()
        .build();

    Response response = client.newCall(request).execute();
    String string = response.body().string();
    return string;
  }
}
