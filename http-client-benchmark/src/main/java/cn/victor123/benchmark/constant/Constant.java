package cn.victor123.benchmark.constant;

public class Constant {

  volatile public static Constant i = new Constant("localhost", "3000", "mock");


  public Constant(String host, String port, String url) {
    this.host = host;
    this.port = port;
    this.url = url;
    init();
  }

  public void init() {
    now_url = "http://" + host + ":" + port + "/" + url + "/now";

    sleep1_url = "http://" + host + ":" + port + "/" + url + "/sleep1ms";
    sleep5_url = "http://" + host + ":" + port + "/" + url + "/sleep5ms";
    sleep10_url = "http://" + host + ":" + port + "/" + url + "/sleep10ms";

    download_small_url = "http://" + host + ":" + port + "/" + url + "/download_small";
    download_large_url = "http://" + host + ":" + port + "/" + url + "/download_large";

    upload_url = "http://" + host + ":" + port + "/" + url + "/upload";
  }

  private String host;
  private String url;
  private String port;

  private String now_url;
  private String sleep1_url;
  private String sleep5_url;
  private String sleep10_url;
  private String download_small_url;
  private String download_large_url;
  private String upload_url;

  public String getNow_url() {
    return now_url;
  }

  public void setNow_url(String now_url) {
    this.now_url = now_url;
  }

  public String getSleep1_url() {
    return sleep1_url;
  }

  public void setSleep1_url(String sleep1_url) {
    this.sleep1_url = sleep1_url;
  }

  public String getSleep5_url() {
    return sleep5_url;
  }

  public void setSleep5_url(String sleep5_url) {
    this.sleep5_url = sleep5_url;
  }

  public String getSleep10_url() {
    return sleep10_url;
  }

  public void setSleep10_url(String sleep10_url) {
    this.sleep10_url = sleep10_url;
  }

  public String getDownload_small_url() {
    return download_small_url;
  }

  public void setDownload_small_url(String download_small_url) {
    this.download_small_url = download_small_url;
  }

  public String getDownload_large_url() {
    return download_large_url;
  }

  public void setDownload_large_url(String download_large_url) {
    this.download_large_url = download_large_url;
  }

  public String getUpload_url() {
    return upload_url;
  }

  public void setUpload_url(String upload_url) {
    this.upload_url = upload_url;
  }
}
