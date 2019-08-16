package cn.victor123.benchmark.read.impl;

import cn.victor123.benchmark.read.FileReader;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class BufferedInputStreamFileReader implements FileReader {


  @Override
  public int read(String path, int bufferSize) throws Exception {
    InputStream fs = new BufferedInputStream(new FileInputStream(path), bufferSize);
    int position = 0;
    while (true) {
      byte[] arr = new byte[bufferSize];
      int len = fs.read(arr);
      if (len == -1) {
        break;
      }
      position += len;
    }
    return position;
  }
}
