# WEB第四天
### JS
##### 基本概念
- 脚本语言（动态解释执行）
- 事件驱动（事件触动）
- 导入
--<script type="text/javascript" src=""> </script>--
- JavaScript 是一种轻量级的编程语言。
- JavaScript 是可插入 HTML 页面的编程代码。
- document.writeln("i:" + f);//writeln 并不换行，只是多个空格 。。 输出
- document.write(arr[f]+ "
");//write和writeln相比只是后面少个空格
##### 函数变量
- 在所有函数外面定义的变量是全局的
- 局部变量
- var pubObj;//在所有函数外面定义的变量是全局的
      function fn(){
      //          var obj=1; 此行定义了一个只在函数内部起作用的局部变量
                  obj=1;//此处定义了一个全局变量
                  console.log("函数内部obj："+obj);
              }
      //        调用语句
              fn();
- 数据类型
- 数值：
整数，浮点数，十进制，八进制，十六进制
- Infinity：无穷大，两个无穷大相比结果位true；
- 正负无穷大比较结果位false；
- 有无穷大参与的运算结果都是NaN
- var result=(0/0 == 0/0) = (NaN == NaN)=false
- NaN不等于任何东西
- 字符串
      "charAt(0)"+str.charAt(0));
      "str长度"+str.length);
      str + "转大写"+str.toUpperCase();
      str + "转小写"+str.toLowerCase();
      str+",3-5的内容是："+str.substring(2,5);
      //substring(开始位置，结束位置);
      tr+",从3 开始区两个字符:"+str.substr(2,3);
      //substr（开始位置，截取长度）；
- undefined
      字符串对象中并没有width属性所以undefined
- null
      var x,y,z = null;x==undefined,y==undefined,z==null;
      三等于:精确比较 https://www.cnblogs.com/starof/p/6368048.html
##### 复合数据类型
###### 内置对象
- Object
- Array数组长度不固定，数组元素类型不固定，可以是多个类型
      var num = [1,2,3];
      var num = [];
      var num = new Array();
- Date
- Error
- Function
  function fn(arg1,arg2) {}
      参数是弱类型，只写参数名，没有参数类型
      不需要指定返回值，可直接返回
      可以定义匿名函数，把函数赋值给变量
      定义一个类
      定义类中的方法，另一个类即使未定义方法也可以使用
- Math
- Number
- String
- 附加
      typeof/instanceof :判断类型
      自定义类
- 内置对象
Object  Array Date Error Function Math Number String
- 函数调用
call调用 apply调用
