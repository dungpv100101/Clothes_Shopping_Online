 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.DAOProduct;
import model.DAOSuppliers;

/**
 *
 * @author Dung
 */
@WebServlet(name = "products", urlPatterns = {"/products"})
public class products extends HttpServlet {

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
            int page_number = Integer.parseInt(request.getParameter("page_number"));
            String supplier = request.getParameter("supplier");
            String search = request.getParameter("search");
            
            String sql_supplier = "";
            if (supplier != null && !supplier.equals("null")) sql_supplier = " and SupplierID=" + supplier;
            
            String sql_search = "";
            if (search != null && !search.isEmpty()) sql_search = " and ProductName like '%"+search+"%'";
            
            DAOProduct daoProducts = new DAOProduct();
            DAOSuppliers daoSuppliers = new DAOSuppliers();
            
            Vector<Product> vecProduct = daoProducts.listAllProduct("SELECT *\n"
                    + "FROM (\n"
                    + "    SELECT *, ROW_NUMBER() OVER (ORDER BY ProductID) AS RowNum\n"
                    + "    FROM dbo.Products\n"
                    + "    WHERE Discontinued = 0"
                    + sql_supplier
                    + sql_search
                    + ") AS MyDerivedTable\n"
                    + "WHERE MyDerivedTable.RowNum BETWEEN "+ (page_number * 9 +1) +" AND " + (page_number *9 + 9));
            
            Vector<Suppliers> vecSuppliers = daoSuppliers.listAllSuppliers();
            
            request.setAttribute("vecSuppliers", vecSuppliers);
            request.setAttribute("vecProduct", vecProduct);
            request.setAttribute("page_number", page_number + "");
            request.setAttribute("supplier", supplier);
            
            request.getRequestDispatcher("products.jsp").forward(request, response);
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
