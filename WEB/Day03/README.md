# WEB第三天
### CSS
##### 定位和浮动（position）
- CSS 有三种基本的定位机制：普通流、浮动和绝对定位。除非专门指定，否则所有框都在普通流中定位。
- 1.CSS position 属性
- relative 元素框偏移某个距离。元素仍保持其未定位前的形状，它原本所占的空间仍保留。
- absolute 元素框从文档流完全删除，并相对于其包含块定位。包含块可能是文档中的另一个元素或者是初始包含块。元素原先在正常文档流中所占的空间会关闭，就好像元素原来不存在一样。元素定位后生成一个块级框，而不论原来它在正常流中生成何种类型的框。
- fixed 元素框的表现类似于将 position 设置为 absolute，不过其包含块是视窗本身。
- 2.相对定位（relative）（相对于父框）
设置为相对定位的元素框会偏移某个距离。元素仍然保持其未定位前的形状，它原本所占的空间仍保留。
      *{
        margin: 0px;
        padding: 0px;
    }
    #div1 {
        width: 300px;
        height: 300px;
        background-color: red;
        position: relative;/*相对布局：在它正常应该出现的位置上的基础上，移动相应的距离*/
        /*如果不设置定位，则div应该正常出现在浏览器x=0，y=0的位置*/
        top:50px;/*向下移动50像素，div2不动。此类型的相对定位，只是移动了div1的位置，但它并没有释放原来占有的空间
        。不会因为div1移动，div2去补充*/
        left: 50px;/*向右移50像素，div2不影响*/
    }  #div2 {
        width: 300px;
        height: 300px;
        background-color: green;
        /*该div应出现在div1的下方*/
    }
- 3.绝对定位（absolute）（相对于父框）
设置为绝对定位的元素框从文档流完全删除，并相对于其包含块定位，包含块可能是文档中的另一个元素或者是初始包含块。元素原先在正常文档流中所占的空间会关闭，就好像该元素原来不存在一样。元素定位后生成一个块级框，而不论原来它在正常流中生成何种类型的框。
- 4、固定定位（fixed）
固定定位，不以父容器的左上角来定位，而是始终以浏览器的左上角来定位，会释放空间
- 5、 z-index
z—index值越大越在最上面，可以为负，要使用z-index属性时，此元素必须是绝对定位或固定定位
- 6、浮动（float）
浮动的框可以向左或向右移动，直到它的外边缘碰到包含框或另一个浮动框的边框为止。由于浮动框不在文档的普通流中，所以文档的普通流中的块框表现得就像浮动框不存在一样。
- 在浮动元素后边的元素如果想要恢复原有的特性，需要使用clear来清除浮动clear：left、right、both-
