## 第十五天笔记
- 构造方法唯一调用者是new，不可以对象调用
- 封装的目的是保护数据，编程上属性私有，提供公共方法对属性调用
- 接口是复合类型之一，接口和抽象类的作用是降低耦合
- 1.Exception和Error的区别
Error：错误，一旦发生，通过异常处理的机制无法解决，通过写代码方式无法解决；例如：内容溢出，一般来说是系统级别的，程序员无能为力
- 2.异常的分类
Checked Exception （已检查异常）：程序编译的 时候就能发现
UnChecked Exception(未检查异常）：程序执行的时候才能发现
- 3.如何人工抛出异常？throw关键字
throw +异常类的对象
throw与throws的区别
throw用在代码内部
请列举几个你熟悉的已检查异常和未检查异常：

- 未检查异常
1.ArithmeticException--算数异常
2.ArrayIndexOutOfBoundsException--数组越界异常
3.ClassCastException--类转换异常
4.NullPointerException--空指针异常 （空对象调用方法）
5.NumberFormatException--数字格式异常
6.runtimeException--运行时异常
7.SQLClientException--数据库异常
- 已检查异常
1.NoSuchFieldException--无属性异常
2.NoSuchMethodException
3.NullPointerException--空指针异常 （空对象调用方法）
4.IOException--输入输出异常，一般属于已检查异常
- 4.调用者处理异常
- 5.方法重写时异常的处理
- 6.自定义异常
一个try可以有多个catch
子类方法可以抛出比子类更少的异常；
资料类方法可以抛出比父类更多的异常，但是抛出的异常必须是父类异常的子类。
自定义异常总是和throw关键字一起出现
