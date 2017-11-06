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
                               createShowingTable(data);

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
        var pageCount = data.pageCount; //取到pageCount的值(把返回数据转成object类型)
        var currentPage = data.currentPage; //得到urrentPage
        var tatol=data.tatol;
        $("#dataTable").html(tableStr);

        //分页控件
        var options = {
            bootstrapMajorVersion: 1, //版本
            numberOfPages: 5,
            currentPage: currentPage, //当前页数
            totalPages: pageCount, //总页数
            itemTexts: function (type, page, current) {
                switch (type) {
                    case "first":
                        return "首页";
                    case "prev":
                        return "上一页";
                    case "next":
                        return "下一页";
                    case "last":
                        return "末页";
                    case "page":
                        return page;
                }
            },
            onPageClicked: function (event, originalEvent, type, page) {
                $.ajax({
                    url : "/v1/loan/search?"+getData()+"&page="+page,
                    type : "GET",
                    contentType : 'application/json;charset=utf-8',
                    success: function (data) {
                        if (typeof(data) == "undefined") {
                            alert("系统繁忙");
                        } else if (data.code != 'success') {
                            alert(data.msg);
                        } else {
                            createShowingTable(data);
                        }
                    },
                    error: function () {
                        alert("错误");
                    }
                });
            }
        };
        $('#example').bootstrapPaginator(options);
        $("#tatolCount").html(tatol);
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
