package cn.org.pomer.utils;

import javax.xml.ws.Endpoint;

/*
 * @(#)Test	Jul 9, 2008
 *
 * Copyright 2008 FIRMLINK, All rights reserved.
 * FIRMLINK PROPRIETARY/CONFIDENTIAL. 
 * http://www.firmlink.com.cn
 */

/**
 * 
 * @author Linlin Yu
 * @version 1.0
 */
public class Test {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9895/ddd", new TestServices());
	}
}
