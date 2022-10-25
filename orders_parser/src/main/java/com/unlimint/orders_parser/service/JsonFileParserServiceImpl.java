package com.unlimint.orders_parser.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.unlimint.orders_parser.model.response.OrderRes;
import com.unlimint.orders_parser.util.OrderValidator;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class JsonFileParserServiceImpl implements FileParserService {
	
	private OrderValidator orderValidator = new OrderValidator();
	
	@Override
	public List<OrderRes> getOrders(String fileName) {
		List<OrderRes> orderResList = new ArrayList<>();
		try (FileReader reader = new FileReader(fileName)) {
			JSONArray orderList = (JSONArray) new JSONParser().parse(reader);
			for (Object object : orderList) {
				OrderRes orderRes = parseOrderObject((JSONObject) object, fileName);
				orderRes.setLine(orderList.indexOf(object)+1);
				orderResList.add(orderRes);
			}
			
		} catch (FileNotFoundException e ) {
			log.error("File Not Found",e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.error("IOException: ",e.getMessage());
			e.printStackTrace();
		} catch (ParseException e) {
			log.error("ParseException: ",e.getMessage());
			e.printStackTrace();
		}
		return orderResList;
	}

	private OrderRes parseOrderObject(JSONObject orderObj, String fileName) {

		OrderRes orderRes = new OrderRes();		
		try {
			orderRes.setFilename(fileName);
			orderRes.setOrderId((Long) orderObj.get("orderId"));
			orderRes.setAmount((Double)orderObj.get("amount"));
			orderValidator.checkCurrency(orderRes, (String)orderObj.get("currency"));
			orderValidator.checkComment(orderRes, (String)orderObj.get("comment"));
			if (orderRes.getResult() == null)
				orderRes.setResult("OK");
			
		}catch (Exception e) {
			orderRes.setResult(orderRes.getResult() + " " +e.getMessage());
		}
		
		return orderRes;
	}

}
