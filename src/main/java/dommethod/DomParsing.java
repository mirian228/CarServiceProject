package dommethod;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import main.Main;
import model.Car;

public class DomParsing {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		Car car = new Car();
		Document xmlFile = null;
		
		try {
			 xmlFile = buildDocument();
			 NodeList carXml1 = xmlFile.getElementsByTagName("vin");
			 NodeList carXml2 = xmlFile.getElementsByTagName("make");
			 NodeList carXml3 = xmlFile.getElementsByTagName("model");
			 NodeList carXml4 = xmlFile.getElementsByTagName("bodytype");
			 NodeList carXml5 = xmlFile.getElementsByTagName("productionYear");
			 NodeList carXml6 = xmlFile.getElementsByTagName("engineCapacity");
			 NodeList carXml7 = xmlFile.getElementsByTagName("fuelType");
			 
			 for(int i=0; i < carXml1.getLength(); i++ ) {
					Node node1 = carXml1.item(i);
					Node node2 = carXml2.item(i);
					Node node3 = carXml3.item(i);
					Node node4 = carXml4.item(i);
					Node node5 = carXml5.item(i);
					Node node6 = carXml6.item(i);
				if(node1.getNodeType() == Node.ELEMENT_NODE) {
					System.out.println("vin: " + node1.getTextContent());
					System.out.println("make: " + node1.getTextContent());
					System.out.println("model: " + node2.getTextContent());
					System.out.println("bodytype: " + node3.getTextContent());
					System.out.println("productionYear: " + node4.getTextContent());
					System.out.println("engineCapcaity: " + node5.getTextContent());
					System.out.println("fuelType: " + node6.getTextContent() + "\n");
				}
			 
			 
			 
			 }
			 
			 
		} catch (SAXException | IOException | ParserConfigurationException e) {
			LOGGER.error("Parse error", e);
			return;
		}
		
		
		
		Node carXml = xmlFile.getFirstChild();
		NodeList carXmlList = xmlFile.getChildNodes();
		System.out.println("First child - " + carXml.getNodeName());
		
		
		
		String fullText = null; 
		String vinText = null;
		Node car1 = null;
		
		for(int i=0; i < carXmlList.getLength(); i++) {
			if(carXmlList.item(i).getNodeType() == Node.ELEMENT_NODE) {
			 System.out.println("All Child tags - " + carXmlList.item(i).getNodeName());
			}
			switch(carXmlList.item(i).getNodeName()) {
			case "car": {
				fullText = carXmlList.item(i).getTextContent();
				System.out.println("Full text: " + fullText + "--------------------");
				break;
			}
			
			 
		
			}
			
			
			
		}
		
}
	private static Document buildDocument() throws SAXException, IOException, ParserConfigurationException {
		File file = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\Car.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		return factory.newDocumentBuilder().parse(file);
	}
	}


