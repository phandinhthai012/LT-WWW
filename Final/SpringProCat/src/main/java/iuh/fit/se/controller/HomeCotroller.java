package iuh.fit.se.controller;

import iuh.fit.se.entities.Catergory;
import iuh.fit.se.entities.Product;
import iuh.fit.se.service.CategoryService;
import iuh.fit.se.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class HomeCotroller {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @RequestMapping(value = {"/","page/{i}"},method = RequestMethod.GET)
    public String home(Model model, @PathVariable(required = false) Integer i){
        if(i == null){
            i = 1;
        }
//        Catergory category1 = new Catergory("Electronics");
//        Catergory category2 = new Catergory("Books");
//        Catergory category3 = new Catergory("Clothing");
//        Catergory category4 = new Catergory("Furniture");
//        List<Catergory> catergories = List.of(category1,category2,category3,category4);
//        for (int i = 0; i < catergories.size(); i++) {
//            categoryService.addCategory(catergories.get(i));
//        }
//        Product product1 = new Product("Laptop","Dell","Dell Laptop",1000,new Date());
//        product1.setCatergory(category1);
//        Product product2 = new Product("Book","Java","Java Programming",100,new Date());
//        product2.setCatergory(category2);
//        Product product3 = new Product("T-shirt","Adidas","Adidas T-shirt",50,new Date());
//        product3.setCatergory(category3);
//        Product product4 = new Product("Table","IKEA","IKEA Table",200,new Date());
//        product4.setCatergory(category4);
//        Product product5 = new Product("Laptop","HP","HP Laptop",900,new Date());
//        product5.setCatergory(category1);
//        Product product6 = new Product("Book","C#","C# Programming",90,new Date());
//        product6.setCatergory(category2);
//        Product product7 = new Product("T-shirt","Nike","Nike T-shirt",60,new Date());
//        product7.setCatergory(category3);
//        Product product8 = new Product("Chair","IKEA","IKEA Chair",100,new Date());
//        product8.setCatergory(category4);
//        Product product9 = new Product("Laptop","Asus","Asus Laptop",950,new Date());
//        product9.setCatergory(category1);
//        Product product10 = new Product("Book","Python","Python Programming",80,new Date());
//        product10.setCatergory(category2);
//        Product product11 = new Product("T-shirt","Puma","Puma T-shirt",70,new Date());
//        product11.setCatergory(category3);
//        List<Product> products = List.of(product1,product2,product3,product4,product5,product6,product7,product8,product9,product10,product11);
//        for (int i = 0; i < products.size(); i++) {
//            productService.addProduct(products.get(i));
//        }
        List<Product> products = productService.getALLProduct();
        List<Catergory> catergories = categoryService.getALLCategory();
        int size = 3;
        int totalPage = (int) Math.ceil((double) products.size()/size);
        List<Product> productsPage = productService.getProductsPage(i,size);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("catergories",catergories);
        model.addAttribute("currentPage",i);
        model.addAttribute("products",productsPage);
        return "HomePage";
    }

//    Hiển thị danh sách toàn bộ Product (Phân trang 10 product trên 1 trang )
//    @RequestMapping(value = "/page/{i}",method = RequestMethod.GET)
//    public String getProductsPage(@PathVariable int i, Model model){
//        List<Product> products = productService.getProductsPage(i,3);
//        List<Catergory> catergories = categoryService.getALLCategory();
//        int size = 3;
//        int totalPage = (int) Math.ceil((double) productService.getALLProduct().size()/size);
//        model.addAttribute("totalPage",totalPage);
//        model.addAttribute("catergories",catergories);
//        model.addAttribute("products",products);
//        model.addAttribute("currentPage",i);
//        return "HomePage";
//    }
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String searchProduct(Model model,@RequestParam(value = "name",defaultValue = "") String name){
        System.out.println(name);
        List<Product> products = productService.searchProduct(name);
        List<Catergory> catergories = categoryService.getALLCategory();
        model.addAttribute("catergories",catergories);
        model.addAttribute("products",products);
        return "HomePage";
    }
    @RequestMapping(value = "/searchDate",method = RequestMethod.GET)
    public String searchDate(Model model,@RequestParam(value = "date",defaultValue = "2024-12-19") String date){
        System.out.println(date);
        Date dateSearch =null;
        try {
            dateSearch = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        List<Product> products = productService.seachDate((Date) dateSearch);
        List<Catergory> catergories = categoryService.getALLCategory();
        model.addAttribute("catergories",catergories);
        model.addAttribute("products",products);
        return "HomePage";
    }
    @RequestMapping(value = "/searchPrice",method = RequestMethod.GET)
    public String searchPrice(Model model,@RequestParam(value = "price",defaultValue = "100") double price){
        System.out.println(price);
        List<Product> products = productService.seachPrice(price);
        List<Catergory> catergories = categoryService.getALLCategory();
        model.addAttribute("catergories",catergories);
        model.addAttribute("products",products);
        return "HomePage";
    }
    @RequestMapping("/detail/{id}")
    public String detailProduct(Model model,@PathVariable int id){
        Product product = productService.getProductById(id);
        model.addAttribute("product",product);
        return "Detail";
    }
    @RequestMapping("/editDetail")
    public String editDetailProduct(Model model,@ModelAttribute("product") Product product){
        System.out.println(product);
        productService.updateProduct(product);
        return "redirect:/";
    }
    @RequestMapping(value = "/searchCatergory", method = RequestMethod.GET)
    public String categoryProduct(Model model,@RequestParam("id") int id){
        if (id == 0){
            return "redirect:/";
        }
        List<Product> products = productService.seacchProductByCategory(id);
        List<Catergory> catergories = categoryService.getALLCategory();
        model.addAttribute("catergories",catergories);
        model.addAttribute("products",products);
        model.addAttribute("message","Product detail and can edit");
        return "HomePage";
    }
    @RequestMapping(value = "/formAdd",method = RequestMethod.GET)
    public String showFormAdd(Model model){
        model.addAttribute("message", "Add new Productz");
        model.addAttribute("product", new Product());
        List<Catergory> catergories = categoryService.getALLCategory();
        model.addAttribute("catergories",catergories);
        return "AddProduct";
    }
    @RequestMapping(value = "/addProduct",method = RequestMethod.GET)
    public String addProduct(Model model,@ModelAttribute("product") Product product,@RequestParam("catergoryid") int id){
//        productService.addProduct(product);
        System.out.println(product);
        System.out.println(id);
        product.setCatergory(categoryService.getCatergoryById(id));
        productService.addProduct(product);
        System.out.println(product);
        return "redirect:/";

    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteProduct(Model model,@PathVariable int id){
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
