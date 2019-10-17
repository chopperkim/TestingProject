package kr.or.nextit.memo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemoDAO {
	public List<MemoVO> selectMemoList() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "oracle");
		PreparedStatement statement = connection.prepareStatement("select * from memo");
		ResultSet resultSet = statement.executeQuery();

		List<MemoVO> list = new ArrayList<MemoVO>();
		while (resultSet.next()) {
			long memoId = resultSet.getLong("memo_id");
			String memoContents = resultSet.getString("memo_contents");
			Date memoCreateDate = resultSet.getDate("memo_create_date");
			Date memoModifyDate = resultSet.getDate("memo_modify_date");
			list.add(new MemoVO(memoId, memoContents, memoCreateDate, memoModifyDate));
		}
		resultSet.close();
		statement.close();
		connection.close();
		return list;
	}
	public MemoVO selectMemo(int id) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "oracle");
		PreparedStatement statement = connection.prepareStatement("select * from memo where memo_id = ?");
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();

		MemoVO vo = null;
		while (resultSet.next()) {
			long memoId = resultSet.getLong("memo_id");
			String memoContents = resultSet.getString("memo_contents");
			Date memoCreateDate = resultSet.getDate("memo_create_date");
			Date memoModifyDate = resultSet.getDate("memo_modify_date");
			vo = new MemoVO(memoId, memoContents, memoCreateDate, memoModifyDate);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return vo;
	}
	public int insertMemo(MemoVO vo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "oracle");
		PreparedStatement statement = connection.prepareStatement("INSERT INTO MEMO(MEMO_ID, MEMO_CONTENTS) VALUES (SEQ_MEMO.NEXTVAL, ?)");
		statement.setString(1, vo.getMemoContents());
		int update = statement.executeUpdate();
		
		statement.close();
		connection.close();
		return update;
	}
	public int updateMemo(MemoVO vo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "oracle");
		PreparedStatement statement = connection.prepareStatement("UPDATE MEMO SET MEMO_CONTENTS = ?, MEMO_MODIFY_DATE = SYSDATE WHERE MEMO_ID = ?");
		statement.setString(1, vo.getMemoContents());
		statement.setLong(2, vo.getMemoId());
		int update = statement.executeUpdate();
		
		statement.close();
		connection.close();
		return update;
	}
	public int deleteMemo(int id) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "oracle");
		PreparedStatement statement = connection.prepareStatement("DELETE FROM MEMO WHERE MEMO_ID = ?");
		statement.setLong(1, id);
		int update = statement.executeUpdate();
		
		statement.close();
		connection.close();
		return update;
	}
}



