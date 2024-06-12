import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepo {
    private List<Product> products;

    public ProductRepo() {
        products = new ArrayList<>();
        products.add(new Product("1", "Apfel"));
    }

    public List<Product> getProducts() {
        return products;
    }

    public Optional<Product> getProductById(String id) {
/*
Modify the 'getProductById' method in your ProductRepo so that it returns an Optional<Product> if the product exists, otherwise an empty Optional.
 */
        for(Product product: products){
            if (product.id().equals(id)){
                return Optional.of(product);
            }
        }
        return Optional.ofNullable(null);
    }

    public Product addProduct(Product newProduct) {

        products.add(newProduct);
        return newProduct;
    }

    public void removeProduct(String id) {
        for (Product product : products) {
           if (product.id().equals(id)) {
               products.remove(product);
               return;
           }
        }
    }
}
