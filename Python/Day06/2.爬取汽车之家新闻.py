import  requests
from bs4 import BeautifulSoup


response = requests.get("https://www.autohome.com.cn/news/")
response.encoding = "gbk"
#print(response.text)

soup = BeautifulSoup(response.text,'html.parser')

div = soup.find(name='div',attrs={'id':'auto-channel-lazyload-article'})
li_list = div.find_all(name='li')
for li in li_list:
    title = li.find(name='h3')
    if not title:
        continue

    p = li.find(name='p')
    a = li.find(name='a')
    print(title.text)
    print(a.attrs.get('href'))
    print(p.text)

    img = li.find(name='img')
    src = img.get('src')
    src = 'http:'+ src
    print(src)

    #再次发起请求，下载图片
    file_name = src.rsplit('/',maxsplit=1)[1]
    ret = requests.get(src)
    with open(file_name,'wb') as f:
        f.write(ret.content)



