package cn.victor123.benchmark.write;

public interface FileWriter {

  void write(int fileSize, int bufferSize, String dstPath) throws Exception;

}
