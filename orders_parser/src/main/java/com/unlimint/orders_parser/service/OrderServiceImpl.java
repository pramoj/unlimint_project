package com.unlimint.orders_parser.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.unlimint.orders_parser.enums.FileType;
import com.unlimint.orders_parser.exception.OrdersException;
import com.unlimint.orders_parser.model.response.OrderRes;
import com.unlimint.orders_parser.util.OrderHelper;

@Service
public class OrderServiceImpl implements OrderService{
	
	private JsonFileParserServiceImpl jsonFileParserServiceImpl = new JsonFileParserServiceImpl();
	private CsvFileParserServiceImpl csvFileParserServiceImpl = new CsvFileParserServiceImpl();
	private OrderHelper orderHelper = new OrderHelper();
	
	@Override
	public List<OrderRes> getOrderResult(String fileName) {
		
		List<OrderRes> order = new ArrayList<>();
		
		String extension = orderHelper.getExtensionByStringHandling(fileName);
		
		if (FileType.CSV.value.equalsIgnoreCase(extension)) {        
	        order.addAll(csvFileParserServiceImpl.getOrders(fileName));
		}			
		else if (FileType.JSON.value.equalsIgnoreCase(extension))
			order.addAll(jsonFileParserServiceImpl.getOrders(fileName));
		else
			throw new OrdersException("Provide filename with extension");
		
		return order;
	}
	
}
