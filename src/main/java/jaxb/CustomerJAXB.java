package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Customer;

public class CustomerJAXB {
	private static final Logger LOGGER = LogManager.getLogger(CustomerJAXB.class);
	File file = new File(
			"C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\jaxbXml\\CustomerJAXB.xml");
	File file1 = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\xml\\Customer.xml");

	public void marshall() {
		try {
			Customer customer = new Customer(1L, "Ana", "Surmanidze", "+995555222000", "Tbilisi Street 2", "3%");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(customer, System.out);
			marshaller.marshal(customer, file);

		} catch (JAXBException e) {
			LOGGER.error("JAXBException", e);
		}
	}

	public void unmarshall() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			Customer customer = (Customer) unMarshaller.unmarshal(file);
			LOGGER.info("Customer info");
			LOGGER.info("Customer ID " + customer.getIdCustomer());
			LOGGER.info("First name " + customer.getFname());
			LOGGER.info("Last name " + customer.getLname());
			LOGGER.info("Phone number " + customer.getPhoneNumber());
			LOGGER.info("adress " + customer.getAdress());
			LOGGER.info("discount " + customer.getDiscount());

		} catch (JAXBException e) {
			LOGGER.error("JAXBException", e);
		}
	}

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
