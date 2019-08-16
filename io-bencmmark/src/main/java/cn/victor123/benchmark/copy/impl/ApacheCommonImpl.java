package cn.victor123.benchmark.copy.impl;

import cn.victor123.benchmark.copy.StreamConvert;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

public class ApacheCommonImpl implements StreamConvert {

  public void copy(InputStream in, FileOutputStream ou, int bufferSize) {
    try {
      IOUtils.copy(in, ou);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
