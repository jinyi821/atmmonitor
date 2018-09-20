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

<script src="${BASE_PATH}/wizardAce/ace.min.js"></script>
<script src="${BASE_PATH}/wizardAce/ace-elements.min.js"></script>
<script src="${BASE_PATH}/wizardAce/ace-extra.min.js"></script>
<script src="${BASE_PATH}/wizardAce/bootbox.js"></script>
<script src="${BASE_PATH}/wizardAce/wizard.min.js"></script>

<link type="text/css"  href="${BASE_PATH}/wizardAce/font-awesome.min.css" rel="stylesheet">
<link type="text/css"  href="${BASE_PATH}/wizardAce/fonts.googleapis.com.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen" href="${BASE_PATH}/smartadmin/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" media="screen" href="${BASE_PATH}/smartadmin/css/smartadmin-production.min.css">
<link type="text/css"  href="${BASE_PATH}/wizardAce/ace.min.css" rel="stylesheet">
<link type="text/css"  href="${BASE_PATH}/wizardAce/ace-rtl.min.css" rel="stylesheet">
<link type="text/css"  href="${BASE_PATH}/wizardAce/ace-skins.min.css" rel="stylesheet">



<script type="text/javascript">
            jQuery(function($) {
                var $validation = false;
                $('#fuelux-wizard-container')
                        .ace_wizard({
                            //step: 2 //optional argument. wizard will jump to step "2" at first
                            //buttons: '.wizard-actions:eq(0)'
                        })
                        .on('actionclicked.fu.wizard' , function(e, info){
                            if(info.step == 1 && $validation) {
                                /*if(!$('#validation-form').valid())
                                    e.preventDefault();*/
                            }
                        })
                        //.on('changed.fu.wizard', function() {
                        //})
                        .on('finished.fu.wizard', function(e) {
                            bootbox.dialog({
                                message: "Thank you! Your information was successfully saved!",
                                buttons: {
                                    "success" : {
                                        "label" : "OK",
                                        "className" : "btn-sm btn-primary"
                                    }
                                }
                            });
                        }).on('stepclick.fu.wizard', function(e){
                    //e.preventDefault();//this will prevent clicking and selecting steps
                });


                //jump to a step
                /**
                 var wizard = $('#fuelux-wizard-container').data('fu.wizard')
                 wizard.currentStep = 3;
                 wizard.setState();
                 */

                //determine selected step
                //wizard.selectedItem().step



                //hide or show the other form which requires validation
                //this is for demo only, you usullay want just one form in your application
                /*$('#skip-validation').removeAttr('checked').on('click', function(){
                    $validation = this.checked;
                    if(this.checked) {
                        $('#sample-form').hide();
                        $('#validation-form').removeClass('hide');
                    }
                    else {
                        $('#validation-form').addClass('hide');
                        $('#sample-form').show();
                    }
                })*/

                //documentation : http://docs.jquery.com/Plugins/Validation/validate

                $('#modal-wizard-container').ace_wizard();
                $('#modal-wizard .wizard-actions .btn[data-dismiss=modal]').removeAttr('disabled');
           })

            function changeDefaultRelSteps(targetId){
                var  serverChooseVal="none";
                var  probeChooseVal="none";
                var operateChooseVal="none";
                //自身项及相关项
                var target=$("#"+targetId);
                 if(targetId=="serverChoose") {
                     var targetValue = target.val();
                     serverChooseVal=targetValue;
                     if (targetValue == "probe") {
                         $("#probeChooseDiv").show();
                     } else {
                         $("#probeChooseDiv").hide();
                     }
                     operateChooseVal=$("#operateChoose").val();
                 }else if(targetId=="operateChoose"){
                     operateChooseVal=target.val();
                     serverChooseVal=$("#serverChoose").val();
                 }else{
                     serverChooseVal=$("#serverChoose").val();
                     operateChooseVal=$("#operateChoose").val();
                 }
                //steps项
                var stepsId="default";
                if(operateChooseVal!="none"){
                    operateChooseVal=operateChooseVal.substring(0,1).toUpperCase( )+operateChooseVal.substring(1); //首字母大写
                   if(serverChooseVal=="cluster"){
                       stepsId="cluster"+operateChooseVal;
                   }else  if(serverChooseVal!="none"){
                       stepsId="common"+operateChooseVal;
                   }
                }
                $("#"+stepsId).siblings().hide();
                $("#"+stepsId+" li").removeClass("active");
                $("#"+stepsId).show();
                //$("#"+stepsId).children("li:first-child").addClass("active");
                $("#stepPaneContent").empty();
            };
       function execProcess(){
           var  serverChooseVal=$("#serverChoose").val();
           var  probeChooseVal=$("#probeChoose").val();
           var  operateChooseVal=$("#operateChoose").val();
           var  execContinueFlag=false;
          if(operateChooseVal!="none"&&operateChooseVal!="none"){

              if(serverChooseVal!="probe"){
                  execContinueFlag=true;
              }else{
                  if(probeChooseVal!="none"){
                  execContinueFlag=true;
                  }else{
                  execContinueFlag=false;
                  alert("请选择probe选项！");
                  return;
                  }
              }
          }else{
            execContinueFlag=false;
            alert("请选择集群Server和操作选项！");
            return ;
          }
          if(execContinueFlag){ //满足执行可持续flag,进行下一项
              $("#execProcess").addClass("disabled");
              $("#execProcess").prop("disabled",true);
             //steps项
              var stepsId="default";
              if(operateChooseVal!="none"){
               var operateChooseStepVal=operateChooseVal.substring(0,1).toUpperCase( )+operateChooseVal.substring(1); //首字母大写
                  if(serverChooseVal=="cluster"){
                      stepsId="cluster"+operateChooseStepVal;
                  }else  if(serverChooseVal!="none"){
                      stepsId="common"+operateChooseStepVal;
                  }
              }
              if(operateChooseVal=="stop"){
                  if(serverChooseVal!="cluster"){ //非集群停止操作
                      $("#"+stepsId+' li').eq(0).addClass("active");
                      var  stopValidateProcessFlag=stopValidateProcess(serverChooseVal,probeChooseVal);
                      if(stopValidateProcessFlag){
                       $("#stepPaneContent").attr("data-step","1");
                       $("#"+stepsId+' li').eq(0).removeClass("active");
                       $("#"+stepsId+' li').eq(0).addClass("complete");
                       $("#"+stepsId+' li').eq(1).addClass("active");
                       var  stopProcessFlag=stopProcess(serverChooseVal,probeChooseVal);
                       if(stopProcessFlag){
                        $("#"+stepsId+' li').eq(1).removeClass("active");
                        $("#"+stepsId+' li').eq(1).addClass("complete");
                      }

                      }
                  }else{ //集群停止操作
                      $("#"+stepsId+' li').eq(0).addClass("active");
                      var  stopProcessFlag=stopProcess(serverChooseVal,probeChooseVal);
                      if(stopProcessFlag){
                          $("#stepPaneContent").attr("data-step","1");
                          $("#"+stepsId+' li').eq(0).removeClass("active");
                          $("#"+stepsId+' li').eq(0).addClass("complete");
                          $("#"+stepsId+' li').eq(1).addClass("complete");
                      }
                  }
              };
              if(operateChooseVal=="start"){
                  if(serverChooseVal!="cluster"){ //非集群启动操作
                      $("#"+stepsId+' li').eq(0).addClass("active");
                      var  startValidateProcessFlag=startValidateProcess(serverChooseVal,probeChooseVal);
                      if(startValidateProcessFlag){
                          $("#stepPaneContent").attr("data-step","1");
                          $("#"+stepsId+' li').eq(0).removeClass("active");
                          $("#"+stepsId+' li').eq(0).addClass("complete");
                          $("#"+stepsId+' li').eq(1).removeClass("active");
                          var  startProcessFlag=startProcess(serverChooseVal,probeChooseVal);
                          if(startProcessFlag){
                              $("#"+stepsId+' li').eq(1).removeClass("active");
                              $("#"+stepsId+' li').eq(1).addClass("complete");
                          }

                      }
                  }else{ //集群启动操作
                      $("#"+stepsId+' li').eq(0).addClass("active");
                      var  startProcessFlag=startProcess(serverChooseVal,probeChooseVal);
                      if(startProcessFlag){
                          $("#stepPaneContent").attr("data-step","1");
                          $("#"+stepsId+' li').eq(0).removeClass("active");
                          $("#"+stepsId+' li').eq(0).addClass("complete");
                          $("#"+stepsId+' li').eq(1).addClass("complete");
                      }
                  }
              };
              if(operateChooseVal=="restart"){
                  if(serverChooseVal!="cluster"){ //非集群重启操作
                      $("#"+stepsId+' li').eq(0).addClass("active");
                      var  stopValidateProcessFlag=stopValidateProcess(serverChooseVal,probeChooseVal);
                      var  stopProcessFlag=false;
                      var  startValidateProcessFlag=false;
                      if(stopValidateProcessFlag){
                          $("#stepPaneContent").attr("data-step","1");
                          $("#"+stepsId+' li').eq(0).removeClass("active");
                          $("#"+stepsId+' li').eq(0).addClass("complete");
                          $("#"+stepsId+' li').eq(1).addClass("active");
                          stopProcessFlag=stopProcess(serverChooseVal,probeChooseVal);
                      }
                      if(stopProcessFlag){
                          $("#stepPaneContent").attr("data-step","2");
                          $("#"+stepsId+' li').eq(1).removeClass("active");
                          $("#"+stepsId+' li').eq(1).addClass("complete");
                          $("#"+stepsId+' li').eq(2).addClass("active");
                          startValidateProcessFlag=startValidateProcess(serverChooseVal,probeChooseVal);
                      }
                      if(startValidateProcessFlag){
                          $("#stepPaneContent").attr("data-step","3");
                          $("#"+stepsId+' li').eq(2).removeClass("active");
                          $("#"+stepsId+' li').eq(2).addClass("complete");
                          $("#"+stepsId+' li').eq(3).addClass("active");
                          var  startProcessFlag=startProcess(serverChooseVal,probeChooseVal);
                          if(startProcessFlag){
                          $("#"+stepsId+' li').eq(3).removeClass("active");
                          $("#"+stepsId+' li').eq(3).addClass("complete");
                          }
                      }
                  }else{ //集群重启操作
                   $("#"+stepsId+' li').eq(0).addClass("active");
                   var stopProcessFlag=stopProcess(serverChooseVal,probeChooseVal);
                    if(stopProcessFlag){
                        $("#stepPaneContent").attr("data-step","1");
                        $("#"+stepsId+' li').eq(0).removeClass("active");
                        $("#"+stepsId+' li').eq(0).addClass("complete");
                        $("#"+stepsId+' li').eq(1).addClass("active");
                        var  startProcessFlag=startProcess(serverChooseVal,probeChooseVal);
                        if(startProcessFlag){
                            $("#"+stepsId+' li').eq(1).removeClass("active");
                            $("#"+stepsId+' li').eq(1).addClass("complete");
                        }
                    }
                  }
              };
              $("#execProcess").removeClass("disabled");
              $("#execProcess").prop("disabled",false);
          }
       }

            //停止前校验server处理
            function stopValidateProcess(serverChooseVal,probeChooseVal){
                var stopValidateProcessFlag=false;
                var url="${BASE_PATH}/restartManage/"+serverChooseVal+"Restart/"+serverChooseVal+"StopPreValidateProcess";
                $("#stepPaneContent").empty();
                $.ajax({
                    type: "get",
                    url: url,    //向后端请求数据的url
                    cache:false,  //get方式相同参数请求，易产生缓存；用此参数设置清除缓存
                    async:false,
                    data: {},
                    success: function (data) {
                        var batchShellExecRes=eval(data);
                        var shellExecList=batchShellExecRes.shellExecList;
                        stopValidateProcessFlag=batchShellExecRes.batchExecResultFlag;
                        var html = [];
                        html.push('<div class="row">'+serverChooseVal+'停止校验执行命令及响应信息</div>');
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
                        $("#stepPaneContent").html(html.join(''));                    }
                });
                return stopValidateProcessFlag;
            };

            //停止server处理
            function  stopProcess(serverChooseVal,probeChooseVal){
                var stopProcessFlag=false;
                var url="${BASE_PATH}/restartManage/"+serverChooseVal+"Restart/"+serverChooseVal+"StopProcess";
                var data={};
                if(serverChooseVal=='probe'){
                    data={probeName:probeChooseVal};
                };
                $("#stepPaneContent").empty();
                var html = [];
                html.push('<div class="row">'+serverChooseVal+'停止执行命令及响应信息</div>');
                $.ajax({
                    type: "get",
                    url: url,    //向后端请求数据的url
                    cache:false,  //get方式相同参数请求，易产生缓存；用此参数设置清除缓存
                    async:false,
                    data: data,
                    success: function (data) {
                        var batchShellExecRes=eval(data);
                        var shellExecList=batchShellExecRes.shellExecList;
                        stopProcessFlag=batchShellExecRes.batchExecResultFlag;
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
                        $("#stepPaneContent").html(html.join(''));
                    }
                });
                return stopProcessFlag;
            };

           //启动前校验server处理
            function startValidateProcess(serverChooseVal,probeChooseVal){
                var startValidateProcessFlag=false;
                var url="${BASE_PATH}/restartManage/"+serverChooseVal+"Restart/"+serverChooseVal+"StartPreValidateProcess";
                $("#stepPaneContent").empty();
                var html = [];
                html.push('<div class="row">'+serverChooseVal+'启动校验执行命令及响应信息</div>');
                $.ajax({
                    type: "get",
                    url: url, //向后端请求数据的url
                    cache:false,//get方式相同参数请求，易产生缓存；用此参数设置清除缓存
                    async:false,
                    data: {},
                    success: function (data) {
                        var batchShellExecRes=eval(data);
                        var shellExecList=batchShellExecRes.shellExecList;
                        startValidateProcessFlag=batchShellExecRes.batchExecResultFlag;
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
                        $("#stepPaneContent").html(html.join(''));
                    }
                });
                return startValidateProcessFlag;
            };

            function  startProcess(serverChooseVal,probeChooseVal){
                var startProcessFlag=false;
                var url="${BASE_PATH}/restartManage/"+serverChooseVal+"Restart/"+serverChooseVal+"StartProcess";
                var data={};
                if(serverChooseVal=='probe'){
                    data={probeName:probeChooseVal};
                }
                $("#stepPaneContent").empty();
                var html = [];
                html.push('<div class="row">'+serverChooseVal+'启动执行命令及响应信息</div>');
                $.ajax({
                    type: "get",
                    url: url,    //向后端请求数据的url
                    cache:false,  //get方式相同参数请求，易产生缓存；用此参数设置清除缓存
                    async:false,
                    data: data,
                    success: function (data) {
                        var batchShellExecRes=eval(data);
                        var shellExecList=batchShellExecRes.shellExecList;
                        startProcessFlag=batchShellExecRes.batchExecResultFlag;
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
                        $("#stepPaneContent").html(html.join(''));
                    }
                })
                return startProcessFlag;
            };


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
<style>
    .btn{
        border:0px;
    }
    .form-group{
        margin-bottom:0px
    }
