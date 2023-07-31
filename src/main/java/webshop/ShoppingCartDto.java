package webshop;

import java.util.List;

public class ShoppingCartDto {

    public ShoppingCartDto() {
    }

    private long shoppingCartNumber;
    private List<CartLineDto> cartLineDtos;

    public ShoppingCartDto(long shoppingCartNumber, List<CartLineDto> cartLineDtos) {
        this.shoppingCartNumber = shoppingCartNumber;
        this.cartLineDtos = cartLineDtos;
    }

    public long getShoppingCartNumber() {
        return shoppingCartNumber;
    }

    public List<CartLineDto> getCartLineDtos() {
        return cartLineDtos;
    }

    @Override
    public String toString() {
        return "ShoppingCartDto{" +
                "shoppingCartNumber=" + shoppingCartNumber +
                ", cartLineDtos=" + cartLineDtos +
                '}';
    }
}

class CartLineDto {
    private long productNumber;
    private String description;
    private double price;
    private int quantity;


    public CartLineDto() {
    }

    public CartLineDto(long productNumber, String description, double price, int quantity) {
        this.productNumber = productNumber;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "CartLineDto{" +
                "productNumber=" + productNumber +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

