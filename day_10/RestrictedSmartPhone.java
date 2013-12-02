public class RestrictedSmartPhone extends SmartPhone {

    public RestrictedSmartPhone(String brand) {
	super(brand);
    }

    // private : attempting to assign weaker access privileges
    public void playGame(String game) {
	super.playGame(game);
    }
}
