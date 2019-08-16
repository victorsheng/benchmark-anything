package cn.victor123.benchmark.copy.impl;

import cn.victor123.benchmark.copy.StreamConvert;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class JdkChannelImpl2 implements StreamConvert {

  public void copy(InputStream in, FileOutputStream ou, int bufferSize) {
    ReadableByteChannel readableByteChannel = Channels.newChannel(in);
    long size = 0;
    try {
      size = ((FileInputStream) in).getChannel().size();
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      long position = 0;
      long offsize;
      do {
        offsize = ou.getChannel().transferFrom(readableByteChannel, position, bufferSize);
        position += offsize;

      } while (position < size);
      System.out.println("position" + position);
      System.out.println("available" + size);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
