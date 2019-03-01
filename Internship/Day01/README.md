# 第一天
## JDK高级
### 类加载器Classloader
- 概念：类加载器是使得Java类可以被动态加载到Java虚拟机中并执行。
- Java虚拟机使用Java类的方式：Java源程序(.java文件)在经过Java编译器编译之后就被转换成Java字节码(.class文件)。
- 类加载器是负责加载类的对象。ClassLoader类是一个抽象类。每个Class对象都包含一个对定义它的Classloader的引用。应用程序需要实现ClassLoaderd 的子类，以扩展Java虚拟机动态类的方式。
-  数组类的Class对象不是由类加载器创建的，而是由Java运行时根据需要自动创建。数组类的类加载器由Class.getClassLoader()返回，该加载器与其元素类型的类加载器是相同的；如果该元素类型是基本类型，则该数组类没有类加载器。
- ClassLoader类使用委托模型来搜索类和资源。
- Java应用环境中不同的class分别由不同的ClassLoader负责加载。
一个JVM中默认的classloader有BootstrapClassLoader、Extension ClassLoader、AppClassLoader、CustomClassLoader,分别各司其职：
BootstrapClassLoader
      负责加载java基础类，主要是%JRE_HOME/lib/目录下的rt.jar、resources.jar、charsets.jar和class等.
  ExtensionClassLoader   
      负责加载java扩展类，主要是%JRE_HOME/lib/ext 目录下的jar和class
  AppClassLoader          
      负责加载当前java应用的classpath中的所有类。
Custom ClassLoader（自定义ClassLoader）    

    由于一些特殊的需求，我们可能需要定制ClassLoader的加载行为，这时候就需要自定义ClassLoader了.自定义ClassLoader需要继承ClassLoader抽象类，重写findClass方法，这个方法定义了ClassLoader查找class的方式。

主要可以扩展的方法有：

    findClass         定义查找Class的方式

    defineClass      将类文件字节码加载为jvm中的class

    findResource   定义查找资源的方式

- 其中Bootstrap ClassLoader是JVM级别的，由C++撰写；ExtensionClassLoader、App ClassLoader都是java类，都继承自URLClassLoader超类。
- Bootstrap ClassLoader由JVM启动，然后初始化sun.misc.Launcher ，sun.misc.Launcher初始化ExtensionClassLoader、App ClassLoader。
- ClassLoader 中与加载类相关的方法
          getParent() 	返回该类加载器的父类加载器。
          loadClass(String name) 	加载名称为 name的类，返回的结果是 java.lang.Class类的实例。
          findClass(String name) 	查找名称为 name的类，返回的结果是 java.lang.Class类的实例。
          findLoadedClass(String name) 	查找名称为 name的已经被加载过的类，返回的结果是 java.lang.Class类的实例。
          defineClass(String name, byte[] b, int off, int len) 	把字节数组 b中的内容转换成 Java 类，返回的结果是 java.lang.Class类的实例。这个方法被声明为final的。
          resolveClass(Class<?> c) 	链接指定的 Java 类。
- 为什么要使用双亲委托这种模型呢？
       因为这样可以避免重复加载，当父类已经加载了该类的时候，就没有必要子类ClassLoader再加载一次。考虑到安全因素，我们试想一下，如果不使用这种委托模式，那我们就可以随时使用自定义的String来动态替代java核心api中定义的类型，这样会存在非常大的安全隐患，而双亲委托的方式，就可以避免这种情况，因为String已经在启动时就被引导类加载器（Bootstrcp ClassLoader）加载，所以用户自定义的ClassLoader永远也无法加载一个自己写的String，除非你改变JDK中ClassLoader搜索类的默认算法。
- 既然JVM已经提供了默认的类加载器，为什么还要定义自已的类加载器呢？
      因为Java中提供的默认ClassLoader，只加载指定目录下的jar和class，如果我们想加载其它位置的类或jar时，比如：我要加载网络上的一个class文件，通过动态加载到内存之后，要调用这个类中的方法实现我的业务逻辑。在这样的情况下，默认的ClassLoader就不能满足我们的需求了，所以需要定义自己的ClassLoader。
- 定义自已的类加载器分为两步：
      1、继承java.lang.ClassLoader
      2、重写父类的findClass方法
