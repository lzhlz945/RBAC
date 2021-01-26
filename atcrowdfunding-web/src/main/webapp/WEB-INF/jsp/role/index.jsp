
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <style>
        .tree li {
            list-style-type: none;
            cursor:pointer;
        }
        table tbody tr:nth-child(odd){background:#F4F4F4;}
        table tbody td:nth-child(even){color:#C00;}
    </style>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <div><a class="navbar-brand" style="font-size:32px;" href="#">众筹平台 - 角色维护</a></div>
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
                            <li><a href="index.html"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
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
                                <a href="${Path_APP}/user/index"><i class="glyphicon glyphicon-user"></i> 用户维护</a>
                            </li>
                            <li style="height:30px;">
                                <a href="${Path_APP}/role/index" style="color:red;"><i class="glyphicon glyphicon-king"></i> 角色维护</a>
                            </li>
                            <li style="height:30px;">
                                <a href="permission.html"><i class="glyphicon glyphicon-lock"></i> 许可维护</a>
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
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
                </div>
                <div class="panel-body">
                    <form class="form-inline" role="form" style="float:left;">
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <div class="input-group-addon">查询条件</div>
                                <input class="form-control has-success" id="textInput1" type="text" placeholder="请输入查询条件">
                            </div>
                        </div>
                        <button type="button" id="chaxun" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
                    </form>
                    <button type="button" class="btn btn-danger" style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 删除</button>
                    <button type="button" class="btn btn-primary" style="float:right;" onclick="window.location.href='form.html'"><i class="glyphicon glyphicon-plus"></i> 新增</button>
                    <br>
                    <hr style="clear:both;">
                    <div class="table-responsive">
                        <table class="table  table-bordered">
                            <thead>
                            <tr >
                                <th width="30">#</th>
                                <th width="30"><input type="checkbox" id="qx"></th>
                                <th>名称</th>
                                <th width="100">操作</th>
                            </tr>
                            </thead>
                            <tbody id="tbody1">


                            </tbody>
                            <tfoot>
                            <tr >
                                <td colspan="6" align="center">
                                    <ul class="pagination">
                                        <%--<li class="disabled"><a href="#">上一页</a></li>
                                        <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                        <li><a href="#">下一页</a></li>--%>
                                    </ul>
                                </td>
                            </tr>

                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
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

        //全选
        $("#qx").click(function () {
            $("input[name=xz]").prop("checked",this.checked);
        })

        //反选
        $("#tbody1").on("click",$("input[name=xz]"),function () {
            $("#qx").prop("checked",$("input[name=xz]").length==$("input[name=xz]:checked").length)
        })

        rolePages(1);
        $("#chaxun").click(function () {
            rolePages(1)
        })
    });

    //分页展示
    function rolePages(pageNum){
        var loadingIndex=null;
        $.ajax({
            url:"${Path_APP}/role/pages",
            type:"POST",
            dataType:"json",
            data:{
                "pageNum":pageNum,
                "pageSize":4,
                "name":$.trim($("#textInput1").val())
            },
            beforeSend:function () {
                loadingIndex = layer.msg('加载中...', {icon: 16});
            },
            success:function (result) {
                layer.close(loadingIndex);
                if(result.success){
                    var html1="";
                    var html2="";
                    $.each(result.data.list,function (i,n) {

                        html1+='<tr>';
                        html1+='<td>'+i+'</td>';
                        html1+='<td><input type="checkbox" name="xz"></td>';
                        html1+='<td>'+n.name+'</td>';
                        html1+='<td>';
                        html1+='<button type="button" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></button>';
                        html1+='<button type="button" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>';
                        html1+='<button type="button" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>';
                        html1+='</td>';
                        html1+='</tr>';

                    });
                    if(pageNum >1){
                        layer.close(loadingIndex);
                        html2+='<li ><a href="#" onclick="rolePages('+1+')">首页</a></li>';
                        html2+='<li ><a href="#" onclick="rolePages('+(pageNum-1)+')">上一页</a></li>';
                    }

                    var len=result.data.navigatepageNums.length;
                    for(var j = 0; j < len; j++) {

                        if(result.data.navigatepageNums[j]==pageNum){
                            html2+='<li class="active"><a href="#" onclick="rolePages('+result.data.navigatepageNums[j]+')">'+result.data.navigatepageNums[j]+'</a></li>';
                        }else {
                            html2+='<li ><a href="#" onclick="rolePages('+result.data.navigatepageNums[j]+')">'+result.data.navigatepageNums[j]+'</a></li>';
                        }

                    }

                    if(pageNum != result.data.pages){
                        layer.close(loadingIndex);
                        html2+='<li ><a href="#" onclick="rolePages('+(pageNum+1)+')">下一页</a></li>';
                        html2+='<li ><a href="#" onclick="rolePages('+result.data.pages+')">尾页</a></li>';
                    }

                    $("#tbody1").html(html1);
                    $(".pagination").html(html2);

                }else {
                    layer.msg("系统出错了，请稍后重试", {time:2000, icon:5, shift:6}, function () {
                    });
                }
            },
            error:function () {
                layer.msg("系统出错了，请稍后重试", {time:2000, icon:5, shift:6}, function () {
                });
            }

        })




    }

    $("tbody .btn-success").click(function(){
        window.location.href = "assignPermission.html";
    });
</script>
</body>
</html>

