# 第三天
## Apache commons
### Commons BeanUtils
- Apache Commons是一个Apache项目，专注于可重用Java组件的所有方面。

Apache Commons项目由三部分组成：
  -  Commons Proper - 可重用Java组件的存储库。
  -  Commons Sandbox - 用于Java组件开发的工作区。
  -  Commons Dormant - 当前不活动的组件库。

- BeanUtils是Apache Commons组件的成员之一，
主要用于简化JavaBean封装数据的操作。
简化反射封装参数的步骤，给对象封装参数。
好处： BeanUtils给对象封装参数的时候会进行类型自动转换。

- BeanUtils工具由Apache软件基金组织编写，提供给我们使用，主要解决的问题是：把对象的属性数据封装到对象中。在整个J2EE的编程过程中，我们经常会从各种配置文件中读取相应的数据，需要明白的一点是从配置文件中读取到的数据都是String，但是很显然我们的应用程序中不仅仅有String一种数据类型，比如：基本数据类型（int、double、char、float等），还有自定义数据类型（引用数据类型），那么我们必须面临的一个问题就是讲字符串类型转换为各种具体的数据类型，该怎么办呢？有两种方法供我们是使用：

1、首先判断需要的数据类型，然后对字符串类型调用相应的方法，将其转换为我们想要的类型

2、使用BeanUtils工具

对于上面提到的两种方法，我们分析第一种存在的问题是太过于繁琐，每次都要进行大量的类型转换，Apache软件基金会给我们提供了第二种方法，使用其提供的BeanUtils工具，具体的说只需要知道其中的两个方法就能实现类型的转换，很简单，降低了编程的难度。
- 注意：如果想自动封装数据，表单form中元素的name需要与JavaBean中的属性一致。
- BeanUtils一共分4个包：
  	org.apache.commons.beanutils
  	org.apache.commons.beanutils.converters
  	org.apache.commons.beanutils.locale
  	org.apache.commons.beanutils.locale.converters
	其中上面两个是BeanUtils的默认实现，它没有针对本地化的任何处理，这个可以提高执行效率。但是若你的程序对于本地化有要求的话，那还是使用下面2个包比较安全。

   	org.apache.commons.beanutils这个包主要提供用于操作JavaBean的工具类，Jakarta-Common-BeanUtils的主要功能都在这个包里实现。
- BeanUtils的应用场景

  1. 快速将一个JavaBean各个属性的值，赋值给具有相同结构的另一个JavaBean中。
  2. 快速收集表单中的所有数据到JavaBean中。

- BeanUtils的基本使用：导入相关JAR包，在当前目录下，创建一个目录lib，将jarr包复制到lib目录中。
- BeanUtils常用方法
      1. public static void setProperty(Object bean, String name, Object value)
      给指定对象bean的指定name属性赋值为指定值value。
      //如果指定的属性不存在，则什么也不发生。
      ​
      2.public static String getProperty(Object bean, String name)
      获取指定对象bean指定name属性的值。
      //如果指定的属性不存在，则会抛出异常。
      注意：当属性的类型是数组类型时，获取到的值数组中的第一个值。
      ​
      3.public static void copyProperties(Object dest, Object orig)    
      将对象orig的属性值赋值给对象dest对象对应的属性
      注意：只有属性名名相同且类型一致的才会赋值成功。
      ​
      4. public static void populate(Object bean, Map<String, ? extends Object>
      properties)
      将一个Map集合中的数据封装到指定对象bean中
      注意：对象bean的属性名和Map集合中键要相同。
### Commons Betwixt
	Betwixt是Apache Commons家族中又一重要的成员，它可以很容易地将一个XML的内容转化为一个JavaBean，这一点与Digester倒很相似，但它同时也可以很容易地将一个JavaBean转化为XML格式的内容。

	Commons Betwixt这个组件提供了一个XML自省(introspection)机制用来把Java Bean映射成XML信息（.xml文件或符合xml格式的字符串，下同）或者把XML信息映射成Java Bean。

### Commons Collections

- Commons Collections，又是一个重量级的东西，为Java标准的Collections API提供了相当好的补充。

- 包的结构
      org.apache.commons.collections – CommonsCollections自定义的一组公用接口和工具类
      org.apache.commons.collections.bag – 实现Bag接口的一组类
      org.apache.commons.collections.bidimap – 实现BidiMap系列接口的一组类
      org.apache.commons.collections.buffer – 实现Buffer接口的一组类
      org.apache.commons.collections.collection –实现java.util.Collection接口的一组类
      org.apache.commons.collections.comparators– 实现java.util.Comparator接口的一组类
      org.apache.commons.collections.functors –Commons Collections自定义的一组功能类
      org.apache.commons.collections.iterators – 实现java.util.Iterator接口的一组类
      org.apache.commons.collections.keyvalue – 实现集合和键/值映射相关的一组类
      org.apache.commons.collections.list – 实现java.util.List接口的一组类
      org.apache.commons.collections.map – 实现Map系列接口的一组类
      org.apache.commons.collections.set – 实现Set系列接口的一组类

- Bag--在org.apache.commons.collections包中定义的接口，它extends java.util.Collection，而它的实现类都被放在下面的bag包中。HashBag是Bag接口的一个标准实现。而BagUtils提供一组static的方法让调用者获取经过不同装饰后的Bag实例。

- Buffer--定义在org.apache.commons.collections包下面的接口，用于表示按一定顺序除去成员对象的collection如队列等。具体的实现类在org.apache.commons.collections.buffer 包下可以找到。最简单直接的Buffer实现类是UnboundedFifoBuffer，提供先进先出的大小可变的队列。而BoundedFifoBuffer则是对其大小进行了限制，是固定大小的先进先出队列。BlockingBuffer要在多线程的环境中才能体现出它的价值，尤其是当我们需要实现某种流水线时这个BlockingBuffer很有用：每个流水线上的组件从上游的BlockingBuffer获取数据，处理后放到下一个BlockingBuffer中依次传递。BlockingBuffer的核心特色通俗点说就是如果你向它要东西，而它暂时还没有的话，你可以一直等待直至拿到为止。PriorityBuffer则提供比一般的先进先出Buffer更强的控制力：我们可以自定义Comparator给它，告诉它怎么判定它的成员的先后顺序，优先级最高的最先走。此外还有执行类型检查的TypedBuffer、或者不可改变的UnmodifiableBuffer等等。