### 反射 Reflact
- 概念：反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性，这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。
- 一直以来反射技术都是Java中的闪亮点，这也是目前大部分框架(如Spring/Mybatis等)得以实现的支柱。在Java中，Class类与java.lang.reflect类库一起对反射技术进行了全力的支持。在反射包中，我们常用的类主要有Constructor类表示的是Class 对象所表示的类的构造方法，利用它可以在运行时动态创建对象、Field表示Class对象所表示的类的成员变量，通过它可以在运行时动态修改成员变量的属性值(包含private)、Method表示Class对象所表示的类的成员方法，通过它可以动态调用对象的方法(包含private)。
### 注解 Annotation
- Java 注解用于为 Java 代码提供元数据。作为元数据，注解不直接影响你的代码执行，但也有一些类型的注解实际上可以用于这一目的。Java 注解是从 Java5 开始添加到 Java 的。
- 注解的定义
注解通过 @interface 关键字进行定义。

    public @interface TestAnnotation {
    }

它的形式跟接口很类似，不过前面多了一个 @ 符号。上面的代码就创建了一个名字为 TestAnnotaion 的注解。
你可以简单理解为创建了一张名字为 TestAnnotation 的标签。
- 注解的应用
上面创建了一个注解，那么注解的的使用方法是什么呢。

      @TestAnnotation
      public class Test {
      }
创建一个类 Test,然后在类定义的地方加上 @TestAnnotation 就可以用 TestAnnotation 注解这个类了。
你可以简单理解为将 TestAnnotation 这张标签贴到 Test 这个类上面。

- 元注解是什么意思呢？
    元注解是可以注解到注解上的注解，或者说元注解是一种基本注解，但是它能够应用到其它的注解上面。
- 元标签有 @Retention、@Documented、@Target、@Inherited、@Repeatable 5 种。
- @Retention
    Retention 的英文意为保留期的意思。当 @Retention 应用到一个注解上的时候，它解释说明了这个注解的的存活时间。
它的取值如下：
  - RetentionPolicy.SOURCE 注解只在源码阶段保留，在编译器进行编译时它将被丢弃忽视。
  - RetentionPolicy.CLASS 注解只被保留到编译进行的时候，它并不会被加载到 JVM 中。
  - RetentionPolicy.RUNTIME 注解可以保留到程序运行的时候，它会被加载进入到 JVM 中，所以在程序运行时可以获取到它们。
- @Documented
顾名思义，这个元注解肯定是和文档有关。它的作用是能够将注解中的元素包含到 Javadoc 中去。
- @Target

Target 是目标的意思，@Target 指定了注解运用的地方。

你可以这样理解，当一个注解被 @Target 注解时，这个注解就被限定了运用的场景。

类比到标签，原本标签是你想张贴到哪个地方就到哪个地方，但是因为 @Target 的存在，它张贴的地方就非常具体了，比如只能张贴到方法上、类上、方法参数上等等。@Target 有下面的取值

    ElementType.ANNOTATION_TYPE 可以给一个注解进行注解
    ElementType.CONSTRUCTOR 可以给构造方法进行注解
    ElementType.FIELD 可以给属性进行注解
    ElementType.LOCAL_VARIABLE 可以给局部变量进行注解
    ElementType.METHOD 可以给方法进行注解
    ElementType.PACKAGE 可以给一个包进行注解
    ElementType.PARAMETER 可以给一个方法内的参数进行注解
    ElementType.TYPE 可以给一个类型进行注解，比如类、接口、枚举

- @Inherited

Inherited 是继承的意思，但是它并不是说注解本身可以继承，而是说如果一个超类被 @Inherited 注解过的注解进行注解的话，那么如果它的子类没有被任何注解应用的话，那么这个子类就继承了超类的注解。
说的比较抽象。代码来解释。

    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @interface Test {}
    @Test
    public class A {}
    public class B extends A {}
注解 Test 被 @Inherited 修饰，之后类 A 被 Test 注解，类 B 继承 A,类 B 也拥有 Test 这个注解。
- @Repeatable
Repeatable 自然是可重复的意思。@Repeatable 是 Java 1.8 才加进来的，所以算是一个新的特性。
- 举个例子，一个人他既是程序员又是产品经理,同时他还是个画家。
    @interface Persons {
        Person[]  value();
    }
    @Repeatable(Persons.class)
    @interface Person{
        String role default "";
    }
    @Person(role="artist")
    @Person(role="coder")
    @Person(role="PM")
    public class SuperMan{

    }
