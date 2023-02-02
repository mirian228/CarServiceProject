package main;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jaxb.AutomotiveElectricianJAXB;
import jaxb.AutomotivePartsStoreJAXB;
import jaxb.AutomotivePartsStoreOrdersJAXB;
import jaxb.CarJAXB;
import jaxb.CarServiceAJAXB;
import jaxb.CarServiceBJAXB;
import jaxb.CashierJAXB;
import jaxb.CustomerJAXB;
import jaxb.DiagnosticsMechanicJAXB;
import jaxb.EmployeesJAXB;
import jaxb.EngineMechanicJAXB;
import jaxb.EnginePartsStoreJAXB;
import jaxb.GearboxMechanicJAXB;
import jaxb.ManagerJAXB;
import jaxb.PartWarehouseJAXB;
import jaxb.SuspensionMechanicJAXB;
import model.AutomotiveElectrician;
import model.Car;
import model.Cashier;
import model.PartWarehouse;
import service.ICarService;
import service.ICashierService;
import service.serviceimpl.CarServiceImpl;
import service.serviceimpl.CashierServiceImpl;

public class Main {
	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws SQLException {

		// --- MyBatis --- //
		LOGGER.info("||--- MyBatis Examples ---|||");

		// --- Cashier --- //
		ICashierService cashierInstance = new CashierServiceImpl();
		LOGGER.info(cashierInstance.selectEntityById(2L));
		Cashier cashierObject = new Cashier(3L, 11L);
		Cashier cashierUpdate = new Cashier(3L, 5L);
		cashierInstance.insertEntity(cashierObject);
		System.out.println("------------------------");
		cashierInstance.selectEntityById(3L);
		// cashierInstance.deleteEntinty(cashierObject);
		cashierInstance.updateEntity(cashierUpdate);
		LOGGER.info(cashierInstance.selectAllEntity());
		cashierInstance.deleteEntinty(3L);
		LOGGER.info(cashierInstance.selectAllEntity());

		// --- Car --- //
		Car carObj = new Car(3L, 2L, "JH4DA9370MS016526", "Audi", "A5", "Sportback", 2015, "1993cc", "Gasoline",
				"Gray");
		Car carUpdate = new Car(3L, 2L, "WB4DD9550MS170534", "Nissan", "Patrol", "Large-Size SUV", 2002, "4497cc",
				"Diesel", "White");
		ICarService carInstance = new CarServiceImpl();
		carInstance.selectEntityById(1L);
		System.out.println("------------------------");
		// carInstance.insertEntity(carObj);
		carInstance.selectAllEntity();
		carInstance.deleteEntinty(3L);
		System.out.println("------------------------");
		carInstance.selectAllEntity();
		// carInstance.updateEntity(carUpdate);
		carInstance.deleteEntinty(3L);
		carInstance.selectAllEntity();

		for (int i = 0; i < 5; i++) {
			System.out.println();
		}

		LOGGER.info("--- JACKSON ---");
		// --- JACKSON --- //

		File automotiveElectricianJsonFile = new File(
				"C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\json\\AutomotiveElectrician.json");
		File carJsonFile = new File(
				"C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\json\\Car.json");
		File cashierJsonFile = new File(
				"C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\json\\Cashier.json");
		File enginePartsStoreOrdersJsonFile = new File(
				"C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\json\\EnginePartsStoreOrders.json");
		File partWarehouseJsonFile = new File(
				"C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\json\\PartWarehouse.json");
		ObjectMapper om = new ObjectMapper();

		try {
			PartWarehouse[] partWarehouse = om.readValue(partWarehouseJsonFile, PartWarehouse[].class);
			for (PartWarehouse object : partWarehouse) {
				System.out.println(object);
				System.out.println("-----------");
			}
			System.out.println();

			JsonNode enginePartsStoreOrders = om.readTree(enginePartsStoreOrdersJsonFile);
			System.out.println(enginePartsStoreOrders);
			System.out.println("-----------");

			Cashier cashier = new Cashier(1L, 1L);
			om.writeValue(cashierJsonFile, cashier);
			Cashier cashier1 = om.readValue(cashierJsonFile, Cashier.class);
			System.out.println(cashier1);
			System.out.println("-----------");

			JsonNode carNode = om.readTree(carJsonFile);
			System.out.println(carNode.toPrettyString());
			System.out.println("-----------");

			// prints nulls
			Car car = om.readValue(carJsonFile, Car.class);
			System.out.println(car);
			System.out.println("-----------");

			// prints nulls
			AutomotiveElectrician automotiveElectricianW = om.readValue(automotiveElectricianJsonFile,
					AutomotiveElectrician.class);
			System.out.println(automotiveElectricianW);
			System.out.println("-----------");

		} catch (StreamReadException e) {
			LOGGER.error("StreamReadException", e);
		} catch (DatabindException e) {
			LOGGER.error("DatabindException", e);
		} catch (IOException e) {
			LOGGER.error("IOException", e);
		}

		// --- JAXB --- //
		System.out.println("--- JAXB Examples ---");
		CarJAXB carObject = new CarJAXB();
		CarJAXB carObject2 = new CarJAXB();
		AutomotivePartsStoreOrdersJAXB storeObject = new AutomotivePartsStoreOrdersJAXB();
		PartWarehouseJAXB partWarehouseObject = new PartWarehouseJAXB();
		GearboxMechanicJAXB gearboxMechanicObject = new GearboxMechanicJAXB();
		EnginePartsStoreJAXB enginePartsStoreObject = new EnginePartsStoreJAXB();
		DiagnosticsMechanicJAXB diagnosticsMechanicObject = new DiagnosticsMechanicJAXB();
		CarServiceAJAXB carServiceAJAXB = new CarServiceAJAXB();
		CarServiceBJAXB carServiceBJAXB = new CarServiceBJAXB();
		AutomotiveElectricianJAXB automotiveElectricianJAXB = new AutomotiveElectricianJAXB();
		AutomotivePartsStoreJAXB automotivePartsStoreJAXB = new AutomotivePartsStoreJAXB();
		CashierJAXB cashierJAXB = new CashierJAXB();
		CustomerJAXB customerJAXB = new CustomerJAXB();
		EmployeesJAXB employeesJAXB = new EmployeesJAXB();
		EngineMechanicJAXB engineMechanicJAXB = new EngineMechanicJAXB();
		ManagerJAXB managerJAXB = new ManagerJAXB();
		SuspensionMechanicJAXB suspensionMechanicJAXB = new SuspensionMechanicJAXB();

		carObject.marshall();
		System.out.println();
		carObject.unmarshall();
		System.out.println();
		// prints null
		carObject2.unmarshallExistingFile();
		System.out.println();

		storeObject.marshall();
		System.out.println();
		storeObject.unmarshall();
		System.out.println();

		partWarehouseObject.marshall();
		System.out.println();
		partWarehouseObject.unmarshall();
		System.out.println();

		gearboxMechanicObject.marshall();
		System.out.println();
		gearboxMechanicObject.unmarshall();
		System.out.println();

		enginePartsStoreObject.marshall();
		System.out.println();
		enginePartsStoreObject.unmarshall();
		System.out.println();

		diagnosticsMechanicObject.marshall();
		System.out.println();
		diagnosticsMechanicObject.unmarshall();
		System.out.println();

		carServiceAJAXB.marshall();
		System.out.println();
		carServiceAJAXB.unmarshall();
		System.out.println();

		carServiceBJAXB.marshall();
		System.out.println();
		carServiceBJAXB.unmarshall();
		System.out.println();

		automotiveElectricianJAXB.marshall();
		System.out.println();
		automotiveElectricianJAXB.unmarshall();
		System.out.println();

		automotivePartsStoreJAXB.marshall();
		System.out.println();
		automotivePartsStoreJAXB.unmarshall();
		System.out.println();

		cashierJAXB.marshall();
		System.out.println();
		cashierJAXB.unmarshall();
		System.out.println();

		customerJAXB.marshall();
		System.out.println();
		customerJAXB.unmarshall();
		System.out.println();

		employeesJAXB.marshall();
		System.out.println();
		employeesJAXB.unmarshall();
		System.out.println();

		engineMechanicJAXB.marshall();
		System.out.println();
		engineMechanicJAXB.unmarshall();
		System.out.println();

		managerJAXB.marshall();
		System.out.println();
		managerJAXB.unmarshall();
		System.out.println();

		suspensionMechanicJAXB.marshall();
		System.out.println();
		suspensionMechanicJAXB.unmarshall();
		System.out.println();

	}
}
