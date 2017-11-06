 $(function() {

     $(document).ready(function(){
        $.ajax({
                    url : "v1/app/list?"+getJsonData(),
                    type : "GET",
                    contentType : 'application/json;charset=utf-8',
                    success : function(data) {
                        createShowingTable(data)
                    },
                    error : function() {
                    alert("错误");
                    }
                });
        });
        /* $('.borrowTable').DataTable({
               		 	"paging": true,  //是否启用分页
               		 	"ordering": false ,//还否启用排序
               		 	"bFilter": false,
               		 	'pagingType': 'input'
           });*/
        $("#query").click(function(){
                 $.ajax({
                           url : "v1/app/list?"+getJsonData(),
                           type : "get",
                           contentType : 'application/json;charset=utf-8',
                           success : function(data) {
                               createShowingTable(data)
                           },
                           error : function() {
                           alert("错误");
                           }
                 });
        });
        $('#startTime').datetimepicker({
                 format: 'YYYY-MM-DD',
                 locale: moment.locale('zh-cn')
        });
        $('#endTime').datetimepicker({
                 format: 'YYYY-MM-DD',
                 locale: moment.locale('zh-cn')
        });
        $('.startTime').datetimepicker({
                 format: 'YYYY-MM-DD',
                 locale: moment.locale('zh-cn')
        });
        $('.endTime').datetimepicker({
                 format: 'YYYY-MM-DD',
                 locale: moment.locale('zh-cn')

        });
 });

 function createShowingTable(data) {

        var tableStr = "";
        var len = data.result.length;
        for (var i = 0; i < len; i++) {
             var id=data.result[i].id;
             tableStr = tableStr + "<tr><td align='center'><a href='detail?id="+id+"' class=' btn btn-primary btn-sm' >查看</a>&nbsp;&nbsp;"
                    +"<a  class='btn btn-primary btn-sm' data-toggle='modal'onclick='getModifyData("+id+")'>修改</a></td>"
                    + "<td align='center'>" + data.result[i].name + "</td>"
                    + "<td align='center'>" + data.result[i].enterprise + "</td>"
                    + "<td align='center'>" + data.result[i].postTimeStr + "</td>"
                    + "<td align='center'>" + data.result[i].appTypeStr + "</td></tr>";
        }
        $("#platformDataTable").html(tableStr);
 }
 function getJsonData() {
         var ret="type=2";
         if($("#appName").val()!=null&&$("#appName").val()!=''){
            ret= ret+"&name="+$("#appName").val();
         }
         if($("#startTime").val()!=null&&$("#startTime").val()!=''){
            ret=ret+"&startTime="+$("#startTime").val();
         }
         if($("#endTime").val()!=null&&$("#endTime").val()!=''){
            ret=ret+"&endTime="+$("#endTime").val();
         }
        return ret;
 }