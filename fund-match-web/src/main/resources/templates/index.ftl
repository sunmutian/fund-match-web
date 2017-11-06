<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>平台信息</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- Font Awesome -->
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Select2 -->
    <link rel="stylesheet" href="css/select2.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="css/AdminLTE.min.css">
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="css/skins/_all-skins.min.css">

	 <!--<link rel="stylesheet" type="text/css" href="css/dataTables.bootstrap.css">-->
	 <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
      .btn-sm{
      	padding:2px 6px;
      }
      #myTable_wrapper .row{
      	margin:0;
      }
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
  </head>
  <body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
       <!--- header -->
       <#include "header.ftl">
       <!--- main sidebar -->
       <#include "main_sidebar.ftl">
       <!--- main -->
       <#include "${bodyMain}">
       <!--- foot -->
       <#include "foot.ftl">

    </div><!-- ./wrapper -->
    <!-- jQuery 2.1.4 -->
    <script src="js/jquery-1.11.2.min.js"></script>
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

    <script src="js/jquery.dataTables.min.js"></script>

     <!--<script src="js/dataTables.bootstrap.min.js"></script>-->
    <script src="//cdn.datatables.net/plug-ins/1.10.16/pagination/input.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.js"></script>


    <script type="text/javascript">
     $(document).ready(function () {
         var oTable = new TableInit();
                     aaater(11111);
                     oTable.Init();
                     var TableInit = function () {
                                           var oTableInit = new Object();
                                           //初始化Table
                                           oTableInit.Init = function () {
                                               $('#loan_table').bootstrapTable({
                                                   url: '/v1/app/list',         //请求后台的URL（*）
                                                   method: 'post',                      //请求方式（*）
                                                   toolbar: '#toolbar',                //工具按钮用哪个容器
                                                   striped: true,                      //是否显示行间隔色
                                                   cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                                                   pagination: true,                   //是否显示分页（*）
                                                   sortable: false,                     //是否启用排序
                                                   sortOrder: "asc",                   //排序方式
                                                   queryParams: oTableInit.queryParams,//传递参数（*）
                                                   sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                                                   pageNumber:1,                       //初始化加载第一页，默认第一页
                                                   pageSize: 50,                       //每页的记录行数（*）
                                                   pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
                                                   strictSearch: true,
                                                   clickToSelect: true,                //是否启用点击选中行
                                                   height: 460,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                                                   uniqueId: "id",                     //每一行的唯一标识，一般为主键列
                                                   cardView: false,                    //是否显示详细视图
                                                   detailView: false,                   //是否显示父子表
                                                   columns: [{
                                                       field: 'appType',
                                                       title: '平台类型'
                                                   }, {
                                                       field: 'name',
                                                       title: '平台名称'
                                                   }, {
                                                       field: 'enterprise',
                                                       title: '企业名称'
                                                   }]
                                               });
                                           });
                                 };
      });
      $(function() {
              $('#myTable').DataTable({
                    "paging": true,  //是否启用分页
                    "ordering": false ,//还否启用排序
                    "bFilter": false,
                    'pagingType': 'input'
              });
              $('.recall_btnsure').click(function(){
                   	$('#addPairing').modal('hide');
                   	$('.saveInfo').modal('show');
              })

      		  $('.borrowTable').DataTable({
      		 	"paging": true,  //是否启用分页
      		 	"ordering": false ,//还否启用排序
      		 	"bFilter": false,
      		 	'pagingType': 'input'
      		  });
      		  $('#startTime').datetimepicker({
             			  format: 'YYYY-MM-DD',
                           locale: moment.locale('zh-cn')

              });

              $('#endTime').datetimepicker({
             			  format: 'YYYY-MM-DD',
                         locale: moment.locale('zh-cn')
              });

              $('#table').bootstrapTable({
                       'pagination':true,
                        'paginationLoop':true,
                         'onlyInfoPagination':false,
                         'search':true
              });
              $('.switch').click(function(){
               		          var _this = $(this);
               		          var data = $(this).attr('data');
               		          if(data == 1){
               		            $(this).children('span').animate({left: '38px'}, 500,function(){
               		              _this.addClass('currentSwitch').attr('data', 0);
               		            });
               		          }else{
               		            $(this).children('span').animate({left: '0px'}, 500,function(){
               		              _this.removeClass('currentSwitch').attr('data', 1);

               		            });
               		          }
              });

      })
        </script>
  </body>
</html>
