/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gestino.cfdi.pdf;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mx.com.gestino.cfdi.invoice.Invoice;
import mx.com.gestino.cfdi.invoice.Items;
import mx.com.gestino.helper.ConverterNumToLetter;
import mx.com.gestino.helper.Mail;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author developer
 */
public class CreatePDF {

    public void createPDF(String fileXml, String fileCBB, String urlLogo) {

        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
        simbolo.setDecimalSeparator('.');
        simbolo.setGroupingSeparator(',');
        DecimalFormat formateador = new DecimalFormat("###,###.##", simbolo);
        String uuid = "";
        try {
            ConverterNumToLetter converter = new ConverterNumToLetter();
            File xmlFile = new File(fileXml);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuiler = dbFactory.newDocumentBuilder();
            Document doc = dBuiler.parse(xmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Element: " + doc.getDocumentElement().getNodeName());

            Invoice invoice = new Invoice();

            NodeList nList = doc.getElementsByTagName("cfdi:Comprobante");

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                System.out.println("Current Element: " + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    //Section: QR
                    invoice.setDateEmision(eElement.getAttribute("fecha"));
                    invoice.setCSDEmisor(eElement.getAttribute("noCertificado"));
                    Node node01 = doc.getElementsByTagName("tfd:TimbreFiscalDigital").item(i);
                    Element element01 = (Element) node01;
                    invoice.setCSDSAT(element01.getAttribute("noCertificadoSAT"));
                    invoice.setDateCertification(element01.getAttribute("FechaTimbrado"));
                    uuid = element01.getAttribute("UUID");
                    invoice.setFolioFiscal(uuid);
                    invoice.setUrlQR(fileCBB);
                    invoice.setUrlLogo(urlLogo);
                    invoice.setPaymentCondition(eElement.getAttribute("condicionesDePago"));
                    //Section: QR

                    //Section: customer data
                    Node node02 = doc.getElementsByTagName("cfdi:Receptor").item(i);
                    Element element02 = (Element) node02;
                    invoice.setName(element02.getAttribute("nombre"));
                    invoice.setRfc(element02.getAttribute("rfc"));
                    Node node03 = doc.getElementsByTagName("cfdi:Domicilio").item(i);
                    Element element03 = (Element) node03;
                    invoice.setAddress(element03.getAttribute("calle") + " "
                            + element03.getAttribute("noExterior") + ", Col. "
                            + element03.getAttribute("colonia") + ", "
                            + element03.getAttribute("municipio"));
                    invoice.setPostalCode(element03.getAttribute("codigoPostal"));
                    invoice.setCity(element03.getAttribute("estado") + ", " + element03.getAttribute("pais"));
                    invoice.setCurrency(eElement.getAttribute("Moneda"));
                    invoice.setTypeProof(eElement.getAttribute("tipoDeComprobante"));
                    invoice.setMethodPayment(eElement.getAttribute("formaDePago"));
                    invoice.setExpeditionPlace(eElement.getAttribute("LugarExpedicion"));
                    Node node04 = doc.getElementsByTagName("cfdi:RegimenFiscal").item(i);
                    Element element04 = (Element) node04;
                    invoice.setTaxRegime(element04.getAttribute("Regimen"));
                    invoice.setDocumentNumber(eElement.getAttribute("serie") + "-" + eElement.getAttribute("folio"));
                    //Section: customer data
                    invoice.setCustomer(element02.getAttribute("nombre"));
                    invoice.setStreet(element03.getAttribute("calle"));
                    invoice.setLocality(element03.getAttribute("colonia"));
                    invoice.setMunicipality(element03.getAttribute("municipio"));
                    invoice.setState(element03.getAttribute("estado"));
                    invoice.setCountry(element03.getAttribute("pais"));
                    //Section: customer data 02

                    ArrayList<Items> items = new ArrayList<Items>();
                    NodeList nodeList = doc.getElementsByTagName("cfdi:Concepto");
                    for (int j = 0; j < nodeList.getLength(); j++) {
                        Node node05 = nodeList.item(j);
                        Element element05 = (Element) node05;
                        Items item = new Items();
                        item.setAmount(element05.getAttribute("cantidad"));
                        item.setUnit(element05.getAttribute("unidad"));
                        item.setQuantity("$"+ formateador.format(Double.parseDouble(element05.getAttribute("importe"))));
                        item.setDescription(element05.getAttribute("descripcion"));
                        item.setPrice("$" + formateador.format(Double.parseDouble(element05.getAttribute("valorUnitario"))));
                        items.add(item);
                    }
                    invoice.setItems(items);

                    //Section: Total
                    invoice.setSubtotal("$"+ formateador.format(Double.parseDouble(eElement.getAttribute("subTotal"))));
                    String total = eElement.getAttribute("total");
                    invoice.setTotal("$"+ formateador.format(Double.parseDouble(total)));
                    invoice.setTotalLetter(converter.convertNumberToLetter(total));
                    Node node06 = doc.getElementsByTagName("cfdi:Traslado").item(i);
                    Element element06 = (Element) node06;
                    invoice.setTasa(element06.getAttribute("tasa"));
                    invoice.setVAT("$"+ formateador.format(Double.parseDouble(element06.getAttribute("importe"))));
                    //Section: Total

                    //digital stamps
                    invoice.setDigitalStampCFDI(eElement.getAttribute("sello"));
                    invoice.setComplementSAT("||" + element01.getAttribute("version")
                            + "|" + element01.getAttribute("UUID")
                            + "|" + element01.getAttribute("FechaTimbrado")
                            + "|" + eElement.getAttribute("sello")
                            + "|" + element01.getAttribute("noCertificadoSAT"));
                    invoice.setDigitalStampSAT(element01.getAttribute("selloSAT"));
                }
            }

            List<Invoice> invoiceList = new ArrayList<Invoice>();
            invoiceList.add(invoice);
            String file = GenerateReportGeneric(System.getProperty("user.dir") + "\\src\\main\\jasper\\Invoice.jrxml", null, invoiceList, uuid);

            if (!file.equals("")) {
                Mail mail = new Mail();
                xmlFile.renameTo(new File(uuid + ".xml"));
                String xml = System.getProperty("user.dir") + "/" + uuid + ".xml";
                mail.sender(file, xml);
            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public String GenerateReportGeneric(String jasperFile, HashMap m,
            List listReport, String nameFiles) {
        InputStream file = null;
        String pathPDF = "";
        try {
            JasperDesign jasperDesign = JRXmlLoader.load(jasperFile);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(listReport);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, m, data);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            JRPdfExporter exporter = new JRPdfExporter();
//            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
//            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
//            exporter.exportReport();
            baos.toByteArray();
            String path = System.getProperty("user.dir");
            JasperExportManager.exportReportToPdfFile(print, path + "/" + nameFiles + ".pdf");

            pathPDF = path + "/" + nameFiles + ".pdf";
        } catch (Exception e) {
            System.out.println(e);
        }

        return pathPDF;
    }

}
