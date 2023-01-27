package utility;

import java.util.Properties;
import java.io.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseConfigUtil {
	private static final Logger LOGGER = LogManager.getLogger(DatabaseConfigUtil.class);
	private static Properties properties = new Properties();
	
	static {
		try {
			properties.load(new FileReader("database.properties"));
		} catch (FileNotFoundException e) {
			LOGGER.error("File Not Found Exception", e);
		} catch (IOException e) {
			LOGGER.error("IOException", e);
		}
	}
	
	private DatabaseConfigUtil() {

    }
	
	 public static Properties getProperties() {
	        return properties;
	    }
}
