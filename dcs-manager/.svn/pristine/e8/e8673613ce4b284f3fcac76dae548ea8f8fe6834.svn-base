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
                        <!--查询条件开始-->
                        <div id="dt_basic_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                            <div class="dt-toolbar">
                               
                                <!--Scanner监控查询条件-->
                                <div class="col-xs-11 col-sm-11">
                                    <div id="dt_basic_filter" class="dataTables_filter">
                                        <label>

                                            <form id="searchForm" method="post"  >
                                                <select id ="ftpId"
                                                        name="dt_basic_length" aria-controls="dt_basic"
                                                        class="form-control input">
                                                </select>
                                                <select
                                                        id="dataTypeId"
                                                        name="dt_basic_length" aria-controls="dt_basic"
                                                        class="form-control input">
                                                </select>
                                                <input id="pathAndName" name="pathAndName" class="form-control" style="display:inline-block;width:180px;" placeholder="文件名称"  type="text"/>
                                                <button id="searchButton" class="btn btn-default btn-primary tooltips" type="button"   title="搜索">
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
                                                        class="form-control input-sm pageSize">
                                            <option value="10">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                        </select> </label>

                                    </div>
                                </div>
                            </div>

                        </div>
                        <!--查询条件结束-->
                        <!-- 表格开始-->
                        <div id="tableContent">
                            <table id="dt_basic"
                                   class="table table-striped table-bordered table-hover dataTable no-footer"
                                   role="grid" aria-describedby="dt_basic_info" style="width: 100%;" width="100%">
                                <thead>

                                    <tr role="row">
                                        <th style="width: 30px;" >ID</th>
                                        <th>FTP文件名</th>
                                        <th  style="width: 60px;">大小(B)</th>
                                        <th style="width: 125px;">文件创建时间</th>
                                        <th>存储HDFS路径</th>
                                        <th style="width: 125px;">更改后文件名</th>
                                        <th style="width: 30px;"></th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <#list pageInfo.list as col>
                                    <tr role="row"
                                            class="<#if col_index%2==0>odd<#else>even</#if>">
                                        <td > ${col["fileId"]}</td>
                                        <td>
                                        ${col["pathAndName"]!''?html}
                                        </td>
                                        <td>
                                        ${col["fileSize"]?default("")}
                                        </td>
                                        <td><#if col["fileIntime"]??> ${col["fileIntime"]?string('yyyy-MM-dd HH:mm:ss')} </#if>
                                        </td>
                                        <td title="${col["hdfsPath"]!''}">${col["hdfsPath"]!''}</td>
                                        <td>${col["renameFileName"]!''?html}</td>
                                        <td>

                                            <button class="btn btn-xs btn-primary tooltips " title="查看明细" data-toggle="modal"  data-placement="left"
                                                    data-target="#addModalId"   onclick="initID('${col_index}','${col["fileId"]}')"
                                            ><i class="fa fa-eye" aria-hidden="true"></i></button>
                                        </td>
                                    </tr>

                                    </#list>
                                </tbody>
                            </table>
                            <!--分页开始-->
                            <#include "/page.ftl">
                            <!--分页结束-->
                        </div>
                        <!-- 表格结束-->
                    </div>
                    <!-- end widget content -->

                </div>
                <!-- end widget div -->
            </div>
            <!-- end widget -->
        </article>
        <!-- WIDGET END -->

    </div>

    <!-- end row -->

    <!-- end row -->

</section>

<#--调用modal 窗口开始 -->
<#if formcontenturl??>
    <#include "/add_modal.ftl">
</#if>

