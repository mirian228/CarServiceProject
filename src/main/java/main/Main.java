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

import jaxb.AutomotivePartsStoreOrdersJAXB;
import jaxb.CarJAXB;
import jaxb.CarServiceBJAXB;
import jaxb.DiagnosticsMechanicJAXB;
import jaxb.EnginePartsStoreJAXB;
import jaxb.GearboxMechanicJAXB;
import jaxb.PartWarehouseJAXB;
import model.AutomotiveElectrician;
import model.Car;
import model.Cashier;
import model.PartWarehouse;
import service.ICashierService;
import service.serviceimpl.CashierServiceImpl;

public class Main {
	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws SQLException {
		
		ICashierService cashierService = new CashierServiceImpl();
		LOGGER.info(cashierService.selectEntityById(1L));
		
		// --- JACKSON --- //
		
		File automotiveElectricianJsonFile = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\json\\AutomotiveElectrician.json");
		File carJsonFile = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\json\\Car.json");
		File cashierJsonFile = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\json\\Cashier.json");
		File enginePartsStoreOrdersJsonFile = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\json\\EnginePartsStoreOrders.json");
		File partWarehouseJsonFile = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\json\\PartWarehouse.json");
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
			AutomotiveElectrician automotiveElectricianW = om.readValue(automotiveElectricianJsonFile, AutomotiveElectrician.class);
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
		CarServiceBJAXB carServiceBJAXB = new CarServiceBJAXB();

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

		carServiceBJAXB.marshall();
		System.out.println();
		carServiceBJAXB.unmarshall();
		System.out.println();

	}
}
