# Python3基本数据类型
##
- 等号（=）用来给变量赋值。
- 等号（=）运算符左边是一个变量名,等号（=）运算符右边是存储在变量中的值
## 标准数据类型
- Python3 中有六个标准的数据类型：
  - Number（数字）
  - String（字符串）
  -  List（列表）
  -  Tuple（元组）
  -  Set（集合）
  -  Dictionary（字典）
- Python3 的六个标准数据类型中：
   - 不可变数据（3 个）：Number（数字）、String（字符串）、Tuple（元组）；
   - 可变数据（3 个）：List（列表）、Dictionary（字典）、Set（集合）。

## Number（数字）
- Python3 支持 int、float、bool、complex（复数）。
## String（字符串）
- Python中的字符串用单引号 ' 或双引号 " 括起来，同时使用反斜杠 \ 转义特殊字符。
## List（列表）
- List（列表） 是 Python 中使用最频繁的数据类型。

- 列表可以完成大多数集合类的数据结构实现。列表中元素的类型可以不相同，它支持数字，字符串甚至可以包含列表（所谓嵌套）。

- 列表是写在方括号 [] 之间、用逗号分隔开的元素列表。

- 和字符串一样，列表同样可以被索引和截取，列表被截取后返回一个包含所需元素的新列表。
## Tuple（元组）
- 元组（tuple）与列表类似，不同之处在于元组的元素不能修改。元组写在小括号 () 里，元素之间用逗号隔开。

- 元组中的元素类型也可以不相同：
## Set（集合）
- 集合（set）是由一个或数个形态各异的大小整体组成的，构成集合的事物或对象称作元素或是成员。

- 基本功能是进行成员关系测试和删除重复元素。

- 可以使用大括号 { } 或者 set() 函数创建集合，注意：创建一个空集合必须用 set() 而不是 { }，因为 { } 是用来创建一个空字典。
## Dictionary（字典）
- 字典（dictionary）是Python中另一个非常有用的内置数据类型。

- 列表是有序的对象集合，字典是无序的对象集合。两者之间的区别在于：字典当中的元素是通过键来存取的，而不是通过偏移存取。

- 字典是一种映射类型，字典用 { } 标识，它是一个无序的 键(key) : 值(value) 的集合。

- 键(key)必须使用不可变类型。

- 在同一个字典中，键(key)必须是唯一的。
# Python3运算符
- Python语言支持以下类型的运算符:
  -  算术运算符
    - +；-；*;/;%;**;//
  -  比较（关系）运算符
    - ==;!=;>;<;>=;<=;
  -  赋值运算符
    - =	简单的赋值运算符	c = a + b 将 a + b 的运算结果赋值为 c
    - +=	加法赋值运算符	c += a 等效于 c = c + a
    - -=	减法赋值运算符	c -= a 等效于 c = c - a
    - *=	乘法赋值运算符	c *= a 等效于 c = c * a
    - /=	除法赋值运算符	c /= a 等效于 c = c / a
    - %=	取模赋值运算符	c %= a 等效于 c = c % a
    - **=	幂赋值运算符	c **= a 等效于 c = c ** a
    - //=	取整除赋值运算符 c //= a 等效于 c = c // a
  -  位运算符逻辑运算符
    - &	按位与运算符;
    - |	按位或运算符;
    - ^	按位异或运算符：
    - ~	按位取反运算符;
    - <<	左移动运算符：
    -  >>	右移动运算符：
  -  逻辑运算符
    - and；or;not；
  -  成员运算符
    - in；not in；
  -  身份运算符
    - is;not is;
  - 运算符优先级
    - 以下表格列出了从最高到最低优先级的所有运算符：

      运算符	描述
      **	指数 (最高优先级)
      ~ + -	按位翻转, 一元加号和减号 (最后两个的方法名为 +@ 和 -@)
      * / % //	乘，除，取模和取整除
      + -	加法减法
      >> <<	右移，左移运算符
      &	位 'AND'
      ^ |	位运算符
      <= < > >=	比较运算符
      <> == !=	等于运算符
      = %= /= //= -= += *= **=	赋值运算符
      is is not	身份运算符
      in not in	成员运算符
      and or not	逻辑运算符
- 