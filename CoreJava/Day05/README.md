# 第五天笔记
## LOS-如何使用运算符
###  赋值运算符（=）
=
a++返回原来的值 ++a返回+1后的值
s = s + 1和 s +=1相等
- 1.等号左右两侧类型问题
- 2.左右两侧范围
###  算术运算符
- 数字变字符串  数字 + ""
- 整数除以0错误，小数除以0正确
&（与），|（或），&&（短路与），||（短路或）。&&和||更高效，如果前一个式子可以直接决定结果，就可以跳过下一个直接输出结果。
### 扩展运算符
### 逻辑运算符
### 关系运算符
### 三目运算符
### 二进制运算符
### 移动运算符
---
System.out.println(3 + 2 + "tit");//5tit System.out.println(3 + "tit" + 2);//3tit2 System.out.println( "tit" + 2 + 3);//tit23 String str1 = 23 + "";//将23变成字符串 System.out.println(3 / 2);//1(整数相除取整数) System.out.println(3.0 / 2);//1.5(小数相除直接输出答案) System.out.println(2 / 3);//0 System.out.println(2.0 / 3);//0.666 System.out.println(2.0 / 0);//小数除以0正确，小数除以0得无穷大 //System.out.println(2 / 0);整数除以0报错 System.out.println(3 % 2);//1 System.out.println(3.0 % 2);//-1.0 System.out.println(2 % 3);//2 System.out.println(2.0 % 3);//2.0 System.out.println(2.0 % 0);//报错 int a = 2; int b = 3; int c = a++ - ++b + --a; // 2 - 4 + 2 System.out.println("c = "+ c);
