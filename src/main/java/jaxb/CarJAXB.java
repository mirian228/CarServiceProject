package jaxb;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import main.Main;
import model.Car;

public class CarJAXB {
	private static final Logger LOGGER = LogManager.getLogger(Main.class);
	File file = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\marshallerCar.xml");
	File file2 = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\Car.xml");
	
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
			LOGGER.info("vin: " + car.getVin());
			LOGGER.info("make: " + car.getMake());
			LOGGER.info("model: " + car.getModel());

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
			LOGGER.info("idCustomer: " + car.getVin());
			LOGGER.info("make: " + car.getMake());
			LOGGER.info("model: " + car.getModel());

		} catch (JAXBException e) {
			LOGGER.error("JAXBException occured", e);
		}

	}
	 
}
