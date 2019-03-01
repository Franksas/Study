###职业化软件基础设施学习笔记
```
1.安装各种软件
```
- xmind
- 金山打字通
- Notepad++
- Firefox
- Opera 浏览器
- Safari
- Google Chrome
- Atom
- Git
- Evergthing
- npp
- Subline

 ```
2.快捷键使用
```
- windows:显示或隐藏"开始"功能表
- windons+BREAK:显示"系统属性"对话框
- Windows+D：显示桌面
- Windows+M：最小化所有窗口
- Windows+E：开启“资源管理器”
- Windows+CTRL+ F：查找电脑
- Windows+R：开启“运行” 对话框
- Windows+L：切换使用者（Windows XP新功能）
- Windows+u：开启“公用程序管理器”
- Ctrl+w:关闭程序
- Ctrl+o:打开
- Ctrl+a:全选
- Ctrl+z：撤销
- Ctrl+f:查找
- frewall.cpl:防火墙
- calc:计算器
- notepad:记事本
- mspaint：画图
- ncpa.cpl:网络连接
- control:控制面板
- cmd:控制台
- sysdm.cpl:系统属性
- msconfig：系统配置
- regedit：注册表
- serales。msc:服务

```
3.Git中的各种术语
```
- git init Java1008:建仓库
- cd Java：进入仓库
- git branch :查看本地分支
- git branch -r:查看远程分支
- git branch yinhansong:新建分支
- git push --set--upstream origin+分支名:推送远程分支
- git checkout+分支名：切换分支
- mkdir+文件名：创建文件夹
- git add*：推送所有
- git commit -m ""：推送到暂存区
- git push origin yinghansong：推送到远程指定分支


4.Git 中遇到的问题
```
1.如果远程删除，本地也想删除，怎么办？
- git pull
2.如果本地删除，远程也想删除，怎么办？
- 回到跟目录
- git add *
- git commit -m""
- git push origin
3.如果在本地误删许多文件，怎么办？
- 到远程重新克隆项目

```
5.markdown
```
- Markdown 是一种轻量级的标记语言，可以用一些简单语法来表达一些富文本内容。
- 使用 Markdown 的优点:
专注你的文字内容而不是排版样式，安心写作。
轻松的导出 HTML、PDF 和本身的 .md 文件。
纯文本内容，兼容所有的文本编辑器与字处理软件。
随时修改你的文章版本，不必像字处理软件生成若干文件版本导致混乱。
可读、直观、学习成本低。
```
6.VPN
``
虚拟专用网指的是在公用网络上建立专用网络的技术。其之所以称为虚拟网，主要是因为整个VPN网络的任意两个节点之间的连接并没有传统专网所需的端到端的物理链路，而是架构在公用网络服务商所提供的网络平台，如Internet、ATM(异步传输模式〉、Frame Relay （帧中继）等之上的逻辑网络，用户数据在逻辑链路中传输。
  ```
  7.如何生成SSH公钥
  ```
  - 1.在命令行中输入： gitconfig−−globaluser.name"YourName"
  gitconfig−−globaluser.name"YourName"
   git config --global user.email "email@example.commit
   -  2.创建SSH Key需要把邮件地址换成你自己的邮件地址，然后一路回车，使用默认值即可。
   - 3.文件里面有id_rsa和id_rsa.pub两个文件，这两个就是SSH Key 的秘钥对，id_rsa是私钥，不能泄露出去，id_rsa.pub是公钥，可以放心地告诉任何人。
   - 4登录码云，在SSH公钥文本框里粘贴id_rsa.pub文件的内容。
