package ruff;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import utilities.PathManager;


public class RuffWork {

	public static void main(String[] args) throws IOException {
		Properties config = new Properties();
		FileInputStream fConfig = new FileInputStream(
				PathManager.getResourcePath("/resources/properties/Config.properties"));
	
		config.load(fConfig);
		System.out.println(config.getProperty("browser"));
	}

}
