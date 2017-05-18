package quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzWithCron {

	public static void main(String[] args) throws SchedulerException {

		// 触发器详情
		JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group1").build();

		// 创建触发器
		Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("* * * ? * *"))
				.build();

		SchedulerFactory schedFact = new StdSchedulerFactory();
		Scheduler sched = schedFact.getScheduler();

		// 将任务和触发器联系在一起
		sched.scheduleJob(job, trigger);

		// 启动任务
		sched.start();
	}

}
