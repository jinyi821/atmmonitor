package com.ultrapower.dcs.cluster.control.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.RequestContextFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@WebFilter(urlPatterns = "/")
public class ActionNameFilter extends RequestContextFilter {

    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.endsWith(".jsp")) {
            if (uri.endsWith("run-overview.jsp")){
                uri="/runOverview/";
            }
            if (uri.endsWith("scanner-monitor.jsp")){
                uri="/scannerMonitor/";
            }
            if (uri.endsWith("probe-running/currentprobe-tasklist.jsp")){
                uri="/probeRunning/currentProbeTaskList/";
            }
            if (uri.endsWith("probe-running/deal-failurefile.jsp")){
                uri="/probeRunning/dealFailureFile/";
            }
            if (uri.endsWith("currentday-collectionfiles.jsp")){
                uri="/currentDayCollectionFiles/";
            }
            if (uri.endsWith("historyfiles.jsp")){
                uri="/historyFiles/";
            }
            if (uri.endsWith("dcs-ftpserver.jsp")){
                uri="/dcsFtpServer/";
            }
            if (uri.endsWith("dcs-datatype.jsp")){
                uri="/dcsDataType/";
            }
            if (uri.endsWith("cluster-restart-manage.jsp")){
                uri="/restartManage/clusterRestartManage/";
            }
            if (uri.endsWith("dcs-user-manager.jsp")){
                uri="/dcsUserManager/";
            }
            request.getRequestDispatcher(uri).forward(request,response);

        } else {
            super.doFilterInternal(request, response, filterChain);
        }
    }
}