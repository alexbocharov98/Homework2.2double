package org.skypro.skyshop;


import org.skypro.skyshop.ProductBasket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String args[]) {
        Product product = new Product("Хлеб", 100);
        Product product1 = new Product("Молоко", 150);
        Product product2 = new Product("Масло", 300);
        Product product3 = new Product("Апельсин", 245);
        Product product4 = new Product("Банан", 342);
        Product product5 = new Product("Творог", 543);
        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(product);
        productBasket.addProduct(product1);
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);
        productBasket.addProduct(product5);
        productBasket.printing();
        System.out.println(productBasket.hasProduct("Хлеб"));
        System.out.println(productBasket.hasProduct("Пицца"));
        productBasket.cleanBasket();
        productBasket.printing();
        System.out.println(productBasket.summ());
        System.out.println(productBasket.hasProduct("Хлеб"));

    }
}