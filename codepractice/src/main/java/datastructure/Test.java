package datastructure;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class Test {
    public static void main(String[] args) {

//        System.out.println(10/3);
//
//        Random random = new Random();
//        int avg = 1 + random.nextInt(10 -1);
//
//        ArrayBlockingQueue<Object> objects = new ArrayBlockingQueue<Object>(10);
//
//
//        line_cut(100,10);




    }

    public static void line_cut(int money,int people ) {
        List<Integer> team=new ArrayList();
        List<Integer> result=new ArrayList();
        ThreadLocalRandom random= ThreadLocalRandom.current();

        int m=money-1;
        while(team.size() < people -1) {
            int nextInt = random.nextInt(m)+1;//不让nextInt 为0
            if(!team.contains(nextInt)) {
                team.add(nextInt);
            }
        }
        Collections.sort(team);
        System.out.println(team);

        for (int i = 0; i < team.size(); i++) {
            if(i== 0) {
                result.add(team.get(i));
            }else {
                result.add(team.get(i)-team.get(i-1));
                if(i==team.size()-1) {
                    result.add(money-team.get(i));
                }
            }
        }
        System.out.println(result);
        //验证分割后的数是否是输入的总金额
        Optional<Integer> r = result.stream().reduce(Integer::sum);
        System.out.println(r.get());
    }
}
