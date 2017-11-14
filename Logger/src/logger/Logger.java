package logger;

public interface Logger {

	// void log(String message);

 void debug(String category, String message);
 void info(String category, String message);
 void error(String category, String message);
}