- Map -- 在java.util.Map的基础上扩展的接口和类。BidiMap，直译就是双向Map，可以通过key找到value，也可以通过value找到key，这在我们日常的代码-名称匹配的时候很方便：因为我们除了需要通过代码找到名称之外，往往也需要处理用户输入的名称，然后获取其代码。需要注意的是BidiMap当中不光key不能重复，value也不可以。MultiMap，就是说一个key不在是简单的指向一个对象，而是一组对象，add()和remove()的时候跟普通的Map无异，只是在get()时返回一个Collection，利用MultiMap，我们就可以很方便的往一个key上放数量不定的对象，也就实现了一对多。LazyMap，意思就是这个Map中的键/值对一开始并不存在，当被调用到时才创建。

- Collection -- 用也各collection之间的类型转换。典型的是TypedCollection，它实际上的作用就是提供一个decorate方法，我们传进去一个Collection和需要的类型甄别信息java.lang.Class，它给我们创建一个全新的强类型的Collection。

- Comparator--提供了一些Comparator的实现类（都在org.apache.commons.collections.comparators包下面）BooleanComparator – 用于排序一组Boolean对象，指明先true还是先false；ComparableComparator – 用于排序实现了java.lang.Comparable接口的对象（我们常用的Java类如String、Integer、Date、Double、File、Character等等都实现了Comparable接口）；ComparatorChain – 定义一组Comparator链，链中的Comparator对象会被依次执行；FixedOrderComparator – 用于定义一个特殊的顺序，对一组对象按照这样的自定义顺序进行排序；NullComparator – 让null值也可参与比较，可以设定为先null或者后null；ReverseComparator – 将原有的Comparator效果反转；TransformingComparator – 将一个Comparator装饰为具有Transformer效果的Comparator。

- Predicate -- 它以一个Object对象为参数，处理后返回一个boolean值，检验某个对象是否满足某个条件。Commons Collections也提供了一组定义好的Predicate类供我们使用，这些类都放在org.apache.commons.collections.functors包中。当然，我们也可以自定义Predicate，只要实现这个Predicate接口即可。

- Transformer -- 我们有时候需要将某个对象转换成另一个对象供另一组方法调用，而这两类对象的类型有可能并不是出于同一个继承体系的，或者说出了很基本的Object之外没有共同的父类，或者我们根本不关心他们是不是有其他继承关系，甚至就是同一个类的实例只是对我们而言无所谓，我们为了它能够被后续的调用者有意义的识别和处理，在这样的情形，我们就可以利用Transformer。除了基本的转型Transformer之外，Commons Collections还提供了Transformer链和带条件的Transformer，使得我们很方便的组装出有意义的转型逻辑。

- Closure -- 这一组接口和类提供一个操作对象的execute方法，为我们在处理一系列对象时可以将处理逻辑分离出来。ChainedClosure可以包装一组Closure作为整体执行；IfClosure在创建时需要提供给它一个Predicate和两个Closure，执行时先做Predicate判定再决定执行哪一个Closure；SwitchClosure跟SwitchTransformer类似，根据创建时传入的Predicate组和Closure组对应执行；WhileClosure则根据创建时传入的Predicate做判断，如果为true则执行Closure，直到Predicate返回false；等等。

- Iterator -- java.util.Iterator接口定义了标准的Collection遍历方法，但是如果不做改变的使用它，我们得到的是从头到尾一次性的遍历。假如我们需要循环遍历，假如我们需要遍历某一段，假如我们需要遍历满足某些条件的元素，等等等等，我们就不能完全依赖于这个Iterator的标准实现了。除非我们宁可在此基础上在调用的代码中多加一些判断，不过这样的话代码就会显得混乱，时间长了就容易变得难以维护。Commons Collections的这一组Iterator为我们带来了便利。
### Commons io
- Commons-io是一款处理io流的工具，封装了很多处理io流和文件的方法，可以大大简化我们处理io流和操作文件的代码。从common-io的官方使用文档可以看出，它主要分为工具类、尾端类、行迭代器、文件过滤器、文件比较器和扩展流。

- Commons-io是一款处理io流的工具，封装了很多处理io流和文件的方法，可以大大简化我们处理io流和操作文件的代码。从common-io的官方使用文档可以看出，它主要分为工具类、尾端类、行迭代器、文件过滤器、文件比较器和扩展流。

Commons IO是一个帮助开发IO功能的实用程序库。

- 主要包括六个方面：
  - 1.实用程序类 - 使用静态方法执行常见任务
  - 2.输入 - 有用的输入流和读取器实现
  - 3.输出 - 有用的输出流和写入器实现
  - 4.过滤器 - 文件过滤器的各种实现
  - 5.比较器 - 用于文件的java.util.Comparator的各种实现
  - 6.文件监视器 - 用于监视文件系统事件的组件
- Commons-IO包含 实用程序类， endian类， 行迭代器， 文件过滤器， 文件比较器和 流实现。
###### 工具类
- IOUtils
IOUtils包含了用来处理读、写、复制的工具方法。这些方法基于 InputStream，OutputStream ， Reader ， Writer运行。
例：一个从URL读取字节并将其打印的任务，典型的实现代码如下：

      InputStream in  = new URL("http://commons.apache.org").openStream();

      try{

           InputStreamReader inR = new InputStreamReader(in);

           BufferedReader buf = new BufferedReader(inR);

           String line;

            while( ( line = buf.readLine() ) != null ){

                      System.out.println( line );

             }

      }finally{

              in.close();

      }

而通过IOUtils类，实现如下：

    InputStream in = new URL( "http://commons.apache.org" ).openStream();

    try{

          System.out.println( IOUtils.toString( in ) );

    }finally{

          IOUtils.closeQuietly( in );

    }


- FileUtils
包含了与File对象一起工作的工具方法。这些方法包括读、写、复制、比较文件。
比如，一行一行的读取整个文件你可能会这样实现：

      File file = new File("/commons/io/project.properties");
      List lines = FileUtils.readLines(file,"UTF-8");
- FilenameUtils
包含了不使用File对象操作文件名的工具类方法。这个类的主旨是使Unix和Windows一致，为了帮助这些环境之间的过渡（比如说开发环境和生产环境）。
比如为了规范化的去除两个点的路径：

      String filename = "C:/commons/io/../lang/project.xml";
      String normalized = FilenameUtils.normalize(filename);    //结果是  "C:/commons/lang/project.xml"
