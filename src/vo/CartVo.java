package vo;

import lombok.Data;

@Data
public class CartVo {
	private String cart_no;
	private String prod_name;
	private int prod_count;
	private int prod_price;
	private int mem_no;
}
