package cn.victor123.benchmark.client;

import cn.victor123.benchmark.constant.Constant;
import java.net.HttpURLConnection;
import java.net.URL;

public class JdkClientClient extends AbstractClient {


  @Override
  public String getMethod(String url) throws Exception {
    URL getUrl = new URL(Constant.LOCALHOST_GET_URL);
    HttpURLConnection urlConnection = (HttpURLConnection) getUrl.openConnection();
    urlConnection.setRequestMethod("GET");// 设置请求方法
    String responseMessage = urlConnection.getResponseMessage();
    return responseMessage;
  }
}
