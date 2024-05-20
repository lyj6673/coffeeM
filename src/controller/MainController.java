package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Print.Print;
import service.MemberService;
import service.ProdService;
import util.ScanUtil;
import util.View;
import vo.CartVo;
import vo.MemberVo;
import vo.ProdVo;

public class MainController  {
	static public Map<String, Object> sessionStorage = new HashMap<>();
	ProdService prodService = ProdService.getInstance();
	MemberService memberService = MemberService.GetInstance();
	
	public static void main(String[] args) {
		new MainController().start();
	}

	private void start() {
		View view = View.MAIN;
		while (true) {
			switch (view) {
			case MAIN:
				view = home();
				break;
			case CATEGORY:
				view = category();
				break;
			case PROD_MAIN:
				view = prodMain();
				break;
			case PROD_DETAIL:
				view = prodDetail();
				break;
			case ORDER_DETAIL:
				view = orderDetail();
				break;
			case ADMIN:
				view = admin();
				break;
			case SIGN:
				view = sign();
				break;
			case LOGIN:
				view = login();
				break;
			case ORDER:
				view = order();
				break;
			case PAYMENT:
				view = payment();
				break;
	         case MEMBER:
	             view = member();
	             break;
	         case MEMBER_UPDATE:
	             view = memberUpdate();
	             break;
	         case MEMBER_DELETE:
	             view = memberDelete();
	             break;
	         case MEMBER_STAMP:
	             view = myStamp();
	             break;
	         case REVIEW:
	             view = myReview();
	             break;
	         case REVIEW_INSERT:
	             view = reviewInsert();
	             break;
	         case REVIEW_DELETE:
	             view = reviewDelete();
	             break;
	         case MENU_INSERT:
	                view = menuInsert();
	                break;
	         case MENU_UPDATE:
	                view = menuUpdate();
	                break;
	         case MENU_DELETE:
	                view = menuDelete();
	                break;
	         case TOTAL_SALES:
	                view = totalSales();
	                break;
			default:
				break;
			}
		}
	}
	private View menuInsert() {
	      System.out.println("\n\n\n");
        System.out.println("                                                                       ┌────────────────── 메 뉴 판 ────────────────┐");
        System.out.println("                                                                       │\t 추가할 메뉴 카테고리 선택 \t\t│");
        System.out.println("                                                                       │\t\t 1. 커   피 \t\t│");
        System.out.println("                                                                       │\t\t 2. 논커피\t\t│");
        System.out.println("                                                                       │\t\t 3.  티   \t\t\t│");
        System.out.println("                                                                       │\t\t 4. 에이드\t\t│");
        System.out.println("                                                                       │\t\t 5. 스무디\t\t│");
        System.out.println("                                                                       └────────────────────────────────────────┘");
     System.out.println("\n");
     	  int cate_lgu = ScanUtil.nextInt("                                                                                                                                                                               메뉴 선택 : "); 
     	  
	   System.out.println("\n\n");
	      System.out.println("                                                                       ┌─────────────── 메뉴 추가 ──────────────────┐");
	      String prod_name   = ScanUtil.nextLine("                                                                       \t메뉴명 : ");
	      String prod_price   = ScanUtil.nextLine("                                                                      \t가격 : ");
	      String prod_detail = ScanUtil.nextLine("                                                                       \t메뉴설명 : ");
	      String prod_insdate = ScanUtil.nextLine("                                                                       \t출시일자(ex 20200501) : ");
	      System.out.println("                                                                       └────────────────────────────────────────┘");
	      System.out.println("\n\n");
	      
	      List<Object> param = new ArrayList<Object>();
	      param.add(prod_name);
	      param.add(prod_price);
	      param.add(prod_detail);
	      param.add(prod_insdate);
	      param.add(cate_lgu);
	      boolean success = prodService.prodInsert(param);
        
        if (success) {
           System.out.println("\n\n");
           System.out.println("                                                                       ┌────────────────── 메뉴추가 ────────────────┐");
           System.out.println("                                                                       │\t 메뉴 추가가 완료되었습니다.  \t\t│");
           System.out.println("                                                                       └─────────────────────────────────────────┘");
           System.out.println("\n");
           return View.ADMIN;
        } else {
           System.out.println("\n\n");
           System.out.println("                                                                       ┌──────────────── 메뉴추가 ─────────────────┐");
           System.out.println("                                                                       │\t 메뉴 추가에 실패했습니다.\t\t│");
           System.out.println("                                                                       │\t 다시 시도해주세요.\t\t│");
           System.out.println("                                                                       └────────────────────────────────────────┘");
           System.out.println("\n");

           return View.ADMIN;
        }
	      
 }
 
