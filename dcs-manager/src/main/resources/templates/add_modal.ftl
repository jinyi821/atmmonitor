<#--通用modal窗口-->
<div class="modal inmodal fade" id="addModalId" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="addLabel">窗口标题</h4>
                
            </div>
            <div class="modal-body">
                <!--调用明细内容 -->
                <#if formcontenturl??>
                    <#include '${formcontenturl}'>
                </#if>
               
            </div>

            <div class="modal-footer">
                <button type="button" id="closeModal" class="btn btn-white" data-dismiss="modal">关闭</button>
            
                <#if isHasSaveButton??&&isHasSaveButton=="true">
                    <button type="button" class="btn btn-primary" id="saveButton_add">保存</button>
               

                </#if>
                
            </div>
        </div>
    </div>
</div>