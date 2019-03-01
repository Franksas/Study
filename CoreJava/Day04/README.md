# 基本数据类型的转换
- 小数的默认类型：double 整数的默认类型：int
- float型数据在写时后要加f/F
- java 中char、byte、short在内部处理时都以int看待

- 低级类型向高级类型可以自动转换、高级类型向低级类型要强制转换      byte->char->short->int->long->float->double
- 内存的逻辑划分：
栈：先进后出；放局部变量（方法形参，方法内部定义的）；应用于频繁的数据交换；由OS管理
堆：放创建的对象，new的对象全放在堆区
全局数据区:static类型数据
代码段：



-----
内存泄漏:无用对象依然占用内存空间
Java垃圾回收机制：自动回收机制；
 我们能不能使用system。gc（）强制JVM立即垃圾回收？只是建议，不能强制

----
### git分支合并；冲突解决
- 1.如何分支的合并
在git中，可以使用git merge 和git rebase两个命令来进行分支的合并。
git merge命令示例:
$ git merge branchname
这个命令把分支"branchname"合并到了当前分支里面。
如有冲突(冲突--同一个文件在远程分支和本地分支里按不同的方式被修改了）；那么命令的执行输出就像下面一样
$ git merge next
 100% (4/4) done
Auto-merged file.txt
CONFLICT (content): Merge conflict in file.txt
Automatic merge failed; fix conflicts and then commit the result.
在有问题的文件上会有冲突标记，在你手动解决完冲突后就可以把此文件添 加到索引(index)中去，用git commit命令来提交，就像平时修改了一个文件 一样。
如果你用gitk来查看commit的结果，你会看到它有两个父分支：一个指向当前的分支，另外一个指向刚才合并进来的分支。

- 2.解决合并中的冲突
如果执行自动合并没有成功的话，git会在索引和工作树里设置一个特殊的状态， 提示你如何解决合并中出现的冲突。
有冲突(conflicts)的文件会保存在索引中，除非你解决了问题了并且更新了索引，否则执行 git commit都会失败:
$ git commit
file.txt: needs merge
如果执行 git status 会显示这些文件没有合并(unmerged),这些有冲突的文件里面会添加像下面的冲突标识符:
<<<<<<< HEAD:file.txt
- Hello world

=======

Goodbye>>>> 77976da35a11db4580b80ae27e8d65caf5208086:file.txt
你所需要的做是就是编辑解决冲突，（接着把冲突标识符删掉），再执行下面的命令:
$ git add file.txt
$ git commit
- 3.冲突解决：
基于同个原始分支后，两个分支同步开发，最后合并：合并两个分支
-  branch1/2可以是分支名，也可以通过指定版本的SHA1 16进制的前7个位
git merge branch1 branch2
解决冲突：
  通过git diff来比较两个分支的不同点，手动合并：
-  比较两个分支(默认比较所有的不同)
git diff d02b6ff 919b8ea
- 比较版本d02b6ff和版本919b8ea的common.h文件
-  默认diff
git diff d02b6ff 919b8ea -- api/include/common.h
- 配置好vim diff
git d d02b6ff 919b8ea -- api/include/common.h
处理完冲突后，已合并的分支：
git add [file]
git commit -m "xxx"
现在的分支状态变为(在M最新的基础上超前M分支)：
M最新分支变为D：
方式一：D申请merge request到M管理者
方式二：M主动合并D
