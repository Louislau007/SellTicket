package com.lkw;

import java.util.List;

/**
 * @author kwliu
 * @date 2016年6月6日 下午2:09:57
 * @version 1.0
 */
class Ticket extends Thread {
	private List<String> tickets;
	private boolean sellout = false;

	public Ticket(List<String> tickets) {
		this.tickets = tickets;
	}

	private synchronized void sell() {
		if (tickets.size() <= 0) {
			sellout = true;
			return;
		}
		// 随机挑一张票售出
		int index = (int) (Math.random() * tickets.size());
		System.out.println(Thread.currentThread().getName() + "卖了一张票，票号为："
				+ tickets.get(index) + "。");
		// 票库中删去已售出的票
		tickets.remove(index);
	}

	public void run() {
		while (sellout==false) {
			sell();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
