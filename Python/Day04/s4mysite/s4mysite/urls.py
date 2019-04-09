"""s4mysite URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/2.1/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.conf.urls import url
#路由系统：url->函数
from django.shortcuts import HttpResponse,render,redirect
def login(request):
    """
    处理用户请求，并返回内容
    ：parm request：用户请求相关的所有信息（对象）
    ：:return
    """
    #return HttpResponse('login')
    #自动找到模板路径下的login.html文件，读取内容并返回给用户
    #模板路径的配置
    if request.method == "GET":
        return render(request,'login.html')
    else:
        u = request.POST.get('user')
        p = request.POST.get('pwd')
        if u == 'root' and p == '123123':
            return redirect('Http://www.oldboyedu.com')
        else:
            return render(request,'login.html')
urlpatterns = [
    #path('admin/', admin.site.urls),
    url(r'^login/',login),
]
