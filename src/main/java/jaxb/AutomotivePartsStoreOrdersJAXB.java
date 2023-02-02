package jaxb;

import java.io.File;
import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.AutomotivePartsStoreOrders;


public class AutomotivePartsStoreOrdersJAXB {
	private static final Logger LOGGER = LogManager.getLogger(AutomotivePartsStoreOrdersJAXB.class);
	File file = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\jaxbXml\\AutomotivePartsStoreOrdersJAXB.xml");

	public void marshall() {
		try {
			Date date = new Date(2023-01-01);
			AutomotivePartsStoreOrders orders = new AutomotivePartsStoreOrders(1L , 1L , 1L , date , 200.0);
			JAXBContext jaxbContent = JAXBContext.newInstance(AutomotivePartsStoreOrders.class);
			Marshaller marshaller = jaxbContent.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(orders,  System.out);
			marshaller.marshal(orders, file);
			
		} catch (JAXBException e) {
			LOGGER.error("JAXBException occured", e);
		}
		
		
	}

	public void unmarshall() {
		try {
			JAXBContext jaxbContent = JAXBContext.newInstance(AutomotivePartsStoreOrders.class);
			Unmarshaller unmarshaller = jaxbContent.createUnmarshaller();
			AutomotivePartsStoreOrders orders = (AutomotivePartsStoreOrders) unmarshaller.unmarshal(file);
			LOGGER.info("Automotive Parts Store order information");
			LOGGER.info("Customer ID: " + orders.getIdCustomer());
			LOGGER.info("AutomotivePartsStore ID: " + orders.getIdAutomotivePartsStore());
			LOGGER.info("Order ID: " + orders.getIdOrder());
			LOGGER.info("Order Date: " + orders.getOrderDate());

		} catch (JAXBException e) {
			LOGGER.error("JAXBException occured", e);
		}
	}
	
	
}
