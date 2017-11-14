package logger;

import java.util.function.Predicate;

public class FilteredLogger implements Logger{

	private Predicate<String> condition;
	private Logger delegate;

	public FilteredLogger(Logger delegate, Predicate<String> condition) {
		// TODO assign arguments to fields
		this.delegate = delegate;
		this.condition = condition;
	}

	// @Override
	// public void log(String message) {
	// 	// TODO Auto-generated method stub
	// 	if(condition.test(message)){
	// 		delegate.log(message);
	// 	}
	// }

	@Override
	public void info(String category, String message) {
		// TODO Auto-generated method stub
		if(condition.test(category) && condition.test(message)){
			delegate.info(category,message);
		}
	}

	@Override
	public void debug(String category, String message) {
		// TODO Auto-generated method stub
		if(condition.test(category) && condition.test(message)){
			delegate.debug(category,message);
		}
	}

	@Override
	public void error(String category, String message) {
		// TODO Auto-generated method stub
		if(condition.test(category) && condition.test(message)){
			delegate.error(category,message);
		}
	}
}
