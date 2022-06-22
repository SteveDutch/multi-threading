package com.coderscampus.stefanassignment8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ThreadRunner {

	public  String run() throws InterruptedException {

		Assignment8 assignment = new Assignment8();
		List<Integer> numbers = Collections.synchronizedList(new ArrayList<>());

		List<CompletableFuture<Void>> tasks = new ArrayList<>();

		ExecutorService cpuBoundTask = Executors.newFixedThreadPool(1000);
//		ExecutorService ioBoundTask = Executors.newCachedThreadPool();
//		Executor executor = Executors.newSingleThreadScheduledExecutor();

		// do like Trevor did
		for (int i = 0; i < 1000; i++) {
			CompletableFuture<Void> task = CompletableFuture.supplyAsync(() -> assignment.getNumbers(), cpuBoundTask)
					.thenAccept(number -> numbers.addAll(number));
			tasks.add(task);

//		System.out.println("Thead-"+ Thread.currentThread().getName()); 

		}

		while (tasks.stream().filter(CompletableFuture::isDone).count() < 1000) {
			// this just loops and keeps the main thread alive
			// until all threads are done working. (Trevor is saying)
		}

		System.out.println("Länge von numbers = " + numbers.toArray().length);

		Map<Integer, Long> numbersFrequency = numbers.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(numbersFrequency);
		String message = "well done";
		return message; 	
	}
	
	

}
