<!DOCTYPE html>
<html lang="en-us">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <base href="${BASE_PATH}/smartadmin/" />
    <title>DCS集群管理系统</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <!-- Basic Styles -->
    <link rel="stylesheet" type="text/css" media="screen" href="${BASE_PATH}/smartadmin/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" media="screen" href="${BASE_PATH}/smartadmin/css/font-awesome.min.css">

    <!-- SmartAdmin Styles : Caution! DO NOT change the order -->
    <link rel="stylesheet" type="text/css" media="screen" href="${BASE_PATH}/smartadmin/css/smartadmin-production-plugins.min.css">
    <link rel="stylesheet" type="text/css" media="screen" href="${BASE_PATH}/smartadmin/css/smartadmin-production.min.css">
    <link rel="stylesheet" type="text/css" media="screen" href="${BASE_PATH}/smartadmin/css/smartadmin-skins.min.css">

    <!-- SmartAdmin RTL Support  -->
    <link rel="stylesheet" type="text/css" media="screen" href="${BASE_PATH}/smartadmin/css/smartadmin-rtl.min.css">

    <!-- We recommend you use "your_style.css" to override SmartAdmin
         specific styles this will also ensure you retrain your customization with each SmartAdmin update.
    <link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

    <!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
    <link rel="stylesheet" type="text/css" media="screen" href="${BASE_PATH}/smartadmin/css/demo.min.css">

    <!-- FAVICONS -->
    <link rel="shortcut icon" href="${BASE_PATH}/images/favicon.ico" type="image/x-icon">
    <link rel="icon" href="${BASE_PATH}/images/favicon.ico" type="image/x-icon">

    <!-- GOOGLE FONT -->
    <link rel="stylesheet" href="${BASE_PATH}/smartadmin/css/gooleFontCss.css">

    <!-- Specifying a Webpage Icon for Web Clip
         Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
    <link rel="apple-touch-icon" href="${BASE_PATH}/smartadmin/img/splash/sptouch-icon-iphone.png">
    <link rel="apple-touch-icon" sizes="76x76" href="${BASE_PATH}/smartadmin/img/splash/touch-icon-ipad.png">
    <link rel="apple-touch-icon" sizes="120x120" href="${BASE_PATH}/smartadmin/img/splash/touch-icon-iphone-retina.png">
    <link rel="apple-touch-icon" sizes="152x152" href="${BASE_PATH}/smartadmin/img/splash/touch-icon-ipad-retina.png">
    <link href="${BASE_PATH}/css/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
    <link href="${BASE_PATH}/css/dcs-manager-common.css" rel="stylesheet"/>
    <!--<link href="${BASE_PATH}/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css" rel="stylesheet">
     -->
    <style>
        .login-info a span{text-transform:none; }
    </style>
    <#--<link href="${BASE_PATH}/css/toastr.css" rel="stylesheet"/>-->
    <#--<link rel="stylesheet" type="text/css" href="${BASE_PATH}/layui/css/layui.css">-->

</head>
<body class="">

<!-- HEADER -->
<header id="header">
    <div id="logo-group">
        <!-- PLACE YOUR LOGO HERE -->
        <span id="logo"> <img src="${BASE_PATH}/images/logo.png" alt="SmartAdmin"> </span>
    </div>

    <!-- pulled right: nav area -->
    <div class="pull-right">
        <!-- collapse menu button -->
        <div id="hide-menu" class="btn-header pull-right">
            <span> <a href="javascript:void(0);" data-action="toggleMenu" title="折叠菜单"><i class="fa fa-reorder"></i></a> </span>
        </div>
        <!-- end collapse menu -->

        <!-- #MOBILE -->
        <!-- Top menu profile link : this shows only when top menu is active -->
        <ul id="mobile-profile-img" class="header-dropdown-list hidden-xs padding-5">
            <li class="">
                <a href="#" class="dropdown-toggle no-margin userdropdown" data-toggle="dropdown">
                    <img src="${BASE_PATH}/smartadmin/img/avatars/sunny.png" alt="John Doe" class="online" />
                </a>
                <ul class="dropdown-menu pull-right">
                    <li class="divider"></li>
                    <li>
                        <a href="javascript:void(0);" class="padding-10 padding-top-0 padding-bottom-0" data-action="launchFullscreen"><i class="fa fa-arrows-alt"></i> Full <u>S</u>creen</a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="login.html" class="padding-10 padding-top-5 padding-bottom-5" data-action="userLogout"><i class="fa fa-sign-out fa-lg"></i> <strong><u>L</u>ogout</strong></a>
                    </li>
                </ul>
            </li>
        </ul>

        <!-- logout button -->
        <div id="logout" class="btn-header transparent pull-right">
            <span> <a href="javascript:void(0)" onclick="showDi('是否退出系统?', function(){logout()})" title="退出" ><i class="fa fa-sign-out"></i></a> </span>
        </div>
        <!-- end logout button -->


        <!-- fullscreen button -->
        <div id="fullscreen" class="btn-header transparent pull-right">
            <span> <a href="javascript:void(0);" data-action="launchFullscreen" title="全屏"><i class="fa fa-arrows-alt"></i></a> </span>
        </div>
        <!-- end fullscreen button -->

    </div>
    <!-- end pulled right: nav area -->

