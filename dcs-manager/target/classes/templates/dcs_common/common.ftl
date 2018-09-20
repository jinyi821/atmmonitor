<!DOCTYPE html>
<html lang="en-us">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <base href="${BASE_PATH}/smartadmin/" />
    <title>DCS集群管理系统</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <#include '/dcs_common/common_css.ftl'>
    <script src="${BASE_PATH}/smartadmin/js/libs/jquery-3.2.1.min.js"></script>

</head>
<body class="">

    <!-- HEADER -->
    <#include '/dcs_common/common_header.ftl'>
    <!-- END HEADER -->

<!-- Left panel : Navigation area -->
<!-- Note: This width of the aside area can be adjusted through LESS variables -->
    <#include '/dcs_common/common_left_panel.ftl'>
<!-- END NAVIGATION -->

<!-- MAIN PANEL -->

    <#include '/dcs_common/common_main.ftl'>
<!-- END MAIN PANEL -->

<!-- PAGE FOOTER -->
    <#include '/dcs_common/common_page_footer.ftl'>

<!-- END PAGE FOOTER -->
    <#include '/dcs_common/common_script.ftl'>
<script>
    var BASE_PATH = "${BASE_PATH}";
    var    oldURL="";
    
    function initPage() {

        var functionName='${function}';
        var breadcrumb = $("nav").find("." + functionName).attr("breadcrumb");
        var funArray = breadcrumb.split("#");
        $(".breadcrumb").html("");
        var content = "";
        for (var i = 0; i < funArray.length; i++) {
            var n = i + 1;
            if (content == "") {
                content = "<li>" + funArray[i] + "</li>";
            } else {
                content = content + "<li>" + funArray[i] + "</li>"
            }
        }
        $(".breadcrumb").html(content);

    }

    function  goFunPage(targetTabId,targetHref,targetFunction){

        var funArray=targetFunction.split("#");
        var content="";
        for(var i=0;i<funArray.length;i++){
            var n=i+1;
            if (content==""){
                content="<li>"+funArray[i]+"</li>";
            }else {
                content=content+"<li>"+funArray[i]+"</li>";
            }
        }
        $(".breadcrumb").html(content);
        // $("#mainContent").html(loadingHtml);
        targetHref = targetHref.substring(1);
        targetHref = targetHref.replace("#", "/");
        window.location.href = "${BASE_PATH}/" + targetHref + "/";
        oldURL= "${BASE_PATH}/" + targetHref + "/";
    };
    function refreshPage(){

        $("#content").load( oldURL, {}, function (txt) {
            if (!txt) {
            }

        })
    }

    $(document).ready(function() {

        // DO NOT REMOVE : GLOBAL FUNCTIONS!
        pageSetUp();

        /*
         * PAGE RELATED SCRIPTS
         */

       /* $(".js-status-update a").click(function() {
            var selText = $(this).text();
            var $this = $(this);
            $this.parents('.btn-group').find('.dropdown-toggle').html(selText + ' <span class="caret"></span>');
            $this.parents('.dropdown-menu').find('li').removeClass('active');
            $this.parent().addClass('active');
        });
         */
        /*
        * TODO: add a way to add more todo's to list
        */

        // initialize sortable
        $(function() {
            $("#sortable1, #sortable2").sortable({
                handle : '.handle',
                connectWith : ".todo",
                update : countTasks
            }).disableSelection();
        });

        // check and uncheck
        $('.todo .checkbox > input[type="checkbox"]').click(function() {
            var $this = $(this).parent().parent().parent();

            if ($(this).prop('checked')) {
                $this.addClass("complete");

                // remove this if you want to undo a check list once checked
                //$(this).attr("disabled", true);
                $(this).parent().hide();

                // once clicked - add class, copy to memory then remove and add to sortable3
                $this.slideUp(500, function() {
                    $this.clone().prependTo("#sortable3").effect("highlight", {}, 800);
                    $this.remove();
                    countTasks();
                });
            } else {
                // insert undo code here...
            }

        })

        // count tasks
        function countTasks() {

            $('.todo-group-title').each(function() {
                var $this = $(this);
                $this.find(".num-of-tasks").text($this.next().find("li").size());
            });
        }
        initPage();
    });


</script>

<!-- Your GOOGLE ANALYTICS CODE Below -->
<script>
    function showDi(message, f) {

        $.SmartMessageBox({
            title : "提示信息",
            content : message,
            buttons : '[否][是]'
        }, function(ButtonPressed) {
            if (ButtonPressed === "是") {

                f();
            }
            if (ButtonPressed === "否") {

            }

        });
    }
    function logout(){

        $.ajax({
            type: "post",
            url: BASE_PATH+"/logout",
            async: false,
            success: function (result) {

                if (result=="1"){
                    //toastr.info("退出登录成功!");
                    window.location.href= BASE_PATH+"/"
                } else {
                    // toastr.info("退出登录失败!");
                }

            }

        });
    }
    (function ($) {
        //同样先备份下jquery的load方法
        var _load = $.fn.load;
        $.fn.extend({
            load: function (url, param, calbck) {

                param.loadAjax=true;

                calbck = function (response, status, xhr) {

                    if ( response=='nologinUser'){

                        window.location.href = BASE_PATH + "/"
                    }

                }
                //其他操作和处理
                //..
                //此处用apply方法调用原来的load方法，因为load方法属于对象，所以不可直接对象._load（...）
                var old = _load.apply(this, [url, param, calbck]);

                return old;

            }
        });


    })
    (jQuery);


</script>

</body>

</html>