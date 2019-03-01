/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
import java.util.Scanner;


/**
按照控制台提示输入1～3之间任一个数字，程序将输出相应的课程名称
根据键盘输入进行判断。如果输入正确，输出对应课程名称。如果输入错误，给出错误提示
不管输入是否正确，均输出“欢迎提出建议”语句

@author yinhansong
@version  1.0
*/

public class Course {
	 public void test() {
	       System.out.println("请输入一个正整数n:");
	       Scanner sc = new Scanner(System.in);
	       int n = sc.nextInt();
	      // if(n >= 1 && n<4){
		       try {
			    	if (n == 1) {
			    	   System.out.println("语文");
			        }else if (n == 2) {
			        	System.out.println("数学");
			        }else if (n == 3) {
			        	System.out.println("英语");
			        } else {
			        	throw new Exception();
			        }

		       } catch (Exception e) {
					e.printStackTrace();
					System.out.println("输入错误！");
				} finally {
					System.out.println("欢迎提出建议!");
				}

		}

	 public static void main(String[] args) {
		Course s = new Course();
		s.test();
	}


}
