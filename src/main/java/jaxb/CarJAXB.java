package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Car;

public class CarJAXB {
	private static final Logger LOGGER = LogManager.getLogger(CarJAXB.class);
	File file = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\jaxbXml\\CarJAXB.xml");
	File file2 = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\xml\\Car.xml");
	
	public CarJAXB(){
		
	}
	
	public void marshall() {
		try {
			Car car = new Car(3L, 1L, "KNDJE723297570351" , "BMW", "X3", "SUV", 2018, "2993cc", "Gasoline", "Alpine White");
			JAXBContext jaxbContent = JAXBContext.newInstance(Car.class);
			Marshaller marshaller = jaxbContent.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(car,  System.out);
			marshaller.marshal(car, file);
			
		} catch (JAXBException e) {
			LOGGER.error("JAXBException occured", e);
		}
		
		
	}

	public void unmarshall() {
		try {
			JAXBContext jaxbContent = JAXBContext.newInstance(Car.class);
			Unmarshaller unmarshaller = jaxbContent.createUnmarshaller();
			Car car = (Car) unmarshaller.unmarshal(file);
			LOGGER.info("Car info");
			LOGGER.info("Vin: " + car.getVin());
			LOGGER.info("Make: " + car.getMake());
			LOGGER.info("Model: " + car.getModel());
			LOGGER.info("Body type: " + car.getBodytype());
			LOGGER.info("Production year: " + car.getProductionYear());
			LOGGER.info("Engine capacity: " + car.getEngineCapacity());
			LOGGER.info("Fuel type: " + car.getFuelType());
			LOGGER.info("Exterior color: " + car.getExteriorColor());
			

		} catch (JAXBException e) {
			LOGGER.error("JAXBException occured", e);
		}
	}
	

	public void unmarshallExistingFile() {
		try {
			JAXBContext jaxbContent = JAXBContext.newInstance(Car.class);
			Unmarshaller unmarshaller = jaxbContent.createUnmarshaller();
			Car car = (Car) unmarshaller.unmarshal(file2);
			LOGGER.info("Car info");
			LOGGER.info("Vin: " + car.getVin());
			LOGGER.info("Make: " + car.getMake());
			LOGGER.info("Model: " + car.getModel());
			LOGGER.info("Body type: " + car.getBodytype());
			LOGGER.info("Production year: " + car.getProductionYear());
			LOGGER.info("Engine capacity: " + car.getEngineCapacity());
			LOGGER.info("Fuel type: " + car.getFuelType());
			LOGGER.info("Exterior color: " + car.getExteriorColor());

		} catch (JAXBException e) {
			LOGGER.error("JAXBException occured", e);
		}

	}
	 
}
