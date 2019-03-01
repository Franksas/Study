# 第八天笔记
##### 计时器
    var date = new Date();//获取当前时间
       var year = date.getFullYear();
       var month = date.getMonth()+1;//比实际月数小一
       month = (month < 10) ? "0" + month : month;
       var day = date.getDay();
       day = (day < 10) ? "0" + day : day;
       var hour = date.getHours();
       hour = (hour < 10) ? "0" + hour : hour;
       var minute = date.getMinutes();
       minute = (minute < 10) ? "0" + minute : minute;
       var second = date.getSeconds();
       second = (second < 10) ? "0" + second : second;
   }
- indow.setInterval("showTime()",1000);//定义一个计时器，参数一：计时器执行的函数 参数二：周期，毫秒
- window.setInterval(showTime,1000);//定义一个计时器，参数一：计时器执行的函数 参数二：周期，毫秒
- window.clearInterval(timer);//取消计时，销毁计时器对象；若不销毁，资源得不到释放
- setTimeout(计时器执行的函数，毫秒)；//在毫秒时间后，开始执行函数
- clearTimeout(计时器);//关闭计时器 ##jquery
###### jquery
- html有解析功能
- text为纯文本
- //jquery对象和dom对象的转换 var jObj = ("#d2");
- // var - dObj =("#d2")[0];//("#d2").get(0) var dObj =("#d2").get(0);
- jQuery slideDown() 方法用于向下滑动元素。
- jQuery slideUp() 方法用于向上滑动元素。
- jQuery slideToggle() 方法可以在 slideDown() 与 slideUp() 方法之间进行切换。
