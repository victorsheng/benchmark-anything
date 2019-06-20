
```
Benchmark                                                        (className)  (diffFeature)  Mode  Cnt   Score   Error  Units
ClientBenchMark.test   cn.victor123.benchmark.client.ApacheClientClient     KEEP_ALIVE  avgt        1.915          ms/op
ClientBenchMark.test   cn.victor123.benchmark.client.ApacheClientClient           NULL  avgt        2.553          ms/op
ClientBenchMark.test      cn.victor123.benchmark.client.JdkClientClient     KEEP_ALIVE  avgt        0.653          ms/op
ClientBenchMark.test      cn.victor123.benchmark.client.JdkClientClient           NULL  avgt        0.725          ms/op
ClientBenchMark.test   cn.victor123.benchmark.client.OkHttpClientClient     KEEP_ALIVE  avgt        0.171          ms/op
ClientBenchMark.test   cn.victor123.benchmark.client.OkHttpClientClient           NULL  avgt        0.154          ms/op
ClientBenchMark.test        cn.victor123.benchmark.client.UnirestClient     KEEP_ALIVE  avgt        0.196          ms/op
ClientBenchMark.test        cn.victor123.benchmark.client.UnirestClient           NULL  avgt        0.178          ms/op
ClientBenchMark2.test  cn.victor123.benchmark.client.ApacheClientClient     KEEP_ALIVE  avgt        2.212          ms/op

ClientBenchMark2.test  cn.victor123.benchmark.client.ApacheClientClient           NULL  avgt        2.566          ms/op
ClientBenchMark2.test     cn.victor123.benchmark.client.JdkClientClient     KEEP_ALIVE  avgt        1.933          ms/op
ClientBenchMark2.test     cn.victor123.benchmark.client.JdkClientClient           NULL  avgt        1.402          ms/op
ClientBenchMark2.test  cn.victor123.benchmark.client.OkHttpClientClient     KEEP_ALIVE  avgt        0.185          ms/op
ClientBenchMark2.test  cn.victor123.benchmark.client.OkHttpClientClient           NULL  avgt        0.186          ms/op
ClientBenchMark2.test       cn.victor123.benchmark.client.UnirestClient     KEEP_ALIVE  avgt        0.205          ms/op
ClientBenchMark2.test       cn.victor123.benchmark.client.UnirestClient           NULL  avgt        0.206          ms/op

ClientBenchMark4.test  cn.victor123.benchmark.client.ApacheClientClient     KEEP_ALIVE  avgt        3.086          ms/op
ClientBenchMark4.test  cn.victor123.benchmark.client.ApacheClientClient           NULL  avgt        3.128          ms/op
ClientBenchMark4.test     cn.victor123.benchmark.client.JdkClientClient     KEEP_ALIVE  avgt        4.065          ms/op
ClientBenchMark4.test     cn.victor123.benchmark.client.JdkClientClient           NULL  avgt        6.318          ms/op
ClientBenchMark4.test  cn.victor123.benchmark.client.OkHttpClientClient     KEEP_ALIVE  avgt        0.248          ms/op
ClientBenchMark4.test  cn.victor123.benchmark.client.OkHttpClientClient           NULL  avgt        0.206          ms/op
ClientBenchMark4.test       cn.victor123.benchmark.client.UnirestClient     KEEP_ALIVE  avgt        0.263          ms/op
ClientBenchMark4.test       cn.victor123.benchmark.client.UnirestClient           NULL  avgt        0.252          ms/op

ClientBenchMark8.test  cn.victor123.benchmark.client.ApacheClientClient     KEEP_ALIVE  avgt        6.584          ms/op
ClientBenchMark8.test  cn.victor123.benchmark.client.ApacheClientClient           NULL  avgt       10.064          ms/op
ClientBenchMark8.test     cn.victor123.benchmark.client.JdkClientClient     KEEP_ALIVE  avgt        3.581          ms/op
ClientBenchMark8.test     cn.victor123.benchmark.client.JdkClientClient           NULL  avgt        5.001          ms/op
ClientBenchMark8.test  cn.victor123.benchmark.client.OkHttpClientClient     KEEP_ALIVE  avgt        0.293          ms/op
ClientBenchMark8.test  cn.victor123.benchmark.client.OkHttpClientClient           NULL  avgt        0.294          ms/op
ClientBenchMark8.test       cn.victor123.benchmark.client.UnirestClient     KEEP_ALIVE  avgt        0.337          ms/op
ClientBenchMark8.test       cn.victor123.benchmark.client.UnirestClient           NULL  avgt        0.341          ms/op

```
可以看出UnirestClient和OkHttpClientClient在开启KEEP_ALIVE参数后,性能是一样的,因此可以推断,UnirestClient和OkHttpClientClient是默认开启的
