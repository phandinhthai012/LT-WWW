package iuh.fit.se.controller;

import iuh.fit.se.enities.Category;
import iuh.fit.se.enities.Product;
import iuh.fit.se.services.CategoryService;
import iuh.fit.se.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(Model model){
        List<Category> categories = categoryService.getAllCategory();
        List<Product> products = productService.getAllProduct();
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        model.addAttribute("springApplicationName", "PhanDinhThai_21038281_SpringBoot_MVC_Thymleaf");
        return "index";
    }
    @RequestMapping(value = "/phanTrang",method = RequestMethod.GET)
    public String phanTrang(Model model, @RequestParam(defaultValue = "0") int page){
        Page<Product> productPage = productService.getAllProductPagination(page, 5);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", productPage.getTotalPages());
        model.addAttribute("products", productPage.getContent());
        model.addAttribute("springApplicationName", "PhanDinhThai_21038281_SpringBoot_MVC_Thymleaf");
        return "phanTrang";
    }
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String search(Model model, @RequestParam String keyword){
        List<Product> products = productService.search(keyword);
        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword);
        model.addAttribute("springApplicationName", "PhanDinhThai_21038281_SpringBoot_MVC_Thymleaf");
        return "index";
    }

    @RequestMapping(value = "/searchByPrice",method = RequestMethod.GET)
    public String searchByPrice(Model model, @RequestParam(defaultValue = "0") double price){
        if(price == 0){
            return "redirect:/";
        }
        List<Product> products = productService.findByPrice(price);
        model.addAttribute("products", products);
        model.addAttribute("price", price);
        model.addAttribute("springApplicationName", "PhanDinhThai_21038281_SpringBoot_MVC_Thymleaf");
        return "index";
    }
    @RequestMapping(value = "/searchByRegisterDate",method = RequestMethod.GET)
    public String searchByRegisterDate(Model model, @RequestParam String registerDate){
        List<Product> products;
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(registerDate);
            products = productService.findByRegisterDate(date);
        } catch (ParseException e) {
            products = List.of(); // Return an empty list if the date is invalid
        }
        model.addAttribute("products", products);
        model.addAttribute("registerDate", registerDate);
        model.addAttribute("springApplicationName", "PhanDinhThai_21038281_SpringBoot_MVC_Thymleaf");
        return "index";
    }
    @RequestMapping(value = "/filterByCategory",method = RequestMethod.GET)
    public String filterByCategory(Model model, @RequestParam int categoryId){
        if(categoryId == 0){
            return "redirect:/";
        }
        List<Product> products = productService.findByCategory_Id(categoryId);
        List<Category> categories = categoryService.getAllCategory();
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("springApplicationName", "PhanDinhThai_21038281_SpringBoot_MVC_Thymleaf");
        return "index";
    }
    @RequestMapping(value = "/showForm",method = RequestMethod.GET)
    public String showForm(Model model){
        List<Category> categories = categoryService.getAllCategory();
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("categories", categories);
        model.addAttribute("springApplicationName", "PhanDinhThai_21038281_SpringBoot_MVC_Thymleaf");
        return "form";
    }

    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    public String addProduct(Model model, @Valid @ModelAttribute Product product, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<Category> categories = categoryService.getAllCategory();
            model.addAttribute("categories", categories);
            model.addAttribute("springApplicationName", "PhanDinhThai_21038281_SpringBoot_MVC_Thymleaf");
            return "form";
        }
        productService.addProduct(product);
        return "redirect:/";
    }
}
