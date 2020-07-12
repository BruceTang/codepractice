package datastructure;

public class BitTest {


    public static void main(String[] args) {
        // ThreadPoolExecutor
        // private static int workerCountOf(int c)  { return c & CAPACITY; }  //计算当前线程数量
        int COUNT_BITS = Integer.SIZE - 3;
        int CAPACITY   = (1 << COUNT_BITS) - 1;
        System.out.println(Integer.toBinaryString(Integer.SIZE));
        System.out.println(Integer.toBinaryString(COUNT_BITS));
        System.out.println(Integer.toBinaryString(1 << COUNT_BITS));
        System.out.println(Integer.toBinaryString(CAPACITY));
        System.out.println(Integer.toBinaryString(~ CAPACITY));
        System.out.println(~37);
    }
}
