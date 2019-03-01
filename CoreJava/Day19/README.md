# 第十九天笔记
###
#### 集合
java 的集合java.util.collection接口
1.list/set     \Map
list是有序集合，有序可重复
set是无序不可重复
- 遍历集合的方式：
- for (String s : strList) {
			System.out.println(s);
		}
- 	for (int i = 0; i < strList.size();i++) {
			System.out.println(strList.get(i));
		}
- iterator迭代器遍历
- 1）list和set的遍历---去集合中的元素
 - 2）如何过滤掉List中的重复元素
 - 3）size() ，list.get(),add();
 - 4)Map     键-值 对
 key 键
 value 值
##### 面试题 HashMap与HashTable区别
- HashMap不是线程安全的， 接受空的key和value
- HashTable是线程安全的一个Collection，不接受空的key和value

- collection与collections没有关系collections是集合实用类并非集合
- 集合可以通过toArray变成数组
- web编程部分
### 泛型
- 就是类型参数化，增强方法的适应性    广泛，不限定什么
#### 注解
- 要通过注解来代替XML
- 看懂，会用
- 自定义注解：
工作中： 服从框架或第三方组件的注解定义；看懂第三方提供的注解有什么作用。
注解的主要使用场合：第三方组件定义的注解
