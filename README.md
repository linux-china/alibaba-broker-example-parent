RSocket Broker Example
======================
![GitHub Workflow Status](https://img.shields.io/github/workflow/status/linux-china/alibaba-broker-example-parent/JavaBuildWithMaven)

Example: requester <-> Broker <-> responder 三者通讯模型

# Maven Modules

* user-service-api: Reactive服务接口定义都在该模块中
* rsocket-responder: RSocket服务响应者，Reactive服务接口的实现和服务提供者
* rsocket-requester: RSocket服务请求者，调用远程的RSocket服务


# Features

* 标准RSocket服务接口
* 流式二进制接口
* Protobuf样例
* Kotlin Coroutines & Async Flow

