package logger;

public class ConsoleLogger implements Logger {

	// @Override
	// public void log(String message) {
	// 	System.out.println(message);
	// }

	@Override
	public void info(String category, String message) {
		System.out.println(category + " " + message);
	}

	@Override
	public void debug(String category, String message) {
		System.out.println(category + " " + message);
	}

	@Override
	public void error(String category, String message) {
		System.out.println(category + " " + message);
	}


}
