package logger.src;

public class LoggerFactory {

	public static Logger getLogger(String message) {
		return new ConsoleLogger();
	}
}
