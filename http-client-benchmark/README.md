

## 性能比较
```


Benchmark                                                   (className)  (diffFeature)                                (url)  Mode  Cnt   Score   Error  Units
ClientBenchMark.test   cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL       http://localhost:8080/mock/now  avgt        1.923          ms/op
ClientBenchMark.test   cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  http://localhost:8080/mock/sleep1ms  avgt        4.369          ms/op
ClientBenchMark.test   cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  http://localhost:8080/mock/sleep5ms  avgt        9.404          ms/op
ClientBenchMark.test      cn.victor123.benchmark.client.JdkHttpClient           NULL       http://localhost:8080/mock/now  avgt        0.827          ms/op
ClientBenchMark.test      cn.victor123.benchmark.client.JdkHttpClient           NULL  http://localhost:8080/mock/sleep1ms  avgt        2.561          ms/op
ClientBenchMark.test      cn.victor123.benchmark.client.JdkHttpClient           NULL  http://localhost:8080/mock/sleep5ms  avgt        7.875          ms/op
ClientBenchMark.test   cn.victor123.benchmark.client.OkHttpClientt           NULL       http://localhost:8080/mock/now  avgt        0.154          ms/op
ClientBenchMark.test   cn.victor123.benchmark.client.OkHttpClientt           NULL  http://localhost:8080/mock/sleep1ms  avgt        2.012          ms/op
ClientBenchMark.test   cn.victor123.benchmark.client.OkHttpClientt           NULL  http://localhost:8080/mock/sleep5ms  avgt        6.807          ms/op
ClientBenchMark.test         cn.victor123.benchmark.client.SpringHttpClient           NULL       http://localhost:8080/mock/now  avgt        0.204          ms/op
ClientBenchMark.test         cn.victor123.benchmark.client.SpringHttpClient           NULL  http://localhost:8080/mock/sleep1ms  avgt        1.911          ms/op
ClientBenchMark.test         cn.victor123.benchmark.client.SpringHttpClient           NULL  http://localhost:8080/mock/sleep5ms  avgt        7.191          ms/op
ClientBenchMark.test        cn.victor123.benchmark.client.UnirestHttpClient           NULL       http://localhost:8080/mock/now  avgt        0.186          ms/op
ClientBenchMark.test        cn.victor123.benchmark.client.UnirestHttpClient           NULL  http://localhost:8080/mock/sleep1ms  avgt        2.039          ms/op
ClientBenchMark.test        cn.victor123.benchmark.client.UnirestHttpClient           NULL  http://localhost:8080/mock/sleep5ms  avgt        7.132          ms/op
ClientBenchMark2.test  cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL       http://localhost:8080/mock/now  avgt        2.147          ms/op
ClientBenchMark2.test  cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  http://localhost:8080/mock/sleep1ms  avgt        3.663          ms/op
ClientBenchMark2.test  cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  http://localhost:8080/mock/sleep5ms  avgt        8.922          ms/op
ClientBenchMark2.test     cn.victor123.benchmark.client.JdkHttpClient           NULL       http://localhost:8080/mock/now  avgt        1.573          ms/op
ClientBenchMark2.test     cn.victor123.benchmark.client.JdkHttpClient           NULL  http://localhost:8080/mock/sleep1ms  avgt        3.047          ms/op
ClientBenchMark2.test     cn.victor123.benchmark.client.JdkHttpClient           NULL  http://localhost:8080/mock/sleep5ms  avgt        7.414          ms/op
ClientBenchMark2.test  cn.victor123.benchmark.client.OkHttpClientt           NULL       http://localhost:8080/mock/now  avgt        0.174          ms/op
ClientBenchMark2.test  cn.victor123.benchmark.client.OkHttpClientt           NULL  http://localhost:8080/mock/sleep1ms  avgt        1.909          ms/op
ClientBenchMark2.test  cn.victor123.benchmark.client.OkHttpClientt           NULL  http://localhost:8080/mock/sleep5ms  avgt        6.714          ms/op
ClientBenchMark2.test        cn.victor123.benchmark.client.SpringHttpClient           NULL       http://localhost:8080/mock/now  avgt        0.218          ms/op
ClientBenchMark2.test        cn.victor123.benchmark.client.SpringHttpClient           NULL  http://localhost:8080/mock/sleep1ms  avgt        1.942          ms/op
ClientBenchMark2.test        cn.victor123.benchmark.client.SpringHttpClient           NULL  http://localhost:8080/mock/sleep5ms  avgt        7.043          ms/op
ClientBenchMark2.test       cn.victor123.benchmark.client.UnirestHttpClient           NULL       http://localhost:8080/mock/now  avgt        0.168          ms/op
ClientBenchMark2.test       cn.victor123.benchmark.client.UnirestHttpClient           NULL  http://localhost:8080/mock/sleep1ms  avgt        1.896          ms/op
ClientBenchMark2.test       cn.victor123.benchmark.client.UnirestHttpClient           NULL  http://localhost:8080/mock/sleep5ms  avgt        6.645          ms/op
ClientBenchMark4.test  cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL       http://localhost:8080/mock/now  avgt        3.610          ms/op
ClientBenchMark4.test  cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  http://localhost:8080/mock/sleep1ms  avgt        4.479          ms/op
ClientBenchMark4.test  cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  http://localhost:8080/mock/sleep5ms  avgt        9.751          ms/op
ClientBenchMark4.test     cn.victor123.benchmark.client.JdkHttpClient           NULL       http://localhost:8080/mock/now  avgt        3.102          ms/op
ClientBenchMark4.test     cn.victor123.benchmark.client.JdkHttpClient           NULL  http://localhost:8080/mock/sleep1ms  avgt        7.385          ms/op
ClientBenchMark4.test     cn.victor123.benchmark.client.JdkHttpClient           NULL  http://localhost:8080/mock/sleep5ms  avgt        8.174          ms/op
ClientBenchMark4.test  cn.victor123.benchmark.client.OkHttpClientt           NULL       http://localhost:8080/mock/now  avgt        0.199          ms/op
ClientBenchMark4.test  cn.victor123.benchmark.client.OkHttpClientt           NULL  http://localhost:8080/mock/sleep1ms  avgt        1.756          ms/op
ClientBenchMark4.test  cn.victor123.benchmark.client.OkHttpClientt           NULL  http://localhost:8080/mock/sleep5ms  avgt        6.312          ms/op
ClientBenchMark4.test        cn.victor123.benchmark.client.SpringHttpClient           NULL       http://localhost:8080/mock/now  avgt        0.272          ms/op
ClientBenchMark4.test        cn.victor123.benchmark.client.SpringHttpClient           NULL  http://localhost:8080/mock/sleep1ms  avgt        1.702          ms/op
ClientBenchMark4.test        cn.victor123.benchmark.client.SpringHttpClient           NULL  http://localhost:8080/mock/sleep5ms  avgt        6.476          ms/op
ClientBenchMark4.test       cn.victor123.benchmark.client.UnirestHttpClient           NULL       http://localhost:8080/mock/now  avgt        0.234          ms/op
ClientBenchMark4.test       cn.victor123.benchmark.client.UnirestHttpClient           NULL  http://localhost:8080/mock/sleep1ms  avgt        1.808          ms/op
ClientBenchMark4.test       cn.victor123.benchmark.client.UnirestHttpClient           NULL  http://localhost:8080/mock/sleep5ms  avgt        6.708          ms/op
ClientBenchMark8.test  cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL       http://localhost:8080/mock/now  avgt        5.995          ms/op
ClientBenchMark8.test  cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  http://localhost:8080/mock/sleep1ms  avgt        7.612          ms/op
ClientBenchMark8.test  cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  http://localhost:8080/mock/sleep5ms  avgt       15.526          ms/op
ClientBenchMark8.test     cn.victor123.benchmark.client.JdkHttpClient           NULL       http://localhost:8080/mock/now  avgt        3.496          ms/op
ClientBenchMark8.test     cn.victor123.benchmark.client.JdkHttpClient           NULL  http://localhost:8080/mock/sleep1ms  avgt        6.096          ms/op
ClientBenchMark8.test     cn.victor123.benchmark.client.JdkHttpClient           NULL  http://localhost:8080/mock/sleep5ms  avgt        9.880          ms/op
ClientBenchMark8.test  cn.victor123.benchmark.client.OkHttpClientt           NULL       http://localhost:8080/mock/now  avgt        0.303          ms/op
ClientBenchMark8.test  cn.victor123.benchmark.client.OkHttpClientt           NULL  http://localhost:8080/mock/sleep1ms  avgt        1.664          ms/op
ClientBenchMark8.test  cn.victor123.benchmark.client.OkHttpClientt           NULL  http://localhost:8080/mock/sleep5ms  avgt        6.661          ms/op
ClientBenchMark8.test        cn.victor123.benchmark.client.SpringHttpClient           NULL       http://localhost:8080/mock/now  avgt        0.434          ms/op
ClientBenchMark8.test        cn.victor123.benchmark.client.SpringHttpClient           NULL  http://localhost:8080/mock/sleep1ms  avgt        1.662          ms/op
ClientBenchMark8.test        cn.victor123.benchmark.client.SpringHttpClient           NULL  http://localhost:8080/mock/sleep5ms  avgt        6.521          ms/op
ClientBenchMark8.test       cn.victor123.benchmark.client.UnirestHttpClient           NULL       http://localhost:8080/mock/now  avgt        0.337          ms/op
ClientBenchMark8.test       cn.victor123.benchmark.client.UnirestHttpClient           NULL  http://localhost:8080/mock/sleep1ms  avgt        1.627          ms/op
ClientBenchMark8.test       cn.victor123.benchmark.client.UnirestHttpClient           NULL  http://localhost:8080/mock/sleep5ms  avgt        6.583          ms/op


```
1.性能能结果
2.可以看出UnirestClient和OkHttpClientClient在开启KEEP_ALIVE参数后,性能是一样的,因此可以推断,UnirestClient和OkHttpClientClient是默认开启的
3.配置问题