 private View menuUpdate() {
	   Print print = new Print(); 
	   System.out.println("\n\n\n");
     System.out.println("                                                                       ┌────────────────── 메 뉴 판 ────────────────┐");
     System.out.println("                                                                       │\t 변경할 메뉴 카테고리 선택 \t\t│");
     System.out.println("                                                                       │\t\t 1. 커   피 \t\t│");
     System.out.println("                                                                       │\t\t 2. 논커피\t\t│");
     System.out.println("                                                                       │\t\t 3.  티   \t\t\t│");
     System.out.println("                                                                       │\t\t 4. 에이드\t\t│");
     System.out.println("                                                                       │\t\t 5. 스무디\t\t│");
     System.out.println("                                                                       └────────────────────────────────────────┘");
  System.out.println("\n");
  	  int cate_lgu = ScanUtil.nextInt("                                                                                                                                                                               메뉴 선택 : "); 
  	  
  	  List<ProdVo> prodList = null; 
        List<Object> paramCate = new ArrayList();

           List<Object> param = new ArrayList();
           if(cate_lgu == 1) {
              param.add(cate_lgu);
              paramCate.add(cate_lgu);
           }
           if(cate_lgu == 2) {
              param.add(cate_lgu);
              paramCate.add(cate_lgu);
           }
           if(cate_lgu == 3) {
              param.add(cate_lgu);
              paramCate.add(cate_lgu);
           }
           if(cate_lgu == 4) {
              param.add(cate_lgu);
              paramCate.add(cate_lgu);
           }
           if(cate_lgu == 5) {
              param.add(cate_lgu);
              paramCate.add(cate_lgu);
           }
           prodList = prodService.prodList(param, cate_lgu);

        ProdVo category = prodService.selectLgu(paramCate);
        String nameLGU = category.getCate_name();
        
        System.out.println("\n\n\n");
        System.out.println("                                                                       ┌───────────────── "+nameLGU+" ──────────────────┐");
        System.out.println("                                                                       ├───────────────── 메뉴 보드 ────────────────┤");
        print.printProdList(prodList);
        System.out.println("                                                                       ├────────────────────────────────────────┤");
        String prodName = ScanUtil.nextLine("                                                                   │\t수정할 음료 이름 : ");
        System.out.println("                                                                       └────────────────────────────────────────┘");
        System.out.println("\n");
        
        List<Object> param2 = new ArrayList();
        param2.add(prodName);
        
        ProdVo prod = prodService.prodDetail(param2);
        
        if(prod == null) {
            System.out.println("\n\n");
            System.out.println("                                                                       ┌────────────────── 에  러 ─────────────────┐");
            System.out.println("                                                                       │\t   상품을 찾을 수 없습니다.\t\t│");
            System.out.println("                                                                       └────────────────────────────────────────┘");
            System.out.println("\n\n");

            return View.ADMIN;
        }
        
        System.out.println("\n\n\n");
        System.out.println("                                                                       ┌────────────────── 설  명 ──────────────────┐");
        System.out.println("                                                                       │\t  이름 \t\t\t 가격\t │");
        System.out.println("                                                                       ├─────────────────────────────────────────┤");
        System.out.println("                                                                       │\t"+prod.getProd_name()+"\t\t\t"+prod.getProd_price()+"\t │");
        System.out.println("                                                                       │\t"+prod.getProd_detail()+" \t │");
        System.out.println("                                                                       ├─────────────────────────────────────────┤");
        System.out.println("                                                                       │\t\t1. 상품명 변경 \t\t │");
        System.out.println("                                                                       │\t\t2. 가격 변경 \t\t │");
        System.out.println("                                                                       │\t\t3. 상세설명 변경 \t\t │");
        System.out.println("                                                                       │\t\t4. 돌아가기 \t\t │");
        System.out.println("                                                                       └─────────────────────────────────────────┘");
        System.out.println("\n");
        
        List<Object> param3 = new ArrayList();
        int sel = ScanUtil.nextInt("                                                                                                                                                                               메뉴 선택 : ");

        if (sel == 1) {
           System.out.println("\n\n");
           System.out.println("                                                                       ┌───────────────── 메뉴 수정 ────────────────┐");
           String prodName2 = ScanUtil.nextLine("                                                                       \t 상품명 : ");
           System.out.println("                                                                       └────────────────────────────────────────┘");
           System.out.println("\n");
           
           param3.add(prodName2);
           param3.add(prod.getProd_name());

           System.out.println("\n\n");
           System.out.println("                                                                       ┌───────────────── 메뉴 수정 ────────────────┐");
           System.out.println("                                                                       │\t 메뉴 수정이 완료되었습니다.\t\t│");
           System.out.println("                                                                       └────────────────────────────────────────┘");
           System.out.println("\n");
        }
        if (sel == 2) {
           System.out.println("\n\n");
           System.out.println("                                                                       ┌───────────────── 메뉴 수정 ────────────────┐");
           String prodprice = ScanUtil.nextLine("                                                                       \t 가격 : ");
           System.out.println("                                                                       └────────────────────────────────────────┘");
           System.out.println("\n");
           
           param3.add(prodprice);
           param3.add(prod.getProd_name());
           
           
           System.out.println("\n\n");
           System.out.println("                                                                       ┌───────────────── 메뉴 수정 ────────────────┐");
           System.out.println("                                                                       │\t 메뉴 수정이 완료되었습니다.\t\t│");
           System.out.println("                                                                       └────────────────────────────────────────┘");
           System.out.println("\n");
        }
        if (sel == 3) {
           System.out.println("\n\n");
           System.out.println("                                                                       ┌───────────────── 메뉴 수정 ────────────────┐");
           String menuDetail = ScanUtil.nextLine("                                                                       \t상세설명 : ");
           System.out.println("                                                                       └────────────────────────────────────────┘");
           System.out.println("\n");
           
           param3.add(menuDetail);
           param3.add(prod.getProd_name());
           
           System.out.println("\n\n");
           System.out.println("                                                                       ┌───────────────── 메뉴 수정 ────────────────┐");
           System.out.println("                                                                       │\t 메뉴 수정이 완료되었습니다.\t\t│");
           System.out.println("                                                                       └────────────────────────────────────────┘");
           System.out.println("\n");
        }
        if (sel == 4) {

           return View.ADMIN;
        }
        prodService.prodUpdate(param3, sel);
        
        return View.ADMIN;
        
 }
 private View menuDelete() {
	   Print print = new Print(); 
	   System.out.println("\n\n\n");
     System.out.println("                                                                       ┌────────────────── 메 뉴 판 ────────────────┐");
     System.out.println("                                                                       │\t 삭제할 메뉴 카테고리 선택 \t\t│");
     System.out.println("                                                                       │\t\t 1. 커   피 \t\t│");
     System.out.println("                                                                       │\t\t 2. 논커피\t\t│");
     System.out.println("                                                                       │\t\t 3.  티   \t\t\t│");
     System.out.println("                                                                       │\t\t 4. 에이드\t\t│");
     System.out.println("                                                                       │\t\t 5. 스무디\t\t│");
     System.out.println("                                                                       └────────────────────────────────────────┘");
  System.out.println("\n");
  	  int cate_lgu = ScanUtil.nextInt("                                                                                                                                                                               메뉴 선택 : "); 
  	  
  	  List<ProdVo> prodList = null; 
        List<Object> paramCate = new ArrayList();

           List<Object> param = new ArrayList();
           if(cate_lgu == 1) {
              param.add(cate_lgu);
              paramCate.add(cate_lgu);
           }
           if(cate_lgu == 2) {
              param.add(cate_lgu);
              paramCate.add(cate_lgu);
           }
           if(cate_lgu == 3) {
              param.add(cate_lgu);
              paramCate.add(cate_lgu);
           }
           if(cate_lgu == 4) {
              param.add(cate_lgu);
              paramCate.add(cate_lgu);
           }
           if(cate_lgu == 5) {
              param.add(cate_lgu);
              paramCate.add(cate_lgu);
           }
           prodList = prodService.prodList(param, cate_lgu);

        ProdVo category = prodService.selectLgu(paramCate);
        String nameLGU = category.getCate_name();
        
        System.out.println("\n\n\n");
        System.out.println("                                                                       ┌───────────────── "+nameLGU+" ──────────────────┐");
        System.out.println("                                                                       ├───────────────── 메뉴 보드 ────────────────┤");
        print.printProdList(prodList);
        System.out.println("                                                                       ├────────────────────────────────────────┤");
        String prodName = ScanUtil.nextLine("                                                                   │\t삭제할 음료 이름 : ");
        System.out.println("                                                                       └────────────────────────────────────────┘");
        System.out.println("\n");
        
        List<Object> param2 = new ArrayList();
        param2.add(prodName);

        boolean success = prodService.prodDelete(param2);
        
        if (success) {
           System.out.println("\n\n");
           System.out.println("                                                                       ┌────────────────── 메뉴 삭제 ────────────────┐");
           System.out.println("                                                                       │\t 메뉴 삭제가 완료되었습니다. \t\t│");
           System.out.println("                                                                       └─────────────────────────────────────────┘");
           System.out.println("\n");
           return View.ADMIN;
        } else {
           System.out.println("\n\n");
           System.out.println("                                                                       ┌──────────────── 메뉴 삭제 ─────────────────┐");
           System.out.println("                                                                       │\t 메뉴 삭제에 실패했습니다.\t\t│");
           System.out.println("                                                                       │\t 메뉴명을 다시 확인해주세요.\t\t│");
           System.out.println("                                                                       └────────────────────────────────────────┘");
           System.out.println("\n");
           
           return View.ADMIN;
        }
 }
 
 private View totalSales() {
	   List<Map<String, Object>> totalSales = prodService.totalSales(); // 총매출을 구함
     System.out.println("                                                                       ┌───────────────  총매출  ──────────────────┐");
     if (!totalSales.isEmpty()) {
        Map<String, Object> firstSale = totalSales.get(0);
        Object totalPrice = firstSale.get("SUM(ORDER_PRICE*ORDER_QTY)");
        if (totalPrice != null) {
           System.out.println("\t\t\t\t\t\t\t\t       │\t\t"+totalPrice + "원                                     │");
        }
     }
     System.out.println("                                                                       │\t\t1. 홈\t\t\t│");
     System.out.println("                                                                       │\t\t2. 관리자 돌아가기\t\t│");
     System.out.println("                                                                       └────────────────────────────────────────┘");
     int sel = ScanUtil.nextInt("                                                                                                                                                                               메뉴 선택 : "); 
     switch (sel) {
          case 1: return View.MAIN;
          case 2: return View.ADMIN;
          default:
           return View.MAIN;   
     }  
 }
 
 
 private View admin() {
	   System.out.println("\n\n");
     System.out.println("                                                                       ┌──────────────관리자 페이지 ────────────────┐");
     System.out.println("                                                                       │\t\t1. 메뉴추가\t\t│");
     System.out.println("                                                                       │\t\t2. 메뉴수정\t\t│");
     System.out.println("                                                                       │\t\t3. 메뉴삭제\t\t│");
     System.out.println("                                                                       │\t\t4. 하루 총매출\t\t│");
     System.out.println("                                                                       │\t\t5. 홈\t\t\t│");
     System.out.println("                                                                       └───────────────────────────────────────┘");
     System.out.println("\n");
	   int sel = ScanUtil.nextInt("                                                                                                                                                                               메뉴 선택 : "); 
     switch (sel) {
          case 1: return View.MENU_INSERT;
          case 2: return View.MENU_UPDATE;
          case 3: return View.MENU_DELETE;
          case 4: return View.TOTAL_SALES;
          case 5: return View.MAIN;
          default:
           return View.MAIN;   
     }
 }
	
