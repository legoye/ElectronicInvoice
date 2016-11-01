package mx.com.gestino.cfdi.invoice;

/**
 * @author developer
 */
public class SalesInvoiceC {

    private Integer idSalesInvoiceC;
    private String electronic;
    private String number;
    private String status;
    private String idCustomer;
    private String idUser;
    private String salesOrder;
    private String idSalesOrder;
    private String idWarehouse;
    private String idCurrency;
    private String exchangeType;
    private String type;
    private String limitCredit;
    private String documentDate;
    private String expirationDate;
    private String accountingDate;
    private Double amount;
    private Double disccountPerLines;
    private Double disccountDocument;
    private Double subtotal;
    private Double tax;
    private Double retention;
    private Double total;
    private String comments;
    private String creationDate;
    private String modificationDate;
    private Double balance;
    private String paymentDate;
    private String idAccountPolicy;
    private String numberInvoice;
    private String authorizedUser;
    private String idSalesAgent;
    private String aux1;
    private String aux2;
    private String aux3;
    private String aux4;

    public SalesInvoiceC(Integer idSalesInvoiceCC, String electronic, 
            String number, String status, String idCustomer, String idUser, 
            String salesOrder, String idSalesOrder, String idCurrency, 
            String exchangeType, String type, String limitCredit, 
            String documentDate, String expirationDate, String accountingDate, 
            Double amount, Double disccountPerLines, Double disccountDocument, 
            Double subtotal, Double tax, Double retention, Double total, 
            String comments, String creationDate, String modificationDate, 
            Double balance, String paymentDate, String idAccountPolicy, 
            String numberInvoice, String authorizedUser, String idSalesAgent) {
        this.idSalesInvoiceC = idSalesInvoiceCC;
        this.electronic = electronic;
        this.number = number;
        this.status = status;
        this.idCustomer = idCustomer;
        this.idUser = idUser;
        this.salesOrder = salesOrder;
        this.idSalesOrder = idSalesOrder;
        this.idCurrency = idCurrency;
        this.exchangeType = exchangeType;
        this.type = type;
        this.limitCredit = limitCredit;
        this.documentDate = documentDate;
        this.expirationDate = expirationDate;
        this.accountingDate = accountingDate;
        this.amount = amount;
        this.disccountPerLines = disccountPerLines;
        this.disccountDocument = disccountDocument;
        this.subtotal = subtotal;
        this.tax = tax;
        this.retention = retention;
        this.total = total;
        this.comments = comments;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.balance = balance;
        this.paymentDate = paymentDate;
        this.idAccountPolicy = idAccountPolicy;
        this.numberInvoice = numberInvoice;
        this.authorizedUser = authorizedUser;
        this.idSalesAgent = idSalesAgent;
    }

    public SalesInvoiceC() {
    }

    public Integer getIdSalesInvoiceC() {
        return idSalesInvoiceC;
    }

    public void setIdSalesInvoiceC(Integer idSalesInvoiceCC) {
        this.idSalesInvoiceC = idSalesInvoiceCC;
    }

    public String getElectronic() {
        return electronic;
    }

    public void setElectronic(String electronic) {
        this.electronic = electronic;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(String salesOrder) {
        this.salesOrder = salesOrder;
    }

    public String getIdSalesOrder() {
        return idSalesOrder;
    }

    public void setIdSalesOrder(String idSalesOrder) {
        this.idSalesOrder = idSalesOrder;
    }

    public String getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(String idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public String getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(String idCurrency) {
        this.idCurrency = idCurrency;
    }

    public String getExchangeType() {
        return exchangeType;
    }

    public void setExchangeType(String exchangeType) {
        this.exchangeType = exchangeType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLimitCredit() {
        return limitCredit;
    }

    public void setLimitCredit(String limitCredit) {
        this.limitCredit = limitCredit;
    }

    public String getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(String expirationDate) {
        this.documentDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(String accountingDate) {
        this.accountingDate = accountingDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getDisccountPerLines() {
        return disccountPerLines;
    }

    public void setDisccountPerLines(Double disccountPerLines) {
        this.disccountPerLines = disccountPerLines;
    }

    public Double getDisccountDocument() {
        return disccountDocument;
    }

    public void setDisccountDocument(Double disccountDocument) {
        this.disccountDocument = disccountDocument;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getRetention() {
        return retention;
    }

    public void setRetention(Double retention) {
        this.retention = retention;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getIdAccountPolicy() {
        return idAccountPolicy;
    }

    public void setIdAccountPolicy(String idAccountPolicy) {
        this.idAccountPolicy = idAccountPolicy;
    }

    public String getNumberInvoice() {
        return numberInvoice;
    }

    public void setNumberInvoice(String numberInvoice) {
        this.numberInvoice = numberInvoice;
    }

    public String getAuthorizedUser() {
        return authorizedUser;
    }

    public void setAuthorizedUser(String authorizedUser) {
        this.authorizedUser = authorizedUser;
    }

    public String getIdSalesAgent() {
        return idSalesAgent;
    }

    public void setIdSalesAgent(String idSalesAgent) {
        this.idSalesAgent = idSalesAgent;
    }

    public String getAux1() {
        return aux1;
    }

    public void setAux1(String aux1) {
        this.aux1 = aux1;
    }

    public String getAux2() {
        return aux2;
    }

    public void setAux2(String aux2) {
        this.aux2 = aux2;
    }

    public String getAux3() {
        return aux3;
    }

    public void setAux3(String aux3) {
        this.aux3 = aux3;
    }

    public String getAux4() {
        return aux4;
    }

    public void setAux4(String aux4) {
        this.aux4 = aux4;
    }

}
