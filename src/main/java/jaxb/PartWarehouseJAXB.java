package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.PartWarehouse;

public class PartWarehouseJAXB {
	private static final Logger LOGGER = LogManager.getLogger(PartWarehouseJAXB.class);
	File file = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\xml\\PartWarehouse.xml");
	
	public void marshall() {
		try {
			PartWarehouse partWarehouse = new PartWarehouse(1L, "1", "Valve cover gasket" , "b32sCx100", 3, "Mahle", 2021);
			JAXBContext jaxbContent = JAXBContext.newInstance(PartWarehouse.class);
			Marshaller marshaller = jaxbContent.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(partWarehouse,  System.out);
			marshaller.marshal(partWarehouse, file);
			
		} catch (JAXBException e) {
			LOGGER.error("JAXBException occured", e);
		}
		
		
	}

	public void unmarshall() {
		try {
			JAXBContext jaxbContent = JAXBContext.newInstance(PartWarehouse.class);
			Unmarshaller unmarshaller = jaxbContent.createUnmarshaller();
			PartWarehouse partWarehouse = (PartWarehouse) unmarshaller.unmarshal(file);
			LOGGER.info("Part warehouse info");
			LOGGER.info("Part warehouse ID : " + partWarehouse.getIdPartWarehouse());
			LOGGER.info("Part ID: " + partWarehouse.getPartId());
			LOGGER.info("Part name: " + partWarehouse.getPartName());
			LOGGER.info("Part number: " + partWarehouse.getPartNumber());
			LOGGER.info("Part quantity: " + partWarehouse.getPartquantity());
			LOGGER.info("Part producer: " + partWarehouse.getProducer());
			LOGGER.info("Part name: " + partWarehouse.getReleaseyear());
			

		} catch (JAXBException e) {
			LOGGER.error("JAXBException occured", e);
		}
	}
	
	
}
