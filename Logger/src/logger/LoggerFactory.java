package logger;

public class LoggerFactory  {

	public static Logger getLogger(String name){

		return new CompositeLogger(name, new ConsoleLogger(), new FileLogger("log.txt"));
}
}
