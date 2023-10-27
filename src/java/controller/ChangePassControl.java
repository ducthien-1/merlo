/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;

/**
 *
 * @author asus
 */
@WebServlet(name="ChangePassControl", urlPatterns={"/changepassword"})
public class ChangePassControl extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ChangePassControl</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangePassControl at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        Customer c = (Customer)session.getAttribute("account");
//        request.setAttribute("acc", c);
        
        request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String username = request.getParameter("username");
        String oldPass = request.getParameter("oldPassword");
        String newPass = request.getParameter("newPassword");
        String confirmPass = request.getParameter("confirmPassword");
        String curPass = request.getParameter("curPass");
        
        
        if(!oldPass.equals(curPass)){
            request.setAttribute("err", "Your old password is not correct");
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
        }
        else if(newPass.equals(oldPass)){
            request.setAttribute("err", "New password must be different from old password");
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
        }else if(!newPass.equals(confirmPass)){
            request.setAttribute("err", "Confirm password is incorrect");
            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
        }else{
            CustomerDAO ad = new CustomerDAO();
            ad.changePassword(username, newPass);
            request.setAttribute("err", "Your password has been changed successfully");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
