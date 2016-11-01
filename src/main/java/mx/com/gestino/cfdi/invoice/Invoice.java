/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.gestino.cfdi.invoice;

import java.util.List;

/**
 *
 * @author developer
 */
public class Invoice {
    
    private String name;
    private String curp;
    private String address;
    private String postalCode;
    private String city;
    private String phone;
    
    private String folioFiscal;
    private String CSDSAT;
    private String CSDEmisor;
    private String dateCertification;
    private String dateEmision;
    
    private String urlLogo;
    private String urlQR;
    
    private String methodPayment;
    private String typeProof;
    private String currency;
    private String documentNumber;
    private String expeditionPlace;
    private String taxRegime;
    
    private String customer;
    private String street;
    private String colony;
    private String locality;
    private String municipality;
    private String state;
    private String country;
    private String email;
    private String rfc;
    
    private List<Items> items;
    
    private String subtotal;
    private String VAT;
    private String tasa;
    private String total;
    private String totalLetter;
    
    private String digitalStampCFDI;
    private String digitalStampSAT;
    private String complementSAT;
    private String paymentCondition;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFolioFiscal() {
        return folioFiscal;
    }

    public void setFolioFiscal(String folioFiscal) {
        this.folioFiscal = folioFiscal;
    }

    public String getCSDSAT() {
        return CSDSAT;
    }

    public void setCSDSAT(String CSDSAT) {
        this.CSDSAT = CSDSAT;
    }

    public String getCSDEmisor() {
        return CSDEmisor;
    }

    public void setCSDEmisor(String CSDEmisor) {
        this.CSDEmisor = CSDEmisor;
    }

    public String getDateCertification() {
        return dateCertification;
    }

    public void setDateCertification(String dateCertification) {
        this.dateCertification = dateCertification;
    }

    public String getDateEmision() {
        return dateEmision;
    }

    public void setDateEmision(String dateEmision) {
        this.dateEmision = dateEmision;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        this.urlLogo = urlLogo;
    }

    public String getUrlQR() {
        return urlQR;
    }

    public void setUrlQR(String urlQR) {
        this.urlQR = urlQR;
    }

    public String getMethodPayment() {
        return methodPayment;
    }

    public void setMethodPayment(String methodPayment) {
        this.methodPayment = methodPayment;
    }

    public String getTypeProof() {
        return typeProof;
    }

    public void setTypeProof(String typeProof) {
        this.typeProof = typeProof;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getExpeditionPlace() {
        return expeditionPlace;
    }

    public void setExpeditionPlace(String expeditionPlace) {
        this.expeditionPlace = expeditionPlace;
    }

    public String getTaxRegime() {
        return taxRegime;
    }

    public void setTaxRegime(String taxRegime) {
        this.taxRegime = taxRegime;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getColony() {
        return colony;
    }

    public void setColony(String colony) {
        this.colony = colony;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getVAT() {
        return VAT;
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotalLetter() {
        return totalLetter;
    }

    public void setTotalLetter(String totalLetter) {
        this.totalLetter = totalLetter;
    }

    public String getDigitalStampCFDI() {
        return digitalStampCFDI;
    }

    public void setDigitalStampCFDI(String digitalStampCFDI) {
        this.digitalStampCFDI = digitalStampCFDI;
    }

    public String getDigitalStampSAT() {
        return digitalStampSAT;
    }

    public void setDigitalStampSAT(String digitalStampSAT) {
        this.digitalStampSAT = digitalStampSAT;
    }

    public String getComplementSAT() {
        return complementSAT;
    }

    public void setComplementSAT(String complementSAT) {
        this.complementSAT = complementSAT;
    }

    public String getTasa() {
        return tasa;
    }

    public void setTasa(String tasa) {
        this.tasa = tasa;
    }

    public String getPaymentCondition() {
        return paymentCondition;
    }

    public void setPaymentCondition(String paymentCondition) {
        this.paymentCondition = paymentCondition;
    }

    
    
    
}
