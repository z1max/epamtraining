package com.epam.task1.runner;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
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
