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
        ShoppingCart cart = new ShoppingCart(123);
        Product movie1 = new Product("Movie A", 19.99);
        Product movie2 = new Product("Movie B", 24.99);

        cart.addProduct(movie1);
        cart.addProduct(movie2);

        System.out.println("Customer ID: " + cart.getCustomerId());
        System.out.println("Total Items: " + cart.getItemCount());
        System.out.println("Total Price: $" + cart.getTotalPrice());
    }
}
