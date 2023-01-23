package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Customer;

public class CustomerJAXB {
	private static final Logger LOGGER = LogManager.getLogger(CustomerJAXB.class);
	File file1 = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\xml\\Customer.xml");
	
	
	public void unmarshallExistingFile() {
		try {
			JAXBContext jaxbContent = JAXBContext.newInstance(Customer.class);
			Unmarshaller unmarshaller = jaxbContent.createUnmarshaller();
			Customer customer = (Customer) unmarshaller.unmarshal(file1);
			LOGGER.info("Car info");
			LOGGER.info("idCustomer: " + customer.getIdCustomer());
			LOGGER.info("fname: " + customer.getFname());
			LOGGER.info("lname: " + customer.getLname());

		} catch (JAXBException e) {
			LOGGER.error("JAXBException occured", e);
		}

	}
}