- FileSystemUtils
包含了一系列不被jdk支持的操作文件系统的工具方法。现在，唯一的方法是用来获取磁盘剩余空间。注意这使用的是命令行而不是native代码。

     例：long freeSpace = FileSystemUtils.freeSpace("C:/");

- Endian classes
不同的计算机架构包含了不同的byte ordering的习惯。在被称作“Little Endian”的架构（比如Intel）上，low-order byte被存储在内存的最低地址，并且随后的字节在高位地址。对于“Big Endian”架构，情况恰好相反。

    - 这个包中有两个类与之相关：

       - EndianUtils
      类包含了用于交换Java primitives和streams的Endian-ness的静态方法。

       - SwappedDataInputStream
      类是一个DataInput接口的实现，通过这个类，用户可以读取文件数据而不需理会Endian-ness。
- Line iterator
org.apache.commons.io.LineIterator类提供了一种弹性的方式来操作line-based的文件。LineIterator的实例可以通过FileUtils或者IOUtils的钢厂方法直接创建。
  - 推荐的使用方式是：
        LineIterator it = FileUtils.lineIterator(file,"UTF-8");
        try{
             while( it.hasNext() ){
             String line = it.nextLine();    //do something with line
        }
        }finally{
              LineIterator.closeQuietly(it);
        }
- File filters
  包org.apache.commons.io.filefilter定义了一个接口IOFileFilter
合并了java.io.FileFilter和java.io.FilenameFilter。并且这个包提供了一系列随时取用的IOFileFilter的实现。这些实现允许你合并其他类似的过滤器。
比如，这些过滤器可以用来list files或者FileDialog

- File comparators
包org.apache.commons.io.comparator为java.io.File提供了java.util.Comparator的一些实现。
比如这些比较器可以被用来给文件列表排序。

- Streams
包org.apache.commons.io.input和org.apache.commons.io.output packages包含了各种有用的流的实现。内容如下：
      Null output stream - 会静默的接收发送给它的数据
      Tee output stream - 发送output数据给两个流而不是一个
      Byte array output stream - 这是一个比JDK类更快的版本
      Counting streams - 查出经过的字节数
      Proxy streams - proxy中的正确方法的delegate
      Lockable writer - 使用锁文件提供同步写操作

### Commons lang
- Apache Commons lang包提供了标准Java库函数里没有提供的Java核心类的操作方法。Apache Commons Lang为java.lang API提供了大量的辅助工具，尤其是在String操作方法。
###### StringUtils
- 如何判断字符串为空的情况？

      String a=null；
      if(a!=null && a!=""){}
需要判断的地方有很多，代码累赘
- StringUtils ： 该类主要提供对字符串的操作,对null是安全的,主要提供了字符串查找,替换,分割,去空白,去掉非法字符等等操作
    //        1.public static boolean isEmpty(String str)
    //        判断某字符串是否为空，为空的标准是str == null 或 str.length() == 0
    //        下面是示例：
      System.out.println(StringUtils.isEmpty(null));// true
      System.out.println(StringUtils.isEmpty(""));// true
      System.out.println(StringUtils.isEmpty(" "));// false
      System.out.println(StringUtils.isEmpty("        "));// false
      System.out.println(StringUtils.isEmpty("bob"));// false
      System.out.println(StringUtils.isEmpty(" bob "));// false
      // 2.public static boolean isNotEmpty(String str)
      //判断某字符串是否非空，等于!isEmpty(String str)
      //下面是示例：
      System.out.println(StringUtils.isNotEmpty(null));// false
      System.out.println(StringUtils.isNotEmpty(""));// false
      System.out.println(StringUtils.isNotEmpty(" "));// true
      System.out.println(StringUtils.isNotEmpty("         "));// true
      System.out.println(StringUtils.isNotEmpty("bob"));// true
      System.out.println(StringUtils.isNotEmpty(" bob "));// true
      //3. public static boolean isBlank(String str)
      //判断某字符串是否为空或长度为0或由空白符(whitespace)构成
      ///下面是示例：
      StringUtils.isBlank(null);// true
      StringUtils.isBlank("");// true
      StringUtils.isBlank(" ");// true
      StringUtils.isBlank("        ");// true
      System.out.println(StringUtils.isBlank("\t \n \f \r"));// true
      System.out.println(StringUtils.isBlank("\b"));// false
      System.out.println(StringUtils.isBlank(" bob "));// false
      //4. public static boolean isNotBlank(String str)
      //判断某字符串是否不为空且长度不为0且不由空白符(whitespace)构成，
      //等于!isBlank(String str)
      // 下面是示例：
      System.out.println(StringUtils.isNotBlank(null));       // false
      System.out.println(StringUtils.isNotBlank(""));               // false
      System.out.println(StringUtils.isNotBlank(" "));          // false
      System.out.println(StringUtils.isNotBlank("         "));        //false
      System.out.println(StringUtils.isNotBlank("\t \n \f \r"));     // false
      System.out.println(StringUtils.isNotBlank("\b"));              // true
      System.out.println(StringUtils.isNotBlank("bob"));           // true
      System.out.println(StringUtils.isNotBlank(" bob "));   // true
      //5. public static String trim(String str)
      //去掉字符串两端的控制符(control characters, char <= 32)
      //如果输入为null则返回null
      //下面是示例：
      System.out.println(StringUtils.trim(null));                // null
      System.out.println(StringUtils.trim(""));                 // ""
      System.out.println(StringUtils.trim(" "));                          // ""
      System.out.println(StringUtils.trim("     \b \t \n \f \r    ")); // ""
      System.out.println(StringUtils.trim("     \n\tss   \b"));       // "ss"
      System.out.println(StringUtils.trim(" d   d dd     "));     // "d   d dd"
      System.out.println(StringUtils.trim("dd     "));            // "dd"
      System.out.println(StringUtils.trim("     dd       "));           // "dd"
      //6.public static String trimToNull(String str)
      //去掉字符串两端的控制符
      //如果变为null或""，则返回null
      //下面是示例：
      StringUtils.trimToNull(null);                // null
      StringUtils.trimToNull("");                           // null
      StringUtils.trimToNull(" ");                          // null
      StringUtils.trimToNull("     \b \t \n \f \r    "); // null
      StringUtils.trimToNull("     \n\tss   \b");     // "ss"
      StringUtils.trimToNull(" d   d dd     ");        // "d   d dd"
      StringUtils.trimToNull("dd     ");           // "dd"
      StringUtils.trimToNull("     dd       ");          // "dd"


      System.out.println(StringUtils.contains("defg", "ef"));//检查一字符串是否包含另一字符串.
      System.out.println(StringUtils.containsOnly("ef", "defg"));//检查一字符串是否为另一字符串的子集

      System.out.println("去除字符中的空格.");
      System.out.println(StringUtils.deleteWhitespace("aa  bb  cc"));//aabbcc

      System.out.println("分隔符处理成数组.");
      String[] strArray = StringUtils.split("a,b,,c,d,null,e", ",");
      System.out.println(strArray.length);//6

      System.out.println("缩短到某长度,用...结尾.");
      System.out.println(StringUtils.abbreviate("The quick brown fox jumps over the lazy dog.", 10));//The qui...
      System.out.println(StringUtils.abbreviate("The quick brown fox jumps over the lazy dog.", 15, 10));//... fox...
