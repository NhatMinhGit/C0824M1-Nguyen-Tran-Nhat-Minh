package org.example.ex03_currencyconverter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", value = "/display-discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double price = Double.parseDouble(request.getParameter("price"));
        int discountAmount = Integer.parseInt(request.getParameter("percent"));

        Double discountPrice = price * discountAmount * 0.01;
        Double finalPrice = price - discountAmount;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Normal price: " + price + "USD</h1>");
        writer.println("<h1>Discount amount: " + discountAmount + "%</h1>");
        writer.println("<h1>Discount price : " + discountPrice + "USD</h1>");
        writer.println("<h1>Final price : " + finalPrice  + "USD</h1>");
        writer.println("</html>");
    }
}