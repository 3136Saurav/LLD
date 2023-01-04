public class LogManager {

    public static AbstractLogger buildChainOfLogger() {
        InfoLogger infoLogger = new InfoLogger(1);
        ErrorLogger errorLogger = new ErrorLogger(2);
        DebugLogger debugLogger = new DebugLogger(3);

        infoLogger.setNextLogger(errorLogger);
        errorLogger.setNextLogger(debugLogger);

        return infoLogger;
    }
}
