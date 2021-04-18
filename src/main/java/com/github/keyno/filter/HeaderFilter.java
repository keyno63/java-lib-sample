package com.github.keyno.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(
        urlPatterns = {"/*"},
        asyncSupported = true
)
public class HeaderFilter implements Filter {

    @Override
    public final void init(final FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public final void doFilter(
            final ServletRequest request,
            final ServletResponse response,
            final FilterChain chain
            ) {

    }

    @Override
    public void destroy() {}
}
