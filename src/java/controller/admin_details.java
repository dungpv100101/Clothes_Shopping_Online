/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Categories;
import entity.Customers;
import entity.OrderDetails;
import entity.Orders;
import entity.Product;
import entity.Suppliers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOCategories;
import model.DAOCustomers;
import model.DAOOrderDetails;
import model.DAOOrders;
import model.DAOProduct;
import model.DAOSuppliers;

/**
 *
 * @author Dung
 */
@WebServlet(name = "admin_details", urlPatterns = {"/admin_details"})
public class admin_details extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String service = request.getParameter("do");

            int page_number = 0;
            try {
                page_number = Integer.parseInt(request.getParameter("page_number"));
            } catch (Exception e) {
                page_number = 0;
            }

            if (service != null && service.equals("customer")) {
                String customerID = request.getParameter("customerID");
                Customers customer = (new DAOCustomers()).getCustomerByID(customerID);

                request.setAttribute("customer", customer);
            }

            if (service != null && service.equals("customer_update")) {
                String customerID = request.getParameter("customerID");
                String companyName = request.getParameter("companyName");
                String contactName = request.getParameter("contactName");
                String contactTitle = request.getParameter("contactTitle");
                String address = request.getParameter("address");
                String city = request.getParameter("city");
                String region = request.getParameter("region");
                String postalCode = request.getParameter("postalCode");
                String country = request.getParameter("country");
                String phone = request.getParameter("phone");
                String fax = request.getParameter("fax");

                if (companyName == null || companyName.equals("") || customerID == null || customerID.equals("")) {
                    out.print("Company Name, Costumers ID is not empty");
                    return;
                }

                (new DAOCustomers()).updateCostumer(new Customers(customerID, companyName, contactName, contactTitle, address, city, region, postalCode, country, phone, fax));

                Customers customer = (new DAOCustomers()).getCustomerByID(customerID);
                service = "customer";

                request.setAttribute("customer", customer);
            }
            
            if (service != null && service.equals("customer_remove")) {
                String customerID = request.getParameter("customerID");
                (new DAOCustomers()).deleteByID(customerID);

                request.getRequestDispatcher("admin?do=customer").forward(request, response);
                return;
            }

            if (service != null && service.equals("product")) {
                String productID = request.getParameter("productID");
                Product product = (new DAOProduct()).searchProductByID(productID);
                Vector<Suppliers> vecSuppliers = (new DAOSuppliers()).listAllSuppliers();
                Vector<Categories> vecCategories = (new DAOCategories()).listAllCategories("select * from Categories");

                request.setAttribute("vecSuppliers", vecSuppliers);
                request.setAttribute("vecCategories", vecCategories);
                request.setAttribute("product", product);
            }

            if (service != null && service.equals("product_update")) {
                String productID = request.getParameter("productID");
                String productName = request.getParameter("productName");
                String supplierID = request.getParameter("supplierID");
                String categoryID = request.getParameter("categoryID");
                String quantityPerUnit = request.getParameter("quantityPerUnit");
                String unitPrice = request.getParameter("unitPrice");
                String unitsInStock = request.getParameter("unitsInStock");
                String unitsOnOrder = request.getParameter("unitsOnOrder");
                String reorderLevel = request.getParameter("reorderLevel");
                String discontinued = request.getParameter("discontinued");

                if (productName == null || productName.equals("")) {
                    out.print("ProductName is not empty");
                    return;
                }
                if (discontinued == null || discontinued.equals("")) {
                    out.print("Discontinued is not empty");
                    return;
                }
                try {
                    int pID = Integer.parseInt(productID);
                    String ProductName = productName;
                    int SupplierID = Integer.parseInt(supplierID);
                    int CategoryID = Integer.parseInt(categoryID);
                    String QuantityPerUnit = quantityPerUnit;
                    double UnitPrice = Double.parseDouble(unitPrice);
                    int UnitsInStock = Integer.parseInt(unitsInStock);
                    int UnitOnOrder = Integer.parseInt(unitsOnOrder);
                    int ReordeerLevel = Integer.parseInt(reorderLevel);
                    int Discontinued = Integer.parseInt(discontinued);

                    (new DAOProduct()).updateProduct(new Product(pID, ProductName, SupplierID, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitOnOrder, ReordeerLevel, Discontinued));

                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    return;
                }

                Product product = (new DAOProduct()).searchProductByID(productID);
                Vector<Suppliers> vecSuppliers = (new DAOSuppliers()).listAllSuppliers();
                Vector<Categories> vecCategories = (new DAOCategories()).listAllCategories("select * from Categories");

                service = "product";
                request.setAttribute("vecSuppliers", vecSuppliers);
                request.setAttribute("vecCategories", vecCategories);
                request.setAttribute("product", product);
            }
            
            if (service != null && service.equals("product_remove")) {
                String productID = request.getParameter("productID");
                (new DAOProduct()).deleteProduct(Integer.parseInt(productID));

                request.getRequestDispatcher("admin?do=product").forward(request, response);
                return;
            }

            if (service != null && service.equals("order")) {
                String orderID = request.getParameter("orderID");
                Vector<OrderDetails> vecOrderDetails = (new DAOOrderDetails()).listAllOrderDetails("select * from [Order Details] where OrderID = " + orderID + " ");
                Orders order = (new DAOOrders()).searchOrderByOrderID(orderID);
                String customerName = (new DAOCustomers()).getCustomerName(order.getCustomerID());

                request.setAttribute("customerName", customerName);
                request.setAttribute("order", order);
                request.setAttribute("vecOrderDetails", vecOrderDetails);
            }

            if (service != null && service.equals("order_update")) {
                String orderID = request.getParameter("orderID");
                String status = request.getParameter("status");
                (new DAOOrders()).updateOrdersStatus(orderID, status);
                Vector<OrderDetails> vecOrderDetails = (new DAOOrderDetails()).listAllOrderDetails("select * from [Order Details] where OrderID = " + orderID + " ");
                Orders order = (new DAOOrders()).searchOrderByOrderID(orderID);
                String customerName = (new DAOCustomers()).getCustomerName(order.getCustomerID());
                service = "order";

                request.setAttribute("customerName", customerName);
                request.setAttribute("order", order);
                request.setAttribute("vecOrderDetails", vecOrderDetails);
                request.setAttribute("orderID", orderID);
            }

            request.setAttribute("page_number", page_number + "");
            request.setAttribute("service", service);
            request.getRequestDispatcher("admin_details.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
