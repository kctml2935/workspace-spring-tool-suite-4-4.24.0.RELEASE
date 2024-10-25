package com.itwill.order;

import java.util.List;

import org.springframework.stereotype.Component;

@Component("orderService")
public interface OrderService {
	public List<Order> list();
}