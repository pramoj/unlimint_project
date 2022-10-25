package com.unlimint.orders_parser.util;

import org.springframework.stereotype.Component;

import com.unlimint.orders_parser.model.response.OrderRes;

@Component
public class OrderValidator {
	
	public OrderRes checkOrderId(OrderRes orderRes, String data){
		try {
			if (data == null)
				orderRes.setResult("Order Id is null");
			else if (data.length()==0)
				orderRes.setResult("Order Id is an empty");
			else 
				orderRes.setOrderId(Long.parseLong(data));
		} catch (NumberFormatException e) {
			orderRes.setResult("Order Id is not a Number");
		}
		return orderRes;
	}
	
	public OrderRes checkAmount(OrderRes orderRes, String data){
		try {
			if (data == null)
				orderRes.setResult(orderRes.getResult()+"  Amount is null");
			else if (data.length()==0)
				orderRes.setResult(orderRes.getResult()+"  Amount is an empty");
			else 
				orderRes.setAmount(Double.parseDouble(data));
		} catch (NumberFormatException e) {
			orderRes.setResult(orderRes.getResult()+"  Amount is not a Number");
		}
		return orderRes;
	}
	
	public OrderRes checkCurrency(OrderRes orderRes, String data){
			if (data == null)
				orderRes.setResult(orderRes.getResult()+"  Currency is null");
			else if (data.length()==0)
				orderRes.setResult(orderRes.getResult()+"  Currency is an empty");
			else 
				orderRes.setCurrency(data);
		return orderRes;
	}
	
	public OrderRes checkComment(OrderRes orderRes, String data){
			if (data == null)
				orderRes.setResult(orderRes.getResult()+"  Comment is null");
			else if (data.length()==0)
				orderRes.setResult(orderRes.getResult()+"  Comment is an empty");
			else 
				orderRes.setComment(data);
		return orderRes;
	}

}
