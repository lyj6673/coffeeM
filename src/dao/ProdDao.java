package dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import vo.CartVo;
import vo.ProdVo;

public class ProdDao {
	private static ProdDao instance;

	private ProdDao() {

	}

	public static ProdDao getInstance() {
		if (instance == null) {
			instance = new ProdDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	
	public List<ProdVo> prodList(List<Object> param, int sel){
		String sql = "SELECT *\r\n" +
				"FROM PROD\r\n" +
				"WHERE CATE_LGU = ? ";
		
		return jdbc.selectList(sql, param, ProdVo.class);
	}
	
	public ProdVo prodDetail(List<Object> param) {
		String sql = "SELECT *\r\n" +
				"FROM PROD\r\n" +
				"WHERE PROD_NAME = ? ";
		
		return jdbc.selectOne(sql, param, ProdVo.class);
	}
	
	public ProdVo selectLgu(List<Object> param) {
		String sql = "SELECT *\r\n" +
				"FROM CATEGORY \r\n" +
				"WHERE CATE_LGU = ? ";
		
		return jdbc.selectOne(sql, param, ProdVo.class);
	}
	
	public void insertCart(List<Object> param) {
        String sql = "INSERT INTO CART (CART_NO, PROD_NAME, PROD_COUNT, PROD_PRICE, MEM_NO) " +
                "VALUES (cart_no_seq.nextval, ?, ?, ?, ?)";
	    
	    jdbc.update(sql, param);
	}
	
	public ProdVo selectCart(List<Object> param) {
		String sql = "SELECT *\r\n" + 
				     "FROM CART\r\n" + 
				     "WHERE MEM_NO = ? ";
		
		return jdbc.selectOne(sql, param, ProdVo.class);
	}
	
	public List<CartVo> getAllCartItems() {
	    List<CartVo> cartItems = new ArrayList<>();

	    String sql = "SELECT PROD_NAME, PROD_COUNT, PROD_PRICE FROM CART";
	    List<Map<String, Object>> rows = jdbc.selectList(sql);

	    if (rows != null) {
	        for (Map<String, Object> row : rows) {
	            String prodName = (String) row.get("PROD_NAME");
	            // prod_count와 prod_price를 BigDecimal 타입으로 가져옵니다.
	            BigDecimal prodCountDecimal = (BigDecimal) row.get("PROD_COUNT");
	            BigDecimal prodPriceDecimal = (BigDecimal) row.get("PROD_PRICE");
	            // BigDecimal 값을 Integer로 변환하여 사용합니다.
	            int prodCount = prodCountDecimal.intValue();
	            int prodPrice = prodPriceDecimal.intValue();

	            CartVo cartItem = new CartVo();
	            cartItem.setProd_name(prodName);
	            cartItem.setProd_count(prodCount);
	            cartItem.setProd_price(prodPrice);
	            
	            cartItems.add(cartItem);
	        }
	    }
	    return cartItems;
	}

	
	public void cartReset(){
		String sql="DELETE FROM CART";

	    jdbc.update(sql);
	}
	
	public void insertOrder(){
	     String sql = "INSERT INTO ORDERS (ORDER_NO, ORDER_PROD, ORDER_QTY, ORDER_PRICE, ORDER_DATE, MEM_NO)\r\n" + 
	       		"SELECT order_no_sequence.nextval, PROD_NAME, PROD_COUNT, PROD_PRICE, SYSDATE, MEM_NO \r\n" + 
	       		"FROM CART";
	   
	     jdbc.update(sql);
	}
	
	public List<Map<String, Object>> totalSales() {
        String sql = "SELECT SUM(ORDER_PRICE*ORDER_QTY)\r\n" + 
              "FROM ORDERS \r\n" + 
              "WHERE TRUNC(ORDER_DATE) = TRUNC(SYSDATE)";
        
        return jdbc.selectList(sql);
     }
	public boolean prodInsert(List<Object> param) {
		   
		String sql = "INSERT INTO PROD (PROD_ID, PROD_NAME, PROD_PRICE, PROD_DETAIL, PROD_INSDATE, CATE_LGU) " + 
				" values( prod_no_sequence.nextval, ?, ?, ?, TO_DATE(?, 'YYYYMMDD'), ? ) " ;
		int count=jdbc.update(sql, param);
		
		if (count>0) 
			return true; 
		else 
            return false;
			
		
	}
	public void prodUpdateName(List<Object> param) {
		String sql="UPDATE PROD\r\n" + 
				"   SET PROD_NAME = ? \r\n" + 
				" WHERE PROD_NAME =? ";
		
		jdbc.update(sql, param);
	}
	
	public void prodUpdatePrice(List<Object> param) {
		String sql="UPDATE PROD\r\n" + 
				"   SET PROD_PRICE = ?\r\n" + 
				" WHERE PROD_NAME =? ";
		
		jdbc.update(sql, param);
	}
	
	public void prodUpdateDetail(List<Object> param) {
		String sql="UPDATE PROD\r\n" + 
				"   SET PROD_DETAIL = ?\r\n" + 
				" WHERE PROD_NAME =? ";
		
		jdbc.update(sql, param);
	}
	
	public boolean prodDelete(List<Object> param) {
		String sql = "UPDATE PROD\r\n" + 
				"SET PROD_DELYN = 'Y'\r\n" + 
				"WHERE PROD_NAME = ?";
		
		return jdbc.update(sql, param) > 0;
	}      
  
}