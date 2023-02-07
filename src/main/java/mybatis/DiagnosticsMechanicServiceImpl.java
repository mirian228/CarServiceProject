package mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.IDiagnosticsMechanicDao;
import model.DiagnosticsMechanic;
import utility.MyBatisUtil;

public class DiagnosticsMechanicServiceImpl implements IDiagnosticsMechanicDao {
	private static final SqlSessionFactory SESSION_FACTORY = MyBatisUtil.getSqlSessionFactory();
	private static final Logger LOGGER = LogManager.getLogger(DiagnosticsMechanicServiceImpl.class);
	DiagnosticsMechanic diagnosticsMechanic;

	@Override
	public DiagnosticsMechanic selectEntityById(Long id) throws SQLException {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IDiagnosticsMechanicDao diagnosticsMechanicDao = sqlSession.getMapper(IDiagnosticsMechanicDao.class);
			diagnosticsMechanic = diagnosticsMechanicDao.selectEntityById(id);
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);

		}
		return diagnosticsMechanic;
	}

	@Override
	public List<DiagnosticsMechanic> selectAllEntity() {
		List<DiagnosticsMechanic> diagnosticsMechanicList = null;
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IDiagnosticsMechanicDao diagnosticsMechanicDao = sqlSession.getMapper(IDiagnosticsMechanicDao.class);
			try {
				diagnosticsMechanicList = diagnosticsMechanicDao.selectAllEntity();
			} catch (SQLException e) {
				LOGGER.error("SQLException", e);
			}

		}
		return diagnosticsMechanicList;
	}

	@Override
	public void insertEntity(DiagnosticsMechanic entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {

			IDiagnosticsMechanicDao diagnosticsMechanicDao = sqlSession.getMapper(IDiagnosticsMechanicDao.class);

			try {
				diagnosticsMechanicDao.insertEntity(entity);
				sqlSession.commit();

			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);

			} catch (Exception e) {
				LOGGER.error("Exception", e);
			}

		}

	}

	@Override
	public void updateEntity(DiagnosticsMechanic entity) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IDiagnosticsMechanicDao diagnosticsMechanicDao = sqlSession.getMapper(IDiagnosticsMechanicDao.class);
			try {
				diagnosticsMechanicDao.updateEntity(entity);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);
			}
		}

	}

	@Override
	public void deleteEntinty(Long id) {
		try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
			IDiagnosticsMechanicDao diagnosticsMechanicDao = sqlSession.getMapper(IDiagnosticsMechanicDao.class);

			try {
				diagnosticsMechanicDao.deleteEntinty(id);
				sqlSession.commit();
			} catch (SQLException e) {
				sqlSession.rollback();
				LOGGER.error("SQLException", e);
			}

		}

	}

}