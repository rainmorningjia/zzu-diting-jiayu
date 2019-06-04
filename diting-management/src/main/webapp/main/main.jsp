<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>谛听系统主页</title>
    <link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="../themes/icon.css">
    <script type="text/javascript" src="../JS/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="../JS/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../JS/datagrid-detailview.js"></script>
    <script type="text/javascript" src="../JS/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="../JS/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="../JS/echarts.min.js"></script>
    <script type="text/javascript" src="../JS/china.js"></script>
    <script type="text/javascript">
        <!--菜单处理-->
        $(function () {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/menu/getAllUserParentMenu",
                data: {},
                dataType: "json",
                success: function (result) {
                    $.each(result, function (ind, menu) {
                        var htm = '<div title="Language"  style="overflow:auto;padding:10px; height:100px;">' + '<ul id="tree' + menu.id + '" ></ul>';
                        $("#aa").accordion("add", {

                            title: menu.name,
                            content: htm,
                            selected: false,

                            onExpand: function () {
                                $('#tree' + menu.id).tree({
                                    url: "${pageContext.request.contextPath}/menu/queryAllChildrenMenu?parentId=" + menu.id,
                                    loadFilter: function (data) {
                                        if (data.d) {
                                            return data.d;
                                        } else {
                                            return data;
                                        }
                                    },
                                    onClick: function (node) {
                                        var ex = $('#tt').tabs('exists', node.text);

                                        if (ex == false) {
                                            $('#tt').tabs('add', {
                                                title: node.text,
                                                href: "${pageContext.request.contextPath}/" + node.url,
                                                closable: true,
                                            });
                                        } else {
                                            $('#tt').tabs('select', node.text);
                                        }
                                    }
                                });
                            }


                        });

                    })

                }

            })

        });

        function init() {
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('statistics_main'));
            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '用户认证状态数据图'
                },
                tooltip: {},
                dataset: {
                    sources: [
                        ["produce", "已认证", "未认证"]
                    ]
                },
                legend: {
                    data: ['用户数量']
                },
                xAxis: {
                    data: []
                },
                yAxis: {},
                series: [{
                    silent: true,
                    barWidth: 20,
                    barGap: '-100%',
                    name: '数量',
                    type: 'bar',
                    data: []
                }]
            };
            myChart.setOption(option);
            // 异步加载统计信息
            $.post("${pageContext.request.contextPath }/data/getUserAuthenticationData", function (data) {
                console.log(data);
                // 使用刚指定的配置项和数据显示图表。
                var series = [];
                for (var i = 0; i < data.data.length; i++) {
                    var item = {
                        name: data.categ[i],
                        data: data.data[i],
                        type: 'bar',
                        label: {normal: {show: true, position: 'top'}}
                    };
                    series.push(item);
                }
                //将数据加载到图形中
                myChart.setOption({
                    title: {
                        text: data.title,
                        textStyle: {fontSize: 14}
                    },
                    legend: {
                        data: data.categ,
                        left: 'right'
                    },
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {type: 'shadow'}
                    },
                    xAxis: {
                        type: 'category',
                        data: data.intervals,
                        axisLabel: {interval: 0} //x轴数据显示完整
                    },
                    yAxis: {name: '认证数据'},
                    series: series
                }, true);
            }, "json");
            buildData();
        };
        function init2(){
            // 基于准备好的dom，初始化echarts实例
            // var myChart = echarts.init(document.getElementById('statistics_main2'));
            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: '用户投诉数据分析图'
                },
                tooltip: {},
                dataset: {
                    sources: [
                        ["produce", "著作权", "名誉权","肖像权"]
                    ]
                },
                legend: {
                    data: ['投诉量']
                },
                xAxis: {
                    data: []
                },
                yAxis: {},
                series: [{
                    silent: true,
                    barWidth: 20,
                    barGap: '-100%',
                    name: '数量',
                    type: 'bar',
                    data: []
                }]
            };
            myChart.setOption(option);
            // 异步加载统计信息
            $.post("${pageContext.request.contextPath }/data/getUserComplaintNumber", function (data) {
                console.log(data);
                // 使用刚指定的配置项和数据显示图表。
                var series = [];
                for (var i = 0; i < data.data.length; i++) {
                    var item = {
                        name: data.categ[i],
                        data: data.data[i],
                        type: 'bar',
                        label: {normal: {show: true, position: 'top'}}
                    };
                    series.push(item);
                }
                //将数据加载到图形中
                myChart.setOption({
                    title: {
                        text: data.title,
                        textStyle: {fontSize: 14}
                    },
                    legend: {
                        data: data.categ,
                        left: 'right'
                    },
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {type: 'shadow'}
                    },
                    xAxis: {
                        type: 'category',
                        data: data.intervals,
                        axisLabel: {interval: 0} //x轴数据显示完整
                    },
                    yAxis: {name: '投诉量数据'},
                    series: series
                }, true);
            }, "json");
        }
        function test(id, text) {
            text = "投诉集工单详情";
            var ex = $("#tt").tabs('exists', text);

            if (ex == false) {
                $('#tt').tabs('add', {
                    title: "投诉集工单详情",
                    href: "${pageContext.request.contextPath}/complaintwork/ComplaintWrokDetail.jsp?id=" + id,
                    closable: true,
                });
            } else {
                $('#tt').tabs('select', text);
            }
        }		//生成数据
        function buildData()
        {
            var columLabel = ['甲','乙','丙','丁','戊','己','庚','辛','壬','癸'];
            var columName = ['周一','周二','周三','周四','周五','周六','周日'];
            var columnValue = new Array();
            var arrData = new Array();

            for(var i=0;i<columLabel.length;i++)
            {
                for(var j=0;j<columName.length;j++)
                {
                    arrData.push(Math.floor(Math.random()*1000+1000*j-1000*i));
                }
                console.info(arrData);
                columnValue.push(eval('(' + ("{'name':'"+columLabel[i]+"','type':'bar','data':["+arrData+"]}") + ')'));
            }

            buildChart(columLabel,columName,columnValue);
        }

        //生成图形
        function buildChart(columLabel,columName,columnValue)
        {
            var chart = document.getElementById('statistics_main2');
            var echart = echarts.init(chart);
            var option = {
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {
                        type : 'shadow'
                    }
                },
                toolbox: {
                    show : true,
                    feature : {
                        saveAsImage : {show: true}
                    }
                },
                legend: {
                    data:columLabel
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis : [
                    {
                        min:0,
                        type : 'category',
                        data : columName
                    }
                ],
                yAxis : [
                    {
                        min:0,
                        type : 'value'
                    }
                ],
                series : columnValue
            };

            echart.setOption(option);
        }
        window.onload = init;
    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px">
        谛听版权投诉系统后台
        欢迎您:<%= request.getSession().getAttribute("name") %>
    </div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">
        &nbsp;&nbsp;<a href="${pageContext.request.contextPath}/manager/queit" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a>
    </div>
</div>
<div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体">&copy;谛听 moringrain</div>
</div>

<div data-options="region:'west',title:'导航菜单',split:true" style="width:250px;">
    <div id="aa" class="easyui-accordion" data-options="multiple:true," style="width:500px;">
    </div>
</div>
<div data-options="region:'center'">
    <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood',"
             style="background-image:url(../images/shouyehuge.jpeg);background-repeat: no-repeat;background-size:100% 100%;">
            <div id="statistics_main" style=" width: 400px;height: 300px;;margin-top: 200px;margin-left: 30px"></div>
            <div id="statistics_main2" style=" width: 400px;height: 300px;;margin-top: 200px;margin-right: 30px"></div>
        </div>
    </div>
</div>
<div id="dialogUserRightComplaint"></div>
<div id="userAuthenInfo"></div>
<div id="rejectInfo"></div>
<div id="adoptInfo"></div>
<div id="userRightInfo"></div>
<div  id="addRightDistributionInfo"></div>
</body>
</html>