</header>
<!-- END HEADER -->

<!-- Left panel : Navigation area -->
<!-- Note: This width of the aside area can be adjusted through LESS variables -->
<aside id="left-panel">

    <!-- User info -->
    <div class="login-info" >
				<span> <!-- User image size is adjusted inside CSS, it should stay as it -->

					<a href="javascript:void(0);" id="show-shortcut" >  <!--data-action="toggleShortcut"-->
						<img src="${BASE_PATH}/smartadmin/img/avatars/sunny.png" alt="me" class="online" />
						<span style="text-transform:lowercase">
                        <#if loginUser ??>
                            ${loginUser.loginname}
                        </#if>
						</span>
						<i class="fa fa-angle-down"></i>
					</a>

				</span>
    </div>
    <!-- end user info -->

    <!-- NAVIGATION : This navigation is also responsive-->
    <nav>
        <ul>
            <li class="open">
                <a href="#" title="Dashboard"><i class="fa fa-lg fa-fw fa-cloud"></i> <span class="menu-item-parent">集群情况</span></a>
                <ul style="display: block;">
                    <li class="active">
                        <a href="javascript:void(0);" ><span class="menu-item-parent" onclick="goFunPage('runOverview','#runOverview','集群情况#运行概览',this);" >运行概览</span></a>
                    </li>
                  
                    <li>
                        <a href="javascript:void(0);" ><span class="menu-item-parent"    onclick="goFunPage('scannerMonitor','#scannerMonitor','集群情况#Scanner监控',this);">Scanner监控</span></a>
                    </li>
                    <li>
                        <a href="#">Probe运行情况</a>
                        <ul>

                            <li>
                                <a href="javascript:void(0);"><span class="menu-item-parent" onclick="goFunPage('currentProbeTask','#probeRunning#currentProbeTaskList','集群情况#Probe运行情况#当前采集任务',this);">当前采集任务</span></a>
                            </li>
                            <li>
                                <a href="javascript:void(0);"><span class="menu-item-parent" onclick="goFunPage('probeFailureFile','#probeRunning#dealFailureFile','集群情况#Probe运行情况#采集失败列表',this);">采集失败列表</span></a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">采集历史 </a>
                        <ul>

                            <li>
                                <a href="javascript:void(0)"
                                   onclick="goFunPage('currentDayCollectionFiles','#currentDayCollectionFiles','采集历史#当日采集文件列表',this);"
                                ><i class="menu-item-parent fa fa-fw"></i> 当日采集文件列表</a>
                            </li>
                            <li>
                                <a href="javascript:void(0)"
                                   onclick="goFunPage('historyFiles','#historyFiles','采集历史#历史文件列表',this);"
                                ><i class="menu-item-parent fa fa-fw"></i> 历史文件列表</a>
                            </li>
                        </ul>
                    </li>

                </ul>
            </li>
            <li class="top-menu-invisible">
                <a href="#"><i class="fa fa-lg fa-fw fa-list-alt"></i> <span class="menu-item-parent">任务配置</span></a>
                <ul>

                    <li>
                        <a href="javascript:void(0)"
                           onclick="goFunPage('dcsFtpServer','#dcsFtpServer','任务配置#FTP元数据配置',this);"><span class="menu-item-parent">FTP元数据配置</span></a>
                    </li>
                    <li>
                        <a href="javascript:void(0)" onclick="goFunPage('dcsDataType','#dcsDataType','任务配置#数据文件元数据',this);"><span class="menu-item-parent">数据文件元数据</span></a>
                    </li>
                    <#--<li>-->
                        <#--<a href="javascript:void(0)" onclick="goFunPage('dcsFtpTypeRel','#dcsFtpTypeRel','任务配置#FTP服务器数据类型配置',this);"><span class="menu-item-parent">FTP服务器数据类型配置</span></a>-->
                    <#--</li>-->
                </ul>
            </li>
            <li class="top-menu-invisible">
                <a href="#"><i class="fa fa-lg fa-fw  fa-magnet"></i> <span class="menu-item-parent">集群管理</span></a>
                <ul>
                    <li>
                        <a href="javascript:void(0);"  id="clusterRestart" onclick="goFunPage('clusterRestart','#restartManage#clusterRestartManage','集群管理#重启管理',this);" ><span class="menu-item-parent">重启管理</span></a>
                    </li>
                </ul>
            </li>
            <#if loginUser ?? && loginUser.isadmin==1>
            <li class="top-menu-invisible">
                <a href="javascript:void(0);"
                   onclick="goFunPage('dcsUserManager','#dcsUserManager','用户管理',this);"
                ><i class="fa fa-lg fa-fw fa-male" aria-hidden="true"></i> <span class="menu-item-parent">用户管理</span></a>
                
            </li>
            </#if>
        </ul>
    </nav>
    <span class="minifyme" data-action="minifyMenu">
				<i class="fa fa-arrow-circle-left hit"></i>
			</span>

