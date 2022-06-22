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

public class StartApp {

	public static void main(String[] args) throws InterruptedException {
		ThreadRunner start = new ThreadRunner();
		System.out.println(start.run() + " ;)");
		start.interruptThreads();

		
	}
}
