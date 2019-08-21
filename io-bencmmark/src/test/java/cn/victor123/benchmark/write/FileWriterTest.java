package cn.victor123.benchmark.write;

import cn.victor123.benchmark.write.impl.BufferedOutPutFileWriter;
import cn.victor123.benchmark.write.impl.DirectBufferFileChannelFileWriter;
import cn.victor123.benchmark.write.impl.InDirectBufferFileChannelFileWriter;
import cn.victor123.benchmark.write.impl.MultiMmapFileWriter;
import cn.victor123.benchmark.write.impl.OneMmapFileWriter;
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
    int bufferSize = 1024*16;
    System.out.println("file size:" + fileSize / 1024 / 1024 + "MB");
    System.out.println("buffer size:" + bufferSize + "B");
    for (FileWriter fileWriter : implList) {
      File tmp = File.createTempFile("file-writer", "tmp");
      tmp.deleteOnExit();
      String path = tmp.getAbsolutePath();
      long date = new Date().getTime();
      fileWriter.write(fileSize, bufferSize, path);
      long length = tmp.length();
      long date2 = new Date().getTime();
      System.out
          .println(fileWriter.getClass().getSimpleName() + "," + length + "," + (date2 - date));
      tmp.delete();
    }
  }


  private ArrayList<FileWriter> getImplList() {
    ArrayList<FileWriter> list = new ArrayList<>();
    list.add(new OutPutFileWriter());
    list.add(new BufferedOutPutFileWriter());
    list.add(new InDirectBufferFileChannelFileWriter());
    list.add(new DirectBufferFileChannelFileWriter());
    list.add(new OneMmapFileWriter());
    list.add(new MultiMmapFileWriter());
    list.add(new RandomAccessFileWriter());
    return list;
  }
}
