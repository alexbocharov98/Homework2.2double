package org.skypro.skyshop;


import org.skypro.skyshop.ProductBasket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Product> cart = new ArrayList<>();

        DiscountedProduct discountedProduct = new DiscountedProduct("Хлеб", 500, 15);
        FixPriceProduct fixPriceProduct = new FixPriceProduct("Молоко");
        SimpleProduct simpleProduct = new SimpleProduct("Апельсин", 1500);

        cart.add(discountedProduct);
        cart.add(fixPriceProduct);
        cart.add(simpleProduct);

        printCart(cart);
    }

    public static void printCart(List<Product> cart) {
        int totalPrice = 0;
        int specialCount = 0;

        for (Product product : cart) {
            System.out.println(product.toString());
            totalPrice += product.getProductPrice();
            if (product.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого: " + totalPrice);
        System.out.println("Специальных товаров: " + specialCount);
    }
}