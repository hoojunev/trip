package cn.itcast.nsfw.complain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuartzTask {

	public void doSimpleTriggerTask() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("doing simpleTriggerTask..." + sdf.format(new Date()));
	}
	public void doCronTriggerTask() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("doing cronTriggerTask..." + sdf.format(new Date()));
	}
}
