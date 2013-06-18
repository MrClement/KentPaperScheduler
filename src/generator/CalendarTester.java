package generator;

import java.io.IOException;

public class CalendarTester {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			CSVWriter test = new CSVWriter("Hi.txt", true);
			test.writeDayToFile('A', new CurrentDate(10, 11, 2102));
			ScheduleGeneratorDriver test2 = new ScheduleGeneratorDriver();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