- ArrayUtils
ArrayUtils 提供了数组的复制,查找,获取子数组,反转等功

      //判断数组是否为空(null和length=0的时候都为空)
      ArrayUtils.isEmpty(new int[0]);// true
      ArrayUtils.isEmpty(new Object[] { null });// false

      //合并两个数组
      ArrayUtils.addAll(new int[] { 1, 3, 5 }, new int[] { 2, 4 });// {1,3,5,2,4}

      //删除数组中某个位置上的数据
              ArrayUtils.remove(new int[] { 1, 3, 5 }, 1);// {1,5}

      // 删除数组中某个对象(从正序开始搜索,删除第一个)
      ArrayUtils.removeElement(new int[] { 1, 3, 5 }, 3);// {1,5}

      //Null处理,如果输入的两个数组都为null时候则返回true
      ArrayUtils.isEquals(new int[] { 1, 2, 3 }, null);// false
      ArrayUtils.isEquals(null, null);// true

      //查询某个Object是否在数组中
      ArrayUtils.contains(new int[] { 3, 1, 2 }, 1);// true

      //输出数组中的元素内容
      ArrayUtils.toString(new int[] { 1, 4, 2, 3 });// {1,4,2,3}
      ArrayUtils.toString(new Integer[] { 1, 4, 2, 3 });// {1,4,2,3}
      ArrayUtils.toString(null, "I'm nothing!");// I'm nothing!
- DateUtils和DateFormatUtils

DateUtils 主要提供了对日期的操作,包括日期加减,日期格式化,日期比较等。它们在org.apache.commons.lang.time包下。
  - 1.与SUN的SimpleDateFormat相比 ，其主要优点是：线程安全。
  - 2.对应于SimpleDateFormat的format()的方法，是DateFormatUtils 的format系列方法，常用的就是：
        public static String format(Date date, String pattern)
  - 3.对应与SimpleDateFormat的parse()的方法，是DateUtils的parseDate方法，即：
        public static Date parseDate(String dateValue) throws DateParseException
  - 4.日期舍入与截整，DateUtils的truncate()方法可以将日期按照任意范围截整，关键看第二个参数。
        public static Date truncate(Date date, int field)
第二个参数取自Calendar的常量，可以是MONTH、DATE、HOUR等多种；
  -  5.判断是否是同一天，DateUtils的isSameDay()方法
       public static boolean isSameDay(Date date1, Date date2)
  - 6.DateFormatUtils定义了很多内置的固定日期格式，均为FastDateFormat类型，比如 ISO_DATE_FORMAT。使用 FastDateFormat的format()方法可以直接将日期格式化为内置的固定格式。
        public String format(Date date)。
、、
        //常用日期格式的格式化操作：
        //以 yyyy-MM-dd 格式化:
        System.out.println(DateFormatUtils.ISO_DATE_FORMAT.format(new Date()));//2017-06-17
        //以 yyyy-MM-dd'T'HH:mm:ss 格式化:
        System.out.println(DateFormatUtils.ISO_DATETIME_FORMAT.format(new Date()));//2017-06-17T12:51:18
        //以 HH:mm:ss 格式化:
        System.out.println(DateFormatUtils.ISO_TIME_NO_T_FORMAT.format(new Date()));//12:51:18

        //自定义日期格式的格式化操作：
        // 以 yyyy-MM-dd HH:mm:ss 格式化Date对象:
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));//2017-06-17 12:51:18
        //以 yyyy-MM-dd HH:mm:ss 格式化Calendar对象:
        System.out.println(DateFormatUtils.format(Calendar.getInstance(), "yyyy-MM-dd HH:mm:ss"));//2017-06-17 12:51:18
        //以 yyyy-MM-dd HH:mm:ss 格式化TimeInMillis:
        System.out.println(DateFormatUtils.format(Calendar.getInstance().getTimeInMillis(), "yyyy-MM-dd HH:mm:ss"));//2017-06-17 12:51:18

-  BooleanUtils用来操作基础布尔或者布尔对象，很多方法在工作中可以经常使用。
### Commons Validator
- 以电子方式或从用户输入接收数据时的常见问题是验证数据的完整性。当需要将不同的验证规则集应用于基于区域设置的同一组数据时，这项工作是重复的，并且变得更加复杂。错误消息也可能因区域设置而异。该软件包解决了其中一些问题，以加快验证规则的开发和维护。
- alidator提供两组不同的功能：
    - 1.可配置（通常为XML）验证引擎
    - 2.可重复使用的“原始”验证方法
 - 您的验证方法将插入引擎并根据您的数据执行。通常，这些方法使用特定于一个应用程序或框架的资源，因此Commons Validator不直接提供可插入的验证器操作。但是，它确实有一组常用的验证方法（电子邮件地址，日期，URL等），有助于创建可插入的操作
 commons-validator（通用验证系统）,它使用了一个xml文件来定义针对用户输入的数据验证功能，整个验证体系提供了很强的扩展性，使得开发者可以开发自己的验证函数加入到这个验证体系中来。它对web应用程序提供了客户端javascript验证和服务端验证的两种选择，但是它只是一个验证体系，有些东西还需要自己开发特别是validatoraction的开发。
	整个Validator框架可以有若干个FormSet，而每个FormSet又可以有若干个Form，每个Form中可以有若干个Field。FormSet的process(...)方法，逐个调用其中的Form的process(...)方法，而Form的process(...)方法又是逐个调用Field的process(...)方法。Validator类作为验证的起始点，调用与其一一对应的Form的validate(...)方法，而Form的validate(...)方法又是逐个调用其中Field的validate(...)方法实现的。
