import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(3);
        executor.schedule(() -> {
            System.out.println(5444);
            System.out.println(executor.getActiveCount());
        }, 0, TimeUnit.MINUTES);
        executor.schedule(() -> {
            System.out.println(3333);
            System.out.println(executor.getActiveCount());
        }, 1000, TimeUnit.MINUTES);
        System.out.println(executor.getActiveCount());
        System.out.println(executor.getTaskCount());
        System.out.println(executor.getQueue().size());
//        LinkedTransferQueue<Runnable> workQueue = new LinkedTransferQueue<>();
//        MyThreadFactory threadFactory = new MyThreadFactory(name);
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, 5, TimeUnit.MINUTES, workQueue, threadFactory, new ThreadPoolExecutor.DiscardPolicy());
//        EXECUTORS.put(name,executor);
    }
}
