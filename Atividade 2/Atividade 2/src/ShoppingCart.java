import java.util.ArrayList;

public class ShoppingCart {
    private int customerId;
    private ArrayList<Product> productList;

    public ShoppingCart(int customerId) {
        this.customerId = customerId;
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public int getCustomerId() {
        return customerId;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Product product : productList) {
            total += product.getPrice();
        }
        return total;
    }

    public int getItemCount() {
        return productList.size();
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(2);
        TV television = new TV("Samsung", 1100.99, 32);
        Refrigerator geladeira = new Refrigerator("Brastemp", 2400.99, 2);
        Stove fogao = new Stove("Brastemp", 500.93, 6);

        cart.addProduct(television);
        cart.addProduct(geladeira);
        cart.addProduct(fogao);

        System.out.println("Customer ID: " + cart.getCustomerId());
        System.out.println("Total Items: " + cart.getItemCount());
        System.out.printf("Total Price: $ %.2f %n", cart.getTotalPrice());
    }
}