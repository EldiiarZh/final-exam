<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>
<div>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse " id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/top/add">Создать тему</a>
                </li>
            </ul>
            <form action="/top/topics" class="form-inline my-2 my-lg-0">
                <input name="nameOfTopic" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
            <#if user??>

                <div id="username" style="margin-left: auto;color: #f8fafb">User: ${user.name}</div>
                <li class="nav-item" style="margin-left: auto" >
                    <form id="icon" action="/user" method="post">
                        <button class="btn btn-outline-success my-2 my-sm-0" data-toggle="collapse" role="button" aria-expanded="false" aria-controls="collapseExample" type="submit">Личный кабинет</button>
                    </form>
                </li>

                <li class="nav-item" style="margin-left: auto" >
                    <form id="icon" action="/logout" method="post">
                        <button class="btn btn-outline-success my-2 my-sm-0" data-toggle="collapse" role="button" aria-expanded="false" aria-controls="collapseExample" type="submit">выйти</button>
                    </form>
                </li>
            <#else>
                <li class="nav-item">
                    <a class="btn btn-outline-success my-2 my-sm-0" data-toggle="collapse" href="/login" role="button" aria-expanded="false" aria-controls="collapseExample">Вход</a>
                </li>
                <li class="nav-item">
                    <a class="btn btn-outline-success my-2 my-sm-0 " data-toggle="collapse" href="/register" role="button" aria-expanded="false" aria-controls="collapseExample">Регистрация</a>
                </li>
            </#if>
        </div>
    </nav>
</div>
<div style="display: flex;justify-content: space-around;  flex-wrap: wrap;">
    <#list places as pl>
        <#if pl.state.toString()=="FREE">
            <div style="border: solid black 1px;height: 100px; width:100px; margin-top: 20px;  ">
                <#if pl.numberCar!=0>
                    <h3>${pl.numberCar}</h3>
                </#if>
            </div>
            <#else>
                <div style="border: solid red 1px;height: 100px; width:100px; margin-top: 20px;  ">
                    <#if pl.numberCar!=0>
                        <h3>${pl.numberCar}</h3>
                    </#if>
                </div>
        </#if>
    </#list>

</div>
<div>
  Свободных мест =  ${free}
</div>

<div>
   Занято= ${busy}
</div>
</body>
</html>