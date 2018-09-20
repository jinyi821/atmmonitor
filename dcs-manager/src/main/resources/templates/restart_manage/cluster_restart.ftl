<#--<!doctype html>
<html lang="ch">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>集群控制管理系统</title>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 &ndash;&gt;
<script type="text/javascript" src="${BASE_PATH}/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件&ndash;&gt;
<script type="text/javascript" src="${BASE_PATH}/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${BASE_PATH}/css/common.css"/>
<link type="text/css"  href="${BASE_PATH}/css/bootstrap.min.css" rel="stylesheet"> --><#--不要在引入样式，否则改写父页面样式，导致头部变形-->
<style>
    .btn{
    min-width:200px;
    }
    .tablebody {
        margin: 10px 30px;
        text-align: left;
    }
    .tablebody .row {
        margin-top: 5px;
        background-color: #fff;
        height: 35px;
        line-height: 35px;
    }
    .row{
        padding-left:15px;
        padding-right:15px;
    }
    .toolBar{
        padding:5px 0px 10px 10px;
        margin-top:5px;
        border-bottom:1px solid #e5e5e5;
        /*#box-shadow:inset 0px 1px 0px #fbfbfb;
        -webkit-box-shadow:0 1px 0 #FBFBFB inset;*/
    }

    .transition {
        -moz-transition: all .3s ease;
        -webkit-transition: all .3s ease;
        transition: all .3s ease;
    }
    .tab {
        height: 60px;
        line-height: 60px;
        text-align: center;
        font-size: 24px;
        background-color: #F5F5F5;
        box-sizing: border-box;
        /*border-right: 1px solid #e5e5e5;*/
        /* border-left: none; */
        position: relative;
        cursor: default;
        width: 15%;
        float:left;
        /* margin-right: 0px; */
    }
    .nav-tabs>li.active>a,.nav-tabs>li.active>a:focus,.nav-tabs>li.active>a:hover{
        color:#555;
        cursor:default;
        background-color:#20B09F;
        border:1px solid #20B09F;
        border-bottom-color:transparent
    }
    .nav>li>a:hover{
        text-decoration:none;
        background-color:#20B09F
    }

    .tab.active {
        background-color: #20B09F;
        color: #fff;
    }

    .tab.active:after {
        content: "";
        position: absolute;
        width: 0;
        height: 0;
        border: 11px solid;
        border-color: #20B09F transparent transparent transparent;
        bottom: -22px;
        left: 50%;
        transform: translateX(-50%);
        transition: all .3s ease;
    }{
        content: "";
        position: absolute;
        width: 0;
        height: 0;
        border: 11px solid;
        border-color: #20B09F transparent transparent transparent;
        bottom: -22px;
        left: 50%;
        transform: translateX(-50%);
        transition: all .3s ease;
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
        margin-top:50px;
    }
    .cmd-row{
        color: #646987!important;
        background-color: #e3e8ee!important;
    }
    .stage-row{
        background-color: #e0f5f1!important;
        border-top: 1px solid #e6e6e6!important;
        border-bottom: 1px solid #e6e6e6!important;
    }
    .stage-success-content{
       /* background-color:#c1e2b3!important;
        border-color:#4cae4c!important*/
    }

    .stage-common-content{
       /* border: 1px solid #A8E0DC!important;
        background-color: #F2FFFC!important;*/
    }

    .stage-warn-content{
        /*border-color: greenyellow!important;
        background-*/
        color:#ff0!important;
    }
    .stage-error-content{
        /*border: 1px solid red!important;
        background-*/
        color:red!important;
    }


