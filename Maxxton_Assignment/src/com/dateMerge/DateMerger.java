package com.dateMerge;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class DateMerger {

	static int count = 0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ArrayList<DateRange> dateRanges = new ArrayList<DateRange>();
		dateRanges.add(new DateRange("01 Jan 2014", "30 Jan 2014"));
		dateRanges.add(new DateRange("15 Jan 2014", "15 Feb 2014"));
		dateRanges.add(new DateRange("10 March 2014", "15 Apr 2014"));
		dateRanges.add(new DateRange("10 Apr 2014", "15 May 2014"));

		for (Iterator iterator = mergeDates(dateRanges).iterator(); iterator.hasNext();) {
			DateRange date_range = (DateRange) iterator.next();

			System.out.println(date_range.getStartDate() + " " + "-" + " " + date_range.getEndDate());
		}

		if (count % 2 != 0 && count > 1 || count == 2) {
			throw new WrongDateRangeException(
					"Second date range's startDate is greater than First date range endDate. It should be less than or equal to First date range endDate ");
		}

	}

	public static ArrayList<DateRange> mergeDates(ArrayList<DateRange> dateRanges) {

		Collections.sort(dateRanges);
		Set<DateRange> resultlist = new TreeSet<DateRange>();
		ArrayList<DateRange> mergedDateRanges = new ArrayList<DateRange>();

		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		if (dateRanges.size() == 1) {
			return dateRanges;
		}

		if (dateRanges.size() > 1) {
			DateRange mergeDateRange = dateRanges.get(0);

			for (int i = 1; i < dateRanges.size(); i++) {
				DateRange dateRange2 = dateRanges.get(i);

				try {
					Date startDate1 = sdf.parse(mergeDateRange.getStartDate());
					Date endDate1 = sdf.parse(mergeDateRange.getEndDate());
					Date startDate2 = sdf.parse(dateRange2.getStartDate());
					Date endDate2 = sdf.parse(dateRange2.getEndDate());

					if (startDate2.compareTo(endDate1) < 0) {

						if (endDate2.compareTo(endDate1) > 0) {

							mergeDateRange.setEndDate(dateRange2.getEndDate());

						}

					}

					else if (startDate2.compareTo(endDate1) == 0) {

						if (endDate2.compareTo(endDate1) > 0) {

							mergeDateRange.setEndDate(dateRange2.getEndDate());

						}

					}

					else if (startDate2.compareTo(endDate1) == 0) {

						if (endDate2.compareTo(endDate1) > 0) {

							mergeDateRange.setEndDate(dateRange2.getEndDate());

						}

					}

					else {
						mergeDateRange = dateRange2;
						count++;

					}

					if (mergeDateRange != dateRange2) {
						resultlist.add(mergeDateRange);
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		}

		mergedDateRanges.addAll(resultlist);
		return mergedDateRanges;

	}

}
