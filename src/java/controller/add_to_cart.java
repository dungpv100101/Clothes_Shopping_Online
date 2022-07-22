/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.OrderDetails;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOProduct;

/**
 *
 * @author Dung
 */
@WebServlet(name = "add_to_cart", urlPatterns = {"/add_to_cart"})
public class add_to_cart extends HttpServlet {

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
            HttpSession session = request.getSession();
            Vector<OrderDetails> vecOrderDetails = (Vector<OrderDetails>) session.getAttribute("vecOrderDetails");

            int productID = Integer.parseInt(request.getParameter("productID"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            String text = "";
            
            if (vecOrderDetails == null) {
                vecOrderDetails = new Vector<OrderDetails>();
            }

            DAOProduct dao = new DAOProduct();
            Product pro = dao.searchProductByID(productID + "");
            boolean isExist = false;

            for (OrderDetails order : vecOrderDetails) {
                if (order.getProductID() == productID) {
                    if (order.getQuantity() + quantity < pro.getUnitsInStock()) {
                        order.setQuantity(order.getQuantity() + quantity);
                        isExist = true;
                    } else {
                        text = "Qua so luong trong kho";
                        break;
                    }
                }
            }

            if (!isExist) {
                if (quantity < pro.getUnitsInStock()) {
                    vecOrderDetails.add(new OrderDetails(productID, pro.getUnitPrice(), quantity, 0));
                } else {
                    text = "Qua so luong trong kho";
                }
            }

            session.setAttribute("vecOrderDetails", vecOrderDetails);
            
            request.setAttribute("text", text);
            request.setAttribute("productID", productID);
            request.getRequestDispatcher("product_detail").forward(request, response);
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
