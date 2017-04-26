<!DOCTYPE html> 
<html> 
<head> 
<meta charset="utf-8"> 
<script src="http://code.jquery.com/jquery-2.1.3.min.js"></script> 
<script type="text/javascript"> 
$(document).ready(function(){ 

    $("#b1").click(function(){ 
         $.ajax({ 
            url:'http://localhost:8080/myspringboot/testJson.json?name=Shanhy&name1=Lily', 
            type: "get", 
            async: false, 
            dataType: "jsonp", 
            jsonp: "callback", //服务端用于接收callback调用的function名的参数(请使用callback或jsonp)
            jsonpCallback: "fun_jsonpCallback", //callback的function名称
            success: function(json) { 
                alert(json.name); 
            },
            error: function(){
                alert('Request Error');
            } 
        }); 
    });        

    $("#b2").click(function(){ 
         $.ajax({ 
            url:'http://localhost:8080/myspringboot/testJson.json?name=Shanhy&name1=Lily', 
            type: "get", 
            async: false, 
            //dataType: "jsonp", 
            //jsonp: "callback", //服务端用于接收callback调用的function名的参数(请使用callback或jsonp)
            //jsonpCallback: "fun_jsonpCallback", //callback的function名称 
            success: function(json) { 
                alert(json.name1); 
            },
            error: function(){
                alert('Request Error');
            } 
        }); 
    });   

}); 
</script> 
</head> 
<body> 

    <div id="div1"><h2>jQuery AJAX 的跨域请求</h2></div> 
    <button id="b1">JSONP请求 (预期结果为成功)</button> <br/> 
    <button id="b2">JSON请求 (预期结果为失败)</button> 

</body> 
</html>