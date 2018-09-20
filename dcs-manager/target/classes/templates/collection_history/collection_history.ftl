<!-- 通用模板 -->
<!-- widget grid -->
<section id="widget-grid" class="">
    <!-- row -->
    <div class="row">
        <!-- NEW WIDGET START -->
        <article class="col-xs-12 col-sm-12 col-md-12 col-lg-12 sortable-grid ui-sortable">
            <!-- Widget ID (each widget will need unique ID)-->
            <div class="jarviswidget jarviswidget-color-darken jarviswidget-sortable" id="wid-id-0"
                 data-widget-editbutton="false" role="widget">
               
                <!-- widget div-->
                <div role="content">
                    <!-- widget edit box -->
                    <div class="jarviswidget-editbox">
                        <!-- This area used as dropdown edit box -->
                    </div>
                    <!-- end widget edit box -->
                    <!-- widget content -->
                    <div class="widget-body no-padding">
                        <div id="dt_basic_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                            <div class="dt-toolbar">
                                <!-- 当天采集查询条件 -->
                                <div class="col-xs-11 col-sm-11">
                                    <div id="dt_basic_filter" class="dataTables_filter">
                                        <label>
                                        <#--<span class="input-group-addon">-->
                                        <#---->
                                        <#--</span>-->
                                            <form id="searchForm" method="post" >
                                                <select id ="ftpId"
                                                        name="dt_basic_length" aria-controls="dt_basic"
                                                        class="form-control input">
                                                    <option value="-1" style="display:none">请选择FTP名称</option>

                                                </select>

                                            <#--<span class="input-group-addon" >-->
                                            <#---->
                                            <#--</span>-->

                                                <select
                                                        id="dataTypeId"
                                                        name="dt_basic_length" aria-controls="dt_basic"
                                                        class="form-control input">                                             robe
                                                    <option value="-1" style="display:none">请选择类型名称</option>

                                                </select>
                                            <#--<span class="input-group-addon" >-->
                                            <#---->
                                            <#--</span>-->

                                                <select
                                                        id="probeId"
                                                        name="dt_basic_length" aria-controls="dt_basic"
                                                        class="form-control input">
                                                    <option value="-1" style="display:none">请选择Probe名称</option>

                                                </select>
                                                <input id="pathAndName" name="pathAndName" class="form-control" style="display:inline-block;width:180px;" placeholder="文件名称"  type="text"/>

                                                <button id="searchButton" class="btn btn-default btn-primary tooltips" type="button" title="搜索">
                                                    <i class="fa fa-search"></i> 搜索
                                                </button>
                                            </form>
                                        </label>
                                    </div>

                                </div>

                                <div class="col-sm-1 col-xs-1 hidden-xs">
                                    <div class="dataTables_length" id="dt_basic_length">

                                        <label> <select id = "pageSize"
                                                        name="dt_basic_length" aria-controls="dt_basic"
                                                        class="form-control input-sm">
                                            <option value="10">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                        </select> </label>

                                    </div>
                                </div>
                            </div>
                        </div>
                       <div id="tableContent">
                            <#--调用表格部分 -->
                                <table id="dt_basic"
                                       class="table table-striped table-bordered table-hover dataTable no-footer"
                                       role="grid" aria-describedby="dt_basic_info" style="Width:100%;table-layout:fixed;" >
                                    <thead>

                                    <tr role="row">
                                        <th style="width: 77px;">文件ID </th>
                                        <th style="width: 80px;">IP地址</th>
                                        <th style="width: 90px;" >Probe名称</th>
                                        <th style="width: 100px;">类型名称</th>
                                        <th>文件名称</th>
                                        <th style="width: 125px;">

                                            生成时间
                                        </th>
                                        <th style="width: 115px;">状态</th>
                                        <th  style="width: 60px;">大小(B)</th>
                                    <#--<th  -->
                                    <#-- style="width: 80px;"-->
                                    <#--aria-label=" Date: activate to sort column ascending">-->
                                    <#--下载时长<br/>(ms)-->
                                    <#--</th>-->
                                    <#--<th  -->
                                    <#-- style="width: 80px;"-->
                                    <#--aria-label=" Date: activate to sort column ascending">-->
                                    <#--上传时长<br/>(ms)-->
                                    <#--</th>-->

                                        <th  style="width: 30px;"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#list pageInfo.list as col>
                                    <tr role="row"
                                        class="<#if col_index%2==0>
                                       odd
                                        <#else>
                                        even
                                        </#if>
                                            ">
                                        <td> ${col["fileId"]?c}</td>
                                        <td> ${col["ftpIp"]!}</td>
                                        <td> ${col["probeName"]}</td>
                                        <td> ${col["dataTypeName"]}</td>
                                        <td class="trimtd" style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;" title='${col["pathAndName"]}'>

                                        ${col["pathAndName"]}

                                        </td>
                                        <td>${col["fileInsertTime"]?string('yyyy-MM-dd HH:mm:ss')}</td>
                                        <td title="<#if col["status"]== 0>正在下载</#if><#if col["status"]== 1>准备上传HDFS</#if><#if col["status"]== 2>上传HDFS成功</#if><#if col["status"]== 3>上传HDFS失败</#if><#if col["status"]== 4>正在上传HDFS</#if>">
                                            <#if col["status"]== 0>正在下载</#if><#if col["status"]== 1>准备上传HDFS</#if><#if col["status"]== 2>上传HDFS成功</#if><#if col["status"]== 3>上传HDFS失败</#if><#if col["status"]== 4>正在上传HDFS</#if></td>
                                        <td> ${col["fileSize"]?c!''}</td>
                                    <#--<td>${col["downloadDuration"]}</td>-->
                                    <#--<td> ${col["toHdfsDuration"]}</td>-->

                                        <td>
                                           
                                            <button class="btn btn-xs btn-primary tooltips" data-toggle="modal"  title="查看明细"  data-placement="left"
                                                    data-target="#addModalId"   onclick="initID('${col_index}','${col["fileId"]}')"
                                            ><i class="fa fa-eye" aria-hidden="true"></i></button>

                                        </td>
                                    </tr>
                                    
                                    </#list>

                                    </tbody>
                                </table>
                                <#include "/page.ftl">
                        </div>
                    </div>
                    <!-- end widget content -->
                </div>
                <!-- end widget div -->
            </div>
            <!-- end widget -->
        </article>
        <!-- WIDGET END -->
    </div>
