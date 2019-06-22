package cn.victor123.benchmark.client;

import cn.victor123.benchmark.util.HttpUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

public class JdkHttpClient extends AbstractClient {


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

    // 从连接对象中获取字节输入流
    InputStream inputStream = urlConnection.getInputStream();
    // 实例化字符输入流对象，将字节流包装成字符流
    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
    // 创建一个输入缓冲区对象，将要输入的字符流对象传入
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

    // 创建一个字符串对象，用来接收每次从输入缓冲区中读入的字符串
    String line;
    // 创建一个可变字符串对象，用来装载缓冲区对象的最终数据，使用字符串追加的方式，将响应的所有数据都保存在该对象中
    StringBuilder stringBuilder = new StringBuilder();
    // 使用循环逐行读取缓冲区的数据，每次循环读入一行字符串数据赋值给line字符串变量，直到读取的行为空时标识内容读取结束循环
    while ((line = bufferedReader.readLine()) != null) {
      // 将缓冲区读取到的数据追加到可变字符对象中
      stringBuilder.append(line);
    }
    return stringBuilder.toString();
  }

  @Override
  public String postMethod(String accessUrl, Map<String, String> headerMap, File file)
      throws Exception {
    return HttpUtil.uploadFile(accessUrl, new String[]{file.getAbsolutePath()});
  }
}
