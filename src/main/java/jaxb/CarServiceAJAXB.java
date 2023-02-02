package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.CarServiceA;

public class CarServiceAJAXB {
	private static final Logger LOGGER = LogManager.getLogger(CarServiceAJAXB.class);
	File file = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\jaxbXml\\CarServiceAJAXB.xml");
	
	
	public void marshall() {
		try {
			CarServiceA carServiceA = new CarServiceA(1L, 2L, "Gearbox Replacement");
			JAXBContext jaxbContext = JAXBContext.newInstance(CarServiceA.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(carServiceA, System.out);
			marshaller.marshal(carServiceA, file);

		} catch (JAXBException e) {
			LOGGER.error("JAXException", e);
		}
	}

	public void unmarshall() {
		try {
			JAXBContext jaxbContent = JAXBContext.newInstance(CarServiceA.class);
			Unmarshaller unmarshaller = jaxbContent.createUnmarshaller();
			CarServiceA carServiceA = (CarServiceA) unmarshaller.unmarshal(file);
			LOGGER.info("Car Service B info:");
			LOGGER.info("Car service B ID: " + carServiceA.getIdCarServiceA());
			LOGGER.info("Car ID: " + carServiceA.getIdCar());
			LOGGER.info("Service type: " + carServiceA.getServiceType());

		} catch (JAXBException e) {
			LOGGER.error("JAXBException occured", e);
		}
	}
}
