package vttp.batch5.sdf.task01;

public class ExtraUtilities {

	public static final String[] POSITION = { "highest", "second highest", "third highest", "fourth highest", "fifth highest" };
	public static final String[] WEATHER = { "Clear, Few clouds, Partly cloudy, Partly cloudy", "Monday", "Mist + Cloudy, Mist + Broken clouds, Mist + Few clouds, Mist", "Light Snow, Light Rain + Thunderstorm + Scattered clouds, Light Rain + Scattered clouds", "Heavy Rain + Ice Pallets + Thunderstorm + Mist, Snow + Fog"};
	public static final String[] HOLIDAY = {"a holiday.", "not a holiday."};

	public static String toPosition(int position) {
		switch (position) {
			case 1:
			case 2:
			case 3:
			case 4:
            case 5:
				return POSITION[position - 1];
			default:
				return "not in top 5";
		}
	}

    public static String toWeather(int weather) {
		switch (weather) {
			case 1:
			case 2:
			case 3:
			case 4:
				return WEATHER[weather - 1];
			default:
				return "weatherman on break";
		}
	}

    public static String toHoliday(int holiday) {
		switch (holiday) {
			case 1:
			case 2:
				return HOLIDAY[holiday - 1];
			default:
				return "not a holiday.";
		}
	}
}
