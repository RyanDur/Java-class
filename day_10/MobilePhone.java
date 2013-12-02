import java.util.ArrayList;

public class MobilePhone extends OldPhone {
    ArrayList<String> numbers = new ArrayList<String>();

    public void call(String number) {
	super.call(number);
	numbers.add(number);
	if(numbers.size() > 10) {
	    numbers.remove(0);
	}
    }

    public void ringAlarm(String alarm) {
	System.out.println("Alarm " + alarm);
    }

    public void playGame(String game) {
	System.out.println("Playing " + game);
    }
}
