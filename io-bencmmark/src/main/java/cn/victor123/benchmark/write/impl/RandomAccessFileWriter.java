package cn.victor123.benchmark.write.impl;

import cn.victor123.benchmark.write.FileWriter;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class RandomAccessFileWriter implements FileWriter {

  @Override
  public void write(int fileSize, int bufferSize, String dstPath) throws Exception {
    RandomAccessFile file = new RandomAccessFile(dstPath, "rw");
    byte[] arr = new byte[bufferSize];
    Arrays.fill(arr, (byte) 2);
    int length = 0;
    while (length < fileSize) {
      length += arr.length;
      file.write(arr);
    }
    file.close();
  }
}
