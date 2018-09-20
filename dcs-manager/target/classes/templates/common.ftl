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
                            <#if queryftl??>
                                <#--调用查询条件部分 -->
                                <#include '${queryftl}'>
                            </#if>

                            </div>
                        </div>
                        <script>
                            var dataList = [];
                        </script>
                        
                        <div id="tableContent">
                            <#--调用表格部分 -->
                            <#if tableftl??>
                             
                            <#include '${tableftl}'>
                            
                            </#if>
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
<#if scriptftl??>
    <#include '${scriptftl}'>
</#if>

<!-- end widget grid -->


			