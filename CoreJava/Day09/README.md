# 第九天笔记
##
### Java中的方法：
- 1、什么是方法？
  在Java中，方法就是用来完成解决某件事情或实现某个功能的办法。
方法实现的过程中，会包含很多条语句用于完成某些有意义的功能——通常是处理文本，控制输入或计算数值。
   Method(方法）就是函数Function。所谓方法就是把一段可以重复使用的代码包装起来完成某些有意义的功能的代码块。
- break结束的是一个变量
- 2、方法的创建
方法创建格式：

访问修饰符  [修饰符]  返回值数据类型  方法名([参数类型  参数名,...]){

		方法体（可重复使用的代码）；

		[return  返回值；]

}
- 形参与实参
形参（形式参数）: 方法的参数定义的变量,它是临时变量（是个空壳子，相当于声明变量而没有赋值）。
实参（实际参数）: 方法调用时候实际传递的参数变量（实际的值，相当于赋值）。
   见案例代码
- return结束的是一个循环
- 方法的重载与返回值类型无关，它只有方法名相同，参数的个数不同时可实现方法的重载
- 方法的调用时机
   正常情况： 在其他方法中调用
   花式调用：
   1)、创建"变量"时调用
   2)、for 循环中调用
   3)、自身方法中调用,被称之为“递归调用”
   4)、方法和方法之间互相调用
   -
- 8、重载的注意事项及特点
  (a)、重载的注意事项：
    1、重载方法参数必须不同：
              1）参数个数不同，如method(int x)与method(int x,int y)不同
              2）参数类型不同，如method(int x)与method(double x)不同
             3）参数顺序不同，如method(int x,double y)与method(double x,int y)不同
  2、重载只与方法名与参数类型相关与返回值无关
            如void method(int x)与int method(int y)不是方法重载，不能同时存在
  3、重载与具体的参数变量标识符无关
           如method(int x)与method(int y)不是方法重载，不能同时存在

  (b)、方法重载特点：
    与方法的返回值类型无关，与方法的参数名无关，只看方法名与参数列表；
	方法重载，是通过JVM来完成同名方法的调用的，通过参数列表来决定调用的是哪一个方法。
-  方法使用的注意事项
	1)、方法不调用不执行
	2)、方法与方法是平级关系，不能嵌套定义
	3)、方法定义的时候参数之间用逗号隔开
	4)、方法调用的时候不用再传递数据类型
	5)、如果方法有明确的返回值，一定要通过return返回一个值
