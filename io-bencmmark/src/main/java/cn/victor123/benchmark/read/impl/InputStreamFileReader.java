package cn.victor123.benchmark.read.impl;

import cn.victor123.benchmark.read.FileReader;
import java.io.FileInputStream;
import java.util.Arrays;

public class InputStreamFileReader implements FileReader {


  @Override
  public int read(String path, int bufferSize) throws Exception {
    FileInputStream fs = new FileInputStream(path);
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
    return position;
  }
}
