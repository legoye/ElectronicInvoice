/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gestino.cfdi;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author developer
 */
public class WebCfdiConnection {

    protected final Log logger = LogFactory.getLog("CFDI Gestino");

    private String urlSOAP;
    private String userId;
    private String userPassword;
    private String rfcEmisor;
    private String soapResponse;
    //not used
    public boolean generatePDF;
    public boolean generateTXT;
    public boolean generateCBB;
    public boolean error;
    public String strPDF;
    public String strXml;
    public String strCBB;
    public String strTxt;

    public WebCfdiConnection() {

        try {
            Properties prop = new Properties();
            InputStream fileProperties = getClass().getClassLoader().getResourceAsStream("ConnectionSOAP.properties");
            prop.load(fileProperties);

            this.urlSOAP = prop.getProperty("gestino.cfdi.url");
            this.userId = prop.getProperty("gestino.cfdi.id");
            this.userPassword = prop.getProperty("gestino.cfdi.password");
            this.rfcEmisor = prop.getProperty("gestino.cfdi.rfc");
            this.generatePDF = Boolean.parseBoolean(prop.getProperty("gestino.cfdi.generatePDF"));
            this.generateTXT = Boolean.parseBoolean(prop.getProperty("gestino.cfdi.generateTXT"));
            this.generateCBB = Boolean.parseBoolean(prop.getProperty("gestino.cfdi.generateCBB"));
            this.error = Boolean.parseBoolean(prop.getProperty("gestino.cfdi.error"));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

    }

    public String timbrar(String layout) {
//        File f = null;
        String linea, strLayout = "", layoutb64 = "", wsresponse = "Timbrado Exitoso";
        SOAPMessage soapResp;
//        f = new File(layout);
//        if (f.exists()) {
//            try {
//                BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(layout), "utf-8"));
//                while ((linea = buffer.readLine()) != null) {
//                    strLayout = strLayout + linea + "\n";
//                }
//            } catch (Exception ex) {
//                return "Error al leer el layout";
//            }
//            layout = strLayout;
//        }
        // Convertir a base 64 el layout.
        try {
            String ly = layout;
            layoutb64 = new sun.misc.BASE64Encoder().encode(ly.getBytes("UTF-8"));
        } catch (Exception ex) {
        }

        // Inicia la petición SOAP
        try {
            System.setProperty("java.net.useSystemProxies", "true");
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            // Enviar mensaje al servidor
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.addNamespaceDeclaration("xmlns", this.urlSOAP);
            SOAPBody soapBody = envelope.getBody();
            SOAPElement soapBodyElem = soapBody.addChildElement("requestTimbrarCFDI", "");
            SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("param0");
            SOAPElement soapBodyElem3 = soapBodyElem1.addChildElement("text2CFDI");
            soapBodyElem3.addTextNode(layoutb64);
            SOAPElement soapBodyElem4 = soapBodyElem1.addChildElement("UserID");
            soapBodyElem4.addTextNode(this.userId);
            SOAPElement soapBodyElem5 = soapBodyElem1.addChildElement("UserPass");
            soapBodyElem5.addTextNode(this.userPassword);
            SOAPElement soapBodyElem6 = soapBodyElem1.addChildElement("emisorRFC");
            soapBodyElem6.addTextNode(this.rfcEmisor);
            SOAPElement soapBodyElem7 = soapBodyElem1.addChildElement("generarTXT");
            soapBodyElem7.addTextNode(Boolean.toString(this.generateTXT));
            SOAPElement soapBodyElem8 = soapBodyElem1.addChildElement("generarPDF");
            soapBodyElem8.addTextNode(Boolean.toString(this.generatePDF));
            SOAPElement soapBodyElem9 = soapBodyElem1.addChildElement("generarCBB");
            soapBodyElem9.addTextNode(Boolean.toString(this.generateCBB));
            MimeHeaders headers = soapMessage.getMimeHeaders();
            headers.addHeader("SOAPAction", "requestTimbrarCFDI");
            soapMessage.saveChanges();

            /* Dscomentar la siguiente linea si desea visualizar el request*/
            //this.soapRequest=this.soapMessageToString(soapMessage);
            soapResp = soapConnection.call(soapMessage, this.urlSOAP);

            this.soapResponse = this.soapMessageToString(soapResp);
            soapConnection.close();

            String cadenaXML = this.soapResponse;

            DOMParser parser = new DOMParser();
            parser.parse(new InputSource(new java.io.StringReader(cadenaXML)));

            Document doc = parser.getDocument();

            if (doc.getElementsByTagName("SOAP-ENV:Fault").getLength() > 0) {
                NodeList nodeLst = doc.getElementsByTagName("SOAP-ENV:Body");
                for (int i = 0; i < nodeLst.getLength(); i++) {
                    Element ele = (Element) nodeLst.item(i);

                    NodeList nlsCode = ele.getElementsByTagName("faultcode");
                    Element eleCode = (Element) nlsCode.item(0);
                    String strCode = eleCode.getFirstChild().getNodeValue();

                    NodeList nlsMessage = ele.getElementsByTagName("faultstring");
                    Element eleMsg = (Element) nlsMessage.item(0);
                    String strMessage = eleMsg.getFirstChild().getNodeValue();

                    wsresponse = "Error: " + strCode + "\n";
                    wsresponse = wsresponse + "Mensaje: " + strMessage;
                    this.error = true;

                }
            } else {
                if (this.generateCBB) {
                    this.generatePDF = false;
                }
                NodeList nodeLst = doc.getElementsByTagName("ns1:requestTimbrarCFDIResponse");
                for (int i = 0; i < nodeLst.getLength(); i++) {
                    Element ele = (Element) nodeLst.item(i);

                    NodeList nlsxml = ele.getElementsByTagName("xml");
                    Element elexml = (Element) nlsxml.item(0);
                    this.strXml = elexml.getFirstChild().getNodeValue();

                    if (this.generatePDF) {
                        NodeList nlspdf = ele.getElementsByTagName("pdf");
                        Element elepdf = (Element) nlspdf.item(0);
                        this.strPDF = elepdf.getFirstChild().getNodeValue();
                    }
                    if (this.generateTXT) {
                        NodeList nlstxt = ele.getElementsByTagName("txt");
                        Element eletxt = (Element) nlstxt.item(0);
                        this.strTxt = eletxt.getFirstChild().getNodeValue();
                    }
                    if (this.generateCBB) {
                        NodeList nlscbb = ele.getElementsByTagName("png");
                        Element elecbb = (Element) nlscbb.item(0);
                        this.strCBB = elecbb.getFirstChild().getNodeValue();
                    }
                }
            }
        } catch (Exception e) {
            this.error = true;
            wsresponse = e.getMessage().toString();
        }
        return wsresponse;
    }

    public String cancelar(String UUID) {
        String wsresponse = "Cancelado Exitoso";
        SOAPMessage soapResp;
        // Inicia la petición SOAP
        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            // Enviar mensaje al servidor
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.addNamespaceDeclaration("xmlns", this.urlSOAP);
            SOAPBody soapBody = envelope.getBody();
            SOAPElement soapBodyElem = soapBody.addChildElement("requestCancelarCFDI", "");
            SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("request");
            SOAPElement soapBodyElem4 = soapBodyElem1.addChildElement("UserID");
            soapBodyElem4.addTextNode(this.userId);
            SOAPElement soapBodyElem5 = soapBodyElem1.addChildElement("UserPass");
            soapBodyElem5.addTextNode(this.userPassword);
            SOAPElement soapBodyElem6 = soapBodyElem1.addChildElement("emisorRFC");
            soapBodyElem6.addTextNode(this.rfcEmisor);
            SOAPElement soapBodyElem7 = soapBodyElem1.addChildElement("uuid");
            soapBodyElem7.addTextNode(UUID);
            MimeHeaders headers = soapMessage.getMimeHeaders();
            headers.addHeader("SOAPAction", "requestTimbrarCFDI");
            soapMessage.saveChanges();

            soapResp = soapConnection.call(soapMessage, this.urlSOAP);

            this.soapResponse = this.soapMessageToString(soapResp);
            soapConnection.close();

            String cadenaXML = this.soapResponse;

            DOMParser parser = new DOMParser();
            parser.parse(new InputSource(new java.io.StringReader(cadenaXML)));

            Document doc = parser.getDocument();

            if (doc.getElementsByTagName("SOAP-ENV:Fault").getLength() > 0) {
                NodeList nodeLst = doc.getElementsByTagName("SOAP-ENV:Body");
                for (int i = 0; i < nodeLst.getLength(); i++) {
                    Element ele = (Element) nodeLst.item(i);

                    NodeList nlsCode = ele.getElementsByTagName("faultcode");
                    Element eleCode = (Element) nlsCode.item(0);
                    String strCode = eleCode.getFirstChild().getNodeValue();

                    NodeList nlsMessage = ele.getElementsByTagName("faultstring");
                    Element eleMsg = (Element) nlsMessage.item(0);
                    String strMessage = eleMsg.getFirstChild().getNodeValue();

                    wsresponse = "Error: " + strCode + "\n";
                    wsresponse = wsresponse + "Mensaje: " + strMessage;

                }
            } else {
                NodeList nodeLst = doc.getElementsByTagName("ns1:requestCancelarCFDIResponse");
                for (int i = 0; i < nodeLst.getLength(); i++) {
                    Element ele = (Element) nodeLst.item(i);

                    NodeList nlsCode = ele.getElementsByTagName("Code");
                    Element eleCode = (Element) nlsCode.item(0);
                    String strCode = eleCode.getFirstChild().getNodeValue();

                    NodeList nlsMessage = ele.getElementsByTagName("Message");
                    Element eleMsg = (Element) nlsMessage.item(0);
                    String strMessage = eleMsg.getFirstChild().getNodeValue();

                    wsresponse = "Exito: " + strCode + "\n";
                    wsresponse = wsresponse + "Mensaje: " + strMessage;
                }
            }
        } catch (SOAPException e) {
            this.error = true;
            wsresponse = e.getMessage().toString();
        } catch (UnsupportedOperationException e) {
            this.error = true;
            wsresponse = e.getMessage().toString();
        } catch (SAXException e) {
            this.error = true;
            wsresponse = e.getMessage().toString();
        } catch (IOException e) {
            this.error = true;
            wsresponse = e.getMessage().toString();
        } catch (DOMException e) {
            this.error = true;
            wsresponse = e.getMessage().toString();
        }
        return wsresponse;
    }

