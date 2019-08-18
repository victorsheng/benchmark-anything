package cn.victor123.benchmark.write.impl;

import cn.victor123.benchmark.write.FileWriter;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class BufferedOutPutFileWriter implements FileWriter {


  @Override
  public void write(int fileSize, int bufferSize, String dstPath) throws Exception {
    BufferedOutputStream fo = new BufferedOutputStream(
        new FileOutputStream(dstPath));
    byte[] arr = new byte[bufferSize];
    Arrays.fill(arr, (byte) 2);
    int length = 0;
    while (length < fileSize) {
      length += arr.length;
      fo.write(arr);
    }
    fo.close();
  }
}
