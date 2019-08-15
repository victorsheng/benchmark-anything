package cn.victor123.benchmark.test;

import cn.victor123.benchmark.StreamConvert;
import cn.victor123.benchmark.impl.ApacheCommonImpl;
import cn.victor123.benchmark.impl.JdkChannelImpl;
import cn.victor123.benchmark.impl.JdkChannelImpl2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserCase {

  public static void main(String[] args) {
    ApacheCommonImpl apacheCommon = new ApacheCommonImpl();

    JdkChannelImpl jdkChannel = new JdkChannelImpl();
    JdkChannelImpl2 jdkChannel2 = new JdkChannelImpl2();

    List<StreamConvert> todoList = new ArrayList<>();
    todoList.add(jdkChannel);
//    todoList.add(jdkChannel2);
//    todoList.add(apacheCommon);

    for (StreamConvert streamConvert : todoList) {
      String inputPath = "/Users/victor/Downloads/IMG_2844.MOV";
//      String inputPath = "/Users/victor/tennis/match6.0.mp4";
      try (FileInputStream fileInputStream = new FileInputStream(
          inputPath);) {
        long date = new Date().getTime();
        File tempFile = File.createTempFile("cn.victor123.benchmark", "tmp");
        tempFile.deleteOnExit();
        FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
        streamConvert.copy(fileInputStream, fileOutputStream, 1024);
        long date1 = new Date().getTime();
        long diff = date1 - date;
        System.out.println(streamConvert.getClass().getName());
        System.out.println("diff time:" + diff);
        System.out.println("input size:" + fileInputStream.getChannel().size());
        System.out.println("output size:" + tempFile.length());
        tempFile.delete();

      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }


  }

}
