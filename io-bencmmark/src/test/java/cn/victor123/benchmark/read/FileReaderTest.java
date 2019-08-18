package cn.victor123.benchmark.read;

import cn.victor123.benchmark.read.impl.BufferedInputStreamFileReader;
import cn.victor123.benchmark.read.impl.FileChannelReader;
import cn.victor123.benchmark.read.impl.InputStreamFileReader;
import cn.victor123.benchmark.read.impl.MmapFileReader;
import cn.victor123.benchmark.read.impl.RandomAccessFileReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;

public class FileReaderTest {

  private String input = "/Users/victor/code/vicProjects/benchmark-anything/README.md";
//  private String input = "/Users/victor/Downloads/abc.txt";
  ;

  @Test
  public void test() throws Exception {
    ArrayList<FileReader> list = new ArrayList<>();
//    list.add(new FileChannelReader());
    list.add(new InputStreamFileReader());
//    list.add(new MmapFileReader());
    list.add(new BufferedInputStreamFileReader());
    for (FileReader fileReader : list) {
      int read = fileReader.read(input, 10);
      System.out.println(fileReader.getClass() + ":" + read);
    }
  }

  @Test
  public void test2() throws Exception {
    ArrayList<FileReader> list = getImplList();
    for (FileReader fileReader : list) {
      String gen = DataGenerator.gen2(1024 * 1024 * 1000);
      long date = new Date().getTime();
      int read = fileReader.read(gen, 1024 * 4 * 8);
      long date2 = new Date().getTime();

      System.out.println(fileReader.getClass() + ":" + read + ":" + (date2 - date));
    }
  }

  private ArrayList<FileReader> getImplList() {
    ArrayList<FileReader> list = new ArrayList<>();
    list.add(new InputStreamFileReader());
    list.add(new BufferedInputStreamFileReader());
    list.add(new FileChannelReader());
    list.add(new MmapFileReader());
    list.add(new RandomAccessFileReader());
    return list;
  }


  @Test
  public void test3() throws Exception {
    ArrayList<FileReader> list = getImplList();
    for (FileReader fileReader : list) {
      long date = new Date().getTime();
      int read = fileReader.read(input, 1024);
      long date2 = new Date().getTime();

      System.out.println(fileReader.getClass() + ":" + read + ":" + (date2 - date));
    }
  }


  @Test
  public void test0() throws Exception {
    RandomAccessFile randomAccessFile = new RandomAccessFile(input, "rw");
    long length = randomAccessFile.length();
    System.out.println(length);

    FileInputStream fileInputStream = new FileInputStream(input);
    long size = fileInputStream.getChannel().size();
    System.out.println(size);

    File file = new File(input);
    System.out.println(file.length());

  }

}