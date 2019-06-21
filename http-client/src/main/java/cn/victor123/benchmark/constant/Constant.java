package cn.victor123.benchmark.constant;

public class Constant {

  public static final String LOCALHOST = "localhost";
  public static final String PORT = "8080";
  public static final String URL = "mock";



  public static final String LOCALHOST_NOW_URL = "http://" + LOCALHOST + ":" + PORT + "/" + URL
      + "/now";
  public static final String LOCALHOST_SLEEP1_URL = "http://" + LOCALHOST + ":" + PORT
      + "/" + URL + "/sleep1ms";
  public static final String LOCALHOST_SLEEP5_URL = "http://" + LOCALHOST + ":" + PORT
      + "/" + URL + "/sleep5ms";
  public static final String LOCALHOST_SLEEP10_URL = "http://" + LOCALHOST + ":" + PORT
      + "/" + URL + "/sleep10ms";

}
