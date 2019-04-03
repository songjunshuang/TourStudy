/**
 * Created by Gangdan on 2017/4/19.
 */

/*function //showTip(title){
    layer.tips(title,"#" + id,{tips : [3,"#5a98de"]})
};

/*var regList = [
    {
        name : 'name',
        id : 'name',
        reg : ['notnull','textlength','textnumber','textcn']
    }
];*/
var validate = function(employeeAccount,password,canvasId){
	var flag = "不能为空";
    if( employeeAccount == "" ){
    	flag = "用户名不能为空"
    }
    if( password == "" ){
    	flag = "密码不能为空"
    }
    if( canvasId == "" ){
    	flag = "验证码不能为空"
    }
    if (flag != "不能为空"){
    	alert(flag+"不能为空");
    	////showTip(flag+"不能为空");
        return false;
    } 
    
        /*
            if (objList[j] === 'textlength'){
                if(objVal.length<3 || objVal.length>32 ){
                    ////showTip(obj.name + '名称过长或过短',obj.id);
                    return false;
                }
            }else if(objList[j] === 'textnumber'){
                var reg = /^[0-9]\d*$/;
                if(objVal!==""){
                    if(!reg.test(objVal)){
                        //showTip(obj.name + '只能为数字',obj.id);
                        return false;
                    }
                }
            }else if(objList[j] === 'textcn'){
                if(!/[\u4e00-\u9fa5]/.test(objVal)){
                    //showTip(obj.name + '只能为汉字',obj.id);
                    return false;
                }
            }else if(objList[j] === 'notspecial'){
                var special = /(?=[\x21-\x7e]+)[^A-Za-z0-9]/;
                if(special.test(objVal)){
                    //showTip(obj.name + '内部含有非法字符',obj.id);
                    return false;
                }
            }else if(objList[j] === 'namelength'){
                if(objVal.length<2 || objVal.length>6){
                    //showTip(obj.name+ '请输入正确姓名',obj.id);
                    return false;
                }
            }else if(objList[j] === 'meID'){
                if(objVal!==""){
                    if(!/^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/.test(objVal)){
                        //showTip(obj.name + '输入有误！',obj.id);
                        return false;
                    }
                }

            }else if(objList[j] === 'phone'){
                if(!/^(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}$/.test(objVal)){
                    if(!/^1[34578]\d{9}$/.test(objVal)){
                        //showTip(obj.name + '填写有误!',obj.id);
                        return false;
                    }
                }

            }else if(objList[j] === 'email'){
                if(objVal!==""){
                    if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(objVal)){
                        //showTip(obj.name + '填写有误!',obj.id);
                        return false;
                    }
                }

            }else if(objList[j] === 'qq'){
                if(!/^\d{5,10}$/.test(objVal)){
                    //showTip(obj.name + '填写有误!',obj.id);
                    return false;
                }
            }else if(objList[j] === 'mobile'){
                if(!/^1[34578]\d{9}$/.test(objVal)){
                    //showTip(obj.name + '填写有误!',obj.id);
                    return false;
                }
            }else if(objList[j] === 'notcn'){
                if(!/[\u4e00-\u9fa5]/.test(objVal)){
                    //showTip(obj.name + '是由字母，数字组成的，和符号组成的',obj.id);
                    return false;
                }
            }else if(objList[j] === 'minlength'){
                if(objVal.length>2){
                    //showTip(obj.name + '输入错误！',obj.id);
                    return false;
                }
            }else if(objList[j] === 'workLength'){
                debugger
                if(!(1<=objVal && objVal<=18)){
                    //showTip(obj.name + '介于1-18数字，例如：1,2,3,4,5,6,7,8,9，10,11,12,13，14,15,16,17,18',obj.id);
                    return false;
                }
            }else if(objList[j] === 'qqLength'){
                if(!(objVal.length<=12)){
                    //showTip(obj.name + '最大长度不能超过12位',obj.id);
                    return false;
                }
            }else if(objList[j] === 'lastNumber'){
                if(!/.*[0-9]{8}$/.test(objVal)){
                    //showTip(obj.name + '规则不符，例如：java培训班20170903',obj.id);
                    return false;
                }
            }else if(objList[j] === 'user'){
                var special = /^[a-zA-Z0-9_-]{4,16}$/;

                if(!special.test(objVal)){
                    //showTip(obj.name + '长度大于四位，子母和数字组成',obj.id);
                    return false;
                }
            }else if(objList[j] === 'pw') {
                var special = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{4,16}$/;
                if (!special.test(objVal)) {
                    //showTip(obj.name + '只能由字母和数字组成', obj.id);
                    return false;
                }
            }else if(objList[j] === 'pwlength') {
                if (objVal.length < 6 || objVal.length > 16) {
                    //showTip(obj.name + '密码过长或过短', obj.id);
                    return false;
                }
            }else if(objList[j] === 'code') {
                if (!CheckSocialCreditCode(objVal)) {
                    //showTip(obj.name + '代码错误', obj.id);
                    return false;
                }
            }else if(objList[j] === 'web') {
                if (!IsURL(objVal)) {
                    //showTip(obj.name + '网站错误', obj.id);
                    return false;
                }
            }else if(objList[j] === 'file') {
                var special = /(.jpg|.JPG|.gif|.GIF)$/;
                if(!special.test(objVal)){
                    //showTip(obj.name + '格式不符合', obj.id);
                    return false;
                }
            }


        }
    }
    return true;
}
$(".c-red").parent().next().find("input,select").on("blur",function(){
    for(var i=0;i<regList.length;i++){
        if(regList[i].id==$(this).attr("id")){
            var reg = [];
            reg.push(regList[i]);
            validate(reg);
            break;
        }
    }
})

function CheckSocialCreditCode(Code) {
    var patrn = /^[0-9A-Z]+$/;
    //18位校验及大写校验
    if ((Code.length != 18) || (patrn.test(Code) == false)) {
        console.info("不是有效的统一社会信用编码！");
        return false;
    }
    else {
        var Ancode;//统一社会信用代码的每一个值
        var Ancodevalue;//统一社会信用代码每一个值的权重
        var total = 0;
        var weightedfactors = [1, 3, 9, 27, 19, 26, 16, 17, 20, 29, 25, 13, 8, 24, 10, 30, 28];//加权因子
        var str = '0123456789ABCDEFGHJKLMNPQRTUWXY';
        //不用I、O、S、V、Z
        for (var i = 0; i < Code.length - 1; i++) {
            Ancode = Code.substring(i, i + 1);
            Ancodevalue = str.indexOf(Ancode);
            total = total + Ancodevalue * weightedfactors[i];
            //权重与加权因子相乘之和
        }
        var logiccheckcode = 31 - total % 31;
        if (logiccheckcode == 31) {
            logiccheckcode = 0;
        }
        var Str = "0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F,G,H,J,K,L,M,N,P,Q,R,T,U,W,X,Y";
        var Array_Str = Str.split(',');
        logiccheckcode = Array_Str[logiccheckcode];


        var checkcode = Code.substring(17, 18);
        if (logiccheckcode != checkcode) {
            console.info("不是有效的统一社会信用编码！");
            return false;
        }else{
            console.info("yes");
        }
        return true;
    }
}

function IsURL(str_url){
    var strRegex = "^((https|http|ftp|rtsp|mms)?://)"
        + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@
        + "(([0-9]{1,3}\.){3}[0-9]{1,3}" // IP形式的URL- 199.194.52.184
        + "|" // 允许IP和DOMAIN（域名）
        + "([0-9a-z_!~*'()-]+\.)*" // 域名- www.
        + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\." // 二级域名
        + "[a-z]{2,6})" // first level domain- .com or .museum
        + "(:[0-9]{1,4})?" // 端口- :80
        + "((/?)|" // a slash isn't required if there is no file name
        + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";
    var re=new RegExp(strRegex);
    if (re.test(str_url)){
        return true;
    }else{
        return false;
    }*/
}


