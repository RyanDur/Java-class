import java.util.*;

public class Fibonacci {
    private int[] mem = new int[1];

    public int fib(int num) {
        if(num <= 0) return 0;
        if(num < 3) return 1;
        return fib(num-1) + fib(num-2);
    }

    public int fibMem(int num) {
        if(num <= 0) return 0;
        if(num < 3) return 1;

        if(mem.length <= num) {
            mem = growTo(num);
        }

        if(mem[num] == 0) {
            mem[num] = fibMem(num-1) + fibMem(num-2);
        }

        return mem[num];
    }

    private int[] growTo(int num) {
        int[] newMem = new int[num+1];
        System.arraycopy(mem,0,newMem,0,mem.length);
        return newMem;
    }
}
