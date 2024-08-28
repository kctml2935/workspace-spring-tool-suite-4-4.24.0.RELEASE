package com.itwill.shop.order;

import com.itwill.shop.product.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
이름     널?       유형         
------ -------- ---------- 
OI_NO  NOT NULL NUMBER(10) 
OI_QTY          NUMBER(10) 
O_NO            NUMBER(10) FK
P_NO            NUMBER(10) FK
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
	private int oi_no;
	private int oi_qty;
	/************FK******************/
	private Order order;
	/************FK******************/
	private Product product;
	
}