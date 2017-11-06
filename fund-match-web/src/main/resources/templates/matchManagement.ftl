<!DOCTYPE html>
<html>
   <#include "header.ftl">
   <style>
       .flagBox{
           display:inline-block;
           margin-right:25px;
           position: relative;
           bottom:-7px;
       }
       .switch{
           width:60px;
           height:20px;
           background:#E4E4E4;
           margin:0 auto;
           border-radius:10px;
           border:1px solid #a4a4a4;
           position:relative;
           cursor: pointer;
           line-height:43px;
           vertical-align: baseline;
       }
       .switchBtn{
           display:block;
           width:20px;
           height:18px;
           border-radius:50%;
           background:#B5B5B5;
           position:absolute;
           left:0px;
       }
       .currentSwitch{
           background:#3C8CBB;
       }
       .currentSwitch .switchBtn{
           background:#fff;
           left:38px;
       }
       .asterisk{
           color:red;
           font-size:16px;
           vertical-align: middle;
           padding:0;
           diaplay:inline-block;
       }
       .btn-sm{
           padding:2px 6px;
       }
   </style>
  <body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">

        <#include "body_header.ftl">
        <#include "body_main_sidebar.ftl">


		 <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            配对管理   
            <small></small>
          </h1>
          <ol class="breadcrumb">
		        <li><a href="#"><i class="fa fa-dashboard"></i> 业务管理</a></li>
		        <li><a href="#">平台管理</a></li>
		        <li class="active">配对管理</li>
		      </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          <div class="row">
            <div class="col-xs-12">
              <div class="nav-tabs-custom">
                <ul class="nav nav-tabs">
                  <li class="active"><a href="javascript:;" >配对管理</a></li>
                 
                </ul>

                <div class="tab-content">
                   
                    <!-- 第一个tab -->
                    <div class="tab-pane active" id="w_product">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="box box-primary">
                                    <div class="box-body" style="padding-top:20px;">
                                        <div class="row">
                                            <form class="form-horizontal">
                                            	<div class="col-sm-12">
                                            		<div class="col-sm-5">
                                            			<label  class="col-sm-3 control-label">创建时间 : </label>
	                                                <div class="col-sm-9">
	                                                    <div class=""  style="border: none;background:none;padding:0;">
	                                                        <input type="text" class="input-sm startTime" style="border-radius:0;" width="100px" id="startTime"/>
	                                                        <span class="glyphicon glyphicon-minus"></span>
	                                                        <input type="text" class="input-sm endTime" style="border-radius:0;" id="endTime"/>
	                                                    </div>
	                                                </div>
                                            		</div>
                                            		
                                            		<div class=" col-sm-4">
                                            			<label  class="col-sm-4 control-label" >出借平台名称: </label>
	                                                <div class="col-sm-8">
	                                                    <input type="text" class="form-control input-sm" id="srcName">
	                                                </div>
                                            		</div>
                                            		<div class="col-sm-offset-2 col-sm-1">
                                                    <a   class="btn btn-primary btn-sm" onclick="addModel()">新增配对</a>
                                                </div>
                                            	</div>
                                                
                                              <div class="col-sm-12" style="margin-top:20px;">
                                            		<div class="col-sm-4">
                                            			<label  class="col-sm-4 control-label" id="tarName">借款平台名称: </label>
	                                                <div class="col-sm-8">
	                                                    <input type="text" class="form-control input-sm" id="tarName">
	                                                </div>
                                            		</div>
                                            		<div class="col-sm-offset-1 col-sm-3">
                                            			<label  class="col-sm-3 control-label">状态: </label>
	                                                <div class="col-sm-9">
                                                    <select class="form-control input-sm" id="state">
																	                  		<option value="0">全部</option>
																	                  		<option value="1">启用中</option>
																	                  		<option value="2">未启用</option>
																	                  	</select>
	                                                </div>
                                            		</div>
                                            		
                                        			  <div class="col-sm-offset-1 col-sm-1">
                                                    <input type="button" class="btn btn-primary btn-sm" value="查 询" id="query"/>
                                               </div>
                                            	</div>
                                            </form>
                                        </div>
                                        <div class="table-responsive" style="margin-top:20px;">
                                            <table class="table table-striped table-bordered text-center table-hover table-condensed " data-toggle="table" id="table">
                                                <thead>
                                                	<tr>
                                                    <th width="350">操作</th>
                                                    <th>出借平台名称</th>
                                                    <th>借款平台名称</th>
                                                    <th>创建时间</th>
                                                    <th>状态</th>
                                                  </tr>
                                                </thead>
                                                <tbody id="dataTable">
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div id="example"></div>
                    </div>
                            
									  <!--弹窗结构开始-->
									  			<!--新增配对开始-->
					<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" id="addPairing" data-backdrop="false">
                                <div class="modal-dialog " style="margin-top:150px;">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                            <h4 class="modal-title text-center">新增</h4>
                                        </div>
                                        <div class="modal-body" style="padding:20px 0;height:150px;">
                                            <form class="form-horizontal">
												<div class=" col-sm-12">
												   <div class="col-sm-6 text-center">
													   <label  class="control-label" style="line-height:36px;">出借平台: </label>
	                                                   <div class="" id="srcDiv">
	                                                   </div>
												   </div>
												   <div class="col-sm-6 text-center">
														 <label  class="control-label" style="line-height:36px;">借款平台: </label>
	                                                <div class="" id="tarDiv">
	                                                </div>
												   </div>
															                
												  </div>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-primary recall_btnsure" id="saveMatch">保存配对</button>
                                        </div>
                                    </div>
                                </div>
                    </div>
                    <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" id="modifyModel" data-backdrop="false">
                                <div class="modal-dialog " style="margin-top:150px;">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                            <h4 class="modal-title text-center">修改配对</h4>
                                        </div>
                                        <div class="modal-body" style="padding:20px 0;height:150px;">
                                            <form class="form-horizontal">
												<div class=" col-sm-12">
												   <div class="col-sm-6 text-center">
													   <label  class="control-label" style="line-height:36px;">出借平台: </label>
	                                                   <div class="" id="srcModifyDiv">
	                                                   </div>
												   </div>
												   <div class="col-sm-6 text-center">
														 <label  class="control-label" style="line-height:36px;">借款平台: </label>
	                                                <div class="" id="tarModifyDiv">
	                                                </div>
												   </div>

												  </div>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-primary recall_btnsure" id="modifySubmitMatch">保存配对</button>
                                        </div>
                                    </div>
                                </div>
                    </div>
									  			 <!--保存配对的弹窗-->
					<div class="modal fade saveInfo" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" id="save_finished" >
					                    <div class="modal-dialog modal-sm" style="margin-top:150px;">
					                      <div class="modal-content">
					                        <div class="modal-header">
					                          <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					                          <h4 class="modal-title text-center">提 示</h4>
					                        </div>
					                        <div class="modal-body">
					                          <p style="margin:20px 0;text-align:center;" class="pText">配对保存成功</p>
					                        </div>
					                        <div class="modal-footer">
					                          <button type="button" class="btn btn-primary" id="saveFinished">确定</button>
					                          
					                        </div>
					                      </div>
					                    </div>
					</div>
					                  
					                  
					                  <!--删除的确认弹窗-->
					<div class="modal fade " tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true"  id="deleteInfo">
					                    <div class="modal-dialog modal-sm" style="margin-top:150px;">
					                      <div class="modal-content">
					                        <div class="modal-header">
					                          <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					                          <h4 class="modal-title text-center">提 示</h4>
					                          <input type="hidden" id="appId">
					                           <input type="hidden" class="form-control input-sm" id="appId_delete" value="0">
					                        </div>
					                        <div class="modal-body">
					                          <p style="margin:20px 0;text-align:center;" class="pText">确认要删除？请慎重</p>
					                        </div>
					                        <div class="modal-footer">
					                          <button type="button" class="btn btn-primary" id="deleteMatched">确定</button>
					                          <button type="button" class="btn btn-default" data-dismiss="modal" id="cancelDeleteMatched">取消</button>
					                        </div>
					                      </div>
					                    </div>
					</div>
									        <!--弹窗结构结束-->
              </div>
            </div>
          </div>
        </section>
      </div>

            <#include "footer.ftl">


    </div><!-- ./wrapper -->

    <script src="js/jQuery-2.1.4.min.js"></script>
    <script src="js/asyn_page.js"></script>
    <script src="js/bootstrap-paginator.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-table.js"></script>
    <!-- Select2 -->
    <!--<script src="js/select2.full.min.js"></script>-->
    <!-- Slimscroll 滚动条插件-->
    <script src="js/jquery.slimscroll.min.js"></script>
    <!-- AdminLTE App 轻量级UI库适用于移动端-->
    <script src="js/app.min.js"></script>
    <script src="js/demo.js"></script>
    <script type="text/javascript" src="js/bootstrap-multiselect.js"></script>
    <link rel="stylesheet" href="css/bootstrap-multiselect.css" type="text/css"/>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
    <!--时间插件-->
    <script src="js/moment-with-locales.js"></script>
    <script src="js/bootstrap-datetimepicker.min.js"></script>
    //样式
    <link href="http://cdn.bootcss.com/bootstrap-table/1.9.1/bootstrap-table.min.css" rel="stylesheet"/>

    <script src="http://cdn.bootcss.com/bootstrap-table/1.9.1/bootstrap-table.min.js"></script>
    //国际化，表格汉化
    <script src="http://cdn.bootcss.com/bootstrap-table/1.9.1/locale/bootstrap-table-zh-CN.min.js"></script>
    <script src="js/define/matchManagement.js"></script>
  </body>
</html>
