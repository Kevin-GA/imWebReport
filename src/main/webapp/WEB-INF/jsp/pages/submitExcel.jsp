<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Spring Boot Sample</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>

<body>
<center>
<h1>选择文件</h1>


    <form id="uploadForm" method="post" action="/handleExcel"  enctype="multipart/form-data"  ContentType="">
        　　<input id="file" type="file" name="fileName"/>
        　　<input type="submit" name="submit" id="submit" value="提交" />
    </form>


</center>
</body>
</html>