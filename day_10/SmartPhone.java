public class SmartPhone implements MobilePhone {

    public void call(String number) {
	super.call(number);
    }

    public void ringAlarm(String alarm) {
	super.ringAlarm(alarm);
    }

    public void playGame(String game) {
	super.playGame(game);
    }

    public void browseWeb(String search) {
	System.out.println("Searching for " + search);
    }

    public void findPosition() {
	System.out.println("You are here.");
    }
}
