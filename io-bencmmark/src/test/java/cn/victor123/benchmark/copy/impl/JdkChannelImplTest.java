package cn.victor123.benchmark.copy.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.junit.Test;

public class JdkChannelImplTest {

  @Test
  public void testCopy() throws Exception {
    JdkChannelImpl jdkChannel = new JdkChannelImpl();

    File tempFile = File.createTempFile("hhhh", ".mov");
    tempFile.deleteOnExit();
//    String inputPath = "/Users/victor/Downloads/第二场比赛IMG_6984.MOV";
//    String inputPath = "/Users/victor/code/vicProjects/benchmark-anything/stream-convert/pom.xml";
    String inputPath = "/Users/victor/Downloads/IMG_2844.MOV";
//    String inputPath = "/Users/victor/tennis/match6.0.mp4";
    try (FileInputStream fileInputStream = new FileInputStream(
        inputPath);) {
      FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
      jdkChannel.copy(fileInputStream, fileOutputStream, 100 * 1024);
      fileOutputStream.flush();
//      jdkChannel.copy(fileInputStream, fileOutputStream, 1024*100);
      System.out.println(tempFile.length());
      System.out.println(tempFile.getAbsoluteFile());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      tempFile.delete();
    }

  }

}