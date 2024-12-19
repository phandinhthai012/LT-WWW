package iuh.fit.se.controller;

import iuh.fit.se.entities.Order;
import iuh.fit.se.service.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/")
    public String home(Model model) {
        List<Order> orders = orderService.getAllOrders();
        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i).getId());
        }
        model.addAttribute("orders", orders);
        model.addAttribute("message", "Hello Spring MVC");
        return "home";
    }
//    show details of order by id can be edit type 1
    //    public String orderDetails(@PathVariable("id") int id, Model model) {
    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String detailOrder(Model model, @PathVariable("id") int id) {
        System.out.println("ID: " + id);
        model.addAttribute("message", "Details of order");
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        double total = order.getPrice() * order.getQuantity();
        model.addAttribute("total", total);
        return "Details";
    }
//    @RequestMapping(value = "/addNew", method = RequestMethod.GET)
//    public String addNewOrder(Model model,@RequestParam("id") int id) {
//        System.out.println("ID: " + id);
//        return "addNew";
//    }
//    show edit order form amd add new information to database type 1
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editOrder(Model model, @RequestParam("id") int id, @RequestParam("quantity") int quantity,
                            @RequestParam("price") double price,
                            @RequestParam("proID") String proID,
                            @RequestParam("proName") String proName) {
        System.out.println("ID: " + id);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + price);
        System.out.println("ProID: " + proID);
        System.out.println("ProName: " + proName);
        Order order = orderService.getOrderById(id);
        order.setQuantity(quantity);
        order.setPrice(price);
        order.setProID(proID);
        order.setProName(proName);
        orderService.editOrder(order);
        return "redirect:/";
    }

//    show form add new order
    @RequestMapping(value = "/addNew", method = RequestMethod.GET)
    public String addNew(Model model) {
        Order order = new Order();
        model.addAttribute("order", order);
        return "addNew";
    }
//    add new order to database
    @RequestMapping(value = "/addOrder", method = RequestMethod.GET)
    public String addNewOrder(Model model, @Valid @ModelAttribute("order") Order order, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addNew";
        }else {
            orderService.addOrder(order);
            return "redirect:/";
        }
    }
//    delete order by id
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteOrder(Model model, @PathVariable("id") int id) {
        orderService.deleteOrder(id);
        return "redirect:/";
    }
//    search order by name
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchOrder(Model model,@RequestParam("search") String text) {
//        BindingResult không hỗ trợ @RequestParam,
//        BindingResult là một tính năng của Spring MVC để kiểm tra và lưu trữ lỗi của các object được validate (thường thông qua @ModelAttribute hoặc @RequestBody).
//        tạo một object Order và validate nó thì BindingResult sẽ chứa thông tin lỗi của object Order.
//        kiểm tra thủ công
        if (text == null || text.trim().isEmpty()) {
            model.addAttribute("error", "Search text cannot be empty");
            List<Order> orders = orderService.getAllOrders();
            model.addAttribute("orders", orders);
            model.addAttribute("message", "Hello Spring MVC");
            return "home";
        }
        List<Order> orders = orderService.searchOrder(text);
        model.addAttribute("orders", orders);
        return "home";
    }
//    show form edit order type 2
    @RequestMapping(value = "/edit2", method = RequestMethod.GET)
    public String editOrder(Model model, @RequestParam("id") int id) {
        Order order = orderService.getOrderById(id);
        System.out.println("ID: " + id);
        model.addAttribute("order", order);
        model.addAttribute("message", "Edit order type 2 use object");
        return "Details2";
    }
//    edit order type 2
    @RequestMapping(value = "/editOrder2", method = RequestMethod.GET)
    public String editOrder(Model model,@Valid @ModelAttribute("order") Order order,BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "Details2";
        }
        orderService.editOrder(order);
        return "redirect:/";
    }
}
