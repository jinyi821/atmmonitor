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
                                <div class="col-xs-10 col-sm-10">
                                    <div id="dt_basic_filter" class="dataTables_filter">
                                        <form id="searchForm" method="post" >
                                            <label>

                                                <select id ="probeId" name="dt_basic_length" aria-controls="dt_basic"  class="form-control input">

                                                    <option value='-1'  >所有Probe</option>
                                                <#list dcsProbeList as col>
                                                    <option value='${col["probe_id"]}' <#if col.probe_id==probeId > selected</#if>>${col["probe_name"]}</option>;
                                                </#list>
                                                </select>
                                                <select id ="ftpId"  name="dt_basic_length" aria-controls="dt_basic"
                                                        class="form-control input">

                                                    <option value='-1'  >所有FTP</option>
                                                <#list ftpServerList as col>
                                                    <option value='${col["ftpId"]}' <#if col.ftpId==ftpId > selected</#if> >${col["ftpIp"]}</option>;
                                                </#list>
                                                </select>
                                                <select id="dataTypeId" name="dt_basic_length" aria-controls="dt_basic"
                                                        class="form-control input">

                                                    <option value='-1'  >所有数据类型</option>
                                                <#list dcsDataTypeList as col>
                                                    <option value='${col["dataTypeId"]}'<#if col.dataTypeId==dataTypeId > selected</#if> >${col["dataTypeName"]}</option>
                                                </#list>
                                                </select>

                                                <select id="fileStatus" name="dt_basic_length" aria-controls="dt_basic" class="form-control input">

                                                    <option value='-1'  >所有状态</option>
                                                <#list fileStatusEnumList as col>
                                                    <option value='${col["code"]}' <#if col.code==fileStatus> selected</#if>>${col["context"]}</option>
                                                </#list>
                                                </select>
                                                <input id="fileName" name="fileName" value="${fileName!}"
                                                       class="form-control" style="display:inline-block;width:100px;" placeholder="文件名称"  type="text"/>
                                                <button id="searchButton" class="btn btn-default btn-primary" type="button">
                                                    <i class="fa fa-search"></i> 搜索
                                                </button>

                                            </label>
                                        </form>
                                    </div>

                                </div>

                                <div class="col-sm-2 col-xs-2 hidden-xs">
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
                                       role="grid" aria-describedby="dt_basic_info" style="width: 100%;table-layout:fixed;" width="100%">
                                    <thead>

                                    <tr role="row">
                                        <th style="width:65px;">Probe名称</th>
                                        <th style="width:80px;">任务FTP</th>
                                        <th style="width:70px;">数据类型</th>
                                        <th >FTP路径文件</th>
                                        <th style="width:150px;">改名文件名称</th>
                                        <th style="width:125px;">文件下载时间
                                        </th>
                                        <th style="width:180px;">目标HDFS路径</th>
                                        <th style="width:30px;">状态
                                        </th>
                                    <#--<th tabindex="0" aria-controls="dt_basic" style="width: 60px;"
                                        aria-label=" Date: activate to sort column ascending" rowspan="1" colspan="1"><i
                                            class="fa fa-fw txt-color-blue hidden-md hidden-sm hidden-xs"></i> 操作
                                    </th>-->
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
                                        <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;" >${col["probe_name"]}</td>
                                        <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${col["ftp_ip"]!}</td>
                                        <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${col["data_type_name"]!}</td>
                                        <td  style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;" title='${col["ftp_path_and_name"]}'>${col["ftp_path_and_name"]}</td>
                                        <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;" title='${col["rename_file_name"]}'>${col["rename_file_name"]}</td>
                                        <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">  ${(col["file_insert_time"]?string("yyyy-MM-dd HH:mm:ss"))!}</td>
                                        <td  style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;" title='${col["hdfs_path"]}'>${col["hdfs_path"]}</td>
                                        <td title="${col.getDcsFileStatusEnum().titleContext}">
                                        ${col.getDcsFileStatusEnum().htmlContent}
                                        </td>
                                    <#--<td>
                                        <button class="btn btn-primary" onclick="findCurrentProbeRelTaskList(${col.probe_id});" data-toggle="modal" data-target="#showCurrentProbeRelTaskFile">采集文件</button>
                                    </td>-->
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
    var pageSize=10;
    var probeId=-1;
    var ftpId=-1;
    var dataTypeId=-1;
    var fileName=null;
    var fileStatus=-1;

    
    function goto(pn) {

        probeId=$("#probeId").val();
        ftpId= $("#ftpId").val();
        dataTypeId = $("#dataTypeId").val();
        fileStatus=$("#fileStatus").val();
        fileName=$("#fileName").val();
        pageSize = $("#pageSize").val();

        $("#content").load("${BASE_PATH}/probeRunning/dealFailureFile/", {probeId:probeId,ftpId:ftpId,dataTypeId:dataTypeId,fileStatus:fileStatus,fileName:fileName,pn: pn,pageSize:pageSize,refreshPart:1}, function (txt) {
            if (!txt) {
            }
        });
    };
</script>

<!-- end widget grid -->


			