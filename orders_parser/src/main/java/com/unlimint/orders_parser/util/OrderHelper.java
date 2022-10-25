package com.unlimint.orders_parser.util;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.unlimint.orders_parser.exception.OrdersException;

@Component
public class OrderHelper {
	public String getExtensionByStringHandling(String filename) {
		return Optional.ofNullable(filename).filter(f -> f.contains("."))
				.map(f -> f.substring(filename.lastIndexOf(".") + 1))
				.orElseThrow(() -> new OrdersException("Provide filename with extension"));
	}
}
