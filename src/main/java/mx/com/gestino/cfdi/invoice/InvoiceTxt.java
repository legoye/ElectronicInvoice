/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.gestino.cfdi.invoice;

import java.util.List;

public class InvoiceTxt {
    
    private String serie;
    private String fecha;
    private String folio;
    private String tipoDeComprobante;
    private String formaDePago;
    private String metodoDePago;
    private String condicionesDePago;
    private String numCtaPago;
    private String subTotal;
    private String descuento;
    private String total;
    private String moneda;
    private String tipoCambio;
    private String noCertificado;
    private String lugarExpedicion;
    
    //Datos Adicionales
    private String tipoDocumento;
    private String numeroPedido;
    private String observaciones;
    private String transID;
    
    //Emisor
    private String rfc;
    private String nombre;
    private String regimenFiscal;
    
    //Domicilio fiscal
    private String calle;
    private String noExterior;
    private String noInterior;
    private String colonia;
    private String localidad;
    private String municipio;
    private String estado;
    private String pais;
    private String codigoPostal;
    
    //ExpedidoEn
    private String calleExpedidoEn;
    private String noExteriorExpedidoEn;
    private String noInteriorExpedidoEn;
    private String coloniaExpedidoEn;
    private String localidadExpedidoEn;
    private String municipioExpedidoEn;
    private String estadoExpedidoEn;
    private String paisExpedidoEn;
    private String codigoPostalExpedidoEn;
    
    //Receptor
    private String rfcReceptor;
    private String nameReceptor;
    private String calleReceptor;
    private String noExteriorReceptor;
    private String noInteriorReceptor;
    private String coloniaReceptor;
    private String localidadReceptor;
    private String municipioReceptor;
    private String estadoReceptor;
    private String paisReceptor;
    private String codigoPostalReceptor;
    
    private String noCliente;
    private String email;
    
    private List<Items> listConceptos;
    
    private String impuestos;
    private String importe;
    private String tasa;

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getTipoDeComprobante() {
        return tipoDeComprobante;
    }

