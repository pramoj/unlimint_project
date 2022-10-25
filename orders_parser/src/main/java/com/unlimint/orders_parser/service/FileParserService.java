package com.unlimint.orders_parser.service;

import java.util.List;

import com.unlimint.orders_parser.model.response.OrderRes;


public interface FileParserService {
	public List<OrderRes> getOrders(String fileName);
}