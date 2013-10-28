public class InstanceCounter {
    public static int spy;

    public InstanceCounter() {
        spy++;
    }
    public static void main(String []args) {
        InstanceCounter ic1 = new InstanceCounter();
        System.out.println(ic1.spy);

        InstanceCounter ic2 = new InstanceCounter();
        System.out.println(ic1.spy);

        InstanceCounter ic3 = new InstanceCounter();
        System.out.println(ic1.spy);
    }
}
