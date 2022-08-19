package pl.coderslab.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter("/*")
public class MyEncodingFilter implements Filter {

    public static final String UTF_8 = "UTF-8";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding(UTF_8);    // ctrl+ alt + c  -> ustawiamy stała
        response.setCharacterEncoding(UTF_8);
        chain.doFilter(request, response);
    }
}