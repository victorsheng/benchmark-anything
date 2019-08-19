package cn.victor123.benchmark.read.impl;

import cn.victor123.benchmark.read.FileReader;
import java.io.RandomAccessFile;

public class RandomAccessFileReader implements FileReader {

  @Override
  public int read(String path, int bufferSize) throws Exception {
    RandomAccessFile file = new RandomAccessFile(path, "r");
    long s = System.currentTimeMillis();
    int position = 0;
    byte[] arr = new byte[bufferSize];
    while (true) {
      int len = file.read(arr);
      if (len == -1) {
        break;
      }
      position += len;
    }
    return position;
  }
}