</section>

<#--调用modal 窗口 -->
<#if formcontenturl??>
<#include "/add_modal.ftl">
</#if>
<#include "/common_script.ftl">
<#--调用每个功能点自己的script部分 -->
<script>
    var ftpId=-1;
    var dataTypeId=-1;
    var pageSize=10;
    var pid=-1;
    var pkid=-1;
    var probeId =-1;
    var pathAndName="";
    var dataList=[];
    function initID(_id,_pkid) {
        pid = _id;
        pkid = _pkid;

    }
    $('#addModalId').on('shown.bs.modal', function () {

        var col = dataList[pid];
        $("#fileId").text(col["fileId"]);
        $("#pathAndName").text(col["pathAndName"]);
        $("#renameFileName").text(col["renameFileName"]);
        $("#dataTypeName").text(col["dataTypeName"]);
        $("#ftpIp").text(col["ftpIp"]);
        $("#probeName").text(col["probeName"]);

        $("#fileInsertTime").text(col["fileInsertTime"]);

        $("#status").text(col["status"]);

        $("#fileSize").text(col["fileSize"]);
        $("#ftpPathAndName").text(col["ftpPathAndName"]);
        $("#downloadDuration").text(col["downloadDuration"]);
        $("#toHdfsDuration").text(col["toHdfsDuration"]);
        $("#hdfsPath").text(col["hdfsPath"]);
        $("#addLabel").html("采集文件明细");

    });

    function goto(pn) {
        ftpId= $("#ftpId").val();
        dataTypeId = $("#dataTypeId").val();
        pageSize =   $("#pageSize").val();
        probeId =  $("#probeId").val();
        $("#content").load(BASE_PATH + "/currentDayCollectionFiles/",
                {
                    pn: pn,
                    ftpId:ftpId,
                    dataTypeId:dataTypeId,
                    pageSize:pageSize,
                    refreshPart:1,
                    probeId:probeId,
                    pathAndName:$('#pathAndName').val()
                }, function (txt) {

                    if (!txt) {

                    }

                });
    }
    $(function(){
        <#list pageInfo.list as col>
            dataList.push(
                    {
                        fileId:'${col["fileId"]?c}',
                        pathAndName: '${col["pathAndName"]}',
                        renameFileName: '${col["renameFileName"]}',
                        dataTypeName:'${col["dataTypeName"]!''}',
                        ftpIp: '${col["ftpIp"]!''}',
                        probeName: '${col["probeName"]!''}',
                        fileInsertTime:'${col["fileInsertTime"]?string('yyyy-MM-dd HH:mm:ss')}' ,
                        fileSize:'${col["fileSize"]?c!''}',

                        status:'<#if col["status"]== 0>正在下载</#if><#if col["status"]== 1>准备上传HDFS</#if><#if col["status"]== 2>上传HDFS成功</#if><#if col["status"]== 3>上传HDFS失败</#if><#if col["status"]== 4>正在上传HDFS</#if>',
                        ftpPathAndName:'${col["ftpPathAndName"]!''}',
                        downloadDuration:'${col["downloadDuration"]?c}',
                        toHdfsDuration:'${col["toHdfsDuration"]?c}',
                        hdfsPath:'${col["hdfsPath"]!''}'
                    });
        </#list>


        $("#ftpId").empty();

        $("#ftpId").append("<option value='-1'  >所有FTP</option>");
    <#list ftPserverList as col>
        $("#ftpId").append("<option value='${col["ftpId"]}'>${col["ftpIp"]}:${col["ftpPort"]}</option>");
    </#list>

        $("#dataTypeId").empty();

        $("#dataTypeId").append("<option value='-1'  >所有数据类型</option>");
    <#list dcsDataTypeList as col>
        $("#dataTypeId").append("<option value='${col["dataTypeId"]}'>${col["dataTypeName"]}</option>");
    </#list>

        $("#probeId").empty();

        $("#probeId").append("<option value='-1'  >所有Probe</option>");
    <#list allDcsProbeList as col>
        $("#probeId").append("<option value='${col["probe_id"]}'>${col["probe_name"]}</option>");
    </#list>
        $('#ftpId') .val('${ftpId}');
        $('#dataTypeId') .val('${dataTypeId}');
        $('#probeId') .val('${probeId}');
        $('#pathAndName') .val('${pathAndName}');
    })



</script>

<!-- end widget grid -->


			