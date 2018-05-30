<!doctype html>
<html lang="ch">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>集群控制管理系统</title>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
 <link rel="stylesheet" type="text/css" href="css/common.css" />
 <link rel="stylesheet" type="text/css" href="css/slide.css" />
 <link rel="stylesheet" type="text/css" href="css/flat-ui.min.css" />
 <link rel="stylesheet" type="text/css" href="css/jquery.nouislider.css">
 <script>
            $(function() {
                $(".meun-item").click(function() {
                    $(".meun-item").removeClass("meun-item-active");
                    $(this).addClass("meun-item-active");
                    var itmeObj = $(".meun-item").find("img");
                    itmeObj.each(function() {
                        var items = $(this).attr("src");
                        items = items.replace("_grey.png", ".png");
                        items = items.replace(".png", "_grey.png")
                        $(this).attr("src", items);
                    });
                    var attrObj = $(this).find("img").attr("src");
                    ;
                    attrObj = attrObj.replace("_grey.png", ".png");
                    $(this).find("img").attr("src", attrObj);
                });
               /*  $("#topAD").click(function() {
                    $("#topA").toggleClass(" glyphicon-triangle-right");
                    $("#topA").toggleClass(" glyphicon-triangle-bottom");
                });
                $("#topBD").click(function() {
                    $("#topB").toggleClass(" glyphicon-triangle-right");
                    $("#topB").toggleClass(" glyphicon-triangle-bottom");
                });
                $("#topCD").click(function() {
                    $("#topC").toggleClass(" glyphicon-triangle-right");
                    $("#topC").toggleClass(" glyphicon-triangle-bottom");
                }); */
                $(".toggle-btn").click(function() {
                    $("#leftMeun").toggleClass("show");
                    $("#rightContent").toggleClass("pd0px");
                })
            })
        </script>
<style type="text/css">
.jumbotron {
min-height:5%;
padding-top:0px;
margin-bottom:0px;
border-bottom:1px solid #354457;
color:#333;
background-color:#333;
}
</style>
</head>
<body style="color:#333;">  <!--data-spy="scroll" data-target="#myScrollspy"  -->
<div class="container" style="min-height:100%;min-width:100%;width:100%;height:100%;padding:0px;">
	<div class="jumbotron" style="border-radius:0px;padding-left:15px;">
	   <div style="display:inline-block;float:left;"><span style="font-size:20px;text-decoration:none;color:#fff">集群控制管理系统</span></div>
       <div id="personInfor" style="float:right;border:none;">admin &nbsp;&nbsp;&nbsp;<a>退出登录</a> </div>       
       <!-- <div style="display:inline-block;float:right;">admin &nbsp;&nbsp;
       	<button type="button" class="btn btn-info btn-sm">退出</button>  
        </div> -->
    </div>
      <div id="wrap" sytle="min-height:95%;min-width:95%;">
            <!-- 左侧菜单栏目块 -->
            <div class="leftMeun" id="leftMeun">
                <div id="logoDiv">
                    <p id="logoP"><img id="logo" alt="导航菜单" src="images/logo.png"><span>导航菜单</span></p>
                </div>
                <div class="meun-title">账号管理</div>
                <div class="meun-item meun-item-active" href="#sour" aria-controls="sour" role="tab" data-toggle="tab"><img src="images/icon_source.png">资源管理</div>
                <div class="meun-item" href="#char" aria-controls="char" role="tab" data-toggle="tab"><img src="images/icon_chara_grey.png">权限管理</div>
                <div class="meun-item" href="#user" aria-controls="user" role="tab" data-toggle="tab"><img src="images/icon_user_grey.png">用户管理</div>
                <div class="meun-item" href="#chan" aria-controls="chan" role="tab" data-toggle="tab"><img src="images/icon_change_grey.png">修改密码</div>
                <div class="meun-title">地区管理</div>
                <div class="meun-item" href="#scho" aria-controls="scho" role="tab" data-toggle="tab"><img src="images/icon_house_grey.png">地区管理</div>
                <div class="meun-item" href="#regu" aria-controls="regu" role="tab" data-toggle="tab"><img src="images/icon_rule_grey.png">规则管理</div>
                <div class="meun-item" href="#stud" aria-controls="stud" role="tab" data-toggle="tab"><img src="images/icon_card_grey.png">人员信息</div>
                <div class="meun-item" href="#sitt" aria-controls="sitt" role="tab" data-toggle="tab"><img src="images/icon_char_grey.png">座位管理</div>
            </div> 
             <!-- 右侧具体内容栏目 -->
            <div id="rightContent">
               <a class="toggle-btn" id="nimei">
                  <i class="glyphicon glyphicon-align-justify"></i>
                </a>
                <!-- Tab panes -->
                <div class="tab-content">
                   <div role="tabpanel" class="tab-pane active" id="sour">
                                                         资源管理
                   </div>                             
                   <div role="tabpanel" class="tab-pane" id="char">
                                                          权限管理模块
                   </div>         
                 <div role="tabpanel" class="tab-pane" id="user">  
                                                        用户管理模块                  
                 </div>
         </div>
    </div>
</div>
</div>
</body>
</html>