- 注意上面的代码，@Repeatable 注解了 Person。而 @Repeatable 后面括号中的类相当于一个容器注解。

什么是容器注解呢？就是用来存放其它注解的地方。它本身也是一个注解。

我们再看看代码中的相关容器注解。

@interface Persons {
    Person[]  value();
}

按照规定，它里面必须要有一个 value 的属性，属性类型是一个被 @Repeatable 注解过的注解数组，注意它是数组。
###### 注解的属性
-   注解的属性也叫做成员变量。注解只有成员变量，没有方法。注解的成员变量在注解的定义中以“无形参的方法”形式来声明，其方法名定义了该成员变量的名字，其返回值定义了该成员变量的类型。
      @Target(ElementType.TYPE)
      @Retention(RetentionPolicy.RUNTIME)
      public @interface TestAnnotation {

          int id();

          String msg();

      }
上面代码定义了 TestAnnotation 这个注解中拥有 id 和 msg 两个属性。在使用的时候，我们应该给它们进行赋值。

赋值的方式是在注解的括号内以 value=”” 形式，多个属性之前用 ，隔开。

    @TestAnnotation(id=3,msg="hello annotation")
    public class Test {
    }
- 需要注意的是，在注解中定义属性时它的类型必须是 8 种基本数据类型外加 类、接口、注解及它们的数组。
- 如果一个注解内仅仅只有一个名字为 value 的属性时，应用这个注解时可以直接接属性值填写到括号内。

      public @interface Check {
          String value();
      }

上面代码中，Check 这个注解只有 value 这个属性。所以可以这样应用。

    @Check("hi")
    int a;
######  Java 预置的注解
- @Deprecated
这个元素是用来标记过时的元素，想必大家在日常开发中经常碰到。编译器在编译阶段遇到这个注解时会发出提醒警告，告诉开发者正在调用一个过时的元素比如过时的方法、过时的类、过时的成员变量。
- @Override
这个大家应该很熟悉了，提示子类要复写父类中被 @Override 修饰的方法
- @SuppressWarnings
阻止警告的意思。之前说过调用被 @Deprecated 注解的方法后，编译器会警告提醒，而有时候开发者会忽略这种警告，他们可以在调用的地方通过 @SuppressWarnings 达到目的。
- @SafeVarargs
参数安全类型注解。它的目的是提醒开发者不要用参数做一些不安全的操作,它的存在会阻止编译器产生 unchecked 这样的警告。它是在 Java 1.7 的版本中加入的。
- @FunctionalInterface
函数式接口注解，这个是 Java 1.8 版本引入的新特性。函数式编程很火，所以 Java 8 也及时添加了这个特性。
- 注解与反射。
注解通过反射获取。首先可以通过 Class 对象的 isAnnotationPresent() 方法判断它是否应用了某个注解

    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {}

然后通过 getAnnotation() 方法来获取 Annotation 对象。

     public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {}

或者是 getAnnotations() 方法。
      public Annotation[] getAnnotations() {}

前一种方法返回指定类型的注解，后一种方法返回注解到这个元素上的所有注解。

如果获取到的 Annotation 如果不为 null，则就可以调用它们的属性方法了。
- 需要注意的是，如果一个注解要在运行时被成功提取，那么 @Retention(RetentionPolicy.RUNTIME) 是必须的。
- 注解的使用场景
  注解是一系列元数据，它提供数据用来解释程序代码，但是注解并非是所解释的代码本身的一部分。注解对于代码的运行效果没有直接影响。
  注解有许多用处，主要如下：
  - 提供信息给编译器： 编译器可以利用注解来探测错误和警告信息
  - 编译阶段时的处理： 软件工具可以用来利用注解信息来生成代码、Html文档或者做其它相应处理。
  - 运行时的处理： 某些注解可以在程序运行的时候接受代码的提取
######  注解应用的场景
  - JUnit 测试
  - ButterKnife是 Android 开发中大名鼎鼎的 IOC 框架，它减少了大量重复的代码
  - Dagger2也是一个很有名的依赖注入框架。
  - Retrofit 很牛逼的 Http 网络访问框架

