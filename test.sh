#java -classpath Banking/bin:Testframework/bin testframework.maintest
java -classpath Banking/bin:Logger/bin:Testframework/bin testframework.RunTest logger.LoggerFactory logger.ContextualLogger logger.CompositeLogger logger.FileLogger logger.Logger logger.ConsoleLogger banking.Client banking.Affichage banking.Banque banking.Credit banking.Main banking.Menu banking.Operation
