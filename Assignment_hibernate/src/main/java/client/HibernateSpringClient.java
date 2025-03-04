package client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.CustomerService;
import service.OrderService;
import hibernate1.customer;



public class HibernateClient {

    public static void main(String[] args) {

        // Load Spring Application Context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("ass-hib-ann.xml");

        // Retrieve Beans from Spring Context
        CustomerService customerService = ctx.getBean(CustomerService.class);
        InventoryService inventoryService = ctx.getBean(InventoryService.class);
        OrderService orderService = ctx.getBean(OrderService.class);

        // Sample Customer Data
        customer c1 = new customer("FENIL", 21, "AHM", "SRT");
        customer c2 = new customer("RAJ", 21, "RJT", "AHM");
        customer c3 = new customer("KRISHNA", 21, "VDA", "DIU");
        customer c4 = new customer("SHIV", 21, "AMR", "HMT");

        customerService.addCustomer(c1);
        customerService.addCustomer(c2);
        customerService.addCustomer(c3);
        customerService.addCustomer(c4);

        // Perform Delete Operation
        customerService.deleteCustomer(9);

        // Sample Inventory Data
//        Item i1 = new Item("LAPTOP", "XZT", 10, 4, 15);
//        Item i2 = new Item("PC", "i5", 6, 2, 10);
//        Item i3 = new Item("MOUSE", "WIRELESS", 5, 2, 8);
//        Item i4 = new Item("KEYBOARD", "WIRED", 5, 2, 6);

//        inventoryService.addInventory(i1);
//        inventoryService.addInventory(i2);
//        inventoryService.addInventory(i3);
//        inventoryService.addInventory(i4);

        // Example of using LiveItem (if needed)
//        LiveItem liveItem = new LiveItem(i1, 2);

        // Close Context
        ctx.close();
    }
}