<#--调用modal 窗口结束 -->
<#include "/common_script.ftl">
<#--调用每个功能点自己的script部分 -->
<!--Scanner监控脚本-->
<script>
    var ftpId=-1;
    var dataTypeId=-1;
    var pageSize=10;
    var pid=-1;
    var pkid=-1;
    var pathAndName="";
    var dataList = [];
    function initID(_id,_pkid) {
        pid = _id;
        pkid = _pkid;

    }

    function goto(pn) {
        ftpId= $("#ftpId").val();
        dataTypeId = $("#dataTypeId").val();
        pageSize =   $("#pageSize").val();
        $("#content").load(BASE_PATH + "/scannerMonitor/",
                {
                    pn: pn,
                    ftpId:ftpId,
                    dataTypeId:dataTypeId,
                    pageSize:pageSize,
                    refreshPart:0,
                    pathAndName:$("#pathAndName").val()
                }, function (txt) {

                    if (!txt) {

                    }

                });
    }
    $(function(){
        $('#addModalId').on('shown.bs.modal', function () {
            var col = dataList[pid];

            $("#fileId").text(col["fileId"]);
            $("#ftpName").text(col["dcsFtpServer.ftpIp"]+":"+col["dcsFtpServer.ftpPort"]);
            $("#ftpIp").text(col["dcsFtpServer.ftpIp"]);
            $("#ftpPort").text(col["dcsFtpServer.ftpPort"]);
            $("#dataTypeName").text(col["dcsDataType.dataTypeName"]);
            $("#dataTypeName1").text(col["dcsDataType.dataTypeName"]);
            $("#pathAndName").text(col["pathAndName"]);
            $("#renameFileName").text(col["renameFileName"]);
            $("#fileIntime").text(col["fileIntime"]);
            $("#fileSize").text(col["fileSize"]);
            $("#source").text(col["source"]);
            $("#hdfsPath").text(col["hdfsPath"]);
            $("#dataTypePathReg").text(col["dcsDataType.dataTypePathReg"]);
            var isFtpDelete=col["dcsDataType.isFtpDelete"] ;
            var isFileDelete=col["dcsDataType.isFileDelete"] ;
            if (isFtpDelete=='0'){
                $("#isFtpDelete").text("否");
            }else{
                $("#isFtpDelete").text("是");
            }
            if (isFileDelete=='0'){
                $("#isFileDelete").text("否");
            }else{
                $("#isFileDelete").text("是");
            }
            $("#hdfsPath1").text(col["dcsDataType.hdfsPath"]);
            $("#pathFtp").text(col["dcsDataType.pathFtp"]);
            $("#dcsFtpServer.ftpIp").text(col["dcsFtpServer.ftpIp"]);
            $("#ftpUserName").text(col["dcsFtpServer.ftpUserName"]);
            $("#ftpPassword").text(col["dcsFtpServer.ftpPassword"]);
            $("#ftpWorkDirectory").text(col["dcsFtpServer.ftpWorkDirectory"]);
            $("#ftpLastScanTime").text(col["dcsFtpServer.ftpLastScanTime"]);
            $("#ftpPeriod").text(col["dcsFtpServer.ftpPeriod"]);
            $("#scannerIp").text(col["dcsFtpServer.scannerIp"]);
            $("#ftpLastServerTime").text(col["dcsFtpServer.ftpLastServerTime"]);

            $("#pathReg").text(col["dcsFtpServer.pathReg"]);
            $("#addLabel").html("Scanner监控明细");

        });

        $("#pathAndName").val('${pathAndName}');
        $("#ftpId").empty();

        $("#ftpId").append("<option value='-1'  >所有FTP</option>");
        <#list ftPserverList as col>
            $("#ftpId").append("<option value='${col["ftpId"]}'>${col["ftpIp"]}:${col["ftpPort"]}</option>");
        </#list>
        $("#ftpId").val('${ftpId}');
        
        $("#dataTypeId").empty();
        

        $("#dataTypeId").append("<option value='-1'  >所有数据类型</option>");
        <#list dcsDataTypeList as col>
            $("#dataTypeId").append("<option value='${col["dataTypeId"]}'>${col["dataTypeName"]}</option>");
        </#list>
        $("#dataTypeId").val('${dataTypeId}');
        $("#pageSize").val('${pageSize}');
         <#list pageInfo.list as col>
            dataList.push(
                    {
                        fileId:'${col["fileId"]}',
                        ftpId: '${col["ftpId"]}',
                        dataTypeId: '${col["dataTypeId"]}',
                        pathAndName:'${col["pathAndName"]!''}',
                        renameFileName: '${col["renameFileName"]!''}',
                        fileIntime:'${col["fileIntime"]?string("yyyy-MM-dd HH:mm:ss")}' ,

                        fileSize:'${col["fileSize"]!''}',
                        source:'${col["source"]!''}',
                        hdfsPath:'${col["hdfsPath"]!''}',
                        'dcsDataType.dataTypeName':'${col["dcsDataType"]["dataTypeName"]!''}',
                        'dcsDataType.dataTypePathReg':'${col["dcsDataType"]["dataTypePathReg"]!''}',
                        'dcsDataType.isFtpDelete':'${col["dcsDataType"]["isFtpDelete"]}',
                        'dcsDataType.isFileDelete':'${col["dcsDataType"]["isFileDelete"]}',
                        'dcsDataType.hdfsPath':'${col["dcsDataType"]["hdfsPath"]!''}',
                        'dcsDataType.pathFtp':'${col["dcsDataType"]["pathFtp"]!''}',
                        'dcsFtpServer.ftpIp':'${col["dcsFtpServer"]["ftpIp"]!''}',
                        'dcsFtpServer.ftpPort':'${col["dcsFtpServer"]["ftpPort"]!''}',
                        'dcsFtpServer.ftpUserName':'${col["dcsFtpServer"]["ftpUserName"]!''}',
                        'dcsFtpServer.ftpPassword':'${col["dcsFtpServer"]["ftpPassword"]!''}',
                        'dcsFtpServer.ftpWorkDirectory':'${col["dcsFtpServer"]["ftpWorkDirectory"]!''}',
                        'dcsFtpServer.ftpLastScanTime':'${col["dcsFtpServer"]["ftpLastScanTime"]?number_to_datetime?string("yyyy-MM-dd HH:mm:ss")}',
                        'dcsFtpServer.ftpPeriod':'${col["dcsFtpServer"]["ftpPeriod"]!''}',
                        'dcsFtpServer.scannerIp':'${col["dcsFtpServer"]["scannerIp"]!''}',
                        'dcsFtpServer.ftpLastServerTime':'${col["dcsFtpServer"]["ftpLastServerTime"]?number_to_datetime?string("yyyy-MM-dd HH:mm:ss")}',
                        'dcsFtpServer.pathFtp':'${col["dcsFtpServer"]["pathFtp"]!''}',
                        'dcsFtpServer.pathReg':'${col["dcsFtpServer"]["pathReg"]!''}'

                    });
        </#list>

        
    })
</script>
<!-- end widget grid -->


			