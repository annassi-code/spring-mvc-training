package com.application.controller;

import com.application.entity.Product;
import com.application.entity.User;
import com.application.repository.ProductRepository;
import com.application.validator.ProductValidator;
import com.application.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    @GetMapping("/products/add/")
    public String getAddProductForm(@ModelAttribute("product") Product product, Model model) {
        model.addAttribute("action", "add");
        return "new-product";
    }


    @PostMapping("/products/add/")
    public String addProduct(@ModelAttribute("productObject") Product product, BindingResult result, Model model) {

        new ProductValidator().validate(product, result);
        if (result.hasErrors()) {
            return "new-product";
        }
        productRepository.save(product);

        model.addAttribute("message", " new product has been added");
        return "redirect:/products/";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable int id, Model model) {
        productRepository.deleteById(id);
        model.addAttribute("message", "product " + id + " has been removed");
        return "redirect:/products";
    }

    @GetMapping("/products/modify/{productId}")
    public String getProductFromForProductId(@PathVariable int productId, Model model) {
        model.addAttribute("product", productRepository.findById(productId));
        model.addAttribute("action", "update");
        return "new-product";
    }

    @PostMapping("/products/modify/{productId}")
    public String updateProduct(@ModelAttribute("productObject") Product product, @PathVariable int productId, Model model) {
        product.setId(productId);
        if (product.getId() != null) {
            productRepository.save(product);
        }
        model.addAttribute("message", "user " + product.getName() + " has been updated");
        return "redirect:/products";
    }
}
