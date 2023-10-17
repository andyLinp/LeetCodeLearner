<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SSE-Demo</title>
    <link rel="stylesheet" type="text/css" value="">
</head>
<body>
<h2> sse.jsp </h2>
​
服务器推送  可以用于消息订阅
<br/>
解决长短轮询不是解决问题
<br/>
server send event 当客户端方服务器发送请求时 服务器抓住不放 等有数据时 再回复给客户端，客户端收到消息时发给送给服务器，如此循环
<br/>
参考内容：
https://www.jianshu.com/p/bc5a9b4a1cd1
​
<div id="msgFromPush"></div>
<script type="text/javascript" src="<c:url value="assets/js/jquery.js"/>"></script>
<script type="text/javascript">
    if (!!window.EventSource) {
        var source = new EventSource('push');
        s='';
        source.addEventListener('message', function (e) {
            s+=e.data+"<br/>";
            $("#msgFromPush").html(s);
        });

        source.addEventListener('open', function (e) {
            console.log("连接打开.");
        }, false);

        source.addEventListener('error', function (e) {
           if (e.readState == EventSource.CLOSED) {
               console.log("连接关闭");
           } else {
               console.log(e.readState);
           }
        }, false);
    } else {
        console.log("你的浏览器不支持SSE")
    }
</script>

</body>
</html>