配置文件说明：
            <form-validation>
               <global>
              <constant>
            <constant-name>验证方法的标志名</constant-name>
            <constant-value>正则表达式</constant-value>
            </constant>
                  <validator name="这个验证方法的标志名，供下面的depends调用"
            classname="这个验证方法在哪个类中，为类全名"
            method="验证方法的名称"
            methodParams="这个验证方法需要的参数类型，依次以逗号格开，为类全名"
            depends="基于什么验证之上，可以为多个值，以逗号格开，值为方法的标志名"
            jsFunction="js的方法全名，格式为文件路径.方法名。文件路径以点隔开，如果不填，默认为org.apache.commons.validator.javascript.xxxx"
            msg="对应于properties文件中的一条，作为不通过验证时返回的信息"/>
            </global>
               <formset language="语言" country="城市" variant="方言？">
                  <constant>
                    <constant-name>验证方法的标志名</constant-name>
                    <constant-value>正则表达式</constant-value>
                  </constant>
                  <form name="bean 对象名称">
                     <field property="bean中的属性名"  depends="需要什么样的验证，可以为多个值，以逗号格开，值为方法的标志名">
                       <arg name = "变量名" key = "properties文件的key，或者来自Var的name" resource = "是/否来自资源文件"/>
                       <var>
                         <var-name>变量名</var-name>
                         <var-value>变量值</var-value>
                       </var>
                     </field>
                  </form>
               </formset>  
            </form-validation>
## 设计模式
###  工厂模式
- 工厂模式可以分为三类：
  -  1）简单工厂模式（Simple Factory）
  -  2）工厂方法模式（Factory Method）
  -  3）抽象工厂模式（Abstract Factory）
- 工厂方法模式与抽象工厂模式的区别：
  - 工厂方法模式只有一个抽象产品类，而抽象工厂模式有多个。
  - 工厂方法模式的具体工厂类只能创建一个具体产品类的实例，而抽象工厂模式可以创建多个。
-  使用场景：消费者不关心它所要创建对象的类(产品类)的时候、消费者知道它所要创建对象的类（产品类），但不关心如何创建的时候，等等。
- 模式要素：
        - 1. 提供一个产品类的接口。产品类均要实现这个接口(也可以是abstract类，即抽象产品)。
        -    2.提供一个工厂类的接口。工厂类均要实现这个接口(即抽象工厂)。
        - 3.由工厂实现类创建产品类的实例。工厂实现类应有一个方法，用来实例化产品类。
- 抽象工厂模式的优点

  抽象工厂模式除了具有工厂方法模式的优点外，最主要的优点就是可以在类的内部对产品族进行约束。所谓的产品族，一般或多或少的都存在一定的关联，抽象工厂模式就可以在类内部对产品族的关联关系进行定义和描述，而不必专门引入一个新的类来进行管理。
- 抽象工厂模式的缺点

   产品族的扩展将是一件十分费力的事情，假如产品族中需要增加一个新的产品，则几乎所有的工厂类都需要进行修改。所以使用抽象工厂模式时，对产品等级结构的划分是非常重要的。
- 适用场景:

   当需要创建的对象是一系列相互关联或相互依赖的产品族时，便可以使用抽象工厂模式。说的更明白一点，就是一个继承体系中，如果存在着多个等级结构（即存在着多个抽象类），并且分属各个等级结构中的实现类之间存在着一定的关联或者约束，就可以使用抽象工厂模式。假如各个等级结构中的实现类之间不存在关联或约束，则使用多个独立的工厂来对产品进行创建，则更合适一点。
- 总结

  无论是简单工厂模式，工厂方法模式，还是抽象工厂模式，他们都属于工厂模式，在形式和特点上也是极为相似的，他们的最终目的都是为了解耦。
### 单例模式
- 定义：单例模式，是一种常用的软件设计模式。在它的核心结构中只包含一个被称为单例的特殊类。通过单例模式可以保证系统中，应用该模式的类一个类只有一个实例。即一个类只有一个对象实例。
- 要点：显然单例模式的要点有三个；一是某个类只能有一个实例；二是它必须自行创建这个实例；三是它必须自行向整个系统提供这个实例。
- 主要解决：一个全局使用的类频繁地创建与销毁。
- 何时使用：当您想控制实例数目，节省系统资源的时候。
- 如何解决：判断系统是否已经有这个单例，如果有则返回，如果没有则创建。
- 关键代码：构造函数是私有的。
- 优点

  -   一、实例控制
    单例模式会阻止其他对象实例化其自己的单例对象的副本，从而确保所有对象都访问唯一实例。
  -   二、灵活性
    因为类控制了实例化过程，所以类可以灵活更改实例化过程。
- 缺点
  - 一、开销
虽然数量很少，但如果每次对象请求引用时都要检查是否存在类的实例，将仍然需要一些开销。可以通过使用静态初始化解决此问题。
  - 二、可能的开发混淆
使用单例对象（尤其在类库中定义的对象）时，开发人员必须记住自己不能使用new关键字实例化对象。因为可能无法访问库源代码，因此应用程序开发人员可能会意外发现自己无法直接实例化此类。
  - 三、对象生存期
不能解决删除单个对象的问题。在提供内存管理的语言中（例如基于.NET Framework的语言），只有单例类能够导致实例被取消分配，因为它包含对该实例的私有引用。在某些语言中（如 C++），其他类可以删除对象实例，但这样会导致单例类中出现悬浮引用。
## Springframework基础
### 控制反转（Ioc）、依赖注入
- 理论背景：为了解决对象之间的耦合度过高的问题，软件专家Michael Mattson提出了IOC理论，用来实现对象之间的“解耦”，目前这个理论已经被成功地应用到实践当中，很多的J2EE项目均采用了IOC框架产品Spring。
- 什么是控制反转(Ioc)？

