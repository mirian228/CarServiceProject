package main;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import jaxb.AutomotivePartsStoreOrdersJAXB;
import jaxb.CarJAXB;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws SQLException {
		 //ConnectionPool conPool = ConnectionPool.getInstance();
		//conPool.retrieve();
	
	CarJAXB carObject = new CarJAXB();
	CarJAXB carObject2 = new CarJAXB();
	//  carObject.marshall();
     carObject.unmarshall();
	// print null
     carObject2.unmarshallExistingFile();
     
     AutomotivePartsStoreOrdersJAXB storeObject = new AutomotivePartsStoreOrdersJAXB();
     storeObject.marshall();
     storeObject.unmarshall();
}
}

