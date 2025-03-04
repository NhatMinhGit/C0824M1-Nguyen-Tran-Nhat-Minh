package org.example.ex03_showlist;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> list = new ArrayList<>();
        list.add(new Customer("Mai Van Doan", "1983-08-20", "Ha Noi", "img1"));
        list.add(new Customer("Nguyen Van B", "1990-05-15", "Ho Chi Minh", "img2"));
        list.add(new Customer("Tran Thi C", "1985-12-10", "Da Nang", "img3"));
        list.add(new Customer("Le Van D", "1992-03-25", "Can Tho", "img4"));

        request.setAttribute("list", list);
        request.getRequestDispatcher("/customerList.jsp").forward(request, response);
    }
}