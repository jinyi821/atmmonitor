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
                                <!--数据文件元数据查询条件 -->
                                <div class="col-xs-8 col-sm-8">

                                    <button class="btn btn-sm btn-primary tooltips" type="button" title="添加数据文件元数据"
                                            data-toggle="modal" data-target="#addModalId" onclick="initID(-1,-1)"
                                    ><span class="fa fa-plus"></span></button>

                                </div>

                                <div class="col-sm-4 col-xs-4 hidden-xs">
                                    <div class="dataTables_length" id="dt_basic_length">

                                        <label> <select id = "pageSize"
                                                        name="dt_basic_length" aria-controls="dt_basic"
                                                        class="form-control input-sm">
                                            <option value="10">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                        </select></label>

                                    </div>
                                </div>
                            </div>
                        </div>
                       
                        <div id="tableContent">
                            <#--调用表格部分 -->
                                <!--数据文件元数据表格 -->
                                <table id="dt_basic"
                                       class="table table-striped table-bordered table-hover dataTable no-footer"
                                       role="grid" aria-describedby="dt_basic_info" style="width:100%;table-layout:fixed;"  >
                                    <thead>
                                    <tr role="row">
                                        <th style="width: 30px;">ID</th>
                                        <th style="width: 72px;">类型名称</th>
                                        <th style="width: 240px;">正则表达式</th>
                                        <th style="width: 60px;" title="是否删除FTP文件">删除FTP?</th>
                                        <th style="width: 60px;" title="是否删除本地文件"> 删除本地?</th>
                                        <th>HDFS路径</th>
                                        <th>相对路径</th>
                                        <th style="width:50px"></th>
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
                                        <td> ${col["dataTypeId"]?c}</td>
                                        <td> ${col["dataTypeName"]!}</td>
                                        <td style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;" title=" ${col["dataTypePathReg"]?html}">
                                        ${col["dataTypePathReg"]?html}

                                        </td>
                                        <td>
                                            <#if col["isFtpDelete"]== 0>否</#if><#if col["isFtpDelete"]== 1>是</#if>
                                        </td>
                                        <td >
                                            <#if col["isFileDelete"]== 0>否</#if><#if col["isFileDelete"]== 1>是</#if>
                                        </td>
                                        <td  style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;" title=" ${col["hdfsPath"]}">
                                            ${col["hdfsPath"]}
                                        </td>
                                        <td  style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;" title=" ${col["pathFtp"]}">
                                            ${col["pathFtp"]}
                                        </td>
                                        <td>
                                            
                                            <div class="btn btn-xs btn-primary tooltips"  title="修改数据文件元数据"
                                                 data-toggle="modal" data-target="#addModalId" onclick="initID('${col_index}','${col["dataTypeId"]}')"
                                            ><span class="fa fa-pencil"></span>
                                            </div>
                                      
                                            <div class="btn btn-xs btn-primary tooltips" title="删除数据文件元数据"
                                                 onclick="initID('${col_index}','${col["dataTypeId"]}');showDi('是否删除该记录?', function(){deleteRecord()})"
                                            ><span class="fa fa-trash-o"></span>
                                            </div>
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
<!--数据文件元数据脚本 -->
<script>

    var pageSize = 10;
    var pid = -1;
    var pkid = -1;
    var dataList=[];
    function initID(_id,_pkid) {
        pid = _id;
        pkid = _pkid;

    }
    function goto(pn) {
        $("#content").load(BASE_PATH + "/dcsDataType/",
                {
                    pn: pn,

                    pageSize: pageSize,
                    refreshPart: 1
                }, function (txt) {

                    if (!txt) {

                    }

                });
    }
    function deleteRecord(){
        $.ajax({
            type:"post",
            url:BASE_PATH + "/dcsDataType/delete",
            data:{id:pkid},
            async:false,
            success:function(result){

                if (pageSize==1 && pid==1){
                    goto(${pageInfo.pageNum} -1);
                } else {
                    goto(${pageInfo.pageNum});
                }

                showMessage("删除成功!");
            }

        });
    }
    $(function () {
    $('#addModalId').on('shown.bs.modal', function () {

        var col = dataList[pid];

        resultOk=false;
        $("#dcsDataTypeForm").data('bootstrapValidator').resetForm();
        if (pid == -1) {

            $("#dataTypeName").val("");
            $("#dataTypePathReg").val("");
            $("#hdfsPath").val("");
            $("#pathFtp").val("");
            //$("#isFtpDelete").val("-1");
            //$("#isFileDelete").val("-1");
            $(":checkbox[id='isFtpDelete'][value='1']").prop("checked", "");
            $(":checkbox[id='isFileDelete'][value='1']").prop("checked", "");
            $("#addLabel").html("添加数据文件元数据");

        } else {

            var col = dataList[pid];
            $("#dataTypeName").val(col["dataTypeName"]);
            $("#dataTypePathReg").val(col["dataTypePathReg"]);
            $("#hdfsPath").val(col["hdfsPath"]);
            $("#pathFtp").val(col["pathFtp"]);
            var isFtpDelete = col["isFtpDelete"];
            if (isFtpDelete == 1) {
                $(":checkbox[id='isFtpDelete'][value='1']").prop("checked", "checked");
            } else {
                $(":checkbox[id='isFtpDelete'][value='1']").prop("checked", "");
            }
            //$("#isFtpDelete").val(isFtpDelete);
            //$("#isFtpDelete").find("option[value='" + isFtpDelete + "']").attr("selected", true);
            var isFileDelete = col["isFileDelete"];
            //$("#isFileDelete").val(isFileDelete);
            if (isFileDelete == 1) {
                $(":checkbox[id='isFileDelete'][value='1']").prop("checked", "checked");
            } else {
                $(":checkbox[id='isFileDelete'][value='1']").prop("checked", "");
            }

            $("#addLabel").html("修改数据文件元数据");
        }
        $.ajax({
            type:"post",
            url:BASE_PATH + "/dcsDataType/selectFtpServerByDataType",
            data:{dataTypeId: pkid},
            async:false,
            success:function(result){
                $("#ftpIds").empty();
                result.forEach(function(item,index){
                    $("#ftpIds").append("<option value='"+
                            item["ftpId"]+"'" +(item["dataTypeId"]? " selected='selected'":"")+ ">"+item["ftpIp"]+":"+item["ftpPort"]+"</option>");
                })

            }

        });


    });

    $("#saveButton_add").click(function(){

        //$("#dcsDataTypeForm").submit();
        //获取表单对象
        var bootstrapValidator = $("#dcsDataTypeForm").data('bootstrapValidator');
        //手动触发验证
        bootstrapValidator.validate();
        if(bootstrapValidator.isValid()){
            
            //表单提交的方法、比如ajax提交
            var dataTypeName= $("#dataTypeName").val();
            var dataTypePathReg=$("#dataTypePathReg").val();
            var isFtpDelete= 0;
            var isFileDelete= 0;
            if ($("#isFtpDelete").is(":checked")) {//选中
                isFtpDelete = 1
            } else {
                isFtpDelete = 0
            }
            if ($("#isFileDelete").is(":checked")) {//选中
                isFileDelete = 1
            } else {
                isFileDelete = 0
            }
            var hdfsPath= $("#hdfsPath").val();
            var pathFtp=$("#pathFtp").val();
            var  ftpIds=""
            $("#ftpIds option:selected").each(function () {
                if (!ftpIds) {
                    ftpIds=$(this).val();
                } else {
                    ftpIds=ftpIds+","+($(this).val());
                }

            })

            var postdata ={
                dataTypeName:dataTypeName,
                dataTypePathReg:dataTypePathReg,
                isFtpDelete:isFtpDelete,
                isFileDelete:isFileDelete,
                hdfsPath:hdfsPath,
                pathFtp:pathFtp,
                dataTypeId: pkid,
                ftpIds:ftpIds
            } ;
            $.ajax({
                type:"post",
                url:BASE_PATH + "/dcsDataType/add",
                data:postdata,
                async:false,
                success:function(result){
                    resultOk=true;
                    $('#addModalId').modal('hide');


                }

            });
        }
    });
   
   
        <#list pageInfo.list as col>
            dataList.push(
                    {
                        dataTypeId:${col["dataTypeId"]},
                        dataTypeName: '${col["dataTypeName"]}',
                        dataTypePathReg:'${col["dataTypePathReg"]}',
                        hdfsPath:'${col["hdfsPath"]}',
                        pathFtp:'${col["pathFtp"]}',
                        isFtpDelete:${col["isFtpDelete"]},
                        isFileDelete:${col["isFileDelete"]}
                    });
        </#list>
        $('#dcsDataTypeForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                dataTypeName: {
                    validators: {
                        notEmpty: {
                            message: '类型名称不能为空'
                        },
                        stringLength: {
                            min: 0,
                            max: 20,
                            message: '类型名称长度必须在0到20位之间'
                        }
                    }
                },
                dataTypePathReg: {
                    validators: {
                        notEmpty: {
                            message: '正则表达式不能为空'
                        },
                        stringLength: {
                            min: 0,
                            max: 255,
                            message: '正则表达式必须在0到255位之间'
                        }
                    }
                },
                hdfsPath: {
                    validators: {
                        notEmpty: {
                            message: 'HDFS路径不能为空'
                        },
                        stringLength: {
                            min: 0,
                            max: 500,
                            message: 'HDFS路径长度必须在0到500位之间'
                        }
                    }
                },
                pathFtp: {
                    validators: {
                        notEmpty: {
                            message: '相对路径不能为空'
                        },
                        stringLength: {
                            min: 0,
                            max: 500,
                            message: '相对路径长度必须在0到500位之间'
                        }
                    }
                }

            }

        });


    });
</script>
<!-- end widget grid -->


			