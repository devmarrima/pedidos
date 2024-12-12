package com.devmarrima.sevices;

import com.devmarrima.entities.Order;

public class ShippmentService {
	public double shippment(Order order) {
		double freight = 0;
		if (order.getBasic() < 100) {
			freight = 20.00;
		} else if (order.getBasic() >= 100 && order.getBasic() < 200) {
			freight = 12.00;
		} else {
			freight = 0.00;
		}
		return freight;
	}

}
