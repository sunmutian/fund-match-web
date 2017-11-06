<!DOCTYPE html>
<html>
<#include "header.ftl">
<style>
    .div-inline{ display:inline}
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
            ${name}
            <small></small>
          </h1>
          <ol class="breadcrumb">
		        <li><a href="#"><i class="fa fa-dashboard"></i> 业务管理</a></li>
		        <li><a href="#">匹配管理</a></li>
		        <li class="active">出借匹配</li>
		      </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          <div class="row">
            <div class="col-xs-12">
              <div class="nav-tabs-custom">
                <ul class="nav nav-tabs"  id="userTabs">
                  <li class="active"><a tab-head="loanMatchWait" href="#loanMatchWait" aria-expanded="true" tab-url="loanMatchState?state=0&id=${id}">待匹配</a></li>
                  <li><a tab-head="loanMatching" href="#loanMatching" aria-expanded="true" tab-url="loanMatchState?state=1&id=${id}">匹配中</a></li>
                  <li><a tab-head="loanMatched" href="#loanMatched" aria-expanded="true" tab-url="loanMatchState?state=2&id=${id}">已匹配（待放款）</a></li>
                  <li><a tab-head="loanMatchRepaymentSucc" href="#loanMatchRepaymentSucc" aria-expanded="true" tab-url="loanMatchState?state=3&id=${id}">放款成功</a></li>
                  <li><a tab-head="loanMatchRepaymentFail" href="#loanMatchRepaymentFail" aria-expanded="true" tab-url="loanMatchState?state=4&id=${id}">放款失败</a></li>
                  <li><a tab-head="loanMatchAll" href="#loanMatchAll" aria-expanded="true" tab-url="loanMatchState?state=5&id=${id}">全部</a></li>
                </ul>

                <div class="tab-content">
                    <div class="tab-pane active" id="loanMatchWait"></div>
                    <div class="tab-pane active" id="loanMatching"></div>
                    <div class="tab-pane active" id="loanMatched"></div>
                    <div class="tab-pane active" id="loanMatchRepaymentSucc"></div>
                    <div class="tab-pane active" id="loanMatchRepaymentFail"></div>
                    <div class="tab-pane active" id="loanMatchAll"></div>
					<!--弹窗结构开始--><!--查看弹窗-->
					<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true" id="matchingLook" data-backdrop="false">
                                <div class="modal-dialog modal-lg" style="margin-top:50px;">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                            <h4 class="modal-title text-center">查看（匹配明细）</h4>
                                        </div>
                                        <div class="modal-body" style="padding:20px 20px;">
                                            <div  style="overflow:auto; padding:0;max-height:550px;">
		                                          <div class="table-responsive" style="width:1500px;">
			                                            <table class="table table-striped table-bordered text-center table-hover table-condensed">
			                                                <tbody>
			                                                    <tr>
			                                                        <th>匹配金额</th>
			                                                        <th>匹配订单编号</th>
			                                                        <th>匹配时间</th>
			                                                        <th>借款流水单号</th>
			                                                        <th>流水单号时间</th>
			                                                        <th>借款人姓名</th>
			                                                        <th>身份证号</th>
			                                                        <th>借款金额</th>
			                                                        <th>利率</th>
			                                                        <th>期限</th>
			                                                        <th>银行开户行</th>
			                                                        <th>开户支行</th>
			                                                        <th>银行卡号</th>
			                                                        <th>预留手机号</th>
			                                                    </tr>
			                                                    <tr>
			                                                        <td>1</td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                    </tr>
			                                                    <tr>
			                                                        <td>1</td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                        <td></td>
			                                                    </tr>

			                                                </tbody>
			                                            </table>
			                                        </div>
			                                      </div>
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
    <script type="text/javascript">
      $(function(){
            $('#userTabs a').click(function (e) {
              e.preventDefault()
              $("#"+$(this).attr("tab-head")).load($(this).attr("tab-url")); // ajax load页面
              $(this).tab('show');
            });
            //初始加载第一个tab
            $('#userTabs').children().first().find("a").click();
    });
    $('#table').bootstrapTable({
      				    'pagination':true,
      				    'paginationLoop':true,
      				    'onlyInfoPagination':false,
      				    'search':true
    });
    </script>
  </body>
</html>
