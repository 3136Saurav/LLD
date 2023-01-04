public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    public void display(String message) {
        System.out.println("ERROR: " + message);
    }
}