	private View reviewDelete() {
		int memNo = (int) sessionStorage.remove("memNo");
		String idL = (String) sessionStorage.remove("idL");
		String nameL = (String) sessionStorage.remove("nameL");
		
		System.out.println("\n\n");
		System.out.println("                                                                       ┌─────────────────── 메  뉴 ─────────────────┐");
		System.out.println("                                                                       │\t 리뷰를 삭제하시겠습니까?.\t\t │");
		int sel = ScanUtil.nextInt("                                                                       │\t 1. 네 \t\t 2. 아니오 \t │\n");
		System.out.println("                                                                       └────────────────────────────────────────┘");
		System.out.println();
		switch (sel) {
		case 1:
			System.out.println("\n\n");
			System.out.println("                                                                       ┌───────────────── 메  뉴 ─────────────────┐");
			String prodName = ScanUtil.nextLine("                                                                       │\t삭제할 리뷰 상품명 : ");
			System.out.println("                                                                       └───────────────────────────────────────┘");
			System.out.println();
			
			List<Object> param = new ArrayList<Object>();
			param.add(memNo);
			param.add(prodName);
			
			MemberVo rvMem = memberService.selectRv1(param);
			int rvNo = rvMem.getRv_no();
			
			List<Object> paramRv = new ArrayList<Object>();
			paramRv.add(rvNo);
			
			memberService.reviewDelete(paramRv);
			
			System.out.println("\n\n");
			System.out.println("                                                                       ┌────────────────── 리 뷰  ─────────────────┐");
			System.out.println("                                                                       │\t 리뷰가 삭제되었습니다.\t\t\t│");
			System.out.println("                                                                       └────────────────────────────────────────┘");
			System.out.println("\n\n");
			
			sessionStorage.put("memNo", memNo);
			sessionStorage.put("idL", idL);
			sessionStorage.put("nameL", nameL);
			
			return View.REVIEW;
		case 2:
			System.out.println("\n\n");
			System.out.println("                                                                       ┌────────────────── 리 뷰  ─────────────────┐");
			System.out.println("                                                                       │\t 리뷰 창으로 돌아갑니다.\t\t\t│");
			System.out.println("                                                                       └────────────────────────────────────────┘");
			System.out.println("\n\n");
			
			sessionStorage.put("memNo", memNo);
			sessionStorage.put("idL", idL);
			sessionStorage.put("nameL", nameL);
			
			return View.REVIEW;
		default:
    		System.out.println("\n\n");
    		System.out.println("                                                                       ┌────────────────── 에  러 ─────────────────┐");
    		System.out.println("                                                                       │\t해당 리뷰를 찾을 수 없습니다.\t\t\t│");
    		System.out.println("                                                                       └────────────────────────────────────────┘");
    		System.out.println("\n\n");
			sessionStorage.put("memNo", memNo);
			sessionStorage.put("idL", idL);
			sessionStorage.put("nameL", nameL);
			return View.REVIEW;
		}
	}

	private View reviewInsert() {
		// 카테고리, 음료 정보 읽어서 리뷰 작성
		int memNo = (int) sessionStorage.remove("memNo");
		String idL = (String) sessionStorage.remove("idL");
		String nameL = (String) sessionStorage.remove("nameL");
		
		List<ProdVo> prodList = null;
		Print print = new Print(); 
		List<Object> paramCate = new ArrayList();
		if(sessionStorage.containsKey("category")) {
			int category = (int) sessionStorage.remove("category");
			List<Object> param = new ArrayList();
			if(category == 1) {
				int prod = 1;
				param.add(prod);
				paramCate.add(prod);
			}
			if(category == 2) {
				int prod = 2;
				param.add(prod);
				paramCate.add(prod);
			}
			if(category == 3) {
				int prod = 3;
				param.add(prod);
				paramCate.add(prod);
			}
			if(category == 4) {
				int prod = 4;
				param.add(prod);
				paramCate.add(prod);
			}
			if(category == 5) {
				int prod = 5;
				param.add(prod);
				paramCate.add(prod);
			}
			prodList = prodService.prodList(param, category);
		}
		ProdVo category = prodService.selectLgu(paramCate);
		String nameLGU = category.getCate_name();
		
		System.out.println("\n\n\n");
		System.out.println("                                                                       ┌───────────────── "+nameLGU+" ──────────────────┐");
		System.out.println("                                                                       ├───────────────── 메뉴 보드 ────────────────┤");
		print.printProdList(prodList);
		System.out.println("                                                                       ├────────────────────────────────────────┤");
		System.out.println("                                                                       │\t 1. 리뷰 작성\t\t\t│");
		System.out.println("                                                                       │\t 2. 리뷰 메인\t\t\t│");
		System.out.println("                                                                       └────────────────────────────────────────┘");
		System.out.println("\n");

		int sel = ScanUtil.nextInt("                                                                                                                                                                               메뉴 선택 : ");

		switch (sel) {
			case 1:
				System.out.println("\n\n");
				System.out.println("                                                                       ┌───────────────── 메  뉴 ─────────────────┐");
				String prodName = ScanUtil.nextLine("                                                                       │\t음료 이름 : ");
				String content  = ScanUtil.nextLine("                                                                       │\t리뷰 내용 : ");
				System.out.println("                                                                       └───────────────────────────────────────┘");
				System.out.println("\n");
				
				
    			List<Object> paramRv = new ArrayList<Object>();
    			paramRv.add(prodName);
    			paramRv.add(content);
    			paramRv.add(memNo);
    			memberService.reviewInsert(paramRv);
    			
        		System.out.println("\n\n");
        		System.out.println("                                                                       ┌───────────────── 리 뷰  ─────────────────┐");
        		System.out.println("                                                                       │\t 리뷰가 작성되었습니다.\t\t\t│");
        		System.out.println("                                                                       └───────────────────────────────────────┘");
        		System.out.println("\n\n");
    			
    			sessionStorage.put("memNo", memNo);
    			sessionStorage.put("idL", idL);
    			sessionStorage.put("nameL", nameL);
				return View.REVIEW;
			case 2:
    			sessionStorage.put("memNo", memNo);
    			sessionStorage.put("idL", idL);
    			sessionStorage.put("nameL", nameL);
    			return View.REVIEW;
    		default :
        		System.out.println("\n\n");
        		System.out.println("                                                                       ┌───────────────── 에  러 ─────────────────┐");
        		System.out.println("                                                                       │\t 잘못된 입력입니다.\t\t\t│");
        		System.out.println("                                                                       └───────────────────────────────────────┘");
        		System.out.println("\n\n");
        		
    			sessionStorage.put("memNo", memNo);
    			sessionStorage.put("idL", idL);
    			sessionStorage.put("nameL", nameL);
    			return View.REVIEW_INSERT;
		}
	}

	private View myReview() {
		// 상품 선택 -> INSERT 넣고 조인으로 PROD_ID, MEM_NO
		String nameL = (String) sessionStorage.remove("nameL");
		String idL   = (String) sessionStorage.remove("idL");
		int memNo = (int) sessionStorage.remove("memNo");
		
		System.out.println("\n\n");
		System.out.println("                                                                             \t "+nameL+"님 환영합니다.\n");
		System.out.println("                                                                       ┌───────────────── 내 리뷰 ──────────────────┐");
		System.out.println("                                                                       │\t\t 1. 리뷰 작성\t \t │");
		System.out.println("                                                                       │\t\t 2. 리뷰 확인\t \t │");
		System.out.println("                                                                       │\t\t 3.  홈   \t\t\t │");
		System.out.println("                                                                       └─────────────────────────────────────────┘");
		System.out.println();
		
		int selMain = ScanUtil.nextInt("                                                                                                                                                                               메뉴 선택 : ");
		
		if(selMain == 1) {
			List<Object> param = new ArrayList<>();
			param.add(memNo);
			
			System.out.println("\n\n\n");
			System.out.println("                                                                       ┌────────────────── 메 뉴 판 ────────────────┐");
			System.out.println("                                                                       │\t\t 1. 커   피 \t\t│");
			System.out.println("                                                                       │\t\t 2. 논커피\t\t│");
			System.out.println("                                                                       │\t\t 3.  티   \t\t\t│");
			System.out.println("                                                                       │\t\t 4. 에이드\t\t│");
			System.out.println("                                                                       │\t\t 5. 스무디\t\t│");
			System.out.println("                                                                       │\t\t 6.  홈   \t\t\t│");
			System.out.println("                                                                       └────────────────────────────────────────┘");
			System.out.println("\n");
			
			int category = 0;
			System.out.println("\n\n");
			System.out.println("                                                                       ┌───────────────── 메  뉴 ─────────────────┐");
			int sel = ScanUtil.nextInt("                                                                       \t\t카테고리 선택 : ");
			System.out.println("                                                                       └───────────────────────────────────────┘");
			System.out.println("\n");
			switch (sel) {
			case 1: 
				category = 1;
				sessionStorage.put("nameL", nameL);
				sessionStorage.put("idL", idL);
				sessionStorage.put("memNo", memNo);
				sessionStorage.put("category", category);
				return View.REVIEW_INSERT; 
			case 2: 
				category = 2;
				sessionStorage.put("nameL", nameL);
				sessionStorage.put("idL", idL);
				sessionStorage.put("memNo", memNo);
				sessionStorage.put("category", category);
				return View.REVIEW_INSERT; 
			case 3: 
				category = 3;
				sessionStorage.put("nameL", nameL);
				sessionStorage.put("idL", idL);
				sessionStorage.put("memNo", memNo);
				sessionStorage.put("category", category);
				return View.REVIEW_INSERT; 
			case 4: 
				category = 4;
				sessionStorage.put("nameL", nameL);
				sessionStorage.put("idL", idL);
				sessionStorage.put("memNo", memNo);
				sessionStorage.put("category", category);
				return View.REVIEW_INSERT; 
			case 5: 
				category = 5;
				sessionStorage.put("nameL", nameL);
				sessionStorage.put("idL", idL);
				sessionStorage.put("memNo", memNo);
				sessionStorage.put("category", category);
				return View.REVIEW_INSERT; 
			case 6:	
				sessionStorage.put("nameL", nameL);
				sessionStorage.put("idL", idL);
				sessionStorage.put("memNo", memNo);
				return View.MEMBER;
			default:
				System.out.println("\n\n");
				System.out.println("                                                                       ┌───────────────── 에  러 ─────────────────┐");
				System.out.println("                                                                       │\t 잘못된 입력입니다.\t\t\t│");
				System.out.println("                                                                       └───────────────────────────────────────┘");
				System.out.println("\n\n");
				sessionStorage.put("nameL", nameL);
				sessionStorage.put("idL", idL);
				sessionStorage.put("memNo", memNo);
				return View.REVIEW;
			}
		}
		if (selMain == 2) {
			// 작성한 리뷰 리스트 보여주고 삭제
			Print print = new Print();
			List<Object> rvParam = new ArrayList();
			rvParam.add(memNo);
			List<MemberVo> memList = memberService.selectReview(rvParam);
			
			System.out.println("\n\n");
			System.out.println("                                                                       ┌───────────────── 내 리뷰 ──────────────────┐");
			print.printReviewList(memList);
			System.out.println("                                                                       ├─────────────────────────────────────────┤");
			System.out.println("                                                                       │\t\t 1. 리뷰 홈   \t\t\t │");
			System.out.println("                                                                       │\t\t 2. 리뷰 삭제\t \t │");
			System.out.println("                                                                       └─────────────────────────────────────────┘");
			System.out.println();
			
			int selRv = ScanUtil.nextInt("                                                                                                                                                                               메뉴 선택 : ");
			
			if(selRv == 1) {
				sessionStorage.put("nameL", nameL);
				sessionStorage.put("idL", idL);
				sessionStorage.put("memNo", memNo);
				return View.REVIEW;
			}
			if(selRv == 2) {
				sessionStorage.put("nameL", nameL);
				sessionStorage.put("idL", idL);
				sessionStorage.put("memNo", memNo);
				return View.REVIEW_DELETE;
			}
		}
		if(selMain == 3) {
			sessionStorage.put("nameL", nameL);
			sessionStorage.put("idL", idL);
			sessionStorage.put("memNo", memNo);
			return View.MEMBER;
		}
		sessionStorage.put("nameL", nameL);
		sessionStorage.put("idL", idL);
		sessionStorage.put("memNo", memNo);
		
		return View.REVIEW;
	}

	

