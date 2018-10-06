<!DOCTYPE html>

<html lang="en">
<title>Generator</title>

<body>
<form method="post" action="/result">
<#list tasks as task>
    <p>${task.task}</p>
    <#--<p>${task.result}</p>-->
<input type="text" name="param" placeholder="Ответ"
       required="true"/>
</#list>
    <input type="submit" value="Результат"/>
</form>
</body>
</html>


