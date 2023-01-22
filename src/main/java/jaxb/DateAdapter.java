package jaxb;

import java.util.Date;
import java.text.SimpleDateFormat;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {
    private static final String CUSTOM_FORMAT_STRING = "yyyy-MM-dd";


	@Override
	public String marshal(Date v) throws Exception {
		return new SimpleDateFormat(CUSTOM_FORMAT_STRING).format(v);
	}
	
	@Override
	public Date unmarshal(String v) throws Exception {
		return new SimpleDateFormat(CUSTOM_FORMAT_STRING).parse(v);
	}

}
