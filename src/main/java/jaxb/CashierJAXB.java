package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Cashier;

public class CashierJAXB {
	private static final Logger LOGGER = LogManager.getLogger(CashierJAXB.class);
	File file = new File(
			"C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\jaxbXml\\CashierJAXB.xml");

	public void marshall() {
		try {
			Cashier cashier = new Cashier(1L, 1L);
			JAXBContext jaxbContext = JAXBContext.newInstance(Cashier.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(cashier, System.out);
			marshaller.marshal(cashier, file);

		} catch (JAXBException e) {
			LOGGER.error("JAXBException", e);
		}
	}

	public void unmarshall() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Cashier.class);
			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			Cashier cashier = (Cashier) unMarshaller.unmarshal(file);
			LOGGER.info("Cashier info");
			LOGGER.info("Cashier ID" + cashier.getIdCashier());
			LOGGER.info("Employee ID" + cashier.getIdEmployees());

		} catch (JAXBException e) {
			LOGGER.error("JAXBException", e);
		}
	}
}
