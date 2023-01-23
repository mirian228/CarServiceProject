package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.EnginePartsStore;

public class EnginePartsStoreJAXB {
	private static final Logger LOGGER = LogManager.getLogger(EnginePartsStoreJAXB.class);
	File file = new File(
			"C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\xml\\EnginePartsStore.xml");

	public void marshall() {
		try {
			EnginePartsStore enginePartsStore = new EnginePartsStore(1L, 1L, 1L, "3");
			JAXBContext jaxbContext = JAXBContext.newInstance(EnginePartsStore.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(enginePartsStore, System.out);
			marshaller.marshal(enginePartsStore, file);

		} catch (JAXBException e) {
			LOGGER.error("JAXBException", e);
		}
	}
	
	public void unmarshall() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(EnginePartsStore.class);
			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			EnginePartsStore enginePartsStore = (EnginePartsStore) unMarshaller.unmarshal(file);
			LOGGER.info("Engine parts store info");
			LOGGER.info("Engine parts store ID" + enginePartsStore.getIdEnginePartsStore());
			LOGGER.info("Cashier ID" + enginePartsStore.getIdСashier());
			LOGGER.info("Part warehouse ID" + enginePartsStore.getIdPartWarehouse());
			LOGGER.info("Part ID" + enginePartsStore.getPartid());
			
		} catch (JAXBException e) {
			LOGGER.error("JAXBException", e);
		}
	}

}
