public class PhoneLauncher {
    public void launch() {
        OldPhone p1 = new OldPhone("Nokia");
        MobilePhone p2 = new MobilePhone("Blackberry");
        SmartPhone p3 = new SmartPhone("Android");

        System.out.println("Old Phone");
        System.out.println(p1.getBrand());
        p1.call("333333333");
        p1.call("00333333333");

        System.out.println();
        System.out.println("Mobile Phone");
        System.out.println(p2.getBrand());
        p2.call("333333333");
        p2.call("00333333333");

        System.out.println();
        System.out.println("Smart Phone");
	System.out.println(p3.getBrand());
        p3.call("333333333");
        p3.call("00333333333");
    }

    public static void main(String[] args) {
        PhoneLauncher launcher = new PhoneLauncher();
        launcher.launch();
    }
}
