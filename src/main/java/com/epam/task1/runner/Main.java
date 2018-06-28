package com.epam.task1.runner;

import com.epam.task1.model.Necklace;
import com.epam.task1.parser.DOMParser;
import com.epam.task1.parser.SAXNecklaceParser;
import com.epam.task1.parser.StAXNecklaceParser;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);
    private static final String XSD_PATH = "src/main/resources/task4/necklace.xsd";
    private static final String XML_PATH = "src/main/resources/task4/necklace.xml";

    public static void main(String[] args) {
        try {
            validateXml(XSD_PATH, XML_PATH);
        } catch (SAXException e) {
            LOG.error("Error parsing file!", e);
        } catch (IOException e) {
            LOG.error("File not found!", e);
        }

        Necklace necklaceSAX;
        try {
            necklaceSAX = parseUsingSAX(XML_PATH);
            LOG.info("Parsed by SAX " + necklaceSAX);
        } catch (ParserConfigurationException e) {
            LOG.error("Parser error!", e);
        } catch (SAXException e) {
            LOG.error("Error parsing file!", e);
        } catch (IOException e) {
            LOG.error("File not found!", e);
        }

        Necklace necklaceStAX;
        try {
            necklaceStAX = parseUsingStAX(XML_PATH);
            LOG.info("Parsed by StAX " + necklaceStAX);
        } catch (FileNotFoundException e) {
            LOG.error("File not found!", e);
        } catch (XMLStreamException e) {
            LOG.error("Error parsing file!", e);
        }

        Necklace necklaceDOM;
        try {
            necklaceDOM = parseUsingDOM(XML_PATH);
            LOG.info("Parsed by DOM " + necklaceDOM);
        } catch (ParserConfigurationException e) {
            LOG.error("Parser error!", e);
        } catch (IOException e) {
            LOG.error("File not found!", e);
        } catch (SAXException e) {
            LOG.error("Error parsing file!", e);
        }
    }

    private static void validateXml(String xsdPath, String xmlPath) throws SAXException, IOException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        File schemaLocation = new File(xsdPath);
        Source xmlFile = new StreamSource(xmlPath);

        Schema schema = factory.newSchema(schemaLocation);
        Validator validator = schema.newValidator();
        validator.validate(xmlFile);
    }

    private static Necklace parseUsingSAX(String xmlPath) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser parser = factory.newSAXParser();
        SAXNecklaceParser necklaceParser = new SAXNecklaceParser();
        parser.parse(xmlPath, necklaceParser);
        return necklaceParser.getNecklace();
    }

    private static Necklace parseUsingStAX(String xmlPath) throws FileNotFoundException, XMLStreamException {
        return new StAXNecklaceParser().parse(xmlPath);
    }

    private static Necklace parseUsingDOM(String xmlPath) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlPath);
        return new DOMParser().parse(document);
    }
}
