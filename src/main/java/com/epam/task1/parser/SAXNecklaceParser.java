package com.epam.task1.parser;

import com.epam.task1.model.Jewel;
import com.epam.task1.model.Necklace;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXNecklaceParser extends DefaultHandler {
    private static final Logger LOG = Logger.getLogger(SAXNecklaceParser.class);

    private Necklace necklace;
    private Jewel jewel;
    private StringBuilder text;

    public Necklace getNecklace() {
        return necklace;
    }

    @Override
    public void startDocument() throws SAXException {
        LOG.info("Start parsing");
    }

    @Override
    public void endDocument() throws SAXException {
        LOG.info("End parsing");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        LOG.info("Start handling element " +  qName);
        text = new StringBuilder();

        if (qName.equals("necklace")){
            necklace = new Necklace(attributes.getValue("name"));
        }
        if (qName.equals("jewel")){
           jewel = new Jewel(attributes.getValue("name"));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        LOG.info("End handling element " + qName);
        switch (qName){
            case "weight" : {
                jewel.setWeight(Double.valueOf(text.toString()));
                break;
            }
            case "price" : {
                jewel.setPrice(Long.valueOf(text.toString()));
                break;
            }
            case "refractive-index" : {
                jewel.setRefractiveIndex(Double.valueOf(text.toString()));
                break;
            }
            case "jewel" : {
                necklace.addJewel(jewel);
                jewel = null;
                break;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch, start, length);
    }
}
