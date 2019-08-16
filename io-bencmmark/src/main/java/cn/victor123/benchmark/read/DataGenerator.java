package cn.victor123.benchmark.read;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class DataGenerator {

  public static String gen(int size) throws IOException {
    File file = File.createTempFile("mock-data", ".tmp");
    FileOutputStream fo = new FileOutputStream(file);
    byte[] arr = new byte[size];
    Arrays.fill(arr, (byte) 2);
    fo.write(arr);
    file.deleteOnExit();
    return file.getAbsolutePath();
  }

}
