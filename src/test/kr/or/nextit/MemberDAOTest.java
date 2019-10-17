package kr.or.nextit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

public class MemberDAOTest {

	@Test
	public void testSelectMemberList() throws Exception {
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.selectMemberList();
//		assertTrue(list.size() == 24);
//		assertTrue(list.get(7).getMemId().equals("h001"));
	}

	@Test
	public void testSelectMember() throws Exception {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.selectMember("p001");
//		assertTrue(vo.getMemName().equals("오성순"));
		assertThat(vo.getMemName(), is(not("유성순")));
	}

	@Test(expected = SQLException.class)
	public void testInsertMember() throws Exception {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setMemId("a004");
		vo.setMemPass("qwer");
		vo.setMemName("홍길동");
		vo.setMemReg01("960101");
		vo.setMemReg02("1234567");
		vo.setMemBir("960101");
		vo.setMemZip("30217");
		vo.setMemAdd1("대전광역시 중구");
		vo.setMemAdd2("희영빌딩 2층");
		vo.setMemHometel("042-123-4567");
		vo.setMemComtel("042-789-1234");
		vo.setMemHp("010-5555-8888");
		vo.setMemMail("hong@hong.kr");
		int size = dao.selectMemberList().size();
		dao.insertMember(vo);
		assertThat(dao.selectMemberList().size(), is(size + 1));
		dao.insertMember(vo);
	}

	@Test
	public void testUpdateMember() {
	}

	@Test
	public void testDeleteMember() {
	}

}
