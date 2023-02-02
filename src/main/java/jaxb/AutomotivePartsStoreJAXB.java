package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.AutomotivePartsStore;

public class AutomotivePartsStoreJAXB {
	private static final Logger LOGGER = LogManager.getLogger(AutomotivePartsStoreJAXB.class);
	File file = new File(
			"C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\jaxbXml\\AutomotivePartsStoreJAXB.xml");

	public void marshall() {
		try {
			AutomotivePartsStore automotivePartsStore = new AutomotivePartsStore(1L, 1L, 1L, 1L, "3");
			JAXBContext jaxbContext = JAXBContext.newInstance(AutomotivePartsStore.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(automotivePartsStore, System.out);
			marshaller.marshal(automotivePartsStore, file);

		} catch (JAXBException e) {
			LOGGER.error("JAXBException", e);
		}
	}

	public void unmarshall() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(AutomotivePartsStore.class);
			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			AutomotivePartsStore automotivePartsStore = (AutomotivePartsStore) unMarshaller.unmarshal(file);
			LOGGER.info("Automotive parts store info");
			LOGGER.info("Automotive parts store ID" + automotivePartsStore.getIdAutomotivePartsStore());
			LOGGER.info("Cashier ID" + automotivePartsStore.getIdСashier());
			LOGGER.info("Order ID" + automotivePartsStore.getIdOrders());
			LOGGER.info("Part warehouse ID" + automotivePartsStore.getIdPartWarehouse());
			LOGGER.info("Part ID" + automotivePartsStore.getPartid());

		} catch (JAXBException e) {
			LOGGER.error("JAXBException", e);
		}
	}

}
