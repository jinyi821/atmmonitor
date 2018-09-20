<div class="jarviswidget jarviswidget-color-darken jarviswidget-sortable" id="wid-id-0" role="widget"
     data-widget-editbutton="false">
    <!-- widget options:
    usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">
    data-widget-colorbutton="false"
    data-widget-editbutton="false"
    data-widget-togglebutton="false"
    data-widget-deletebutton="false"
    data-widget-fullscreenbutton="false"
    data-widget-custombutton="false"
    data-widget-collapsed="true"
    data-widget-sortable="false"
    -->

    <div role="content">

        <!-- widget edit box -->
        <div class="jarviswidget-editbox">
        </div>
        <!-- end widget edit box -->

        <!-- widget content -->
        <div class="widget-body no-padding" id="tableContent">
            <div class="dataTables_wrapper form-inline dt-bootstrap no-footer" id="dt_basic_wrapper">
                <div class="dt-toolbar">
                    <div class="col-xs-12 col-sm-6">
                        <div id="dt_basic_filter" class="dataTables_filter">

                        </div>
                    </div>
                    <div class="col-sm-6 col-xs-12 hidden-xs">
                        <div class="dataTables_length" id="dt_basic_length"><label>
                            <select id="pageSize" name="dt_basic_length"  class="form-control input-sm" aria-controls="dt_basic">
                            <#--<option value="1">1</option>-->
                            <option value="10">10</option>
                            <option value="25">25</option>
                            <option value="50">50</option>
                            <option value="100">100</option>
                        </select></label></div>
                    </div>
                </div>
                <#--<table width="100%" class="table table-striped table-bordered table-hover dataTable no-footer"-->
                       <#--id="dt_basic" role="grid" aria-describedby="dt_basic_info" style="width: 100%;">-->
                <table id="dt_basic"
                       class="table table-striped table-bordered table-hover dataTable no-footer"
                       role="grid" aria-describedby="dt_basic_info" style="Width:100%;table-layout:fixed;" >
                    <thead>
                    <tr role="row">
                        <th  style="width: 70px;">Probe名称
                        </th>
                        <th  style="width: 80px;">
                             主机IP
                        </th>
                        <th >
                            
                            数据分配的硬盘
                        </th>
                        <th  >硬盘总空间(GB)
                        </th>
                        <th  style="width: 140px;">硬盘剩余空间(GB)
                        </th>
                        <th  style="width: 100px;">硬盘已用空间(GB)
                        </th>
                        <th  style="width: 70px;">心跳(ms)
                        </th>
                        <th  style="width: 125px;"></i>最后修改时间
                        </th>
                        <th style="width: 60px;">
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list pageInfo.list as col>
                    <tr class="<#if col_index%2==0>odd</#if><#if col_index%2==1>even</#if>" role="row">
                        <td >${col["probe_name"]}</td>
                        <td>${col["probe_ip"]}</td>
                        <td>${col["hard_disk"]}</td>
                        <td>  <#list col.total_space?split(",") as total>
                            <#if total_has_next>
                            ${(total?eval/1024/1024/1024)?string("0.##")},
                            <#else> <!--最后一项-->
                            ${(total?eval/1024/1024/1024)?string("0.##")}
                            </#if>
                        </#list></td>
                        <td> <#list col["free_space"]?split(",") as free>
                            <#if free_has_next>
                            ${(free?eval/1024/1024/1024)?string("0.##")},
                            <#else> <!--最后一项-->
                            ${(free?eval/1024/1024/1024)?string("0.##")}
                            </#if>
                        </#list></td>
                        <td><#list col.use_space?split(",") as use>
                            <#if use_has_next>
                            ${(use?eval/1024/1024/1024)?string("0.##")},
                            <#else> <!--最后一项-->
                            ${(use?eval/1024/1024/1024)?string("0.##")}
                            </#if>
                        </#list></td>
                        <td>${col["heart_interval"]?c}</td>
                        <td>${(col["update_time"]?string("yyyy-MM-dd HH:mm:ss"))!}</td>
                        <td>
                            <button class="btn btn-primary btn-xs" onclick="findCurrentProbeRelTaskList(${col.probe_id},'${col["probe_name"]}');" data-toggle="modal" data-target="#showCurrentProbeRelTaskFile">任务文件</button>
                    </tr>
             </#list>
                    </tbody>
                </table>
             <#include "/page.ftl">
        </div>
        <!-- end widget content -->
    </div>
    <!-- end widget div -->
        <div class="modal inmodal fade" id="showCurrentProbeRelTaskFile" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                        <h4 class="modal-title" id="addLabel">当前Probe采集任务</h4>
                    </div>
                    <div class="modal-body">
                        <div class="widget-body no-padding" id="childTbleContent">
                            <!-- end widget content -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <#--<#include "current_probe_rel_task_list.ftl">-->
    </div>
</div>
<script>
    var pageSize=10;
    var childPageSize=10;
    $(document).ready(function(){
        $("#pageSize").bind('change', function () {
            pageSize = $("#pageSize").val();
            goto(1);
        });
        $("#pageSize").val(${pageInfo.pageSize});
        pageSize=${pageInfo.pageSize};
    });
    function goto(pn) {
        $("#content").load("${BASE_PATH}/probeRunning/currentProbeTaskList/", {pn: pn,pageSize:pageSize}, function (txt) {
            if (!txt) {
            }
        });
    };

    function findCurrentProbeRelTaskList(probe_id,probe_name) {
        //alert("probe_id:" + probe_id);
        $("#childTbleContent").load(
                "${BASE_PATH}/probeRunning/findDcsProbeRelCurrentTaskList/", {
                    probe_id: probe_id,
                    ftpId:null,
                    dataTypeId:null,
                    pn: 1,
                    childPageSize: 5
                }, function (txt) {
                    if (!txt) {

                    }

                });
        $("#addLabel").html("["+probe_name+"] 采集任务")
    };
    $('#addModalId').on('hidden.bs.modal', function (e) {

    });
    $('#messageModalId').on('shown.bs.modal', function (e) {

    });

</script>
