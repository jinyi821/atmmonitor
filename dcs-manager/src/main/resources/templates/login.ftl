<!DOCTYPE html>
<html lang="en-us" id="extr-page">
	<head>
		<meta charset="utf-8">
		<title>DCS集群管理系统</title>
        <base href="${BASE_PATH}/smartadmin/" />
		<meta name="description" content="">
		<meta name="author" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		
		<!-- #CSS Links -->
		<!-- Basic Styles -->
        <link href="${BASE_PATH}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${BASE_PATH}/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="${BASE_PATH}/css/toastr.css" rel="stylesheet"/>

		<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
		<link rel="stylesheet" type="text/css" media="screen" href="${BASE_PATH}/smartadmin/css/smartadmin-production-plugins.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="${BASE_PATH}/smartadmin/css/smartadmin-production.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="${BASE_PATH}/smartadmin/css/smartadmin-skins.min.css">

		<!-- SmartAdmin RTL Support -->
		<link rel="stylesheet" type="text/css" media="screen" href="${BASE_PATH}/smartadmin/css/smartadmin-rtl.min.css">

		<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
		<link rel="stylesheet" type="text/css" media="screen" href="${BASE_PATH}/smartadmin/css/demo.min.css">

		<!-- #FAVICONS -->
		<link rel="shortcut icon" href="${BASE_PATH}/images/favicon.ico" type="image/x-icon">
		<link rel="icon" href="${BASE_PATH}/images/favicon.ico" type="image/x-icon">

	


	</head>
	
	<body class="animated fadeInDown">

		<header id="header">

			<div id="logo-group">
				<span id="logo"> <img src="${BASE_PATH}/images/logo.png" alt="DCS管理系统"> </span>
			</div>

		

		</header>

		<div id="main"  style="min-height:575px" role="main">

			<!-- MAIN CONTENT -->
			<div id="content" class="container">

				<div class="row">

                    <div class="col-md-offset-4 col-md-4">
						<div class="well no-padding">
							<form id="loginform" action="login" method="post"  class="smart-form client-form">
								<header>
									登录
								</header>

								<fieldset>
									
									<section>
										<label class="label">管理员名</label>
										<label class="input"> <i class="icon-append fa fa-user"></i>
											<input type="text" id="loginname" name="loginname">
											<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i> 请输入管理员名</b></label>
									</section>

									<section>
										<label class="label">密码</label>
										<label class="input"> <i class="icon-append fa fa-lock"></i>
											<input type="password" id="password" name="password">
											<b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i> 输入密码</b> </label>
										<div class="note">
										
										</div>
									</section>

								
								</fieldset>
								<footer>
									<button type="submit" class="btn btn-primary" >
										登录
									</button>
								</footer>
							</form>

						</div>
						
					
						
					</div>
				</div>
			</div>

		</div>

		<!--================================================== -->	

		<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
        <script data-pace-options='{ "restartOnRequestAfter": true }' src="${BASE_PATH}/smartadmin/js/plugin/pace/pace.min.js"></script>

        <!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
        <script src="${BASE_PATH}/js/jquery.min.js"></script>
        <script>
            if (!window.jQuery) {
                document.write('<script src="${BASE_PATH}/smartadmin/js/libs/jquery-3.2.1.min.js"><\/script>');
            }
        </script>

        <script src="${BASE_PATH}/js/jquery-ui.min.js"></script>
        <script>
            if (!window.jQuery.ui) {
                document.write('<script src="${BASE_PATH}/smartadmin/js/libs/jquery-ui.min.js"><\/script>');
            }
        </script>
	   

		<!-- IMPORTANT: APP CONFIG -->
		<script src="${BASE_PATH}/smartadmin/js/app.config.js"></script>

		<!-- JS TOUCH : include this plugin for mobile drag / drop touch events 		
		<script src="js/plugin/jquery-touch/jquery.ui.touch-punch.min.js"></script> -->

		<!-- BOOTSTRAP JS -->
		<script src="${BASE_PATH}/smartadmin/js/bootstrap/bootstrap.min.js"></script>

		<#--<!-- JQUERY VALIDATE &ndash;&gt;-->
		<script src="${BASE_PATH}/smartadmin/js/plugin/jquery-validate/jquery.validate.min.js"></script>

		<!-- JQUERY MASKED INPUT -->
		<#--<script src="smartadmin/js/plugin/masked-input/jquery.maskedinput.min.js"></script>-->
		
		<!--[if IE 8]>
			
			<h1>Your browser is out of date, please update your browser by going to www.microsoft.com/download</h1>
			
		<![endif]-->

		<!-- MAIN APP JS FILE -->
		<script src="${BASE_PATH}/smartadmin/js/app.min.js"></script>
        <!-- CUSTOM NOTIFICATION -->
        <script src="${BASE_PATH}/smartadmin/js/notification/SmartNotification.min.js"></script>
		<script>
            //toastr.options.positionClass = 'toast-bottom-center';
            var BASE_PATH = "${BASE_PATH}";
//            function showWarnMessage(message){
//                $.bigBox({
//                    title : "信息",
//                    content : message,
//                    color : "#C46A69",
//                    //timeout: 6000,
//                    icon : "fa fa-warning shake animated",
//                    timeout : 6000
//                });
//
//            }
//            function showMessage(message) {
//
//                $.bigBox({
//                    title : "提示",
//                    content : message,
//                    color : "#739E73",
//                    timeout: 3000,
//                    sound: "disabled",
//                    icon : "fa fa-check"
//
//                }, function() {
//                    //closedthis();
//                });
//
//            }
            function login() {



                    var loginname = $("#loginname").val();
                    var pwd = $("#password").val();
                    var user = {
                        loginname: loginname,
                        pwd: pwd
                    };
                    $.ajax({
                        type: "post",
                        url: BASE_PATH + "/login",
                        data: user,
                        async: false,
                        success: function (result) {
                            
                            if (result == "1") {
                                showMessage("登录成功!");
                               // toastr.info("登录成功!");
                                //window.location.href = BASE_PATH + "/index"
                                window.location.href = BASE_PATH + "/run-overview.jsp"
                            } else {
                                //toastr.info("用户名和密码不正确!");
                                showWarnMessage("用户名和密码不正确");
                            }

                        }

                    });
             

            }
			//runAllForms();
           
			$(function() {

                // Validation
                $("#loginform").validate({
                    submitHandler:function(form){
                        login();
                        //form.submit();
                    },
                    // Rules for form validation
                    rules: {
                        loginname: {
                            required: true
                        },
                        password: {
                            required: true,
                            minlength: 3,
                            maxlength: 20
                        }
                    },

                    // Messages for form validation
                    messages: {
                        loginname: {
                            required: '请输入用户名'

                        },
                        password: {
                            required: '请输入密码'
                        }
                    },

                    // Do not change code below
                    errorPlacement: function (error, element) {
                        error.insertAfter(element.parent());
                    }

                });
            });
		</script>

	</body>
</html>
<script>
    function showWarnMessage(message){
        $.bigBox({
            title : "信息",
            content : message,
            color : "#C46A69",
            //timeout: 6000,
            icon : "fa fa-warning shake animated",
            timeout : 6000
        });

    }
    function showMessage(message) {

        $.bigBox({
            title : "提示",
            content : message,
            color : "#739E73",
            timeout: 3000,
            sound: "disabled",
            icon : "fa fa-check"

        }, function() {
            //closedthis();
        });

    }
</script>