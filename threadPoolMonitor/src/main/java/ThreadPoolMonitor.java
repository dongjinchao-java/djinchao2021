import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolMonitor extends ThreadPoolExecutor {

    private Logger logger = LoggerFactory.getLogger(ThreadPoolExecutor.class);

    public ThreadPoolMonitor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        logger.info("maxThreadCount=" + this.getLargestPoolSize() + " currPooleSize = " + this.getActiveCount());
    }


    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("123");
            }
        };
        TimerTask task2 = new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("456");
            }
        };
        Timer timer = new HashedWheelTimer();
        timer.newTimeout(task, 10, TimeUnit.SECONDS);
        timer.newTimeout(task2, 3, TimeUnit.SECONDS);
    }
}