## 参数比较
在服务端添加过滤器,打印http的请求
http1.1

## UnirestClient与ApacheClientClient

```xml
		<dependency>
			<groupId>org.apache.httpcomponents</groupId>
			<artifactId>httpclient</artifactId>
			<version>4.5.2</version>
		</dependency>
		<dependency>
			<groupId>org.apache.httpcomponents</groupId>
			<artifactId>httpasyncclient</artifactId>
			<version>4.1.1</version>
		</dependency>
		<dependency>
			<groupId>org.apache.httpcomponents</groupId>
			<artifactId>httpmime</artifactId>
			<version>4.5.2</version>
		</dependency>
```


```java
    if (!request.getHeaders().containsKey("user-agent")) {
      request.header("user-agent", "unirest-java/1.3.11");
    }

    if (!request.getHeaders().containsKey("accept-encoding")) {
      request.header("accept-encoding", "gzip");
    }

```

```java
public static void refresh() {
    Object connectionTimeout = getOption(Option.CONNECTION_TIMEOUT);
    if (connectionTimeout == null) {
      connectionTimeout = 10000L;
    }

    Object socketTimeout = getOption(Option.SOCKET_TIMEOUT);
    if (socketTimeout == null) {
      socketTimeout = 60000L;
    }

    Object maxTotal = getOption(Option.MAX_TOTAL);
    if (maxTotal == null) {
      maxTotal = 200;
    }

    Object maxPerRoute = getOption(Option.MAX_PER_ROUTE);
    if (maxPerRoute == null) {
      maxPerRoute = 20;
    }

    HttpHost proxy = (HttpHost)getOption(Option.PROXY);
    RequestConfig clientConfig = RequestConfig.custom().setConnectTimeout(((Long)connectionTimeout).intValue()).setSocketTimeout(((Long)socketTimeout).intValue()).setConnectionRequestTimeout(((Long)socketTimeout).intValue()).setProxy(proxy).build();
    PoolingHttpClientConnectionManager syncConnectionManager = new PoolingHttpClientConnectionManager();
    syncConnectionManager.setMaxTotal((Integer)maxTotal);
    syncConnectionManager.setDefaultMaxPerRoute((Integer)maxPerRoute);
    setOption(Option.HTTPCLIENT, HttpClientBuilder.create().setDefaultRequestConfig(clientConfig).setConnectionManager(syncConnectionManager).build());
    SyncIdleConnectionMonitorThread syncIdleConnectionMonitorThread = new SyncIdleConnectionMonitorThread(syncConnectionManager);
    setOption(Option.SYNC_MONITOR, syncIdleConnectionMonitorThread);
    syncIdleConnectionMonitorThread.start();

    PoolingNHttpClientConnectionManager asyncConnectionManager;
    try {
      DefaultConnectingIOReactor ioreactor = new DefaultConnectingIOReactor();
      asyncConnectionManager = new PoolingNHttpClientConnectionManager(ioreactor);
      asyncConnectionManager.setMaxTotal((Integer)maxTotal);
      asyncConnectionManager.setDefaultMaxPerRoute((Integer)maxPerRoute);
    } catch (IOReactorException var11) {
      throw new RuntimeException(var11);
    }

    CloseableHttpAsyncClient asyncClient = HttpAsyncClientBuilder.create().setDefaultRequestConfig(clientConfig).setConnectionManager(asyncConnectionManager).build();
    setOption(Option.ASYNCHTTPCLIENT, asyncClient);
    setOption(Option.ASYNC_MONITOR, new AsyncIdleConnectionMonitorThread(asyncConnectionManager));
  }
```


