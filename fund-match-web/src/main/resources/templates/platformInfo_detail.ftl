<!DOCTYPE html>
<html>
     <#include "header.ftl">
<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">

      <#include "body_header.ftl">
      <#include "body_main_sidebar.ftl">


		 <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            平台信息
            <small></small>
          </h1>
          <ol class="breadcrumb">
		        <li><a href="#"><i class="fa fa-dashboard"></i> 业务管理</a></li>
		        <li><a href="#">平台管理</a></li>
		        <li><a href="platformInfo.html">平台信息</a></li>
		        <li class="active">查看</li>
		      </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          <div class="row">
            <div class="col-xs-12">
               <div class="box box-primary">
                <div class="box-header with-border">
                  <h3 class="box-title">平台信息</h3>
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="platformInfoIndex">返回</a>
                </div>
                <div class="box-body" >
                  <div class="row" style="padding:20px 0;">
                    <form class="form-horizontal" role="form">
                    	<div class="col-sm-12">
                    		<div class="col-sm-4">
                        <div class="form-group">
                          <label  class="col-sm-4 control-label">平台名称：</label>
                          <div class="col-sm-8" style="padding:0;">
                            <input type="text" class="form-control input-sm" value="${appName!''}">
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-4">
                        <div class="form-group">
                          <label  class="col-sm-4 control-label">所属企业：</label>
                          <div class="col-sm-8" style="padding:0;">
                            <input type="text" class="form-control input-sm" value="${enterprise!''}">
                          </div>
                        </div>
                      </div>
                      <div class=" col-sm-4">
                        <div class="form-group">
                          <label  class="col-sm-4 control-label">创建时间：</label>
                          <div class="col-sm-8" style="padding:0;">
                            <input type="text" class="form-control input-sm" value="${createTime!''}">
                          </div>
                        </div>
                      </div>
                    	</div>
                      
                      <div class="col-sm-12" style="margin-top:20px;">
                    		<div class="col-sm-4">
                        <div class="form-group">
                          <label  class="col-sm-4 control-label">匹配总金额：</label>
                          <div class="col-sm-8" style="padding:0;">
                            <input type="text" class="form-control input-sm" value="${totalAmount!''}">
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-4">
                        <div class="form-group">
                          <label  class="col-sm-4 control-label">已匹配金额：</label>
                          <div class="col-sm-8" style="padding:0;">
                            <input type="text" class="form-control input-sm" value="${matchedAmount!''}">
                          </div>
                        </div>
                      </div>
                      <div class=" col-sm-4">
                        <div class="form-group">
                          <label  class="col-sm-4 control-label">未匹配金额：</label>
                          <div class="col-sm-8" style="padding:0;">
                            <input type="text" class="form-control input-sm" value="${unMatchAmount!''}">
                          </div>
                        </div>
                      </div>
                    	</div>
                      
                      <div class="col-sm-12" style="margin-top:20px;">
                    		<div class="col-sm-4">
                        <div class="form-group">
                          <label  class="col-sm-4 control-label">匹配总人次：</label>
                          <div class="col-sm-8" style="padding:0;">
                            <input type="text" class="form-control input-sm" value="${matchedTimes!''}">
                          </div>
                        </div>
                      </div>
                      <div class="col-sm-4">
                        <div class="form-group">
                          <label  class="col-sm-4 control-label">匹配总人数：</label>
                          <div class="col-sm-8" style="padding:0;">
                            <input type="text" class="form-control input-sm" value="${matchedUsers!''}">
                          </div>
                        </div>
                      </div>
                      
                    	</div>
                      
                    </form>
                  </div>
                  <div>
                    </div>
                </div>
              </div>          
            </div>
          </div>
        </section>
      </div>


        <#include "footer.ftl">


    </div><!-- ./wrapper -->

    <!-- jQuery 2.1.4 -->
    <script src="js/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Select2 -->
    <!--<script src="js/select2.full.min.js"></script>-->
    <!-- Slimscroll 滚动条插件-->
    <script src="js/jquery.slimscroll.min.js"></script>
    <!-- AdminLTE App 轻量级UI库适用于移动端-->
    <script src="js/app.min.js"></script>
    <script src="js/demo.js"></script>
    
    <!--时间插件-->
    <script src="js/moment-with-locales.js"></script>
    <script src="js/bootstrap-datetimepicker.min.js"></script>
  </body>
</html>
