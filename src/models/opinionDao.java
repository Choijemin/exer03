package models;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class opinionDao {

	SqlSessionFactory factory; 
	
	public opinionDao() throws IOException {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		InputStream is =  Resources.getResourceAsStream("mybatis-config.xml");
		factory = builder.build(is);
	}
	
	
	public int addOne(Map a) {
		SqlSession sql = factory.openSession();
		try {
			int i = sql.insert("opinion.addOne",a);
			if(i==1) {
				sql.commit();
			}
			return i;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			sql.close();
		}
	}
	
	public List<Map> getSomeByIno(int ino) {
		SqlSession sql = factory.openSession();
		try {
			List<Map> list = sql.selectList("opinion.getSomeByIno",ino);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sql.close();
		}
	}
	
	// ÇÖÀÌ½´ 
	public List<Map> hotissue() {
		SqlSession sql = factory.openSession();
		try {
			List<Map> p = sql.selectList("opinion.hotissue");
			return p;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// ÀÇ°ß yes, no °³¼ö 
	public List<Map> sumagree() {
		SqlSession sql = factory.openSession();
		try {
			List<Map> p = sql.selectList("opinion.sumagree");
			return p;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
