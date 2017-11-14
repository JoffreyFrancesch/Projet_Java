package logger;

public class CompositeLogger implements Logger {


	private final Logger delegate1;
	private final Logger delegate2;

	public CompositeLogger(Logger delegate1, Logger delegate2) {
		this.delegate1 = delegate1;
		this.delegate2 = delegate2;
	}

	// @Override
	// public void log(String message) {
	// 	delegate1.log(message);
	// 	delegate2.log(message);
	// }

	@Override
	public void info(String category, String message) {
		delegate1.info(category,message);
		delegate2.info(category,message);
	}

	@Override
	public void debug(String category, String message) {
		delegate1.debug(category,message);
		delegate2.debug(category,message);
	}

	@Override
	public void error(String category, String message) {
		delegate1.error(category,message);
		delegate2.error(category,message);
	}
}
