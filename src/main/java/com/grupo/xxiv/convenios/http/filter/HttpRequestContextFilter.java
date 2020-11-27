package com.grupo.xxiv.convenios.http.filter;

import common.http.filter.HttpRequestContextFilterImpl;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HttpRequestContextFilter extends HttpRequestContextFilterImpl {

}
