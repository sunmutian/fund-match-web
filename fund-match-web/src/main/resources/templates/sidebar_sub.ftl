<li><a href="#">
   <i class="fa fa-sitemap"></i> <span>借款匹配</span><i class="fa fa-angle-left pull-right"></i></a>
        <ul class="treeview-menu">
        <#list list2 as item>
             <li ><a href="platformInfoLoan"><i class="fa fa-circle-o"></i>${item.appName}${list2?size}</a></li>
        </#list>
         </ul>
 </li>