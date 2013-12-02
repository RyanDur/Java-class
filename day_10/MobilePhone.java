public class MobilePhone extends OldPhone {
    List[] numbers = new ArrayList();

    public void call(String number) {
	super.call(number);
	numbers.add(number);
	if(list.size() > 10) {
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
