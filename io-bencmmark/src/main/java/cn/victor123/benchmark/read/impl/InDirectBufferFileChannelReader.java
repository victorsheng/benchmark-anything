package cn.victor123.benchmark.read.impl;

import cn.victor123.benchmark.read.FileReader;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class InDirectBufferFileChannelReader implements FileReader {

  @Override
  public int read(String path, int bufferSize) throws Exception {
    RandomAccessFile file = new RandomAccessFile(path, "r");
    FileChannel channel = file.getChannel();
    ByteBuffer buff = ByteBuffer.allocate(bufferSize);
    int position = 0;
    int read;
    while (true){
      read = channel.read(buff);
      if (read == -1) {
        break;
      }
      position += read;
      buff.clear();
    }
    channel.close();
    return position;
  }
}
