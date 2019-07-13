package com.shuoyi.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

/**
 * Created by zhaosy-c on 2019/7/12.
 */
public class AccessFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        com.netflix.zuul.context.RequestContext currentContext = com.netflix.zuul.context.RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessToken");
        if(null == accessToken){
            logger.error("access token is empty");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            return null;
        }
        logger.info("access token ok");
        return null;
    }
}
