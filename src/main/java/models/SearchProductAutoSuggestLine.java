package models;

public class SearchProductAutoSuggestLine {
    private String imgLink;
    private String productName;
    private String oldPrice;
    private String price;

    public SearchProductAutoSuggestLine(String imgLink,
                                        String productName,
                                        String oldPrice,
                                        String price) {
        this.imgLink = imgLink;
        this.productName = productName;
        this.oldPrice = oldPrice;
        this.price = price;
    }

    public SearchProductAutoSuggestLine(){
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