	private View member() {
		if (sessionStorage.containsKey("nameL")) {
			String nameL = (String) sessionStorage.remove("nameL");
			String idL   = (String) sessionStorage.remove("idL");
			int memNo = (int) sessionStorage.remove("memNo");
			
			System.out.println("\n\n");
			System.out.println("                                                                             \t "+nameL+"님 환영합니다.\n");
			System.out.println("                                                                       ┌───────────────── 내 정보 ──────────────────┐");
			System.out.println("                                                                       │\t\t1. 회원 수정 \t \t │");
			System.out.println("                                                                       │\t\t2. 회원 탈퇴\t \t │");
			System.out.println("                                                                       │\t\t3. 스탬프 확인\t \t │");
			System.out.println("                                                                       │\t\t4. 주문하기\t \t │");
			System.out.println("                                                                       │\t\t5. 나의 리뷰\t \t │");
			System.out.println("                                                                       │\t\t6. 로그아웃\t \t │");
			System.out.println("                                                                       └─────────────────────────────────────────┘");
			System.out.println("\n");

			int sel = ScanUtil.nextInt("                                                                                                                                                                               메뉴 선택 : ");

			switch (sel) {
			case 1:
				sessionStorage.put("nameL", nameL);
				sessionStorage.put("idL", idL);
				sessionStorage.put("memNo", memNo);
				return View.MEMBER_UPDATE;
			case 2:
				sessionStorage.put("nameL", nameL);
				sessionStorage.put("idL", idL);
				sessionStorage.put("memNo", memNo);
				return View.MEMBER_DELETE;
			case 3:
				sessionStorage.put("nameL", nameL);
				sessionStorage.put("idL", idL);
				sessionStorage.put("memNo", memNo);
				return View.MEMBER_STAMP;
			case 4:
				sessionStorage.put("nameL", nameL);
				sessionStorage.put("idL", idL);
				sessionStorage.put("memNo", memNo);
				return View.PROD_MAIN;
			case 5:
				sessionStorage.put("nameL", nameL);
				sessionStorage.put("idL", idL);
				sessionStorage.put("memNo", memNo);
				return View.REVIEW;
			case 6:
				return View.MAIN;
			default:
				sessionStorage.put("nameL", nameL);
				sessionStorage.put("idL", idL);
				sessionStorage.put("memNo", memNo);
				return View.MEMBER;
			}
		}
		else {
			return View.LOGIN;
		}
	}

	   private View memberUpdate() {
		      String nameL = (String) sessionStorage.remove("nameL");
		      String idL   = (String) sessionStorage.remove("idL");
		      int memNo = (int) sessionStorage.remove("memNo");
		      
		      List<Object> paramPhone = new ArrayList<Object>();
		      paramPhone.add(idL);
		      paramPhone.add(nameL);
		      MemberVo phoneNum = memberService.selectMem(paramPhone);
		      String phoneMem = phoneNum.getMem_phone();
		      
		      System.out.println("\n\n");
		      System.out.println("                                                                               \t " + nameL +"님 환영합니다.\n");
		      System.out.println("                                                                       ┌────────────────── 내 정보 ─────────────────┐");
		      System.out.println("                                                                       │\t이      름 : "+nameL+"\t\t\t │");
		      System.out.println("                                                                       │\t아  이 디 : "+idL+"\t\t\t │");
		      System.out.println("                                                                       │\t전화번호 : "+phoneMem+"\t\t │");
		      System.out.println("                                                                       ├─────────────────────────────────────────┤");
		      System.out.println("                                                                       │\t\t1. 비밀번호 변경 \t\t │");
		      System.out.println("                                                                       │\t\t2. 이름 변경 \t\t │");
		      System.out.println("                                                                       │\t\t3. 전화번호 변경 \t\t │");
		      System.out.println("                                                                       │\t\t4. 돌아가기 \t\t │");
		      System.out.println("                                                                       └─────────────────────────────────────────┘");
		      System.out.println("\n");
		      
		      List<Object> param = new ArrayList();
				int sel = ScanUtil.nextInt("                                                                                                                                                                               메뉴 선택 : ");

		      if (sel == 1) {
		         System.out.println("\n\n");
		         System.out.println("                                                                       ┌───────────────── 정보 수정 ────────────────┐");
		         String pw = ScanUtil.nextLine("                                                                       \t 비밀번호 : ");
		         System.out.println("                                                                       └────────────────────────────────────────┘");
		         System.out.println("\n");
		         
		         param.add(pw);
		         param.add(nameL);
		         param.add(idL);
		         
		         sessionStorage.put("nameL", nameL);
		         sessionStorage.put("idL", idL);
		         sessionStorage.put("memNo", memNo);
		         
		         System.out.println("\n\n");
		         System.out.println("                                                                       ┌───────────────── 정보 수정 ────────────────┐");
		         System.out.println("                                                                       │\t 정보 수정이 완료되었습니다.\t\t│");
		         System.out.println("                                                                       └────────────────────────────────────────┘");
		         System.out.println("\n");
		      }
		      if (sel == 2) {
		         System.out.println("\n\n");
		         System.out.println("                                                                       ┌───────────────── 정보 수정 ────────────────┐");
		         String name = ScanUtil.nextLine("                                                                       \t 이름 : ");
		         System.out.println("                                                                       └────────────────────────────────────────┘");
		         System.out.println("\n");
		         
		         param.add(name);
		         param.add(nameL);
		         param.add(idL);
		         
		         sessionStorage.put("nameL", name);
		         sessionStorage.put("idL", idL);
		         sessionStorage.put("memNo", memNo);
		         
		         System.out.println("\n\n");
		         System.out.println("                                                                       ┌───────────────── 정보 수정 ────────────────┐");
		         System.out.println("                                                                       │\t 정보 수정이 완료되었습니다.\t\t│");
		         System.out.println("                                                                       └────────────────────────────────────────┘");
		         System.out.println("\n");
		      }
		      if (sel == 3) {
		         System.out.println("\n\n");
		         System.out.println("                                                                       ┌───────────────── 정보 수정 ────────────────┐");
		         String phone = ScanUtil.nextLine("                                                                       \t전화번호 : ");
		         System.out.println("                                                                       └────────────────────────────────────────┘");
		         System.out.println("\n");
		         
		         param.add(phone);
		         param.add(nameL);
		         param.add(idL);
		         
		         sessionStorage.put("nameL", nameL);
		         sessionStorage.put("idL", idL);
		         sessionStorage.put("memNo", memNo);
		         
		         System.out.println("\n\n");
		         System.out.println("                                                                       ┌───────────────── 정보 수정 ────────────────┐");
		         System.out.println("                                                                       │\t 정보 수정이 완료되었습니다.\t\t│");
		         System.out.println("                                                                       └────────────────────────────────────────┘");
		         System.out.println("\n");
		      }
		      if (sel == 4) {
		    	  sessionStorage.put("nameL", nameL);
			      sessionStorage.put("idL", idL);
			      sessionStorage.put("memNo", memNo);
			      return View.MEMBER;
		      }
		      memberService.memberUpdate(param, sel);
		      
		      return View.MEMBER;
		   }

