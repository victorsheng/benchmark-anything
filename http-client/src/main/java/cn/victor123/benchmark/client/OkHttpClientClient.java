package cn.victor123.benchmark.client;

import cn.victor123.benchmark.constant.Constant;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class OkHttpClientClient extends AbstractClient {

  private OkHttpClient client = new OkHttpClient();


  @Override
  public String getMethod(String url) throws Exception {
    Request request = new Request.Builder()
        .url(Constant.LOCALHOST_GET_URL)
        .get()
        .build();

    Response response = client.newCall(request).execute();
    String string = response.body().string();
    return string;
  }
}
