package com.bilgeadam.commentappJava4.service;

import com.bilgeadam.commentappJava4.repository.IProductRepository;
import com.bilgeadam.commentappJava4.repository.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final IProductRepository productRepository;


    public void saveAll(List<Product> products) {

        productRepository.saveAll(products);
    }


    public List<Product> findAllByGreaterThan(double price) {

        return productRepository.findAllByPriceGreaterThan(price);
    }

    public List<Product> findAllByExpirationDate() {

        return productRepository.findAllByExpirationDateBefore(LocalDate.now());
    }

    public List<Product> findAllByExpirationDate2(String date) {

        LocalDate newDate = LocalDate.parse(date);


        return productRepository.findAllByExpirationDateBefore(newDate);
    }


    public List<Product> findAllByExpirationDateAfterOrExpirationDateIsNull(String date) {
        LocalDate newDate = LocalDate.parse(date);
        return productRepository.findAllByExpirationDateAfterOrExpirationDateIsNull(newDate);
    }

    public List<Product> findAllByExpirationDateGreaterThanEqualOrExpirationDateIsNull(String date) {
        LocalDate newDate = LocalDate.parse(date);
        return productRepository.findAllByExpirationDateGreaterThanEqualOrExpirationDateIsNull(newDate);
    }


    public Object[] searchByProductPrice() {

        return productRepository.searchByProductPrice();
    }

    public List<Object> searchByProductPrice2() {

        return productRepository.searchByProductPrice2();
    }


    public int countAllByExpirationDate(String date) {
        return productRepository.countAllByExpirationDate(LocalDate.parse(date));
    }

    public List<Product> findAllByPriceIn(List<Double> prices) {

        return productRepository.findAllByPriceIn(prices);

    }

    public List<Product> findAllByPriceIn(Double[] prices) {
        return productRepository.findAllByPriceIn(prices);

    }

    public List<Product> findAllByNameIn(String[] names) {

        return productRepository.findAllByNameIn(names);
    }

    public List<Product> findAllByExpirationDateBetween() {
        LocalDate now = LocalDate.now();
        LocalDate nextDate = LocalDate.now().plusMonths(6);

        List<Product> products = productRepository.findAllByExpirationDateBetween(now, nextDate);

        products.stream().forEach(x -> {
            x.setPrice(x.getPrice() * 0.9);
            productRepository.save(x);
        });
        return products;

//        return products.stream().map(y -> {
//            y.setPrice(y.getPrice() * 0.9);
//            return productRepository.save(y);
//
//        }).collect(Collectors.toList());

    }


}
