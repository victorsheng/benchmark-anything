package cn.victor123.benchmark.impl;

import cn.victor123.benchmark.StreamConvert;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class JdkChannelImpl implements StreamConvert {

  public void copy(InputStream in, FileOutputStream ou, int bufferSize) {
    ReadableByteChannel readableByteChannel = Channels.newChannel(in);
    try {
      ou.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