	   private View memberDelete() {
		      int memNo = (int) sessionStorage.remove("memNo");
		      List<Object> param = new ArrayList();
		      String nameL = (String) sessionStorage.remove("nameL");
		      String idL   = (String) sessionStorage.remove("idL");
		      System.out.println("\n\n");
		      System.out.println("                                                                       \t"+nameL+"님 \n");
		      System.out.println("                                                                       ┌───────────────── 회원탈퇴 ────────────────┐");
		      System.out.println("                                                                       │   "+nameL+"님의 비밀번호를 입력해주십시오.\t\t│");
		      String pw = ScanUtil.nextLine("                                                                       \t   비밀번호 : ");
		      System.out.println("                                                                       └────────────────────────────────────────┘");
		      System.out.println("\n");
		      
		      param.add(nameL);
		      param.add(idL);
		      param.add(pw);
		      boolean success = memberService.memberDelete(param);
		      
		      if (success) {
		         System.out.println("\n\n");
		         System.out.println("                                                                       ┌────────────────── 회원탈퇴 ────────────────┐");
		         System.out.println("                                                                       │\t 회원 삭제가 완료되었습니다. \t\t│");
		         System.out.println("                                                                       └─────────────────────────────────────────┘");
		         System.out.println("\n");
		         return View.MAIN;
		      } else {
		         System.out.println("\n\n");
		         System.out.println("                                                                       ┌──────────────── 회원탈퇴 ─────────────────┐");
		         System.out.println("                                                                       │\t 회원 삭제에 실패했습니다.\t\t│");
		         System.out.println("                                                                       │\t 비밀번호를 다시 확인해주세요.\t\t│");
		         System.out.println("                                                                       └────────────────────────────────────────┘");
		         System.out.println("\n");
		         
		         sessionStorage.put("nameL", nameL);
		         sessionStorage.put("idL", idL);
		         sessionStorage.put("memNo", memNo);
		         return View.MEMBER;
		      }
		   }

	private View myStamp() {
		int memNo = (int) sessionStorage.remove("memNo");
		List<Object> param = new ArrayList();
		String idL = (String) sessionStorage.remove("idL");
		String nameL = (String) sessionStorage.remove("nameL");
		param.add(idL);
		
		MemberVo myStamp = memberService.myStamp(param);
		int stampL = myStamp.getMem_stamp();
		
		System.out.println("\n\n");
		System.out.println("                                                                       ┌───────────────── 스 탬 프  ────────────────┐");
		System.out.println("                                                                       │\t\t"+nameL + " 님의 스탬프\t\t│");
		System.out.println("                                                                       │\t 현재 보유중인 스탬프는 총 " + stampL + "개 입니다.\t│");
		System.out.println("                                                                       └────────────────────────────────────────┘");
		System.out.println("\n");
		
		sessionStorage.put("nameL", nameL);
		sessionStorage.put("idL", idL);
		sessionStorage.put("memNo", memNo);
		
		return View.MEMBER;
	}
	

	private View sign() {
		System.out.println("\n\n");
		System.out.println("                                                                       ┌─────────────── 회원가입──────────────────┐");
		String mem_id   = ScanUtil.nextLine("                                                                       \t아 이  디 : ");
		String mem_pw   = ScanUtil.nextLine("                                                                       \t비밀번호 : ");
		String mem_name = ScanUtil.nextLine("                                                                       \t이      름 : ");
		int mem_phone   =  ScanUtil.nextInt("                                                                       \t전화번호 : ");
		System.out.println("                                                                       └────────────────────────────────────────┘");
		System.out.println("\n\n");
		
		List<Object> param = new ArrayList<Object>();
		param.add(mem_id);
		param.add(mem_pw);
		param.add(mem_name);
		param.add(mem_phone);
		memberService.sign(param);
		
		return View.MAIN;
	}
	
