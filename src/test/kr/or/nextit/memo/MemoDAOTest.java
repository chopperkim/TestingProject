package kr.or.nextit.memo;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.Test;

public class MemoDAOTest {

	@Test
	public void test() throws Exception {
		MemoDAO dao = new MemoDAO();
		List<MemoVO> list = dao.selectMemoList();
		int size = list.size();
//		assertThat(list.size(), is(size));
		MemoVO vo = new MemoVO();
		vo.setMemoContents("세번째 메모");
		dao.insertMemo(vo);
		List<MemoVO> list2 = dao.selectMemoList();
		
		assertThat(list2.size(), is(size + 1));
	}
	
	@Test
	public void testUpdateMemo() throws Exception {
		MemoDAO dao = new MemoDAO();
		MemoVO vo = new MemoVO();
		vo.setMemoId(2);
		vo.setMemoContents("바뀐 데이터");
		dao.updateMemo(vo);
		// 결과 테스트
		MemoVO memo = dao.selectMemo((int) vo.getMemoId());
		assertThat(memo.getMemoContents(), is("바뀐 데이터"));
	}

}









