// Chain of Responsibility
public abstract class AbstractLogger {
    int level;
    AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            display(message);
        }

        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    public abstract void display(String message);
}
