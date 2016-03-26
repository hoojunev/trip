package cn.itcast.nsfw.complain;

import java.util.Timer;


public class MyTimer {

	public static void main(String[] args) {
		
		Timer timer = new Timer();
		//延迟1秒，每2秒执行一次
		timer.schedule(new MyTimerTask(), 1000, 2000);
	}

}
