/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gestino.helper;

import mx.com.gestino.cfdi.invoice.InvoiceTxt;
import mx.com.gestino.cfdi.invoice.Items;

public class TemplateInvoiceTxt {

    public String getStringLayout(InvoiceTxt invoiceTxt) {
        String layout = "";

        layout = "[Encabezado] \n\n";
        layout += "serie|" + invoiceTxt.getSerie() + "\n";
        layout += "fecha|" + invoiceTxt.getFecha() + "\n";
        layout += "folio|" + invoiceTxt.getFolio() + "\n";
        layout += "tipoDeComprobante|" + invoiceTxt.getTipoDeComprobante() + "\n";
        layout += "formaDePago|" + invoiceTxt.getFormaDePago() + "\n";
        layout += "metodoDePago|" + invoiceTxt.getMetodoDePago() + "\n";
        layout += "condicionesDePago|" + invoiceTxt.getCondicionesDePago() + "\n";
        layout += "NumCtaPago|" + invoiceTxt.getNumCtaPago() + "\n";
        layout += "subTotal|" + invoiceTxt.getSubTotal() + "\n";
        layout += "descuento|" + invoiceTxt.getDescuento() + "\n";
        layout += "total|" + invoiceTxt.getTotal() + "\n";
        layout += "Moneda|" + invoiceTxt.getMoneda() + "\n";
        layout += "TipoCambio|" + invoiceTxt.getTipoCambio() + "\n";
        layout += "noCertificado|" + invoiceTxt.getNoCertificado() + "\n";
        layout += "LugarExpedicion|" + invoiceTxt.getLugarExpedicion() + "\n\n";

        layout += "[Datos Adicionales]\n\n";

        layout += "tipoDocumento|" + invoiceTxt.getTipoDocumento() + "\n";
        layout += "numeropedido|" + invoiceTxt.getNumeroPedido() + "\n";
        layout += "observaciones|" + invoiceTxt.getObservaciones() + "\n";
        layout += "TransID|" + invoiceTxt.getTransID() + "\n";

        layout += "[Emisor]\n\n";

        layout += "rfc|" + invoiceTxt.getRfc() + "\n";
        layout += "nombre|" + invoiceTxt.getNombre() + "\n";
        layout += "RegimenFiscal|" + invoiceTxt.getRegimenFiscal() + "\n\n";

        layout += "[DomicilioFiscal]\n\n";

        layout += "calle|" + invoiceTxt.getCalle() + "\n";
        layout += "noExterior" + invoiceTxt.getNoExterior() + "\n";
        layout += "noInterior|" + invoiceTxt.getNoInterior() + "\n";
        layout += "colonia|" + invoiceTxt.getColonia() + "\n";
        layout += "localidad|" + invoiceTxt.getLocalidad() + "\n";
        layout += "municipio|" + invoiceTxt.getMunicipio() + "\n";
        layout += "estado|" + invoiceTxt.getEstado() + "\n";
        layout += "pais|" + invoiceTxt.getPais() + "\n";
        layout += "codigoPostal|" + invoiceTxt.getCodigoPostal() + "\n\n";

        layout += "[ExpedidoEn]\n";
        layout += "calle|" + invoiceTxt.getCalleExpedidoEn() + "\n";
        layout += "noExterior|" + invoiceTxt.getNoExteriorExpedidoEn() + "\n";
        layout += "noInterior|" + invoiceTxt.getNoInteriorExpedidoEn() + "\n";
        layout += "colonia|" + invoiceTxt.getColoniaExpedidoEn() + "\n";
        layout += "localidad|" + invoiceTxt.getLocalidadExpedidoEn() + "\n";
        layout += "municipio|" + invoiceTxt.getMunicipioExpedidoEn() + "\n";
        layout += "estado|" + invoiceTxt.getEstadoExpedidoEn() + "\n";
        layout += "pais|" + invoiceTxt.getPaisExpedidoEn() + "\n";
        layout += "codigoPostal|" + invoiceTxt.getCodigoPostalExpedidoEn() + "\n\n";

        layout += "[Receptor]\n";
        layout += "rfc|" + invoiceTxt.getRfc() + "\n";
        layout += "nombre|" + invoiceTxt.getNameReceptor() + "\n\n";
        layout += "[Domicilio]\n";
        layout += "calle|" + invoiceTxt.getCalleReceptor() + "\n";
        layout += "noExterior|" + invoiceTxt.getNoExterior() + "\n";
        layout += "noInterior|" + invoiceTxt.getNoInterior() + "\n";
        layout += "colonia|" + invoiceTxt.getColoniaReceptor()+ "\n";
        layout += "localidad|" + invoiceTxt.getLocalidadReceptor()+ "\n";
        layout += "municipio|" + invoiceTxt.getMunicipioReceptor() + "\n";
        layout += "estado|" + invoiceTxt.getEstadoReceptor() + "\n";
        layout += "pais|" + invoiceTxt.getPaisReceptor() + "\n";
        layout += "codigoPostal|" + invoiceTxt.getCodigoPostalReceptor() + "\n\n";

        layout += "[DatosAdicionales]\n\n";
        layout += "noCliente|" + invoiceTxt.getNoCliente() + "\n";
        layout += "email|" + invoiceTxt.getEmail() + "\n\n\n";

        for (Items items : invoiceTxt.getListConceptos()) {
            layout += "[Concepto]\n\n";
            layout += "cantidad|" + items.getQuantity() + "\n";
            layout += "unidad|" + items.getUnit() + "\n";
            layout += "noIdentificacion|" + items.getNoIdetificacion() + "\n";
            layout += "descripcion|" + items.getDescription() + "\n";
            layout += "valorUnitario|" + items.getPrice() + "\n";
            layout += "importe|" + items.getAmount() + "\n";
        }
        layout += "\n\n[ImpuestoTrasladado]\n\n";
        layout += "impuesto|" + invoiceTxt.getImpuestos() + "\n";
        layout += "importe|" + invoiceTxt.getImporte() + "\n";
        layout += "tasa|" + invoiceTxt.getTasa() + "\n";

        return layout;
    }

}
