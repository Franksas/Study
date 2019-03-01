/*
 * 英才汇硕信息科技有限公司版权所有  @2018
 */
package com.ychs168.corejava;
/**
简化的自定义异常
@author yinhansong
@version  1.0
*/

public class SelfDefineException extends Exception {

	public SelfDefineException() {
		super();
	}

	public SelfDefineException(String message) {
		super(message);
	}

}
