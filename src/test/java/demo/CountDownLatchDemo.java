package demo;

import java.util.concurrent.CountDownLatch;

/**
 * @project:metadata
 * @packname:demo
 * @name: CountDownLatchDemo
 * @describe:
 * @author: niujiaxin
 * @create: 2018-11-26-17:14
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是子线程a开始执行。。。。");
                try {
                    Thread.sleep(1000);//子线程处理事情
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();//每次减一
                System.out.println("我是子线程a执行结束。。。。");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是子线程b开始执行。。。。");
                try {
                    Thread.sleep(1000);//子线程处理事情
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
                System.out.println("我是子线程b执行结束。。。。");
            }
        }).start();
        countDownLatch.await();//如果不为0，则一直等待
        System.out.println("主线程开始执行任务");
        for (int i = 0; i < 10; i++) {
            System.out.println("main: i="+i);
        }
    }
}
