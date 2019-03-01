public class PersonTest {
    public static void main(String [] args) {
        Person p = new Person(21,"zhangsan","ty");
        System.out.println(p);
        PersonTest pt = new PersonTest();
        pt.test1(p);
    }
    public void test1(Person per) {
        //Person px = per;
        per = new Person(18,"lisi","shandong");
    }
}
class Person {
    int age = 19;
    String name = "hello";
    String addr;
    public Person(){}
    public Person(int a,String n,String ad) {
        age = a;
        name = n;
        addr = ad;
    }
}
