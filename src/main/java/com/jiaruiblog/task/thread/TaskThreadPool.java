package com.jiaruiblog.task.thread;

import com.google.common.util.concurrent.*;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Jarrett Luo
 * @Date 2022/10/20 17:37
 * @Version 1.0
 */
public class TaskThreadPool {

    private final ThreadPoolExecutor threadPoolExecutor;

    private final ListeningExecutorService listeningExecutorService;

    private static final TaskThreadPool instance = new TaskThreadPool(3, "Task_Thread_%d");

    private List<MainTask> mainTaskList;


    private TaskThreadPool(Integer threadsNum, String threadNameFormat) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setDaemon(true)
                .setNameFormat(threadNameFormat)
                .build();
        threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadsNum, threadFactory);
        listeningExecutorService = MoreExecutors.listeningDecorator(this.threadPoolExecutor);
        mainTaskList = new LinkedList<>();
    }

    public static TaskThreadPool getInstance() {
        return instance;
    }

    public void submit(MainTask mainTask) {
        mainTaskList.add(mainTask);
        // 使用线程池执行任务工作流
        ListenableFuture future = this.listeningExecutorService.submit(mainTask);

        // 工作流执行完成后，回调，将工作流从执行map中移除
        FutureCallback futureCallback = new FutureCallback() {
            @Override
            public void onSuccess(Object o) {

                mainTaskList.remove(mainTask);
            }

            @Override
            public void onFailure(Throwable throwable) {
                mainTaskList.remove(mainTask);
            }
        };
        Futures.addCallback(future, futureCallback, this.listeningExecutorService);

    }

}
