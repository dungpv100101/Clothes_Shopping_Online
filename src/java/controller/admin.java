/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customers;
import entity.Orders;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOCustomers;
import model.DAOOrders;
import model.DAOProduct;

/**
 *
 * @author Dung
 */
@WebServlet(name = "admin", urlPatterns = {"/admin"})
public class admin extends HttpServlet {

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
            String isAdmin = (String)request.getSession().getAttribute("isAdmin");
            
            if (isAdmin == null || !isAdmin.equals("1")) {
                request.getRequestDispatcher("home").forward(request, response);
                return;
            }
            
            int page_number = 0;
            try {
                page_number = Integer.parseInt(request.getParameter("page_number"));
            } catch (Exception e) {
                page_number = 0;
            }

            if (service == null || service.equals("null")) {
                service = "order";
            }

            if (service.equals("customer")) {
                String customerID = request.getParameter("ID");
                String sql_customerID = "";
                if (customerID != null && !customerID.equals("null") && !customerID.isEmpty()) {
                    sql_customerID = "WHERE CustomerID='" + customerID + "'";
                }

                Vector<Customers> vecCustomers = (new DAOCustomers()).listAllCustomers("SELECT *\n"
                        + "FROM (\n"
                        + "    SELECT *, ROW_NUMBER() OVER (ORDER BY CustomerID) AS RowNum\n"
                        + "    FROM dbo.Customers\n"
                        + sql_customerID
                        + ") AS MyDerivedTable\n"
                        + "WHERE MyDerivedTable.RowNum BETWEEN " + (page_number * 9 + 1) + " AND " + (page_number * 9 + 9));
                request.setAttribute("vecCustomers", vecCustomers);
            }
            
            if (service.equals("product")) {
                String productID = request.getParameter("ID");
                String sql_productID = "";
                if (productID != null && !productID.equals("null") && !productID.isEmpty()) {
                    sql_productID = "WHERE ProductID='" + productID + "'";
                }

                Vector<Product> vecProduct = (new DAOProduct()).listAllProduct("SELECT *\n"
                        + "FROM (\n"
                        + "    SELECT *, ROW_NUMBER() OVER (ORDER BY ProductID) AS RowNum\n"
                        + "    FROM dbo.Products\n"
                        + sql_productID
                        + ") AS MyDerivedTable\n"
                        + "WHERE MyDerivedTable.RowNum BETWEEN " + (page_number * 9 + 1) + " AND " + (page_number * 9 + 9));
                request.setAttribute("vecProduct", vecProduct);
            }
            
            
            if (service.equals("order")) {
                String orderID = request.getParameter("ID");
                String status = request.getParameter("status");
                String sql_orderID = "";
                if (orderID != null && !orderID.equals("null") && !orderID.isEmpty()) {
                    sql_orderID = "WHERE OrderID=" + orderID;
                }
                
                String sql_status = "";
                if (status != null && !status.equals("null") && !status.isEmpty()) {
                    sql_status = "WHERE status=" + status;
                }

                Vector<Orders> vecOrder = (new DAOOrders()).listAllOrders("SELECT *\n"
                        + "FROM (\n"
                        + "    SELECT *, ROW_NUMBER() OVER (ORDER BY OrderID) AS RowNum\n"
                        + "    FROM dbo.Orders\n"
                        + sql_orderID
                        + sql_status
                        + ") AS MyDerivedTable\n"
                        + "WHERE MyDerivedTable.RowNum BETWEEN " + (page_number * 9 + 1) + " AND " + (page_number * 9 + 9));
                request.setAttribute("vecOrder", vecOrder);
            }
            
            

            request.setAttribute("service", service);
            request.setAttribute("page_number", page_number + "");
            request.getRequestDispatcher("admin.jsp").forward(request, response);
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
