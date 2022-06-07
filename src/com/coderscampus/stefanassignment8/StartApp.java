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
		 			
		// from week 12-09r 
//		for (int j=0; j<1000; j++) {
//			tasks = ((CompletableFuture) CompletableFuture.supplyAsync(() ->new Assignment8(), ioBoundTask)
//					.thenApplyAsync(assignment -> assignment.getNumbers(), cpuBoundTask).get())
//					.exceptionally( e -> "Pirat Guybrush hat den Todesfluch '"    );
			
			
		// new try
			for (int i = 0; i < 1000; i++) {
				CompletableFuture<Void> task = CompletableFuture.supplyAsync(() -> assignment.getNumbers(), cpuBoundTask)
																.thenAccept(number -> numbers.addAll(number));
				tasks.add(task);
			

//		CompletableFuture.supplyAsync(() ->new Assignment8(), ioBoundTask)
//		 .thenApplyAsync(assignment -> assignment.getNumbers(), cpuBoundTask)
//		
//		 .thenAcceptAsync(number -> numbers.addAll(numbers), cpuBoundTask);
//		
		
		System.out.println("Thead-"+ Thread.currentThread().getName()); 

		
		taskId++;
		System.out.println("Hey look at me, I'm task-id: " + taskId + "! "
				+ "I'm running on thread: " + Thread.currentThread().getName());
		
		String message = "Done";
		System.out.println(message);
		System.out.println("Länge von numbers = " + numbers.toArray().length);
		
		}
//		CompletableFuture.runAsync(()-> assignment.getNumbers(), ioBoundTask);
		
//		for (int i=0; i<1000; i++) {
//			
//			int taskId = 0;
//
//    		String message = "Starting";
//    		
//    		CompletableFuture.runAsync(()-> assignment.getNumbers(), executor);
//
//    		System.out.println("Thead-"+ Thread.currentThread().getName()); 
//			
//    		
//    	 	List<Integer> numbersList = assignment.getNumbers();
//    	 	
//    		System.out.println("Thead-"+ Thread.currentThread().getName()); 
//    		System.out.println("round : " + i+1);
//    		
//    		taskId++;
//    		System.out.println("Hey look at me, I'm task-id: " + taskId + "! "
//    				+ "I'm running on thread: " + Thread.currentThread().getName());
//    		
//    		message = "Done";
//    		System.out.println(message);
//		}
//		


//	       
//        for (int k=0; k<1000; k++) {
//    		String message = "Starting";
//    		System.out.println(message);
//    		System.out.println("Thead-"+ Thread.currentThread().getName()); 
//    		
//        	List<Integer> numbersList = assignment.getNumbers();
//        	
//    		message = "Done";
//    		System.out.println(message);
//        	
//        }
	}
	}


