package cn.victor123.benchmark.read.impl;

import cn.victor123.benchmark.read.FileReader;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelReader implements FileReader {

  @Override
  public int read(String path, int bufferSize) throws Exception {
    RandomAccessFile file = new RandomAccessFile(path, "r");
    FileChannel channel = file.getChannel();
    ByteBuffer buff = ByteBuffer.allocateDirect(bufferSize);
    int position = 0;
    int read;
    do {
      read = channel.read(buff);
      if (read > 0) {
        position += read;
      }
//      buff.flip();
//      while (buff.hasRemaining()) {
//        byte b = buff.get();
//        System.out.print(b);
//      }
//      System.out.println();
      buff.clear();
    } while (read > 0);
    channel.close();
    return position;
  }
}
