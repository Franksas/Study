import  requests
from bs4 import  BeautifulSoup


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
    print(title)

