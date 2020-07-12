package juc;

public class MyThread extends Thread{
    public void run(){
        super.run();
//        for(int i=0; i<500000; i++){
//            if(this.interrupted()) {
//                System.out.println("线程已经终止， for循环不再执行");
//                break;
//            }
////            System.out.println("i="+(i+1));
//        }
            try {
                System.out.println("线程开始。。。");
                Thread.sleep(200000);
                System.out.println("线程结束。");
            } catch (InterruptedException e) {
                System.out.println("在沉睡中被停止, 进入catch， 调用isInterrupted()方法的结果是：" + this.isInterrupted());
                e.printStackTrace();
            }
    }

    public static void main(String args[]){
        Thread thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(1000);
            thread.interrupt();
//            thread.stop();

//            Thread.currentThread().interrupt();
//            Thread.currentThread().stop();
//            System.out.println("stop 1??" + Thread.interrupted());
//            System.out.println("stop 1??" + Thread.interrupted());

//            System.out.println("stop 1??" + thread.isInterrupted());
//            System.out.println("stop 2??" + thread.isInterrupted());
            System.out.println(".....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