# post上传

```

Benchmark                                                    (className)  (diffFeature)                              (url)  Mode  Cnt   Score   Error  Units
ClientBenchMark.upload    cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  http://localhost:8080/mock/upload  avgt        6.466          ms/op
ClientBenchMark.upload       cn.victor123.benchmark.client.JdkHttpClient           NULL  http://localhost:8080/mock/upload  avgt        4.880          ms/op
ClientBenchMark.upload       cn.victor123.benchmark.client.OkHttpClientt           NULL  http://localhost:8080/mock/upload  avgt        5.963          ms/op
ClientBenchMark.upload    cn.victor123.benchmark.client.SpringHttpClient           NULL  http://localhost:8080/mock/upload  avgt        6.186          ms/op
ClientBenchMark.upload   cn.victor123.benchmark.client.UnirestHttpClient           NULL  http://localhost:8080/mock/upload  avgt        3.402          ms/op
ClientBenchMark2.upload   cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  http://localhost:8080/mock/upload  avgt        4.115          ms/op
ClientBenchMark2.upload      cn.victor123.benchmark.client.JdkHttpClient           NULL  http://localhost:8080/mock/upload  avgt        3.914          ms/op
ClientBenchMark2.upload      cn.victor123.benchmark.client.OkHttpClientt           NULL  http://localhost:8080/mock/upload  avgt        5.262          ms/op
ClientBenchMark2.upload   cn.victor123.benchmark.client.SpringHttpClient           NULL  http://localhost:8080/mock/upload  avgt        5.457          ms/op
ClientBenchMark2.upload  cn.victor123.benchmark.client.UnirestHttpClient           NULL  http://localhost:8080/mock/upload  avgt        4.583          ms/op
ClientBenchMark4.upload   cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  http://localhost:8080/mock/upload  avgt        9.837          ms/op
ClientBenchMark4.upload      cn.victor123.benchmark.client.JdkHttpClient           NULL  http://localhost:8080/mock/upload  avgt        4.585          ms/op
ClientBenchMark4.upload      cn.victor123.benchmark.client.OkHttpClientt           NULL  http://localhost:8080/mock/upload  avgt        5.551          ms/op
ClientBenchMark4.upload   cn.victor123.benchmark.client.SpringHttpClient           NULL  http://localhost:8080/mock/upload  avgt        5.731          ms/op
ClientBenchMark4.upload  cn.victor123.benchmark.client.UnirestHttpClient           NULL  http://localhost:8080/mock/upload  avgt        4.739          ms/op
ClientBenchMark8.upload   cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  http://localhost:8080/mock/upload  avgt       16.073          ms/op
ClientBenchMark8.upload      cn.victor123.benchmark.client.JdkHttpClient           NULL  http://localhost:8080/mock/upload  avgt        8.605          ms/op
ClientBenchMark8.upload      cn.victor123.benchmark.client.OkHttpClientt           NULL  http://localhost:8080/mock/upload  avgt       13.457          ms/op
ClientBenchMark8.upload   cn.victor123.benchmark.client.SpringHttpClient           NULL  http://localhost:8080/mock/upload  avgt       10.690          ms/op
ClientBenchMark8.upload  cn.victor123.benchmark.client.UnirestHttpClient           NULL  http://localhost:8080/mock/upload  avgt        8.263          ms/op

```

