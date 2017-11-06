$(function () {

    $(document).ready(function () {

        //初始化
        $.ajax({
            url: "v1/app_ref/list?" + getParamData(),
            type: "GET",
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                if (typeof(data) == "undefined") {
                    alert("系统繁忙");
                } else if (data.code != 'success') {
                    alert(data.msg);
                } else {
                    createShowingTable(data)
                }
            },
            error: function () {
                alert("错误");
            }
        });
    });

    //查询
    $("#query").click(function () {
        $.ajax({
            url: "v1/app_ref/list?" + getParamData(),
            type: "GET",
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                if (data == null) {
                    alert("系统繁忙");
                } else if (data.code != 'success') {
                    alert(data.msg);
                } else {
                    createShowingTable(data)
                }
            },
            error: function () {
                alert("系统繁忙");
            }
        });
    });
    //新建
    $("#saveMatch").click(function () {
        if ($("#tarSelect").val() == null) {
            alert("空");
            return;
        }
        $.ajax({
            url: "match",
            data: JSON.stringify(getSaveParamData()),
            type: "POST",
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                if (data.code != 'success') {
                    alert(data.msg);
                }
            },
            error: function () {
                alert("系统繁忙");
            }
        });
    });
    //删除
    $("#deleteMatched").click(function () {
        $.ajax({
            url: "deleteMatch",
            data: JSON.stringify(getDeleteParamData()),
            type: "POST",
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                if (data.code != 'success') {
                    alert(data.msg);
                } else {
                    $("#deleteInfo").hide();
                    window.location.reload();
                }
            },
            error: function () {
                alert("系统繁忙");
            }
        });
    });
    //修改doModify
    $("#modifySubmitMatch").click(function () {
        $.ajax({
            url: "modify",
            data: JSON.stringify(getModifyParamData()),
            type: "POST",
            contentType: 'application/json;charset=utf-8',
            success: function (data) {
                if (data.code != 'success') {
                    alert(data.msg);
                } else {
                    $("#deleteInfo").hide();
                    window.location.reload();
                }
            },
            error: function () {
                alert("系统繁忙");
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
    $('table').on('click','.switch',function () {
        var _this = $(this);
        var data = $(this).attr('data');
        var obArray=data.split("|");
        if (obArray[0] == 1) {//开
            $(this).children('span').animate({left: '38px'}, 500, function () {
                _this.addClass('currentSwitch').attr('data',"0|"+obArray[1] );
                var data= {
                    "appId": obArray[1],
                    "enabled": true
                };
                doOnOrOff(data);//请求后台
            });
        } else {//关
            $(this).children('span').animate({left: '0px'}, 500, function () {
                _this.removeClass('currentSwitch').attr('data', "1|"+obArray[1] );

                var data= {
                    "appId": obArray[1],
                    "enabled": false
                };
                doOnOrOff(data);//请求后台
            });
        }
    });
    //保存弹窗的点击关闭的效果
    $('.recall_btnsure').click(function () {
        $('#addPairing').modal('hide');
        $('.saveInfo').modal('show');
    });
    $('#saveFinished').click(function () {
        $("#save_finished").hide();
        window.location.reload();
    });
});
function getOnOrOffData(srcAppId,enabled) {
    var retJson = {
        "appId": srcAppId,
        "enabled": enabled
    };
    return retJson;
}
function doOnOrOff(data) {
    $.ajax({
        url: "onOff",
        data: JSON.stringify(data),
        type: "POST",
        contentType: 'application/json;charset=utf-8',
        success: function (data) {
            if (data.code != 'success') {
                alert(data.msg);
            } else {
                $("#deleteInfo").hide();
                window.location.reload();
            }
        },
        error: function () {
            alert("系统繁忙");
        }
    });
}

/**
 * table数据展开显示
 */
function createShowingTable(data) {

    var tableStr = "";
    var len = data.result.length;
    for (var i = 0; i < len; i++) {
        var sw="";
        if(data.result[i].enableData==0){
            sw="<div class='clearfix flagBox'><div class='switch currentSwitch'  data='" +data.result[i].enableData+"|"+data.result[i].srcAppId+
            "'><span class='switchBtn'></span></div></div>";
        }else {
            sw="<div class='clearfix flagBox'><div class='switch '  data='" +data.result[i].enableData+"|"+data.result[i].srcAppId+
                "'><span class='switchBtn'></span></div></div>";
        }
        tableStr = tableStr + "<tr><td align='center'>" +sw+
            "<a  class='btn btn-primary btn-sm' onclick='modifyMatch(" + data.result[i].srcAppId + ")'>修改</a>&nbsp;&nbsp;"
            + "<a  class=' btn btn-primary btn-sm' onclick='deleteMatch(" + data.result[i].srcAppId + ")'>删除</a>"
            + "<td align='center'>" + data.result[i].srcName + "</td>"
            + "<td align='center'>" + data.result[i].tarNames + "</td>"
            + "<td align='center'>" + data.result[i].createTime + "</td>"
            + "<td align='center'>" + data.result[i].enabled + "</td></tr>";
    }


    var pageCount = 5; //取到pageCount的值(把返回数据转成object类型)
    var currentPage = 1; //得到urrentPage

    $("#dataTable").html(tableStr);
    //分页控件
   /* var options = {
        bootstrapMajorVersion: 1, //版本
        numberOfPages: 10,
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
                url: "v1/app_ref/list?" + getParamData()+"&page="+page,
                type: "GET",
                contentType: 'application/json;charset=utf-8',
                success: function (data) {
                    if (typeof(data) == "undefined") {
                        alert("系统繁忙");
                    } else if (data.code != 'success') {
                        alert(data.msg);
                    } else {
                        createShowingTable(data)
                    }
                },
                error: function () {
                    alert("错误");
                }
            });
        }
    };
    $('#example').bootstrapPaginator(options);*/
}

function getParamData() {
    var ret = "enabled=" + $("#state").val();
    if ($("#srcName").val() != null && $("#srcName").val() != '') {

        ret = ret + "&srcName=" + $("#srcName").val();
    }
    if ($("#startTime").val() != null && $("#startTime").val() != '') {
        ret = ret + "&startTime=" + $("#startTime").val();
    }
    if ($("#endTime").val() != null && $("#endTime").val() != '') {
        ret = ret + "&endTime=" + $("#endTime").val();
    }
    return ret;
}

function getSaveParamData() {
    var retJson = {
        "srcAppId": $("#srcSelect").val(),
        "tarAppIds": $("#tarSelect").val()
    };
    return retJson;
}

function getDeleteParamData() {
    var srcAppId = $("#appId_delete").val();
    var retJson = {
        "appId": srcAppId
    };
    return retJson;
}
function getModifyParamData() {
    var retJson = {
        "srcAppId": $("#srcModifySelect").val(),
        "tarAppIds": $("#tarModifySelect").val()
    };
    return retJson;
}
/**
 * 新建model展开和页面显示
 */
function addModel() {
    $('#addPairing').modal('show');
    $.ajax({
        url: "/v1/lists/list",
        type: "GET",
        contentType: 'application/json;charset=utf-8',
        success: function (data) {
            if (data.code == 'success') {
                setAddData(data);
            }
        },
        error: function () {

        }
    });

}

/**
 * 修改model展开和页面显示
 */
function modifyMatch(id) {
    $('#modifyModel').modal('show');

    $.ajax({
        url: "/modify/" + id,
        type: "GET",
        contentType: 'application/json;charset=utf-8',
        success: function (data) {
            if (data.code == 'success') {
                var srcDiv = "<select class='form-control' id='srcModifySelect'>";
                srcDiv = srcDiv + "<option value='" + data.result.srcAppId + "'>" + "<div id='srcOption'>" + data.result.srcName + "</div>" + "</option>";
                srcDiv = srcDiv + "</select>";
                $("#srcModifyDiv").html(srcDiv);
                var objArray=data.result.tarAppIds;
                $.ajax({
                    url: "/v1/lists/list",
                    type: "GET",
                    contentType: 'application/json;charset=utf-8',
                    success: function (dataResult) {
                        if (dataResult.code == 'success') {
                            var tarDiv = "<select class='form-control' multiple='multiple' id='tarModifySelect'>";
                            if(dataResult.tarAppList!=null&&dataResult.tarAppList.length>0){
                                for (var i = 0; i < dataResult.tarAppList.length; i++) {
                                    tarDiv = tarDiv + "<option value='" + dataResult.tarAppList[i].id + "'>" + "<div id='tarOption'>" + dataResult.tarAppList[i].name + "</div>" + "</option>";
                                }
                                tarDiv = tarDiv + "</select>";
                                $("#tarModifyDiv").html(tarDiv);
                                $('#tarModifySelect').multiselect();
                                $('#tarModifySelect').multiselect('select', objArray);
                            }
                        }

                    },
                    error: function () {

                    }
                });
            } else {
                alert("系统繁忙");
            }
        },
        error: function () {
            alert("系统繁忙");
        }
    });
}

/**
 * 删除model展开
 */
function deleteMatch(id) {
    $('#deleteInfo').modal('show');
    $("#appId_delete").val(id);

}

/**
 * 新建model展开显示
 */
function setAddData(data) {
    var srcDiv = "<select class='form-control' id='srcSelect'>";

    if (data.srcAppList != null) {
        var srcLength = data.srcAppList.length;
        for (var i = 0; i < srcLength; i++) {
            srcDiv = srcDiv + "<option value='" + data.srcAppList[i].id + "'>" + data.srcAppList[i].name + "</option>"
        }
    }
    srcDiv = srcDiv + "</select>";
    $("#srcDiv").html(srcDiv);

    var tarDiv = "<select class='form-control' multiple='multiple' id='tarSelect'>";
    var tarLength = data.tarAppList.length;
    for (var i = 0; i < tarLength; i++) {
        tarDiv = tarDiv + "<option value='" + data.tarAppList[i].id + "'>" + data.tarAppList[i].name + "</option>"
    }
    tarDiv = tarDiv + "</select>";

    $("#tarDiv").html(tarDiv);
    $("#tarSelect").multiselect({
         buttonClass: 'btn',
         buttonWidth: 'auto',
         buttonText: function (options) {
             if (options.length == 0) {
                 return '请选择借款平台';
             }
             else {
                 var selected = '';
                 options.each(function () {
                     selected += $(this).text() + ',';
                 });
                 return selected.substr(0, selected.length - 1);
             }
         },
     });
}

