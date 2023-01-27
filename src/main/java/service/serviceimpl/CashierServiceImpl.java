package service.serviceimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ICashierDao;
import main.Main;
import model.Cashier;
import service.ICashierService;
import utility.MyBatisUtil;

public class CashierServiceImpl implements ICashierService {
	 private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
	 private static final Logger LOGGER = LogManager.getLogger(CashierServiceImpl.class);
	 SqlSession sqlSession;
	 Cashier cashier;
	
	 @Override
	 public Cashier selectEntityById(Long id) {
		
		
		try {
			sqlSession = SESSION_FACTORY.openSession();
			ICashierDao cashierDao = sqlSession.getMapper(ICashierDao.class);
			cashier = cashierDao.selectEntityById(id);
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
			
		} 
		return cashier;
	}

	@Override
	public List<Cashier> selectAllEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertEntity(Cashier entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEntity(Cashier entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEntinty(Cashier entity) {
		// TODO Auto-generated method stub
		
	}
	 

}
