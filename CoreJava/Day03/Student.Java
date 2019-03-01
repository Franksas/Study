/*
 英才科技版权所有 2018
 */
 /**
 @author yinhansong
 @version 1.0
 */
 public class Student {
     String name;
     int age = 19;
     double height;
     String sex = "女";
     public Student() {}
     public Student(String n,int a) {
         name = n;
         age = a;
     }
     public Student(String n,int a,double h,String s){
         name = n;
         age = a;
         height = h;
         sex = s;
     }

    public void sayHello() {
      System.out.println ("你好");
    }
    public String bite(){
      return "疼";
    }
    public String bitel(String name) {
      System.out.println(name + "被咬了。");
      return name + "喊;疼";
    }
    public static void main(String[] args) {
        Student zhangsan =  new Student();//创建对象
       zhangsan.sayHello();//对象调用方法
       String result1 = zhangsan.bite();
       System.out.println(result1);
       String result2 = zhangsan.bitel("王主任");
       System.out.println(result2);

       //构造方法使用代码示例
       Student lisi = new Student("李四",21);
       System.out.println(lisi.name);
       System.out.println(lisi.age);
       System.out.println(lisi.sex);
       System.out.println(lisi.height);
       System.out.println("---------------");

       Student wangwu = new Student("王五",18,1.75,"男");
       System.out.println(wangwu.name);
       System.out.println(wangwu.age);
       System.out.println(wangwu.sex);
       System.out.println(wangwu.height);
       System.out.println("---------------");

    }
 }
