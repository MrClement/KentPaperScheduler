package generator;
import java.io.IOException;

public class CalendarTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ICSWriter test = new ICSWriter("Hi.txt", true);
			System.out.println(test.isWednesday(new CurrentDate(1, 2, 2013)));
			test.writeDayToFile('A', new CurrentDate(10, 11, 2102));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