    public void setTipoDeComprobante(String tipoDeComprobante) {
        this.tipoDeComprobante = tipoDeComprobante;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    public String getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(String metodoDePago) {
        this.metodoDePago = metodoDePago;
    }

    public String getCondicionesDePago() {
        return condicionesDePago;
    }

    public void setCondicionesDePago(String condicionesDePago) {
        this.condicionesDePago = condicionesDePago;
    }

    public String getNumCtaPago() {
        return numCtaPago;
    }

    public void setNumCtaPago(String numCtaPago) {
        this.numCtaPago = numCtaPago;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getNoCertificado() {
        return noCertificado;
    }

    public void setNoCertificado(String noCertificado) {
        this.noCertificado = noCertificado;
    }

    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    public void setLugarExpedicion(String lugarExpedicion) {
        this.lugarExpedicion = lugarExpedicion;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTransID() {
        return transID;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRegimenFiscal() {
        return regimenFiscal;
    }

    public void setRegimenFiscal(String regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNoExterior() {
        return noExterior;
    }

    public void setNoExterior(String noExterior) {
        this.noExterior = noExterior;
    }

    public String getNoInterior() {
        return noInterior;
    }

    public void setNoInterior(String noInterior) {
        this.noInterior = noInterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCalleExpedidoEn() {
        return calleExpedidoEn;
    }

    public void setCalleExpedidoEn(String calleExpedidoEn) {
        this.calleExpedidoEn = calleExpedidoEn;
    }

    public String getNoExteriorExpedidoEn() {
        return noExteriorExpedidoEn;
    }

    public void setNoExteriorExpedidoEn(String noExteriorExpedidoEn) {
        this.noExteriorExpedidoEn = noExteriorExpedidoEn;
    }

    public String getNoInteriorExpedidoEn() {
        return noInteriorExpedidoEn;
    }

    public void setNoInteriorExpedidoEn(String noInteriorExpedidoEn) {
        this.noInteriorExpedidoEn = noInteriorExpedidoEn;
    }

    public String getColoniaExpedidoEn() {
        return coloniaExpedidoEn;
    }

    public void setColoniaExpedidoEn(String coloniaExpedidoEn) {
        this.coloniaExpedidoEn = coloniaExpedidoEn;
    }

    public String getLocalidadExpedidoEn() {
        return localidadExpedidoEn;
    }

    public void setLocalidadExpedidoEn(String localidadExpedidoEn) {
        this.localidadExpedidoEn = localidadExpedidoEn;
    }

    public String getMunicipioExpedidoEn() {
        return municipioExpedidoEn;
    }

    public void setMunicipioExpedidoEn(String municipioExpedidoEn) {
        this.municipioExpedidoEn = municipioExpedidoEn;
    }

    public String getEstadoExpedidoEn() {
        return estadoExpedidoEn;
    }

    public void setEstadoExpedidoEn(String estadoExpedidoEn) {
        this.estadoExpedidoEn = estadoExpedidoEn;
    }

    public String getPaisExpedidoEn() {
        return paisExpedidoEn;
    }

    public void setPaisExpedidoEn(String paisExpedidoEn) {
        this.paisExpedidoEn = paisExpedidoEn;
    }

    public String getCodigoPostalExpedidoEn() {
        return codigoPostalExpedidoEn;
    }

    public void setCodigoPostalExpedidoEn(String codigoPostalExpedidoEn) {
        this.codigoPostalExpedidoEn = codigoPostalExpedidoEn;
    }
    
    public String getRfcReceptor() {
        return rfcReceptor;
    }

    public void setRfcReceptor(String rfcReceptor) {
        this.rfcReceptor = rfcReceptor;
    }

    public String getNameReceptor() {
        return nameReceptor;
    }

    public void setNameReceptor(String nameReceptor) {
        this.nameReceptor = nameReceptor;
    }

    public String getCalleReceptor() {
        return calleReceptor;
    }

    public void setCalleReceptor(String calleReceptor) {
        this.calleReceptor = calleReceptor;
    }

    public String getNoExteriorReceptor() {
        return noExteriorReceptor;
    }

    public void setNoExteriorReceptor(String noExteriorReceptor) {
        this.noExteriorReceptor = noExteriorReceptor;
    }

    public String getNoInteriorReceptor() {
        return noInteriorReceptor;
    }

    public void setNoInteriorReceptor(String noInteriorReceptor) {
        this.noInteriorReceptor = noInteriorReceptor;
    }

    public String getColoniaReceptor() {
        return coloniaReceptor;
    }

    public void setColoniaReceptor(String coloniaReceptor) {
        this.coloniaReceptor = coloniaReceptor;
    }

    public String getLocalidadReceptor() {
        return localidadReceptor;
    }

    public void setLocalidadReceptor(String localidadReceptor) {
        this.localidadReceptor = localidadReceptor;
    }

    public String getMunicipioReceptor() {
        return municipioReceptor;
    }

    public void setMunicipioReceptor(String municipioReceptor) {
        this.municipioReceptor = municipioReceptor;
    }

    public String getEstadoReceptor() {
        return estadoReceptor;
    }

    public void setEstadoReceptor(String estadoReceptor) {
        this.estadoReceptor = estadoReceptor;
    }

    public String getPaisReceptor() {
        return paisReceptor;
    }

    public void setPaisReceptor(String paisReceptor) {
        this.paisReceptor = paisReceptor;
    }

    public String getCodigoPostalReceptor() {
        return codigoPostalReceptor;
    }

    public void setCodigoPostalReceptor(String codigoPostalReceptor) {
        this.codigoPostalReceptor = codigoPostalReceptor;
    }

    public String getNoCliente() {
        return noCliente;
    }

    public void setNoCliente(String noCliente) {
        this.noCliente = noCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Items> getListConceptos() {
        return listConceptos;
    }

    public void setListConceptos(List<Items> listConceptos) {
        this.listConceptos = listConceptos;
    }

    public String getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(String impuestos) {
        this.impuestos = impuestos;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getTasa() {
        return tasa;
    }

    public void setTasa(String tasa) {
        this.tasa = tasa;
    }
   
    
    
}
