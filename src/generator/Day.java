package generator;
import java.util.PriorityQueue;

public class Day {

	private boolean isWednesday;
	private PriorityQueue<Period> d;
	private char dayType;

	public Day() {
		d = new PriorityQueue<>();
		isWednesday = false;
	}

	public void add(Period p) {
		d.add(p);
	}

	public PriorityQueue<Period> getD() {
		return d;
	}

	public String toString() {
		String line = "";
		for (Period p : d) {
			line += p.toString() + "\n";
		}
		return line;

	}

	public char getDayType() {
		return dayType;
	}

	public void setDayType(char dayType) {
		this.dayType = dayType;
	}

	public void makeWednesday(boolean b) {
		isWednesday = b;
	}

	public boolean isWednesday() {
		return isWednesday;
	}

}