IOC是Inversion of Control的缩写，即“控制反转”，不是什么技术，而是一种设计思想。在Java开发中，Ioc意味着将你设计好的对象交给容器控制，而不是传统的在你的对象内部直接控制。
- loc的作用：Ioc 不是一种技术，只是一种思想，一个重要的面向对象编程的法则，它能指导我们如何设计出松耦合、更优良的程序。传统应用程序都是由我们在类内部主动创建依赖对象，从而导致类与类之间高耦合，难于测试；有了IoC容器后，把创建和查找依赖对象的控制权交给了容器，由容器进行注入组合对象，所以对象与对象之间是 松散耦合，这样也方便测试，利于功能复用，更重要的是使得程序的整个体系结构变得非常灵活。
	- 其实Ioc对编程带来的最大改变不是从代码上，而是从思想上，发生了“主从换位”的变化。应用程序原本是老大，要获取什么资源都是主动出击，但是在Ioc/DI思想中，应用程序就变成被动的了，被动的等待Ioc容器来创建并注入它所需要的资源了。
- loc很好的体现了面向对象设计法则，即由Ioc容器帮对象找相应的依赖对象并注入，而不是由对象主动去找。
##### loc和DI
	- DI—Dependency Injection，即“依赖注入”：组件之间依赖关系由容器在运行期决定，形象的说，即由容器动态的将某个依赖关系注入到组件之中。依赖注入的目的并非为软件系统带来更多功能，而是为了提升组件重用的频率，并为系统搭建一个灵活、可扩展的平台。通过依赖注入机制，我们只需要通过简单的配置，而无需任何代码就可指定目标需要的资源，完成自身的业务逻辑，而不需要关心具体的资源来自何处，由谁实现。

- 理解DI的关键是：“谁依赖谁，为什么需要依赖，谁注入谁，注入了什么”：
　　 - 谁依赖于谁：当然是应用程序依赖于IoC容器；
　　 - 为什么需要依赖：应用程序需要IoC容器来提供对象需要的外部资源；
　　 -  谁注入谁：很明显是IoC容器注入应用程序某个对象，应用程序依赖的对象；
　　 - 注入了什么：就是注入某个对象所需要的外部资源（包括对象、资源、常量数据）。
- IoC和DI由什么关系呢？

  其实它们是同一个概念的不同角度描述，由于控制反转概念比较含糊，所以2004年大师级人物Martin Fowler又给出了一个新的名字：“依赖注入”，相对IoC 而言，“依赖注入”明确描述了“被注入对象依赖IoC容器配置依赖对象”。
### 面向切面编程AOP
- AOP实现可分为两类（按AOP框架修改源代码的时机）：

  - 静态AOP实现：AOP框架在编译阶段对程序进行修改，即实现对目标类的增强，生成静态的AOP代理类（生成的*.class文件已经被改掉了，需要使用特定的编辑器）。以AspectJ为代表。

  - 动态AOP实现：AOP框架在运行阶段动态生成AOP代理（在内存中以JDK动态代理或cglib动态代理生成AOP代理类）。以实现对目标类的增强。以Spring AOP为代表。
- AOP框架具有如下两个特征：
    - 个步骤之间的良好隔离性。
    - 源代码无关性。
- 关于面向切面编程的一些术语：
      1.切面（Aspect）：切面用于组织多个Advice，Advice放在切面中定义。
      2.连接点（Joinpoint）：程序执行过程中明确的点，如方法的调用，或者异常的抛出。在Spring AOP中，连接点总是方法的调用。
      3.增强处理（Advice）：AOP框架在特定的点执行的增强处理。处理有“before”，“around”，“after”等。
      4.切入点（Pointcut）：可以插入增强处理的连接点。简而言之，当某个连接点满足指定要求时，该连接点将被添加增强处理，该连接点也就变成了切入点。
      5、通知（advice）
      所谓通知指的就是指拦截到连接点之后要执行的代码，通知分为前置、后置、异常、最终、环绕通知五类
      6、目标对象
      代理的目标对象
      7、织入（weave）
      将切面应用到目标对象并导致代理对象创建的过程
      8、引入（introduction）
      在不修改代码的前提下，引入可以在运行期为类动态地添加一些方法或字段
- Spring中的使用

Spring中AOP代理由Spring的IOC容器负责生成、管理，其依赖关系也由IOC容器负责管理。因此，AOP代理可以直接使用容器中的其它bean实例作为目标，这种关系可由IOC容器的依赖注入提供。

- Spring创建代理的规则为：

    - 1、默认使用Java动态代理来创建AOP代理，这样就可以为任何接口实例创建代理了
    -  2、当需要代理的类不是代理接口的时候，Spring会切换为使用CGLIB代理，也可强制使用CGLIB
- 应用范围

很明显，AOP非常适合开发J2EE容器服务器，JBoss 4.0正是使用AOP框架进行开发。
- 具体功能如下：
      Authentication 权限
      Caching缓存
      Context passing内容传递
      Error handling 错误处理
      Lazy loading 延时加载
      Debugging 调试
      logging, tracing, profiling and monitoring 记录跟踪 优化 校准
      Performance optimization性能优化
      Persistence 持久化
      Resource pooling资源池
      Synchronization 同步
      Transactions事务

- 最常见的一些横切行为如下面这些：
      1.日志记录，跟踪，优化和监控
      2.事务的处理
      3.持久化
      4.性能的优化
      5.资源池，如数据库连接池的管理
      6.系统统一的认证、权限管理等
      7.应用系统的异常捕捉及处理
      8.针对具体行业应用的横切行为
- 实现项目

    AOP是一个概念，并没有设定具体语言的实现，它能克服那些只有单继承特性语言的缺点（如Java），AOP具体实现有以下几个项目：
    - AspectJ (TM)： 创建于Xerox PARC. 有近十年历史，成熟
缺点：过于复杂；破坏封装；需要专门的Java编译器。
    - 动态AOP：使用JDK的动态代理API或字节码Bytecode处理技术。
    - 基于动态代理API的具体项目有：
JBoss 4.0 JBoss 4.0服务器
    - 基于字节码的项目有：
