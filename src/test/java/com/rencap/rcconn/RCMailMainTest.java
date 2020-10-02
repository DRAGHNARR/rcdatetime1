package com.rencap.rcconn;

import com.rencap.rcmail.RCMailMain;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class RCMailMainTest {
    @Test
    public void send() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element root = doc.createElement("html");
        doc.appendChild(root);
        Element body = doc.createElement("html");
        root.appendChild(body);
        Element table = doc.createElement("table");
        body.appendChild(table);
        Element tr1 = doc.createElement("tr");
        table.appendChild(tr1);
        Element tr2 = doc.createElement("tr");
        table.appendChild(tr2);
        Element td1 = doc.createElement("td");
        tr1.appendChild(td1);
        Element td2 = doc.createElement("td");
        tr1.appendChild(td2);
        Element td3 = doc.createElement("td");
        tr2.appendChild(td3);
        Element td4 = doc.createElement("td");
        tr2.appendChild(td4);

        td1.appendChild(doc.createTextNode("Hi there!"));
        td2.appendChild(doc.createTextNode("Hi there!"));
        td3.appendChild(doc.createTextNode("Hi there!"));
        td4.appendChild(doc.createTextNode("Hi there!"));

        String result = RCMailMain.send("SvcEmail@rencap.com", "JNVK28ekcs", "dkochnev@rencap.com", "test", root);
        Assert.assertEquals("sended", result);
    }
}
