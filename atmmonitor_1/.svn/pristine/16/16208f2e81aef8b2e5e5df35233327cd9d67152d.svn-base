/**
 * Created with JetBrains WebStorm.
 * User: hupeng
 * Date: 13-3-12
 * Time: 下午4:41
 * To change this template use File | Settings | File Templates.
 * 季度选择控件，使用了datepicker的ui
 */

//浏览器类型
var Sys = {};
var ua = navigator.userAgent.toLowerCase();
var s;
(s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :
    (s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :
        (s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :
            (s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :
                (s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;

var wQuarterToggle = false;
var quarterDiv;
var focusElement;
var hiddenValueElement;
var wQuarterCallBack;

var WquarterPicker = function (opts) {
    hiddenValueElement = opts.vel;
    wQuarterCallBack = opts.callback;
    if (!wQuarterToggle) {
        //获取当前焦点所在元素
        var focusDom = document.activeElement;
        focusElement = focusDom;

        var actualLeft = getElementViewLeft(focusDom);
        var actualTop = getElementViewTop(focusDom);
        var height = focusDom.clientHeight;
        var body = document.getElementsByTagName("body")[0];

        if (Sys.ie == '7.0') {
            var div = document.createElement('<div style="position: absolute; z-index: 100004; display: block; top: ' + (actualTop + height + 4) + 'px; left: ' + (actualLeft) + 'px;width:222px;height:244px;overflow:hidden;"></div>');
            var iframe = document.createElement('<iframe idefocus="true" frameborder="0" border="0" scrolling="no" src="/Ultra-PMS/scripts/plugins/datepicker/wquarterpicker.html?' + Math.random() + '" style="width: 222px; height: 244px;" marginheight="0" marginwidth="0"></iframe>');
            quarterDiv = div;
            div.appendChild(iframe);
            body.appendChild(div);
        } else {
            var div = document.createElement("div");
            quarterDiv = div;

            div.style.position = "absolute";
            div.style.zIndex = 100004;
            div.style.display = "block";
            div.style.top = (actualTop + height + 4) + "px";
            div.style.left = (actualLeft) + "px";
            div.style.width = "222px";
            div.style.height = "244px";
            div.style.overflow = "hidden";

            var iframe = document.createElement("iframe");
            iframe.setAttribute("idefocus", "true");
            iframe.setAttribute("frameborder", "0");
            iframe.setAttribute("frameBorder", "0");
            iframe.setAttribute("border", "0");
            iframe.setAttribute("scrolling", "no");
            iframe.setAttribute("src", "/Ultra-PMS/scripts/plugins/datepicker/wquarterpicker.html?" + Math.random());
            iframe.setAttribute("style", "width: 222px; height: 244px;");
            iframe.setAttribute("marginheight", "0");
            iframe.setAttribute("marginwidth", "0");

            div.appendChild(iframe);
            body.appendChild(div);
        }
        wQuarterToggle = true;
    }

};

var quarterDivRemove = function () {
    //quarterDiv.remove();
    document.getElementsByTagName("body")[0].removeChild(quarterDiv);
    quarterDiv = undefined;
    wQuarterToggle = false;
};

function getElementViewLeft(element) {
    var actualLeft = element.offsetLeft;
    var current = element.offsetParent;
    while (current !== null) {
        actualLeft += current.offsetLeft;
        current = current.offsetParent;
    }
    if (document.compatMode == "BackCompat") {
        var elementScrollLeft = document.body.scrollLeft;
    } else {
        var elementScrollLeft = document.documentElement.scrollLeft;
    }
    return actualLeft - elementScrollLeft;
}

function getElementViewTop(element) {
    var actualTop = element.offsetTop;
    var current = element.offsetParent;
    while (current !== null) {
        actualTop += current.offsetTop;
        current = current.offsetParent;
    }
    if (document.compatMode == "BackCompat") {
        var elementScrollTop = document.body.scrollTop;
    } else {
        var elementScrollTop = document.documentElement.scrollTop;
    }
    return actualTop - elementScrollTop;
}

document.onmousedown = function (event) {
    var e = event || window.event;
    if (quarterDiv && e.target != focusElement) {
        quarterDivRemove();
        quarterDiv = undefined;
    }
    return;
};