<#--<!doctype html>
<html lang="ch">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>集群控制管理系统</title>-->
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 &ndash;&gt;
<script type="text/javascript" src="${BASE_PATH}/js/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件&ndash;&gt;
<script type="text/javascript" src="${BASE_PATH}/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${BASE_PATH}/css/common.css"/>
<link type="text/css"  href="${BASE_PATH}/css/bootstrap.min.css" rel="stylesheet"> --><#--不要在引入样式，否则改写父页面样式，导致头部变形-->


<script src="${BASE_PATH}/smartadmin/js/plugin/bootstrap-wizard/jquery.bootstrap.wizard.min.js" type="text/javascript"></script>
<script src="${BASE_PATH}/smartadmin/js/plugin/fuelux/wizard/wizard.min.js" type="text/javascript"></script>
<script src="${BASE_PATH}/js/toastr.min.js" type="text/javascript"></script>
<!-- CUSTOM NOTIFICATION -->
<script src="${BASE_PATH}/smartadmin/js/notification/SmartNotification.min.js"></script>
<script>
    var wizard =null;
    function initWizardChart() {  //winzard监听事件
        //pageSetUp();
        wizard = $('#bootstrap-wizard-1').bootstrapWizard({
            'tabClass': 'form-wizard',
            'onTabClick': function () {
                return false;
            },
            'onTabChange': function () {
                return false;
            },
            'onNext': function (tab, navigation, index) {
                alert(tab);
                alert(navigation);
                alert(index);
             $('#bootstrap-wizard-1').find('.form-wizard').children('li').eq(index - 1).addClass('complete');
             $('#bootstrap-wizard-1').find('.form-wizard').children('li').eq(index - 1).find('.step').html('<i class="fa fa-check"></i>');
            }
        });

    }
    function alertMessage(content){
        $.bigBox({
            title : "提示信息",
            content : content,
            color : "#C79121",   //"#C46A69",
            //timeout: 6000,
            icon : "fa fa-warning shake animated",
            //number : "1",
            timeout : 10000
        });
    }

    toastr.options.positionClass = 'toast-top-center ';
    var stepsId="default"; //steps项
    var stepNameArray=new Array();
    var  serverChooseVal="none";
    var  probeChooseVal="none";
    var operateChooseVal="none";
    var operateChooseStepVal="无";
    var shellUsesArray=new Array();
    var shellSubUsesArray=new Array();

    function changeDefaultRelSteps(targetId){ //变动当前默认相关步骤流程图
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
                if(operateChooseVal!="none" && serverChooseVal!="none"){
                    getProcessSteps(serverChooseVal,operateChooseVal);
                }
                $("#tab").empty();
            };

       function execProcess(){
           serverChooseVal=$("#serverChoose").val();
           probeChooseVal=$("#probeChoose").val();
           operateChooseVal=$("#operateChoose").val();
           var  execContinueFlag=false;
           if(serverChooseVal=="none"){
               alertMessage("请选择集群角色！");
               return;
           }
           if(operateChooseVal=="none"){
               alertMessage("请选择操作！");
               return;
           }
          if(serverChooseVal!="none"&&operateChooseVal!="none"){
              if(serverChooseVal!="probe"){
                  execContinueFlag=true;
              }else{
                  if(probeChooseVal!="none"){
                  execContinueFlag=true;
                  }else{
                  execContinueFlag=false;
                  //alert("请选择probe选项！");
                  //toastr.warning("请选择probe选项！");
                  //$("#alert").trigger("click");
                  alertMessage("请选择probe！");
                  return;
                  }
              }
          }else{
            execContinueFlag=false;
            //alert("请选择集群Server和操作选项！");
              //toastr.warning("请选择集群Server和操作选项！");
              //$("#alert").trigger("click");
              alertMessage("请选择集群角色和操作！");
            return ;
          }
          if(execContinueFlag){ //满足执行可持续flag,进行下一项
              $("#execProcess").addClass("disabled");
              $("#execProcess").prop("disabled",true);
              $("#execProcess").button('loading');
              shellUsesArray=[];
              shellSubUsesArray=[];
              //operateChooseStepVal=operateChooseVal.substring(0,1).toUpperCase( )+operateChooseVal.substring(1); //首字母大写
              operateChooseStepVal=$("#operateChoose").find("option:selected").text(); //选中操作文本
              $("#tab").html("<br><br>");
              $("#"+stepsId).children('li').eq(0).addClass("active");
              execStepProcess(serverChooseVal,probeChooseVal,operateChooseStepVal,0,stepNameArray,stepsId);
              //$("#execProcess").removeClass("disabled");
              //$("#execProcess").prop("disabled",false);
              //$("#execProcess").button('reset');

          }
       };
  function  getProcessSteps(serverChooseVal,operateChooseVal){
  var url="${BASE_PATH}/restartManage/clusterRestartManage/getServerRestartSteps";
  var parmData={serverChooseVal:serverChooseVal,operateChooseVal:operateChooseVal};
      $.ajax({
          type: "get",
          url: url, //向后端请求数据的url
          cache:false,//get方式相同参数请求，易产生缓存；用此参数设置清除缓存
          async:false,
          data: parmData,
          success: function (data) {
              var steps= data;
              if(steps!=null){
                  $("#default").empty();
                  steps=steps.substring(1,steps.length-1); //去掉前后“”号
                  stepNameArray=steps.split(",");
                  for(var i=0;i<stepNameArray.length;i++){
                   var step=stepNameArray[i];
                   var stepSeq=i+1;
                   var stepHtml='<li  data-target="#step'+stepSeq+'"> <a href="#tab" data-toggle="tab"> <span class="step">'+stepSeq+'</span> <span class="title">'+step+'</span> </a></li>';
                    $("#default").append(stepHtml);
                  }

                  initWizardChart(); //加载监听事件
                  wizard.bootstrapWizard('resetWizard');//重置初始化监听事件
              }
          }
      })
  };

  function  execNextStepProcess(stepsId,stepIndex,endStepIndex,stepNameArray,execStepFlag){
       if(execStepFlag) {
           $("#" + stepsId).children('li').eq(stepIndex).removeClass('active');
           $("#" + stepsId).children('li').eq(stepIndex).addClass('complete');
           $("#" + stepsId).children('li').eq(stepIndex).find('.step').html('<i class="fa fa-check"></i>');
           var isNextStepFlag = stepIndex < endStepIndex ? true : false;
        /*   if (serverChooseVal == "cluster" && operateChooseStepVal != "Restart") {
               isNextStepFlag = stepIndex < endStepIndex - 1 ? true : false;
           }*/
           if (isNextStepFlag) {
               $("#" + stepsId).children('li').eq(stepIndex + 1).addClass("active");
               execStepProcess(serverChooseVal, probeChooseVal, operateChooseStepVal, stepIndex + 1, stepNameArray, stepsId);
           } else {
               $("#" + stepsId).children('li').eq(endStepIndex).removeClass('active');
               $("#" + stepsId).children('li').eq(endStepIndex).addClass('complete');
               $("#" + stepsId).children('li').eq(endStepIndex).find('.step').html('<i class="fa fa-check"></i>');
              /* if (serverChooseVal == "cluster" && operateChooseStepVal != "Restart") {
                   $("#" + stepsId).children('li').eq(endStepIndex + 1).addClass('complete');
                   $("#" + stepsId).children('li').eq(endStepIndex + 1).find('.step').html('<i class="fa fa-check"></i>');
               }*/
               $("#execProcess").removeClass("disabled");
               $("#execProcess").prop("disabled", false);
               $("#execProcess").button('reset');
           }
       }else{
           $("#" + stepsId).children('li').eq(stepIndex).removeClass('active');
           $("#" + stepsId).children('li').eq(stepIndex).addClass('complete');
           $("#" + stepsId).children('li').eq(stepIndex).find('.step').html('<i class="fa fa-times"></i>');
           $("#execProcess").removeClass("disabled");
           $("#execProcess").prop("disabled", false);
           $("#execProcess").button('reset');
       }
    }
    function execStepProcess(serverChooseVal,probeChooseVal,operateChooseStepVal,stepIndex,stepNameArray,stepsId){
        var  processFlag=false;
        var stepName=stepNameArray[stepIndex];
        var url=null;
        if(stepName=="ValidateStop"){
          url="${BASE_PATH}/restartManage/"+serverChooseVal+"Restart/"+serverChooseVal+"StopPreValidateProcess";
        }
        if(stepName=="Stop"){
            url="${BASE_PATH}/restartManage/"+serverChooseVal+"Restart/"+serverChooseVal+"StopProcess";
        }
        if(stepName=="ValidateStart"){
            url="${BASE_PATH}/restartManage/"+serverChooseVal+"Restart/"+serverChooseVal+"StartPreValidateProcess";
        }
        if(stepName=="Start"){
            url="${BASE_PATH}/restartManage/"+serverChooseVal+"Restart/"+serverChooseVal+"StartProcess";
        }
        var parmData={};
        if(serverChooseVal=='probe'){
            parmData={probeName:probeChooseVal};
        };
        var html = [];
       // html.push('<br><h3>'+serverChooseVal+operateChooseStepVal+stepName+'阶段执行命令及响应信息</h3>');
        //html.push('<br>');
        html.push('<div class="row"><div class="col-sm-12">');
        $.ajax({
            type: "get",
            url: url, //向后端请求数据的url
            cache:false,//get方式相同参数请求，易产生缓存；用此参数设置清除缓存
            async:true,
            data: parmData,
            success: function (data) {
                var batchShellExecRes=eval('('+ data +')');
                var shellExecList=batchShellExecRes.shellExecList;
                processFlag=batchShellExecRes.batchExecResultFlag;
                for(var i=0;i<shellExecList.length;i++){
                    var shellExecBody=shellExecList[i];
                    var resResult=shellExecBody.resResult;
                    var resConclusion=shellExecBody.resConclusion;
                    var stageContentLevel="alert-info";
                    if(shellExecBody.resResultLevel=="warn"){
                        stageContentLevel="alert-warning";
                    }else if(shellExecBody.resResultLevel=="error"){
                        stageContentLevel="alert-danger";
                    }else if(shellExecBody.resResultLevel=="success"){
                        stageContentLevel="alert-success";
                    }else{
                        stageContentLevel="alert-info";
                    }
                    var  usesStage=shellExecBody.shellUses;
                    var  subUsesStage=shellExecBody.shellSubUses;
                    var execCmd=shellExecBody.shellCmd;
                    var  usesStageExist=$.inArray(usesStage,shellUsesArray);
                    if(usesStageExist==-1){
                        shellUsesArray.push(usesStage);
                        shellSubUsesArray=[];
                        var usesSeq=shellUsesArray.length;
                        html.push('<div class="alert alert-info">'+usesSeq+"、"+usesStage+'</div>');
                    }
                    if(subUsesStage!=""&&subUsesStage!=usesStage){
                        shellSubUsesArray.push(subUsesStage);
                        var subUsesSeq=shellSubUsesArray.length;
                        html.push('<div class="alert alert-info">('+subUsesSeq+")、"+subUsesStage+'</div>');
                    }
                    if(execCmd!=null && execCmd!=""){
                        html.push('<div class="alert alert-info">'+formatDateTime(shellExecBody.shellExecTime)+' '+shellExecBody.shellCmd+'</div>');
                    }
                    if(resResult!=null && resResult!=""){
                        html.push('<div class="alert '+stageContentLevel+'">'+resResult+'</div>');
                    }
                    if(resConclusion!=null && resConclusion!=""){
                        html.push('<div class="alert  '+stageContentLevel+'">'+resConclusion+'</div>');
                    }
                }
                html.push('</div></div>');
                $("#tab").append(html.join(''));
                //if(processFlag){
                    execNextStepProcess(stepsId,stepIndex,stepNameArray.length-1,stepNameArray,processFlag);
                //}
            }
        });
        return processFlag;
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
                        <fieldset>
                            <div class="form-group" >   <!-- well-->
                                <div class="form-group has-feedback">
                                    <label class="col-xs-1 col-lg-1 control-label">集群角色:</label>
                                    <div class="col-xs-3 col-lg-3 selectContainer">
                                        <select name="color" class="form-control" id="serverChoose" onchange="changeDefaultRelSteps('serverChoose');">
                                            <option value="none">请选择集群角色</option>
                                            <option value="cluster">集群</option>
                                            <option value="scanner">Scanner</option>
                                            <option value="server">Server</option>
                                            <option value="probe">Probe</option>
                                        </select>
                                    </div>
                                    <div id="probeChooseDiv" style="min-height:32px;display:none;">
                                   <div class="col-xs-1 col-lg-1"></div>
                                    <label class="col-xs-1 col-lg-1 control-label">Probe:</label>
                                    <div class="col-xs-3 col-lg-3 selectContainer">
                                        <select name="color" class="form-control" id="probeChoose" onchange="changeDefaultRelSteps('operateChoose');">
                                             <option value="none">请选择Probe</option>
                                            <option value="probeFull">全部Probe</option>
                                        <#list dcsProbeList as col>
                                            <option value='${col["probe_name"]}' >${col["probe_name"]}</option>;
                                        </#list>
                                        </select>
                                    </div>
                                    </div>
                                </div>
                            </div></fieldset>
                        <fieldset>
                            <div class="form-group"> <!-- well-->
                                <div class="form-group has-feedback">
                                    <label class="col-xs-1 col-lg-1 control-labe">操作:</label>
                                    <div class="col-xs-3 col-lg-3 selectContainer" ">
                                        <select name="color" class="form-control" id="operateChoose" onchange="changeDefaultRelSteps('operateChoose');">
                                            <option  value="none">请选择操作</option>
                                            <option value="stop">停止</option>
                                            <option value="start">启动</option>
                                            <option value="restart">重启</option>
                                        </select>
                                    </div>
                                    <div class="col-xs-2 col-lg-2 col-md-2 inputGroupContainer">
                                        <div class="col-xs-1 col-lg-1"></div>
                                        <button class="btn btn-success" type="submit" id="execProcess" onClick="execProcess();" data-loading-text="执行中">
                                            <i class="fa fa-refresh"></i>
                                            执行
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                        <fieldset><legend></legend></fieldset>
                    </thead>
                    <tbody>

                    <tr>
                        <div class="widget-body">
                            <div class="row">
                        <div class="col-sm-12" id="bootstrap-wizard-1">
                            <div class="form-bootstrapWizard">
                                <ul id="default" class="bootstrapWizard form-wizard" style="min-height:35px;"></ul>
                              <#--  <ul id="commonStop" class="bootstrapWizard form-wizard" style="min-height:35px;display:none;">
                                    <li class="active" data-target="#step1">
                                        <a href="#tab" data-toggle="tab"> <span class="step">1</span> <span class="title">ValidateStop</span> </a>
                                    </li>
                                    <li data-target="#step2">
                                        <a href="#tab" data-toggle="tab"> <span class="step">2</span> <span class="title">Stop</span> </a>
                                    </li>
                                </ul>
                                <ul id="commonStart" class="bootstrapWizard form-wizard" style="min-height:35px;display:none;">
                                    <li class="active" data-target="#step1">
                                        <a href="#tab" data-toggle="tab"> <span class="step">1</span> <span class="title">ValidateStart</span> </a>
                                    </li>
                                    <li data-target="#step2">
                                        <a href="#tab" data-toggle="tab"> <span class="step">2</span> <span class="title">Start</span> </a>
                                    </li>
                                </ul>
                                <ul id="commonRestart" class="bootstrapWizard form-wizard" style="min-height:35px;display:none;">
                                    <li class="active" data-target="#step1">
                                        <a href="#tab" data-toggle="tab"> <span class="step">1</span> <span class="title">ValidateStop</span> </a>
                                    </li>
                                    <li data-target="#step2">
                                        <a href="#tab" data-toggle="tab"> <span class="step">2</span> <span class="title">Stop</span> </a>
                                    </li>
                                    <li data-target="#step3">
                                        <a href="#tab" data-toggle="tab"> <span class="step">3</span> <span class="title">ValidateStart</span> </a>
                                    </li>
                                    <li data-target="#step4">
                                        <a href="#tab" data-toggle="tab"> <span class="step">4</span> <span class="title">Start</span> </a>
                                    </li>
                                </ul>
                                <ul id="clusterStop" class="bootstrapWizard form-wizard" style="min-height:35px;display:none;">
                                    <li class="active" data-target="#step1">
                                        <a href="#tab" data-toggle="tab"> <span class="step">1</span> <span class="title">Stop</span> </a>
                                    </li>
                                    <li data-target="#step2">
                                        <a href="#tab" data-toggle="tab"> <span class="step">2</span> <span class="title">End</span> </a>
                                    </li>
                                </ul>
                                <ul id="clusterStart" class="bootstrapWizard form-wizard" style="min-height:35px;display:none;">
                                    <li class="active" data-target="#step1">
                                        <a href="#tab" data-toggle="tab"> <span class="step">1</span> <span class="title">Start</span> </a>
                                    </li>
                                    <li data-target="#step2">
                                        <a href="#tab" data-toggle="tab"> <span class="step">2</span> <span class="title">End</span> </a>
                                    </li>
                                </ul>
                                <ul id="clusterRestart" class="bootstrapWizard form-wizard" style="min-height:35px;display:none;">
                                    <li class="active" data-target="#step1">
                                        <a href="#tab" data-toggle="tab"> <span class="step">1</span> <span class="title">Stop</span> </a>
                                    </li>
                                    <li data-target="#step2">
                                        <a href="#tab" data-toggle="tab"> <span class="step">2</span> <span class="title">start</span> </a>
                                    </li>
                                </ul>-->

                                <div class="clearfix"></div>
                            </div>
                            <div class="tab-content">
                                <div class="tab-pane active" id="tab">
                                    <#--<br>
                                    <h3><strong>Step 1 </strong> - Basic Information</h3>
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <div class="alert alert-info">
                                                <i class="fa-fw fa fa-info"></i>
                                                <strong>Info!</strong> Place an info message box if you wish.
                                            </div>
                                            <div class="alert alert-warning">
                                                <i class="fa fa-warning fa-fw fa-lg"></i><strong>Opps!</strong>
                                                You may get an error during the upload for this demo. The error will subside once the backend portion is properly configured.
                                            </div>
                                            <div class="alert alert-success">
                                               <i class="fa fa-check fa-lg"></i><strong> Complete</strong> dator.com/sdsdfsdfgdfgfgfh
                                            </div>
                                            <div class="alert  alert-danger">
                                                <i class="fa fa-warning fa-lg"></i><strong> Complete</strong> dator.com/sdsdfsdfgdfgfgfh
                                            </div>


                                        </div>
                                    </div>-->
                                </div>
                             </div>
                 <#--           <div class="tab-content">
                                <div class="tab-pane active" id="tab1">
                                    <br>
                                    <h3><strong>Step 1 </strong> - Basic Information</h3>
                                    <div class="row">
                                        <div class="col-sm-12">
                                        </div>
                                    </div>
                                </div>
                                <div class="tab-pane" id="tab2">
                                    <br>
                                    <h3><strong>Step 2</strong> - Billing Information</h3>
                                </div>
                                <div class="tab-pane" id="tab3">
                                    <br>
                                    <h3><strong>Step 3</strong> - Domain Setup</h3>
                                    <div class="alert alert-info fade in">
                                        <button class="close" data-dismiss="alert">
                                            ×
                                        </button>
                                        <i class="fa-fw fa fa-info"></i>
                                        <strong>Info!</strong> Place an info message box if you wish.
                                    </div>
                                </div>
                                <div class="tab-pane" id="tab4">
                                    <br>
                                    <h3><strong>Step 4</strong> - Save Form</h3>
                                    <br>
                                    <h1 class="text-center text-success"><strong><i class="fa fa-check fa-lg"></i> Complete</strong></h1>
                                    <h4 class="text-center">Click next to finish</h4>
                                    <br>
                                    <br>
                                </div>-->

                                <div class="form-actions" style="display:none;">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <ul class="pager wizard no-margin no-steps-container">
                                                <!--<li class="previous first disabled">
                                                <a href="javascript:void(0);" class="btn btn-lg btn-default"> First </a>
                                                </li>-->
                                                <li class="previous disabled">
                                                    <a class="btn btn-lg btn-default" href="javascript:void(0);"> Previous </a>
                                                </li>
                                                <!--<li class="next last">
                                                <a href="javascript:void(0);" class="btn btn-lg btn-primary"> Last </a>
                                                </li>-->
                                                <li class="next">
                                                    <a class="btn btn-lg txt-color-darken" href="javascript:void(0);"> Next </a>
                                                </li>
                                                <li>
                                                <a class="btn btn-primary" id="eg1" href="#"> <i class="fa fa-warning"></i>alter</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                       </div>
                   </div>
                    </tr>
                    <!-- end Post -->
                    </tbody>
                </table>
            </div>
        </div>
     <div id="divbigBoxes"></div>
    </div>


<!-- Your GOOGLE ANALYTICS CODE Below -->
<#--<script>
    var _gaq = _gaq || [];
    _gaq.push(['_setAccount', 'UA-XXXXXXXX-X']);
    _gaq.push(['_trackPageview']);

    (function() {
        var ga = document.createElement('script');
        ga.type = 'text/javascript';
        ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(ga, s);
    })();
</script>-->
    <!-- end row -->
    <!-- row,a blank row to get started  -->
   <#-- <div class="row">
    </div>-->
    <!-- end row -->
<#--</div>-->

<#--

</body>
</html>-->
