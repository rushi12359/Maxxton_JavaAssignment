package com.dateMerge;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateRange implements Comparable<DateRange> {

	private String startDate;
	private String endDate;

	public DateRange() {
		super();
	}

	public DateRange(String startDate, String endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public boolean equals(Object obj) {

		DateRange dateRange = (DateRange) obj;

		return this.getStartDate().equals(dateRange.getStartDate()) && this.getEndDate().equals(dateRange.getEndDate());

	}

	@Override
	public int compareTo(DateRange o) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		try {
			Date start_date = sdf.parse(startDate);
			Date end_date = sdf.parse(endDate);
			Date pstart_Date = sdf.parse(o.startDate);
			Date pend_Date = sdf.parse(o.endDate);

			return start_date.compareTo(pstart_Date);
		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return 0;
	}

	@Override
	public String toString() {
		return "DateRange [startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
