/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gestino.cfdi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import mx.com.gestino.cfdi.invoice.InvoiceTxt;
import mx.com.gestino.cfdi.invoice.Items;
import mx.com.gestino.cfdi.pdf.CreatePDF;
import mx.com.gestino.helper.TemplateInvoiceTxt;

/**
 * @author developer
 */
public class Timbrado {

    public Timbrado() {
    }

    public static void main(String[] args) throws IOException {

        WebCfdiConnection connect = new WebCfdiConnection();
        String path = System.getProperty("user.dir");
        connect.setRfcEmisor("TUMG620310R95");
        
        //Bean Txt
        InvoiceTxt invoiceTxt = new InvoiceTxt();
        invoiceTxt.setSerie("AA");
        invoiceTxt.setFecha("asignarFecha");
        invoiceTxt.setFolio("asignarFolio");
        invoiceTxt.setTipoDeComprobante("ingreso");
        invoiceTxt.setFormaDePago("PAGO EN UNA SOLA EXHIBICIÓN");
        invoiceTxt.setMetodoDePago("Transferencía Electrónica");
        invoiceTxt.setCondicionesDePago("Contado");
        invoiceTxt.setNumCtaPago("No identificado");
        invoiceTxt.setSubTotal("1489.00");
        invoiceTxt.setDescuento("0.00");
        invoiceTxt.setTotal("1342.00");
        invoiceTxt.setMoneda("MXN");
        invoiceTxt.setTipoCambio("");
        invoiceTxt.setNoCertificado("20001000000200000278");
        invoiceTxt.setLugarExpedicion("Nuevo León, México.");
        invoiceTxt.setNumeroPedido("");
        invoiceTxt.setTipoDocumento("Factura");
        invoiceTxt.setObservaciones("Comprobante para fines demostrativos");
        invoiceTxt.setTransID("");
        
        invoiceTxt.setRfc("TUMG620310R95");
        invoiceTxt.setNombre("FACTURACION MODERNA S.A de C.V.");
        invoiceTxt.setRegimenFiscal("REGIMEN GENERAL DE LEY PERSONAS MORALES");
        invoiceTxt.setCalle("RIO GUADALQUIVIR");
        invoiceTxt.setNoExterior("308");
        invoiceTxt.setNoInterior("");
        invoiceTxt.setColonia("Oriente del valle");
        invoiceTxt.setLocalidad("");
        invoiceTxt.setMunicipio("San Pedro");
        invoiceTxt.setEstado("Nueo Leon");
        invoiceTxt.setPais("México");
        invoiceTxt.setCodigoPostal("66220");
        
        invoiceTxt.setCalleExpedidoEn("Cerrada de azucenas");
        invoiceTxt.setNoExteriorExpedidoEn("109");
        invoiceTxt.setNoInteriorExpedidoEn("");
        invoiceTxt.setColoniaExpedidoEn("Reforma");
        invoiceTxt.setLocalidadExpedidoEn("");
        invoiceTxt.setMunicipioExpedidoEn("Oaxaca de juarez");
        invoiceTxt.setEstadoExpedidoEn("OAXACA");
        invoiceTxt.setPaisExpedidoEn("Mexico");
        
        invoiceTxt.setRfcReceptor("XAXX010101000");
        invoiceTxt.setNameReceptor("PUBLICO GENERAL");
        
        invoiceTxt.setCalleReceptor("Av. Batallon de San Patricio");
        invoiceTxt.setNoExteriorReceptor("1000");
        invoiceTxt.setNoInteriorReceptor("1000");
        invoiceTxt.setColoniaReceptor("Residencial San Agustin");
        invoiceTxt.setLocalidadReceptor("");
        invoiceTxt.setMunicipioReceptor("San PEdro");
        invoiceTxt.setEstadoReceptor("Nuevo león");
        invoiceTxt.setPaisReceptor("México");
        invoiceTxt.setCodigoPostalReceptor("66260");
        
        invoiceTxt.setNoCliente("");
        invoiceTxt.setEmail("Email@email.com");
        
        Items items = new Items();
        List<Items> listItems = new ArrayList<Items>();
        items.setQuantity("3");
        items.setUnit("PIEZA");
        items.setNoIdetificacion("");
        items.setDescription("CAJA DE HOJAS BLANCAS TAMAÑO CARTA");
        items.setPrice("450.00");
        items.setAmount("1350.00");
        
        listItems.add(items);
        invoiceTxt.setListConceptos(listItems);
        
        invoiceTxt.setImporte("238.00");
        invoiceTxt.setImpuestos("IVA");
        invoiceTxt.setTasa("16.00");
        //bean Txt
        TemplateInvoiceTxt template = new TemplateInvoiceTxt();
        String layout = template.getStringLayout(invoiceTxt);
        
        String r = connect.timbrar(layout);
        String urlCBB = "";
        String urlLogo = System.getProperty("user.dir") + "/logo/Electrocapital.jpg";
        if (connect.error) {
            System.out.println(r);
        } else {
            if (connect.generateCBB) {
                OutputStream out;
                try {
                    byte[] b = new sun.misc.BASE64Decoder().decodeBuffer(connect.strCBB);
                    urlCBB = path + "/ejemploCBB_CFDI.png";
                    out = new FileOutputStream(urlCBB);
                    out.write(b, 0, b.length);
                    out.close();

                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            System.out.println(r);
            String xml = new String(new sun.misc.BASE64Decoder().decodeBuffer(connect.strXml));
            try {
                String url = path + "/ejemploXmlTimbrado.xml";
                File file = new File(url);
                FileWriter write = new FileWriter(file);
                write.write(xml);
                write.close();
                CreatePDF createPdf = new CreatePDF();
                createPdf.createPDF(url, urlCBB, urlLogo);
            } catch (Exception e) {
                System.out.println(e.getMessage().toString());
            }

        }

    }

}
