package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.AutomotiveElectrician;

public class AutomotiveElectricianJAXB {
	private static final Logger LOGGER = LogManager.getLogger(AutomotiveElectricianJAXB.class);
	File file = new File(
			"C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\jaxbXml\\AutomotiveElectricianJAXB.xml");

	public void marshall() {
		try {
			AutomotiveElectrician automotiveElectrician = new AutomotiveElectrician(1L, 1L, 3L);
			JAXBContext jaxbContent = JAXBContext.newInstance(AutomotiveElectrician.class);
			Marshaller marshaller = jaxbContent.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(automotiveElectrician, System.out);
			marshaller.marshal(automotiveElectrician, file);

		} catch (JAXBException e) {
			LOGGER.error("JAXBException occured", e);
		}

	}

	public void unmarshall() {
		try {
			JAXBContext jaxbContent = JAXBContext.newInstance(AutomotiveElectrician.class);
			Unmarshaller unmarshaller = jaxbContent.createUnmarshaller();
			AutomotiveElectrician automotiveElectrician = (AutomotiveElectrician) unmarshaller.unmarshal(file);
			LOGGER.info("Automotive Electrician information:");
			LOGGER.info("Automotive Electrician ID: " + automotiveElectrician.getIdAutomotiveElectrician());
			LOGGER.info("Car Service B ID: " + automotiveElectrician.getIdCarServiceB());
			LOGGER.info("Employee ID: " + automotiveElectrician.getIdEmployees());

		} catch (JAXBException e) {
			LOGGER.error("JAXBException occured", e);
		}
	}
}
