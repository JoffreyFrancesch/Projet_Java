package logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE;

	private final Logger delegate;
	private final String callerClass;

	public ContextualLogger(Logger paramDelegate, String callerClass) {
		delegate = paramDelegate;
		this.callerClass = callerClass;
	}

	// @Override
	// public void log(String message) {
	// 	String date = LocalDateTime.now().format(FORMATTER);
  //
	// 	delegate.log(date + " " + callerClass + " " + message);
	// }

	@Override
	public void debug(String category, String message) {
		String date = LocalDateTime.now().format(FORMATTER);

		delegate.debug("[DEBUG]["+ category + "] ", date + " " + callerClass + " " + message);
	}

	@Override
	public void info(String category, String message) {
		String date = LocalDateTime.now().format(FORMATTER);

		delegate.info("[INFO]["+ category + "] ", date + " " + callerClass + " " + message);
	}

	@Override
	public void error(String category, String message) {
		String date = LocalDateTime.now().format(FORMATTER);

		delegate.error("[ERROR]["+ category + "] ", date + " " + callerClass + " " + message);
	}

}
