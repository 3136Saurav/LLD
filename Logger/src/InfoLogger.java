public class InfoLogger extends AbstractLogger{

    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    public void display(String message) {
        System.out.println("INFO: " + message);
    }
}
