# 第十六天笔记
- API：Application Program Interface
类库（属性和方法）
#### object
- clone() 创建并返回此对象的一个副本。
- equals(Object obj) 指示其他某个对象是否与此对象“相等”
- finalize() 当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法。
-  getClass() 返回此 Object 的运行时类。
-  hashCode()   返回该对象的哈希码值。
-  notify()   唤醒在此对象监视器上等待的单个线程。
-  notifyAll() 唤醒在此对象监视器上等待的所有线程。 这两个是对象方法，与线程有关
-  toString() 返回该对象的字符串表示。
- wait()   在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待。
-  wait(long timeout) 在其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者超过指定的时间量前，导致当前线程等待。
-  wait(long timeout, int nanos) 在其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者其他某个线程中断当前线程，或者已超过某个实际时间量前，导致当前线程等待。
- wait这三个是对象方法，与线程有关
#### String类
- String，Objiect，可以做标识符；

-   char charAt(int index)
          返回指定索引处的 char 值。
 - boolean equals(Object anObject)
          将此字符串与指定的对象比较。
 - boolean equalsIgnoreCase(String anotherString)
          将此 String 与另一个 String 比较，不考虑大小写。
- static String format(Locale l, String format, Object... args)
          使用指定的语言环境、格式字符串和参数返回一个格式化字符串。
- static String format(String format, Object... args)
          使用指定的格式字符串和参数返回一个格式化字符串。
 - byte[] getBytes()
          使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
 - byte[] getBytes(Charset charset)
          使用给定的 charset 将此 String 编码到 byte 序列，并将结果存储到新的 byte 数组。
 - void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin)
          已过时。 该方法无法将字符正确转换为字节。从 JDK 1.1 起，完成该转换的首选方法是通过 getBytes() 方法，该方法使用平台的默认字符集。
-  byte[] getBytes(String charsetName)
          使用指定的字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
 - void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
          将字符从此字符串复制到目标字符数组。
 - int hashCode()
          返回此字符串的哈希码。
 - int indexOf(int ch)
          返回指定字符在此字符串中第一次出现处的索引。
 - int indexOf(int ch, int fromIndex)
          返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索。
 - int indexOf(String str)
          返回指定子字符串在此字符串中第一次出现处的索引。
 - int indexOf(String str, int fromIndex)
          返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始。
 - String intern()
          返回字符串对象的规范化表示形式。
 - boolean isEmpty()
          当且仅当 length() 为 0 时返回 true。
 - int lastIndexOf(int ch)
          返回指定字符在此字符串中最后一次出现处的索引。
 - int lastIndexOf(int ch, int fromIndex)
          返回指定字符在此字符串中最后一次出现处的索引，从指定的索引处开始进行反向搜索。
 - int lastIndexOf(String str)
          返回指定子字符串在此字符串中最右边出现处的索引。
 - int lastIndexOf(String str, int fromIndex)
          返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索。
 - int length()
          返回此字符串的长度。
- boolean matches(String regex)
          告知此字符串是否匹配给定的正则表达式。
 - int offsetByCodePoints(int index, int codePointOffset)
          返回此 String 中从给定的 index 处偏移 codePointOffset 个代码点的索引。
 - boolean regionMatches(boolean ignoreCase, int toffset, String other,  int ooffset, int len)
          测试两个字符串区域是否相等。
 - boolean regionMatches(int toffset, String other, int ooffset, int len)
          测试两个字符串区域是否相等。
 - String replace(char oldChar, char newChar)
          返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
 - String replace(CharSequence target, CharSequence replacement)
          使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
 - String replaceAll(String regex, String replacement)
          使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
 - String replaceFirst(String regex, String replacement)
          使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
 - String[] split(String regex)
          根据给定正则表达式的匹配拆分此字符串。
 - String[] split(String regex, int limit)
          根据匹配给定的正则表达式来拆分此字符串。
 - boolean startsWith(String prefix)
          测试此字符串是否以指定的前缀开始。
-  boolean startsWith(String prefix, int toffset)
          测试此字符串从指定索引开始的子字符串是否以指定前缀开始。
 - CharSequence subSequence(int beginIndex, int endIndex)
          返回一个新的字符序列，它是此序列的一个子序列。
- String substring(int beginIndex)
          返回一个新的字符串，它是此字符串的一个子字符串。
 - String substring(int beginIndex, int endIndex)
          返回一个新字符串，它是此字符串的一个子字符串。
 - char[] toCharArray()
          将此字符串转换为一个新的字符数组。
 - String toLowerCase()
          使用默认语言环境的规则将此 String 中的所有字符都转换为小写。
 -  String toLowerCase(Locale locale)
          使用给定 Locale 的规则将此 String 中的所有字符都转换为小写。
 -  String toString()
          返回此对象本身（它已经是一个字符串！）。
 - String toUpperCase()
          使用默认语言环境的规则将此 String 中的所有字符都转换为大写。
 - String toUpperCase(Locale locale)
          使用给定 Locale 的规则将此 String 中的所有字符都转换为大写。
 - String trim()
          返回字符串的副本，忽略前导空白和尾部空白。