aspectwerkz ，spring
## 序列化
#### jdk 原生：ObjectOutputStream
  当创建对象时,程序运行时它就会存在,但是程序停止时,对象也就消失了.但是如果希望对象在程序不运行的情况下仍能存在并保存其信息，将会非常有用，对象将被重建并且拥有与程序上次运行时拥有的信息相同。可以使用对象的序列化。

   对象的序列化： 将内存中的对象直接写入到文件设备中

   对象的反序列化： 将文件设备中持久化的数据转换为内存对象

  基本的序列化由两个方法产生：一个方法用于序列化对象并将它们写入一个流，另一个方法用于读取流并反序列化对象。

  ObjectOutput
  writeObject(Object obj)
            将对象写入底层存储或流。
  ObjectInput
  readObject()
            读取并返回对象。

  ObjectOutputStream的使用步骤:
        1、找到目标文件
        2、建立数据的输出流通道，需要准备一个FileOutputStream流
        3、建立对象的输出流通道
        4、把对象写出去
        5、关闭资源
  对象输入输出流使用需要注意的细节：

      1、如果对象需要被写出到文件上，那么对象所属的类必须要实现Serializable接口，Serializable接口没有任何的方法，是一个标志接口。
      2、对象的反序列化和对象的克隆，创建对象的时候，并不会调用构造方法。
      3、serialVersionUID是用于记录class文件的版本信息的，serialVersionUID这个数字是通过一个类的类名，成员，包名，工程名算出来的一个数字。
      4、使用ObjectInputStream反序列化的时候，ObjectInputStream会先读取文件中的serialVersionUID与本地的serialVersionUID对比，如果不一致反序列化失败
      5、如果反序列化的时候可能会修改类的成员，那么最好一开始就给这个类，指定一个serialVersionUID，如果一个类已经指定了serialVersionUID，然后在序列化和反序列化的时候，jvm都不会自己计算这个class的serialVersionUID了。这样就不怕无法序列化和反序列化了。点击累前面的黄色箭头，添加一个serialVersionUID
      6、如果一个对象的某个数据不想序列化到硬盘上，可以使用关键字transient修饰
      7、如果一个类，维护了另外一个类的引用，另外一个类，也需要实现Serializable接口。如果无法修改这个类的源码，可以给这个类创建一个可序列化的子类。如果这个类是final的也就是不可以继承的。那么就在使用trancint关键字，或者是指定serialVersionUID。
###  Xml：JAXB、XStream
- Java Architecture for XML Binding (JAXB) 是一个业界的标准，是一项可以根据XML Schema产生Java类的技术。该过程中，JAXB也提供了将XML实例文档反向生成Java对象树的方法，并能将Java对象树的内容重新写到XML实例文档。从另一方面来讲，JAXB提供了快速而简便的方法将XML模式绑定到Java表示，从而使得Java开发者在Java应用程序中能方便地结合XML数据和处理函数。

- JAXB和XStream比较

  这两东西本质上是有差别的，JAXB称为OX binding工具，XStream应该算序列化工具，但OX binding工具也会marshall和unmarshall，所以包含了序列化这一部分。序列化工具不一定需要提供binding的功能。
      JAXB: 优点
      •	J2EE标准
      •	运行时间比XStream少
      缺点
      •	用起来不方便：需要把手动的把business object转换成schema object，当然也可以直接将schema object作为business object，或者采用反射的方法。
      •	有一定的局限性：需要schema或者annotation
      •	数据量稍大
      XStream优点：
      •	用起来方便
      •	不需要schema，拿过来就转
      •	数据量稍小
      缺点：
      •	非标准
      •	时间性能差
### json：jackson、fastjson
- FastJSON与Jackson比较
      调用方便性而言：
      •	FastJSON提供了大量静态方法，调用简洁方便
      •	Jackson须实例化类，调用相对繁琐，可通过封装成JSON工具类简化调用

- 性能而言：
      •	FastJSON反序列化的性能略差，对于256k的json字符串，平均700ms
      •	Jackson 的 data binding反序列化的性能稍好，对于256k的json字符串，平均600ms
      •	两者的序列化性能基本相同，对于256k的json字符串，平均140ms
      •	相对data binding方式（ObjectMapper.writeValueAsString()），Jackson的流输出方式（JsonGenerator.writeObject()）性能稍好，平均130ms
#### spring OXM
-  O/X Mapper 是什么？  
      Spring 3.0 的一个新特性是 O/X Mapper。O/X 映射器这个概念并不新鲜，O 代表 Object，X 代表 XML。它的目的是在 Java 对象（几乎总是一个 plain old Java object，或简写为 POJO）和 XML 文档之间来回转换。

      例 如，您可能有一个带有几个属性的简单 bean，且您的业务需要将那个 Java 对象转换为一个 XML 文档。Spring 的 O/X Mapper 能够为您解决那个问题。如果反过来，您需要将一个 XML 文档转换为一个简单 Java bean，Spring 的 O/X Mapper 也能胜任。

      有一点需要注意：Spring O/X Mapper 只是定义由流行的第三方框架实现的统一的界面。要利用 Spring 的 O/X 功能，您需要一个在 Java 对象和 XML 之间来回转换的实用程序。Castor 就是这样一个流行的第三方工具，本文将使用这个工具。其他这样的工具包括 XMLBeans、Java Architecture for XML Binding (JAXB)、JiBX 和 XStream。
-  编组和解组

      进行 O/X 映射时，您经常会看到编组（marshalling）和解组（unmarshalling） 这两个术语。

      编组 指将 Java bean 转换成 XML 文档的过程，这意味着 Java bean 的所有字段和字段值都将作为 XML 元素或属性填充到 XML 文件中。有时，编组也称为序列化（serializing）。

      如您所料，解组 是与编组完全相反的过程，即将 XML 文档转换为 Java bean，这意味着 XML 文档的所有元素或属性都作为 Java 字段填充到 Java bean 中。有时，解组也称为反序列化（deserializing）。
- 使用 Spring 的 O/X Mapper 的好处

      使 用 Spring 的 O/X Mapper 的一个最直接的好处是可以通过利用 Spring 框架的其他特性简化配置。Spring 的 bean 库支持将实例化的 O/X 编组器注入（即前面提到过的 “依赖项注入”）使用那些编组器的对象。重申一遍，这将加快应用程序开发和部署。

      遵循坚实的面向对象的设计实践，Spring O/X 框架只定义两个接口：Marshaller 和 Unmarshaller，它们用于执行 O/X 功能，这是使用这个框架的另一个重大好处。这些接口的实现完全对独立开发人员开放，开发人员可以轻松切换它们而无需修改代码。例如，如果您一开始使用 Castor 进行 O/X 转换，但后来发现它缺乏您需要的某个功能，这时您可以切换到 XMLBeans 而无需任何代码更改。唯一需要做的就是更改  Spring 配置文件以使用新的 O/X 框架。

      使用 Spring 的 O/X Mapper 的另一个好处是统一的异常层次结构。Spring 框架遵循使用它的数据访问模块建立的模式，方法是将原始异常对象包装到 Spring 自身专为 O/X Mapper 建立的运行时异常中。由于第三方提供商抛出的原始异常被包装到 Spring 运行时异常中，您能够查明出现异常的根本原因。您也不必费心修改代码以捕获异常，因为异常已包装到一个运行时异常中。以下几个运行时异常扩展了基础异常  XMLMappingException：GenericMarshallingFailureException、 ValidationFailureException、MarshallingFailureException 和 UnmarshallingFailureException。
