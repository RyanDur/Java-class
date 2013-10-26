import java.util.*;

public class Tower {
    ArrayList <Disk> tower = new ArrayList<Disk>();
    int name;

    public Tower(int n) {
	name = n;
    }

    public void set(Disk disk) {
	tower.add(disk);
    }

    public Disk getTop() {
	return tower.remove(tower.size()-1);
    }

    public Integer size() {
	return tower.size();
    }

    public void print() {
	System.out.println("Tower " + name);
	for(int i = tower.size()-1; i >= 0; i--) {
	    tower.get(i).print();
	}
    }
}
