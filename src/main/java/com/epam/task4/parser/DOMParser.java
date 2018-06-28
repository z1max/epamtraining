package com.epam.task4.parser;

import com.epam.task4.model.Jewel;
import com.epam.task4.model.Necklace;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParser {
    private static final Logger LOG = Logger.getLogger(DOMParser.class);

    public Necklace parse(Document input) {
        LOG.info("Start parsing");
        Necklace necklace;
        Jewel jewel;

        Element root = input.getDocumentElement();
        LOG.info("Start handling element " + root.getTagName());
        necklace = new Necklace(root.getAttribute("name"));
        LOG.info("End handling element " + root.getTagName());

        NodeList nodeList = root.getElementsByTagName("jewel");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            LOG.info("Start handling element " + currentNode.getNodeName());

            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) currentNode;
                jewel = new Jewel(element.getAttribute("name"));

                Element weight = (Element) element.getElementsByTagName("weight").item(0);
                LOG.info("Start handling element " + element.getTagName());
                jewel.setWeight(Double.valueOf(weight.getTextContent()));
                LOG.info("Start handling element " + element.getTagName());


                Element price = (Element) element.getElementsByTagName("price").item(0);
                LOG.info("Start handling element " + price.getTagName());
                jewel.setPrice(Long.valueOf(price.getTextContent()));
                LOG.info("End handling element " + price.getTagName());

                Element refractiveIndex = (Element) element.getElementsByTagName("refractive-index").item(0);
                LOG.info("Start handling element " + refractiveIndex.getTagName());
                jewel.setRefractiveIndex(Double.valueOf(refractiveIndex.getTextContent()));
                LOG.info("End handling element " + refractiveIndex.getTagName());

                necklace.addJewel(jewel);
            }
            LOG.info("End handling element " + currentNode.getNodeName());
        }
        LOG.info("End parsing");
        return necklace;
    }
}