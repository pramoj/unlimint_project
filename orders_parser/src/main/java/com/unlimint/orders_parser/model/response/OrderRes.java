package com.unlimint.orders_parser.model.response;

import java.io.Serializable;

import lombok.Data;

/**
 * Instantiates a new order res.
 */
@Data
public class OrderRes implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	private Integer id;
	
	/** The order id. */
	private Long orderId;
	
	/** The amount. */
	private Double amount;
	
	/** The currency. */
	private String currency;
	
	/** The comment. */
	private String comment ;
	
	/** The filename. */
	private String filename;
	
	/** The line. */
	private Integer line;
	
	/** The result. */
	private String result;
	
}
