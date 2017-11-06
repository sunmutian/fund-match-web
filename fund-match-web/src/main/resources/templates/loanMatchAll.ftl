
                        <div class="row">
                            <div class="col-md-12">
                                <div class="box box-primary">
                                    <div class="box-body" style="padding-top:20px;">
                                        <div class="row">
                                            <form class="form-horizontal">
                                            	<div class="col-sm-12">
                                            		<div class="col-sm-4">
                                            			<label  class="col-sm-4 control-label">出借流水单号: </label>
	                                                <div class="col-sm-8">
	                                                    <input type="text" class="form-control input-sm" >
	                                                </div>
                                            		</div>
                                            		 <div class="col-sm-5">
                                            		 	<label  class="col-sm-3 control-label">流水单号时间 : </label>
	                                                <div class="col-sm-9">
	                                                    <div class="form-control"  style="border: none;background:none;padding:0;">
	                                                        <input type="text" class="input-sm" style="border-radius:0;"/>
	                                                        <span class="glyphicon glyphicon-minus"></span>
	                                                        <input type="text" class="input-sm" style="border-radius:0;"/>
	                                                    </div>
	                                                </div>
                                            		 </div> 
                                            	</div>
                                               
                                              <div class="col-sm-12" style="margin-top:20px;">
                                            		<div class="col-sm-4">
                                            			<label  class="col-sm-4 control-label">出借人姓名: </label>
	                                                <div class="col-sm-8">
	                                                    <input type="text" class="form-control input-sm" >
	                                                </div>
                                            		</div>
                                            		 <div class="col-sm-4">
                                            			<label  class="col-sm-4 control-label">身份证号: </label>
	                                                <div class="col-sm-8">
	                                                    <input type="text" class="form-control input-sm" >
	                                                </div>
                                            		</div>
                                            		<div class="col-lg-offset-2 col-sm-1">
                                                    <input type="button" class="btn btn-primary btn-sm" value="查 询" id="query"/>
                                                 </div>
                                            	</div>                                           
                                            </form>
                                        </div>
                                        <div class="table-responsive" style="margin-top:20px;">
                                            <table class="table table-striped table-bordered text-center table-hover table-condensed">
                                                <thead>
                                                    <tr>
                                                        <th>操作</th>
                                                        <th>状态</th>
                                                        <th>出借人姓名</th>
                                                        <th>身份证号</th>
                                                        <th>出借金额</th>
                                                        <th>对应产品编号</th> 
                                                        <th>初始出借订单编号</th>
                                                        <th>出借流水单号</th>
                                                        <th>流水单号时间</th>
                                                        <th>匹配金额</th>
                                                        <th>未匹配金额</th>
                                                    </tr>
                                                   </thead>
                                                   <tbody id="dataTable"></tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>