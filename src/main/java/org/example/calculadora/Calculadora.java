package org.example.calculadora;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calculadora", value = "/calculadora")
public class Calculadora extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello Calculadora!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Recoger datos del formulario
        Integer num1 = request.getParameter("num1") != "" ? Integer.valueOf(request.getParameter("num1")) : null;
        Integer num2 = request.getParameter("num2") != "" ? Integer.valueOf(request.getParameter("num2")) : null;
        String operador = request.getParameter("operador");

        // Enviar respuesta al cliente
        response.setContentType("text/html");
        switch (operador){
            case "+":
                response.getWriter().print(suma(num1, num2));
                break;
            case "-":
                response.getWriter().print(resta(num1, num2));
                break;
            case "*":
                response.getWriter().print(multiplicacion(num1, num2));
                break;
            case "/":
                response.getWriter().print(division(num1, num2));
                break;
            default:
                response.getWriter().print("No va");
                break;
        }
    }

    public static Integer suma(Integer num1, Integer num2) {
        return num1 + num2;
    }

    public static Integer resta(Integer num1, Integer num2) {
        return num1 - num2;
    }

    public static Integer multiplicacion(Integer num1, Integer num2) {
        return num1 * num2;
    }

    public static Double division(Integer num1, Integer num2) {
        Double numero1=Double.parseDouble(num1.toString());
        Double numero2=Double.parseDouble(num2.toString());
        return numero1 / numero2;
    }

    public void destroy() {
    }
}
