package cn.victor123.benchmark.read.impl;

import cn.victor123.benchmark.read.FileReader;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;

public class BufferedInputStreamFileReader implements FileReader {


  @Override
  public int read(String path, int bufferSize) throws Exception {
    InputStream fs = new BufferedInputStream(new FileInputStream(path), bufferSize);
    int position = 0;
    byte[] arr = new byte[bufferSize];
    while (true) {
      int len = fs.read(arr);
      if (len == -1) {
        break;
      }
//      System.out.println(Arrays.toString(arr));
      position += len;
    }
    fs.close();
    return position;
  }
}
