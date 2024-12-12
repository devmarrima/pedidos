package com.devmarrima.pedidos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devmarrima.entities.Order;
import com.devmarrima.sevices.OrderService;
import com.devmarrima.sevices.ShippmentService;

@SpringBootApplication
public class PedidosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PedidosApplication.class, args);
	}

	@Override 
	public void run(String... args) throws Exception {
		Order order = new Order(1034,5000,10);
		ShippmentService shippmentService = new ShippmentService();
		OrderService orderService = new OrderService(shippmentService);
		System.out.printf("O valor total será de %.2f",orderService.total(order));
		
	}

}
