package com.rencap.rcconn;

//import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.EmailAddress;
import microsoft.exchange.webservices.data.property.complex.MessageBody;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.net.URI;
import java.sql.*;

public class RCConnMain {
    public static String exec(String connDriver, String connProps, String user, String pass, String query) {
        StringBuilder result =  new StringBuilder("<root>");
        try {
            Class.forName(connDriver);
            Connection conn = DriverManager.getConnection(connProps, user, pass);
            Statement curs = conn.createStatement();
            ResultSet rs = curs.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            while (rs.next()) {
                result.append("<item>");
                for (int item = 1; item <= meta.getColumnCount(); item++) {
                    result.append(String.format("<%s>", meta.getColumnName(item))).append(rs.getString(item)).append(String.format("</%s>", meta.getColumnName(item)));
                }
                result.append("</item>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.append("</root>");
        return result.toString();
    }

    public static Document exec1(String connDriver, String connProps, String user, String pass, String query) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element root = doc.createElement("body");
        doc.appendChild(root);

        try {
            Class.forName(connDriver);
            Connection conn = DriverManager.getConnection(connProps, user, pass);
            Statement curs = conn.createStatement();
            ResultSet rs = curs.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            while (rs.next()) {
                Element item = doc.createElement("item");
                root.appendChild(item);
                for (int iter = 1; iter <= meta.getColumnCount(); iter++) {
                    Element column = doc.createElement(meta.getColumnName(iter));
                    item.appendChild(column);
                    column.appendChild(doc.createTextNode(rs.getString(iter)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }

    public static String exec2(String connDriver, String connProps, String user, String pass, String query) {
        StringBuilder result =  new StringBuilder();
        try {
            Class.forName(connDriver);
            Connection conn = DriverManager.getConnection(connProps, user, pass);
            Statement curs = conn.createStatement();
            ResultSet rs = curs.executeQuery(query);
            ResultSetMetaData meta = rs.getMetaData();
            while (rs.next()) {
                for (int item = 1; item <= meta.getColumnCount(); item++) {
                    result.append(meta.getColumnName(item)).append(":").append(rs.getString(item)).append(";");
                }
                result.append("|");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}