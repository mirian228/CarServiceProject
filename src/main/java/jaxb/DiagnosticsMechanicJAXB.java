package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.DiagnosticsMechanic;

public class DiagnosticsMechanicJAXB {
	private static final Logger LOGGER = LogManager.getLogger(DiagnosticsMechanicJAXB.class);
	File file = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\xml\\DiagnosticsMechanic.xml");

	public void marshall() {
		try {
			DiagnosticsMechanic diagnosticsMechanic = new DiagnosticsMechanic(1L, 1L, 3L);
			JAXBContext jaxbContext = JAXBContext.newInstance(DiagnosticsMechanic.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(diagnosticsMechanic, System.out);
			marshaller.marshal(diagnosticsMechanic, file);

		} catch (JAXBException e) {
			LOGGER.error("JAXException", e);
		}
	}

	public void unmarshall() {
		try {
			JAXBContext jaxbContent = JAXBContext.newInstance(DiagnosticsMechanic.class);
			Unmarshaller unmarshaller = jaxbContent.createUnmarshaller();
			DiagnosticsMechanic diagnosticsMechanic = (DiagnosticsMechanic) unmarshaller.unmarshal(file);
			LOGGER.info("Car Service B info:");
			LOGGER.info("Car service B ID: " + diagnosticsMechanic.getIdDiagnosticsMechanic());
			LOGGER.info("Car ID: " + diagnosticsMechanic.getIdCarServiceA());
			LOGGER.info("Service type: " + diagnosticsMechanic.getIdEmployees());

		} catch (JAXBException e) {
			LOGGER.error("JAXBException occured", e);
		}
	}
}
