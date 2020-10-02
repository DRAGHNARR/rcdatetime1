package com.rencap.rcmail;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.EmailAddress;
import microsoft.exchange.webservices.data.property.complex.MessageBody;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import java.net.URI;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Store;

public class RCMailMain {
    public static String nodeToString(Node node) throws TransformerException {
        StringWriter writer = new StringWriter();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(node), new StreamResult(writer));
        return writer.toString();
    }

    public static String send(String to, String subject, Node body) throws Exception {
        ExchangeService service = new ExchangeService();
        service.setTraceEnabled(true);
        ExchangeCredentials creds = new WebCredentials("SvcEmail@rencap.com", "JNVK28ekcs");
        service.setCredentials(creds);
        //service.autodiscoverUrl("SvcEmail@rencap.com");
        //service.setTraceEnabled(true);
        service.setUrl(URI.create("https://outlook.office365.com/EWS/Exchange.asmx"));

        try {
            EmailMessage msg = new EmailMessage(service);
            msg.setFrom(new EmailAddress("SvcEmail@rencap.com"));
            String[] toList = to.split(";");

            for (int i = 0; i < toList.length; i++) {
                msg.getToRecipients().add(toList[i]);
            }

            msg.setSubject(subject);
            msg.setBody(new MessageBody(RCMailMain.nodeToString(body)));

            /*
            if (attach != "") {
                String[] attachList = attach.split(";");
                for (int i = 0; i < attachList.length; i++) {
                    msg.getAttachments().addFileAttachment(attachList[i]);
                }
            }
            */

            msg.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sended";
    }

    public static String send(String from, String pass, String to, String subject, Node body) throws Exception {
        ExchangeService service = new ExchangeService();
        service.setTraceEnabled(true);
        ExchangeCredentials creds = new WebCredentials(from, pass);
        service.setCredentials(creds);
        //service.autodiscoverUrl("SvcEmail@rencap.com");
        //service.setTraceEnabled(true);
        service.setUrl(URI.create("https://outlook.office365.com/EWS/Exchange.asmx"));

        try {
            EmailMessage msg = new EmailMessage(service);
            msg.setFrom(new EmailAddress(from));
            String[] toList = to.split(";");

            for (int i = 0; i < toList.length; i++) {
                msg.getToRecipients().add(toList[i]);
            }

            msg.setSubject(subject);
            msg.setBody(new MessageBody(RCMailMain.nodeToString(body)));

            /*
            if (attach != "") {
                String[] attachList = attach.split(";");
                for (int i = 0; i < attachList.length; i++) {
                    msg.getAttachments().addFileAttachment(attachList[i]);
                }
            }
            */

            msg.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sended";
    }

    public static String sendCc(String to, String cc, String subject, Node body) throws Exception {
        ExchangeService service = new ExchangeService();
        service.setTraceEnabled(true);
        ExchangeCredentials creds = new WebCredentials("SvcEmail@rencap.com", "JNVK28ekcs");
        service.setCredentials(creds);
        //service.autodiscoverUrl("SvcEmail@rencap.com");
        //service.setTraceEnabled(true);
        service.setUrl(URI.create("https://outlook.office365.com/EWS/Exchange.asmx"));

        try {
            EmailMessage msg = new EmailMessage(service);
            msg.setFrom(new EmailAddress("SvcEmail@rencap.com"));
            String[] toList = to.split(";");

            for (int i = 0; i < toList.length; i++) {
                msg.getToRecipients().add(toList[i]);
            }

            cc = cc.trim();
            if (cc != "") {
                String[] ccList = cc.split(";");
                for (int i = 0; i < ccList.length; i++) {
                    msg.getCcRecipients().add(ccList[i]);
                }
            }

            msg.setSubject(subject);
            msg.setBody(new MessageBody(RCMailMain.nodeToString(body)));

            /*
            if (attach != "") {
                String[] attachList = attach.split(";");
                for (int i = 0; i < attachList.length; i++) {
                    msg.getAttachments().addFileAttachment(attachList[i]);
                }
            }
            */

            msg.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "sended";
    }

    public static String sendFree(String from, String pass, String to, String subject, Node body) throws Exception {
        Properties props = new Properties();
        props.setProperty("mail.imaps.sasl.enable", "true");
        props.setProperty("mail.imaps.sasl.authorizationid", "MurexSupportShared");
        Session session = Session.getInstance(props);
        Store store = session.getStore("smtps");
        store.connect("outlook.office365.com", 993, "SvcEmail@rencap.com", "JNVK28ekcs");
        return "1";
    }
}
