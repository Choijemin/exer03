package models;

import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import oracle.net.ns.SessionAtts;

	

public class AccountDao {
	SqlSessionFactory factory;
	
	public AccountDao() throws IOException{
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		factory = builder.build(is);
	}
	
	// ��� ȸ������
	public int addAccount(Map map) {
		SqlSession sql = factory.openSession();
		try {
			int r = sql.insert("account.addAccount", map);
			if(r == 1) 
				sql.commit();
			return r;
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		}	 
	}
	/*public Map joinck(Map map) {
		
	}*/
	
	// ��� �α��� 
	public Map loginck(Map map) {
		SqlSession sql = factory.openSession();
		try {
			Map p = sql.selectOne("account.loginck",map);
			System.out.println("��ī��� ���̿�" + p);
			return p;
			
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}