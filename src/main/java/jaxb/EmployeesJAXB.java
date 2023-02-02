package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Employees;

public class EmployeesJAXB {
	private static final Logger LOGGER = LogManager.getLogger(EmployeesJAXB.class);
	File file = new File(
			"C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\jaxbXml\\EmployeesJAXB.xml");

	public void marshall() {
		try {
			Employees employees = new Employees(1L, "Gia", "Bolkvadze", "Batumi", "+995555222000",
					"Gogebashvili Street 2", 25000, 2L);
			JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(employees, System.out);
			marshaller.marshal(employees, file);

		} catch (JAXBException e) {
			LOGGER.error("JAXBException", e);
		}
	}

	public void unmarshall() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			Employees employees = (Employees) unMarshaller.unmarshal(file);
			LOGGER.info("Employee info");
			LOGGER.info("Employee ID " + employees.getIdEmployees());
			LOGGER.info("First name " + employees.getFname());
			LOGGER.info("Last name " + employees.getLname());
			LOGGER.info("City " + employees.getCity());
			LOGGER.info("Phone number " + employees.getPhoneNumber());
			LOGGER.info("adress " + employees.getAdress());
			LOGGER.info("salary " + employees.getSalary());
			LOGGER.info("Manager ID" + employees.getIdManager());

		} catch (JAXBException e) {
			LOGGER.error("JAXBException", e);
		}
	}
}
