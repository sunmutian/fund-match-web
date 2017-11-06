
                        <div class="row">
                            <div class="col-md-12">
                                <div class="box box-primary">
                                    <div class="box-body" style="padding-top:20px;">
                                        <div class="row">
                                            <form class="form-horizontal">
                                                <label  class="col-sm-1 control-label">平台名称: </label>
                                                <div class="col-sm-2">
                                                    <input type="text" class="form-control input-sm" id="appName">
                                                </div>
                                                 <label  class="col-sm-1 control-label">创建时间 : </label>
                                                <div class="col-sm-4">
                                                    <div class="form-control"  style="border: none;background:none;padding:0;">
                                                        <input type="text" class="input-sm" style="border-radius:0;" id="startTime" />
                                                        <span class="glyphicon glyphicon-minus"></span>
                                                        <input type="text" class="input-sm" style="border-radius:0;" id="endTime"/>
                                                    </div>
                                                </div>
                                                <div class="col-sm-1">
                                                    <input type="button" class="btn btn-primary btn-sm" value="查 询" id="query"/>
                                                </div>
                                                <div class=" col-sm-2">
                                                    <a href="#addPlatform" class="btn btn-primary btn-sm" data-toggle="modal">新增出借平台</a>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="table-responsive" style="margin-top:20px;">
                                            <table class="table table-striped table-bordered text-center table-hover table-condensed borrowTable"  id="firstTab">
                                            <thead>
                                                   <tr>
                                                   <th>操作</th>
                                                   <th>平台名称</th>
                                                   <th>所属企业</th>
                                                   <th>创建时间</th>
                                                   <th>平台属性</th>
                                                   </tr>
                                            </thead>
                                             <tbody id="platformDataTable"></tbody>
                                              </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

        <script src="js/define/platformInfoLoan.js"></script>