### 代理（jdk proxy、CGlib）
##### 动态代理
- 使用动态代理的五大步骤
  - 1.通过实现InvocationHandler接口来自定义自己的InvocationHandler;
  - 2.通过Proxy.getProxyClass获得动态代理类
  - 3.通过反射机制获得代理类的构造方法，方法签名为getConstructor(InvocationHandler.class)
  - 4.通过构造函数获得代理对象并将自定义的InvocationHandler实例对象传为参数传入
  - 5.通过代理对象调用目标方法
- 动态代理有以下特点:
    -  1、代理对象,不需要实现接口
    -  2、代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象(需要我们指定创建代理对象/目标对象实现的接口的类型)
    -  3、动态代理也叫做:JDK代理,接口代理
-  JDK中生成代理对象的API
  	代理类所在包:java.lang.reflect.Proxy
  	JDK实现代理只需要使用newProxyInstance方法,但是该方法需要接收三个参数,完整的写法是：
          static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,InvocationHandler h )
- 注意：
该方法是在Proxy类中是静态方法,且接收的三个参数依次为：
	- ClassLoader loader：指定当前目标对象使用类加载器,获取加载器的方法是固定的
	- Class<?>[] interfaces：目标对象实现的接口的类型,使用泛型方式确认类型
	- InvocationHandler h：事件处理,执行目标对象的方法时,会触发事件处理器的方法,会把当前执行目标对象的方法作为参数传入
- 总结:代理对象不需要实现接口,但是目标对象一定要实现接口,否则不能用动态代理。
- 代理模式
  - 使用代理模式必须要让代理类和目标类实现相同的接口，客户端通过代理类来调用目标方法，代理类会将所有的方法调用分派到目标对象上反射执行，还可以在分派过程中添加"前置通知"和后置处理（如在调用目标方法前校验权限，在调用完目标方法后打印日志等）等功能。
- 代理模式的适用，总结为：代理类主要负责为委托类预处理消息、过滤消息、把消息转发给委托类，以及事后处理消息等
- 代理模式的用途，可以分为如下几种（From GOF）:
  - (1)远程代理(Remote Proxy)  ---A remote proxy provides a local representative for an object in a different address space.为远程对象提供一个本地的代理对象， 典型的例子如RMI， EJB，local bean 为remote 接口对象提供一个stub

  - (2)虚拟代理(Virtual Proxy) –  A virtual proxy creates expensive objects on demand.允许内存开销较大的对象在需要的时候创建。只有我们真正需要这个对象的时候才创建。
  - (3)写入时复制代理(Copy-On-Write Proxy) – 用来控制对象的复制，方法是延迟对象的复制，直到客户真的需要为止。是虚拟代理的一个变体。

  - (4)保护代理(Protection (Access)Proxy) –  A protection proxy controls access to the original object. Protection proxies are useful when objects should have different access rights.为不同的客户提供不同级别的目标对象访问权限

   - (5)缓存代理(Cache Proxy) – 为开销大的运算结果提供暂时存储，它允许多个客户共享结果，以减少计算或网络延迟。

  - (6)防火墙代理(Firewall Proxy) – 控制网络资源的访问，保护主题免于恶意客户的侵害。

  - (7)同步代理(SynchronizationProxy) –在多线程的情况下为主题提供安全的访问。

  - (8)智能引用代理(Smart ReferenceProxy) -  A smart reference is a replacement for a bare pointer that performs additional actions when an object is accessed。当一个对象被引用时，提供一些额外的操作，比如将对此对象调用的次数记录下来等。

  - (9)复杂隐藏代理(Complexity HidingProxy) – 用来隐藏一个类的复杂集合的复杂度，并进行访问控制。有时候也称为外观代理(Façade Proxy)，这不难理解。复杂隐藏代理和外观模式是不一样的，因为代理控制访问，而外观模式是不一样的，因为代理控制访问，而外观模式只提供另一组接口。
-  按照代理创建的时期，可以分为动态代理和静态代理：

- 静态代理：由程序员或者自动生成工具生成代理类，然后进行代理类的编译和运行。在代理类、委托类运行之前，代理类已经以.class的格式存在。

 - 静态代理：在程序运行时，由反射机制动态创建而成。
