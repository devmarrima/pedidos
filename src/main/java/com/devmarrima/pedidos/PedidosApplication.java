package com.devmarrima.pedidos;

import java.util.Locale;
import java.util.Scanner;

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
		Scanner sc = new Scanner(System.in);

		sc.useLocale(Locale.US);

		System.out.print("Digite o código do pedido: ");
		int code = sc.nextInt();

		System.out.print("Digite o valor básico do pedido (R$): ");
		double basic = sc.nextDouble();

		System.out.print("Digite a porcentagem de desconto (%) ");
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		ShippmentService shippmentService = new ShippmentService();
		OrderService orderService = new OrderService(shippmentService);
		System.out.printf("pedido código " + code + "\n" + "valor total: R$ %.2f ", orderService.total(order));
		sc.close();
	}

}
