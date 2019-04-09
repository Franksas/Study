# -*- coding: utf-8 -*-
import csv
import requests
from lxml import etree

f = open('/Users/ning.liu/Desktop/test.csv', 'a+',encoding='utf-8-sig') # encoding='utf-8-sig' 这种编码格式适合写入csv文件，不然utf-8会乱码
writer = csv.writer(f)
url = "https://book.douban.com/top250"
headers = {
'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36'
}

def writer_csv(url):
    res = requests.get(url, headers = headers)
    res_text = res.content.decode('utf-8')
    html = etree.HTML(res_text)

    url_infos = html.xpath('//tr[@class="item"]') # 大标签具体到了class，取这里为循环点
    for url_info in url_infos:
        name = url_info.xpath('td[2]/div[1]/a/text()')[0].strip()
        grade = url_info.xpath('td[2]/div[2]/span[2]/text()')[0]
        link = url_info.xpath('td[1]/a/@href')[0] # 为什么这里不使用/text()呢？ 答：因为/text()只可以抓取文本数据，而这里的href并不是文本数据,而是以href="https://book.douban.com/subject/xxxx"的形式展现的
        messages = url_info.xpath('td[2]/p[1]/text()')[0] # 这里输出的messages的信息为：[美] 丹·布朗 / 朱振武 / 上海人民出版社 / 2004-2 / 28.00元 这种样式，所以必须还要加工处理
        price = messages.split('/')[-1] # 使用split处理得到对应信息
        date = messages.split('/')[-2]
        publish_house = messages.split('/')[-3]
        author = messages.split('/')[0]
        comments = url_info.xpath('td[2]/p[2]/span/text()')
        comment = comments[0] if len(comments) != 0 else "空" # 这里使用if语句判断comments[0]是否赋值给comment，从而避免了异常的产生

        writer.writerow((name, grade, link, author, publish_house, date, price, comment))

if __name__ == '__main__':
    writer_csv(url)
    f.close()


# writer.writerow(('1', 'liuning')) # writer.writerow()内的内容一定要为itemable

# name //*[@id="content"]/div/div[1]/div/table[2]/tbody/tr/td[2]/div[1]/a

# link //*[@id="content"]/div/div[1]/div/table[1]/tbody/tr/td[1]/a
# link //*[@id="content"]/div/div[1]/div/table[1]/tbody/tr/td[1]/a

# grade //*[@id="content"]/div/div[1]/div/table[1]/tbody/tr/td[2]/div[2]/span[2]