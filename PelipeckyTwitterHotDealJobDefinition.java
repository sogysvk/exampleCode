package com.pelicantravel.definitions.pelipecky;

import com.pelicantravel.definitions.JobDefinition;
import com.pelicantravel.jobs.pelipecky.PelipeckyTwitterHotDealJob;
import org.quartz.*;

/**
 * @author Marek Tomas on 15.10.2019
 */
public class PelipeckyTwitterHotDealJobDefinition implements JobDefinition {

	@Override
	public void registerJob(Scheduler scheduler) throws SchedulerException {
		JobDetail job = JobBuilder.newJob(PelipeckyTwitterHotDealJob.class)
				.withIdentity("pelipeckyTwitterHotDeal", "pelipecky")
				.build();

		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("pelipeckyTwitterHotDealJob", "pelipecky")
				.startNow()
				.withSchedule(DailyTimeIntervalScheduleBuilder
						.dailyTimeIntervalSchedule()
						.startingDailyAt(TimeOfDay.hourAndMinuteOfDay(05, 00))
						.endingDailyAt(TimeOfDay.hourAndMinuteOfDay(23, 00))
						.withIntervalInMinutes(3)
//						.withIntervalInHours(3)
				)
				.build();

		scheduler.scheduleJob(job, trigger);
	}

}
