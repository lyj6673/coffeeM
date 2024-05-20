package Print;

import java.util.List;

import vo.MemberVo;
import vo.ProdVo;

public class Print {
	
	public void printProdList(List<ProdVo> prodList) {
		System.out.println("                                                                       │   NO\t\t제품명\t\t가격\t│");
		int no = 1;
		for (ProdVo prodVo : prodList) {
			String name = prodVo.getProd_name();
			int price 	= prodVo.getProd_price();
			System.out.println("                                                                       │   "+no+"\t "+name+"     \t\t"+price+"  \t│");	
			no++;
		}
	}
	
	public void printReviewList(List<MemberVo> memList) {
		System.out.println("                                                                       │\tNO\t상품명\t\t리뷰 \t │");
		int no = 1;
		
		for (MemberVo memberVo : memList) {
			String name = memberVo.getProd_name();
			String content = memberVo.getContent();
			System.out.println("                                                                       │\t"+no+"\t"+name+"\t\t\t │");
			System.out.println("                                                                       │\t    "+content+"\t\t │");
			no++;
		}
	}
	
	public void printReviewMenu(List<MemberVo> memList) {
		System.out.println("                                                                       │\tNO\t작성자\t\t리뷰 \t │");
		int no = 1;
		
		for (MemberVo memberVo : memList) {
			String name = memberVo.getMem_name();
			String content = memberVo.getContent();
			System.out.println("                                                                       │\t"+no+"\t"+name+"\t\t\t │");
			System.out.println("                                                                       │\t    "+content+"\t\t │");
			no++;
		}
	}
}