    public String soapMessageToString(SOAPMessage message) {
        String result = null;
        if (message != null) {
            ByteArrayOutputStream baos = null;
            try {
                baos = new ByteArrayOutputStream();
                message.writeTo(baos);
                result = baos.toString();
            } catch (SOAPException e) {
            } catch (IOException e) {
            } finally {
                if (baos != null) {
                    try {
                        baos.close();
                    } catch (IOException ioe) {
                    }
                }
            }
        }
        return result;
    }

    public String getUrlSOAP() {
        return urlSOAP;
    }

    public void setUrlSOAP(String urlSOAP) {
        this.urlSOAP = urlSOAP;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getRfcEmisor() {
        return rfcEmisor;
    }

    public void setRfcEmisor(String rfcEmisor) {
        this.rfcEmisor = rfcEmisor;
    }

    public String getSoapResponse() {
        return soapResponse;
    }

    public void setSoapResponse(String soapResponse) {
        this.soapResponse = soapResponse;
    }

    public boolean isGeneratePDF() {
        return generatePDF;
    }

    public void setGeneratePDF(boolean generatePDF) {
        this.generatePDF = generatePDF;
    }

    public boolean isGenerateTXT() {
        return generateTXT;
    }

    public void setGenerateTXT(boolean generateTXT) {
        this.generateTXT = generateTXT;
    }

    public boolean isGenerateCBB() {
        return generateCBB;
    }

    public void setGenerateCBB(boolean generateCBB) {
        this.generateCBB = generateCBB;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getStrPDF() {
        return strPDF;
    }

    public void setStrPDF(String strPDF) {
        this.strPDF = strPDF;
    }

    public String getStrXml() {
        return strXml;
    }

    public void setStrXml(String strXml) {
        this.strXml = strXml;
    }

    public String getStrCBB() {
        return strCBB;
    }

    public void setStrCBB(String strCBB) {
        this.strCBB = strCBB;
    }

    public String getStrTxt() {
        return strTxt;
    }

    public void setStrTxt(String strTxt) {
        this.strTxt = strTxt;
    }

}
