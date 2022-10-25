package com.unlimint.orders_parser.service;

import java.util.List;

import com.unlimint.orders_parser.model.response.OrderRes;

public interface OrderService {
	public List<OrderRes> getOrderResult(String fileName);
}
