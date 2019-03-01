package com.ychs.servlet;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 关于学生管理的Servlet,是综合性，包含了增删改查
 * Created by asus on 2018/9/19.
 */
public class StudentManagerServlet extends HttpServlet {
    private Logger logger = LogManager.getLogger();
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        switch (method){
            case "toStudentManagerPage":
                toStudentManagerPage(request,response);
                break;

        }
    }

    /**
     * 去管理页面
     * @param request 请求
     * @param response 响应
     */
    private void toStudentManagerPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/view/studentManager." +
                "jsp").forward(request,response);

    }
}
