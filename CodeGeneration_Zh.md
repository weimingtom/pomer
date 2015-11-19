# Introduction #

Pomer代码生成器，主要生成Pomer框架的模块代码。
Pomer代码生成器使用freemark做为模板语言.结合Pomer代码生成器和freemark模板，可直接生成基于pomer框架的代码，以提高工作效率。使用Pomer框架和Pomer代码生成器，可平均降低项目30%-50%的编码时间，让您专注于业务开发。

Pomer代码生成器主要功能如下：
  * 从数据库直接生成基于Pomer框架的可运行的增删改查java后台和Cairngorm的前台FLEX代码
  * 从Java Pojo生成flex的列表，表单，和数据传输对象
  * 从Java接口生成flex Cairngorm的框架代码。

Pomer代码生成的组成：
  * PomerGenerator,主要负责生成freemark模板的数据模型
  * 一套默认的模板
  * 可扩展的代码生成框架
  * 可视化的Ecipse插件。


Pomer代码生成类设计图

![http://lh3.ggpht.com/yulinlincom/SM5z7JCYUZI/AAAAAAAAAbg/FH6Or6zmKGQ/PomerGeneratorClassDiagram.jpg](http://lh3.ggpht.com/yulinlincom/SM5z7JCYUZI/AAAAAAAAAbg/FH6Or6zmKGQ/PomerGeneratorClassDiagram.jpg)