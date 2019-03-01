# 第九天笔记
##### 切换图片
- 写两个div添加图片和图片索引，利用for循环添加
让所有的图片隐藏，让所有小方框不选中，让该显示的显示和选中
创建计时器，第一步重置（让所有的图片隐藏，让所有小方框不选中，让该显示的显示和选中），回到最初，重置
      var NUM = 5;//表示caroursel的小方框的个数,轮播的个数
        //添加图片与图片索引框
        for(var i =1;i<=NUM;i++){
            $("#imgDiv").append("<img src='img/" + i + ".jpg' width='500px'" +
                    " height='400px'>");
            $("#spanDiv").append("<span id='i' class='id' onmouseover='mover(this)'>" +i+ "</span>");
        }

        //让所有的图片隐藏，让所有小方框不选中，让该显示的显示和选中(第一种写法)
        $("img").css("display","none").eq(index).css("display","block");
        $("span").removeClass("selected").eq(index).addClass("selected");

        //让所有的图片隐藏，让所有小方框不选中，让该显示的显示和选中(第二种写法)
        //$("img").css("display","none");//隐藏所有图片
        //$("span").removeClass("selected");//让所有小方框不选中
        //让该显示的显示和选中
        //$("img").eq(index).css("display","block");
        //$("span").eq(index).addClass("selected");

        var index = 0;//当前选中的索引
        var timer = setInterval(function(){
            //第一步重置
            $("img").css("display","none");//隐藏所有图片
            $("span").removeClass("selected");//让所有小方框不选中
            //让该显示的显示和选中
            $("img").eq(index).css("display","block");
            $("span").eq(index).addClass("selected");

            if(++index == NUM){
                index = 0;//回到最初，重置
            }
        },1000);
- 增加鼠标移动上去与移开事件
$("span").hover方法中有两个函数，第一个是鼠标移上去触发的事件，第二个是鼠标移出去触发的事件

- 鼠标移上去停止计时器，隐藏所有图片显示停留span处索引的图片，让所有小方框不选中，选中停留span处索引的小方框
- 鼠标移开，将第一步选中的索引赋给变量a,从新创建一个计时器，显示和选中索引为a的图片和小方框并进行循环时图片滚动
      $("span").hover(
        function () {
            clearInterval(timer);
            $("img").css("display","none").eq(this.innerHTML-1).css("display","block");
            $("span").removeClass("selected").eq(this.innerHTML-1).addClass("selected");
        },
        function () {
            var a = this.innerHTML;
            timer = setInterval(function(){
                //第一步重置
                $("img").css("display","none");//隐藏所有图片
                $("span").removeClass("selected");//让所有小方框不选中
                //让该显示的显示和选中
                $("img").eq(a).css("display","block");
                $("span").eq(a).addClass("selected");

                if(++a == NUM){
                  a = 0;//回到最初，重置
                }
            },1000);
        }
      );
