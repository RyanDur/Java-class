public class scratch {
    int mcCarthy91(int n) {
        if (n > 100) {
	    System.out.println(n);
            return n - 10;
        }  else {
	    System.out.println(n);
            return mcCarthy91(mcCarthy91(n+11));
        }
    }

    public static void main(String []args) {
        scratch s = new scratch();

        System.out.println(s.mcCarthy91(50));

    }
}
