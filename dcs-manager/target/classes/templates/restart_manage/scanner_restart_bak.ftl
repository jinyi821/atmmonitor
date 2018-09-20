<#--<!doctype html>
<html lang="ch">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>集群控制管理系统</title>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 &ndash;&gt;
<script type="text/javascript" src="${BASE_PATH}/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 &ndash;&gt;
<script type="text/javascript" src="${BASE_PATH}/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${BASE_PATH}/css/common.css"/>
<link type="text/css"  href="${BASE_PATH}/css/bootstrap.min.css" rel="stylesheet"> --> <#--不要在引入样式，否则改写父页面样式，导致头部变形-->
<style>
    .row{
     padding-left:15px;
     padding-right:15px;
    }

    .toolBar{
        padding:5px 0px 50px 10px;
        margin-top:5px;
        border-bottom:1px solid #e5e5e5;
        /*#box-shadow:inset 0px 1px 0px #fbfbfb;
        -webkit-box-shadow:0 1px 0 #FBFBFB inset;*/
    }

    .btn{
        border:1px solid rgb(62, 172, 39);
        border-image:none;
        color:rgb(255, 255, 255);
        background-color:rgb(74, 175, 51);
    }

    .btn_primary {
        padding: 0px 36px;
        border-radius: 5px;
        height: 35px;
        text-align: center;
        line-height: 35px;
        overflow: visible;
        font-size：14px;
        text-decoration: none;
        vertical-align: middle;
        display: inline-block;
        cursor：pointer;
        -webkit-border-radius: 5px;
        -moz-border-radius: 5px;
    }

    .apply-finish{
        text-align: center;
        font-family: 微软雅黑;
    }

    .apply-finish-header{
        padding-top:50px;
    }

    .apply-finish-msg{
        font-weight: bold;
        font-size: 24px;
        color: #009899;
        margin-top: 30px;
    }

    ul{
        margin: 0;
        padding: 0;
    }

    li{
        margin: 0;
        padding: 0;
    }

    #myTab li{
        width:25%;
        float:left;
        height:40px;
        list-style: none;
        margin: 0;
        padding: 0;
    }

    #myTab li img{
        float:left;
        height: 40px;
    }

    #myTab li a{
        color:white;
        text-align: center;
        position: relative;
        display: block;
        padding: 10px 15px;
    }

    .blue{
        background:#0f9af2;
    }
    .gray{
        background: #dfdfdf;
    }
    .tabPaneUl{
        width: 700px;
        margin: 0 auto;
        list-style: none;
    }

    .tabPaneUl li{
        height: 40px;
        line-height: 40px;
    }
    .tab-pane{
        margin-top: 50px;
    }
</style>
<script>
    var scanStopValidateFlag="false";
    var scanStopProcessFlag="false";
    var scanStartValidateFlag="false";
    var scanStartProcessFlag="false";
    $(document).ready(function(){

    });
    //dom操作
    var domFun={
    };
    //事件操作
    var eventFun={
        setStep:function(index){
           if(index==2 && scanStopValidateFlag=="true"){
               changeStepAndContent(index);
           }
          if(index==3 && scanStopProcessFlag=="true"&&scanStartValidateFlag=="true"){
              changeStepAndContent(index);
          }
          if(index==4 && scanStartProcessFlag=="true"){
              changeStepAndContent(index);

          }
        }
    };
   function changeStepAndContent(index){
       for(var i=2;i<=index;i++){
           $("#step"+i+"Li").addClass("blue").removeClass("gray");
           $("#step"+i+"Img").attr("src","${BASE_PATH}/images/blue_blue.png");
       }
       for(var i=index+1;i<=4;i++){
           $("#step"+i+"Li").addClass("gray").removeClass("blue");
           $("#step"+i+"Img").attr("src","${BASE_PATH}/images/gray_gray.png");
       }
       $("#step"+(index+1)+"Img").attr("src","${BASE_PATH}/images/blue_gray.png");
       //对兄弟节点及自身节点样式内容的处理
       $("#step"+index).siblings().removeClass("active");
       $("#step"+index).siblings().removeClass("in");
       $("#step"+index).addClass("active");
       $("#step"+index).addClass("in");
       $("#step"+index+" .tablebody").empty();
   }
    function scanStopValidate(){
        $.ajax({
            type: "get",
            url: "${BASE_PATH}/restartManage/scanRestart/scanStopPreProcess",    //向后端请求数据的url
            async:false,
            data: {},
            success: function (data) {
                scanStopValidateFlag=data;
                if(scanStopValidateFlag=="true"){
                    /*  var html = [];
                      //html.push('<div class="evaluate_content">');
                      html.push('<div class="evaluate_left">');
                      html.push('</div>');
                      html.push('<div class="evaluate_right">');
                      html.push('</div>');
                      html.push('<div class="ClearFloat"></div>');
                      html.push('</div>');
                      var divchild= $('<div class="evaluate_content">');
                      divchild.data("obj", obj);*/
                    //divchild.html(html.join(''));
                    // div.append(divchild);
                    var html = [];
                    html.push('<div class="row">scan停止前环境条件已具备，可进入下一步scan停止操作！</div>');
                    $("#step1 .tablebody").append(html.join(''));
                }else{
                    var html = [];
                    html.push('<div class="row">scan停止前环境条件尚不具备，请检查停止scan相关server是否已停止！</div>');
                    $("#step1 .tablebody").append(html.join(''));
                }
            }
        })
    };
    function  scanStopProcess(){
        $.ajax({
            type: "get",
            url: "${BASE_PATH}/restartManage/scanRestart/scanStopProcess",    //向后端请求数据的url
            async:true,
            data: {},
            success: function (data) {
                var shellExecList=eval(data);
                var html = [];
                for(var i=0;i<shellExecList.length;i++){
                    var shellExecBody=shellExecList[i];
                    html.push('<div class="row">'+shellExecBody.shellCmd+'</div>');
                    html.push('<div class="row">'+shellExecBody.resResult+'</div>');
                }
                $("#step2 .tablebody").append(html.join(''));
                scanStopProcessFlag="true";
            }
        })
    };

    function scanStartValidate(){
        $.ajax({
            type: "get",
            url: "${BASE_PATH}/restartManage/scanRestart/scanStartPreProcess",    //向后端请求数据的url
            async:true,
            data: {},
            success: function (data) {
                scanStartValidateFlag=data;
                var html = [];
                if(scanStartValidateFlag=="true"){
                    html.push('<div class="row">scan启动前环境条件已具备，可进入下一步scan启动操作！</div>');
                    eventFun.setStep(3);
                }else{
                    var html = [];
                    html.push('<div class="row">scan启动前环境条件尚不具备，请检查停止scan相关server是否已启动！</div>');
                }
                $("#step2 .tablebody").append(html.join(''));
            }
        })
    };
    function  scanStartProcess(){
        $.ajax({
            type: "get",
            url: "${BASE_PATH}/restartManage/scanRestart/scanStartProcess",    //向后端请求数据的url
            async:true,
            data: {},
            success: function (data) {
                var shellExecList=eval(data);
                var html = [];
                for(var i=0;i<shellExecList.length;i++){
                    var shellExecBody=shellExecList[i];
                    html.push('<div class="row">'+shellExecBody.shellCmd+'</div>');
                    html.push('<div class="row">'+shellExecBody.resResult+'</div>');
                }
                $("#step3 .tablebody").append(html.join(''));
                scanStartProcessFlag="true";
            }
        })
    };
