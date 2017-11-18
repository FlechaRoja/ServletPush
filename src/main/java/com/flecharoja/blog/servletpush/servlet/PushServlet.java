/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flecharoja.blog.servletpush.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;

/**
 * Servlet de Ejemplo para PushServlet
 *
 * @author Gerardo Arroyo
 */
@WebServlet(name = "Push", urlPatterns = {"/push"})
public class PushServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Retorna una instancia de PushBuilder si HTTP/2 esta habilitado o null en caso contrario
        PushBuilder pushBuilder = request.newPushBuilder();

        if (pushBuilder != null) {
            // Hacemos un push del logo
            pushBuilder
                    .path("images/logo.svg")
                    .addHeader("content-type", "image/svg")
                    .push();

            pushBuilder
                    .path("css/bootstrap.css")
                    .push();

            pushBuilder
                    .path("js/jquery-3.2.1.slim.min.js")
                    .push();
            pushBuilder
                    .path("js/popper.min.js")
                    .push();
            pushBuilder
                    .path("js/bootstrap.js")
                    .push();

            request.getRequestDispatcher("index.html").forward(request, response);
        } else {
            super.doGet(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet de ejemplo de Push";
    }

}
