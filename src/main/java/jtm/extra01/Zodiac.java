package jtm.extra01;

public class Zodiac {

	/**
	 * Determine the sign of the zodiac, use day and month.
	 * 
	 * @param day
	 * @param month
	 * @return zodiac
	 */
	public static String getZodiac(int day, int month) {
		String zodiac = null;
		// TODO #1: Implement method which return zodiac sign names
		// As method parameter - day and month;
		// Look at wikipedia:
		// https://en.wikipedia.org/wiki/Zodiac#Table_of_dates
		// Tropical zodiac, to get appropriate date ranges for signs

		String[] zodiacs = {"Capricorn", "Aquarius", "Pisces", "Aries",  "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio", "Sagittarius"};
		switch (month) {
			case 2:
				zodiac = (day <= 19) ? zodiacs[month - 1] : zodiacs[month];
				break;
			case 1:
			case 3:
			case 4:
				zodiac = (day <= 20) ? zodiacs[month - 1] : zodiacs[month];
				break;
			case 5:
			case 6:
				zodiac = (day <= 21) ? zodiacs[month - 1] : zodiacs[month];
				break;
			case 12:
				zodiac = (day <= 21) ? zodiacs[month - 1] : zodiacs[0];
				break;
			case 7:
			case 8:
			case 11:
				zodiac = (day <= 22) ? zodiacs[month - 1] : zodiacs[month];
				break;
			case 9:
			case 10:
				zodiac = (day <= 23) ? zodiacs[month - 1] : zodiacs[month];
				break;
		}
		return zodiac;
	}

	public static void main(String[] args) {
		// HINT: you can use main method to test your getZodiac method with
		// different parameters
		System.out.println(getZodiac(21, 3));
	}

}
