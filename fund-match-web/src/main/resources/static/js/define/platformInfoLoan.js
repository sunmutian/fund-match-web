    $(function() {

     $(document).ready(function(){
        $.ajax({
                    url : "v1/app/list?"+getData(),
                    type : "GET",
                    //data : JSON.stringify(getJsonData()),
                    contentType : 'application/json;charset=utf-8',
                    success : function(data) {
                        //调用创建表和填充动态填充数据的方法.
                        createShowingTable(data);
                    },
                    error : function() {
                        alert("错误");
                    }
                });
        });
        $("#query").click(function(){
                 $.ajax({
                           url : "v1/app/list?"+getData(),
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
        $("#modifyData").click(function(){
                  $.ajax({
                          url : "/v1/app/modify",
                          type : "POST",
                          data:JSON.stringify(getModifyParam()),
                          contentType : 'application/json;charset=utf-8',
                          success : function(data) {
                              if(data.code=='success'){
                                    $("#modifyPlatform").hide();
                                    window.location.reload();
                              }else{
                                    alert("修改失败");
                              }
                          },
                          error : function() {
                             alert("修改失败");
                          }
                  });
        });
        $('#firstTab').bootstrapTable({
        				    'pagination':true,
        				    'paginationLoop':true,
        				    'onlyInfoPagination':false,
        				    'search':false
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

    function getData() {
              var ret="type=1";
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

    function getModifyData(id){
               $('#modifyPlatform').modal('show');
               $.ajax({
                         url : "/v1/app?id="+id,
                         type : "GET",
                         contentType : 'application/json;charset=utf-8',
                         success : function(data) {
                         //调用创建表和填充动态填充数据的方法.
                                  if(data.code=='success'){
                                                 $("#app_name_mo").val(data.result.name);
                                                 $("#enterprise_mo").val(data.result.enterprise);
                                                 $("#appType_mo").val(data.result.appType);
                                                 $("#appId_mo").val(data.result.id);
                                      $("#appType_mo").prop("disabled", true);
                                  }else{
                                                 alert("错误");
                                  }
                         },
                         error : function() {
                                  alert("错误");
                          }
               });
    }
    //修改参数
    function getModifyParam(){
             var appName=$("#app_name_mo").val();
             var enterprise=$("#enterprise_mo").val();
             var appType=$("#appType_mo").val();
              var appId=$("#appId_mo").val();
              var retJson={
                   "id":appId,
                   "name":appName,
                   "enterprise":enterprise,
                   "type":appType
                   }
              return retJson;
    }