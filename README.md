RSocket Broker Example
======================
![GitHub Workflow Status](https://img.shields.io/github/workflow/status/linux-china/alibaba-broker-example-parent/JavaBuildWithMaven)

Alibaba RSocket Kotlin Example: requester <-> Broker <-> responder 三者通讯样例。

# Maven Modules

* user-service-api: Reactive服务接口定义都在该模块中
* rsocket-responder: RSocket服务响应者，Reactive服务接口的实现和服务提供者
* rsocket-requester: RSocket服务请求者，调用远程的RSocket服务

# Features

* 标准RSocket服务接口
* 流式二进制接口
* Protobuf样例
* Kotlin Coroutines & Async Flow

# Free test with Alibaba RSocket Broker

Alibaba RSocket Broker提供了免费的在线测试环境，你本地不需要启动本地的RSocket Broker就可以测试。

* 获取访问RSocket Broker的JWT Token，命令如下：

```
curl https://jwt.alibroker.info
```

* 修改application.properties文件，添加如下配置：

```
rsocket.brokers=tcp://139.196.223.16:9999,tcp://139.196.223.138:9999
rsocket.jwt-token=xxx
```

* 启动RSocket应用，就可以进行测试
