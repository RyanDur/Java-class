public class SmartPhone extends MobilePhone {

    public void call(String number) {
        if(number.matches("00.*")) {
	    System.out.println("Calling " + number + " using the interwebs");
        } else {
            super.call(number);
        }
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
