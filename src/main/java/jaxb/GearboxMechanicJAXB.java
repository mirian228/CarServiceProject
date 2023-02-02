package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.GearboxMechanic;

public class GearboxMechanicJAXB {
	private static final Logger LOGGER = LogManager.getLogger(GearboxMechanicJAXB.class);
	File file = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\jaxbXml\\GearboxMechanicJAXB.xml");

	public void marshall() {
		try {
			GearboxMechanic gearboxMechanic = new GearboxMechanic(1L, 1L, 9L);
			JAXBContext jaxbContext = JAXBContext.newInstance(GearboxMechanic.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(gearboxMechanic, System.out);
			marshaller.marshal(gearboxMechanic, file);

		} catch (JAXBException e) {
			LOGGER.error("JAXBException", e);
		}
	}
	
	public void unmarshall() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(GearboxMechanic.class);
			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			GearboxMechanic gearboxMechanic = (GearboxMechanic) unMarshaller.unmarshal(file);
			LOGGER.info("Gearbox mechanic info");
			LOGGER.info("Gearbox mechanic ID: " + gearboxMechanic.getIdGearboxMechanic());
			LOGGER.info("Car Service B ID: " + gearboxMechanic.getIdCarServiceB());
			LOGGER.info("Employee ID: " + gearboxMechanic.getIdEmployees());
			
		} catch (JAXBException e) {
			LOGGER.error("JAXBException", e);
		}
	}
}
