package kr.or.nextit;

import java.util.List;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();
	
	public List<MemberVO> selectMemberList() throws Exception {
		return dao.selectMemberList();
	}
	
	public MemberVO selectMember(String id) throws Exception {
		return dao.selectMember(id);
	}
	
	public void insertMember(MemberVO vo) throws Exception {
		dao.insertMember(vo);
	}
	
	public void updateMember(MemberVO vo) {
		dao.updateMember(vo);
	}
	
	public void deleteMember(String id) {
		dao.deleteMember(id);
	}
}