##### CGlib代理
- 静态代理和动态代理模式都是要求目标对象是实现一个接口的目标对象,但是有时候目标对象只是一个单独的对象,并没有实现任何的接口,这个时候就可以使用以目标对象子类的方式类实现代理,这种方法就叫做:CGlib代理。
	- 1、JDK的动态代理有一个限制,就是使用动态代理的对象必须实现一个或多个接口,如果想代理没有实现接口的类,就可以使用CGlib实现。
	- 2、CGlib是一个强大的高性能的代码生成包,它可以在运行期扩展java类与实现java接口.它广泛的被许多AOP的框架使用,例如Spring AOP和synaop,为他们提供方法的interception(拦截)。
	- 3、CGlib包的底层是通过使用一个小而快的字节码处理框架ASM来转换字节码并生成新的类.不鼓励直接使用ASM,因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉。
- CGlib子类代理实现方法:
	- 1、需要引入cglib的jar文件,但是Spring的核心包中已经包括了Cglib功能,所以直接引入pring-core-3.2.5.jar即可。
	- 2、引入功能包后,就可以在内存中动态构建子类
	- 3、	代理的类不能为final,否则报错
	- 4、目标对象的方法如果为final/static,那么就不会被拦截,即不会执行目标对象额外的业务方法.代理,也叫作子类代理,它是在内存中构建一个子类对象从而实现对目标对象功能的扩展。
- 在Spring的AOP编程中：
如果加入容器的目标对象有实现接口,用JDK代理
如果目标对象没有实现接口,用CGlib代理
- CGlib代理与JDK中的代理比较:
- JDK动态代理: 只能代理实现了接口的类
没有实现接口的类不能实现JDK动态代理。
- CGlib代理: 针对类来实现代理,对指定目标
产生一个子类 通过方法拦截技术拦截所有父类方法的调用。
我们要使用cglib代理必须引入 cglib的jar包
###### jdk proxy和CGlib动态代理的原理区别：
- jdk动态代理:

  利用拦截器(拦截器必须实现InvocationHanlder)加上反射机制生成一个实现代理接口的匿名类，在调用具体方法前调用InvokeHandler来处理。

- CGlib动态代理:

  利用ASM开源包，对代理对象类的class文件加载进来，通过修改其字节码生成子类来处理。


- 何时使用jdk proxy还是CGlib？

  - 1、如果目标对象实现了接口，默认情况下会采用jdk的动态代理实现AOP。

  - 2、如果目标对象实现了接口，可以强制使用CGlib实现AOP。

  - 3、如果目标对象没有实现了接口，必须采用CGlip库，Spring会自动在jdk动态代理和CGlib之间转换。

- 如何强制使用CGlib实现AOP？

  - 1、添加CGlib库(aspectjrt-xxx.jar、aspectjweaver-xxx.jar、cglib-nodep-xxx.jar)

  - 2、在Spring配置文件中加入<aop:aspectj-autoproxy proxy-target-class="true"/>

- jdk动态代理和CGlib字节码生成的区别？

  - 1、jdk动态代理只能对实现了接口的类生成代理，而不能针对类。

  - 2、CGlib是针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法，并覆盖其中方法实现增强，但是因为采用的是继承，所以该类或方法最好不要声明成final，对于final类或方法，是无法继承的。

- CGlib比JDK快？

  - 1、使用CGLib实现动态代理，CGLib底层采用ASM字节码生成框架，使用字节码技术生成代理类，在jdk6之前比使用Java反射效率要高。唯一需要注意的是，CGLib不能对声明为final的方法进行代理，因为CGLib原理是动态生成被代理类的子类。

  - 2、在jdk6、jdk7、jdk8逐步对JDK动态代理优化之后，在调用次数较少的情况下，JDK代理效率高于CGLIB代理效率，只有当进行大量调用的时候，jdk6和jdk7比CGLIB代理效率低一点，但是到jdk8的时候，jdk代理效率高于CGLIB代理，总之，每一次jdk版本升级，jdk代理效率都得到提升，而CGLIB代理消息确有点跟不上步伐。

- Spring如何选择用JDK还是CGLiB？

    - 1、当Bean实现接口时，Spring就会用JDK的动态代理。

    - 2、当Bean没有实现接口时，Spring使用CGlib是实现。

    - 3、可以强制使用CGlib（在spring配置中加入<aop:aspectj-autoproxy proxy-target-class="true"/>）。