- static String valueOf(boolean b)
          返回 boolean 参数的字符串表示形式。
- static String valueOf(char c)
          返回 char 参数的字符串表示形式。
- static String valueOf(char[] data)
          返回 char 数组参数的字符串表示形式。
- static String valueOf(char[] data, int offset, int count)
          返回 char 数组参数的特定子数组的字符串表示形式。
- static String valueOf(double d)
          返回 double 参数的字符串表示形式。
- static String valueOf(float f) 返回 float 参数的字符串表示形式。
- static String valueOf(int i) 返回 int 参数的字符串表示形式。
- static String valueOf(long l) 返回 long 参数的字符串表示形式。
- static String valueOf(Object obj) 返回 Object 参数的字符串表示形式。
- 从类 java.lang.Object 继承的方法
clone, finalize, getClass, notify, notifyAll, wait, wait, wait
- StringBuffer,StringBuilder可变字符串类；
- StringBuffer是同步的，线程安全的；
- StringBuilder是非同步，非线程安全；
#### StringBuffer类
- StringBuffer	append(Object obj)	追加 Object 参数的字符串表示形式；
- StringBuffer	append(String str)	将指定的字符串追加到此字符序列；
#### System类
- System类的方法是静态的，有构造方法但不能使用为私有的构造方法
- static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) 从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束。
- static long currentTimeMillis()   返回以毫秒为单位的当前时间。
- static void exit(int status) 终止当前正在运行的 Java 虚拟机。
- static void gc()   运行垃圾回收器。
- static void load(String filename) 从作为动态库的本地文件系统中以指定的文件名加载代码文件。
#### Math类
- Math类方法均有static修饰
- static double ceil(double a)   返回最小的（最接近负无穷大）double 值，该值大于等于参数，并等于某个整数。
- static double floor(double a) 返回最大的（最接近正无穷大）double 值，该值小于等于参数，并等于某个整数。
- static double random() 生成随机数 返回带正号的 double 值，该值大于等于 0.0 且小于 1.0。
- static int round(float a) 四舍五入，返回最接近参数的 int。
- 返回带正号的 double 值| random() |随机数，该值大于等于 0.0 且小于 1.0； static long |round(double a)|四舍五入；小数点后由两位或两位以上，只看小数点后一位；
- (int)(Math.random() * 1001)生成0——1000之间的随机整数
#### Random类

返回 |方法 |解释
--- |--- |---
int|	nextInt()|	返回下一个伪随机数，它是此随机数生成器的序列中均匀分布的 int 值。
int|	nextInt(int n)|	返回一个伪随机数，它是取自此随机数生成器序列的、在 0（包括）和指定值（不包括）之间均匀分布的 int 值。

#### 包装类
以下八种数据类型，Character与Boolean是Object的子类；其余都是Number的子类；

序号	|基本数据类型	|包装类（封装类）
--- |
1|char|	Character
3|	short|	Short
4	|long|	Long
5	|float|	Float
6	|double|	Double
7	|boolean|	Boolean
8	|byte	|Byte

### #Date类

返回	|方法	|解释
--- |
得到当前系统日期|	Date()|	分配 Date 对象并初始化此对象，以表示分配它的时间（精确到毫秒）。
#### Calendar类
- Calendar类定义了很多常量；可以按自己的格式输出日期；

返回|	方法	|解释
--- |
static Calendar|	getInstance()|	使用默认时区和语言环境获得一个日历；注意在数月数时，计算机是从零开始数的；
#### Scanner类的方法分析

返回|	方法|	解释
--- |
String	|next()|	查找并返回来自此扫描器的下一个完整标记。
int	|nextInt()	|将输入信息的下一个标记扫描为一个 int。
### java.text
#### DateFormat类

返回|方法|解释
--- |
static DateFormat|	getDateInstance()	|获取日期格式器，该格式器具有默认语言环境的默认格式化风格。
static DateFormat|	getDateTimeInstance()|	获取日期/时间格式器，该格式器具有默认语言环境的默认格式化风格。
String|	format(Date date)|	将一个 Date 格式化为日期/时间字符串。
##### SimpleDateFormat类

返回|	方法	|解释
---  |
SimpleDateFormat(String pattern)|	用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。
StringBuffer|	format(Date date, StringBuffer toAppendTo, FieldPosition pos)	|将给定的 Date 格式化为日期/时间字符串，并将结果添加到给定的 StringBuffer。
Date|	parse(String text, ParsePosition pos)|	解析字符串的文本，生成 Date。
- 注意：带有Deprecated的方法表示已过时，不推荐使用这种方法