</aside>
<!-- END NAVIGATION -->

<!-- MAIN PANEL -->
<div id="main" role="main">
    <!-- RIBBON -->
    <div id="ribbon">
           <span class="ribbon-button-alignment">
					<span id="refresh" class="btn btn-ribbon"  data-title="refresh"  rel="tooltip" data-placement="bottom" data-original-title="刷新" data-html="true" onclick="refreshPage();">
						<i class="fa fa-refresh"></i>
					</span>
	</span>

        <!-- breadcrumb -->
        <ol class="breadcrumb">
            <li id="1FunTitle"></li>
            <li id="2FunTitle"></li>
            <li id="3FunTitle"></li>
        </ol>
        <!-- end breadcrumb -->

    </div>
    <!-- END RIBBON -->

    <!-- MAIN CONTENT -->
    <div id="content">
    </div>
    <!-- END MAIN CONTENT -->

</div>
<!-- END MAIN PANEL -->

<!-- PAGE FOOTER -->
<div class="page-footer">
    <div class="row">
        <div class="col-xs-12 col-sm-6">
            <span class="txt-color-white">@CopyRight 2017-2019</span>
        </div>
    </div>
</div>
<!-- END PAGE FOOTER -->


<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
<script data-pace-options='{ "restartOnRequestAfter": true }' src="${BASE_PATH}/smartadmin/js/plugin/pace/pace.min.js"></script>

<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->

<script src="${BASE_PATH}/smartadmin/js/libs/jquery-3.2.1.min.js"></script>
<script src="${BASE_PATH}/smartadmin/js/libs/jquery.ui.datepicker-zh-CN.js"></script>

<script src="${BASE_PATH}/smartadmin/js/libs/jquery-ui.min.js"></script>

<!-- IMPORTANT: APP CONFIG -->
<script src="${BASE_PATH}/smartadmin/js/app.config.js"></script>

<!-- JS TOUCH : include this plugin for mobile drag / drop touch events-->
<script src="${BASE_PATH}/smartadmin/js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script>

<!-- BOOTSTRAP JS -->
<script src="${BASE_PATH}/smartadmin/js/bootstrap/bootstrap.min.js"></script>

<!-- CUSTOM NOTIFICATION -->
<script src="${BASE_PATH}/smartadmin/js/notification/SmartNotification.min.js"></script>

<!-- JARVIS WIDGETS -->
<script src="${BASE_PATH}/smartadmin/js/smartwidgets/jarvis.widget.min.js"></script>

<!-- EASY PIE CHARTS -->
<script src="${BASE_PATH}/smartadmin/js/plugin/easy-pie-chart/jquery.easy-pie-chart.min.js"></script>

<!-- SPARKLINES -->
<script src="${BASE_PATH}/smartadmin/js/plugin/sparkline/jquery.sparkline.min.js"></script>

