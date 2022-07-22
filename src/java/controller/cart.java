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
@WebServlet(name = "cart", urlPatterns = {"/cart"})
public class cart extends HttpServlet {

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
            String[] productID = request.getParameterValues("productID");
            String[] quantity = request.getParameterValues("quantity");
            String[] remove = request.getParameterValues("remove");
            Vector<OrderDetails> vecOrderDetails = (Vector<OrderDetails>) session.getAttribute("vecOrderDetails");
            String text = "";
            if (productID != null && quantity != null) {
                for (int i = 0; i < productID.length; i++) {
                    for (OrderDetails order : vecOrderDetails) {
                        if ((order.getProductID() + "").equals(productID[i])) {
                            Product pro = (new DAOProduct()).searchProductByID(productID[i]);
                            if (Integer.parseInt(quantity[i]) < pro.getUnitsInStock()) {
                                order.setQuantity(Integer.parseInt(quantity[i]));
                            } else {
                                text = "Mot so san pham ko duoc cap nhap vi qua so luong";
                            }
                        }
                    }
                }

                if (remove != null) {
                    for (int i = 0; i < remove.length; i++) {
                        for (OrderDetails order : vecOrderDetails) {
                            if ((order.getProductID() + "").equals(remove[i])) {
                                vecOrderDetails.remove(order);
                                break;
                            }
                        }
                    }
                }
            }

            request.setAttribute("text", text);
            session.setAttribute("vecOrderDetails", vecOrderDetails);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
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
