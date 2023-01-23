package main;

import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import jaxb.AutomotivePartsStoreOrdersJAXB;
import jaxb.CarJAXB;
import jaxb.CarServiceBJAXB;
import jaxb.DiagnosticsMechanicJAXB;
import jaxb.EnginePartsStoreJAXB;
import jaxb.GearboxMechanicJAXB;
import jaxb.PartWarehouseJAXB;

public class Main {
	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws SQLException {
		// ConnectionPool conPool = ConnectionPool.getInstance();
		// conPool.retrieve();

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
