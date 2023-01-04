// Singleton - Private Constructor


import java.io.Serializable;

public class Logger implements Serializable, Cloneable {
    private volatile static Logger logger;
    private volatile static AbstractLogger chainOfLogger;

    public static Logger getLogger() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                     chainOfLogger = LogManager.buildChainOfLogger();

                }
            }
        }
        return logger;
    }

    private Logger() {
        if (logger != null) {
            throw new IllegalStateException("Cannot create object");
        }
    }

    public Object readResolve() {
        return logger;
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Clone not supported");
    }
}
