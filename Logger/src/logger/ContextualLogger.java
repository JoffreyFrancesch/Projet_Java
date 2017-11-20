package logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("YYYY-MM-dd\tHH:mm:ss.SSS");

	private Logger delegateLogger;
	private String callerClass;

	public ContextualLogger(Logger logger, String name) {
		this.delegateLogger = logger;
		this.callerClass = name;
	}

	public void debug(String category, String message) {
		delegateLogger.debug(category, DATE_FORMAT.format( new Date()) + "\t" + callerClass + "\t" + message);
	}

	public void info(String category, String message) {
		delegateLogger.info(category, DATE_FORMAT.format( new Date()) + "\t" + callerClass + "\t" + message);
	}

	public void error(String category, String message) {
		delegateLogger.error(category, DATE_FORMAT.format( new Date()) + "\t" + callerClass + "\t" + message);
	}

}
