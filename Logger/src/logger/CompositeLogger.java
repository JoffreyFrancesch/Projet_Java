package logger;

public class CompositeLogger implements Logger {


	private final Logger consoleLogger;
	private final Logger fileLogger;

	public CompositeLogger(String name, Logger consoleLogger, Logger fileLogger) {
		this.consoleLogger = consoleLogger;
		this.fileLogger = fileLogger;
	}

	public void info(String category, String message) {
		consoleLogger.info(category,message);
		fileLogger.info(category,message);
	}

	public void debug(String category, String message) {
		consoleLogger.debug(category,message);
		fileLogger.debug(category,message);
	}

	public void error(String category, String message) {
		consoleLogger.error(category,message);
		fileLogger.error(category,message);
	}
}
