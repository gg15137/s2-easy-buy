package com.buy.web;

import com.buy.entity.EasybuyProductCategory;
import com.buy.service.product.IProductCategoryService;
import com.buy.service.product.ProductCatrgoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet",urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从service层获取数据
        IProductCategoryService productCategoryService = new ProductCatrgoryServiceImpl();
        List<EasybuyProductCategory> categories = productCategoryService.queryAllproductCategory("0");
        //存储数据
        request.setAttribute("categories",categories);
        //携带数据跳转到home.jsp，传递数据
        request.getRequestDispatcher("/frot/home.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
