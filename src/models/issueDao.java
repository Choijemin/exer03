package models;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class issueDao {
	SqlSessionFactory factory; 
	
	public issueDao() throws IOException {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		InputStream is =  Resources.getResourceAsStream("mybatis-config.xml");
		factory = builder.build(is);
	}
	// ��� �̽�����ϱ�
	public int addIssue(Map map) {
		SqlSession sql = factory.openSession();
		try {
			int r = sql.insert("issue.addissue", map);
			if(r == 1) 
				sql.commit();
			return r;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	// ��� ���Ȯ�� �ϱ�
	public List<Map> allTrend() {
		SqlSession sql = factory.openSession();
		try {
			List<Map> p = sql.selectList("issue.alltrend");
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	// ��� �󼼺���
	public Map getDetail(int no) {
		SqlSession sql = factory.openSession();
		try {
			return sql.selectOne("issue.getdetail",no);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// ���� 24�ð� �̳� �̽� 
	public List<Map> mainissue() {
		SqlSession sql = factory.openSession();
		try {
			List<Map> p = sql.selectList("issue.mainissue");
			return p;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