</style>
<script>
    $(document).ready(function(){
     /*  $('#clusterStop').click(function() {
           clusterStopProcess();
         });
          $('#clusterStart').bind('click', function() {
              clusterStartProcess();
        });
        $('#clusterRestart').bind('click', function() {
            clusterRestartProcess();
        });*/
    });
    //dom操作
    var domFun={   };
    function  clusterStopProcess(){
        /*bootsrap禁用用按钮*/
        $("#clusterStop").addClass("disabled");
        $("#clusterStop").prop("disabled", true);
        $("#clusterStop").siblings().prop("disabled", true);
        $("#clusterStop").button('loading');

        $("#mainTab .tablebody").empty();
        $.ajax({
            type: "get",
            url: "${BASE_PATH}/restartManage/clusterRestart/clusterStopProcess",    //向后端请求数据的url
            cache:false,  //get方式相同参数请求，易产生缓存；用此参数设置清除缓存
            async:false,
            data: {},
            success: function (data) {
                var shellExecList=eval(data);
                var html = [];
                html.push('<div class="row">cluster停止执行命令及响应信息</div>');
                var shellUsesArray=[];
                var shellSubUsesArray=[];
                for(var i=0;i<shellExecList.length;i++){
                    var shellExecBody=shellExecList[i];
                    var resResult=shellExecBody.resResult;
                    var resConclusion=shellExecBody.resConclusion;
                    var stageContentLevel="stage-"+shellExecBody.resResultLevel+"-content";
                    var  usesStage=shellExecBody.shellUses;
                    var  subUsesStage=shellExecBody.shellSubUses;
                    var  usesStageExist=$.inArray(usesStage,shellUsesArray);
                    if(usesStageExist==-1){
                        shellUsesArray.push(usesStage);
                        shellSubUsesArray=[];
                        var usesSeq=shellUsesArray.length;
                        html.push('<div class="row cmd-row">'+usesSeq+"、"+usesStage+'</div>');
                    }
                    if(subUsesStage!=""&&subUsesStage!=usesStage){
                        shellSubUsesArray.push(subUsesStage);
                        var subUsesSeq=shellSubUsesArray.length;
                        html.push('<div class="row cmd-row ">('+subUsesSeq+")、"+subUsesStage+'</div>');
                    }

                    html.push('<div class="row cmd-row ">'+formatDateTime(shellExecBody.shellExecTime)+' '+shellExecBody.shellCmd+'</div>');
                    if(resResult!=""){
                        html.push('<div class="row cmd-row '+stageContentLevel+'">'+resResult+'</div>');
                    }
                    if(resConclusion!=""){
                        html.push('<div class="row cmd-row '+stageContentLevel+'">'+resConclusion+'</div>');
                    }
                }
                $("#mainTab .tablebody").html(html.join(''));
                /*bootsrap启用按钮*/
                $("#clusterStop").removeClass("disabled");
                $("#clusterStop").prop("disabled",false);
                $("#clusterStop").siblings().prop("disabled", false);
                $("#clusterStop").button('reset');
            }
        })
    };

    function  clusterStartProcess(){
        $("#clusterStart").addClass("disabled");
        $("#clusterStart").prop("disabled", true);
        $("#clusterStart").siblings().prop("disabled", true);
        $("#clusterStart").button('loading');

        $("#mainTab .tablebody").empty();
        $.ajax({
            type: "get",
            url: "${BASE_PATH}/restartManage/clusterRestart/clusterStartProcess",    //向后端请求数据的url
            cache:false,  //get方式相同参数请求，易产生缓存；用此参数设置清除缓存
            async:false,
            data: {},
            success: function (data) {
                var shellExecList=eval(data);
                var html = [];
                html.push('<div class="row">cluster启动执行命令及响应信息</div>');
                var shellUsesArray=[];
                var shellSubUsesArray=[];
                for(var i=0;i<shellExecList.length;i++){
                    var shellExecBody=shellExecList[i];
                    var resResult=shellExecBody.resResult;
                    var resConclusion=shellExecBody.resConclusion;
                    var stageContentLevel="stage-"+shellExecBody.resResultLevel+"-content";
                    var  usesStage=shellExecBody.shellUses;
                    var  subUsesStage=shellExecBody.shellSubUses;
                    var  usesStageExist=$.inArray(usesStage,shellUsesArray);
                    if(usesStageExist==-1){
                        shellUsesArray.push(usesStage);
                        shellSubUsesArray=[];
                        var usesSeq=shellUsesArray.length;
                        html.push('<div class="row cmd-row">'+usesSeq+"、"+usesStage+'</div>');
                    }
                    if(subUsesStage!=""&&subUsesStage!=usesStage){
                        shellSubUsesArray.push(subUsesStage);
                        var subUsesSeq=shellSubUsesArray.length;
                        html.push('<div class="row cmd-row">('+subUsesSeq+")、"+subUsesStage+'</div>');
                    }

                    html.push('<div class="row cmd-row">'+formatDateTime(shellExecBody.shellExecTime)+' '+shellExecBody.shellCmd+'</div>');
                    if(resResult!=""){
                        html.push('<div class="row cmd-row '+stageContentLevel+'">'+resResult+'</div>');
                    }
                    if(resConclusion!=""){
                        html.push('<div class="row cmd-row '+stageContentLevel+'">'+resConclusion+'</div>');
                    }
                }
                $("#mainTab .tablebody").html(html.join(''));
                $("#clusterStart").removeClass("disabled");
                $("#clusterStart").prop("disabled",false);
                $("#clusterStart").siblings().prop("disabled", false);
                $("#clusterStart").button('reset');
            }
        })
    };

    function  clusterRestartProcess(){
        $("#clusterRestart").addClass("disabled");
        $("#clusterRestart").prop("disabled",true);
        $("#clusterRestart").siblings().prop("disabled", true);
        $("#clusterRestart").button('loading');

        $("#mainTab .tablebody").empty();
        $.ajax({
            type: "get",
            url: "${BASE_PATH}/restartManage/clusterRestart/clusterRestartProcess",    //向后端请求数据的url
            cache:false,  //get方式相同参数请求，易产生缓存；用此参数设置清除缓存
            async:false,
            data: {},
            success: function (data) {
                var shellExecList=eval(data);
                var html = [];
                html.push('<div class="row">cluster启动执行命令及响应信息</div>');
                var shellUsesArray=[];
                var shellSubUsesArray=[];
                for(var i=0;i<shellExecList.length;i++){
                    var shellExecBody=shellExecList[i];
                    var resResult=shellExecBody.resResult;
                    var resConclusion=shellExecBody.resConclusion;
                    var stageContentLevel="stage-"+shellExecBody.resResultLevel+"-content";
                    var  usesStage=shellExecBody.shellUses;
                    var  subUsesStage=shellExecBody.shellSubUses;
                    var  usesStageExist=$.inArray(usesStage,shellUsesArray);
                    if(usesStageExist==-1){
                        shellUsesArray.push(usesStage);
                        shellSubUsesArray=[];
                        var usesSeq=shellUsesArray.length;
                        html.push('<div class="row cmd-row">'+usesSeq+"、"+usesStage+'</div>');
                    }
                    if(subUsesStage!=""&&subUsesStage!=usesStage){
                        shellSubUsesArray.push(subUsesStage);
                        var subUsesSeq=shellSubUsesArray.length;
                        html.push('<div class="row cmd-row">('+subUsesSeq+")、"+subUsesStage+'</div>');
                    }

                    html.push('<div class="row cmd-row">'+formatDateTime(shellExecBody.shellExecTime)+' '+shellExecBody.shellCmd+'</div>');
                    if(resResult!=""){
                        html.push('<div class="row cmd-row '+stageContentLevel+'">'+resResult+'</div>');
                    }
                    if(resConclusion!=""){
                        html.push('<div class="row cmd-row '+stageContentLevel+'">'+resConclusion+'</div>');
                    }
                }
                $("#mainTab .tablebody").html(html.join(''));
                $("#clusterRestart").removeClass("disabled");
                $("#clusterRestart").prop("disabled",false);
                $("#clusterRestart").siblings().prop("disabled", false);
                $("#clusterRestart").button('reset');
            }
        })
    }
    function formatDateTime(inputTime) {
        var date = new Date(inputTime);
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
         m = m < 10 ? ('0' + m) : m;
        var d = date.getDate();
       d = d < 10 ? ('0' + d) : d;
       var h = date.getHours();
       h = h < 10 ? ('0' + h) : h;
       var minute = date.getMinutes();
       var second = date.getSeconds();
       minute = minute < 10 ? ('0' + minute) : minute;
       second = second < 10 ? ('0' + second) : second;
       return y + '-' + m + '-' + d+' '+h+':'+minute+':'+second;
  };
