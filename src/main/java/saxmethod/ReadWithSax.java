package saxmethod;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadWithSax {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Mirian\\eclipse-workspace\\CarService\\src\\main\\resources\\Car.xml");
		
		try {
			SAXParserFactory factory =  SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			DefaultHandler handler = new DefaultHandler() {
				boolean bvin = false;  
				boolean bmake = false;  
				boolean bmodel = false;
				boolean bbodytype = false;
				boolean bproductionYear = false;
				boolean bengineCapacity = false;
				boolean bfuelType = false;
				boolean bexteriorColor = false;
				
		public void startElement(String uri, String local, String qName, Attributes attributes) throws SAXException {
						System.out.println("Start Element: " + qName);
						if(qName.equals("vin")) bvin = true;
						if(qName.equals("make")) bmake = true;
						if(qName.equals("model")) bmodel = true;
						if(qName.equals("bodytype")) bbodytype = true;
						if(qName.equals("productionYear")) bproductionYear = true;
						if(qName.equals("engineCapacity")) bengineCapacity = true;
						if(qName.equals("fuelType")) bfuelType = true;
						if(qName.equals("bexteriorColor")) bexteriorColor = true;
						
						
			} 
		public void endElement(String uri, String local, String qName) 
		{
			System.out.println("End Element: " + qName);
		}
		
		public void characters(char[] ch, int start, int length) throws SAXException
		{
			if(bvin) 
			{
			System.out.println("vin: " + new String(ch, start, length));
			bvin = false;
			}
			if(bmake) 
			{
			System.out.println("make: " + new String(ch, start, length));
			bmake = false;
			}
			if(bmodel)
			{
			System.out.println("model: " + new String(ch, start, length));
			bmodel = false;
			}
			if(bbodytype)
			{
			System.out.println("bodytype: " + new String(ch, start, length));
			bbodytype = false;
			}
			if(bproductionYear)
			{
			System.out.println("productionYear: " + new String(ch, start, length));
			bproductionYear = false;
			}
			if(bengineCapacity)
			{
			System.out.println("engineCapacity: " + new String(ch, start, length));
			bengineCapacity = false;
			}
			if(bfuelType)
			{
			System.out.println("fuelType: " + new String(ch, start, length));
			bfuelType = false;
			}
			if(bexteriorColor)
			{
			System.out.println("exteriorColor: " + new String(ch, start, length));
			bexteriorColor = false;
			}
		}
		
			};
			
			saxParser.parse(file, handler);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
