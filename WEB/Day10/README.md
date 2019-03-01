# 第十天笔记
##### 一、轮播图片
    css （“display”，“none”）（属性，值）访问匹配元素的样式属性。block选中
    clone（） 克隆
    html（）取得第一个匹配元素的html内容。
    on（）在选择元素上绑定一个或多个事件的事件处理函数。
##### Jquery中绑定事件有三种方法：以click事件为例

（1）target.click(function(){});

（2）target.bind("click",function(){});

（3）target.live("click",function(){}); - live被弃用 用on

##### 1、 bind 与 live的区别
bind只能给页面加载时存在的元素绑定事件，对于新增的元素是无效的
live是给所有的元素绑定事件，不管是原有的还是新增的
layui第一天课堂笔记
layui（谐音：类UI) 是一款采用自身模块规范编写的前端 UI 框架，
msg()是在窗体中间弹出一个类似于andro的弹框
##### 一、引用
./layui/css/layui.css
./layui/layui.js //提示：如果是采用非模块化方式（最下面有讲解），此处可换成：./layui/layui.all.js
<style type="text/css" rel="stylesheet"  href="layui/css/layui.css"></style>
    <!--  rel 属性规定当前文档与被链接文档之间的关系。-->
    <script type="text/javascript" src="layui/layui.all.js"></script>
###### 二、页面元素
- 1.布局
- 2.颜色
        (1).内置的七中背景色
        赤色：class="layui-bg-red"
        橙色：class="layui-bg-orange"
        墨绿：class="layui-bg-green"
        藏青：class="layui-bg-cyan"
        蓝色：class="layui-bg-blue"
        雅黑：class="layui-bg-black"
        银灰：class="layui-bg-gray"
- 3.图标（icon）
layui 的所有图标全部采用字体形式，取材于阿里巴巴矢量图标库（iconfont）。因此你可以把一个 icon 看作是一个普通的文字，这意味着你直接用 css 控制文字属性，如 color、font-size，就可以改变图标的颜色和大小。
- （1）使用方法
i class="layui-icon layui-icon-face-smile" style="font-size: 50px;color: cyan">
i标签显示斜体文本效果。
- 4.动画（anim）
      从最底部往上滑入layui-anim-up

      微微往上滑入layui-anim-upbit

      平滑放大layui-anim-scale

      弹簧式放大layui-anim-scaleSpring

      渐现layui-anim-fadein

      渐隐layui-anim-fadeout

      360度旋转layui-anim-rotate

      循环动画追加：layui-anim-loop

- 5、按钮（btn）
      <button class="layui-btn">一个标准的按钮</button>
      <a href="http://www.layui.com" class="layui-btn">一个可跳转的按钮
      layui-btn-fluid	用于定义流体按钮。即宽度最大化适应。
      (1)尺寸
      大型	class="layui-btn layui-btn-lg"
      默认	class="layui-btn"
      小型	class="layui-btn layui-btn-sm"
      迷你	class="layui-btn layui-btn-xs"
      （2）圆角（radius）
      <button class="layui-btn layui-btn-radius layui-btn-warm">上传</button>
      (3)不可选中按钮 （disabled）
      <button class="layui-btn layui-btn-disabled ">删除</button>
      (4)按钮添加图标
      <button class="layui-btn">增加<i class="layui-icon layui-icon-loading layui-anim layui-anim-rotate layui-anim-loop"></button>
      layui-anim layui-anim-rotate layui-anim-loop 动画效果360旋转和循环动画
      (5)、按钮分组（group）
      <div class="layui-btn-group">
             <button class="layui-btn"><i class="layui-icon layui-icon-next"></i></button>
             <button class="layui-btn"><i class="layui-icon layui-icon-prev"></i></button>
             <button class="layui-btn">3</button>
         </div>

###### 6.表单
      lay-verify 验证
      layui-form-item:标识每个form-item
      layui-form-label:设置表单提示样式
      layui-input-inline:设置表单行内显示
      layui-input-block ： 原始表单元素区域 使表单变短
      required:注册浏览器所规定的必填字段
      autocomplete:设置是否自动完成
      class="layui-input":layui指定的通用css
      layui-form-mid:设置辅助文字居于输入框中部
      layui-word-aux:设置提示文字样式
      layui-form-mid:设置辅助文字居于输入框中部
      layui-word-aux:设置提示文字样式
      lay-skin="switch" 开关
      layui-textarea 文本框
      layui-btn-primary" 原始按钮
      disabled 禁用
      lay-search 带搜素
