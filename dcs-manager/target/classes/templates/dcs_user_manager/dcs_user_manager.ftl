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
                                <!--用户管理查询条件-->
                                <div class="col-xs-8 col-sm-8">
                                    <div class="btn btn-sm btn-primary tooltips" title="添加用户" data-original-title=">添加用户"
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
                        <!--查询条件部分结束-->
                        <div id="tableContent">
                            <#--调用表格部分 -->
                                <!--用户管理表格-->
                                <script>
                                    dataList = [];
                                </script>
                                <table id="dt_basic"
                                       class="table table-striped table-bordered table-hover dataTable no-footer"
                                       role="grid" aria-describedby="dt_basic_info" width="100%">
                                    <thead>

                                    <tr role="row">

                                        <th style="width: 100px;">登录名</th>
                                    <#--<th style="width: 100px;">用户名</th>-->
                                    <#--<th style="width: 150px;"> 密码</th>-->
                                        <th style="width: 60px;">性别</th>
                                        <th>邮箱</th>
                                        <th style="width: 100px;"> 手机</th>
                                        <th style="width: 80px;"> 是否管理员</th>
                                        <th style="width: 60px;"> 状态</th>
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

                                        <td> ${col["loginname"]!}</td>
                                    <#--<td>  ${col["fullname"]!}</td>-->

                                    <#--<td title=" ${col["pwd"]}">-->
                                    <#--<#if col["pwd"]?? && col["pwd"]?length lt 30>-->
                                    <#--${col["pwd"]?html}-->
                                    <#--<#else>-->
                                    <#--${col["pwd"][0..29]?default("")?html}...-->
                                    <#--</#if>-->
                                    <#--</td>-->
                                        <td>
                                            <#if col["sex"]== "1">男</#if><#if col["sex"]== "2">女</#if>
                                            <#if col["sex"]== "3">未知</#if>
                                        </td>

                                        <td title=" ${col["email"]?html}">
                                            <#if col["email"]?? && col["email"]?length lt 30>
                                            ${col["email"]?html}
                                            <#else>
                                            ${col["email"][0..29]?default("")?html}...
                                            </#if>
                                        </td>
                                        <td title=" ${col["mobile"]}">
                                            <#if col["mobile"]?? && col["mobile"]?length lt 20>
                                            ${col["mobile"]}
                                            <#else>
                                            ${col["mobile"][0..19]?default("")}...
                                            </#if>
                                        </td>
                                        <td>
                                            <#if col["isadmin"]== 1>是</#if><#if col["isadmin"]== 0>否</#if>
                                        </td>
                                        <td>
                                            <#if col["status"]== 1>正常</#if><#if col["status"]== 0>停用</#if>
                                        </td>
                                        <td>
                                            
                                            <div class="btn btn-xs btn-primary tooltips" title="修改用户"
                                                 data-toggle="modal" data-target="#addModalId" onclick="initID('${col_index}','${col["id"]}')"
                                            ><span class="fa fa-pencil"></span></div>
                                        <#--
                                            <div class="btn btn-sm btn-primary"
                                                 data-toggle="modal" data-target="#messageModalId" onclick="initID('${col_index}','${col["ftpId"]}')"
                                            ><span class="fa fa-trash-o"></span></div>
                                            -->
                                            <div class="btn btn-xs btn-primary tooltips" title="删除用户"
                                                 onclick="initID('${col_index}','${col["id"]}');showDi('是否删除该记录?', function(){deleteRecord()})"
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
<<!--用户管理相关脚本-->
<script>

    var pageSize = 10;
    var pid = -1;
    var pkid = -1;
    var createtime = new Date().Format("yyyyMMddHHmmss");
    var dataList = [];
    function initID(_id, _pkid) {
        pid = _id;
        pkid = _pkid;

    }
    function goto(pn) {
        $("#content").load(BASE_PATH + "/dcsUserManager/",
                {
                    pn: pn,

                    pageSize: pageSize,
                    refreshPart: 0
                }, function (txt) {

                    if (!txt) {

                    }

                });
    }
    $('#loginname1').blur(function () {
        //获取表单对象
        var bootstrapValidator = $("#dcsForm").data('bootstrapValidator');
        //手动触发验证
        var bool = bootstrapValidator.validate("loginname");
        var bool1 = bootstrapValidator.isValid();
        ;
    });

    

   
    
    function deleteRecord() {
        $.ajax({
            type: "post",
            url: BASE_PATH + "/dcsUserManager/delete",
            data: {id: pkid},
            async: false,
            success: function (result) {

                if (pageSize == 1 && pid == 1) {
                    goto(${pageInfo.pageNum}-1);
                } else {
                    goto(${pageInfo.pageNum});
                }

                showMessage("删除成功!");
            }

        });
    }
    $(function () {
        $("#saveButton_add").click(function () {


            //获取表单对象
            var bootstrapValidator = $("#dcsForm").data('bootstrapValidator');
            //手动触发验证
            bootstrapValidator.validate();
            setTimeout(function () {
                //有remote校验要延时
                if (bootstrapValidator.isValid()) {
                    ;
                    //表单提交的方法、比如ajax提交
                    var loginname = $("#loginname").val();
                    var fullname = "" ;
                    //$("#fullname").val();
                    var pwd = $("#pwd").val();
                    var email = $("#email").val();
                    var mobile = $("#mobile").val();
                    var sex = $("input[name='sex']:checked").val();
                    var status = $("input[name='status']:checked").val();
                    if ($("#isadmin").is(":checked")) {//选中
                        isadmin = 1
                    } else {
                        isadmin = 0
                    }
                    // var isadmin = $("input[name='isadmin']:checked").val();
                    ;
                    var postdata = {
                        loginname: loginname,
                        fullname: fullname,
                        pwd: pwd,
                        email: email,
                        mobile: mobile,
                        sex: sex,
                        status: status,
                        isadmin: isadmin,
                        createtime: createtime,
                        id: pkid
                    };
                    $.ajax({
                        type: "post",
                        url: BASE_PATH + "/dcsUserManager/add",
                        data: postdata,
                        async: false,
                        success: function (result) {
                            resultOk = true;
                            $('#addModalId').modal('hide');


                        }

                    });
                }
            }, 1000);
        });
        $('#addModalId').on('shown.bs.modal', function () {

            var col = dataList[pid];
            resultOk = false;
            $("#dcsForm").data('bootstrapValidator').resetForm();
            if (pid == -1) {

                $("#loginname").val("");
                $("#loginname").removeAttr("disabled");
//            $("#fullname").val("");
                $("#pwd").val("");
                $("#pwd1").val("");
                $("#email").val("");
                $("#mobile").val("");
                $(":radio[name='sex'][value='3']").prop("checked", "checked");
                $(":radio[name='status'][value='1']").prop("checked", "checked");
                $(":checkbox[id='isadmin'][value='1']").prop("checked", "");
                $("#addLabel").html("添加用户");

            } else {

                var col = dataList[pid];
                $("#loginname").val(col["loginname"]);
                $("#loginname").attr("disabled","disabled");
//            $("#fullname").val(col["fullname"]);
                $("#pwd").val(col["pwd"]);
                $("#pwd1").val(col["pwd"]);
                $("#email").val(col["email"]);
                $("#mobile").val(col["mobile"]);
                var sex = col["sex"];
                var status = col["status"];
                var isadmin = col["isadmin"];
                $(":radio[name='sex'][value='" + sex + "']").prop("checked", "checked");
                $(":radio[name='status'][value='" + status + "']").prop("checked", "checked");
                if (isadmin == 1) {
                    $(":checkbox[id='isadmin'][value='1']").prop("checked", "checked");
                } else {
                    $(":checkbox[id='isadmin'][value='1']").prop("checked", "");
                }
                $("#addLabel").html("修改用户");
                createtime = col["createtime"];

            }


        });
        $("#pageSize").val('${pageSize}');
         <#list pageInfo.list as col>
            dataList.push(
                    {
                        loginname: '${col["loginname"]}',
                        fullname: '${col["fullname"]}',
                        pwd: '${col["pwd"]}',
                        email: '${col["email"]}',
                        mobile: '${col["mobile"]}',
                        sex: '${col["sex"]}',
                        status:${col["status"]},
                        isadmin:${col["isadmin"]},
                        createtime:${col["createtime"]?c}
                    });
        </#list>
        $('#dcsForm').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                loginname: {
                    validators: {
                        notEmpty: {
                            message: '账户名不能为空'
                        },
                        stringLength: {
                            min: 6,
                            max: 20,
                            message: '账户名长度必须在6到20位之间'
                        },
                        threshold: 6, //有6字符以上才发送ajax请求，（input中输入一个字符，插件会向服务器发送一次，设置限制，6字符以上才开始）
                        remote: {
                            //ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}
                            type: 'POST',
                            url: BASE_PATH + "/dcsUserManager/checkUser",
                            data: {
                                loginname: function () {
                                    return $('#loginname').val();
                                },
                                id: function () {
                                    return pkid;
                                }
                            },
                            dataType: "json",
                            delay: 20000,
                            //每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                            dataFilter: function (data, type) {
                                return data;
                            },
                            message: "账户名已经存在"
                        }
                    }
                },
//                fullname: {
//                    validators: {
//                        notEmpty: {
//                            message: '用户名不能为空'
//                        },
//                        stringLength: {
//                            min: 0,
//                            max: 20,
//                            message: '用户名长度必须在0到20位之间'
//                        }
//                    }
//                },
                pwd: {
                    validators: {
                        notEmpty: {
                            message: '密码不能为空'
                        },
                        stringLength: {
                            min: 0,
                            max: 10,
                            message: '密码长度必须在0到10位之间'
                        },
                        identical: {
                            field: 'pwd1',
                            message: '两次输入的密码不相符'
                        }
                    }
                },
                pwd1: {
                    validators: {
                        notEmpty: {
                            message: '确认密码不能为空'
                        },
                        stringLength: {
                            min: 0,
                            max: 10,
                            message: '确认密码长度必须在0到10位之间'
                        },
                        identical: {
                            field: 'pwd',
                            message: '两次输入的密码不相符'
                        }
                    }
                },
                email: {
                    validators: {
//                        notEmpty: {
//                            message: '邮件不能为空'
//                        },
                        stringLength: {
                            min: 0,
                            max: 50,
                            message: '邮件长度必须在0到50位之间'
                        },
                        regexp: {
                            regexp: /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/,
                            message: '邮件地址为非法'
                        }
                    }
                },
                mobile: {
                    validators: {
//                        notEmpty: {
//                            message: '手机号不能为空'
//                        },
                        stringLength: {
                            min: 0,
                            max: 20,
                            message: '手机号长度必须在0到20位之间'
                        },
                        regexp: {
                            regexp: /(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)/,
                            message: '不是有效手机号'
                        }


                    }
                }

            }

        });


    });


</script>

<!-- end widget grid -->


			