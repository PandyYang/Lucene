# Lucene
Lucene实现全文检索技术
## 创建索引的基本步骤
- 创建directory对象 指定索引库保存的位置  
 
- 基于directory对象创建一个indexwriter对象  
 
- 读取磁盘上的文件 对象每个文件创建一个文档对象  
 
- 向文档对象中添加域  
 
- 把文件对象写入索引库  
 
- 关闭indexwriter对象  

## 使用luke查看索引信息  

下载luke  
双击.bat文件打开  
其中有overviwe doucument search等选项  
![image](https://github.com/PandyYang/Lucene/blob/master/1558349224(1).jpg)  

## 一个简单的索引查询  
- 查询索引库
- 创建一个director对象 指定索引库的位置
- 创建一个indexReader对象
- 创建一个indexsearcher对象 构造方法中的参数 indexReader
- 创建一个query对象 teamQuery
- 执行查询 得到一个查询结果 topdocs对象
- 取查询结果的总记录数
- 取出文档列表
- 打印文档中的内容
- 关闭indexReader对象  

_示例结果_  
```
topDocs = 5
document = spring_README.txt
document = G:\ideaProject\searchsource\spring_README.txt
document = 3257
------------------------------->
document = springmvc.txt
document = G:\ideaProject\searchsource\springmvc.txt
document = 2124
------------------------------->
document = 2.Serving Web Content.txt
document = G:\ideaProject\searchsource\2.Serving Web Content.txt
document = 35
------------------------------->
document = 1.create web page.txt
document = G:\ideaProject\searchsource\1.create web page.txt
document = 47
------------------------------->
document = spring.txt
document = G:\ideaProject\searchsource\spring.txt
document = 82
------------------------------->

Process finished with exit code 0

```
