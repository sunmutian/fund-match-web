<!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="images/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
              <p>admin</p>
              <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
          </div>
          <!-- search form -->
          <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>
          <!-- /.search form -->
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="treeview active">
              <a href="#">
                <i class="fa fa-folder"></i> <span>业务管理</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li>
                  <a href="#"><i class="fa fa-sitemap"></i> <span>平台管理</span><i class="fa fa-angle-left pull-right"></i></a>
                  <ul class="treeview-menu">
                    <li ><a href="platformInfoIndex"><i class="fa fa-circle-o"></i>平台信息</a></li>
                    <li><a href="matchManagement"><i class="fa fa-circle-o"></i>配对管理</a></li>
                  </ul>
                </li>
                <li  class="active">
                  <a href="#"><i class="fa fa-sitemap"></i> <span>匹配管理</span><i class="fa fa-angle-left pull-right"></i></a>
                  <ul class="treeview-menu">
                    <li><a href="#"><i class="fa fa-sitemap"></i> <span>出借匹配</span><i class="fa fa-angle-left pull-right"></i></a>
                                      <ul class="treeview-menu">
                                       <#list list1 as item>
                                          <li ><a href="loanMatchIndex?id=${item.id}"><i class="fa fa-circle-o"></i>${item.name}</a></li>
                                        </#list>
                                      </ul>
                     </li>
                    <li><a href="#"><i class="fa fa-sitemap"></i> <span>借款匹配</span><i class="fa fa-angle-left pull-right"></i></a>
                                      <ul class="treeview-menu">
                                         <#list list2 as item>
                                           <li ><a href="debitMatchIndex?id=${item.id}"><i class="fa fa-circle-o"></i>${item.name}</a></li>
                                         </#list>
                                      </ul>
                     </li>
                  </ul>
                </li>
              </ul>
            </li>

            <li class="treeview">
                <a href="#">
                  <i class="fa fa-gear"></i> <span>系统管理</span>
                  <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                  <li><a href="javascript:;"><i class="fa fa-circle-o"></i>权限管理</a></li>
                </ul>
            </li>
          </ul>
        </section>
        <!-- /.sidebar -->
      </aside>