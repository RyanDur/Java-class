public class Target {

    private int[][][] target;
    private int x;
    private int y;
    private int z;

    public Target(int size) {
        target = new int[size][size][size];
        init();
    }

    public void init() {
        x = coordinate(target.length);
        y = coordinate(target.length);
        z = coordinate(target.length);
        target[x][y][z] = 1;
    }

    public Result fire(int x, int y, int z) {
        if(x < 0 || y < 0 || z < 0 || x >= target.length || y >= target.length|| z >= target.length) {
            return Result.OUT_OF_RANGE;
        } else if(target[x][y][z] == 1) {
            return Result.HIT;
        } else if(this.x < x) {
            return Result.FAIL_HIGH;
        } else if(this.x > x) {
            return Result.FAIL_LOW;
        } else if(this.y > y) {
            return Result.FAIL_SHORT;
        } else if(this.y < y) {
            return Result.FAIL_LONG;
        } else if(this.z > z) {
            return Result.FAIL_LEFT;
        } else {
            return Result.FAIL_RIGHT;
        }
    }

    private int coordinate(int n) {
        return (int) Math.abs(n * Math.random());
    }
}
