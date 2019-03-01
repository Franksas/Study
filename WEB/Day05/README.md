# 第五天笔记
### 异常和调试
- throw new Error('000000')
- try/catch/finally
- 只有catch（e）
- 错误信息通过e. message属性获取
- 没有throws
###### 调试
- alter（）调试。最直接最简单的调试，在交付程序后，不能出现在任何alter
- 浏览器开发人员工具 ctrl+shift+I；
##### DOM
- Document Object Model 把网页变成一个文档树，动态修理树，增加修改删除节点
- 1、访问
      document.getElementById（‘’）；
      document.getElementByName（‘’）；
      document.getElementBytagName（‘标签名’）
      relation（关系）
      Node parentNode；
      Node preElementSibLing
##### 查询和修改
- checked属性 预先选定复选框或单选按钮
- 通过 id 找到 HTML 元素 id var x=document.getElementById("intro");
- 通过标签名找到 HTML 元素 tag标签名,选中该类型所有标签 var y=x.getElementsByTagName("p");
- 通过类名找到 HTML 元素 name document.getElementsByName('xx') 可能获取到一组,
- relation Node parentNode Node preElementSibling nextElementSibling Node[] childNodes firstChild lastChild
##### 列表
- value 值
- length 选项个数
- options 选项数组
- selectedindex 选中项的索引
- option 选项
- index 索引
- text 文本
- value 选项的值
- select 是否被选中
- option[i].selected="selected";//这个选项被选中，
