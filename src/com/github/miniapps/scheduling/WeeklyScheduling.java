package com.github.miniapps.scheduling;

import java.util.Set;
import java.util.HashSet;

/* Scheduling that repeats every week in some specific days of the week */
public class WeeklyScheduling extends Scheduling {

	private Set<Integer> weekDays;

	public WeeklyScheduling() {
		super();
		this.weekDays = new HashSet<Integer>();
	}

	public Set<Integer> getWeekDays() {
		return this.weekDays;
	}

	public void setWeekDays(Set<Integer> weekDays) {
		this.weekDays = weekDays;
	}

	public void addWeekDay(Integer weekDay) {
		if ((weekDay >= 1) && (weekDay <= 7)) {
			weekDays.add(weekDay);
		}
	}

	public void removeWeekDay(Integer weekDay) {
		weekDays.remove(weekDay);
	}

}
