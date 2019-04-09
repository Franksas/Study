import requests



r2 = requests.post(
    url='https://dig.chouti.com.login',
    headers={
        'user-agent':'Mozilla/5.0(windows NT 6.1;win64;x64)ApplewebKit/537.36(KHTML,like Gecko) Chrome/63.0.3239.132 Safari/537.36'
    },
    data={
        'phone':'8613121758648',
        'password':'woshiniba',
        'oneMonth':1
    }
)
print(r2.text)
print(r2.cookies.get_dict())

# r3 = requests.post(
#     url='https://dig.chouti.com/link/vote?linksId=20435396',
#     headers={
#         'user-agen':'Mozilla/5.0(windows NT 6.1;win64;x64)ApplewebKit/537.36(KHTML,like Gecko) Chrome/63.0.3239.132 Safari/537.36'
#
#     },
#     cookies=r2.cookies.get_dict()
# )