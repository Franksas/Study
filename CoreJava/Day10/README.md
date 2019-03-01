# 第十天笔记
### 数组
- 结束循环的三种手段 return; break； System.exit(0);
- 内存单元地址单一的 == 比的是值，复合类型比的是地址
- 数组创建的时候是有初始值的，数字都是0，布尔型是false ,所有复合类型都是Null
- int c[];//数组声明时不能指定大小 c = new int[10];//数组的长度在创建时候指定
- 数组定义后只能放单一的数组
- length//属性 length //方法
- 如何定义数组? int a[] = new int[5]; int [] b = new int[3]; int [] b2 = {2,3,4};//ok int [] b3 = new int[]{2,3,4};
- 如何遍历数组？ for (int i = 0; i < b3.length; i++) { System.out.println(b3[i]);//遍历数组 }
- 如何初始化你（动态初始化和静态初始化）？ for (int i = 0; i< b3.length; i++) { b3[i] = 2 * i + 23;//动态初始化 } b3[2] = 900;//静态初始化
- 数组排序（冒泡排序）
- 内存的存放问题
- 数组的第一维必须指定，第二维无所谓
- OOP封装：保护数据（属性私有） java语言单继承
- java.lang.object 所有类的顶级父类
