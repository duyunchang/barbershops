<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>   
    <script src="/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">               
        $().ready(function () {
            $("span").click(function () {
                $.get("http://127.0.0.1:8080/stu/list", { cmd: 123 }, function (d) {
                	//d=JSON.parse(JSON.stringify(d));
                    alert(typeof(d));
                    alert(d[0].name);
                    alert(d[1].name);
                });                                                            
            });
             
        });
    </script>
</head>
<body>
    <span style="cursor:pointer">点击我</span>
</body>

</html>