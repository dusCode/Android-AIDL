### AIDL实现步骤
1. 新建AIDL文件，命名为IRemoteService ----此时在src下的main中多出一个aidl文件夹，其下的包名与java下的包名一致
2. 编写aidl文件
3. 新建一个实体类HelloMsg并实现Parceable接口，能在进程间传递
4. 创建一个service，在service中实现AIDL定义的接口
5. 在client中绑定service，监听接口
