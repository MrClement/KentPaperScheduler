package generator;
import java.util.HashMap;

public class DayBuilder {

	private HashMap<Character, Day> dayMap;

	public DayBuilder() {
		dayMap = new HashMap<Character, Day>();
	}

	public HashMap<Character, Day> makeNormalDays(int start) {
		dayMap = new HashMap<Character, Day>();
		int temp;
		for (int i = 0; i < 7; i++) {
			char dayType = 'A';
			dayType += i;
			Day today = new Day();
			if (dayType != 'B' && dayType != 'G') {
				Period currentPeriod = new Period(start, temp = makeIntTime(start, 60), (dayType % 65) % 7 + 1);
				today.add(currentPeriod);
				today.setDayType(dayType);
				temp = makeIntTime(temp, 5);
				currentPeriod = new Period(temp, temp = makeIntTime(temp, 60), (dayType % 65 + 2) % 7 + 1);
				today.add(currentPeriod);
				currentPeriod = new Period(temp, temp = makeIntTime(temp, 20), -1);
				today.add(currentPeriod);
				currentPeriod = new Period(temp, temp = makeIntTime(temp, 20), studentLife(dayType));
				today.add(currentPeriod);
				temp = makeIntTime(temp, 5);
				currentPeriod = new Period(temp, temp = makeIntTime(temp, 75), (dayType % 65 + 3) % 7 + 1);
				today.add(currentPeriod);
				currentPeriod = new Period(temp, temp = makeIntTime(temp, 60), -7);
				today.add(currentPeriod);
				currentPeriod = new Period(temp, temp = makeIntTime(temp, 60), (dayType % 65 + 5) % 7 + 1);
				today.add(currentPeriod);
				temp = makeIntTime(temp, 5);
				currentPeriod = new Period(temp, temp = makeIntTime(temp, 60), (dayType % 65 + 6) % 7 + 1);
				today.add(currentPeriod);
				dayMap.put(dayType, today);
			} else {
				Period currentPeriod = new Period(start, temp = makeIntTime(start, 60), (dayType % 65) % 7 + 1);
				today.add(currentPeriod);
				today.setDayType(dayType);
				temp = makeIntTime(temp, 5);
				currentPeriod = new Period(temp, temp = makeIntTime(temp, 60), (dayType % 65 + 2) % 7 + 1);
				today.add(currentPeriod);
				currentPeriod = new Period(temp, temp = makeIntTime(temp, 20), -1);
				today.add(currentPeriod);
				currentPeriod = new Period(temp, temp = makeIntTime(temp, 75), (dayType % 65 + 3) % 7 + 1);
				today.add(currentPeriod);
				temp = makeIntTime(temp, 5);
				currentPeriod = new Period(temp, temp = makeIntTime(temp, 20), studentLife(dayType));
				today.add(currentPeriod);
				currentPeriod = new Period(temp, temp = makeIntTime(temp, 60), -7);
				today.add(currentPeriod);
				currentPeriod = new Period(temp, temp = makeIntTime(temp, 60), (dayType % 65 + 5) % 7 + 1);
				today.add(currentPeriod);
				temp = makeIntTime(temp, 5);
				currentPeriod = new Period(temp, temp = makeIntTime(temp, 60), (dayType % 65 + 6) % 7 + 1);
				today.add(currentPeriod);
				dayMap.put(dayType, today);
			}
		}
		return dayMap;

	}

	public HashMap<Character, Day> makeWednesdays(int start) {
		dayMap = new HashMap<Character, Day>();
		int temp;
		for (int i = 0; i < 7; i++) {
			char dayType = 'A';
			Day today = new Day();
			dayType += i;
			Period currentPeriod = new Period(start, temp = makeIntTime(start, 55), (dayType % 65) % 7 + 1);
			today.add(currentPeriod);
			today.setDayType(dayType);
			temp = makeIntTime(temp, 5);
			currentPeriod = new Period(temp, temp = makeIntTime(temp, 55), (dayType % 65 + 2) % 7 + 1);
			today.add(currentPeriod);
			currentPeriod = new Period(temp, temp = makeIntTime(temp, 20), -1);
			today.add(currentPeriod);
			currentPeriod = new Period(temp, temp = makeIntTime(temp, 75), (dayType % 65 + 3) % 7 + 1);
			today.add(currentPeriod);
			currentPeriod = new Period(temp, temp = makeIntTime(temp, 55), -7);
			today.add(currentPeriod);
			currentPeriod = new Period(temp, temp = makeIntTime(temp, 55), (dayType % 65 + 5) % 7 + 1);
			today.add(currentPeriod);
			temp = makeIntTime(temp, 5);
			currentPeriod = new Period(temp, temp = makeIntTime(temp, 55), (dayType % 65 + 6) % 7 + 1);
			today.add(currentPeriod);
			dayMap.put(dayType, today);
		}
		return dayMap;

	}

	private int makeIntTime(int time, int add) {
		int temp = (time % 1000) % 100;
		time -= temp;
		time += ((temp + add) / 60) * 100;
		time += ((temp + add) % 60);
		return time;
	}

	private int studentLife(char d) {
		switch (d) {
			case 'A':
				return -2;
			case 'B':
				return -5;
			case 'C':
				return -3;
			case 'D':
				return -4;
			case 'E':
				return -2;
			case 'F':
				return -4;
			case 'G':
				return -5;

			default:
				return -8;
		}
	}

}
