package cn.victor123.benchmark;

import java.io.FileOutputStream;
import java.io.InputStream;

public interface StreamConvert {

  public void copy(InputStream in, FileOutputStream ou, int bufferSize);

}
