package cn.victor123.benchmark.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * copy from : https://www.jianshu.com/p/545f3a109964
 */
public class HttpUtil {

  /**
   * 上传文件
   *
   * @param actionURL 上次的目标路径地址
   * @param filePaths 上传的文件路径数组
   * @return 服务器响应数据
   */
  public static String uploadFile(String actionURL, String[] filePaths) {

    String towHyphens = "--";   // 定义连接字符串
    String boundary = "******"; // 定义分界线字符串
    String end = "\r\n";    //定义结束换行字符串
    try {
      // 创建URL对象
      URL url = new URL(actionURL);
      // 获取连接对象
      URLConnection urlConnection = url.openConnection();
      // 设置允许输入流输入数据到本机
      urlConnection.setDoOutput(true);
      // 设置允许输出流输出数据到服务器
      urlConnection.setDoInput(true);
      // 设置不使用缓存
      urlConnection.setUseCaches(false);
      // 设置请求参数中的内容类型为multipart/form-data,设置请求内容的分割线为******
      urlConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);

      // 从连接对象中获取输出流
      OutputStream outputStream = urlConnection.getOutputStream();
      // 实例化数据输出流对象，将输出流传入
      DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

      // 遍历文件路径的长度,将路径数组下所有路径的文件都写到输出流中
      for (int i = 0; i < filePaths.length; i++) {
        // 取出文件路径
        String filePath = filePaths[i];
        // 获取文件名称
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
        // 向数据输出流中写出分割符
        dataOutputStream.writeBytes(towHyphens + boundary + end);
        // 向数据输出流中写出文件参数名与文件名
        dataOutputStream
            .writeBytes("Content-Disposition:form-data;name=file;filename=" + fileName + end);
        // 向数据输出流中写出结束标志
        dataOutputStream.writeBytes(end);

        // 实例化文件输入流对象，将文件路径传入，用于将磁盘上的文件读入到内存中
        FileInputStream fileInputStream = new FileInputStream(filePath);
        // 定义缓冲区大小
        int bufferSize = 1024;
        // 定义字节数组对象，用来读取缓冲区数据
        byte[] buffer = new byte[bufferSize];
        // 定义一个整形变量，用来存放当前读取到的文件长度
        int length;
        // 循环从文件输出流中读取1024字节的数据，将每次读取的长度赋值给length变量，直到文件读取完毕，值为-1结束循环
        while ((length = fileInputStream.read(buffer)) != -1) {
          // 向数据输出流中写出数据
          dataOutputStream.write(buffer, 0, length);
        }
        // 每写出完成一个完整的文件流后，需要向数据输出流中写出结束标志符
        dataOutputStream.writeBytes(end);
        // 关闭文件输入流
        fileInputStream.close();

      }
      // 向数据输出流中写出分隔符
      dataOutputStream.writeBytes(towHyphens + boundary + towHyphens + end);
      // 刷新数据输出流
      dataOutputStream.flush();

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

      // 依次关闭打开的输入流
      bufferedReader.close();
      inputStreamReader.close();
      inputStream.close();

      // 依次关闭打开的输出流
      dataOutputStream.close();
      outputStream.close();

      // 返回服务器响应的数据
      return stringBuilder.toString();

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


  /**
   * 下载文件
   *
   * @param urlAddress 文件url地址
   * @param downloadDir 文件保存的目录
   * @return 文件
   */
  public static File downloadFile(String urlAddress, String downloadDir) {

    try {
      // 创建URL对象
      URL url = new URL(urlAddress);
      // 获取连接对象
      URLConnection urlConnection = url.openConnection();
      // 设置允许输入流输入数据到本地
      urlConnection.setDoInput(true);
      // 设置允许输出流输出到服务器
      urlConnection.setDoOutput(true);
      // 获取内容长度
      int fileLength = urlConnection.getContentLength();
      // 获取文件url径名称
      String filePathName = urlConnection.getURL().getFile();
      // 获取文件名称
      String fileName = filePathName.substring(filePathName.lastIndexOf(File.separatorChar) + 1);

      // 定义文件下载的目录与名称
      String path = downloadDir + File.separatorChar + fileName;

      // 实例化文件对象
      File file = new File(path);

      // 判断文件路径是否存在
      if (!file.getParentFile().exists()) {
        // 如果文件不存在就创建文件
        file.getParentFile().mkdirs();
      }

      // 从连接对象中获取输入字节流
      InputStream inputStream = urlConnection.getInputStream();

      // 实例化输入流缓冲区，将输入字节流传入
      BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

      // 实例化输出流对象，将文件对象传入
      OutputStream outputStream = new FileOutputStream(file);

      // 定义整形变量用来接收读取到的文件大小
      int size;
      // 定义整形变量用来累计当前读取到的文件长度
      int len = 0;
      // 定义字节数组对象，用来从输入缓冲区中装载数据块
      byte[] buf = new byte[1024];
      // 从输入缓冲区中一次读取1024个字节的文件内容到buf对象中，并将读取大小赋值给size变量，当读取完毕后size=-1，结束循环读取
      while ((size = bufferedInputStream.read(buf)) != -1) {
        // 累加每次读取到的文件大小
        len += size;
        // 向输出流中写出数据
        outputStream.write(buf, 0, size);
        // 打印当前文件下载的百分比
        System.out.println("下载进度：" + len * 100 / fileLength + "%\n");
      }
      // 关闭输出流
      outputStream.close();
      // 关闭输入缓冲区
      bufferedInputStream.close();
      // 关闭输入流
      inputStream.close();

      // 返回文件对象
      return file;

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
