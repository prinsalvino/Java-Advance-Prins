package nl.inholland.myfirstapi.filter;

import lombok.extern.java.Log;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Log
@Order(1)
public class LargeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        int size = servletRequest.getContentLength();
        log.info("Request size: " + size);
        if (size > 20){
            throw new ServletException(String.format("Request with size %d is too big",size));
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
