package com.unlimint.orders_parser.model;

import com.opencsv.bean.CsvBindByName;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Instantiates a new order.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Order {
	
	/** The order id. */
	@CsvBindByName(column = "Order ID")
	private String orderId;
	
	/** The amount. */
	@CsvBindByName(column = "amount")
	private String amount;
	
	/** The currency. */
	@CsvBindByName(column = "currency")
	private String currency;
	
	/** The comment. */
	@CsvBindByName(column = "comment ")
	private String comment ;
}