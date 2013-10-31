public class HanoiTowers {
    Tower from = new Tower(1);
    Tower to = new Tower(3);
    Tower pivot = new Tower(2);

    public HanoiTowers(int height) {
        initialTower(height);
    }

    public void hanoi() {
        solve(from.size(), from, to, pivot);
    }

    public void solve(int height,Tower from, Tower to, Tower pivot) {
        if(height == 1) {
            to.set(from.getTop());
        } else {
            solve(height-1,from,pivot,to);
            solve(1,from,to,pivot);
            solve(height-1,pivot,to,from);
        }
    }

    public void print() {
        from.print();
        System.out.println(" ");
        pivot.print();
        System.out.println(" ");
        to.print();
    }

    private void initialTower(int n) {
        if(n <= 0) {
            return;
        }
        from.set(new Disk(n));
        initialTower(n - 1);
    }

    public static void main(String []args) {
        HanoiTowers ht = new HanoiTowers(3);

        ht.print();
        ht.hanoi();
        ht.print();
    }
}
