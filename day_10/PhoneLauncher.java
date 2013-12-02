public class PhoneLauncher {
    public void launch() {
        Phone p1 = new OldPhone();
        Phone p2 = new MobilePhone();
        Phone p3 = new SmartPhone();

        System.out.println("Old Phone");
        p1.call("333333333");
        p1.call("00333333333");

        System.out.println();
        System.out.println("Mobile Phone");
        p2.call("333333333");
        p2.call("00333333333");

        System.out.println();
        System.out.println("Smart Phone");
        p3.call("333333333");
        p3.call("00333333333");
    }

    public static void main(String[] args) {
        PhoneLauncher launcher = new PhoneLauncher();
        launcher.launch();
    }
}
