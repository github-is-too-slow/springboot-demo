<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body style="align: center;">
    <h1>欢迎使用Spring Boot</h1>
    <br>
    <br>
    <br>
    <a href="/car/12/owner/lisi?pwd=JackRose&hobbies=sing&hobbies=basketball">参数传递测试</a>
    <br>
    <br>
    <br>
    <!--;two=Rose/owner;one=Smith-->
    <a href="/user/12;one=24/common/Rose;hobbies=dance;hobbies=sing;one=Smith">Matrix矩阵参数传递测试</a>
    <br>
    <br>
    <br>
    <form action="/login" method="post">
        <input type="text" name="uname"/>
        <input type="password" name="pwd"/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>