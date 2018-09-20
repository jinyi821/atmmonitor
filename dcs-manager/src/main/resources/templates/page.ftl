<!--通用分页部分-->
<div class="dt-toolbar-footer">
    <div class="col-sm-6 col-xs-12 hidden-xs">
        <div class="dataTables_info" id="dt_basic_info" role="status" aria-live="polite">
            总共  ${pageInfo.total} 条记录
        </div>
    </div>
    <div class="col-xs-12 col-sm-6">
        <div class="dataTables_paginate paging_simple_numbers" id="dt_basic_paginate">
            <ul class="pagination">
                <#if pageInfo.hasPreviousPage>
                   
                    <li class="paginate_button previous tooltips" id="dt_basic_previous" title="前一页">
                        <a href="javascript:void(0)" aria-controls="dt_basic" data-dt-idx="0" tabindex="0" onclick="goto('${pageInfo.pageNum-1}')">
                            <span class="fa fa-backward tooltips" title="前一页"></span>
                        </a>
                    </li>
                </#if>
                <#list pageInfo.navigatepageNums as page_num>
                    <#if page_num == pageInfo.pageNum>
                        
                        <li class="paginate_button active">
                            <a href="javascript:void(0)" aria-controls="dt_basic"  data-dt-idx="${page_num_index}" tabindex="0">
                                ${page_num}
                            </a>
                        </li>
                    <#else>
                        <li class="paginate_button ">
                            <a href="javascript:void(0)" onclick="goto('${page_num}')" aria-controls="dt_basic"
                               data-dt-idx="${page_num_index}" tabindex="0">${page_num}
                            </a>
                        </li>
                        
                    </#if>
                </#list>
               
                <li class="paginate_button next tooltips" title="后一页" id="dt_basic_next">
                <#if pageInfo.hasNextPage>
                    <a href="javascript:void(0)"  onclick="goto('${pageInfo.pageNum+1}')"
                       aria-controls="dt_basic" data-dt-idx="8"  tabindex="0">
                        <span class="fa fa-forward"></span>
                    </a>
                </#if>
                    
                </li>
            </ul>
        </div>
    </div>
</div>