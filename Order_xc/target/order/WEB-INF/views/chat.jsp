<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<head>
    <meta charset="UTF-8">
    <title>chat回复</title>
</head>
<body>

<div class="col-md-8">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">回复</h3>
        </div>
        <div class="panel-body">
        ${ReturnChat1}
        <br>
        ${ReturnChat2}
        
            <br/>
            <footer class="admin-content-footer">
                <hr>
                <p class="am-padding-left">© 2017 AllMobilize, Inc. Licensed under MIT license.</p>
            </footer>
        </div>
    </div>
</div>

</body>
</html>