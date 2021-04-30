package sample.dto;

import lombok.Data;

@Data
public class Product {
	private String pid;
	private String pname;
	private int price;
	private int stockqty; 
}
