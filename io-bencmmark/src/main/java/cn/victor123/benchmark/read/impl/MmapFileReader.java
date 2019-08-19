package cn.victor123.benchmark.read.impl;

import cn.victor123.benchmark.read.FileReader;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MmapFileReader implements FileReader {

  @Override
  public int read(String path, int bufferSize) throws Exception {
    RandomAccessFile file = new RandomAccessFile(path, "r");
    long length = file.length();

    long time = length / bufferSize;
    int position = 0;
    byte[] arr = new byte[bufferSize];
    for (int i = 0; i < time; i++) {
      MappedByteBuffer mb = file.getChannel().
          map(FileChannel.MapMode.READ_ONLY, position, bufferSize);
      mb.get(arr, 0, bufferSize);
//      System.out.println(Arrays.toString(arr));
      position += bufferSize;
    }

    int reamin = (int) length % bufferSize;
    System.out.println("reamin:" + reamin);
    if (reamin != 0) {
      MappedByteBuffer mb = file.getChannel().
          map(FileChannel.MapMode.READ_ONLY, 0, reamin);
      byte[] arr2 = new byte[reamin];
      mb.get(arr2, 0, reamin);
      position += reamin;
    }
    return position;
  }
}
