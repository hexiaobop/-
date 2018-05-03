package calculate;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {

        public static void main(String[] args) {
            //基本线程池
            ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
            for (int i = 0; i < 10; i++) {
                final int index = i;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cachedThreadPool.execute(new myThreadFirst());
            }




            //调度线程池
            ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
            //延迟三秒执行
            scheduledThreadPool.schedule(new myThreadFirst(), 3, TimeUnit.SECONDS);

            //延迟1秒后每3秒执行一次
            scheduledThreadPool.scheduleAtFixedRate(new myThreadFirst(), 1, 3, TimeUnit.SECONDS);
        }

        static class myThreadFirst extends Thread{
            @Override
            public void run() {
                super.run();
                System.out.println("firstThread myThreadHashCode:"+ this.hashCode()+";threadId"+Thread.currentThread().getId());
            }
        }

    static class myThreadTwo implements Runnable{

            public void run() {
                System.out.println("secondThread");
            }
        }

    static class myThreadThree implements Callable{

            public Object call() throws Exception {
                System.out.println("thirdThread");
                return "hahah";
            }
        }

}
