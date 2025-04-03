package org.example.ex02_productmanagement.controller;

import org.example.ex02_productmanagement.model.Product;
import org.example.ex02_productmanagement.service.ProductService;
import org.example.ex02_productmanagement.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService = new ProductServiceImpl();

    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "index";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(Product customer, RedirectAttributes redirect) {
        productService.remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/products";
    }
    @GetMapping("/{id}/edit")
    public String update(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "update";
    }
    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/products";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/save")
    public String save(Product product) {
        product.setId((long) (Math.random() * 10000));
        productService.save(product);
        return "redirect:/products";
    }
}