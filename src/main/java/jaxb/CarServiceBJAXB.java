package jaxb;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import model.CarServiceB;

public class CarServiceBJAXB {
	private static final Logger LOGGER = LogManager.getLogger(CarServiceBJAXB.class);
	File file = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\jaxbXml\\CarSeviceBJAXB.xml");

	public void marshall() {
		try {
			CarServiceB carServiceB = new CarServiceB(1L, 2L, "Engine Replacement");
			JAXBContext jaxbContext = JAXBContext.newInstance(CarServiceB.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(carServiceB, System.out);
			marshaller.marshal(carServiceB, file);

		} catch (JAXBException e) {
			LOGGER.error("JAXException", e);
		}
	}

	public void unmarshall() {
		try {
			JAXBContext jaxbContent = JAXBContext.newInstance(CarServiceB.class);
			Unmarshaller unmarshaller = jaxbContent.createUnmarshaller();
			CarServiceB carServiceB = (CarServiceB) unmarshaller.unmarshal(file);
			LOGGER.info("Car Service B info:");
			LOGGER.info("Car service B ID: " + carServiceB.getIdCarServiceB());
			LOGGER.info("Car ID: " + carServiceB.getIdCar());
			LOGGER.info("Service type: " + carServiceB.getServiceType());

		} catch (JAXBException e) {
			LOGGER.error("JAXBException occured", e);
		}
	}

}
