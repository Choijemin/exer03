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
	// 요게 이슈등록하기
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
	// 요게 목록확인 하기
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
	// 요게 상세보기
	public Map getDetail(int no) {
		SqlSession sql = factory.openSession();
		try {
			return sql.selectOne("issue.getdetail",no);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// 메인 24시간 이내 이슈 
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
	
	// 내가 의견 남긴 이슈
	public List<Map> myissue(String id) {
		SqlSession sql = factory.openSession();
		try {
			return sql.selectList("issue.myissue", id);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