</style>
<#--<script>
    $(document).ready(function(){
    });
    //dom操作
    var domFun={   };


</script>-->
<#--</head>
<body>-->

<#--<div id="content" style="opacity: 1;">--><!-- Bread crumb is created dynamically -->
    <!-- row -->
    <#--<div class="row">
        <div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
            <h1 class="page-title txt-color-blueDark"><!-- PAGE HEADER &ndash;&gt;<i class="fa-fw fa fa-file-o"></i> Forum Layout<span>&gt;
			Post View </span></h1>
        </div>
    </div>-->
    <!-- end row -->

    <!-- row -->
    <div class="row">
        <div class="col-sm-12">
            <div class="well">

                <table class="table table-striped table-forum">
                    <thead>
                    <tr>
                        <div class="col-md-4 well">
                            <div class="form-group">
                                <div class="col-sm-3"><span class="control-label">集群server：</span>
                                </div>
                                <div class="col-sm-9">
                                    <select class="form-control" id="serverChoose" onchange="changeDefaultRelSteps('serverChoose');">  <!--onchange="changeDefaultRelSteps(this);"-->
                                        <option value="none">------</option>
                                        <option value="cluster">集群</option>
                                        <option value="scanner">Scanner</option>
                                        <option value="server">Server</option>
                                        <option value="probe">Probbe</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4 well" id="probeChooseDiv" style="min-height:32px;display:none;">
                            <div class="form-group">
                                <div class="col-sm-3"><span class="control-label">Probe：</span>
                                </div>
                                <div class="col-sm-9" >
                                    <select class="form-control" id="probeChoose" onchange="changeDefaultRelSteps('probeChoose');"> <!--onchange="changeDefaultRelSteps(this);"-->
                                        <option value="none">------</option>
                                        <option value="probeFull">probeFull</option>
                                        <option value="probe30">probe30</option>
                                        <option value="probe31">probe31</option>
                                        <option value="probe33">probe33</option>
                                        <option value="probe34" >probe34</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-3 well">
                            <div class="form-group">
                                <div class="col-sm-3"><span class="control-label">操作：</span></div>
                                <div class="col-sm-9">
                                    <select class="form-control" id="operateChoose" onchange="changeDefaultRelSteps('operateChoose');" > <!---->
                                        <option value="none">------</option>
                                        <option value="stop">停止</option>
                                        <option value="start">启动</option>
                                        <option value="restart">重启</option>
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-1 well">
                            <div class="form-group">
                                <div id="execProcess" title="" onClick="execProcess();"  class="btn btn-success" data-loading-text="" data-original-title="">执行</div>
                            </div>
                        </div>

                    </tr>
                    <tr>
                        <#--<div class="col-md-12 well">
                           <div class="col-md-4"><div id="clusterStop" title="" onClick="clusterStopProcess();"  class="btn btn-success col-md-3" data-loading-text="停止进行中..." data-original-title="">停止</div></div>
                            <div class="col-md-4" ><div id="clusterStart" onClick="clusterStartProcess();"  title="" class="btn btn-success col-md-3" data-loading-text="启动进行中..." data-original-title="">启动</div></div>
                            <div class="col-md-4"><div id="clusterRestart" onClick="clusterRestartProcess();"  title="" class="btn btn-success col-md-3" data-loading-text="重启进行中..." data-original-title="">重启</div></div>
                        </div>-->
                    </tr>
                    </thead>
                    <tbody>
                    <!-- Post -->
                    <#--<tr>
                        <td class="text-center">
                            <a href="#ajax/profile.html"><img class="flag flag-fr" alt="France" src="img/blank.gif"> &nbsp;
                                <strong>Sadi Orlaf</strong></a>
                        </td>
                        <td>on <em>Jan 1, 2014 - 12:00am</em></td>
                    </tr>-->

                    <tr>
                        <div class="col-md-12 well widget-body">
                            <div class="widget-main">
                                <div class="no-steps-container" id="fuelux-wizard-container">
                                    <div>
                                        <ul id="default" class="steps"  style="margin-left: 0px;">
                                        </ul>
                                        <ul id="commonStop" class="steps"  style="margin-left: 0px;display:none;">
                                            <li data-step="1">
                                                <span class="step">1</span>
                                                <span class="title">Validate</span>
                                            </li>

                                            <li data-step="2">
                                                <span class="step">2</span>
                                                <span class="title">Stop</span>
                                            </li>
                                        </ul>

                                        <ul id="commonStart" class="steps" style="margin-left: 0px;display:none;">
                                            <li  data-step="1">
                                                <span class="step">1</span>
                                                <span class="title">Validate</span>
                                            </li>

                                            <li data-step="2">
                                                <span class="step">2</span>
                                                <span class="title">Start</span>
                                            </li>
                                        </ul>
                                        <ul id="commonRestart" class="steps" style="margin-left: 0px;display:none;">
                                            <li  data-step="1">
                                                <span class="step">1</span>
                                                <span class="title">ValidateStop</span>
                                            </li>

                                            <li data-step="2">
                                                <span class="step">2</span>
                                                <span class="title">stop</span>
                                            </li>

                                            <li data-step="3">
                                                <span class="step">3</span>
                                                <span class="title">ValidateStart</span>
                                            </li>

                                            <li data-step="4">
                                                <span class="step">4</span>
                                                <span class="title">Start</span>
                                            </li>
                                        </ul>
                                        <ul id="clusterStop" class="steps"  style="margin-left: 0px;display:none;">
                                            <li data-step="1">
                                                <span class="step">1</span>
                                                <span class="title">Stop</span>
                                            </li>
                                            <li data-step="2">
                                                <span class="step">2</span>
                                                <span class="title">End</span>
                                            </li>
                                        </ul>

                                        <ul id="clusterStart" class="steps" style="margin-left: 0px;display:none;">
                                            <li  data-step="1">
                                                <span class="step">1</span>
                                                <span class="title">Start</span>
                                            </li>
                                            <li data-step="2">
                                                <span class="step">2</span>
                                                <span class="title">End</span>
                                            </li>
                                        </ul>
                                        <ul id="clusterRestart" class="steps" style="margin-left: 0px;display:none;">
                                            <li class="active" data-step="1">
                                                <span class="step">1</span>
                                                <span class="title">Stop</span>
                                            </li>
                                            <li data-step="2">
                                                <span class="step">2</span>
                                                <span class="title">Start</span>
                                            </li>
                                        </ul>
                                    </div>
                                    <hr>
                                    <div class="step-content pos-rel">
                                        <div class="step-pane active"  data-step="1"  id="stepPaneContent">  <!--active-->
                                        </div>
                                        <#--<div class="step-pane active" data-step="1">
                                            <h3 class="lighter block green">stpep1 Enter the following information</h3>
                                        </div>
                                        <div class="step-pane" data-step="2">
                                            <div>
                                                step2
                                            </div>
                                        </div>

                                        <div class="step-pane" data-step="3">
                                            <div class="center">
                                                <h3 class="blue lighter">This is step 3</h3>
                                            </div>
                                        </div>

                                        <div class="step-pane" data-step="4">
                                            <div class="center">
                                                <h3 class="green">Congrats!</h3>
                                                Your product is ready to ship! Click finish to continue!
                                            </div>
                                        </div>-->

                                    </div>
                                </div>

                               <#--<hr>
                                <div class="wizard-actions">
                                    <button disabled="disabled" class="btn btn-prev">
                                        <i class="ace-icon fa fa-arrow-left"></i>
                                        Prev
                                    </button>
                                    <button class="btn btn-success btn-next" data-last="Finish">
                                        Next
                                        <i class="ace-icon fa fa-arrow-right icon-on-right"></i></button>
                                </div>-->

                            </div><!-- /.widget-main -->
                        </div>
                    </tr>
                    <!-- end Post -->
                    </tbody>
                </table>
            </div>
        </div>

    </div>

    <!-- end row -->

    <!-- row,a blank row to get started  -->
   <#-- <div class="row">
    </div>-->
    <!-- end row -->
<#--</div>-->

<#--
</body>
</html>-->