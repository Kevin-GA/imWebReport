<%-- 所有的静态资源导入都放在这里--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.UUID"%>
<%
  String contextPath = (String) request.getContextPath();
      request.setAttribute("isMenu", "true");
%>
<script type="text/javascript">
  var contextPath="<%=contextPath %>";
</script>
<%-- 样式 默认就有 type="text/css" --%>
<link href="http://js.soufunimg.com/bdp.core/resources/bdp/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">
<link href="http://js.soufunimg.com/bdp.core/resources/bdp/css/orgStructTree/bootstrap/bootstrap-table.min.css" rel="stylesheet"  />
<link href="http://js.soufunimg.com/bdp.core/resources/bdp/bootstrap/css/metisMenu.min.css" rel="stylesheet">
<link href="http://js.soufunimg.com/bdp.core/resources/bdp/bootstrap/css/bootstrap-multiselect.css" rel="stylesheet">
<link href="http://js.soufunimg.com/bdp.core/resources/bdp/bootstrap/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<!--  引入bootstrap-3.0.3.min.css,解决了下拉选择样式问题、表格字体全部加粗问题-->
<link href="http://js.soufunimg.com/bdp.core/resources/bdp/bootstrap/css/bootstrap-3.0.3.min.css" rel="stylesheet" media="screen">
<!--  在线编辑器-->
<link href="http://js.soufunimg.com/bdp.core/resources/bdp/bootstrap/css/summernote.css" rel="stylesheet">
<!--  bootstrap 图标-->
<link href="http://js.soufunimg.com/bdp.core/resources/bdp/bootstrap/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet">

<script src="http://js.soufunimg.com/bdp.core/resources/bdp/js/jquery/jquery.min.js"></script>
<!--highChart  -->
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/highchart/highcharts.js"></script>
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/highchart/exporting.js"></script>
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/bootstrap/js/bootstrap.min.js"></script>
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/js/bdp/orgStructTree/bootstrap/bootstrap-table-all.min.js"></script>
<script src="<%=contextPath %>/resources/bdp/js/bootstrap-table/bootstrap-table-resize.js"></script>
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/js/bootstrap-table/setIframeHeight.js"></script>
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/js/bootstrap-table/bootstrap-table-zh-CN.min.js"></script>
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/js/jquery/jquery-validate/jquery.validate.min.js"></script>
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/js/jquery/jquery-validate/messages_zh.js"></script>
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/js/jquery/jquery.ztree.core-3.5.min.js"></script>
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/js/jquery/jquery.ztree.excheck-3.5.min.js"></script>
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/js/jquery/jquery.ztree.exedit-3.5.min.js"></script>
<!--下拉选择框JS  -->
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/bootstrap/js/bootstrap-multiselect.js"></script>
<!--时间控件  -->
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/bootstrap/datetimepicker/js/bootstrap-datetimepicker.js?version=<%=UUID.randomUUID()%>"></script>
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/bootstrap/datetimepicker/js/bootstrap-datetimepicker.fr.js"></script>
<!--在线编辑器  -->
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/bootstrap/js/summernote.js"></script>

<script src="http://js.soufunimg.com/bdp.core/resources/bdp/js/bdp/util.js"></script>
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/js/bdp/commons-operate.js?version=<%=UUID.randomUUID()%>" ></script>
<!-- 引入组织架构 -->
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/js/bdp/orgStructTree/orgStructTree.js"></script>

<!-- 引入导出表格到文件的插件 -->
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/bootstrap/export/tableExport.min.js"></script>
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/bootstrap/export/FileSaver.min.js"></script>
<script src="<%=contextPath %>/resources/bdp/bootstrap/export/bootstrap-table-export.js"></script> 
<!-- 引入table上侧滚动条插件 -->
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/js/jquery.doubleScroll.js"></script>
<!-- xcConFirm -->
<link href="http://js.soufunimg.com/bdp.core/resources/bdp/js/xConfirm/css/xConfirm.css" rel="stylesheet" type="text/css">
<script src="http://js.soufunimg.com/bdp.core/resources/bdp/js/xConfirm/js/xConfirm.js" type="text/javascript"></script>