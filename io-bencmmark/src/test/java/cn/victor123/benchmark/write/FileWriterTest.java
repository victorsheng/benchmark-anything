package cn.victor123.benchmark.write;

import cn.victor123.benchmark.write.impl.BufferedOutPutFileWriter;
import cn.victor123.benchmark.write.impl.FileChannelFileWriter;
import cn.victor123.benchmark.write.impl.MmapFileWriter;
import cn.victor123.benchmark.write.impl.OutPutFileWriter;
import cn.victor123.benchmark.write.impl.RandomAccessFileWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;

public class FileWriterTest {


  @Test
  public void test1() throws Exception {
    ArrayList<FileWriter> implList = getImplList();
    int fileSize = 1024 * 1024 * 1000;
    int bufferSize = 1024 * 4 * 8;
    System.out.println("size:" + fileSize / 1024 / 1024 + "M");
    for (FileWriter fileWriter : implList) {
      File tmp = File.createTempFile("file-writer", "tmp");
      tmp.deleteOnExit();
      String path = tmp.getAbsolutePath();
      long date = new Date().getTime();
      fileWriter.write(fileSize, bufferSize, path);
      long length = tmp.length();
      long date2 = new Date().getTime();
      System.out
          .println("class:" + fileWriter.getClass() + ",size:" + length + ":" + (date2 - date));
      tmp.delete();
    }
  }


  private ArrayList<FileWriter> getImplList() {
    ArrayList<FileWriter> list = new ArrayList<>();
    list.add(new OutPutFileWriter());
    list.add(new BufferedOutPutFileWriter());
    list.add(new FileChannelFileWriter());
    list.add(new MmapFileWriter());
    list.add(new RandomAccessFileWriter());
    return list;
  }
}
