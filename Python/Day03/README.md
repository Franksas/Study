## 字符串操作
    capitalize()#首字母大写
    upper()#全大写
    lower()#全小写
    swapcase()#大小写翻转
    strip#默认删除空格
    replace()#替换
    reverse()#反转
    li.sort()#排序
    
 ## web框架本质
 - 本质socket
 - Http协议
    - 头
    - 体
- 字符串
- requests 伪造浏览器发起Http请求
- bs4 将html格式的字符串解析成对象，对象.find/find all
- Referer头，上一次请求的地址可以用于防盗链
- 总结：
    - 请求头：
       - user-agen
       - referer
       - host
       - 特殊请求头，查看上一次请求获取内容
     - 请求体：
       - 原始数据
       - 原始数据+token
       - 密文（找算法，使用密文）
      - 套路
        - post登录获取cookie,以后携带cookie
        - get获取未授权cookie，post登录携带cookie去授权，以后携带cookie
        
 - 方法
      - requests.get
      - requests.post
      - requests.put
      - requests.delete
      ...
      requests.request(method='POST')
"""
 -  参数
    - requests.get(
           url='xxx',
           headers={},
           cookies={},
           params={}
       )
     - requests.post(
           url='xxx',
           headers={},
           cookies={},
           params={},
           data={}
       )
       
 - 文件上传
   - 发送文件
   file_dict = {
       'f1':open('xxx.log','rb')
   }
   requests.request(
       method='POST',
       url='http://127.0.0.1:8000/test/',
       files=file_dict
   )