package cn.victor123.benchmark.write.impl;

import cn.victor123.benchmark.write.FileWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class OneMmapFileWriter implements FileWriter {

  @Override
  public void write(int fileSize, int bufferSize, String dstPath) throws Exception {
    RandomAccessFile file = new RandomAccessFile(dstPath, "rw");
    int position = 0;
    MappedByteBuffer mb = file.getChannel().
        map(FileChannel.MapMode.READ_WRITE, position, fileSize);
    while (position < fileSize) {
      byte[] arr = new byte[bufferSize];
      Arrays.fill(arr, (byte) 2);
      position += arr.length;
      mb.put(arr);
//      mb.force();
    }
    file.close();

  }
}
