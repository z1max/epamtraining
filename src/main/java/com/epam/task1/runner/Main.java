package com.epam.task1.runner;

import com.epam.task1.model.Necklace;
import com.epam.task1.parser.SAXNecklaceParser;
import com.epam.task1.parser.StAXNecklaceParser;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        validateXml("src/main/resources/task4/necklace.xsd", "src/main/resources/task4/necklace.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            javax.xml.parsers.SAXParser parser = factory.newSAXParser();
            SAXNecklaceParser necklaceParser = new SAXNecklaceParser();
            parser.parse("src/main/resources/task4/necklace.xml", necklaceParser);
            System.out.println(necklaceParser.getNecklace());
        } catch (ParserConfigurationException e) {
            LOG.error("Parser error", e);
        } catch (SAXException e) {
            LOG.error("Error parsing file", e);
        } catch (IOException e) {
            LOG.info("File not found", e);
        }

        Necklace necklace = new StAXNecklaceParser().parse("src/main/resources/task4/necklace.xml");
        System.out.println(necklace);
    }

    private static void validateXml(String xsdPath, String xmlPath){
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        File schemaLocation = new File(xsdPath);
        Source xmlFile = new StreamSource(xmlPath);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            validator.validate(xmlFile);
        } catch (SAXException e) {
            LOG.error(xmlFile.getSystemId() + " is not valid!", e);
        } catch (IOException e) {
            LOG.error("File not found!",e);
        }
    }
}
