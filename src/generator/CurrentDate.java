package generator;
public class CurrentDate implements Comparable<CurrentDate> {

	private int year;
	private int month;
	private int day;

	public CurrentDate() {

	}

	public CurrentDate(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public boolean equals(CurrentDate c) {
		return (c.getYear() == year && c.getMonth() == month && c.getDay() == day);

	}

	public String toString() {
		return "" + month + " " + day + " " + year;
	}

	public boolean isAfterOrEqual(CurrentDate other) {
		if (other.getYear() > year) {
			return false;
		} else if (other.getYear() < year) {
			return true;
		} else {
			if (other.getMonth() > month) {
				return false;
			} else if (other.getMonth() < month) {
				return true;
			} else {
				if (other.getDay() > day) {
					return false;
				} else if (other.getDay() < day) {
					return true;
				} else {
					return true;
				}
			}
		}
	}

	public boolean isAfter(CurrentDate other) {
		if (other.getYear() > year) {
			return false;
		} else if (other.getYear() < year) {
			return true;
		} else {
			if (other.getMonth() > month) {
				return false;
			} else if (other.getMonth() < month) {
				return true;
			} else {
				if (other.getDay() > day) {
					return false;
				} else if (other.getDay() < day) {
					return true;
				} else {
					return false;
				}
			}
		}

	}

	public boolean isBefore(CurrentDate other) {
		if (other.getYear() < year) {
			return false;
		} else if (other.getYear() > year) {
			return true;
		} else {
			if (other.getMonth() < month) {
				return false;
			} else if (other.getMonth() > month) {
				return true;
			} else {
				if (other.getDay() < day) {
					return false;
				} else if (other.getDay() > day) {
					return true;
				} else {
					return false;
				}
			}
		}
	}

	@Override
	public int compareTo(CurrentDate o) {
		if (equals(o)) {
			return 0;
		} else if (isBefore(o)) {
			return -1;
		} else
			return 1;
	}
}
