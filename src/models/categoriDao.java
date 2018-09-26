package models;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class categoriDao {
	SqlSessionFactory factory;
	
	public categoriDao() throws IOException {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		factory = builder.build(is);
	}
	// 카테고리 
	public int addcate(Map map) {
		SqlSession sql = factory.openSession();
		try {
			int r = sql.insert("categori.addcate",map);
			if(r == 1) 
				sql.commit();
			return r;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}
