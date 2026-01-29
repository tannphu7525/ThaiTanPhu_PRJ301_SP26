/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UniversityDAO;
import model.UniversityDTO;

public class DeleteUniversity extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        String keywords = request.getParameter("keywords");
        String id = request.getParameter("id");
        
        if (keywords == null) {
            keywords ="";
        }
        if (id == null) {
            id = "";
        }
        
        System.out.println(keywords);
        UniversityDAO dao = new UniversityDAO();
        
        //Xoa
        if (!id.isEmpty()) {
            boolean check = dao.softDelete(id);
            if (check) {
                request.setAttribute("mess", "Delete!");
            }else{
                request.setAttribute("mess", "Error, can not delete" + id);
            }
        }
        
        ArrayList<UniversityDTO> list = new ArrayList<>();
        if (keywords.trim().length() > 0) {
            list = dao.filterByName(keywords);
        }
        request.setAttribute("list", list);
        request.setAttribute("keywords", keywords);
        String url = "search.jsp";
        request.getRequestDispatcher(url).forward(request, response);        
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
