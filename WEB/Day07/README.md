# 第七天笔记
### JS
##### 正则
- 转义类
- \d ：代表数字
- . ：代表任意字符
- \D+ :此表达式代表了只能是非数字，+表示至少一个
- \D* :只能是非数字，可以没有，*也可以是很多个
- \D? :只能是非数字，可以没有，?但最多只能有一个
- //\D也可以用下面的表达方式 reg = /^[^0-9]+$/;
- \s :代表空白
- \S :代表非空白
- \w :代表了单词,单词可以是数字字母下划线
- \W:代表了非单词,用范围表示          - -  -alert(/^[^a-zA-Z0-9_]*$/.test("")); +:表示至少一个 *:可以没  有，也可以是很多个 ?:可以没有,但最多只能有一个

#### BOM(Browser Object Model)浏览器对象模型
##### Window
- BOM(Browser Object Model)：浏览器对象模型

- global var
- alert/confirm/prompt
- location
- screen
- history
- 定时器
- navigation
- code
-
      var  btnSubmit = $("button")[0];
      //虽然btnSubmit有提交的功能，不用专门去提交，但是为了保证系统的数据的有效性和安全性，
      // 要在提交前对数据进行正则的有效性效验
      btnSubmit.onclick = function(){
          var reg;//正则对象
        var id = $("#id");
        //reg = new RegExp("/^[0-9][4]$/");
        //reg = /^[0-9][4]$/;
       /* reg = /^\d[4]$/;//\d转义，代表了数字的意思
        if(!reg.test(id.value)){
            alert("编号信息不合法，请重新输入");
            return false;
        }*/
        //代表了任意字符
       /* reg = /^.{4}$/;
        alert("1234:"+ reg.test("1234"))*/
       /* reg = /^.{5}$/;
        alert("al,中"+ reg.test("al.中"));*/
        reg = /^\D+$/;//此表达式代表了只能是非数字，+表示至少有一个
      //   var str = "1234";
      //   alert(str + ":" +reg.test("str"));
       /* var str = "a,8中";
        alert("al,中"+ reg.test(str));*/

        /* reg = /^\D*$/;//只能是非数字，可以没有，也可以是任意多个
         alert("："+ reg.test(""));*///true
        /* reg = /^\D?$/;//?表示可以没有，但最多只能是一个
         /*alert("："+ reg.test(""));//true
         alert("a："+ reg.test("a"));//true
         alert("aa："+ reg.test("aa"));//false*!/

         alert("/^[0-9]+$/".test("1"));//true
        alert("/^[^0-9]+/".test("a"));//true
        //不能以空白开始和结尾，但中间至少有一个空白
        alert(/^\S\s+\S$/.test("李 白"));*/

        //什么是单词？代表可以是数字字母下划线
       // alert(/^\w*$/.test("al_AZ"));//false
        //\W代表了非单词，用范围表示如下
        //alert(/^[^A-Za-z0-9]*$/.test(""));
        //并集
       /*  var str = "abc.dmnop";
        alert(/^[a-dm-p]+$/.test(str));*/
        //交集
        alert(/^[a-z&[def]]+$/.test("fed"));
        //return false;//如果此处返回false，则页面不会进行提交
       }

- nextSibling 和nextElementSibling的区别
使用nextSibling属性返回指定节点之后的下一个兄弟节点，（即：相同节点树层中的下一个节点）。
nextSibling属性与nextElementSibling属性的差别：
nextSibling属性返回元素节点之后的兄弟节点（包括文本节点、注释节点即回车、换行、空格、文本等等）；
nextElementSibling属性只返回元素节点之后的兄弟元素节点（不包括文本节点、注释节点）；
注意: 空格、回车也会看作文本，以文本节点对待。
