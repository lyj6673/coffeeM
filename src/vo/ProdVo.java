package vo;

import java.util.Date;

import lombok.Data;

@Data
public class ProdVo {
	private String prod_id;
	private String prod_name;
	private int prod_price;
	private String prod_detail;
	private Date prod_insdate;
	private int cate_lgu;
	
	private String cate_name;
	
}
