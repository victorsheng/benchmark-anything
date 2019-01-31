# 简介



## 来源
其中jmh-source从[官网](https://hg.openjdk.java.net/code-tools/jmh/)下载而来

hf clone https://hg.openjdk.java.net/code-tools/jmh 下载 

# 我理解的jmh架构

## 运行时架构图
![整体架构](../doc/tools.jmh架构图.jpg)

## 注解说明
![整体架构](../doc/注解说明.jpg)

# 深入了解
## 1.引用pom文件
```
        <dependency>
            <groupId>org.openjdk.jmh</groupId>
            <artifactId>jmh-core</artifactId>
            <version>${project.version}</version>
        </dependency>
        <dependency>
            <groupId>org.openjdk.jmh</groupId>
            <artifactId>jmh-generator-annprocess</artifactId>
            <version>${project.version}</version>
            <scope>provided</scope>
        </dependency>
```

###  jmh-core包:
提供了运行的api,可以再junittest或者main方法中进行调用

做了一些中文注释

###  jmh-jmh-generator-annprocess包:
当编译扫描到jmh的注解时,触发org.openjdk.jmh.generators.BenchmarkProcessor类工作

#### 触发机制:
- org.openjdk.jmh.generators.BenchmarkProcessor 继承 javax.annotation.processing.AbstractProcessor
- META-INF/services/javax.annotation.processing.Processor中注册了org.openjdk.jmh.generators.BenchmarkProcessor


#### 触发后的结果:
生成至target/generateted-sources/annotations/目录下

具体文件如下:

- [JMHSample_01_HelloWorld_jmhType.java](jmh-samples/src/main/java/org/openjdk/jmh/samples/generated/sample01/JMHSample_01_HelloWorld_jmhType.java)
- [JMHSample_01_HelloWorld_jmhType_B1.java](jmh-samples/src/main/java/org/openjdk/jmh/samples/generated/sample01/JMHSample_01_HelloWorld_jmhType_B1.java)
- [JMHSample_01_HelloWorld_jmhType_B2.java](jmh-samples/src/main/java/org/openjdk/jmh/samples/generated/sample01/JMHSample_01_HelloWorld_jmhType_B2.java)
- [JMHSample_01_HelloWorld_jmhType_B3.java](jmh-samples/src/main/java/org/openjdk/jmh/samples/generated/sample01/JMHSample_01_HelloWorld_jmhType_B3.java)
- [JMHSample_01_HelloWorld_wellHelloThere_jmhTest.java](jmh-samples/src/main/java/org/openjdk/jmh/samples/generated/sample01/JMHSample_01_HelloWorld_wellHelloThere_jmhTest.java)


### jmh-samples
- [samples目录](jmh-samples/src/main/java/org/openjdk/jmh/samples/README.md)
- [logs目录](jmh-samples/logs)目录保存了样例的运行结果





# 参考
## 官网说明
https://openjdk.java.net/projects/code-tools/jmh/

## 更新日志
https://hg.openjdk.java.net/code-tools/jmh/shortlog

## 讨论
https://bugs.openjdk.java.net/projects/CODETOOLS/issues/CODETOOLS-7901999?filter=allopenissues

## 详细的英文参数介绍
https://github.com/Valloric/jmh-playground
