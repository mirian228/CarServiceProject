package utility;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBatisUtil {
	private static final Logger LOGGER = LogManager.getLogger(MyBatisUtil.class);
	private final static MyBatisUtil myBatisUtil = new MyBatisUtil();
	private static SqlSessionFactory sqlSessionFactory;
	
	private MyBatisUtil() {
		
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			LOGGER.error("Exception while reading the configuration file", e);
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

}
