package com.visa.training.Concurrency;

public class ProducerConsumerDemo {
		public static void main(String[] args) {
			Buffer buffer = new Buffer();
			Producer producer = new Producer(buffer);
			Consumer consumer  = new Consumer(buffer);
			producer.start();
			consumer.start();
			System.out.println("Producer and Consumer Threads running");
		}
}