<!-- JQUERY VALIDATE -->
<script src="${BASE_PATH}/smartadmin/js/plugin/jquery-validate/jquery.validate.min.js"></script>

<!-- JQUERY MASKED INPUT -->
<script src="${BASE_PATH}/smartadmin/js/plugin/masked-input/jquery.maskedinput.min.js"></script>

<!-- JQUERY SELECT2 INPUT -->
<script src="${BASE_PATH}/smartadmin/js/plugin/select2/select2.min.js"></script>

<!-- JQUERY UI + Bootstrap Slider -->
<script src="${BASE_PATH}/smartadmin/js/plugin/bootstrap-slider/bootstrap-slider.min.js"></script>

<!-- browser msie issue fix -->
<script src="${BASE_PATH}/smartadmin/js/plugin/msie-fix/jquery.mb.browser.min.js"></script>

<!-- FastClick: For mobile devices -->
<script src="${BASE_PATH}/smartadmin/js/plugin/fastclick/fastclick.min.js"></script>

<!--[if IE 8]>

<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>

<![endif]-->

<!-- Demo purpose only -->
<#--<script src="${BASE_PATH}/smartadmin/js/demo.min.js"></script>-->



<script src="${BASE_PATH}/smartadmin/js/app.min.js"></script>

<!-- ENHANCEMENT PLUGINS : NOT A REQUIREMENT -->

<script src="${BASE_PATH}/smartadmin/js/speech/voicecommand.min.js"></script>

<!-- SmartChat UI : plugin -->
<script src="${BASE_PATH}/smartadmin/js/smart-chat-ui/smart.chat.ui.min.js"></script>
<script src="${BASE_PATH}/smartadmin/js/smart-chat-ui/smart.chat.manager.min.js"></script>

<!-- PAGE RELATED PLUGIN(S) -->

<!-- Flot Chart Plugin: Flot Engine, Flot Resizer, Flot Tooltip -->
<script src="${BASE_PATH}/smartadmin/js/plugin/flot/jquery.flot.cust.min.js"></script>
<script src="${BASE_PATH}/smartadmin/js/plugin/flot/jquery.flot.resize.min.js"></script>
<script src="${BASE_PATH}/smartadmin/js/plugin/flot/jquery.flot.time.min.js"></script>
<script src="${BASE_PATH}/smartadmin/js/plugin/flot/jquery.flot.tooltip.min.js"></script>

<!-- Vector Maps Plugin: Vectormap engine, Vectormap language -->
<script src="${BASE_PATH}/smartadmin/js/plugin/vectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${BASE_PATH}/smartadmin/js/plugin/vectormap/jquery-jvectormap-world-mill-en.js"></script>

