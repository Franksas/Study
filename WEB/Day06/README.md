# 第六天笔记
### JS
##### 表格
- caption 标题
- rows 行（数组）
- table.rows[index] 第几行
- cells 所有单元格
- rowIndex 该行在表格中的索引值
- +居中:text-align:center 
##### 正则

- //^是开始，$是结束，[]取值范围，一个[]代表了一位数 ,{m,n}代表了几位数
      function add(){
        var id = $("#id").value;
        //^是开始，$是结束，[]取值范围，一个[]代表了一位数 ,{m,n}代表了几位数
        //()代表分组  |是或者的意思
        var reg = /^[0-9]$/;    //只能是数字，并且是数字开头数字结尾
       //var reg = /^([0-9])|([1-9][0-9]){0,2}$]/;
        if(! reg.test(id)){
            alert("编号只能是1-3位数字");
            return;中断当前程序
        }
