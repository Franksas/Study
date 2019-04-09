import requests
import multiprocessing

#1.找到url
def temp(n):
     url = "https://sohu.com-v-sohu.com/20181101/13971_6060c196/1000k/hls/652817bea0d000.ts"
     headers = {
         "User-Agen":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36"
     }
     #2.解析url
     print(url)
     r = requests.get(url,headers=headers)
     #3.提取数据
     #ret = r.content
     #4.保存数据
     f = open('D:\\电影\\{}'.format(url[-8:]),'ab')
     f.write(r.content)
     f.close()
'''
if __name__ == '__main__':

    pool = Pool(20)
    for i in range(1383,1730):
        pool.apply_async(temp, (i,))

        pool.close()
        pool.join()
'''