package com.unlimint.orders_parser.contoller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unlimint.orders_parser.model.response.OrderRes;
import com.unlimint.orders_parser.service.OrderService;
import com.unlimint.orders_parser.service.OrderServiceImpl;
@Component
public class OrderContoller {

	private OrderService orderService = getOrderService();
	
	public OrderService getOrderService() {
		return new OrderServiceImpl();
	}
	
	public String getOrder(String[] args) throws JsonProcessingException {
		List<OrderRes> order = new ArrayList<>();
		for (String fileName : args) {
			order.addAll(orderService.getOrderResult(fileName));
		}
		int id=0;
		for (OrderRes orderRes : order) {
			orderRes.setId(++id);
		}
		
		return new ObjectMapper().writeValueAsString(order);
	}
	
}
