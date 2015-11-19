http://lh6.ggpht.com/yulinlincom/SK15ZYpj0dI/AAAAAAAAAac/sur-y0EgnLM/pomeranian_cp.PNG

# Pomer：基于Flex和Java EE的信息管理系统基础框架 #
[英文](http://code.google.com/p/pomer)
## [开始在线学习Pomer](help_doc_zh.md) ##

---

## 什么是 Pomer ##
Pomer是一个开源的企业信息管理系统基础框架，它提供了一系列企业信息管理系统的基础功能，包括企业组织架构管理，角色权限管理，菜单管理，数据权限控制等功能。 Pomer提供了简洁高效的Flex应用程序开发框架，丰富实用的Flex控件以及常见的Flex应用模式，和一个基于Pomer框架的代码生成器，基于Pomer，可以快速开发出优秀的管理信息系统，而不用太关注业务以外的技术细节。[License](http://www.apache.org/licenses/LICENSE-2.0).

---

## Pomer 有哪些组件 ##
  * [Flex 开发框架](FlexFramework_Zh.md)
Pomer主要采用spring和hibernate做为后台框架，通过blazeds(LCDS)RemoteObject与java后台通信，前台采用Cairngorm MVC框架， Pomer框架主要作用就是简化blazeds(LCDS)RemoteObject的访问方式，提高开发效率。Pomer通过注解 (Annotation)将普通java对象，Spring Bean和EJB发布为远程对象（RemoteObject）提供给flex访问，而不需要进行任何配置 。

  * [代码生成器](CodeGeneration_Zh.md)
Pomer代码生成器包括两个部分，一个是强大灵活通用代码生成器模型和一套基于Pomer的默认模板。
Pomer通用代码生成器采用freemark做为模板引擎，可以生成任何基于数据表或javaPojo和java接口的代码，用户只需提供freemark的模板即可。
Pomer提供的默认生成功能和默认模板可以通过数据库生成基于Pomer框架可运行的增删改查代码，也可以从javaBean生成RemoteObject的数据传输对象、表单和列表，还能通过java接口生成Cairngorm的框架代码。

  * [Flex 组件](CodeGeneration_Zh.md)
提供一系列高效用户交互组件，渲染极佳用户体验

  * [组织架构管理](OrganizationStructure_Zh.md)
Pomer提供一个简单的企业组织架构管理。主要是为了演示FLEX和JAVA的各种应用模式。

  * [安全管理](SecurityManagement_Zh.md)
Pomer提供一个简单的通用安全框架。

  * [SAM 单点登录集成](SSO_Zh.md)
基于行业标准的开源单点登录集成


**Pomer Functional Architecture**

![http://www.javaeye.com/upload/attachment/35918/5c06dede-8bb0-3da6-abee-0b46d11c554e.jpg](http://www.javaeye.com/upload/attachment/35918/5c06dede-8bb0-3da6-abee-0b46d11c554e.jpg)

---

## Pomer 能做什么 ##
  * Pomer是一个基于Flex & Java的基础开发框架，是经检验过的开发Flex应用程序的高效实践。使用Pomer开发Flex应用程序，您不必再为Flex与Java通信方式的选择、项目组织架构的建设、企业应用通用组件模块的开发而花费宝贵时间。

  * Pomer可以做为企业信息管理系统的基础开发框架。
> Pomer已经完成了企业信息管理系统中大部分的常见功能，如组织机构管理，访问控制管理、菜单权限管理、数据安全管理等。基于Pomer，可以快速开发出企业信息管理系统。

  * Pomer提供一组与SAM（单点登录）集成的接口，可以做为企业的安全管理中心。

  * Pomer提供一套代码生成器，您能减少大量时间使用复制和粘贴建立样板代码，减少代码出错率。
> 用户使用Pomer代码生成器，可根据数据库快速生成基于Pomer项目框架的项目工程代码，您可以立即将此工程部署到符合Java EE规范的Web容器中并立即运行，此过程无需编写任何代码。生成的代码基于Flex、Struts2.x、Spring2.x和Hibernate3.x。用户还可以自定义代码生成模板生成符合您业务需要的代码。

  * Pomer提供丰富实用的Flex控件，实现高效RIA应用，极大增强了用户体验。

  * Pomer提供一个简易高效的Flex应用程序开发框架，您可以快速搭建起符合企业应用的项目框架，它提供的实用程序包使得Flex与Java交互应用开发变得简洁高效。


---

## 如何使用 Pomer ##


---

## Pomer 名称的由来 ##
**Pomer 取自英文单词Pomeranian的缩写形式**。Pomeranian的意思是波美拉尼亚犬或博美犬，它是狐狸犬家族中最小的犬种，其名出自原产地波美拉尼亚，在波兰西北部和德国东北部。

博美是一种活跃的犬种，聪明勇敢并且是忠实的同伴。它们可能不适于与幼儿互动，因为它们的小体型可能会让它们被小孩虐待。它借着宏亮尖锐的吠声，通知闯入者的到来，证明了它们为优秀的看守犬。它们能轻易的适应都市生活，并且就乡村生活而言，也是优秀的犬种，拥有野生祖先传下来的强烈狩猎本能。

博美犬体型小，食量也小，但却十分的忠诚与机警，你无需花费过多时间照看它，它会很好的融入你的生活，带给你无穷的欢乐。博美犬短小精悍的优良特性赋予了Pomer同样的特征，Pomer宣扬简单、快速、实用的原则，你无需花费过高的学习曲线，就能带来极大的产出。我们对博美犬的热爱铸就了Pomer（音译博美）名称的由来（两位项目成员各养了一只白色的博美犬）。

---
