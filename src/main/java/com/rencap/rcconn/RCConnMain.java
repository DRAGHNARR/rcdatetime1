package com.rencap.rcconn;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.sql.*;

public class RCConnMain {
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

    public static Document exec(String connDriver, String connProps, String user, String pass, String query) throws Exception {
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
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return doc;
    }

    public static Document exec3(String connDriver, String connProps, String user, String pass, String query) throws ParserConfigurationException {
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
            Element error = doc.createElement("error");
            System.out.println(e.getMessage());
            root.appendChild(error);
            error.appendChild(doc.createTextNode(e.getMessage()));
        }
        return doc;
    }
}