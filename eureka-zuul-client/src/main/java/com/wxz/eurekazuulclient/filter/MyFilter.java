package com.wxz.eurekazuulclient.filter;

import com.netflix.zuul.ZuulFilter;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 自定义的过滤器
 * @author Wangxingze
 * @date 2019-08-24 14:26
 */
@Component
public class MyFilter extends ZuulFilter {

    private static final Logger log=LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {
        return PRE_TYPE;        //一共四种类型
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER-1;    //执行顺序，越小越先执行
    }

    @Override
    public boolean shouldFilter() {
        return true;   //是否要执行run方法
    }

    @Override
    public Object run() throws ZuulException {
        //RequestContext用于共享client-request的数据，clientrequest是http-client创建的请求
        RequestContext requestContext=RequestContext.getCurrentContext();
        HttpServletRequest request=requestContext.getRequest();
        if (request.getParameter("token")==null){
            if (log.isDebugEnabled()){  //提前避免字符串总是进行拼接，带来无用消耗
                log.warn("token is empty");
            }
            requestContext.setSendZuulResponse(false);//不再继续路由到服务
            requestContext.setResponseStatusCode(401); //返回状态码401
            try {
                requestContext.getResponse().getWriter().write("token is empty");//向浏览器输出
            }
            catch (IOException e){
                return null;
            }
        }
        log.info("OK!");
        return null;
    }
}
