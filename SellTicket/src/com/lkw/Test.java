package com.lkw;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试类
 * 
 * @author kwliu
 * @date 2016年6月6日 下午2:10:19
 * @version 1.0
 */
public class Test {
	public static void main(String[] args) {
		// 初始化票库，为100张票设置票号，设置方法由客户决定。这里票号格式为：No.20160000+序号
		List<String> tickets = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			tickets.add("No.20160000" + i);
		}
		Ticket t = new Ticket(tickets);

		// 用5个线程模拟5个售票点
		Thread sale1 = new Thread(t, "售票点A");
		Thread sale2 = new Thread(t, "售票点B");
		Thread sale3 = new Thread(t, "售票点C");
		Thread sale4 = new Thread(t, "售票点D");
		Thread sale5 = new Thread(t, "售票点E");

		sale1.start();
		sale2.start();
		sale3.start();
		sale4.start();
		sale5.start();
	}
}
