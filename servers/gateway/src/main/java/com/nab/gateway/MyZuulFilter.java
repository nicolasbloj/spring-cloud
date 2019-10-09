package com.nab.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import javax.servlet.http.HttpServletRequest;

@NoArgsConstructor
@Log4j2
public class MyZuulFilter extends ZuulFilter {

    private static final String FILTERTYPE = "pre";
    private static final Integer FILTERORDER = 1;

    @Override
    public String filterType() {
        return FILTERTYPE;
    }

    @Override
    public int filterOrder() {
        return FILTERORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        log.info("{} petición a {}", request.getMethod(), request.getRequestURL().toString());
        return null;
    }
}
