package com.company.se;

import java.util.Random;

/**
 * @Description 生成模拟日志文件
 * @Author Jiang
 * @Date 2021/12/30 13:38
 * @Version 1.0.0
 */

public class GenerateLog {

    public static void main(String[] args) {
        Random random = new Random();
        long taskId = 0L;
        int exectime = 0;

        for (int i = 0; i < 20; i++) {
            taskId = random.nextInt(10000)+1640830570000L;
            exectime = random.nextInt(10) + 5;
            String log = "taskId=" + taskId + " shardingNum=0 WithdrawService::withdraw exectime=" + exectime + " desc=end";
            System.out.println(log);
        }

        System.out.println("分支冲突测试1");

        System.out.println("解决分支冲突测试2");


        System.out.println("ceshi");



    }
}
