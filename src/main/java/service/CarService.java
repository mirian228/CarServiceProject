package service;

import dao.ICarDao;
import dao.jdbc.CarDaoImpl;

public class CarService {
	private ICarDao carDao;
	
	public CarService() {
		carDao = new CarDaoImpl();
	}
	
}
