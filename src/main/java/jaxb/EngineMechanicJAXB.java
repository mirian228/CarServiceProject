package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.EngineMechanic;

public class EngineMechanicJAXB {
	private static final Logger LOGGER = LogManager.getLogger(EngineMechanicJAXB.class);
	File file = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\jaxbXml\\EngineMechanicJAXB.xml");
	
	public void marshall() {
		try {
			EngineMechanic engineMechanic = new EngineMechanic(1L, 1L, 3L);
			JAXBContext jaxbContext = JAXBContext.newInstance(EngineMechanic.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(engineMechanic, System.out);
			marshaller.marshal(engineMechanic, file);

		} catch (JAXBException e) {
			LOGGER.error("JAXException", e);
		}
	}

	public void unmarshall() {
		try {
			JAXBContext jaxbContent = JAXBContext.newInstance(EngineMechanic.class);
			Unmarshaller unmarshaller = jaxbContent.createUnmarshaller();
			EngineMechanic engineMechanic = (EngineMechanic) unmarshaller.unmarshal(file);
			LOGGER.info("Engine mechanic info:");
			LOGGER.info("Engine mechanic ID: " + engineMechanic.getIdEngineMechanic());
			LOGGER.info("Car Service ID: " + engineMechanic.getIdCarServiceA());
			LOGGER.info("Employee ID: " + engineMechanic.getIdEmployees());

		} catch (JAXBException e) {
			LOGGER.error("JAXBException occured", e);
		}
	}
	
}
