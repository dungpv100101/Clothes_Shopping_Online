/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customers;
import entity.OrderDetails;
import entity.Orders;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOCustomers;
import model.DAOOrderDetails;
import model.DAOOrders;
import model.DAOProduct;

/**
 *
 * @author Dung
 */
@WebServlet(name = "checkout", urlPatterns = {"/checkout"})
public class checkout extends HttpServlet {

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

            String userName = (String) request.getSession().getAttribute("username");

            if (userName == null || userName.isEmpty()) {
                request.getRequestDispatcher("register").forward(request, response);
            } else {
                Customers costumer = (new DAOCustomers()).getCustomerByUserName(userName);
                double sumTotal = Double.parseDouble(request.getParameter("sumTotal"));
                if (costumer != null) {
                    Orders order = new Orders(costumer.getCustomerID(), 1, "", "", "", 1, sumTotal, costumer.getCompanyName(), costumer.getAddress(), costumer.getCity(), costumer.getRegion(), costumer.getPostalCode(), costumer.getCountry());
                    (new DAOOrders()).addOrders(order);

                    HttpSession session = request.getSession();
                    Vector<OrderDetails> vecOrderDetails = (Vector<OrderDetails>) session.getAttribute("vecOrderDetails");

                    for (OrderDetails order_details : vecOrderDetails) {
                        String productID = order_details.getProductID() + "";
                        String quantity = order_details.getQuantity() + "";
                        DAOProduct dao = new DAOProduct();
                        
                        int lastestOrderID = 0;
                        ResultSet rs = dao.getData("select TOP 1 * from Orders Order By OrderID DESC");
                        try {
                            if (rs.next()) {
                                lastestOrderID = rs.getInt(1);
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        Vector<Product> vectorProduct = dao.listAllProduct("select * from Products where ProductID=" + productID);
                        for (Product pro : vectorProduct) {
                            (new DAOOrderDetails()).addOrderDetails(new OrderDetails(lastestOrderID, pro.getProductID(), pro.getUnitPrice(), Integer.parseInt(quantity), 0));
                        }
                    }
                }

                request.getSession().removeAttribute("vecOrderDetails");
                request.getRequestDispatcher("home").forward(request, response);
            }

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
