package com.devmarrima.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmarrima.entities.Order;
@Service
public class OrderService {
		@Autowired
		private ShippmentService shippmentService;
		
		public OrderService(ShippmentService shippmentService) {
			this.shippmentService = shippmentService;
		}
		
		public double total(Order order) {

		    double valorDesconto = order.getBasic() * (order.getDiscount() / 100);
		    double valorComDesconto = order.getBasic() - valorDesconto;
			return valorComDesconto + shippmentService.shippment(order);
		}
	}


