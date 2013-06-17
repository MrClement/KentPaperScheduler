package generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map.Entry;

public class CSVWriter {

	private HashMap<Character, Day> normalDays;
	private HashMap<Character, Day> wednesDays;
	private HashMap<Character, Day> normalDaysDST;
	private HashMap<Character, Day> wednesDaysDST;
	private BufferedWriter out;
	private String filename;
	private int startYear = 2012;
	private CurrentDate schoolStartDate = new CurrentDate(10, 15, 2012);
	private CurrentDate dstStartDate = new CurrentDate(11, 4, 2012);
	private CurrentDate dstEndDate = new CurrentDate(3, 10, 2013);
	private CurrentDate dayAfterDSTStartDate = new CurrentDate(11, 5, 2012);

	public CSVWriter(boolean schoolType) {

		DayBuilder db = new DayBuilder();
		normalDays = db.makeNormalDays(adjustTime(800, schoolStartDate, 1));
		wednesDays = db.makeWednesdays(adjustTime(900, schoolStartDate, 1));
		normalDaysDST = db.makeNormalDays(adjustTime(800, dayAfterDSTStartDate, 1));
		wednesDaysDST = db.makeWednesdays(adjustTime(900, dayAfterDSTStartDate, 1));
		for (Entry<Character, Day> e : wednesDays.entrySet()) {
			System.out.println(e.getValue().getDayType());
			System.out.println(e.getValue().toString());
			System.out.println();
		}

	}

	public CSVWriter(String filename, boolean schoolType) throws IOException {
		DayBuilder db = schoolType ? new DayBuilder() : new DayBuilder78();
		normalDays = db.makeNormalDays(adjustTime(800, schoolStartDate, 1));
		wednesDays = db.makeWednesdays(adjustTime(900, schoolStartDate, 1));
		normalDaysDST = db.makeNormalDays(adjustTime(800, dayAfterDSTStartDate, 1));
		wednesDaysDST = db.makeWednesdays(adjustTime(900, dayAfterDSTStartDate, 1));
		this.filename = filename;
	}

	public int adjustTime(int time, CurrentDate today, int direction) {
		int currentTime = time;
		if (today.isBefore(dstStartDate) || today.isAfterOrEqual(dstEndDate)) {
			currentTime += 600 * direction;
		} else {
			currentTime += 700 * direction;
		}
		return currentTime;

	}

	public boolean isWednesday(CurrentDate today) {
		Calendar wed = Calendar.getInstance();
		wed.clear();
		wed.set(startYear, 0, 1, 8, 8, 8);
		while (wed.get(Calendar.DAY_OF_WEEK) != Calendar.WEDNESDAY) {
			wed.add(Calendar.DATE, 1);
		}
		Calendar temp = Calendar.getInstance();
		temp.clear();
		temp.set(today.getYear(), today.getMonth() - 1, today.getDay(), 8, 8, 8);
		while (wed.compareTo(temp) < 0) {
			wed.add(Calendar.DAY_OF_WEEK, 7);
			if (wed.compareTo(temp) == 0) {
				return true;
			}
		}
		return false;

	}

	public void writeHeader() {
		File old = new File(filename);
		old.delete();
		try {
			out = new BufferedWriter(new FileWriter(filename, true));
			out.write("Day Type, Period 1, Period 2, Period 3, Period 4, Period 5, Period 6, Period 7");
			out.newLine();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String periodName(int periodNumber) {
		String s = "";
		switch (periodNumber) {
			case -1:
				s = "Break";
				break;
			case -2:
				s = "Assembly";
				break;
			case -3:
				s = "Class Meeting";
				break;
			case -4:
				s = "Advisory";
				break;
			case -5:
				s = "Clubs";
				break;
			case -7:
				s = "Lunch";
				break;
			default:
				s = "Period " + periodNumber;
				break;
		}
		return s;
	}

	public void writeDayToFile(char dayType, CurrentDate today) throws IOException {
		try {
			out = new BufferedWriter(new FileWriter(filename, true));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<Character, Day> currentDayMap;
		if (today.isBefore(dstStartDate) || today.isAfterOrEqual(dstEndDate)) {
			currentDayMap = isWednesday(today) ? wednesDays : normalDays;
		} else {
			currentDayMap = isWednesday(today) ? wednesDaysDST : normalDaysDST;
		}
		Day dayToPrint = currentDayMap.get(dayType);
		out.write(dayType + " Day, ");
		for (Period p : dayToPrint.getD()) {
			Period periodToPrint = p;
			out.write(periodName(periodToPrint.getNumber()) + " - "
					+ adjustTime(periodToPrint.getStartTime(), today, -1) + " - "
					+ adjustTime(periodToPrint.getEndTime(), today, -1) + ", ");

		}
		out.close();

	}

}
