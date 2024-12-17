package iuh.fit.se.controller;

import iuh.fit.se.entities.Order;
import iuh.fit.se.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping(value = "/addNew", method = RequestMethod.GET)
    public String addNew(Model model) {
        Order order = new Order();
        model.addAttribute("order", order);
        return "addNew";
    }
    @RequestMapping(value = "/addOrder", method = RequestMethod.GET)
    public String addNewOrder(Model model, @ModelAttribute("order") Order order) {
        orderService.addOrder(order);
        return "redirect:/";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteOrder(Model model, @PathVariable("id") int id) {
        orderService.deleteOrder(id);
        return "redirect:/";
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchOrder(Model model, @RequestParam("search") String text) {
        List<Order> orders = orderService.searchOrder(text);
        model.addAttribute("orders", orders);
        return "home";
    }
}
