package quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

public class HelloWorldQuartz {

	public static void main(String[] args) throws SchedulerException {

		// 定义任务详情
		JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group1").build();

		// 定义简单的触发器
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();

		// 创建任务调度类
		SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();
		Scheduler sched = schedFact.getScheduler();

		// 将任务详情和触发器联系在一起
		sched.scheduleJob(job, trigger);

		// 开启任务
		sched.start();
	}
}