</script>
<#--</head>
<body>-->
<div id="page-inner" style="margin-top:-50px;">
    <#--<div class="row" style="padding:10px;background: #bebebe">
        <div class="col-md-12">
            <div class="input-group" style="width: 60%; float: left;font-size: 20px;font-weight: bolder;">
                cluster重启
            </div>
        </div>
    </div>-->
    <div class="row" style="margin-top:15px;">
        <div class="toolBar">
        &nbsp;&nbsp;<div id="clusterStop" title="" onClick="clusterStopProcess();"  class="btn btn-success" data-loading-text="停止进行中..." data-original-title="">停止</div>
        &nbsp;&nbsp;&nbsp;&nbsp; <div id="clusterStart" onClick="clusterStartProcess();"  title="" class="btn btn-success" data-loading-text="启动进行中..." data-original-title="">启动</div>
        &nbsp;&nbsp;&nbsp;&nbsp;<div id="clusterRestart" onClick="clusterRestartProcess();"  title="" class="btn btn-success" data-loading-text="重启进行中..." data-original-title="">重启</div>
        </div>
    </div>
     <div id="myTabContent" class="tab-content">
            <div id="mainTab" class="tab-pane fade active in" style="margin-top:0px;">
                <div class="tablebody">
                </div>
            </div>
        </div>
    </div>
<#--
</body>
</html>-->