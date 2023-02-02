package jaxb;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.EnginePartsStoreOrders;

public class EnginePartsStoreOrdersJAXB {
	private static final Logger LOGGER = LogManager.getLogger(EnginePartsStoreOrdersJAXB.class);
	File file = new File(
			"C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\jaxbXml\\EnginePartsStoreOrdersJAXB.xml");

	public void marshall() {
		try {
			Date date = new Date(2023 - 01 - 01);
			EnginePartsStoreOrders orders = new EnginePartsStoreOrders(1L, 1L, 1L, (java.util.Date) date, 200.0);
			JAXBContext jaxbContent = JAXBContext.newInstance(EnginePartsStoreOrders.class);
			Marshaller marshaller = jaxbContent.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(orders, System.out);
			marshaller.marshal(orders, file);

		} catch (JAXBException e) {
			LOGGER.error("JAXBException occured", e);
		}

	}

	public void unmarshall() {
		try {
			JAXBContext jaxbContent = JAXBContext.newInstance(EnginePartsStoreOrders.class);
			Unmarshaller unmarshaller = jaxbContent.createUnmarshaller();
			EnginePartsStoreOrders orders = (EnginePartsStoreOrders) unmarshaller.unmarshal(file);
			LOGGER.info("Automotive Parts Store order information");
			LOGGER.info("Customer ID: " + orders.getIdCustomer());
			LOGGER.info("EnginepartsStore ID: " + orders.getIdEnginePartsStore());
			LOGGER.info("Order ID: " + orders.getIdOrder());
			LOGGER.info("Order Date: " + orders.getOrderDate());

		} catch (JAXBException e) {
			LOGGER.error("JAXBException occured", e);
		}
	}
}
