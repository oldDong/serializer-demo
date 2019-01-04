序列化方式比较

    1、Java序列化
    优点：Java object serialize，Java原生方法不依赖外部类库
    缺点：
        1、不能跨语言
        2、序列化后byte[]字节数较大，网络传输时性能差
        3、序列化的对象必须接口Serializable接口
        
    2、Hessian序列化
    优点：序列化效率较Java原生较高，序列化后的字节为Java原生的一半以下
    
    3、ProtoBuff序列化
    优点：
        1、跨语言
        2、序列化后数据占用空间比json小
    缺点：以二进制的方式存储，无法直接读取编辑，除非有.proto定义
    
    百度封装了Google的ProtoBuff，简化了使用方式。
    