package com.example.administrator.anroidmvpfarmework.interactor;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 作者：LiShiChuang on 2016/1/19 21:50
 * 邮箱：lschuang@126.com
 */
public class InteractorExecutorImp implements InteractorExecutor {
    private ThreadPoolExecutor threadPoolExecutor;
    //以常量的形式存在
    private static  final  int corPoolSize = 3;//线程池大小
    private static  final  int maxmumPoolSize = 5;//最大线程数
    private static  final  long keepAliveTime = 120;//线程最大存活时间
    private static  final  TimeUnit unit = TimeUnit.SECONDS;//时间单位秒
    private static  final  BlockingDeque<Runnable> workQueue = new LinkedBlockingDeque<>();//线程队列

    public InteractorExecutorImp() {
        threadPoolExecutor = new ThreadPoolExecutor(corPoolSize, maxmumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void run(Interactor interactor) {
        if (interactor != null) {
            threadPoolExecutor.submit(interactor);
        }
    }
}
