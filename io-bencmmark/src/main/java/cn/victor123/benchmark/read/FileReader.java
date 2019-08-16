package cn.victor123.benchmark.read;

public interface FileReader {

  int read(String path, int bufferSize) throws Exception;

}