<!-- Full Calendar -->
<script src="${BASE_PATH}/smartadmin/js/plugin/moment/moment.min.js"></script>
<script src="${BASE_PATH}/smartadmin/js/plugin/fullcalendar/fullcalendar.min.js"></script>
<#--<script src="${BASE_PATH}/layui/layui.js"></script>-->
<script src="${BASE_PATH}/smartadmin/js/plugin/bootstrapvalidator/bootstrapValidator.min.js"></script>
<script src="${BASE_PATH}/smartadmin/js/plugin/bootstrap-timepicker/bootstrap-timepicker.min.js"></script>
<script src="${BASE_PATH}/smartadmin/js/plugin/bootstrap-timepicker/bootstrap-timepicker.min.js"></script>
<#--<script src="${BASE_PATH}/js/dcs-manager-common.js"></script>-->
<script>
    var BASE_PATH = "${BASE_PATH}";
    var    oldURL="";
    function defaultFunPage(){
        var  defaultTargetHref="#runOverview";
        var  defaultTargetFunction="集群情况#运行概览";
        var funArray=defaultTargetFunction.split("#");
        $(".breadcrumb").html("");
        var content="";
        for(var i=0;i<funArray.length;i++){
            var n=i+1;
            if (content==""){
                content="<li>"+funArray[i]+"</li>";
            }else {
                content=content+"<li>"+funArray[i]+"</li>"
            }
        }
        $(".breadcrumb").html(content);
        // $("#mainContent").html(loadingHtml);
        var   targetHref = defaultTargetHref.substring(1);
        targetHref = targetHref.replace("#", "/");

        $("#content").load("${BASE_PATH}/" + targetHref + "/", {}, function (txt) {
            if (!txt) {
            }
        })
        oldURL= "${BASE_PATH}/" + targetHref + "/";


    };




    function  goFunPage(targetTabId,targetHref,targetFunction,ref){
       
        var funArray=targetFunction.split("#");
        var content="";
        for(var i=0;i<funArray.length;i++){
            var n=i+1;
            if (content==""){
                content="<li>"+funArray[i]+"</li>";
            }else {
                content=content+"<li>"+funArray[i]+"</li>";
            }
        }
        $(".breadcrumb").html(content);
        // $("#mainContent").html(loadingHtml);
        targetHref = targetHref.substring(1);
        targetHref = targetHref.replace("#", "/");
       // $(ref).parentsUntil("ul").css({"color":"red","border":"2px solid red"});
        $(ref).parents().find(".active").removeClass("active");
        $(ref).parentsUntil("ul").addClass("active")
        $("#content").load("${BASE_PATH}/" + targetHref + "/", {}, function (txt) {
            if (!txt) {
            }

        })
        oldURL= "${BASE_PATH}/" + targetHref + "/";
    };
     function refreshPage(){
          
         $("#content").load( oldURL, {}, function (txt) {
             if (!txt) {
             }

         })
     }

    $(document).ready(function() {

        // DO NOT REMOVE : GLOBAL FUNCTIONS!
        pageSetUp();

        /*
         * PAGE RELATED SCRIPTS
         */

        $(".js-status-update a").click(function() {
            var selText = $(this).text();
            var $this = $(this);
            $this.parents('.btn-group').find('.dropdown-toggle').html(selText + ' <span class="caret"></span>');
            $this.parents('.dropdown-menu').find('li').removeClass('active');
            $this.parent().addClass('active');
        });

        /*
        * TODO: add a way to add more todo's to list
        */

        // initialize sortable
        $(function() {
            $("#sortable1, #sortable2").sortable({
                handle : '.handle',
                connectWith : ".todo",
                update : countTasks
            }).disableSelection();
        });

        // check and uncheck
        $('.todo .checkbox > input[type="checkbox"]').click(function() {
            var $this = $(this).parent().parent().parent();

            if ($(this).prop('checked')) {
                $this.addClass("complete");

                // remove this if you want to undo a check list once checked
                //$(this).attr("disabled", true);
                $(this).parent().hide();

                // once clicked - add class, copy to memory then remove and add to sortable3
                $this.slideUp(500, function() {
                    $this.clone().prependTo("#sortable3").effect("highlight", {}, 800);
                    $this.remove();
                    countTasks();
                });
            } else {
                // insert undo code here...
            }

        })

        // count tasks
        function countTasks() {

            $('.todo-group-title').each(function() {
                var $this = $(this);
                $this.find(".num-of-tasks").text($this.next().find("li").size());
            });
        }
        defaultFunPage();
    });
    

</script>

<!-- Your GOOGLE ANALYTICS CODE Below -->
<script>
    function showDi(message, f) {

        $.SmartMessageBox({
            title : "提示信息",
            content : message,
            buttons : '[否][是]'
        }, function(ButtonPressed) {
            if (ButtonPressed === "是") {

                f();
            }
            if (ButtonPressed === "否") {

            }

        });
    }
    function logout(){

        $.ajax({
            type: "post",
            url: BASE_PATH+"/logout",
            async: false,
            success: function (result) {
               
                if (result=="1"){
                    //toastr.info("退出登录成功!");
                    window.location.href= BASE_PATH+"/"
                } else {
                   // toastr.info("退出登录失败!");
                }

            }

        });
    }
    (function ($) {
        //同样先备份下jquery的load方法
        var _load = $.fn.load;
        $.fn.extend({
            load: function (url, param, calbck) {

                param.loadAjax=true;

                calbck = function (response, status, xhr) {

                    if ( response=='nologinUser'){

                        window.location.href = BASE_PATH + "/"
                    }

                   // console.info("calbck");
                }
                //其他操作和处理
                //..
                //此处用apply方法调用原来的load方法，因为load方法属于对象，所以不可直接对象._load（...）
                // console.info("----load old----")
                var old = _load.apply(this, [url, param, calbck]);

                return old;

            }
        });


    })
    (jQuery);
    

</script>

</body>

</html>