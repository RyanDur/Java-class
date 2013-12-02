public class PhoneLauncher {
    public void launch() {
	Phone p1 = new OldPhone();
	Phone p2 = new MobilePhone();
	Phone p3 = new SmartPhone();
    }

    public static void main(String[] args) {
        PhoneLauncher launcher = new PhoneLauncher();
        launcher.launch();
    }
}
