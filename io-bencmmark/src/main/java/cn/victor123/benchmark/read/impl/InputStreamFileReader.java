package cn.victor123.benchmark.read.impl;

import cn.victor123.benchmark.read.FileReader;
import java.io.FileInputStream;

public class InputStreamFileReader implements FileReader {


  @Override
  public int read(String path, int bufferSize) throws Exception {
    FileInputStream fs = new FileInputStream(path);
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
