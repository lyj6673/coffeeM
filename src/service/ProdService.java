package service;

import java.util.List;
import java.util.Map;

import controller.MainController;
import dao.ProdDao;
import vo.CartVo;
import vo.ProdVo;

public class ProdService {
	private static ProdService instance;

	private ProdService() {

	}

	public static ProdService getInstance() {
		if (instance == null) {
			instance = new ProdService();
		}
		return instance;
	}
	
	ProdDao prodDao = ProdDao.getInstance();
	
	
	public List<ProdVo> prodList(List<Object> param, int sel){
		return prodDao.prodList(param, sel);
	}
	
	
	public ProdVo prodDetail(List<Object> param) {
		return prodDao.prodDetail(param);
	}
	
	public void insertCart(List<Object> param) {
		prodDao.insertCart(param);
	}
	
	public List<CartVo> getAllCartItems() {
		return prodDao.getAllCartItems();
	}
	  
	public boolean selectCart(List<Object> param) {
		ProdVo prodCart = prodDao.selectCart(param);
		if(prodCart == null) {
			return false;
		}
		MainController.sessionStorage.put("prodCart", prodCart);
		
		return true;
	}
	
	public void cartReset(){
		prodDao.cartReset();
	}

	public ProdVo selectLgu(List<Object> paramCate) {
		return prodDao.selectLgu(paramCate);
	}
	
	public void insertOrder() {
	      prodDao.insertOrder();
	   }
	   
	public List<Map<String, Object>> totalSales() {
		return prodDao.totalSales();
	}
	
	public boolean prodInsert(List<Object> param) {
	       return prodDao.prodInsert(param);
	   }
	   
	   public void prodUpdate(List<Object> param, int sel) {
			if(sel==1) prodDao.prodUpdateName(param);
			if(sel==2) prodDao.prodUpdatePrice(param);
			if(sel==3) prodDao.prodUpdateDetail(param);
		}
	   
	   public boolean prodDelete(List<Object> param) {
	       return prodDao.prodDelete(param);
	   }
	
}
