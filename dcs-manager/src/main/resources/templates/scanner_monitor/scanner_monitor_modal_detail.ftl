<!--Scanner监控明细TAB部分-->
    <header role="heading">
       
        <ul class="nav nav-tabs pull-left in">

            <li class="active">

                <a data-toggle="tab" href="#hr1" aria-expanded="false"> <span class="hidden-mobile hidden-tablet"> FTP服务器</span> </a>

            </li>

            <li>
                <a data-toggle="tab" href="#hr2" aria-expanded="true">  <span class="hidden-mobile hidden-tablet"> 数据类型   </span> </a>
            </li>

        </ul>
        <span class="jarviswidget-loader"><i class="fa fa-refresh fa-spin"></i></span></header>

    <!-- widget div-->
    <div role="content">

        <!-- widget edit box -->
        <div class="jarviswidget-editbox">
            <!-- This area used as dropdown edit box -->

        </div>
        <!-- end widget edit box -->

        <!-- widget content -->
        <div class="widget-body">

            <div class="tab-content">
                <div class="tab-pane active" id="hr1">

                    <!--Scanner监控ftpserver明细-->
                    <div role="content">

                        <!-- widget edit box -->
                        <div class="jarviswidget-editbox">
                            <!-- This area used as dropdown edit box -->

                        </div>
                        <!-- end widget edit box -->

                        <!-- widget content -->
                        <div class="widget-body">
                            <table id="displayTable" class="table table-bordered table-striped" style="clear: both">
                                <tbody>
                                <tr>
                                    <td >FTP IP</td>
                                    <td ><label class="control-label" id="ftpIp"></label></td>
                                </tr>
                                <tr>
                                    <td >FTP端口</td>
                                    <td ><label class="control-label" id="ftpPort"></label></td>
                                </tr>
                                <tr>
                                    <td>FTP用户名</td>
                                    <td><label class="control-label" id="ftpUserName"></label></td>
                                </tr>
                                <tr>
                                    <td>FTP密码</td>
                                    <td><label class="control-label" id="ftpPassword"></label></td>
                                </tr>
                                <tr>
                                    <td>FTP工作目录</td>
                                    <td><label class="control-label" id="ftpWorkDirectory"></label></td>
                                </tr>
                                <tr>
                                    <td>最后扫描时间</td>
                                    <td><label class="control-label" id="ftpLastScanTime"></label></td>
                                </tr>

                                <tr>
                                    <td>扫描间隔时长(s)</td>
                                    <td><label class="control-label" id="ftpPeriod"></label></td>
                                </tr>
                                <tr>
                                    <td>ScannerIP</td>
                                    <td><label class="control-label" id="scannerIp"></label></td>
                                </tr>
                                <tr>
                                    <td>服务器最后启动时间</td>
                                    <td><label class="control-label" id="ftpLastServerTime"></label></td>
                                </tr>




                                </tbody>
                            </table>


                        </div>
                        <!-- end widget content -->

                    </div>

                </div>
                <div class="tab-pane " id="hr2">

                    <!--Scanner监控数据类型明细-->
                    <div role="content">

                        <!-- widget edit box -->
                        <div class="jarviswidget-editbox">
                            <!-- This area used as dropdown edit box -->

                        </div>
                        <!-- end widget edit box -->
                        <!-- widget content -->
                        <div class="widget-body">

                            <table id="displayTable" class="table table-bordered table-striped" style="clear: both">
                                <tbody>
                                <tr>
                                    <td >类型名称</td>
                                    <td ><label class="control-label" id="dataTypeName1"></label></td>
                                </tr>
                                <tr>
                                    <td>正则表达式</td>
                                    <td><label class="control-label" id="dataTypePathReg"></label></td>
                                </tr>
                                <tr>
                                    <td>是否删除FTP文件</td>
                                    <td><label class="control-label" id="isFtpDelete"></label></td>
                                </tr>
                                <tr>
                                    <td>是否删除本地文件</td>
                                    <td><label class="control-label" id="isFileDelete"></label></td>
                                </tr>
                                <tr>
                                    <td>文件存储HDFS路径</td>
                                    <td><label class="control-label" id="hdfsPath1"></label></td>
                                </tr>

                                <tr>
                                    <td>文件转义相对路径</td>
                                    <td><label class="control-label" id="pathFtp"></label></td>
                                </tr>

                                </tbody>
                            </table>


                        </div>
                        <!-- end widget content -->

                    </div>
                </div>
            </div>

        </div>
        <!-- end widget content -->

    </div>
    <!-- end widget div -->

<#--</div>-->