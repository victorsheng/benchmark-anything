package cn.victor123.benchmark.write.impl;

import cn.victor123.benchmark.write.FileWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class FileChannelFileWriter implements FileWriter {

  @Override
  public void write(int fileSize, int bufferSize, String dstPath) throws Exception {
    RandomAccessFile file = new RandomAccessFile(dstPath, "rw");
    int position = 0;
    FileChannel channel = file.getChannel();
    while (position < fileSize) {
      byte[] arr = new byte[bufferSize];
      Arrays.fill(arr, (byte) 2);
      position += arr.length;
      channel.write(ByteBuffer.wrap(arr));
    }
//    channel.force(true);
    file.close();
  }
}
