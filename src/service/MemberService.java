package service;

import java.util.List;

import controller.MainController;
import dao.MemberDao;
import vo.MemberVo;
import vo.ProdVo;

public class MemberService {
	private static MemberService instance;

	private MemberService() {

	}

	public static MemberService GetInstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}
	MemberDao memberDao = MemberDao.GetInstance();
	
	public boolean login(List<Object> param) {
		MemberVo member = memberDao.login(param);
		if(member == null){
			return false;
		}
		MainController.sessionStorage.put("member", member);
		
		return true;
	}
	
	public void sign(List<Object> param) {
		memberDao.sign(param);
	}
	
	public void reviewInsert(List<Object> param) {
		memberDao.reviewInsert(param);
	}
	
	public List<MemberVo> selectReview(List<Object> param) {
		return memberDao.selectReview(param);
	}
	
	public MemberVo selectRv1(List<Object> param) {
		return memberDao.selectRv1(param);
	}
	
	public List<MemberVo> reviewMenu(List<Object> param){
		return memberDao.reviewMenu(param);
	}
	
	public void reviewDelete(List<Object> param) {
		memberDao.reviewDelete(param);
	}
	
	public MemberVo selectName(List<Object> param) {
		return memberDao.login(param);
	}
	
	public MemberVo selectMem(List<Object> param) {
		return memberDao.selectMem(param);
	}
	
	public void memberUpdate(List<Object> param, int sel) {
		if(sel==1) memberDao.memberUpdatePass(param);
		if(sel==2) memberDao.memberUpdateName(param);
		if(sel==3) memberDao.memberUpdatePhone(param);
	}
	
	
	public boolean memberDelete(List<Object> param) {
        return memberDao.memberDelete(param);
    }
	
	public void memberStamp(List<Object> param) {
       memberDao.memberStamp(param);
    }
	
	public MemberVo myStamp(List<Object> param){
		return memberDao.myStamp(param);
	}
	

}
