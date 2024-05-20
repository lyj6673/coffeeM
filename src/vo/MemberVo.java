package vo;

import lombok.Data;

@Data
public class MemberVo {
	private int mem_no;
	private String mem_id;
	private String mem_pw;
	private String mem_name;
	private String mem_phone;
	private String mem_delyn;
	private int mem_stamp;
	private int grade_no;
	
	private int rv_no;
	private String prod_name;
	private String content;
	private String rv_delyn;
	
}
