package main;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import ua.homework.marshalling.Hero;
import ua.homework.parserDOM.ParserDOM;
import ua.homework.parserSAX.ParserSAX;
import ua.homework.validatorXML.ValidatorXML;

public class Main {
	public static void main(String[] args) {
		try {
			if (new ValidatorXML().checkXMLSchema("pom.xsd", "pom.xml")) {
				System.out.println("DOM");
				System.out.println(new ParserDOM("pom.xml").parserDocument());

				System.out.println("---------------------------------------------------------");
				System.out.println("SAX");
				SAXParserFactory.newInstance().newSAXParser().parse("pom.xml", new ParserSAX());
			}

			System.out.println("---------------------------------------------------------");
			System.out.println("Marshalling");
			Hero hero = new Hero("Punge", 10, 20, 30, 40);
			JAXBContext context = JAXBContext.newInstance(Hero.class);
			Marshaller mar = context.createMarshaller();
			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			mar.marshal(hero, System.out);
		} catch (SAXException | IOException | ParserConfigurationException | JAXBException e) {
			e.printStackTrace();
		}

	}
}
