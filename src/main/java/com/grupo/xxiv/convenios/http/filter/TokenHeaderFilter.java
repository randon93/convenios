package com.grupo.xxiv.convenios.http.filter;

import com.grupo.xxiv.convenios.http.util.TokenHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class TokenHeaderFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenHeaderFilter.class);

    private static final String ACCESS_TOKEN_HEADER = "Authorization";

    private static final String PREFIX = "Bearer ";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper((HttpServletRequest) request);
        LOGGER.debug("Processing headers to get token values.");

        String accessToken = wrapper.getHeader(ACCESS_TOKEN_HEADER);
        if (StringUtils.isEmpty(accessToken) || !accessToken.startsWith(PREFIX)) {
            LOGGER.debug("No Bearer token found.");
            TokenHolder.clearAccessToken();
        } else {
            LOGGER.debug("Bearer token found, storing for future usage.");
            TokenHolder.setAccessToken(accessToken.replace(PREFIX, ""));
        }

        try {
            chain.doFilter(request, response);
        } finally {
            LOGGER.debug("Cleaning up token values");
            TokenHolder.clearAccessToken();
        }
    }

}
