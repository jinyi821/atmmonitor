<!--FTP元数据配置明细-->
<div role="content">

    <!-- widget edit box -->
    <div class="jarviswidget-editbox">
        <!-- This area used as dropdown edit box -->

    </div>
    <!-- end widget edit box -->

    <!-- widget content -->
    <div class="widget-body">

        <form class="form-horizontal" id="dcsForm" method="post">
            <fieldset>

                <div class="form-group">
                    <label class="col-md-2 control-label">FTP IP </label>
                    <div class="col-md-10">
                        <input id="ftpIp" name="ftpIp" class="form-control" placeholder="输入FTP IP" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">FTP端口 </label>
                    <div class="col-md-10">
                        <input class="form-control" id="ftpPort" name="ftpPort" placeholder="输入FTP端口" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">用户名 </label>
                    <div class="col-md-10">
                        <input class="form-control" id="ftpUserName" name="ftpUserName" placeholder="输入用户名" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">密码 </label>
                    <div class="col-md-10">
                        <input class="form-control" id="ftpPassword" name="ftpPassword" placeholder="输入密码" type="text">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-2 control-label">FTP工作目录 </label>
                    <div class="col-md-10">
                        <input class="form-control" id="ftpWorkDirectory" name="ftpWorkDirectory"
                               placeholder="输入FTP工作目录" type="text">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-2 control-label">ScannerIP</label>
                    <div class="col-md-10">
                        <select class="form-control input" id="ftpScannerId"
                                name="ftpScannerId"
                                aria-controls="dt_basic"
                                placeholder="输入SCANNERIP">

                        </select>

                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">最后扫描日期</label>
                    <div class="col-md-10">
                        <input class="form-control " id="ftpLastScanTime" name="ftpLastScanTime"
                               autocomplete="off"   placeholder="输入最后扫描日期" type="text">

                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">最后扫描时间</label>
                    <div class="col-md-10">
                       
                        <input class="form-control " id="ftpLastScanTime_time" name="ftpLastScanTime_time"
                               autocomplete="off"  placeholder="输入最后扫描时间" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">扫描间隔时长(s)</label>
                    <div class="col-md-10">
                        <input class="form-control" id="ftpPeriod" name="ftpPeriod"
                               placeholder="输入扫描间隔时长" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">服务器最后启动日期</label>
                    <div class="col-md-10">
                        <input class="form-control ui_timepicker" id="ftpLastServerTime" name="ftpLastServerTime" autocomplete="off"
                               placeholder="输入服务器最后启动日期" type="text">
                    </div>
                    
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">服务器最后启动时间</label>
                    
                    <div class="col-md-10">
                        <input class="form-control " id="ftpLastServerTime_time" name="ftpLastServerTime_time"
                               placeholder="输入服务器最后启动时间" autocomplete="off" type="text">
                    </div>
                </div>

            </fieldset>


        </form>

    </div>
    <!-- end widget content -->

</div>