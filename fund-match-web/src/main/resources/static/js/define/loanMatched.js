    $(function() {

     $(document).ready(function(){
        $.ajax({
                    url : "/v1/loan/search?"+getData(),
                    type : "GET",
                    contentType : 'application/json;charset=utf-8',
                    success : function(data) {
                        //调用创建表和填充动态填充数据的方法.
                        createShowingTable(data)
                    },
                    error : function() {
                    alert("错误");
                    }
                });
          });

       $("#query").click(function(){
                 $.ajax({
                           url : "/v1/loan/search?"+getData(),
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
      /* $('#firstTab').DataTable({
                  "paging": true,  //是否启用分页
                  "ordering": false ,//还否启用排序
                  "bFilter": false,
                  "pagingType": "input"
        });*/
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
        var len = data.result.list.length;
        for (var i = 0; i < len; i++) {
            tableStr = tableStr + "<tr><td align='center'><a href='platformInfo_examine.html' class=' btn btn-primary btn-sm' >查看</a></td>"
                    + "<td align='center'>" + data.result.list[i].appNme + "</td>"
                    + "<td align='center'>" + data.result.list[i].cardNo + "</td>"
                    + "<td align='center'>" + data.result.list[i].money + "</td>"
                    + "<td align='center'>" + data.result.list[i].mNo + "</td>"
                    + "<td align='center'>" + data.result.list[i].appNme + "</td>"
                    + "<td align='center'>" + data.result.list[i].appNme + "</td>"
                    + "<td align='center'>" + data.result.list[i].appNme + "</td>"
                    + "<td align='center'>" + data.result.list[i].appNme + "</td>"
                    + "<td align='center'>" + data.result.list[i].appNme + "</td></tr>";
        }
        $("#dataTable").html(tableStr);
    }
    function getData() {
              var ret="state=0";
              if($("#srcName").val()!=null&&$("#srcName").val()!=''){
                 ret= ret+"&srcName="+$("#srcName").val();
              }
              if($("#appId").val()!=null&&$("#appId").val()!=''){
                 ret= ret+"&appId="+$("#appId").val();
              }
              if($("#startTime").val()!=null&&$("#startTime").val()!=''){
                 ret=ret+"&startTime="+$("#startTime").val();
              }
              if($("#endTime").val()!=null&&$("#endTime").val()!=''){
                 ret=ret+"&endTime="+$("#endTime").val();
              }
             return ret;
    }