## Springframework高级
###  Spring Cache
-  缓存是实际工作中非经常常使用的一种提高性能的方法, 我们会在很多场景下来使用缓存。

      Spring 3.1 引入了激动人心的基于凝视（annotation）的缓存（cache）技术，它本质上不是一个具体的缓存实现方案（比如EHCache 或者 OSCache），而是一个对缓存使用的抽象，通过在既有代码中加入少量它定义的各种 annotation，即能够达到缓存方法的返回对象的效果。
      Spring 的缓存技术还具备相当的灵活性。不仅能够使用 SpEL（Spring Expression Language）来定义缓存的 key 和各种 condition，还提供开箱即用的缓存暂时存储方案，也支持和主流的专业缓存比如 EHCache 集成。

-   其特点总结例如以下：
        •	通过少量的配置 annotation 凝视就可以使得既有代码支持缓存
        •	支持开箱即用 Out-Of-The-Box，即不用安装和部署额外第三方组件就可以使用缓存
        •	支持 Spring Express Language，能使用对象的不论什么属性或者方法来定义缓存的 key 和 condition
        •	支持 AspectJ，并通过事实上现不论什么方法的缓存支持
        •	支持自己定义 key 和自己定义缓存管理者，具有相当的灵活性和扩展性
        和 spring 的事务管理类似，spring cache 的关键原理就是 spring AOP，通过 spring AOP，其实现了在方法调用前、调用后获取方法的入参和返回值，进而实现了缓存的逻辑。
###  Spring Cache redis
      ehcache集群因为节点之间数据同步通过组播的方式，可能带来的问题：节点间大量的数据复制带来额外的开销，在节点多的情况下此问题越发严重，N个节点会出现N-1次网络传输数据进行同步。
      redis主备由于作为中心节点提供缓存，其他节点都向redis中心节点取数据，所以，一次网络传输即可。（当然此处的一次网络代价跟组播的代价是不一样的）但是，随着访问量增大，大量的缓存数据访问使得应用服务器和缓存服务器之间的网络I/O消耗越大。
      两级缓存的思想诞生了，在redis的方案上做一步优化，在缓存到远程redis的同时，缓存一份到本地进程ehcache（此处的ehcache不用做集群，避免组播带来的开销），取缓存的时候会先取本地，没有会向redis请求，这样会减少应用服务器<–>缓存服务器redis之间的网络开销
### Spring MongoDB
      MongoDB是最为流行的开源文档数据库之一。Spring Data MongoDB提供了三种方式在Spring应用中使用MongoDB：
      •	通过注解实现对象-文档映射；
      •	使用MongoTemplate实现基于模板的数据库访问；
      •	自动化的运行时Repository生成功能。
      •	启用MongoDB
          为了有效的使用Spring Data MongoDB，我们需要在Spring配置中添加几个必要的bean。首先，我们需要配置MongoClient，用它来创建Mongo实例，以便于访问MongoDB数据库。在这里，我们使用Spring Data MongoDB的MongoFactoryBean更加简单。因为它是一个工厂bean，会负责构建Mongo实例，而且不用处理MongoClient构造器所抛出的UnknownHostException异常。同时，我们还需要有一个MongoTemplate bean，实现基于模板的数据库访问。此外，不是必须，但是强烈推荐启用Spring Data MongoDB的自动化Repository生成功能。
      1、pom.xml
        pom.xml
      2、MongoConfig.java 配置类配置方式
        MongoConfig.java
      3、applicationContext.xml XML配置方式
        applicationContext.xml
      •	注解实现对象文档映射
          Spring Data MongoDB 提供了一套对象-文档 映射的注解。
      @Document - 用于类，以表示这个类需要映射到数据库，您也可以指定映射到数据库的集合名称
      @Id - 用于字段级别，标记这个字段是一个主键，默认生成的名称是“_id”
        @DBRef - 用于字段，以表示它将使用com.mongodb.DBRef进行存储。
        @Indexed - 用于字段，表示该字段需要如何创建索引
        @CompoundIndex - 用于类，以声明复合索引
        @GeoSpatialIndexed - 用于字段，进行地理位置索引
        @TextIndexed - 用于字段，标记该字段要包含在文本索引中
        @Field - 用于字段，并描述字段的名称，因为它将在MongoDB BSON文档中表示，允许名称与该类的字段名不同。
        @Version - 用于字段锁定，保存操作时检查修改。初始值是0，每次更新时自动触发。
        @Language - 用于字段，以设置文本索引的语言覆盖属性。
        @Transient - 默认情况下，所有私有字段都映射到文档，此注解将会去除此字段的映射
        @PersistenceConstructor - 标记一个给定的构造函数，即使是一个protected修饰的，在从数据库实例化对象时使用。构造函数参数通过名称映射到检索的DBObject中的键值。
          Order.java
-  MongoOperations
      我们已经配置好了MongoTemplate，接下来，需要做的就是将其注入到使用它的地方。注意，在这里我们将MongoTemplate注入到一个类型为MongoOperations的属性中。MongoOperations 是 MongoTemplate 所实现的接口，不直接使用具体实现是一个好的习惯。
         1、 MongoOperations 暴露了多个使用MongoDB文档数据库的方法。这里介绍几个最为常用的操作：
      •	计算集合的数量
              long order = mongoOperations.getCollection("order").count();
      •	保存文档
              Order order = new Order();
              mongoOperations.save(order, "order");
      •	根据文档的 _id 查找文档
              Order byId = mongoOperations.findById("5abb2a6303238760a48e3fd2", Order.class);
      •	得到所有文档
              List<Order> all = mongoOperations.findAll(Order.class);
      •	删除文档
              Order order = new Order();
              order.setId("1");
              mongoOperations.remove(order);
-  MongoOperations 最常见的用法还是接受一个 Query 对象作为参数进行查询、修改、删除的操作。
