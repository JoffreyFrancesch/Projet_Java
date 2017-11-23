package logger;

public class LoggerFactory  {

	public static Logger getLogger(String name){
		return new CompositeLogger(name, new ConsoleLogger(), new ContextualLogger(new FileLogger("log.txt"),name));
	}

}
