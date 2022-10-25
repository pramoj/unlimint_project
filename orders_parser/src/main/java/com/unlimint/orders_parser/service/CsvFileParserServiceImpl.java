package com.unlimint.orders_parser.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.unlimint.orders_parser.model.response.OrderRes;
import com.unlimint.orders_parser.util.OrderValidator;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CsvFileParserServiceImpl implements FileParserService{
	
	private OrderValidator orderValidator = new OrderValidator();
	
	public List<OrderRes> getOrders(String fileName) {
		List<OrderRes> orderResList = new ArrayList<>();
		try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            List<String[]> orderList = reader.readAll();
            
            for (String[] order : orderList) {
            	if(orderList.indexOf(order) > 0) {
            		OrderRes orderRes = getOrder(order, fileName);
    				orderRes.setLine(orderList.indexOf(order));
    				orderResList.add(orderRes);
            	}
			}
        } catch (FileNotFoundException e) {
        	log.error("File Not Found",e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.error("IOException: ",e.getMessage());
			e.printStackTrace();
		} catch (CsvException e) {
			log.error("CsvException: ",e.getMessage());
			e.printStackTrace();
		}
		
		return orderResList;
	}

	private OrderRes getOrder(String[] order, String fileName) {
		OrderRes orderRes = new OrderRes();
		try {
			orderRes.setFilename(fileName);
			orderValidator.checkOrderId(orderRes, order[0]);
			orderValidator.checkAmount(orderRes, order[1]);
			orderValidator.checkCurrency(orderRes, order[2]);
			orderValidator.checkComment(orderRes, order[3]);
			if (orderRes.getResult() == null)
				orderRes.setResult("OK");
			
		}catch (Exception e) {
			orderRes.setResult(orderRes.getResult() + " " +e.getMessage());
		}
		return orderRes;
	}	
}
