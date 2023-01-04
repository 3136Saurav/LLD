public class DebugLogger extends AbstractLogger{

    public DebugLogger(int level) {
        this.level = level;
    }

    @Override
    public void display(String message) {
        System.out.println("DEBUG: " + message);
    }
}