	private View login() {
		System.out.println("\n\n");
		System.out.println("                                                                       ┌─────────────── 로 그 인 ──────────────────┐");
		String id = ScanUtil.nextLine("                                                                            \tID : ");
		String pw = ScanUtil.nextLine("                                                                            \tPW : ");
		System.out.println("                                                                       └───────────────────────────────────────┘");
		System.out.println("\n\n");
		
		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pw);
		boolean login = memberService.login(param);
		if(!login) {
			System.out.println("\n\n");
			System.out.println("                                                                       ┌────────────── 로그인 실 패 ────────────────┐");
			System.out.println("                                                                       │\t\t1. 재로그인\t\t│");
			System.out.println("                                                                       │\t\t2. 회원가입\t\t│");
			System.out.println("                                                                       │\t\t3. 홈\t\t\t│");
			System.out.println("                                                                       └───────────────────────────────────────┘");
			System.out.println("\n");
			
			int sel = ScanUtil.nextInt("                                                                                                                                                                               메뉴 선택 : ");

			if(sel==1)return View.LOGIN;
			else if(sel==2)return View.SIGN;
			else if(sel==3)return View.MAIN;
			else return View.LOGIN;
		}
		if (login) {
			MemberVo member = memberService.selectName(param);
			String nameL = member.getMem_name();
			String idL = member.getMem_id();
			int memNo = member.getMem_no();
			int grade = member.getGrade_no();
			if(grade == 1) {
				sessionStorage.put("memNo", memNo);
				sessionStorage.put("idL", idL);
				sessionStorage.put("nameL", nameL);
				return View.MEMBER;
			}
			if(grade == 2) {
				sessionStorage.put("memNo", memNo);
				sessionStorage.put("idL", idL);
				sessionStorage.put("nameL", nameL);
				return View.ADMIN;
			}

		}
		return View.MAIN;
	}
	
	private View payment() {
		int memNo = (int) sessionStorage.remove("memNo");
		int total = (int) sessionStorage.remove("total");
		int stamp = (int) sessionStorage.remove("stamp");
		String idL = (String) sessionStorage.remove("idL");
		String nameL = (String) sessionStorage.remove("nameL");
		int money = 0;
		
		List<Object> param = new ArrayList<>();
		param.add(idL);
		MemberVo member = memberService.myStamp(param);
		int stampMy = member.getMem_stamp();
		
		System.out.println("\n\n");
		System.out.println("                                                                       ┌───────────────── 스 탬 프  ────────────────┐");
		System.out.println("                                                                       │\t현재 스탬프 : "+stampMy+"\t\t\t│");
		System.out.println("                                                                       │\t\t\t\t\t│");		
		System.out.println("                                                                       │\t스탬프를 사용하시겠습니까? \t\t│");
		int sel = ScanUtil.nextInt("                                                                       │\t1. 네\t\t 2. 아니오\t│\n");
		System.out.println("                                                                       │\t\t\t\t\t│");
		System.out.println("                                                                       └────────────────────────────────────────┘");
		System.out.println();
		
		if(sel == 1) {
			if(stampMy >= 10) {
				System.out.println("                                                                       ┌───────────────── 스 탬 프 ─────────────────┐");
				int useStamp = ScanUtil.nextInt("                                                                       │ 사용하실 스탬프의 개수를 입력하세요. (10개 단위) \t│ \n");
				System.out.println("                                                                       └────────────────────────────────────────┘");
				if(useStamp > stampMy) {
		    		System.out.println("\n\n");
		    		System.out.println("                                                                       ┌────────────────── 에  러 ─────────────────┐");
		    		System.out.println("                                                                       │\t스탬프의 개수가 부족합니다.\t\t│");
		    		System.out.println("                                                                       └────────────────────────────────────────┘");
		    		System.out.println("\n\n");
					sessionStorage.put("total", total);
	            	sessionStorage.put("stamp", stamp);
	    			sessionStorage.put("nameL", nameL);
	        	    sessionStorage.put("memNo", memNo);
	        	    sessionStorage.put("idL", idL);
	                return View.PAYMENT;
				}
				if(useStamp%10 != 0) {
		    		System.out.println("\n\n");
		    		System.out.println("                                                                       ┌───────────────── 에  러 ─────────────────┐");
		    		System.out.println("                                                                       │\t스탬프의 사용개수가 올바르지 않습니다.\t│");
		    		System.out.println("                                                                       └───────────────────────────────────────┘");
		    		System.out.println("\n\n");
					sessionStorage.put("total", total);
	            	sessionStorage.put("stamp", stamp);
	    			sessionStorage.put("nameL", nameL);
	        	    sessionStorage.put("memNo", memNo);
	        	    sessionStorage.put("idL", idL);
	                return View.PAYMENT;
				}
				if((useStamp/10)*3000 > total) {
			    	System.out.println("\n\n");
			    	System.out.println("                                                                       ┌───────────────── 에  러 ─────────────────┐");
			    	System.out.println("                                                                       │\t결재금액을 초과하였습니다.\t\t│");
			    	System.out.println("                                                                       └───────────────────────────────────────┘");
			    	System.out.println("\n\n");
					sessionStorage.put("total", total);
	            	sessionStorage.put("stamp", stamp);
	    			sessionStorage.put("nameL", nameL);
	        	    sessionStorage.put("memNo", memNo);
	        	    sessionStorage.put("idL", idL);
	                return View.PAYMENT;
				}
				money = 3000 * (useStamp/10);
				stampMy -= useStamp;
				total -= money;
				
				System.out.println();
				System.out.println("                                                                       ┌───────────────── 영 수 증 ─────────────────┐");
				if(total == 0) 
					System.out.println("                                                                       │\t지불 가격  "+total+" 원 입니다.\t\t\t│");
				System.out.println("                                                                       │\t지불 가격  "+total+" 원 입니다.\t\t│");
				System.out.println("                                                                       └────────────────────────────────────────┘");
				System.out.println("\n");
			}
			else {
	    		System.out.println("\n\n");
	    		System.out.println("                                                                       ┌───────────────── 에  러 ─────────────────┐");
	    		System.out.println("                                                                       │\t스탬프의 개수가 부족합니다.\t\t│");
	    		System.out.println("                                                                       └───────────────────────────────────────┘");
	    		System.out.println("\n\n");
			}
		}
		if(sel == 2 ) {
			System.out.println();
			System.out.println("                                                                       ┌──────────────── 영 수 증  ─────────────────┐");
			if(total == 0)
				System.out.println("                                                                       │\t지불 가격  "+total+" 원 입니다.\t\t\t│");
			System.out.println("                                                                       │\t지불 가격  "+total+" 원 입니다.\t\t│");
			System.out.println("                                                                       └────────────────────────────────────────┘");
			System.out.println("\n");
		}
		
		System.out.println();
		System.out.println("                                                                       ┌────────────────── 메  뉴 ─────────────────┐");
		System.out.println("                                                                       │\t\t1. 결제\t\t\t│");
		System.out.println("                                                                       │\t\t2. 재 주문\t\t\t│");
		System.out.println("                                                                       └────────────────────────────────────────┘");
		System.out.println();
		
		int sell = ScanUtil.nextInt("                                                                                                                                                                               메뉴 선택 : ");

		switch (sell) {
		case 1:
			System.out.println();
			System.out.println("                                                                       ┌──────────────── 영 수 증  ─────────────────┐");
			System.out.println("                                                                       │\t"+total+" 원 결제되셨습니다.\t\t│");
			System.out.println("                                                                       └────────────────────────────────────────┘");
			System.out.println("\n\n");
			stamp = stampMy + stamp;
			prodService.insertOrder();
			prodService.cartReset();
			List<Object> paramMem = new ArrayList();
			paramMem.add(stamp);
			paramMem.add(idL);
			memberService.memberStamp(paramMem);
			sessionStorage.put("nameL", nameL);
    	    sessionStorage.put("memNo", memNo);
    	    sessionStorage.put("idL", idL);
			return View.MEMBER;
		case 2:
			prodService.cartReset();
			sessionStorage.put("nameL", nameL);
			sessionStorage.put("idL", idL);
			sessionStorage.put("memNo", memNo);
			return View.PROD_MAIN;
		default:
			return View.MAIN;
		}
	}
	
	private View order() {
		int memNo = (int) sessionStorage.remove("memNo");
		String idL = (String) sessionStorage.remove("idL");
		String nameL = (String) sessionStorage.remove("nameL");
		
		
		List<Object> param = new ArrayList<>();
		param.add(idL);
		MemberVo myStamp = memberService.myStamp(param);
		int stampMy = myStamp.getMem_stamp();
		int total = 0;
		int totalStamp = 0;
	    List<CartVo> cartItems = prodService.getAllCartItems();
	    
	    if (!cartItems.isEmpty()) {
    		System.out.println("                                                                       ┌───────────────── 주문 내역 ────────────────┐");
	        for (CartVo item : cartItems) {
	    		System.out.println("                                                                       │\t제품명 : "+item.getProd_name()+"\t\t\t│");
	    		System.out.println("                                                                       │\t지불 하실 가격 : "+item.getProd_price()*item.getProd_count()+" 원  \t\t│");
	    		System.out.println("                                                                       │\t스탬프 "+item.getProd_count()+" 개 적립될 예정입니다.\t\t│");
	    		System.out.println("                                                                       └────────────────────────────────────────┘");

	            totalStamp += item.getProd_count();
	            total += item.getProd_price()*item.getProd_count();
	        }
	        
    		System.out.println("\n\n");
    		System.out.println("                                                                       ┌───────────────── 스 탬 프  ────────────────┐");
    		System.out.println("                                                                       │\t현재 스탬프 : "+stampMy+"\t\t\t│");
    		System.out.println("                                                                       │\t적립 스탬프 : "+ totalStamp+"\t\t\t│");
    		System.out.println("                                                                       │\t 지불 가격  : "+ total +" 원 입니다.\t\t│");    		
    		System.out.println("                                                                       └────────────────────────────────────────┘");
	        
	        System.out.println();
    		System.out.println("                                                                       ┌────────────────── 메  뉴 ─────────────────┐");
    		System.out.println("                                                                       │\t\t1. 결제\t\t\t│");
    		System.out.println("                                                                       │\t\t2. 취소하기\t\t│");
    		System.out.println("                                                                       └────────────────────────────────────────┘");
    		System.out.println("\n");
    		
    		int sel = ScanUtil.nextInt("                                                                                                                                                                               메뉴 선택 : ");

	        switch (sel) {
	            case 1:
	            	sessionStorage.put("total", total);
	            	sessionStorage.put("stamp", totalStamp);
	    			sessionStorage.put("nameL", nameL);
	        	    sessionStorage.put("memNo", memNo);
	        	    sessionStorage.put("idL", idL);
	                return View.PAYMENT;
	            case 2:
	            	prodService.cartReset();
	    			sessionStorage.put("nameL", nameL);
	    			sessionStorage.put("idL", idL);
	    			sessionStorage.put("memNo", memNo);
	                return View.PROD_MAIN;
	            default:
	                return View.ORDER;
	        }
	    } else {
    		System.out.println("\n\n");
    		System.out.println("                                                                       ┌────────────────── 에  러 ─────────────────┐");
    		System.out.println("                                                                       │\t주문 내역이 존재하지 않습니다.\t\t│");
    		System.out.println("                                                                       └────────────────────────────────────────┘");
    		System.out.println("\n\n");
        	sessionStorage.put("memNo", memNo);
        	sessionStorage.put("idL", idL);
			sessionStorage.put("nameL", nameL);
	        return View.PROD_MAIN;
	    }
	}
	
	
	private View orderDetail() {
	    int total = 0;
	    int memNo = (int) sessionStorage.remove("memNo");
	    String idL = (String) sessionStorage.remove("idL");
	    String nameL = (String) sessionStorage.remove("nameL");
	    
	    if (sessionStorage.containsKey("orderName") && sessionStorage.containsKey("orderCount")) {
	        String orderName = (String) sessionStorage.get("orderName");
	        int orderCount = (int) sessionStorage.get("orderCount");
	        List<Object> param = new ArrayList<>();
	        param.add(orderName);
	        
	        ProdVo prodList = prodService.prodDetail(param);
	        if (prodList != null) {
	            int price = prodList.getProd_price();
	            int subtotal = price * orderCount;
	            total += subtotal;
	            
	            List<Object> cartParam = new ArrayList<>();
	            cartParam.add(orderName);
	            cartParam.add(orderCount);
	            cartParam.add(price);
	            cartParam.add(memNo);
	            prodService.insertCart(cartParam);
	            
	    		System.out.println("\n\n\n");
	    		System.out.println("                                                                       ┌────────────────── 주 문 ─────────────────┐");
	    		System.out.println("                                                                       │\t  이름 \t\t 개수 \t 가격\t│");
	    		System.out.println("                                                                       ├────────────────────────────────────────┤");
	    		System.out.println("                                                                       │\t"+orderName+"\t\t"+orderCount+"\t"+total+"원\t│");
	    		System.out.println("                                                                       └────────────────────────────────────────┘");
	    		System.out.println("\n");
	    		
	    		System.out.println("                                                                       ┌────────────────── 메  뉴 ─────────────────┐");
	    		System.out.println("                                                                       │\t\t1. 추가 주문\t\t│");
	    		System.out.println("                                                                       │\t\t2. 결제\t\t\t│");
	    		System.out.println("                                                                       └────────────────────────────────────────┘");
	    		System.out.println("\n");
	    		int sel = ScanUtil.nextInt("                                                                                                                                                                               메뉴 선택 : ");

	            switch (sel) {
	                case 1:
	        			sessionStorage.put("memNo", memNo);
	        			sessionStorage.put("idL", idL);
	        			sessionStorage.put("nameL", nameL);
	                    return View.PROD_MAIN;
	                case 2:
	                	sessionStorage.put("memNo", memNo);
	                	sessionStorage.put("idL", idL);
	        			sessionStorage.put("nameL", nameL);
	                    return View.ORDER;
	                default:
	        			sessionStorage.put("memNo", memNo);
	        			sessionStorage.put("idL", idL);
	        			sessionStorage.put("nameL", nameL);
	                    return View.ORDER_DETAIL;
	            }
	        } else {
	    		System.out.println("\n\n");
	    		System.out.println("                                                                       ┌────────────────── 에  러 ─────────────────┐");
	    		System.out.println("                                                                       │\t상품을 찾을 수 없습니다.\t\t\t│");
	    		System.out.println("                                                                       └────────────────────────────────────────┘");
	    		System.out.println("\n\n");
    			sessionStorage.put("memNo", memNo);
    			sessionStorage.put("idL", idL);
    			sessionStorage.put("nameL", nameL);
	    		return View.PROD_MAIN;
	        }
	    } else {
    		System.out.println("\n\n");
    		System.out.println("                                                                       ┌────────────────── 에  러 ──────────────────┐");
    		System.out.println("                                                                       │\t주문 내역이 존재하지 않습니다.\t\t│");
    		System.out.println("                                                                       └─────────────────────────────────────────┘");
    		System.out.println("\n\n");
        	sessionStorage.put("memNo", memNo);
        	sessionStorage.put("idL", idL);
			sessionStorage.put("nameL", nameL);
    		return View.PROD_MAIN;
	    }
	}
	
	private View prodDetail() {
		Print print = new Print(); 
		int memNo = (int) sessionStorage.remove("memNo");
		String idL = (String) sessionStorage.remove("idL");
		String nameL = (String) sessionStorage.remove("nameL");		
		
		String prodName = (String) sessionStorage.remove("prodName");
		List<Object> param = new ArrayList();
		param.add(prodName);
		
		ProdVo prod = prodService.prodDetail(param);
		String orderName = prodName;
		
		if(prod == null) {
    		System.out.println("\n\n");
    		System.out.println("                                                                       ┌────────────────── 에  러 ─────────────────┐");
    		System.out.println("                                                                       │\t   상품을 찾을 수 없습니다.\t\t│");
    		System.out.println("                                                                       └────────────────────────────────────────┘");
    		System.out.println("\n\n");
			sessionStorage.put("memNo", memNo);
			sessionStorage.put("idL", idL);
			sessionStorage.put("nameL", nameL);
    		return View.PROD_MAIN;
		}
		List<Object> ParamRv = new ArrayList<Object>();
		ParamRv.add(prodName);
		List<MemberVo> rvList = memberService.reviewMenu(ParamRv);
		
		System.out.println("\n\n\n");
		System.out.println("                                                                       ┌────────────────── 설  명 ──────────────────┐");
		System.out.println("                                                                       │\t  이름 \t\t\t 가격\t │");
		System.out.println("                                                                       ├─────────────────────────────────────────┤");
		System.out.println("                                                                       │\t"+prod.getProd_name()+"\t\t\t"+prod.getProd_price()+"\t │");
		System.out.println("                                                                       │\t"+prod.getProd_detail()+" \t │");
		print.printReviewMenu(rvList);
		System.out.println("                                                                       └─────────────────────────────────────────┘");
		System.out.println("\n");
		
		System.out.println("                                                                       ┌───────────────── 메  뉴 ──────────────────┐");
		System.out.println("                                                                       │\t\t1. 주문하기\t\t│");
		System.out.println("                                                                       │\t\t2. 메뉴로 돌아가기\t\t│");
		System.out.println("                                                                       └────────────────────────────────────────┘");
		System.out.println("\n");
		int sel = ScanUtil.nextInt("                                                                                                                                                                               메뉴 선택 : ");

		switch (sel) {
			case 1:
				System.out.println();
				System.out.println("                                                                       ┌───────────────── 메  뉴 ─────────────────┐");
				int orderCount = ScanUtil.nextInt("                                                                       │\t주문 개수 : ");
				System.out.println("                                                                       └───────────────────────────────────────┘");
				sessionStorage.put("orderName", orderName);
				sessionStorage.put("orderCount", orderCount);
	        	sessionStorage.put("memNo", memNo);
	        	sessionStorage.put("idL", idL);
				sessionStorage.put("nameL", nameL);
				return View.ORDER_DETAIL;
			case 2:
	        	sessionStorage.put("memNo", memNo);
	        	sessionStorage.put("idL", idL);
				sessionStorage.put("nameL", nameL);
				return View.PROD_MAIN;
			default: 

    			sessionStorage.put("memNo", memNo);
    			sessionStorage.put("idL", idL);
    			sessionStorage.put("nameL", nameL);
				return View.PROD_DETAIL;
		}
	}
	
	
	private View category() {
		int memNo = (int) sessionStorage.remove("memNo");
		String idL = (String) sessionStorage.remove("idL");
		String nameL = (String) sessionStorage.remove("nameL");
		
		List<ProdVo> prodList = null;
		Print print = new Print(); 
		List<Object> paramCate = new ArrayList();
		if(sessionStorage.containsKey("category")) {
			int category = (int) sessionStorage.remove("category");
			
			List<Object> param = new ArrayList();
			if(category == 1) {
				int prod = 1;
				param.add(prod);
				paramCate.add(prod);
			}
			if(category == 2) {
				int prod = 2;
				param.add(prod);
				paramCate.add(prod);
			}
			if(category == 3) {
				int prod = 3;
				param.add(prod);
				paramCate.add(prod);
			}
			if(category == 4) {
				int prod = 4;
				param.add(prod);
				paramCate.add(prod);
			}
			if(category == 5) {
				int prod = 5;
				param.add(prod);
				paramCate.add(prod);
			}
			prodList = prodService.prodList(param, category);
		}
		ProdVo category = prodService.selectLgu(paramCate);
		String nameLGU = category.getCate_name();
		
		System.out.println("\n\n\n");
		System.out.println("                                                                        ───────────────── "+nameLGU+" ──────────────────");
		print.printProdList(prodList);
		System.out.println("                                                                       ├────────────────────────────────────────┤");
		System.out.println("                                                                       │\t 1. 메뉴 설명\t\t\t│");
		System.out.println("                                                                       │\t 2. 주문하기\t\t\t│");
		System.out.println("                                                                       │\t 3. 음료 메인\t\t\t│");
		System.out.println("                                                                       └────────────────────────────────────────┘");
		System.out.println("\n");

		int sel = ScanUtil.nextInt("                                                                                                                                                                               메뉴 선택 : ");

		switch (sel) {
			case 1:
				System.out.println("\n\n");
				System.out.println("                                                                       ┌───────────────── 메  뉴 ─────────────────┐");
				String prodName = ScanUtil.nextLine("                                                                       │\t음료 이름 : ");
				System.out.println("                                                                       └───────────────────────────────────────┘");
				System.out.println("\n");
				sessionStorage.put("prodName", prodName);
    			sessionStorage.put("memNo", memNo);
    			sessionStorage.put("idL", idL);
    			sessionStorage.put("nameL", nameL);
				return View.PROD_DETAIL;
			case 2:
				System.out.println("\n\n");
				System.out.println("                                                                       ┌───────────────── 메  뉴 ─────────────────┐");
				String orderName = ScanUtil.nextLine("                                                                       │\t음료 이름 : ");
				int orderCount = ScanUtil.nextInt("                                                                       │\t주문 개수 : ");
				System.out.println("                                                                       └───────────────────────────────────────┘");
				System.out.println("\n");
				sessionStorage.put("orderName", orderName);
				sessionStorage.put("orderCount", orderCount);
    			sessionStorage.put("memNo", memNo);
    			sessionStorage.put("idL", idL);
    			sessionStorage.put("nameL", nameL);
				return View.ORDER_DETAIL;	
			case 3:
    			sessionStorage.put("memNo", memNo);
    			sessionStorage.put("idL", idL);
    			sessionStorage.put("nameL", nameL);
				return View.PROD_MAIN;
			default:
	    		System.out.println("\n\n");
	    		System.out.println("                                                                       ┌───────────────── 에  러 ─────────────────┐");
	    		System.out.println("                                                                       │\t상품을 찾을 수 없습니다.\t\t\t│");
	    		System.out.println("                                                                       └───────────────────────────────────────┘");
	    		System.out.println("\n\n");
    			sessionStorage.put("memNo", memNo);
    			sessionStorage.put("idL", idL);
    			sessionStorage.put("nameL", nameL);
	    		return View.PROD_MAIN;
		}
	}
	
	private View prodMain() {
		int memNo = (int) sessionStorage.remove("memNo");
		String idL = (String) sessionStorage.remove("idL");
		String nameL = (String) sessionStorage.remove("nameL");
		
		List<Object> param = new ArrayList<>();
		param.add(memNo);
		
		System.out.println("\n\n\n");
        System.out.println("                                                                       ┌────────────────── 메 뉴 판 ────────────────┐");
        System.out.println("                                                                       │\t\t 1. 커   피 \t\t│");
        System.out.println("                                                                       │\t\t 2. 논커피\t\t│");
        System.out.println("                                                                       │\t\t 3.  티   \t\t\t│");
        System.out.println("                                                                       │\t\t 4. 에이드\t\t│");
        System.out.println("                                                                       │\t\t 5. 스무디\t\t│");
        System.out.println("                                                                       │\t\t 6. 결제하기\t\t│");
        System.out.println("                                                                       │\t\t 7.  홈   \t\t\t│");
        System.out.println("                                                                       └────────────────────────────────────────┘");
		System.out.println("\n");
		
		int category = 0;
		System.out.println("\n\n");
		System.out.println("                                                                       ┌───────────────── 메  뉴 ─────────────────┐");
		int sel = ScanUtil.nextInt("                                                                       \t\t카테고리 선택 : ");
		System.out.println("                                                                       └───────────────────────────────────────┘");
		System.out.println("\n");
		switch (sel) {
		case 1: 
			category = 1;
			sessionStorage.put("nameL", nameL);
			sessionStorage.put("idL", idL);
			sessionStorage.put("memNo", memNo);
			sessionStorage.put("category", category);
			return View.CATEGORY; 
		case 2: 
			category = 2;
			sessionStorage.put("nameL", nameL);
			sessionStorage.put("idL", idL);
			sessionStorage.put("memNo", memNo);
			sessionStorage.put("category", category);
			return View.CATEGORY; 
		case 3: 
			category = 3;
			sessionStorage.put("nameL", nameL);
			sessionStorage.put("idL", idL);
			sessionStorage.put("memNo", memNo);
			sessionStorage.put("category", category);
			return View.CATEGORY; 
		case 4: 
			category = 4;
			sessionStorage.put("nameL", nameL);
			sessionStorage.put("idL", idL);
			sessionStorage.put("memNo", memNo);
			sessionStorage.put("category", category);
			return View.CATEGORY; 
		case 5: 
			category = 5;
			sessionStorage.put("nameL", nameL);
			sessionStorage.put("idL", idL);
			sessionStorage.put("memNo", memNo);
			sessionStorage.put("category", category);
			return View.CATEGORY; 
		case 6:
			boolean cart = prodService.selectCart(param);
			if (!cart) {
	    		System.out.println("\n\n");
	    		System.out.println("                                                                       ┌────────────────── 에  러 ─────────────────┐");
	    		System.out.println("                                                                       │주문 내역이 존재하지 않습니다.\t\t│");
	    		System.out.println("                                                                       └────────────────────────────────────────┘");
	    		System.out.println("\n\n");
			}
			sessionStorage.put("nameL", nameL);
			sessionStorage.put("idL", idL);
			sessionStorage.put("memNo", memNo);
			return View.ORDER;
		case 7:	
			prodService.cartReset();
			sessionStorage.put("nameL", nameL);
			sessionStorage.put("idL", idL);
			sessionStorage.put("memNo", memNo);
			return View.MEMBER;
		default:
    		System.out.println("\n\n");
    		System.out.println("                                                                       ┌───────────────── 에  러 ─────────────────┐");
    		System.out.println("                                                                       │\t 잘못된 입력입니다.\t\t\t│");
    		System.out.println("                                                                       └───────────────────────────────────────┘");
    		System.out.println("\n\n");
			sessionStorage.put("nameL", nameL);
			sessionStorage.put("idL", idL);
			sessionStorage.put("memNo", memNo);
			return View.MEMBER;
		}
	}
	
	
	private View home() {
		String asciiArt = 
			   "                                                                                                                                          \r\n" +
			   "                                                                                                                                          \r\n" + 
	           "                                           ██████  ██████  ███████ ███████ ███████ ███████     ███    ███  █████  ██   ██ ███████ ██████  \r\n" + 
	           "                                          ██      ██    ██ ██      ██      ██      ██          ████  ████ ██   ██ ██  ██  ██      ██   ██ \r\n" + 
	           "                                          ██      ██    ██ █████   █████   █████   █████       ██ ████ ██ ███████ █████   █████   ██████  \r\n" + 
	           "                                          ██      ██    ██ ██      ██      ██      ██          ██  ██  ██ ██   ██ ██  ██  ██      ██   ██ \r\n" + 
	           "                                           ██████  ██████  ██      ██      ███████ ███████     ██      ██ ██   ██ ██   ██ ███████ ██   ██ \r\n" +
			   "                                                                                                                                          \r\n" +
			   "                                                                                                                                          \r\n" +
	           "                                                                                 (\r\n" + 
	           "                                                                                      )     (\r\n" + 
	           "                                                                               ___...(-------)-....___\r\n" + 
	           "                                                                           .-\"\"       )    (          \"\"-.\r\n" + 
	           "                                                                     .-'``'|-._             )         _.-|\r\n" + 
	           "                                                                    /  .--.|   `\"\"---...........---\"\"`   |\r\n" + 
	           "                                                                   /  /    |                             |\r\n" + 
	           "                                                                   |  |    |                             |\r\n" + 
	           "                                                                    \\  \\   |                             |\r\n" + 
	           "                                                                     `\\ `\\ |                             |\r\n" + 
	           "                                                                       `\\ `|                             |\r\n" + 
	           "                                                                                                                "+ 
	           "                                                                      (__/  \\                           /\r\n" + 
	           "                                                                   _..---\"\"` \\                         /`\"\"---.._\r\n" + 
	           "                                                                .-'           \\                       /          '-.\r\n" + 
	           "                                                               :               `-.__             __.-'              :\r\n" + 
	           "                                                               :                  ) \"\"---...---\"\" (                 :\r\n" + 
	           "                                                                '._               `\"--...___...--\"`              _.'\r\n" + 
	           "                                                                 \\\"\"--..__                              __..--\"\"/\r\n" + 
	           "                                                                   '._     \"\"\"----.....______.....----\"\"\"     _.'\r\n" + 
	           	           "                                                                      `\"\"--..,,_____            _____,,..--\"\"`\r\n" + 
	        	           "                                                                                    `\"\"\"----\"\"\"`"+
	        	           "                                                                                                                                          \r\n"+
	        	           "                                                                                                                                          \r\n";
	        System.out.println(asciiArt);
		System.out.println("───────────────────────────────────────────────────────────────────────────────────  커피 주문 시스템   ────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("----------------------------------------------------------------------------------- Coffee Maker -----------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("                                                                                     1. 회원가입");
		System.out.println("                                                                                     2. 로그인/관리자");
		System.out.println("\n\n");
		
		int sel = ScanUtil.nextInt("                                                                                                                                                                               메뉴 선택 : ");
		switch (sel) {
		case 1:
			return View.SIGN;
		case 2:
			return View.LOGIN;
		default:
			return View.MAIN;
		}
	}
}
