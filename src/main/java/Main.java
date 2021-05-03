public class Main {
    public static void main(String[] args) {
        Message message = new Message();
        CarRacing carRacing = new CarRacing(message);
        carRacing.start();
    }
}
