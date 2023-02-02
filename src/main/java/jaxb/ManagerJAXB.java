package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Manager;

public class ManagerJAXB {
	private static final Logger LOGGER = LogManager.getLogger(ManagerJAXB.class);
	File file = new File(
			"C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\jaxbXml\\ManagerJAXB.xml");

	public void marshall() {
		try {
			Manager manager = new Manager(1L, "Leila", "Turmanidze", "Gorgasali Street 2", "+995555222000", 50000);
			JAXBContext jaxbContext = JAXBContext.newInstance(Manager.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(manager, System.out);
			marshaller.marshal(manager, file);

		} catch (JAXBException e) {
			LOGGER.error("JAXBException", e);
		}
	}

	public void unmarshall() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Manager.class);
			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			Manager manager = (Manager) unMarshaller.unmarshal(file);
			LOGGER.info("Customer info");
			LOGGER.info("Manager ID " + manager.getIdManager());
			LOGGER.info("First name " + manager.getFname());
			LOGGER.info("Last name " + manager.getLname());
			LOGGER.info("Phone number " + manager.getPhoneNumber());
			LOGGER.info("adress " + manager.getAdress());
			LOGGER.info("salary " + manager.getsalary());

		} catch (JAXBException e) {
			LOGGER.error("JAXBException", e);
		}
	}
}
