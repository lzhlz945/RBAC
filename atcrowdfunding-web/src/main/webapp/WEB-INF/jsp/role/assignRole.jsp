<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" href="${Path_APP}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${Path_APP}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${Path_APP}/css/main.css">
    <link rel="stylesheet" href="${Path_APP}/css/doc.min.css">
    <style>
        .tree li {
            list-style-type: none;
            cursor:pointer;
        }
    </style>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <div><a class="navbar-brand" style="font-size:32px;" href="user.html">众筹平台 - 用户维护</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li style="padding-top:8px;">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">
                            <i class="glyphicon glyphicon-user"></i> 张三 <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
                            <li class="divider"></li>
                            <li><a href="login.html"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                        </ul>
                    </div>
                </li>
                <li style="margin-left:10px;padding-top:8px;">
                    <button type="button" class="btn btn-default btn-danger">
                        <span class="glyphicon glyphicon-question-sign"></span> 帮助
                    </button>
                </li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <div class="tree">
                <ul style="padding-left:0px;" class="list-group">
                    <li class="list-group-item tree-closed" >
                        <a href="main.html"><i class="glyphicon glyphicon-dashboard"></i> 控制面板</a>
                    </li>
                    <li class="list-group-item">
                        <span><i class="glyphicon glyphicon glyphicon-tasks"></i> 权限管理 <span class="badge" style="float:right">3</span></span>
                        <ul style="margin-top:10px;">
                            <li style="height:30px;">
                                <a href="${Path_APP}/user/index" style="color:red;"><i class="glyphicon glyphicon-user"></i> 用户维护</a>
                            </li>
                            <li style="height:30px;">
                                <a href="${Path_APP}/role/index"><i class="glyphicon glyphicon-certificate"></i> 角色维护</a>
                            </li>
                            <li style="height:30px;">
                                <a href="${Path_APP}/permission/index"><i class="glyphicon glyphicon-lock"></i> 许可维护</a>
                            </li>
                        </ul>
                    </li>
                    <li class="list-group-item tree-closed">
                        <span><i class="glyphicon glyphicon-ok"></i> 业务审核 <span class="badge" style="float:right">3</span></span>
                        <ul style="margin-top:10px;display:none;">
                            <li style="height:30px;">
                                <a href="auth_cert.html"><i class="glyphicon glyphicon-check"></i> 实名认证审核</a>
                            </li>
                            <li style="height:30px;">
                                <a href="auth_adv.html"><i class="glyphicon glyphicon-check"></i> 广告审核</a>
                            </li>
                            <li style="height:30px;">
                                <a href="auth_project.html"><i class="glyphicon glyphicon-check"></i> 项目审核</a>
                            </li>
                        </ul>
                    </li>
                    <li class="list-group-item tree-closed">
                        <span><i class="glyphicon glyphicon-th-large"></i> 业务管理 <span class="badge" style="float:right">7</span></span>
                        <ul style="margin-top:10px;display:none;">
                            <li style="height:30px;">
                                <a href="cert.html"><i class="glyphicon glyphicon-picture"></i> 资质维护</a>
                            </li>
                            <li style="height:30px;">
                                <a href="type.html"><i class="glyphicon glyphicon-equalizer"></i> 分类管理</a>
                            </li>
                            <li style="height:30px;">
                                <a href="process.html"><i class="glyphicon glyphicon-random"></i> 流程管理</a>
                            </li>
                            <li style="height:30px;">
                                <a href="advertisement.html"><i class="glyphicon glyphicon-hdd"></i> 广告管理</a>
                            </li>
                            <li style="height:30px;">
                                <a href="message.html"><i class="glyphicon glyphicon-comment"></i> 消息模板</a>
                            </li>
                            <li style="height:30px;">
                                <a href="project_type.html"><i class="glyphicon glyphicon-list"></i> 项目分类</a>
                            </li>
                            <li style="height:30px;">
                                <a href="tag.html"><i class="glyphicon glyphicon-tags"></i> 项目标签</a>
                            </li>
                        </ul>
                    </li>
                    <li class="list-group-item tree-closed" >
                        <a href="param.html"><i class="glyphicon glyphicon-list-alt"></i> 参数管理</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <ol class="breadcrumb">
                <li><a href="#">首页</a></li>
                <li><a href="#">数据列表</a></li>
                <li class="active">分配角色</li>
            </ol>
            <div class="panel panel-default">
                <div class="panel-body">
                    <form role="form" class="form-inline">
                        <div class="form-group">
                            <label for="exampleInputPassword1">未分配角色列表</label><br>
                            <select class="form-control" multiple id="s1" size="10" name="sel01" style="width:200px;overflow-y:auto;">


                                <c:forEach items="${requestScope.rList}" var="role">
                                    <option value="${role.id}">"${role.name}"</option>
                                </c:forEach>
                                <%--<option value="se">PM</option>
                                <option value="tl">SE</option>
                                <option value="gl">TL</option>
                                <option value="qa">GL</option>
                                <option value="pm">QC</option>
                                <option value="pm">SA</option>
                                <option value="pm">SYSTEM</option>
                                <option value="pm">HR</option>--%>
                            </select>
                        </div>
                        <div class="form-group">
                            <ul>
                                <button id="qbsq" type="button" class="btn btn-success"><i class="glyphicon glyphicon-ok"></i> 全部添加</button>
                                <br>
                                <br>
                                <li class="btn btn-info glyphicon glyphicon-chevron-right" id="but1">选择添加</li>
                                <br>
                                <li class="btn btn-info glyphicon glyphicon-chevron-left" id="but2" style="margin-top:20px;">选择移除</li>
                                <br><br>
                                <button id="qbbsq" type="button" class="btn btn-danger"><i class="glyphicon glyphicon-remove"></i>全部移除</button>

                            </ul>
                        </div>
                        <div class="form-group" style="margin-left:40px;">
                            <label for="exampleInputPassword1">已分配角色列表</label><br>

                            <select class="form-control" multiple size="10" name="sel02" style="width:200px;overflow-y:auto;">
                                <c:forEach items="${requestScope.userRole}" var="role1">
                                    <option value="${role1.id}">"${role1.name}"</option>
                                </c:forEach>

                            </select>

                        </div>
                    </form>
                    <br>
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    <button type="button" id="sqbtn" class="btn btn-primary"><i class="glyphicon glyphicon-user"></i>点击授权</button>

                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">帮助</h4>
            </div>
            <div class="modal-body">
                <div class="bs-callout bs-callout-info">
                    <h4>测试标题1</h4>
                    <p>测试内容1，测试内容1，测试内容1，测试内容1，测试内容1，测试内容1</p>
                </div>
                <div class="bs-callout bs-callout-info">
                    <h4>测试标题2</h4>
                    <p>测试内容2，测试内容2，测试内容2，测试内容2，测试内容2，测试内容2</p>
                </div>
            </div>
            <!--
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              <button type="button" class="btn btn-primary">Save changes</button>
            </div>
            -->
        </div>
    </div>
