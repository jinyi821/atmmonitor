package com.common.core.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.common.constants.Constants;
import com.common.core.component.rquery.core.SqlResult;
import com.portal.model.UserLoginInfo;
import com.usermanager.model.BsMenu;
import com.usermanager.services.BsUserMenuService;
import com.usermanager.services.BsVistRecordeService;


public class WebActionContextFilter implements Filter
{
    private static Log logger= LogFactory.getLog(WebActionContextFilter.class);
    public void destroy()
    {

    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException,
            ServletException
    {
            logger.info("doFilter begin");
            //是否登录拦截
            if (loginIntercepter(arg0,arg1,chain)) {
                return ;        
            }
            ActionContext.setContext(createActionContext(arg0, arg1, "", "", null, null));
          //写入登录日志   
            writeBsVistRecorde(arg0);
            chain.doFilter(arg0, arg1);
            ActionContext.clear();
            logger.info("doFilter end");

    }
 
    /**
     * 

     * <p>Discription:[登录拦截]</p>
     * @param arg0
     * @param arg1

     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    private boolean loginIntercepter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
    {
        logger.info("loginIntercepter begin");
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        HttpSession session = request.getSession();
        
        String url = request.getServletPath();
        
        if (request.getQueryString() != null) {
            url=url+"?"+request.getQueryString();
        }
        
        logger.info("url="+url);
        
        if (session.getAttribute(Constants.USERSESSION) == null)
        {
            logger.info("url="+url+" 没有登录");
            if (url.indexOf("portal/userLogin.action") > -1 || url.indexOf("portal/login.action") > -1 
            	|| url.indexOf("portal/oaLogin.action") > -1
                || url.indexOf("portal/sendValidateCode.action") > -1 
                || url.indexOf("portal/userValidateCodeLogin.action") > -1 
                || url.indexOf("portal/singleLogin.action") > -1 
                || url.indexOf("portal/oldlogin.action") > -1 
                || url.indexOf("tableauReportView.action") > -1 
                || url.indexOf("bsUserUnfreezeApplyLoad.action")>-1
                || url.indexOf("bsUserUnfreezeApplySave.action")>-1
                || url.indexOf("loginnnameExist.action")>-1
                || url.indexOf("bsUserUnfreezeJudgeWhetherTriggerApply.action")>-1
                || url.indexOf("rest/sms/send.action")>-1
              )
            {
                //登录界面无需拦截
                logger.info("url="+url+"不拦截");
                return false; 
            }
            else
            {
                try
                {
                    String path = request.getContextPath() + "/portal/login.action";
                    session.setAttribute(Constants.REDIRECT_URL, url);
                    logger.info("url="+url+"拦截被跳转");
                    response.sendRedirect(path);
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();

                }
                return true;
            }
        }
        else
        {
            //是否受限访问
            if (IsControlMenu(request)){
                
                String path = request.getContextPath() + "/portal/error.jsp";
                try
                {
                    response.sendRedirect(path);
                }
                catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                logger.info("url="+url+"受限访问拦截");
                return true;
            }
            logger.info("url="+url+" 已经登录不拦截");
            //已登录无需拦截
            return false;
        }

    }
    
    /**
     * 
     * 
     * <p>Discription:[访问链接是否有权限]</p>
     * @param request
     * @return

     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    private Boolean IsControlMenu(HttpServletRequest request){
        
        HttpSession session = request.getSession();
        UserLoginInfo userLoginInfo = (UserLoginInfo)session.getAttribute(Constants.USERSESSION);
        
        ServletContext sc = request.getSession().getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(sc);
        BsUserMenuService service = (BsUserMenuService) webApplicationContext
                .getBean("bsUserMenuService");
        
        String url = request.getServletPath().substring(1);
        
        BsMenu menuByurl = service.getMenuByurl(userLoginInfo.getLoginname(), url);
        if (menuByurl!=null){
            return false;
        }
       
        return service.IsControlMenu(userLoginInfo.getLoginname(), url);
        
    }

   


    /**
     * 保存数据
     * @param arg0
     * @param arg1
     * @param resId 资源ID
     * @param opId 操作ID
     * @param sqlResult 数据权限对象
     * @return
     */
    private ActionContext createActionContext(ServletRequest arg0, ServletResponse arg1, String resId, String opId,
            SqlResult sqlResult, Map valueMap)
    {
        ActionContext ctx;

        HashMap hash = new HashMap();
        hash.put(ActionContext.HTTP_REQUEST, arg0);
        //	hash.put(ActionContext.HTTP_RESOURCE,resId);
        //		hash.put(ActionContext.HTTP_OPERATE,opId);
        ctx = new ActionContext(hash);
        return ctx;
    }

    public void init(FilterConfig arg0) throws ServletException
    {
    }
    /**
     * 
     * Created on 2016-3-23 
     * <p>Discription:[记录访问日志]</p>
     * @param arg0
     * @author:<a href=21990173@qq.com>jinyi</a>
     * @update:[日期YYYY-MM-DD] [更改人姓名]
     */
    private void writeBsVistRecorde(ServletRequest re)
    {
        HttpServletRequest request = (HttpServletRequest) re;

        ServletContext sc = request.getSession().getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(sc);
        BsVistRecordeService bsVistRecordeService = (BsVistRecordeService) webApplicationContext
                .getBean("bsVistRecordeService");

        String url = request.getServletPath().substring(1);
        
        UserLoginInfo userLoginInfo=(UserLoginInfo)request.getSession().getAttribute(Constants.USERSESSION);
        if (userLoginInfo==null){
            
            return ;
        }
        String loginname =userLoginInfo.getLoginname();
        //插入访问记录
        bsVistRecordeService.addBsVistRecorde(url, loginname);

    }


}
