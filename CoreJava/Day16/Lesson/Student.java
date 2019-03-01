/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
/**
 equals方法分析
@author yinhansong
@version  1.0
*/

public class Student {
    String name;
    int age = 19;
    int grade = 2;

    public Student(String name,int age,int grade) {
    	this.name = name;
    	this.age = age;
    	this.grade = grade;
    }


    @Override
	public boolean equals(Object obj) {
    	if (this == obj)
			   return true;
		  if (obj == null)
			   return false;
		  if (getClass() != obj.getClass())
			   return false;
		     Student other = (Student) obj;
		  if (age != other.age)
		   	return false;
		  if (grade != other.grade)
		   	return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public String toString() {
	    return  "name = " + name + "  age = " + age + " grade = " + grade;
	}


	public static void main(String [] args) {
    	 Student s1 = new Student("wanglei", 20, 3);
    	 Student s2 = new Student("wanglei", 20, 3);
    	 String str1 = "xdf";//字符串常量池
    	 String str3 = "xdf";
    	 String str4 = "中国,山西,太原工业学院,尹汉松";
    	 String str6 = "made in china.";
    	 String sr = str6.substring(2,2);
         System.out.println(str6.trim());
         System.out.println(sr);//""


         String [] str5 = str4.split(",");
         for (String x : str5) {
             System.out.println(x);
         }
         System.out.println(str4.length());
         String str2 = new String("xdf");
         System.out.println(str1 == str2);
         System.out.println(str1 == str3);
         System.out.println(str1.equals(str2));

          /*str1.equals(str2);
          System.out.println(s1);
          System.out.println(s1.hashCode());
          System.out.println(s1 == s2);
          System.out.println(s1.equals(s2));
          System.out.println(s1.equals(s1));*/
     }
 }
