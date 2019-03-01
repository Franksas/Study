# 第十八天笔记
### Java IO
#### IO流
##### 1.IO是什么？
- Input：输入流，读文件
- Output：输入流，写文件
##### 2.流的分类？按读写单位分
- 1）字节流，处理二进制文件，按字节来读写
- 2）字符流，处理文本文件（不能带格式），按字符来读写
##### 3.File类，java.io.file
##### 4.按字节读写文件（字节流）
- 将硬盘文件与内存对象
- 打开源，读文件
- 关闭流
##### 5.按字符读写         
- Reader/Writer
##### 6.按行读
- BufferedReader
- driverName=oracle.jdbc.OracleDriver
- username=scott
- psw=tiger
- url=jdbc:oracle:thin:@localhost:1521:orcl
#.Properties//属性文件，用于配置
##### 7.JDK8 读写方式
##### 8.对象的序列化
- 序列化：对象（内存）的状态（属性值） -----保存到硬盘文件
- 反序列化：文件中存放的对象属性还原成内存对象
- 用于在网络上传输对象

VO(value object) ,Model .
transient  暂态
第三方组件Apache
