/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
/**

@author yinhansong
@version  1.0
*/
public class TestSelfException {
	public void example() throws SelfDefineException {
		int a = 0;
        if (a == 0) {
       	 throw new SelfDefineException("自定义异常...");
        }
	}
	public static void main(String[] args) {
		TestSelfException ts = new TestSelfException();
		try {
			ts.example();
		} catch (SelfDefineException e) {
			 System.out.println(e.getMessage());
		}
	}
}