</div>

<script src="${Path_APP}/jquery/jquery-2.1.1.min.js"></script>
<script src="${Path_APP}/bootstrap/js/bootstrap.min.js"></script>
<script src="${Path_APP}/script/docs.min.js"></script>
<script src="${Path_APP}/layer/layer.js"></script>
<script type="text/javascript">
    $(function () {
        $(".list-group-item").click(function(){
            if ( $(this).find("ul") ) {
                $(this).toggleClass("tree-closed");
                if ( $(this).hasClass("tree-closed") ) {
                    $("ul", this).hide("fast");
                } else {
                    $("ul", this).show("fast");
                }
            }
        });

        //分配权限 //全部是 :selected 换成 option
        $("#but1").click(function () {
            $("select[name=sel01] :selected").each(function(){
                //alert(this);
                $(this).appendTo("select[name=sel02]");
            });

        })

        //全部添加
        $("#qbsq").click(function () {
            $("select[name=sel01] option").each(function(){
                //alert(this);
                $(this).appendTo("select[name=sel02]");
            });

        })

        //全部移除
        $("#qbbsq").click(function () {
            $("select[name=sel02] option").each(function(){
                //alert(this);
                $(this).appendTo("select[name=sel01]");
                // alert($(this).val())
            });

        })

        //取消权限
        $("#but2").click(function () {
            $("select[name=sel02] :selected").each(function(){
                //alert(this);
            $(this).appendTo("select[name=sel01]");
            // alert($(this).val())
            });

        })

        $("#sqbtn").click(function () {
            var params="userId=${requestScope.userId}&"
            $("select[name=sel02] option").each(function(){
                params+='ids='+$(this).val()+"&";
            });

            // alert(params)
            params=params.substring(0,(params.lastIndexOf("&")))
            alert(params)
            var loadingIndex=null;
            $.ajax({
                url:"${Path_APP}/role/assignRole",
                data:params,
                type:"post",
                beforeSend:function () {
                    loadingIndex = layer.msg('加载中...', {icon: 16});
                },
                success:function (data) {
                    layer.close(loadingIndex);
                    if(data.success){
                        layer.msg("授权成功", {time:2000, icon:1, shift:1}, function () {
                        });
                        window.location.href="${Path_APP}/role/toAssign?userId=${requestScope.userId}"

                    }else {
                        layer.msg("授权失败！！！", {time:2000, icon:5, shift:6}, function () {
                        });
                    }
                }


            })
        })
    });
</script>
</body>
</html>
