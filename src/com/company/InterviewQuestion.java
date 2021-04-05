package com.company;

import com.sun.source.tree.WhileLoopTree;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InterviewQuestion {

    public static void main(String[] args) throws IOException {
        // write your code her
        File folder = new File("/Users/lbenzzine/Documents/reactive/demo/src/main/java");
        final BlockingQueue<File> myQueue = new ArrayBlockingQueue<>(500);

        for (File f : folder.listFiles()) {
            myQueue.add(f);
        }
        ExecutorService pool = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 2; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    File workingOnFile = null;
                    while ((workingOnFile = myQueue.poll()) != null) {
                        //open the file or whatever needs to be done with file.
                        System.out.println("Here where the work will be done");
                    }
                }

            };
            pool.execute(runnable);
        }
    }
}
