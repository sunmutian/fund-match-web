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
                    <#include "debitMatchContentHeader.ftl">

                        <!-- Main content -->
                        <section class="content">
                            <div class="row">
                                <div class="col-xs-12">
                                    <div class="nav-tabs-custom">
                                        <ul class="nav nav-tabs"  id="userTabs">
                                             <li class="active"><a tab-head="debitMatchWait" href="#debitMatchWait" aria-expanded="true" tab-url="debitMatchState?state=0&id=${id}">待匹配</a></li>
                                             <li><a tab-head="debitMatched" href="#debitMatched" aria-expanded="true" tab-url="debitMatchState?state=1&id=${id}">已匹配（待放款）</a></li>
                                             <li><a tab-head="debitMatchRepaymentSucc" href="#debitMatchRepaymentSucc" aria-expanded="true" tab-url="debitMatchState?state=2&id=${id}">放款成功</a></li>
                                             <li><a tab-head="debitMatchRepaymentFail" href="#debitMatchRepaymentFail" aria-expanded="true" tab-url="debitMatchState?state=3&id=${id}">放款失败</a></li>
                                             <li><a tab-head="debitMatchAll" href="#debitMatchAll" aria-expanded="true" tab-url="debitMatchState?state=4&id=${id}">全部</a></li>
                                        </ul>

                                        <div class="tab-content">
                                             <div class="tab-pane active" id="debitMatchWait"></div>
                                             <div class="tab-pane active" id="debitMatched"></div>
                                             <div class="tab-pane active" id="debitMatchRepaymentSucc"></div>
                                             <div class="tab-pane active" id="debitMatchRepaymentFail"></div>
                                             <div class="tab-pane active" id="debitMatchAll"></div>
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
    <script src="js/bootstrap-table.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.js"></script>

    <!--时间插件-->
    <script src="js/moment-with-locales.js"></script>
    <script src="js/bootstrap-datetimepicker.min.js"></script>

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
