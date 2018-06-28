package com.epam.task4.parser;

import com.epam.task4.model.Jewel;
import com.epam.task4.model.Necklace;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class StAXNecklaceParser {
    private static final Logger LOG = Logger.getLogger(StAXNecklaceParser.class);

    public Necklace parse(String fileName) throws FileNotFoundException, XMLStreamException {
        Necklace necklace = new Necklace();
        Jewel jewel = new Jewel();

        XMLInputFactory factory = XMLInputFactory.newInstance();

        InputStream input = new FileInputStream(fileName);
        XMLStreamReader reader = factory.createXMLStreamReader(input);

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_DOCUMENT: {
                    LOG.info("Start parsing file");
                    break;
                }
                case XMLStreamConstants.END_DOCUMENT: {
                    LOG.info("End parsing file");
                    break;
                }
                case XMLStreamConstants.START_ELEMENT: {
                    String elementName = reader.getLocalName();
                    LOG.info("Start handle element " + elementName);
                    switch (elementName) {
                        case "necklace": {
                            necklace = new Necklace(reader.getAttributeValue(null, "name"));
                            break;
                        }
                        case "jewel": {
                            jewel = new Jewel(reader.getAttributeValue(null, "name"));
                            break;
                        }
                        case "weight": {
                            jewel.setWeight(Double.valueOf(reader.getElementText()));
                            break;
                        }
                        case "price": {
                            jewel.setPrice(Long.valueOf(reader.getElementText()));
                            break;
                        }
                        case "refractive-index": {
                            jewel.setRefractiveIndex(Double.valueOf(reader.getElementText()));
                            break;
                        }
                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    String elementName = reader.getLocalName();
                    LOG.info("End handling element " + elementName);
                    if (elementName.equals("jewel")) {
                        necklace.addJewel(jewel);
                        jewel = null;
                    }
                }
            }
        }
        return necklace;
    }
}