</script>
<#--</head>
<body>-->
<div id="page-inner" style="margin-top:-50px;">
    <div class="row" style="padding:10px;background: #bebebe">
        <div class="col-md-12">
            <div class="input-group" style="width: 60%; float: left;font-size: 20px;font-weight: bolder;">
              scan重启
            </div>
        </div>
    </div>
    <div class="row" style="margin-top:0px">
        <ul id="myTab" role="tablist">
            <li id="step1Li" class="active blue">
                <a href="javascript:void(0);"  onclick="eventFun.setStep(1)" role="tab" data-toggle="tab">
                    开始
                </a>
            </li>
            <li id="step2Li"  class="gray">
                <img id="step2Img" src="${BASE_PATH}/images/blue_gray.png"/>
                <a href="javascript:void(0);"   role="tab" data-toggle="tab">停止</a>
            </li>
            <li id="step3Li"  class="gray">
                <img id="step3Img" src="${BASE_PATH}/images/gray_gray.png"/>
                <a href="javascript:void(0);"   role="tab" data-toggle="tab">
                   启动
                </a>
            </li>
            <li id="step4Li"  class="gray">
                <img id="step4Img" src="${BASE_PATH}/images/gray_gray.png"/>
                <a href="javascript:void(0);"   role="tab" data-toggle="tab">
                   完成
                </a>
            </li>
        </ul>
        <div id="myTabContent" class="tab-content">
            <div id="step1" class="tab-pane fade active in">
                <div class="toolBar">
                    <a class="btn btn_primary" id="nextBtn"  style="float:left;" href="javascript:void(0);"  onclick="javascript:scanStopValidate();" >停止前验证</a>
                   <a class="btn btn_primary mt20" style="float:right;margin-right: 10px;" href="javascript:eventFun.setStep(2);">进入下一步</a>
                </div>
                <div class="tablebody">
                  <div class="row">scan重启流程分停止、启动及相关校验验证操作，请按步骤流程操作！</div>
                </div>
            </div>
            <div id="step2" class="tab-pane fade">
                <div class="toolBar">
                    <a class="btn btn_primary" id="nextBtn"  style="float:left;" href="javascript:void(0);"  onclick="javascript:scanStopProcess();" >停止</a>
                    <a class="btn btn_primary mt20" style="float:right;margin-right: 10px;" href="javascript:scanStartValidate();">进入下一步</a>
                </div>
                <div class="tablebody">
                <#--<div class="row">scan停止前环境条件已具备，可进入下一步scan停止操作！</div>-->
                </div>
            </div>
            <div id="step3" class="tab-pane fade">
                <div class="toolBar">
                    <a class="btn btn_primary" id="nextBtn"  style="float:left;" href="javascript:void(0);"  onclick="javascript:scanStartProcess();" >启动</a>
                    <a class="btn btn_primary mt20" style="float:right;margin-right: 10px;" href="javascript:eventFun.setStep(4);">进入下一步</a>
                </div>
                <div class="tablebody">
                <#--<div class="row">scan停止前环境条件已具备，可进入下一步scan停止操作！</div>-->
                </div>
            </div>
            <div id="step4" class="tab-pane fade">
                <div class="apply-finish">
                    <div class="apply-finish-header">
                        <img src="${BASE_PATH}/images/success.png">
                        <div class="apply-finish-msg">恭喜您，已完成本次scan重启流程操作！</div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<#--</body>
</html>-->

