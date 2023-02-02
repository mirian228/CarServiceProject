package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.SuspensionMechanic;

public class SuspensionMechanicJAXB {
	private static final Logger LOGGER = LogManager.getLogger(SuspensionMechanicJAXB.class);
	File file = new File(
			"C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\jaxbXml\\SuspensionMechanicJAXB.xml");

	public void marshall() {
		try {
			SuspensionMechanic suspensionMechanic = new SuspensionMechanic(1L, 1L, 2L);
			JAXBContext jaxbContext = JAXBContext.newInstance(SuspensionMechanic.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(suspensionMechanic, System.out);
			marshaller.marshal(suspensionMechanic, file);

		} catch (JAXBException e) {
			LOGGER.error("JAXException", e);
		}
	}

	public void unmarshall() {
		try {
			JAXBContext jaxbContent = JAXBContext.newInstance(SuspensionMechanic.class);
			Unmarshaller unmarshaller = jaxbContent.createUnmarshaller();
			SuspensionMechanic suspensionMechanic = (SuspensionMechanic) unmarshaller.unmarshal(file);
			LOGGER.info("Suspension mechanic info:");
			LOGGER.info("Suspension mechanic ID: " + suspensionMechanic.getIdSuspensionMechanic());
			LOGGER.info("Car Service B ID: " + suspensionMechanic.getIdCarServiceB());
			LOGGER.info("Employee ID: " + suspensionMechanic.getIdEmployees());

		} catch (JAXBException e) {
			LOGGER.error("JAXBException occured", e);
		}
	}
}
