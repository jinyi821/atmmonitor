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
                                <!--FTP元数据配置查询条件-->
                                <div class="col-xs-8 col-sm-8">
                                    <div class="btn btn-sm btn-primary tooltips" title="添加FTP元数据" data-original-title="添加FTP元数据"
                                         data-toggle="modal" data-target="#addModalId" onclick="initID(-1,-1)"
                                    ><span class="fa fa-plus"></span></div>

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
                                        </select> </label>

                                    </div>
                                </div>

                            </div>

                        </div>
                      
                        <div id="tableContent">
                            <#--调用表格部分 -->
                                <table id="dt_basic"
                                       class="table table-striped table-bordered table-hover dataTable no-footer"
                                       role="grid" aria-describedby="dt_basic_info" style="width: 100%;" width="100%">
                                    <thead>

                                        <tr role="row">

                                            <th style="width: 30px;">ID</th>
                                            <th style="width: 32px;">IP</th>
                                            <th style="width: 30px;">端口</th>
                                            <th style="width: 84px;">用户名</th>
                                            <th style="width: 160px;">密码</th>
                                            <th>FTP工作目录</th>
                                            <th style="width: 40px;"> ScannerIP </th>
                                            <th style="width: 125px;" > 最后扫描时间
                                            </th>
                                            <th style="width: 65px;"> 扫描间隔(s)</th>
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
                                        <td> ${col["ftpId"]?c}</td>
                                        <td>  ${col["ftpIp"]!}</td>
                                        <td>  ${col["ftpPort"]!}</td>
                                        <td>
                                        ${col["ftpUserName"]!}

                                        </td>
                                        <td>
                                        ${col["ftpPassword"]!}

                                        </td>
                                        <td title=" ${col["ftpWorkDirectory"]}">

                                        ${col["ftpWorkDirectory"]}

                                        </td>
                                        <td>
                                        ${col["scannerIp"]!''}
                                        </td>

                                        <td>
                                        ${col["ftpLastScanTime"]?number_to_datetime?string('yyyy-MM-dd HH:mm:ss')}
                                        </td>
                                        <td>
                                        ${col["ftpPeriod"]}
                                        </td>
                                        <td>
                                           
                                            <div class="btn btn-xs btn-primary tooltips" title=" 修改FTP元数据"
                                                 data-toggle="modal" data-target="#addModalId" onclick="initID('${col_index}','${col["ftpId"]}')"
                                            ><span class="fa fa-pencil"></span></div>
                                        <#--
                                            <div class="btn btn-sm btn-primary"
                                                 data-toggle="modal" data-target="#messageModalId" onclick="initID('${col_index}','${col["ftpId"]}')"
                                            ><span class="fa fa-trash-o"></span></div>
                                            -->
                                            <div class="btn btn-xs btn-primary tooltips" title="删除FTP元数据"
                                                 onclick="initID('${col_index}','${col["ftpId"]}');showDi('是否删除该记录?', function(){deleteRecord()})"
                                            ><span class="fa fa-trash-o"></span></div>

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
<!--FTP元数据配置脚本-->
<script>

    var pageSize = 10;
    var pid = -1;
    var pkid = -1;
    var dataList = [];
    function initID(_id, _pkid) {
        pid = _id;
        pkid = _pkid;

    }
    function deleteRecord(){
        $.ajax({
            type:"post",
            url:BASE_PATH + "/dcsFtpServer/delete",
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
    function goto(pn) {
        $("#content").load(BASE_PATH + "/dcsFtpServer/",
                {
                    pn: pn,

                    pageSize: pageSize,
                    refreshPart: 1
                }, function (txt) {

                    if (!txt) {

                    }

                });
    }
    $(function () {
    $('#addModalId').on('shown.bs.modal', function () {

        var col = dataList[pid];

        $("#ftpScannerId").empty();
        <#list dcsScanners as col>
            $("#ftpScannerId").append("<option value='${col["scannerId"]}'>${col["scannerIp"]}</option>");
        </#list>
        resultOk=false;
        $("#dcsForm").data('bootstrapValidator').resetForm();
        if (pid == -1) {

            $("#ftpIp").val("");
            $("#ftpPort").val("");
            $("#ftpUserName").val("");
            $("#ftpPassword").val("");
            $("#ftpWorkDirectory").val("");
            $("#ftpLastScanTime").val("");
            $("#ftpLastScanTime_time").val("");
            $("#ftpPeriod").val("");
            $("#ftpScannerId").val("");
            $("#ftpLastServerTime").val("");
            $("#ftpLastServerTime_time").val("");
            $("#addLabel").html("添加FTP元数据");

        } else {

            var col = dataList[pid];
            $("#ftpIp").val(col["ftpIp"]);
            $("#ftpPort").val(col["ftpPort"]);
            $("#ftpUserName").val(col["ftpUserName"]);
            $("#ftpPassword").val(col["ftpPassword"]);

            $("#ftpWorkDirectory").val(col["ftpWorkDirectory"]);
            var  datetime= col["ftpLastScanTime"].split(' ');
            $("#ftpLastScanTime").val(datetime[0]);
            $("#ftpLastScanTime_time").val(datetime[1]);
            $("#ftpPeriod").val(col["ftpPeriod"]);
            $("#ftpScannerId").find("option[text='" + col["ftpScannerId"] + "']").attr("selected", true);
            var  datetime1= col["ftpLastServerTime"].split(' ');
            $("#ftpLastServerTime").val(datetime1[0]);
            $("#ftpLastServerTime_time").val(datetime1[1]);
            $("#addLabel").html("修改FTP元数据");
        }


    });

    $("#saveButton_add").click(function(){


        //$("#dcsDataTypeForm").submit();
        //获取表单对象
        var bootstrapValidator = $("#dcsForm").data('bootstrapValidator');
        //手动触发验证
        bootstrapValidator.validate();
        if(bootstrapValidator.isValid()){
            ;
            //表单提交的方法、比如ajax提交
            var ftpIp = $("#ftpIp").val();
            var ftpPort = $("#ftpPort").val();
            var ftpUserName = $("#ftpUserName").val();
            var ftpPassword = $("#ftpPassword").val();
            var ftpWorkDirectory = $("#ftpWorkDirectory").val();
            var ftpLastScanTime = $("#ftpLastScanTime").val();
            var ftpLastScanTime_time = $("#ftpLastScanTime_time").val();
            var ftpPeriod = $("#ftpPeriod").val();
            var ftpLastServerTime = $("#ftpLastServerTime").val();
            var ftpLastServerTime_time = $("#ftpLastServerTime_time").val();
            var ftpScannerId = $("#ftpScannerId").val();
            var postdata = {
                ftpIp: ftpIp,
                ftpPort: ftpPort,
                ftpUserName: ftpUserName,
                ftpPassword: ftpPassword,
                ftpWorkDirectory: ftpWorkDirectory,
                ftpLastScanTime: ConvertStrToDate(ftpLastScanTime+" "+ftpLastScanTime_time).getTime(),
                ftpPeriod: ftpPeriod,
                ftpScannerId: ftpScannerId,
                ftpLastServerTime: ConvertStrToDate(ftpLastServerTime+" "+ftpLastServerTime_time).getTime(),
                ftpId: pkid

            };

            ;
            $.ajax({
                type:"post",
                url:BASE_PATH + "/dcsFtpServer/add",
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
                            ftpId:${col["ftpId"]},
                            ftpIp: '${col["ftpIp"]}',
                            ftpPort: '${col["ftpPort"]}',
                            ftpUserName: '${col["ftpUserName"]}',
                            ftpPassword: '${col["ftpPassword"]}',
                            ftpWorkDirectory: '${col["ftpWorkDirectory"]}',
                            ftpLastScanTime: '${col["ftpLastScanTime"]?number_to_datetime?string('yyyy-MM-dd HH:mm:ss')}',
                            ftpPeriod:${col["ftpPeriod"]},
                            ftpLastServerTime: '${col["ftpLastServerTime"]?number_to_datetime?string('yyyy-MM-dd HH:mm:ss')}',
                            ftpScannerId:${col["ftpScannerId"]},
                            scannerIP: '${col["scannerIp"]}'

                        });
            </#list>
           $('#ftpLastScanTime').datepicker({

            dateFormat : 'yy-mm-dd',
            prevText : '<i class="fa fa-chevron-left"></i>',
            nextText : '<i class="fa fa-chevron-right"></i>',
            onSelect : function(selectedDate) {
                var bootstrapValidator = $("#dcsForm").data('bootstrapValidator');
                if (!selectedDate) {

                    bootstrapValidator.updateStatus('ftpLastScanTime', 'NOT_VALIDATED').validateField('ftpLastScanTime'); //错误提示信息变了
                } else {
                    bootstrapValidator.updateStatus('ftpLastScanTime', 'VALID').validateField('ftpLastScanTime');
                }
            }
        });

        $('#ftpLastServerTime').datepicker({
            dateFormat : 'yy-mm-dd',
            prevText : '<i class="fa fa-chevron-left"></i>',
            nextText : '<i class="fa fa-chevron-right"></i>',
            onSelect : function(selectedDate) {
                var bootstrapValidator = $("#dcsForm").data('bootstrapValidator');
                if (!selectedDate) {

                    bootstrapValidator.updateStatus('ftpLastServerTime', 'NOT_VALIDATED').validateField('ftpLastServerTime'); //错误提示信息变了
                } else {
                    bootstrapValidator.updateStatus('ftpLastServerTime', 'VALID').validateField('ftpLastServerTime');
                }
            }
        });
        $('#ftpLastScanTime_time').timepicker({
            defaultTime:'current',
            showMeridian:false,
            showSeconds : true ,

        }).bind("change", function(){
            selectedDate=$(this).val();
            var bootstrapValidator = $("#dcsForm").data('bootstrapValidator');
            if (!selectedDate) {

                bootstrapValidator.updateStatus('ftpLastScanTime_time', 'NOT_VALIDATED').validateField('ftpLastScanTime_time'); //错误提示信息变了
            } else {
                bootstrapValidator.updateStatus('ftpLastScanTime_time', 'VALID').validateField('ftpLastScanTime_time');
            }
        });
        $('#ftpLastServerTime_time').timepicker({
            defaultTime:'current',
            showMeridian:false,
            showSeconds : true
        }).bind("change", function(){
            selectedDate=$(this).val();
            var bootstrapValidator = $("#dcsForm").data('bootstrapValidator');
            if (!selectedDate) {

                bootstrapValidator.updateStatus('ftpLastServerTime_time', 'NOT_VALIDATED').validateField('ftpLastServerTime_time'); //错误提示信息变了
            } else {
                bootstrapValidator.updateStatus('ftpLastServerTime_time', 'VALID').validateField('ftpLastServerTime_time');
            }
        });
        $('#dcsForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                ftpIp: {
                    validators: {
                        notEmpty: {
                            message: 'FTP IP不能为空'
                        },
                        stringLength: {
                            min: 0,
                            max: 15,
                            message: 'FTP IP必须在0到15位之间'
                        },
                        regexp: {
                            regexp: /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/,
                            message: 'FTP IP不是有效IP地址'
                        }
                    }
                },
                ftpPort: {
                    validators: {
                        notEmpty: {
                            message: '端口不能为空'
                        },
                        stringLength: {
                            min: 0,
                            max: 3,
                            message: '端口长度必须在0到3位之间'
                        },
                        regexp: {
                            regexp: /^\d+$/,
                            message: '端口应为整数'
                        }
                    }
                },
                ftpUserName: {
                    validators: {
                        notEmpty: {
                            message: '用户名称不能为空'
                        },
                        stringLength: {
                            min: 0,
                            max: 50,
                            message: '用户名称长度必须在0到50位之间'
                        }
                    }
                },
                ftpPassword: {
                    validators: {
                        notEmpty: {
                            message: '用户密码不能为空'
                        },
                        stringLength: {
                            min: 0,
                            max: 20,
                            message: '用户密码长度必须在0到20位之间'
                        }
                    }
                },
                ftpWorkDirectory: {
                    validators: {
                        notEmpty: {
                            message: 'FTP工作目录不能为空'
                        },
                        stringLength: {
                            min: 0,
                            max: 30,
                            message: 'FTP工作目录长度必须在0到30位之间'
                        }
                    }
                },
                ftpLastScanTime: {
                    validators: {
                        notEmpty: {
                            message: '最后扫描日期不能为空'
                        }
                    }
                },
                ftpLastScanTime_time: {
                    validators: {
                        notEmpty: {
                            message: '最后扫描时间不能为空'
                        } ,
                        regexp: {
                            regexp: /^0[0-9]:[0-5][0-9]|1[0-9]:[0-5][0-9]|2[0-3]:[0-5][0-9]$/,
                            message: '时间为非法'
                        }
                    }
                },
                ftpPeriod: {
                    validators: {
                        notEmpty: {
                            message: '扫描间隔时长不能为空'
                        },
                        stringLength: {
                            min: 0,
                            max: 3,
                            message: '扫描间隔时长长度必须在0到3位之间'
                        },
                        regexp: {
                            regexp: /^\d+$/,
                            message: '扫描间隔时长应为整数'
                        }
                    }
                },
                ftpLastServerTime: {
                    validators: {
                        notEmpty: {
                            message: '服务器最后启动日期不能为空'
                        }
                    }
                },
                ftpLastServerTime_time: {
                    validators: {
                        notEmpty: {
                            message: '服务器最后启动时间不能为空'
                        },
                        regexp: {
                            regexp: /^0[0-9]:[0-5][0-9]|1[0-9]:[0-5][0-9]|2[0-3]:[0-5][0-9]$/,
                            message: '时间为非法'
                        }
                    }
                },
                ftpScannerId: {
                    validators: {
                        notEmpty: {
                            message: 'ScannerIP不能为空'
                        }
                    }
                }

            }

        });


    });


</script>

<!-- end widget grid -->


			