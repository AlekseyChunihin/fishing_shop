package ua.com.alevel.fishing_shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ua.com.alevel.fishing_shop.entity.Brand;
import ua.com.alevel.fishing_shop.entity.Product;
import ua.com.alevel.fishing_shop.service.BrandService;
import ua.com.alevel.fishing_shop.service.ProductService;

import java.util.List;

@SpringBootApplication
public class FishingShopApplication {

    @Autowired
    ProductService productService;

    @Autowired
    BrandService brandService;

    public static void main(String[] args) {
        SpringApplication.run(FishingShopApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    private void testJpaMethods() {
        List<Brand> brandList = brandService.findAll();
        for (Brand brand : brandList) {
            System.out.println(brand.getName());
        }
        List<Product> products = productService.findAll();
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }
}
