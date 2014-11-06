public class Task extends Thread {
    Long time;
    int taskNo;

    public Task(Long time, int taskNo) {
        this.time = time;
        this.taskNo = taskNo;
    }

    @Override
    public void run() {
        try {
            this.sleep(time);
        } catch(InterruptedException e) {

	}
        System.out.println(this);
    }

    @Override
    public String toString() {
        return ""+taskNo;
    }
}
