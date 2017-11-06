    /* 
     * AJAX异步分页
     * 假设id为pageWidget的div是你放置分页控件的容器，则按如下形式调用： 
     * $("#pageWidget").asynPage("/user/test.htm",{"pageNumber":20},"Formid"); 
     * 参数说明： 
     * ------------Required----------- 
     * 参数一：请求URL 
     * ------------Optional----------- 
     * 参数五(json对象)： 
     * 属性pageNumber:每页记录数(不配置，则默认为20) 
     * 属性param:请求参数(json格式) 
     */  
    (function($){  
        var settings;  
        var page;  
        var paramStr;
          
        $.fn.asynPage = function(url,callerSettings,formid){  
          
            settings = $.extend({  
            	currentNumber:1,  
            	pageNumber:20,
                param:callerSettings 
            },callerSettings||{});
          
            settings.url = url;  
            settings.pageWidget = this;  
            settings.formid = formid;
            settings.reloads=reloads;
            page = new Page(settings.currentNumber,settings.pageNumber);
            //开始获取数据  
            fetchData(page.getCurrPageNum());
            return settings;  
        };  
          
        
        /*  
         * 负责获取后台数据，获取完毕后会触发构建分页控件 
         */  
        var fetchData = function(currPageNum){  
            page.setCurrPageNum(currPageNum);
            var firstResult = page.getFirstResult();
            var maxResult = page.getMaxResult();
            var pageRowSize = page.getPageRowSize();
            var data = null;
            if(Object.keys(settings.param).length  != 0){
            	data = settings.param;
            }else{
            	data = settings.param;
            }
            data.currentNumber=currPageNum;
            data.pageNumber=pageRowSize;
            if( settings.formid == "" || settings.formid == null){
            	$.ajax({
            		url : settings.url, 
    				type : 'post',
    				data:data,
    				dataType:"html",
    				traditional:true,
    				success : function(datas) {
    					$(settings.pageWidget).empty().append(datas);
	                    bindEvent();//为分页控件绑定事件  
    				},
    				error:function(xmlHttpRequest,textStatus,errorThrown){
    					if(textStatus == "error"){  
                            var error = eval(xmlHttpRequest.responseText); 
                            if(error!=null&&error!=undefined){
                            	alert("Sorry："+error.errorCode+"，"+error.message+"！"); 
                            }
                        } 
    				}
            	});
            } else {
	            $("#"+settings.formid).ajaxSubmit({
	                type :"POST",  
	                url : settings.url,  
	                data:data,
	                dataType:"html",
	                traditional:true,
	                success :function(datas){
	                    $(settings.pageWidget).empty().append(datas);
	                    bindEvent();//为分页控件绑定事件  
	                },  
	                error:function(xmlHttpRequest,textStatus,errorThrown){  
	                    if(textStatus == "error"){  
	                        var error = eval(xmlHttpRequest.responseText); 
	                        if(error!=null&&error!=undefined){
	                        	alert("Sorry："+error.errorCode+"，"+error.message+"！"); 
	                        }
	                    }  
	                }  
	            });
            }
        };
        
        //分页事件触发
        var reloads = function(){
        	alert(page.getCurrPageNum());
            fetchData(page.getCurrPageNum());
        };
        
        //分页事件触发
        var trunTargetPage = function(pageNum){
            fetchData(pageNum);
        };
          
        /* 为分页控件绑定事件 */  
        var bindEvent = function(){  
            var links = settings.pageWidget.find(".pagination").find("a");
            $.each(links,function(i,link){  
                var link = $(link);  
                var pageNum = link.attr("pageNum");  
                var settingsTemp=settings;//当前进程的参数绑定给分页容器
                var pageTemp = page;
                link.click(function(){  
                	settings=settingsTemp;
                	page = pageTemp;
                    trunTargetPage(pageNum);
                });  
            });
            
            //每页显示条数
            var pageNumbers = settings.pageWidget.find("#pageNumbers").find("button");
            $.each(pageNumbers,function(i,numbs){  
                var numbs = $(numbs);  
                var pageNum = numbs.attr("data-pagenumber");  
                var settingsTemp=settings;//当前进程的参数绑定给分页容器
                numbs.click(function(){  
                	settings=settingsTemp;
                	page.setPageRowSize(pageNum);//设置每页显示条数
                	fetchData(1);//初始化为第一页
                });  
            });  
        };
        
    })(jQuery);
    
    /* 
     * Page类 
     */  
    function Page(currPageNum,pageRowSize){  
        this.currPageNum = currPageNum;  
        this.pageRowSize = pageRowSize;  
    }  
    Page.prototype.getCurrPageNum = function(){  
        return this.currPageNum;  
    };  
    Page.prototype.setCurrPageNum = function(currPageNum){  
        this.currPageNum = currPageNum;  
    };  
    Page.prototype.getTotalPageNum = function(){  
        return (this.totalRowSize%this.pageRowSize==0)?(this.totalRowSize/this.pageRowSize):(Math.floor(this.totalRowSize/this.pageRowSize)+1);  
    };  
    Page.prototype.getTotalRowSize = function(){  
        return this.totalRowSize;  
    };  
    Page.prototype.setTotalRowSize = function(totalRowSize){  
        this.totalRowSize = totalRowSize;  
    };  
    Page.prototype.getPageRowSize = function(){  
        return this.pageRowSize;  
    };  
    Page.prototype.setPageRowSize = function(pageRowSize){  
        this.pageRowSize = pageRowSize;  
    };  
    Page.prototype.getFirstResult = function(){  
        if(this.getCurrPageNum()<=0) return 0;  
        return this.getPageRowSize() * (this.getCurrPageNum() - 1);  
    };  
    Page.prototype.getMaxResult = function(){  
        return this.getFirstResult() + this.getPageRowSize();  
    };  