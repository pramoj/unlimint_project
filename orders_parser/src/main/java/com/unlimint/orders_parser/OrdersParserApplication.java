package com.unlimint.orders_parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.unlimint.orders_parser.contoller.OrderContoller;

public class OrdersParserApplication {

	public static void main(String[] args) throws JsonProcessingException {
		OrderContoller orderContoller = new OrderContoller();
		//args = new String[] {"/Users/saket/pramoj/orders1.csv"};
		//args = new String[] {"/Users/saket/pramoj/order2.json"};
		System.out.println(orderContoller.getOrder(args));
	}
	
}
