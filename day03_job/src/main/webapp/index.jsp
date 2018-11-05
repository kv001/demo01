<%@ page language="java"  pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/echarts.common.min.js"></script>
	<script type="text/javascript" src="js/jquery.min.js"></script>
  </head>
  
  <body>
  	<form action="savefruit" method="get">
  		品名：<input type="text" name="name">
  		日期：<input type="text" name="begindate">
  		日期：<input type="text" name="enddate">
  			  <input type="submit" value="抓取">
  	</form>
  
    <div id="chart" style="width:3500;height:600px"></div>
    
    <script type="text/javascript">
    var myChart=echarts.init(document.getElementById('chart'));
    
    var option={
        title:{
          text:'新发地水果市场价格走势图'
        },
        xAxis:{
          data:[]
        },
        yAxis:{
        
        },
        series:[{
            name:'最低价格',
            type:'line',
            data:[]
        },{
            name:'平均价格',
            type:'line',
            data:[]
        },{
            name:'最高价格',
            type:'line',
            data:[]
        }]
    
    };
    
    myChart.setOption(option);
    
    myChart.showLoading();
    var min=[];
    var avg=[];
    var max=[];
    var dates=[];
    //ajax
    
    $.ajax({
       type:"post",
       url:"getList",
       dataType:'json',
       success:function(json){
         if(json){
         
           for(var i=0;i<json.length;i++){
              min.push(json[i].min);
              avg.push(json[i].avg);
              max.push(json[i].max)
              //需要把毫秒转换为年月日的格式
             var time= new Date(json[i].date);
             var y=time.getFullYear();
             var m=time.getMonth()+1;
             var d=time.getDate();
              dates.push(y+'-'+m+'-'+d);
           }
           
           //设置echarts数据
           myChart.hideLoading();
           myChart.setOption({
           
              xAxis:{
                data:dates
              },
              series:[{
              
               name:'最低价格',
               type:'line',
               data:min
              },{
              
               name:'平均价格',
               type:'line',
               data:avg
              },{
              
               name:'最高价格',
               type:'line',
               data:max
              }]
           })
         }
       }
        
    })
    
    
    </script>
  </body>
</html>
