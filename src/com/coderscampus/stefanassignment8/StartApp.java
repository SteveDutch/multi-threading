package com.coderscampus.stefanassignment8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StartApp {

	public static void main(String[] args) {
		
		Assignment8 assignment = new Assignment8();
		List<Integer> numbers = Collections.synchronizedList(new ArrayList<>());
		int taskId = 0;
		List<CompletableFuture<Void>> tasks = new ArrayList<>();
		
		
		ExecutorService cpuBoundTask = Executors.newFixedThreadPool(300);
		ExecutorService ioBoundTask = Executors.newCachedThreadPool();
		Executor executor = Executors.newSingleThreadScheduledExecutor();
		//CompletableFuture.runAsync(()-> assignment.getNumbers(), executor);
		 			
		// new try
			for (int i = 0; i < 1000; i++) {
				CompletableFuture<Void> task = CompletableFuture
												.supplyAsync(() -> assignment.getNumbers(), ioBoundTask)
												.thenAccept(number -> numbers.addAll(number));
		
		System.out.println("Thead-"+ Thread.currentThread().getName()); 

		taskId++;
		System.out.println("Hey look at me, I'm task-id: " + taskId + "! "
				+ "I'm running on thread: " + Thread.currentThread().getName() + "\n DONE");
		

		System.out.println("Länge von numbers = " + numbers.toArray().length);
		
		}

	}
}


