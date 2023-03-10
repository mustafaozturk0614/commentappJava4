package com.bilgeadam.commentappJava4.mvc;


import com.bilgeadam.commentappJava4.dto.request.ProductCreateRequestDto;
import com.bilgeadam.commentappJava4.repository.entity.Like;
import com.bilgeadam.commentappJava4.repository.entity.Product;
import com.bilgeadam.commentappJava4.repository.entity.User;
import com.bilgeadam.commentappJava4.service.ProductService;
import com.bilgeadam.commentappJava4.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/productmvc")
public class ProductMvcController {


    private final ProductService productService;
    private final UserService userService;

    @GetMapping("/createproduct")
    public ModelAndView getProductPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("createproduct");
        return modelAndView;
    }

    @PostMapping("/createproduct")
    public ModelAndView createProduct(ProductCreateRequestDto dto) {
        productService.saveWithRequest(dto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:createproduct");
        return modelAndView;
    }

    @GetMapping("/getallproducts")
    public ModelAndView getAllproducts(Long userId) {

        User user = userService.findById(userId).get();
        List<Long> productid = user.getLikes().stream().map(x -> x.getProduct().getId()).collect(Collectors.toList());
        Like like = new Like();
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.findAll();
        modelAndView.addObject("products", products);
        modelAndView.addObject("user", user);
        modelAndView.addObject("pid", productid);
        modelAndView.addObject("like", like);
        modelAndView.setViewName("home");
        return modelAndView;
    }


    @GetMapping("/getallproducts2")
    public ModelAndView getAllproducts2(Long userId) {

        User user = userService.findById(userId).get();
        List<Long> productid = user.getLikes().stream().map(x -> x.getProduct().getId()).collect(Collectors.toList());
        Like like = new Like();
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.findAll();
        modelAndView.addObject("products", products);
        modelAndView.addObject("user", user);
        modelAndView.addObject("pid", productid);
        modelAndView.addObject("like", like);
        modelAndView.setViewName("home3");
        return modelAndView;
    }
}
