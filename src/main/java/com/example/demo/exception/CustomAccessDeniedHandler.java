package com.example.demo.exception;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        // You can log the exception here if needed
        // For instance, using SLF4J: LoggerFactory.getLogger(this.getClass()).error("Access Denied", accessDeniedException);

        // Redirect or respond with an appropriate message
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().print("Access Denied!");
    }
}
