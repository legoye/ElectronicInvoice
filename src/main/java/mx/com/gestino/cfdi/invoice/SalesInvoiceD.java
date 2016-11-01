package mx.com.gestino.cfdi.invoice;

/**
 *
 * @author developer
 */
public class SalesInvoiceD {

    private Integer idSalesInvoiceD;
    private String idSalesInvoiceC;
    private String idItem;
    private String idMeasureUnit;
    private String quantityOrdered;
    private Double quantityItem;
    private String idPriceList;
    private Double priceItem;
    private Double costItem;
    private Double disccountItem;
    private String idTax;
    private Double taxValue;
    private Double retentionItem;
    private Double totalItem;
    private String commentsItem;
    private String idMovItem;
    private String Item_Name;
    private String aux1;
    private String aux2;
    private String aux3;
    private String aux4;

    public SalesInvoiceD(Integer idSalesInvoiceD, String idSalesInvoiceC, 
            String idItem, String idMeasureUnit, String quantityOrdered, 
            Double quantityItem, String idPriceList, Double priceItem, 
            Double costItem, Double disccountItem, String idTax, 
            Double taxValue, Double retentionItem, Double totalItem, 
            String commentsItem, String idMovItem, String Item_Name, 
            String aux1, String aux2, String aux3, String aux4) {
        this.idSalesInvoiceD = idSalesInvoiceD;
        this.idSalesInvoiceC = idSalesInvoiceC;
        this.idItem = idItem;
        this.idMeasureUnit = idMeasureUnit;
        this.quantityOrdered = quantityOrdered;
        this.quantityItem = quantityItem;
        this.idPriceList = idPriceList;
        this.priceItem = priceItem;
        this.costItem = costItem;
        this.disccountItem = disccountItem;
        this.idTax = idTax;
        this.taxValue = taxValue;
        this.retentionItem = retentionItem;
        this.totalItem = totalItem;
        this.commentsItem = commentsItem;
        this.idMovItem = idMovItem;
        this.Item_Name = Item_Name;
        this.aux1 = aux1;
        this.aux2 = aux2;
        this.aux3 = aux3;
        this.aux4 = aux4;
    }

    public SalesInvoiceD() {
    }

    public Integer getIdSalesInvoiceD() {
        return idSalesInvoiceD;
    }

    public void setIdSalesInvoiceD(Integer idSalesInvoiceD) {
        this.idSalesInvoiceD = idSalesInvoiceD;
    }

    public String getIdSalesInvoiceC() {
        return idSalesInvoiceC;
    }

    public void setIdSalesInvoiceC(String idSalesInvoiceC) {
        this.idSalesInvoiceC = idSalesInvoiceC;
    }

    public String getIdItem() {
        return idItem;
    }

    public void setIdItem(String idItem) {
        this.idItem = idItem;
    }

    public String getIdMeasureUnit() {
        return idMeasureUnit;
    }

    public void setIdMeasureUnit(String idMeasureUnit) {
        this.idMeasureUnit = idMeasureUnit;
    }

    public String getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(String quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public Double getQuantityItem() {
        return quantityItem;
    }

    public void setQuantityItem(Double quantityItem) {
        this.quantityItem = quantityItem;
    }

    public String getIdPriceList() {
        return idPriceList;
    }

    public void setIdPriceList(String idPriceList) {
        this.idPriceList = idPriceList;
    }

    public Double getPriceItem() {
        return priceItem;
    }

    public void setPriceItem(Double priceItem) {
        this.priceItem = priceItem;
    }

    public Double getCostItem() {
        return costItem;
    }

    public void setCostItem(Double costItem) {
        this.costItem = costItem;
    }

    public Double getDisccountItem() {
        return disccountItem;
    }

    public void setDisccountItem(Double disccountItem) {
        this.disccountItem = disccountItem;
    }

    public String getIdTax() {
        return idTax;
    }

    public void setIdTax(String idTax) {
        this.idTax = idTax;
    }

    public Double getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(Double taxValue) {
        this.taxValue = taxValue;
    }

    public Double getRetentionItem() {
        return retentionItem;
    }

    public void setRetentionItem(Double retentionItem) {
        this.retentionItem = retentionItem;
    }

    public Double getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Double totalItem) {
        this.totalItem = totalItem;
    }

    public String getCommentsItem() {
        return commentsItem;
    }

    public void setCommentsItem(String commentsItem) {
        this.commentsItem = commentsItem;
    }

    public String getIdMovItem() {
        return idMovItem;
    }

    public void setIdMovItem(String idMovItem) {
        this.idMovItem = idMovItem;
    }

    public String getItem_Name() {
        return Item_Name;
    }

    public void setItem_Name(String Item_Name) {
        this.Item_Name = Item_Name;
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
