package com.github.miniapps.scheduling;

import java.util.Set;
import java.util.HashSet;

/* Scheduling that repeats every month in some specific days of the month */
public class MonthlyScheduling extends Scheduling {

	private Set<Integer> monthDays;

	public MonthlyScheduling() {
		super();
		this.monthDays = new HashSet<Integer>();
	}

	public Set<Integer> getMonthDays() {
		return this.monthDays;
	}

	public void setMonthDay(Set<Integer> monthDays) {
		this.monthDays = monthDays;
	}

	public void addMonthDay(Integer monthDay) {
		if ((monthDay >= 1) && (monthDay <= 31)) {
			monthDays.add(monthDay);
		}
	}

	public void removeMonthDay(Integer monthDay) {
		monthDays.remove(monthDay);
	}

}
