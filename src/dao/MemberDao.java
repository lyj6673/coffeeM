package dao;

import java.util.ArrayList;
import util.JDBCUtil;
import vo.MemberVo;

import java.util.List;

public class MemberDao {
	private static MemberDao instance;

	private MemberDao() {

	}

	public static MemberDao GetInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	
	public MemberVo login(List<Object> param) {
		String sql="SELECT * \r\n" + 
				"FROM MEMBERS \r\n" + 
				"WHERE MEM_ID = ? \r\n" + 
				"AND MEM_PW = ? \r\n" + 
				"AND MEM_DELYN = 'N' ";
		
		return jdbc.selectOne(sql, param, MemberVo.class);
	}
	
	public MemberVo selectMem(List<Object> param) {
		String sql="SELECT * \r\n" + 
				"FROM MEMBERS \r\n" + 
				"WHERE MEM_ID = ? \r\n" + 
				"AND MEM_NAME = ? \r\n" + 
				"AND MEM_DELYN = 'N' ";
		
		return jdbc.selectOne(sql, param, MemberVo.class);
	}
	
	public void sign(List<Object> param) {
		String sql="INSERT INTO MEMBERS\r\n" + 
				"VALUES ((SELECT NVL(MAX(MEM_NO),0)+1 FROM MEMBERS)\r\n" + 
				"        , ?, ?, ?, ?,'N', 0, 1 \r\n" + 
				"        ) ";
		
		jdbc.update(sql, param);
	}
	
	public void reviewInsert(List<Object> param) {
		String sql = "INSERT INTO REVIEW(RV_NO, PROD_NAME, CONTENT, MEM_NO, RV_DELYN)\r\n" + 
				"VALUES (rv_no_sequence.nextval, ?, ?, ?, 'N') ";
		
		jdbc.update(sql, param);
	}
	
	public List<MemberVo> selectReview(List<Object> param) {
		String sql = "SELECT *\r\n" + 
				"FROM REVIEW \r\n" + 
				"WHERE MEM_NO = ? " +
				"AND RV_DELYN = 'N' ";
		
		return jdbc.selectList(sql, param, MemberVo.class);
	}
	
	public List<MemberVo> reviewMenu(List<Object> param) {
		String sql = "SELECT *\r\n" + 
				"FROM REVIEW, MEMBERS\r\n" + 
				"WHERE REVIEW.MEM_NO = MEMBERS.MEM_NO\r\n" + 
				"AND PROD_NAME = ? \r\n" + 
				"AND RV_DELYN = 'N'";
		
		return jdbc.selectList(sql, param, MemberVo.class);
	}
	
	public MemberVo selectRv1(List<Object> param) {
		String sql = "SELECT *\r\n" + 
				"FROM REVIEW \r\n" + 
				"WHERE MEM_NO = ? " +
				"AND PROD_NAME = ?" +
				"AND RV_DELYN = 'N' ";
		
		return jdbc.selectOne(sql, param, MemberVo.class);
	}
	
	
	public void reviewDelete(List<Object> param) {
		String sql = "UPDATE REVIEW\r\n" + 
				"SET RV_DELYN = 'Y'\r\n" + 
				"WHERE RV_NO = ?" ;
		
		jdbc.update(sql, param);
	}
	
	public void memberUpdatePass(List<Object> param) {
		String sql="UPDATE MEMBERS\r\n" + 
				"   SET MEM_PW = ? \r\n" + 
				" WHERE MEM_NAME =? " + 
				" AND MEM_ID = ? ";
		
		jdbc.update(sql, param);
	}
	
	public void memberUpdateName(List<Object> param) {
		String sql = "UPDATE MEMBERS\r\n" + 
				"   SET MEM_NAME = ? \r\n" + 
				" WHERE MEM_NAME = ? " + 
				" AND MEM_ID = ? ";
		
		jdbc.update(sql, param);
	}
	
	public void memberUpdatePhone(List<Object> param) {
		String sql="UPDATE MEMBERS\r\n" + 
				"   SET MEM_PHONE = ?\r\n" + 
				" WHERE MEM_NAME =? " + 
				" AND MEM_ID = ? ";
		
		jdbc.update(sql, param);
	}
	
	public boolean memberDelete(List<Object> param) {
		String sql = "UPDATE MEMBERS\r\n" + 
				"SET MEM_DELYN = 'Y'\r\n" + 
				"WHERE MEM_NAME = ? \r\n" + 
				"AND MEM_ID = ? " +
				"AND MEM_PW = ? ";
		
		return jdbc.update(sql, param) > 0;
	}
	
	
	 public void memberStamp(List<Object> param) {
			String sql="UPDATE MEMBERS\r\n" + 
					"SET MEM_STAMP = ?\r\n" + 
					"WHERE MEM_ID = ?";

		    jdbc.update(sql, param);
		}
	 
		public MemberVo myStamp(List<Object> param) {
			String sql = "SELECT MEM_STAMP\r\n" + "FROM MEMBERS\r\n" + "WHERE MEM_ID = ?";

			MemberVo member = jdbc.selectOne(sql, param, MemberVo.class);
			if (member != null) {
				return member;
			} else {
				// null 대신 새로운 MemberVo 객체를 반환하거나, 예외 처리 등을 수행할 수 있습니다.
				return new MemberVo(); // 예시로 빈 MemberVo 객체를 반환합니다.
			}
		}
		
		
}
