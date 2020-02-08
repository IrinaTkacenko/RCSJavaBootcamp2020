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

		boolean res;
		switch (month) {
			case 1:
				zodiac = (day <= 20) ? "Capricorn" : "Aquarius";
			break;
			case 2:
				zodiac = (day <= 19) ? "Aquarius" : "Pisces";
				break;
			case 3:
				zodiac = (day <= 20) ? "Pisces" : "Aries";
				break;
			case 4:
				zodiac = (day <= 20) ? "Aries" : "Taurus";
				break;
			case 5:
				zodiac = (day <= 21) ? "Taurus" : "Gemini";
				break;
			case 6:
				zodiac = (day <= 21) ? "Gemini" : "Cancer";
				break;
			case 7:
				zodiac = (day <= 22) ? "Cancer" : "Leo";
				break;
			case 8:
				zodiac = (day <= 22) ? "Leo" : "Virgo";
				break;
			case 9:
				zodiac = (day <= 23) ? "Virgo" : "Libra";
				break;
			case 10:
				zodiac = (day <= 23) ? "Libra" : "Scorpio";
				break;
			case 11:
				zodiac = (day <= 22) ? "Scorpio" : "Sagittarius";
				break;
			case 12:
				zodiac = (day <= 21) ? "Sagittarius" : "Capricorn";
				break;
		}
		return zodiac;
	}

	public static void main(String[] args) {
		// HINT: you can use main method to test your getZodiac method with
		// different parameters
		System.out.println(getZodiac(20, 2));
	}

}
