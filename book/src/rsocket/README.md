RSocket介绍
=========
RSocket是一个基于Reactive语义、全异步化的二进制消息通讯协议，主要包括以下一些特性：

*  四个通讯协议模型

    * request/response
    * request/stream
    * fire_and_forget
    * Channel

* 一个Ops的事件通知模型: metadataPush
* 角色对等通讯P2P: 也就是通讯双方角色可以互换，没有我们理解的传统意义上的client/server，client既可以为server，也可以为client。

听起来还是比较抽象，没有关系，你不需要马上理解全部的知识点，在完成一个Demo之后，你就会明白啦。

