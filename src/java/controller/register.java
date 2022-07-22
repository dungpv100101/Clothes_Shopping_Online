/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Customers;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAOCustomers;
import model.DAOEmployees;

/**
 *
 * @author Dung
 */
@WebServlet(name = "register", urlPatterns = {"/register"})
public class register extends HttpServlet {

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
            String username = (String) session.getAttribute("username");
            String service = request.getParameter("do");
            String text_login = "";
            String text_register = "";
            String text_login_admin = "";

            if (username == null) {
                if (service != null && service.equals("login")) {
                    DAOCustomers dao = new DAOCustomers();
                    username = request.getParameter("username");
                    String password = request.getParameter("password");
                    if (dao.checkLogin(username, password)) {
                        session.setAttribute("username", username);
                        request.getRequestDispatcher("home").forward(request, response);
                    } else {
                        text_login = "Username or Password incorrect !";
                    }
                }
                
                if (service != null && service.equals("login_admin")) {
                    DAOEmployees dao = new DAOEmployees();
                    username = request.getParameter("username");
                    String password = request.getParameter("password");
                    if (dao.checkLogin(username, password)) {
                        session.setAttribute("username", username);
                        session.setAttribute("isAdmin", "1");
                        request.getRequestDispatcher("home").forward(request, response);
                    } else {
                        text_login_admin = "Username or Password incorrect !";
                    }
                }

                if (service != null && service.equals("register")) {
                    DAOCustomers dao = new DAOCustomers();
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

                    username = request.getParameter("username");
                    String password = request.getParameter("password");
                    
                    if (companyName == null || companyName.equals("") || customerID == null || customerID.equals("")
                            || username == null || username.equals("") || password == null || password.equals("")) {
                        text_register = "Company Name, Costumers ID, User Name, Password is not empty";
                    } else if (dao.checkCustomerExist(username, customerID)) {
                        text_register = "Customer ID or Username has been exist";
                    } else {
                        dao.addCostumer(new Customers(customerID, companyName, contactName, contactTitle, address, city, region, postalCode, country, phone, fax, username, password));
                        request.getSession().setAttribute("username", username);
                        text_register = "Register successful. Please Login";
                        request.getRequestDispatcher("home").forward(request, response);
                    }
                }
            } else {
                session.removeAttribute("username");
                session.removeAttribute("isAdmin");
                request.getRequestDispatcher("home").forward(request, response);
            }

            request.setAttribute("text_login", text_login);
            request.setAttribute("text_login_admin", text_login_admin);
            request.setAttribute("text_register", text_register);
            request.getRequestDispatcher("register.jsp").forward(request, response);
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
