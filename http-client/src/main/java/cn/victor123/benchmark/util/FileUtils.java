package cn.victor123.benchmark.util;

import java.io.File;

public class FileUtils {

  public static File get() {
    return get("/Users/victor/tmp/dataset.csv");
  }


  public static File get(String path) {
    return new File(path);
  }

}
