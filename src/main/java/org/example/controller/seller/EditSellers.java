package org.example.controller.seller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.example.util.NamesUtil.*;


@WebServlet(EDIT_SELLERS)
public class EditSellers extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher includeDispatcher = request.getRequestDispatcher(GET_ALL_SELLERS);
        includeDispatcher.include(request, response);
        RequestDispatcher forwardDispatcher = request.getRequestDispatcher(EDIT_SELLERS_JSP);
        forwardDispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}



