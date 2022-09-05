package ua.homework.validatorXML;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class ValidatorXML {

	public boolean checkXMLSchema(String nameXSD, String nameXML) {
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(nameXSD);
			Schema schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
					.newSchema(new StreamSource(inputStream));
			schema.newValidator().validate(new StreamSource(new File(nameXML)));
		} catch (IOException | SAXException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
