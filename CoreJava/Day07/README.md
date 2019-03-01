# 第七天笔记
## Java中的语句
### 选择结构
- if 语句
- 如果if，for,while后面是变量定义的语句时，后面必须加上花括号{}，if...后面不允许创造，允许应用。
- 做软件设计：1.职责单一原则（某个类的功能是单一的，方法的功能是单一的）
2.通用功能独立实现
扩展，重用 维护三大原则  

### 循环结构
- Switch 里面的class后面只能是常量表达式
- Switch后面只能放byte，short ,int,char, String.五种
- ==可以用于简单的类型的比较（比较值），也可以比较复合类型（比较地址）
- default、case是java关键字，一般只在Switch这里出现
- 关于Switch的用法，可以将default提到case前面，会执行，但是注意break的控制流程；default只有当所有case匹配不到时执行；case后面的条件只能是常量。
