from django.shortcuts import render

def classes(request):
    import  pymysql
    conn = pymysql.connect(host='localhost',port=3306,user='root',passwd='yhs40470',db='s4db65',charset='utf-8')
    cursor = conn.cursor(cursor=pymysql.cursor.DictCursor)
    cursor.execute("select id,title from class")
    class_list = cursor.fetchall()


    cursor.close()
    conn.close()
    return render(request,'classes.html',{'class_list':class_list})
def add_class(request):
    if request.method == "GET":
         return render(request, 'add_class.html')
    else:
        v = pymysql.connect