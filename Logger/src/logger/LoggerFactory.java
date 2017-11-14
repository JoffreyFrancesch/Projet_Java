package logger;

public class LoggerFactory  {

	public static Logger getLogger(String name){

		return
				new ContextualLogger(
					new CompositeLogger(
							new FileLogger("Historique.txt")
							, new FilteredLogger(
									new ConsoleLogger()
									, message -> !message.contains("input"))
					)
					, name
				)

		;
	}
}
