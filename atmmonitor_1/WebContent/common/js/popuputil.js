function PopupUtil() {}

PopupUtil.bg = null;
PopupUtil.box = null;
PopupUtil.content = null;
PopupUtil.loading = null;
PopupUtil.close = null;


PopupUtil.init = function()
{
    PopupUtil.bg = document.createElement("div");
    PopupUtil.bg.id = "popup-bg";

    PopupUtil.box = document.createElement("div");
    PopupUtil.box.id = "popup-box";
    PopupUtil.bg.appendChild(PopupUtil.box);
    
    PopupUtil.colse = document.createElement("div");
    PopupUtil.colse.id = "popup-close";
    PopupUtil.box.appendChild(PopupUtil.colse);

    PopupUtil.content = document.createElement("iframe");
    PopupUtil.content.id = "popup-content";
    PopupUtil.box.appendChild(PopupUtil.content);

    PopupUtil.loading = document.createElement("div");
    PopupUtil.loading.id = "popupLoading";
    PopupUtil.box.appendChild(PopupUtil.loading);

    document.body.appendChild(PopupUtil.bg);

    $("#popup-bg").click(function()
    {
        PopupUtil.hide();
    });
}
/**
 * 显示popup
 * @param top 距顶部距离，通常为0，则为2.5%
 * @param height 高度，-1则为90%，0则为内容的高度，0-1则为百分比，>1则为真是高度
 * @param width 宽度，-1或0则为95%，0-1则为百分比，>1则为真是宽度
 * @param url popup出的内容页面的url
 */
PopupUtil.show = function(top, height, width, url)
{
    if($("#popup-bg").length == 0) PopupUtil.init();

    document.body.style.overflow = "hidden";

    PopupUtil.box.style.height = "0px";
    PopupUtil.loading.style.display = "block";
    PopupUtil.bg.style.display = "block";
    PopupUtil.content.src = url;
    PopupUtil.content.onload = function()
    {
        PopupUtil.fixPopupSize(height, width, top);
    };
}
PopupUtil.fixPopupSize = function(height, width, top)
{
    var bgHeight = PopupUtil.bg.clientHeight * 0.90;
    var bgWidth = PopupUtil.bg.clientWidth * 0.95;
    var contentHeight = 0;
    var contentWidth = 0;
    if(height == -1)
    {
        contentHeight = bgHeight;
    }
    else if(height >= 1)
    {
        contentHeight = height;
    }
    else if(height > 0 && height < 1)
    {
        contentHeight = bgHeight * height;
    }
    else
    {
        contentHeight = $(PopupUtil.content.contentWindow.document).height();
        if(parseInt(PopupUtil.box.style.height) != parseInt(contentHeight) && parseInt(PopupUtil.box.style.height) != parseInt(bgHeight))
        {
            var delayFunc = function()
            {
                return function(h, w, t)
                {
                    PopupUtil.fixPopupSize(h, w, t);
                }(height, width, top);
            };
            setTimeout(delayFunc, 0);
        }
    }

    if(width >= 1)
    {
        contentWidth = width;
    }
    else if(width > 0 && width < 1)
    {
        contentWidth = bgWidth * width;
    }
    else
    {
        contentWidth = bgWidth;
    }

    if(contentHeight > bgHeight) contentHeight = bgHeight;
    if(contentWidth > bgWidth) contentWidth = bgWidth;

    var contentTop = 0;
    if(top > 0)
    {
        contentTop = top;
    }
    else
    {
        contentTop = (bgHeight / 0.9 - contentHeight) / 2;
    }

    PopupUtil.box.style.height = contentHeight + "px";
    PopupUtil.box.style.width = contentWidth + "px";

    var padding = (bgWidth / 0.95 - contentWidth) / 2;

    PopupUtil.box.style.marginLeft = padding + "px";
    PopupUtil.box.style.marginTop = contentTop + "px";

    PopupUtil.loading.style.display = "none";
}
PopupUtil.hide = function()
{
    PopupUtil.box.style.height = "0px";
    PopupUtil.bg.style.display = "none";
    document.body.style.overflow = "scroll";
}
PopupUtil.submit = function()
{
    PopupUtil.hide();
    window.location.reload(true);
}