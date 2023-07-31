package webshop;

public class ProductDto {

    private long productNumber;
    private String description;
    private double price;
    private int noInStock;
    private String locationCode;

    public ProductDto() {
    }

    public ProductDto(long productNumber, String description, double price, int noInStock, String locationCode) {
        this.productNumber = productNumber;
        this.description = description;
        this.price = price;
        this.noInStock = noInStock;
        this.locationCode = locationCode;
    }

    public long getProductNumber() {
        return productNumber;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getNoInStock() {
        return noInStock;
    }

    public String getLocationCode() {
        return locationCode;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productNumber=" + productNumber +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", noInStock=" + noInStock +
                ", locationCode='" + locationCode + '\'' +
                '}';
    }
}