# 下载
```
Benchmark                                                            (className)  (diffFeature)  Mode  Cnt  Score   Error  Units
ClientBenchMark.download_210KB    cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  avgt       1.557          ms/op
ClientBenchMark.download_210KB       cn.victor123.benchmark.client.JdkHttpClient           NULL  avgt       1.316          ms/op
ClientBenchMark.download_210KB       cn.victor123.benchmark.client.OkHttpClientt           NULL  avgt       0.976          ms/op
ClientBenchMark.download_210KB    cn.victor123.benchmark.client.SpringHttpClient           NULL  avgt       1.088          ms/op
ClientBenchMark.download_210KB   cn.victor123.benchmark.client.UnirestHttpClient           NULL  avgt       1.552          ms/op
ClientBenchMark.download_420KB    cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  avgt       1.498          ms/op
ClientBenchMark.download_420KB       cn.victor123.benchmark.client.JdkHttpClient           NULL  avgt       2.393          ms/op
ClientBenchMark.download_420KB       cn.victor123.benchmark.client.OkHttpClientt           NULL  avgt       2.275          ms/op
ClientBenchMark.download_420KB    cn.victor123.benchmark.client.SpringHttpClient           NULL  avgt       6.793          ms/op
ClientBenchMark.download_420KB   cn.victor123.benchmark.client.UnirestHttpClient           NULL  avgt       2.783          ms/op
ClientBenchMark2.download_210KB   cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  avgt       1.160          ms/op
ClientBenchMark2.download_210KB      cn.victor123.benchmark.client.JdkHttpClient           NULL  avgt       1.568          ms/op
ClientBenchMark2.download_210KB      cn.victor123.benchmark.client.OkHttpClientt           NULL  avgt       0.770          ms/op
ClientBenchMark2.download_210KB   cn.victor123.benchmark.client.SpringHttpClient           NULL  avgt       1.079          ms/op
ClientBenchMark2.download_210KB  cn.victor123.benchmark.client.UnirestHttpClient           NULL  avgt       1.606          ms/op
ClientBenchMark2.download_420KB   cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  avgt       1.428          ms/op
ClientBenchMark2.download_420KB      cn.victor123.benchmark.client.JdkHttpClient           NULL  avgt       3.024          ms/op
ClientBenchMark2.download_420KB      cn.victor123.benchmark.client.OkHttpClientt           NULL  avgt       3.716          ms/op
ClientBenchMark2.download_420KB   cn.victor123.benchmark.client.SpringHttpClient           NULL  avgt       1.973          ms/op
ClientBenchMark2.download_420KB  cn.victor123.benchmark.client.UnirestHttpClient           NULL  avgt       2.994          ms/op
ClientBenchMark4.download_210KB   cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  avgt       1.511          ms/op
ClientBenchMark4.download_210KB      cn.victor123.benchmark.client.JdkHttpClient           NULL  avgt       2.051          ms/op
ClientBenchMark4.download_210KB      cn.victor123.benchmark.client.OkHttpClientt           NULL  avgt       2.081          ms/op
ClientBenchMark4.download_210KB   cn.victor123.benchmark.client.SpringHttpClient           NULL  avgt       1.948          ms/op
ClientBenchMark4.download_210KB  cn.victor123.benchmark.client.UnirestHttpClient           NULL  avgt       2.673          ms/op
ClientBenchMark4.download_420KB   cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  avgt       4.119          ms/op
ClientBenchMark4.download_420KB      cn.victor123.benchmark.client.JdkHttpClient           NULL  avgt       3.510          ms/op
ClientBenchMark4.download_420KB      cn.victor123.benchmark.client.OkHttpClientt           NULL  avgt       5.082          ms/op
ClientBenchMark4.download_420KB   cn.victor123.benchmark.client.SpringHttpClient           NULL  avgt       3.436          ms/op
ClientBenchMark4.download_420KB  cn.victor123.benchmark.client.UnirestHttpClient           NULL  avgt       5.381          ms/op
ClientBenchMark8.download_210KB   cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  avgt       3.145          ms/op
ClientBenchMark8.download_210KB      cn.victor123.benchmark.client.JdkHttpClient           NULL  avgt       3.094          ms/op
ClientBenchMark8.download_210KB      cn.victor123.benchmark.client.OkHttpClientt           NULL  avgt       2.183          ms/op
ClientBenchMark8.download_210KB   cn.victor123.benchmark.client.SpringHttpClient           NULL  avgt       3.160          ms/op
ClientBenchMark8.download_210KB  cn.victor123.benchmark.client.UnirestHttpClient           NULL  avgt       4.619          ms/op
ClientBenchMark8.download_420KB   cn.victor123.benchmark.client.ApacheHttpNoShareClient           NULL  avgt       9.196          ms/op
ClientBenchMark8.download_420KB      cn.victor123.benchmark.client.JdkHttpClient           NULL  avgt       5.811          ms/op
ClientBenchMark8.download_420KB      cn.victor123.benchmark.client.OkHttpClientt           NULL  avgt       4.940          ms/op
ClientBenchMark8.download_420KB   cn.victor123.benchmark.client.SpringHttpClient           NULL  avgt       5.935          ms/op
ClientBenchMark8.download_420KB  cn.victor123.benchmark.client.UnirestHttpClient           NULL  avgt       8.669          ms/op
```