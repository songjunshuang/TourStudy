<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>研学旅行</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/login/css/login.css" />
    <%@ include file="topLine.jsp" %>
</head>
<body>
<div class="container">
    <h3 class="log-title">研学旅行</h3>
</div>
<div class="container-fluid login-bg">
    <div class="container">
        <div class="row">
           <div class="col-xs-7">
                <img src="${pageContext.request.contextPath}/static/login/images/logo.jpg" class="login-img" />
            </div>
            <div class="login-hr">
            <br/>
            </div>
            <div class="col-xs-3">
                <div class="login-panel">
                    <div class="login-tag">用户登录</div>
                    <div class="login-row">
                        <div class="login-input-border">
                            <i class="Hui-iconfont Hui-iconfont-user"></i>
                            <input type="text" name="" id="loginName" placeholder="请输入用户名" />
                        </div>
                    </div>
                    <div class="login-row">
                        <div class="login-input-border">
                            <i class="Hui-iconfont Hui-iconfont-suoding"></i>
                            <input type="password" name="" id="password" placeholder="请输入密码" />
                        </div>
                    </div>
                    <div class="login-row">
                        <div class="login-input-border" style="width: 160px;display: inline-block;">
                            <i class="Hui-iconfont Hui-iconfont-shenhe-tingyong"></i>
                            <input type="text" name="" id="canvasId" placeholder="请输入验证码"/>
                        </div>
                        <div class="login-code">
                            <canvas id="canvas" width="100px" height="36px"></canvas>
                        </div>
                    </div>
                    <div class="login-row">
                    	<input type="radio" name="role" id="role1" value="学生" checked="checked"/>学生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						<input type="radio" name="role" id="role2" value="教师" />教师&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
						<input type="radio" name="role" id="role3" value="管理员" />管理员      
                    </div>
                    <div class="login-row">
                        <button type="button" class="login-btn" onclick="login();">登录</button>
                    </div>
                    <div class="login-message">
                        ${requestScope.message}
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<footer class="footer">
    <div class="container-fluid">
        <nav> <a href="Test">关于我们</a> <span class="pipe">|</span> <a href="#" target="_blank">联系我们</a> <span class="pipe">|</span> <a href="#" target="_blank">法律声明</a> </nav>
        <p>研学旅行网站 <br>
            <a href="http://www.miitbeian.gov.cn/" target="_blank" rel="nofollow">京ICP备1000000号</a><br>
        </p>
    </div>
</footer>
<script type="text/javascript" src="<%=request.getContextPath()%>/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/lib/layer/2.4/layer.js"></script>
<script type="text/javascript">
/*
 * 生成验证码算法
 */
    /**生成一个随机数**/
    function randomNum(min,max){
        return Math.floor( Math.random()*(max-min)+min);
    }
    /**生成一个随机色**/
    function randomColor(min,max){
        var r = randomNum(min,max);
        var g = randomNum(min,max);
        var b = randomNum(min,max);
        return "rgb("+r+","+g+","+b+")";
    }
    drawPic();
    document.getElementById("canvas").onclick = function(e){
        e.preventDefault();
        drawPic();
    }

    /**绘制验证码图片**/
    var cc;
    function drawPic(){
        var canvas=document.getElementById("canvas");
        var width=canvas.width;
        var height=canvas.height;
        var ctx = canvas.getContext('2d');
        ctx.textBaseline = 'bottom';

        /**绘制背景色**/
        ctx.fillStyle = 'rgb(255,250,215)'; //颜色若太深可能导致看不清
        ctx.fillRect(0,0,width,height);
        /**绘制文字**/
        var str = 'ABCEFGHJKLMNPQRSTWXYabcdefghijklmnopqrstuvwxyz123456789';
        var code = ''
        for(var i=0; i<4; i++){
            var txt = str[randomNum(0,str.length)];
            code += txt;
            cc = code;
            ctx.fillStyle = randomColor(50,160);  //随机生成字体颜色
            ctx.font = randomNum(25,30)+'px SimHei'; //随机生成字体大小
            var x = 5+i*25;
            var y = randomNum(25,35);
            var deg = randomNum(-30, 30);
            //修改坐标原点和旋转角度
            ctx.translate(x,y);
            ctx.rotate(deg*Math.PI/180);
            ctx.fillText(txt, 0,0);
            //恢复坐标原点和旋转角度
            ctx.rotate(-deg*Math.PI/180);
            ctx.translate(-x,-y);
        }
        for(var i=0; i<100; i++){
            ctx.fillStyle = randomColor(0,255);
            ctx.beginPath();
            ctx.arc(randomNum(0,width),randomNum(0,height), 1, 0, 2*Math.PI);
            ctx.fill();
        }
    }
    function login() {
    	var loginName = $("#loginName").val();
    	var password = $("#password").val();
    	var role = $("input[name='role']:checked").val();

    	flag=1;
    	if( $("#canvasId").val().toLowerCase() != cc.toLowerCase()){
    		flag=0;
        	layer.tips("验证码错误",$("#canvasId"),{tips : [3,"#5a98de"]})
        }
    	if (loginName == "" || password == ""){
    		flag=0;
            if( $("#password").val("") ){
	        	layer.tips("密码不能为空",$("#password"),{tips : [3,"#5a98de"]})
	        }
	        if( $("#loginName").val("")){
	        	layer.tips("用户名不能为空",$("#loginName"),{tips : [3,"#5a98de"]})
	        }
    	}
    	if (flag==1){
        window.location.href = "LoginMiddle?loginName="+encodeURI(encodeURI(loginName))
        						+"&password="+encodeURI(encodeURI(password))
        						+"&role="+encodeURI(encodeURI(role));
    	}
    }
    //    回车登录事件
    $(function(){
        document.onkeydown = function(e){
            var ev = document.all ? window.event : e;
            if(ev.keyCode==13) {
                login();
            }
        }
    });
</script>
</body>
</html>

