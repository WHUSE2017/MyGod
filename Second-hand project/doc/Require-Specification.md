# 需求规格说明文档

版本号:v1.0

修订历史：

版本号 | 修改说明 
---- | ----
v1.0 | 将用户需求分析中的用户场景分析剥离，加入界面设计文档，形成初稿


##目录：

- [1.引言](#1-引言)
	- [1.1 编写目的](#11-编写目的)
	- [1.2 项目背景](#12-项目背景)
	- [1.3 预期的读者和阅读建议](#13-预期的读者和阅读建议)
	- [1.4 项目范围](#14-项目范围)
	- [1.5 参考资料](#15-参考资料)
- [2.总体描述](#2用户需求分析)
	- [2.1 目标]()
		- [开发背景](#开发背景)
		- [开发意图](#开发意图)
		- [应用目标和作用范围](#应用目标和作用范围)
		- [产品前景](#产品前景)
	- [2.2 用户场景分析(User Analysis)](#22-用户场景分析user--analysis)
		- [用户场景](#用户场景)
		- [用户需求](#用户的需求)
	- [2.3 运行环境](#23运行环境)
	- [2.4 假定和约束](#24假定和约束)
		- [约束](#约束)
		- [假定](#假定)
- [3.界面原型](#3界面原型)
	- [3.1 概述](#31-概述)
	- [3.2 界面首页](#32-界面首页)
	- [3.3 系统管理](#33-系统管理)
	- [3.4 其他功能界面](#34其他功能界面)
- [4.系统功能描述及验收验证标准](#4系统功能描述及验收验证标准)
	- [4.1 对功能的规定](#41-对功能的规定)
		- [访客浏览功能](#访问浏览功能)  
		- [登录/注册功能](#登录/注册功能)  
                - [用户发布商品功能](#用户发布商品功能)  
                - [商品及订单管理功能](#商品及订单管理功能)  

## 1. 引言

### 1.1 编写目的

此需求规格说明书编制目的是明确本项目的详细需求，供用户确认项目的功能和性能，和用户形成一致的理解和确认，作为进一步详细设计软件的基础。
本文档仅供MyGod团队的项目经理、设计人员、开发人员进行参考。


### 1.2 项目背景

- 项目名称： 基于Android的校园二手市场app
- 项目面向用户：武汉大学全体学生
- 项目开发者：武汉大学软工实践 MyGod 小组

### 1.3 预期的读者和阅读建议

此需求规格说明书针对项目经理、设计人员、开发人员、用户及测试人员。本文分别介绍了产品的远景规划、用户功能及运行环境，系统的功能的具体描述。

### 1.4 项目范围

在武汉大学，每年的毕业生离校季都会有大量的教材和生活用品得不到恰当的处理，造成许多浪费，而新生入学季大批新生不得不购买教材和全新的生活物资，花销比较大。这个物资流动的错档期，造成了极大的损失和浪费，所以需要有一个校园二手交易平台，实现这些二手物资的合理配置，既帮助毕业生减少损失，帮助新生减少花销，有充分挖掘了各类物资的利用价值，减少污染，保护环境。

### 1.5 参考资料
 1. 《Android 基础教程》（第四部），伯内特
 2. 《构建之法》(第二版)，邹欣。
 3. 《GB8567-88 计算机软件需求说明编制指南》

## 2. 总体描述
### 2.1. 目标
#### 开发背景
武汉大学的新生在刚进入学校时，需要购买大量的教材和生活用品，如果全部购买新书的话，会花费很多的钱。而对于高年级的学长学姐来说，他们会有很多的旧书，书架等物品需要处理，如果直接扔掉或者当作废品卖掉的话会很浪费。
#### 开发意图
信息化的时代利用二手市场APP帮助学生们之间进行交易，避免了浪费，利用手机APP让学生们利用手机随时可以进行市场上物品查询，当用户需要进行交易时随时可以交流，随时交易，没有中间的繁杂的步骤，买方和卖方进行交易，不需要第三方。

### 2.2. 用户场景分析(User  Analysis)

下面针对我们的软件主要面向的用户：

* 需要购买学长学姐们曾经用过的教材的新生
* 有自己不需要的旧物品想要出售的学生
* 有想要买二手贵重物品的学生
* 有物品交换意愿的学生

下面我们通过分析典型用户场景得出各位用户的需求：

#### 用户场景：

1.**大一新生小王**

名字 | 小王
:----: | :----
性别 | 男
职业 | 武汉大学大一新生
动机 | 大一刚进校需要购买很多的教材和生活用品，有的教材只用一个学期但是很贵，感觉没有必要买新的，像书架之类的网上的新的也有点贵
目的 | 想少花点钱买到需要的东西
困难 | 像这样的二手书和旧物品的信息较少，找不到
用户偏好 | 能找学长学姐买到对应的教材和实用的东西
用户比例 | 约占同届学生15%
典型场景 | 登陆二手市场APP，根据自己的需要寻找到想要的东西找到卖家购买相应的物件
典型描述 | 好难找到这些老师说的教材啊！

2.**大四学生小张**

名字 | 小张
:----: | :----
性别 | 女
职业 | 武汉大学大四学生
动机 | 好多没用的东西扔掉了好可惜，买的时候花了不少钱
目的 | 想要将没用的东西处理掉，还可以换点钱，便宜点给自己的学弟学妹是最好的
困难 | 找不到方便的对应平台帮助自己放出自己想要出售的物件
用户偏好 | 方便最好
用户比例 | 约占同届学生30%
典型场景 | 登陆二手市场APP，放上自己想卖的东西，让其他想要买二手物件的人看到信息
典型描述 | 好多东西想要卖出去啊，还可以换几顿饭的钱。



3.**大二学生小何**

名字 | 小何
:----: | :----
性别 | 男
职业 | 武汉大学大二学生
动机 | 校园很大，去上课路程较远，想买一辆二手电动车
目的 | 方便出行
困难 | 不知道去哪里寻找到这一类的二手信息
用户偏好 | 物美价廉
用户比例 | 约占同届学生5%
典型场景 | 登陆二手市场APP，查找有没有自己想要的东西，也可以将自己想买的东西写在上面 
典型描述 | 花更少的钱买到自己想要的东西


4.**研一学生小宇**

名字 | 小宇
:----: | :----
性别 | 男
职业 | 武汉大学研一学生
动机 | 有一双轮滑鞋，想和同学换一个滑板
目的 | 用一种省钱的方式体验两种运动
困难 | 不知道谁有与自己恰好有配对的需求
用户偏好 | 简单便捷，节约时间
用户比例 | 约占同届学生8%
典型场景 | 登陆二手市场APP，查找有没有自己想交换的东西，也可以将自己准备交换的东西写在上面
典型描述 | 以物换物


#### 用户的需求

1. 小王：希望能够用较少的钱买到自己想要的东西。

2. 小张：希望能够将自己以后用不上或者不想要的东西卖出去。

3. 小何：希望有人能够看到我想要买的东西，如果他们恰好想卖出去，可以联系我

4. 小宇：希望通过以物换物，既节省开支，又体验生活


### 2.3 运行环境

![Android](https://raw.githubusercontent.com/WHUSE2017/MyGod/master/Second-hand%20project/doc/AndroidPic/android_logo.png)

主要支持Android系统（android 5.0及以上）

根据google9月份发布的android各版本的市场份额统计：

![](https://raw.githubusercontent.com/WHUSE2017/MyGod/master/Second-hand%20project/doc/AndroidPic/android_table.png)

Android5.0及以上覆盖超过70%的用户，故本次项目拟定支持Android5.0及以上的版本。

### 2.4 假定和约束

#### 假定

- 可操作性：假设使用该APP的用户在经过一段时间的熟悉之后，可以流畅的操作APP来满足自己的需要。  
- 用户支持：假设在该APP在开发的各个环节中得到用户的有效支持和配合。  
- 技术支持：假设开发初期，小组成员充分认识该APP的需求，认真学习好相关知识。开发过程中遇到技术问题，可以及时得到其他同学或者老师的指导与帮助。  
- 人员配合：假设小组主要成员基本不会出现变动，并且在项目的开发过程中不会因为突发情况的发生而导致项目成员无法正常参与开发工作。  
- 时间限定：假设项目的截止时间不会提前。  
- 需求限定：假设项目需求基本确定之后，不会有太大改变。  


#### 约束

**人员约束**：

团队成员均为研一学生，共5人。

**管理约束**：  

1. 本次开发，实行分工合作的模式进行。团队由一人担任项目经理，其他成员协同其共同完成开发。团队开发过程中按照进度表进行，开发过程中遇到的问题通过小组会议得到一致的解决。  

2. 小组成员首次合作，需要一个磨合的过程，需要明确自身责任，分清各自任务，相互配合，遇到问题项目经理必须能够有效进行协调，才能快速、有效的完成开发过程。 
 
**技术约束**：  

大部分小组成员在相关技术水平方面存在一定欠缺，缺乏相关项目经验，处理问题的能力有待提升。

**时间约束**：  

该APP开发时间较短，时间相对紧张。

**其他约束**：  

开发期间，同学们都还有其他课程及任务需要完成，会对项目造成影响。


## 3. 界面原型
### 3.1概述


经团队初步讨论，最终确定校园二手交易APP界面原型设计如下


**界面框架:**

![界面框架](https://raw.githubusercontent.com/WHUSE2017/MyGod/master/Second-hand%20project/doc/PagePic/1.0_frame.png)

### 3.2 界面首页


![首页](https://raw.githubusercontent.com/WHUSE2017/MyGod/master/Second-hand%20project/doc/PagePic/1.0_index_page.png)

上图为我们所设计的首页预览版原型图，涉及到的按钮与功能有：

1.访客浏览：即用户在未登录情况下，无商品发布、订单管理等权限，但可以进行商品浏览

2.首页根据用户发布商品的时间推荐最新的商品

3.点击”我的”按钮：进入用户信息界面，用户可进行登录/注册以及订单管理等

4.点击”分类”按钮：查看商品、加入购物车并提交订单

5.点击”购物车”按钮：进入购物车界面，查看已选择的商品，也可对商品数量进行管理

6.点击”晒二手”图标：用户发布商品

7.根据用户浏览与搜索记录推荐相似商品

8.根据用户点击量推荐热度较高的商品

9.用户发布留言

10.待定


> 注:功能789是后期功能，将放在beta版本中进行开发


### 3.3 系统管理
![购物车界面](https://raw.githubusercontent.com/WHUSE2017/MyGod/master/Second-hand%20project/doc/PagePic/1.0_cart_page.png)

购物车管理界面如上图：

1.界面显示用户已经加入购物车的商品列表，用户可以对商品进行编辑，例如增加数量或减少数量；

2.商品列表下方为商品推荐，该部分根据用户浏览记录及搜索记录进行智能推荐



![订单界面](https://raw.githubusercontent.com/WHUSE2017/MyGod/master/Second-hand%20project/doc/PagePic/1.0_bill_page.png)

订单管理界面如上图：

1.订单界面实现用户订单管理功能，用户可增加/删除现有订单；

2.订单详细信息显示卖家联系方式、交易时间、地点等，以便用户与卖家联系



![个人信息界面](https://raw.githubusercontent.com/WHUSE2017/MyGod/master/Second-hand%20project/doc/PagePic/1.0_person_page.png)

个人信息界面功能：

1.用户在该页面选择登录，或新用户进行注册，登录界面实现用户登录与注册，未登录的用户无权限发布和购入商品

2.点击”我的订单”：用户可查看自己的订单

3.点击"我卖出的"：用户查看已卖出商品

4.点击"我关注的"：用户查看自己关注的商品


### 3.4 其他功能界面

![商品分类界面](https://raw.githubusercontent.com/WHUSE2017/MyGod/master/Second-hand%20project/doc/PagePic/1.0_category_page.png)

商品分类界面功能：

在分类界面，左侧为不同类别商品菜单栏，用户点击后在界面右侧可以查看不同类型商品


![商品详情界面](https://raw.githubusercontent.com/WHUSE2017/MyGod/master/Second-hand%20project/doc/PagePic/1.0_detail_page.png)

商品详情界面功能：

在商品详情界面，用户可查看发布该商品的卖家信息，以及商品详细信息，并能通过右下角按钮将该商品加入购物车；也可选择先关注该商品，随后可在个人信息界面通过点击”我的关注”查看关注商品，以便加入购物车

![商品搜索界面](https://raw.githubusercontent.com/WHUSE2017/MyGod/master/Second-hand%20project/doc/PagePic/1.0_search_page.png)

商品搜索界面功能：

1.用户在主页点击搜索后，出现左图界面，包括历史搜索记录和根据用户浏览/历史搜索提供的商品推荐；

2.用户选择某标签或自己输入关键字后跳转到右图商品列表界面，界面顶部为菜单栏，用户可依据不同标准筛选商品：

  区域————用户可选择查看校园不同区域的商品，例如文理学部、信息学部、工学部和医学部；

  价格————用户可根据价格从高到低或从低到高对商品进行排序；

  排序————用户根据新品优先或点击量优先，对商品进行排序

3.用户选择具体商品后跳转至商品详情界面


![商品发布界面](https://raw.githubusercontent.com/WHUSE2017/MyGod/master/Second-hand%20project/doc/PagePic/1.0_push_page.png)

![商品交换界面](https://raw.githubusercontent.com/WHUSE2017/MyGod/master/Second-hand%20project/doc/PagePic/1.0_exchange_page.png)

商品发布界面功能：

用户根据提示提供发布商品时所需信息

1.标题：用户需输入商品名称/标题

2.分类：用户可选择该商品所属分类，以便其他用户查看该分类

3.联系方式：用户必须输入自己的联系方式，提供买家与自己的沟通途径

4.照片：用户选择拍照上传商品图片；

5.用户可以选择卖出商品，或用该商品与其他商品进行交换：

若点击卖出商品按钮，则需填写价格和交易地点等信息；若点击交换按钮，则跳转到商品交换页面，浏览有交换需求的商品


## 4. 系统功能描述及验收验证标准


### 4.1 对功能的规定

#### 1.访客浏览功能

<table border="0">
  <tr>
    <td>测试功能</td>
    <td>测试项</td>
    <td>输入/操作</td>
    <td>检验点</td>
    <td>测试功能</td>
    <td>完成情况</td>
  </tr>
  <tr>
    <th rowspan="23">访客浏览功能 </th>
    <th rowspan="11">首页</th>
    <th rowspan="6"> </th>
    <td>“首页”按钮颜色</td>
    <td>白底红字</td>
    <td></td>
  </tr>
  <tr>
    <td>搜索框</td>
    <td>可以点击</td>
    <td></td>
  </tr>  
  <tr>
    <td>“二手交换”图标</td>
    <td>可以点击</td>
    <td></td>
  </tr>
  <tr>
    <td>“晒二手”图标</td>
    <td>可以点击</td>
    <td></td>
  </tr>  
  <tr>
    <td>“留言板”图标</td>
    <td>可以点击</td>
    <td></td>
  </tr>
  <tr>
    <td>商品图片</td>
    <td>可以点击</td>
    <td></td>
  </tr>
  <tr>		
    <td>点击搜索框</td>
    <td>确认功能、结果显示</td>
    <td>进入搜索页面而且可以输入信息</td>
    <td></td>
  </tr>
    <tr>
    <td>点击“二手交换”图标</td>
    <td>确认功能、结果显示</td>
    <td>进入商品交换页面</td>
    <td></td>
  </tr>    
  <tr>
    <td>点击“晒二手”图标</td>
    <td>确认功能、结果显示</td>
    <td>进入商品发布页面</td>
    <td></td>
  </tr>  
  <tr>
    <td>点击“留言板”图标</td>
    <td>确认功能、结果显示</td>
    <td>进入留言板页面</td>
    <td></td>
  </tr>
  <tr>
    <td>点击首页商品图片</td>
    <td>确认功能、结果显示</td>
    <td>进入商品详情页面</td>
    <td></td>
  </tr>  
  <tr>
    <th rowspan="7">搜索页面</th>
    <td></td>
    <td>“搜索”按钮</td>
    <td>可以点击</td>
  </tr>  
  <tr>	
    <td></td>
    <td>历史搜索标签</td>
    <td>可以点击</td>
  </tr>  
  <tr>	
    <td></td>
    <td>推荐标签</td>
    <td>可以点击</td>
  </tr>
  </tr>  
  <tr>	
    <td>不在搜索框中输入信息并点击搜索按钮</td>
    <td>确认功能、结果显示</td>
    <td>无法显示商品</td>
  </tr>
  </tr>  
  <tr>	
    <td>在搜索框中输入信息并点击搜索按钮</td>
    <td>确认功能、结果显示</td>
    <td>显示对应商品信息</td>
  </tr>
  </tr>  
  <tr>	
    <td>点击历史搜索标签</td>
    <td>确认功能、结果显示</td>
    <td>显示对应商品信息</td>
  </tr>
  </tr>  
  <tr>	
    <td>点击推荐标签</td>
    <td>确认功能、结果显示</td>
    <td>显示对应商品信息</td>
  </tr>
  <tr>		
    <th rowspan="5">分类页</th>
    <th rowspan="3"></th>
    <td>“分类”按钮颜色</td>
    <td>白底红字”</td>
  </tr>
  <tr>			
    <td>“推荐分类”按钮</td>
    <td>可以点击</td>
  </tr>  
  <tr>			
    <td>各个分类按钮</td>
    <td>可以点击</td>
  </tr>  
  <tr>			
    <td>点击“推荐分类”按钮</td>
    <td>确认功能、结果显示</td>
    <td>显示商品推荐分类</td>
  </tr>  
  <tr>			
    <td>点击各个分类按钮</td>
    <td>确认功能、结果显示</td>
    <td>显示对应商品信息</td>
</table>

#### 2.	用户登录/注册功能
<table border="0">
 <tr>
    <td>测试功能</td>
    <td>测试项</td>
    <td>输入/操作</td>
    <td>检验点</td>
    <td>测试功能</td>
    <td>完成情况</td>
  </tr> 
  <tr>
    <th rowspan="22">用户登录/注册</th>
    <th rowspan="4">个人信息页面</th>
    <th rowspan="2"> </th>
    <td>“我的”按钮颜色</td>
    <td>白底红字</td>
    <td></td>
  </tr>  
  <tr>
    <td>登录/注册按钮</td>
    <td>可以点击</td>
    <td> </td>
  </tr> 
  <tr>
    <td>点击“登录”按钮</td>
    <td>确认功能、结果显示</td>
    <td>进入登录页面</td>
  </tr>
  <tr>
    <td>点击“注册”按钮</td>
    <td>确认功能、结果显示</td>
    <td>进入注册页面</td>
  </tr>
  <tr>
    <th rowspan="9">登录页面</th>
    <th rowspan="3"></th>
    <td>学号框（限13位数字）</td>
    <td>显示“学号”</td>
  </tr>
  <tr>		
    <td>密码框（限6-15位输入）</td>
    <td>显示“密码”</td>
  </tr>  
  <tr>		
    <td>“登录”按钮</td>
    <td>可以点击</td>
  </tr>  
  <tr>		
    <td>不输入信息，点击“登录”</td>
    <td>确认功能、结果显示</td>
    <td>无法登录，警告提示“请输入学号和密码”</td>
    <td> </td>
  </tr>
  <tr>		
    <td>仅输入学号或密码（输入格式正确）</td>
    <td>确认功能、结果显示</td>
    <td>无法登录，警告提示“请输入学号和密码”</td>
    <td> </td>
  </tr>  
  <tr>		
    <td>输入学号和密码，两者之中，其一正确，其一错误</td>
    <td>确认功能、结果显示</td>
    <td>无法登录，警告提示“请输入学号和密码”</td>
    <td> </td>
  </tr>  
  <tr>		
    <td>学号或密码格式错误</td>
    <td>确认功能、结果显示</td>
    <td>无法登录，警告提示“学号或密码格式错误”</td>
    <td> </td>
  </tr> 
  <tr>
    <td>输入正确的学号和密码</td>
    <td>确认功能、结果显示</td>
    <td>登录成功，进入个人信息页面</td>
    <td> </td>
  </tr>
  <tr>
    <td>输入正确的学号和密码</td>
    <td>确认功能、结果显示</td>
    <td>登录成功，进入个人信息页面</td>
    <td> </td>
  </tr>
  <tr>
    <th rowspan="9">注册页面</th>
    <th rowspan="4"></th>
    <td>学号框（限13位数字）</td>
    <td>显示“学号”</td>
  </tr>
  <tr>
    <td>密码框1（限6-15位输入）</td>
    <td>显示“密码”</td>
  </tr> 
  <tr>
    <td>密码框2（限6-15位输入）</td>
    <td>显示“再输入一次密码”</td>
  </tr> 
  <tr>
    <td>“注册”按钮</td>
    <td>可以点击</td>
  </tr> 
  <tr>
    <td>不输入信息，点击“注册”</td>
    <td>确认功能、结果显示</td>
    <td>无法注册，警告提示“请输入学号和密码”</td>
    <td> </td>
  </tr>
  <tr>
    <td>仅输入学号或密码（输入格式正确）</td>
    <td>确认功能、结果显示</td>
    <td>无法注册，警告提示“请输入学号和密码”</td>
    <td> </td>
  </tr>
  <tr>
    <td>学号或密码格式错误</td>
    <td>确认功能、结果显示</td>
    <td>无法注册，警告提示“学号或密码格式错误”</td>
    <td> </td>
  </tr>
  <tr>
    <td>两次输入密码不一致</td>
    <td>确认功能、结果显示</td>
    <td>无法注册，警告提示“两次输入密码不一致”</td>
    <td> </td>
  </tr>
  <tr>
    <td>输入格式正确的学号和密码，并且两次密码输入一致</td>
    <td>确认功能、结果显示</td>
    <td>注册成功，进入个人信息页面</td>
    <td> </td>
  </tr>
</table>

#### 3.查看商品、加入购物车并提交订单功能
<table>
<tr>
  <td>测试功能</td>
  <td>测试项</td>
  <td>输入/操作</td>
  <td>检验点</td>
  <td>测试功能</td>
  <td>完成情况</td>
 </tr>
 <tr>
  <th rowspan="18">查看商品、加入购物车并提交订单</th>
  <th rowspan="7">商品详情页面 </th>
  <td></td>
  <td>文字描述、交易地点、交易时间</td>
  <td>白底黑字</td>
  <td></td>
 </tr>
 <tr>
  <td> </td>
  <td>“关注”按钮 </td>
  <td>未点击之前为白色，可以点击</td>
  <td> 
  </td>
 </tr>
 <tr>
  <td> 
  </td>
  <td>“购物车”按钮 
  </td>
  <td>可以点击 
  </td>
  <td> 
  </td>
 </tr>
 <tr>
  <td> 
  </td>
  <td>“加入购物车”按钮 
  </td>
  <td>可以点击 
  </td>
  <td> 
  </td>
 </tr>
 <tr>
  <td>点击“关注”按钮 
  </td>
  <td>确认功能、结果显示 
  </td>
  <td>如果已经登录，“关注”按钮变为红色，如果没有登录，进入登录页面 
  </td>
  <td> 
  </td>
 </tr>
 <tr>
  <td>点击“购物车”按钮 
  </td>
  <td>确认功能、结果显示 
  </td>
  <td>如果已经登录，进入购物车页面，如果没有登录，进入登录页面 
  </td>
  <td> 
  </td>
 </tr>
 <tr>
  <td>点击“加入购物车”按钮 
  </td>
  <td>确认功能、结果显示 
  </td>
  <td>如果已经登录，进入购物车页面，如果没有登录，进入登录页面 
  </td>
  <td> 
  </td>
 </tr>
 <tr>
  <th rowspan="8">购物车页面 
  </th>
  <td> 
  </td>
  <td>“购物车”按钮颜色 
  </td>
  <td>白底红字 
  </td>
  <td>
  </td>
 </tr>
 <tr>
  <td> 
  </td>
  <td>“编辑”按钮 
  <td>可以点击 
  </td>
  </td>
 </tr>
 <tr>
  <td>“+”按钮 
  </td>
  <td>可以点击 
  </td>
 </tr>
 <tr>
  <td> 
  </td>
  <td>“-”按钮 
  </td>
  <td>可以点击 
  </td>
  <td> 
  </td>
 </tr>
 <tr>
  <td> 
  </td>
  <td>“提交”按钮 
  </td>
  <td>红底白字，可以点击 
  </td>
  <td> 
  </td>
 </tr>
 <tr>
  <td> 
  </td>
  <td>商品信息条目 
  </td>
  <td>交易时间和地点在商品信息条目最上面，商品图片在左侧，商品名称和价格在右侧，商品数量在商品条目信息的右下角，由“-”文本框“+”组成 
  </td>
  <td> 
  </td>
 </tr>
 <tr>
  <td>点击商品图片 
  </td>
  <td>确认功能、结果显示 
  </td>
  <td>进入商品详情页面 
  </td>
  <td> 
  </td>
 </tr>
 <tr>
  <td>点击“提交”按钮 
  </td>
  <td>确认功能、结果显示 
  </td>
  <td>进入订单页面 
  </td>
  <td> 
  </td>
 </tr>
 <tr>
  <th rowspan="3" >订单页面 
  </th>
  <td> 
  </td>
  <td>卖家联系方式、交易地点、交易时间 
  </td>
  <td>白底黑字 
  </td>
  <td> 
  </td>
 </tr>
 <tr>
  <td> 
  </td>
  <td>“删除订单”按钮 
  </td>
  <td>可以点击 
  </td>
  <td> 
  </td>
 </tr>
 <tr>
  <td>点击“删除订单”按钮 
  </td>
  <td>确认功能、结果显示 
  </td>
  <td>刷新页面，删除订单信息 
  </td>
  <td> 
  </td>
 </tr>
</table>

#### 4.用户发布商品功能

<table class=MsoTableGrid border=1 cellspacing=0 cellpadding=0
 style='margin-left:18.0pt;border-collapse:collapse;border:none;mso-border-alt:
 solid windowtext .5pt;mso-yfti-tbllook:1184;mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>
 <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
  <td width=30 style='width:22.85pt;border:solid windowtext 1.0pt;mso-border-alt:
  solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph align=center style='text-align:center;text-indent:
  0cm;mso-char-indent-count:0'><span style='font-family:宋体;mso-ascii-font-family:
  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;
  mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
  mso-hansi-theme-font:minor-latin'>测试功能</span><span lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=40 style='width:30.25pt;border:solid windowtext 1.0pt;border-left:
  none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph align=center style='text-align:center;text-indent:
  0cm;mso-char-indent-count:0'><span style='font-family:宋体;mso-ascii-font-family:
  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;
  mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
  mso-hansi-theme-font:minor-latin'>测试项</span><span lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=207 style='width:155.4pt;border:solid windowtext 1.0pt;border-left:
  none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph align=center style='text-align:center;text-indent:
  0cm;mso-char-indent-count:0'><span style='font-family:宋体;mso-ascii-font-family:
  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;
  mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
  mso-hansi-theme-font:minor-latin'>输入</span><span lang=EN-US>/</span><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>操作</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=89 style='width:66.75pt;border:solid windowtext 1.0pt;border-left:
  none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph align=center style='text-align:center;text-indent:
  0cm;mso-char-indent-count:0'><span style='font-family:宋体;mso-ascii-font-family:
  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;
  mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
  mso-hansi-theme-font:minor-latin'>检验点</span><span lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 style='width:74.95pt;border:solid windowtext 1.0pt;border-left:
  none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph align=center style='text-align:center;text-indent:
  0cm;mso-char-indent-count:0'><span style='font-family:宋体;mso-ascii-font-family:
  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;
  mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
  mso-hansi-theme-font:minor-latin'>测试功能</span><span lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 style='width:57.9pt;border:solid windowtext 1.0pt;border-left:
  none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph align=center style='text-align:center;text-indent:
  0cm;mso-char-indent-count:0'><span style='font-family:宋体;mso-ascii-font-family:
  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;
  mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
  mso-hansi-theme-font:minor-latin'>完成情况</span><span lang=EN-US><o:p></o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:1'>
  <td width=30 rowspan=14 style='width:22.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph align=center style='text-align:center;text-indent:
  0cm;mso-char-indent-count:0'><span style='font-family:宋体;mso-ascii-font-family:
  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;
  mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
  mso-hansi-theme-font:minor-latin'>用户发布商品</span><span lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=40 rowspan=14 style='width:30.25pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph align=center style='text-align:center;text-indent:
  0cm;mso-char-indent-count:0'><span style='font-family:宋体;mso-ascii-font-family:
  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;
  mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
  mso-hansi-theme-font:minor-latin'>商品发布页面</span><span lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>标题框（限</span><span
  lang=EN-US>3-10</span><span style='font-family:宋体;mso-ascii-font-family:Calibri;
  mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:
  minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>个汉字）</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>显示“标题”</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:2'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>分类框（下拉框）</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>显示“分类”，可以点击</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:3'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>联系方式框（限</span><span
  lang=EN-US>11</span><span style='font-family:宋体;mso-ascii-font-family:Calibri;
  mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:
  minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>位数字）</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>显示联系方式</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:4'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>“加入购物车”按钮</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>可以点击</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:5'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>“拍照上传”按钮</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>可以点击</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:6'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>“卖掉”按钮</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>可以点击</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:7'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>“交换”按钮</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>可以点击</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:8'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>“提交”按钮</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>红底白字，可以点击</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:9'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>点击“分类”按钮</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>确认功能、结果显示</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>显示商品类别，可以点击选择</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:10'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>不输入信息，点击“提交”按钮</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>确认功能、结果显示</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>无法提交，警告提示“请输入完整信息”</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:11'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>信息输入不完整，点击“提交”按钮</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>确认功能、结果显示</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>无法提交，警告提示“请输入完整信息”</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:12'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>标题格式不正确，点击“提交”按钮</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>确认功能、结果显示</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>无法提交，警告提示“标题请输入</span><span
  lang=EN-US>3-10</span><span style='font-family:宋体;mso-ascii-font-family:Calibri;
  mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:
  minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>个汉字”</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:13'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>联系方式格式不正确，点击“提交”按钮</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>确认功能、结果显示</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>无法提交，警告提示“请输入</span><span
  lang=EN-US>11</span><span style='font-family:宋体;mso-ascii-font-family:Calibri;
  mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:
  minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>位手机号”</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:14;mso-yfti-lastrow:yes'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>输入信息正确，点击“提交按钮”</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>确认功能、结果显示</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>如果已经登录，提交成功，进入首页，如果没有登录，进入登录页面</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
</table>

#### 5.商品及订单管理功能

<table class=MsoTableGrid border=1 cellspacing=0 cellpadding=0
 style='margin-left:18.0pt;border-collapse:collapse;border:none;mso-border-alt:
 solid windowtext .5pt;mso-yfti-tbllook:1184;mso-padding-alt:0cm 5.4pt 0cm 5.4pt'>
 <tr style='mso-yfti-irow:0;mso-yfti-firstrow:yes'>
  <td width=30 style='width:22.85pt;border:solid windowtext 1.0pt;mso-border-alt:
  solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph align=center style='text-align:center;text-indent:
  0cm;mso-char-indent-count:0'><span style='font-family:宋体;mso-ascii-font-family:
  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;
  mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
  mso-hansi-theme-font:minor-latin'>测试功能</span><span lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=40 style='width:30.25pt;border:solid windowtext 1.0pt;border-left:
  none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph align=center style='text-align:center;text-indent:
  0cm;mso-char-indent-count:0'><span style='font-family:宋体;mso-ascii-font-family:
  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;
  mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
  mso-hansi-theme-font:minor-latin'>测试项</span><span lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=207 style='width:155.4pt;border:solid windowtext 1.0pt;border-left:
  none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph align=center style='text-align:center;text-indent:
  0cm;mso-char-indent-count:0'><span style='font-family:宋体;mso-ascii-font-family:
  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;
  mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
  mso-hansi-theme-font:minor-latin'>输入</span><span lang=EN-US>/</span><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>操作</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=89 style='width:66.75pt;border:solid windowtext 1.0pt;border-left:
  none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph align=center style='text-align:center;text-indent:
  0cm;mso-char-indent-count:0'><span style='font-family:宋体;mso-ascii-font-family:
  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;
  mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
  mso-hansi-theme-font:minor-latin'>检验点</span><span lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 style='width:74.95pt;border:solid windowtext 1.0pt;border-left:
  none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph align=center style='text-align:center;text-indent:
  0cm;mso-char-indent-count:0'><span style='font-family:宋体;mso-ascii-font-family:
  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;
  mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
  mso-hansi-theme-font:minor-latin'>测试功能</span><span lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 style='width:57.9pt;border:solid windowtext 1.0pt;border-left:
  none;mso-border-left-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph align=center style='text-align:center;text-indent:
  0cm;mso-char-indent-count:0'><span style='font-family:宋体;mso-ascii-font-family:
  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;
  mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
  mso-hansi-theme-font:minor-latin'>完成情况</span><span lang=EN-US><o:p></o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:1'>
  <td width=30 rowspan=12 style='width:22.85pt;border:solid windowtext 1.0pt;
  border-top:none;mso-border-top-alt:solid windowtext .5pt;mso-border-alt:solid windowtext .5pt;
  padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph align=center style='text-align:center;text-indent:
  0cm;mso-char-indent-count:0'><span style='font-family:宋体;mso-ascii-font-family:
  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;
  mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
  mso-hansi-theme-font:minor-latin'>商品及订单管理</span><span lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=40 rowspan=9 style='width:30.25pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph align=center style='text-align:center;text-indent:
  0cm;mso-char-indent-count:0'><span style='font-family:宋体;mso-ascii-font-family:
  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;
  mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
  mso-hansi-theme-font:minor-latin'>个人信息页面</span><span lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>“我的”按钮颜色</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>白底红字</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:2'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>“我的订单”图标</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>可以点击</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:3'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>“我的关注”图标</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>可以点击</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:4'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>“我卖出的”图标</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>可以点击</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:5'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>“浏览记录”按钮</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>白底红字而且可以点击</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:6'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>商品图片</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>可以点击</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:7'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>点击“我的订单”图标</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>确认功能、结果显示</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>如果已经登录，进入订单页面，如果没有登录，进入登录页面</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:8'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>点击“我的关注”图标</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>确认功能、结果显示</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>如果已经登录，显示我关注的商品，如果没有登录，进入登录页面</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:9'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>点击“我卖出的”图标</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>确认功能、结果显示</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>如果已经登录，显示我卖出的商品，如果没有登录，进入登录页面</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:10'>
  <td width=40 rowspan=3 style='width:30.25pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph align=center style='text-align:center;text-indent:
  0cm;mso-char-indent-count:0'><span style='font-family:宋体;mso-ascii-font-family:
  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;
  mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;
  mso-hansi-theme-font:minor-latin'>订单页面</span><span lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>卖家联系方式、交易地点、交易时间</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>白底黑字</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:11'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>“删除订单”按钮</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>可以点击</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
 <tr style='mso-yfti-irow:12;mso-yfti-lastrow:yes'>
  <td width=207 valign=top style='width:155.4pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>点击“删除订单”按钮</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=89 valign=top style='width:66.75pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>确认功能、结果显示</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=100 valign=top style='width:74.95pt;border-top:none;border-left:
  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  style='font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:
  minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;
  mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin'>刷新页面，删除订单信息</span><span
  lang=EN-US><o:p></o:p></span></p>
  </td>
  <td width=77 valign=top style='width:57.9pt;border-top:none;border-left:none;
  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;
  mso-border-top-alt:solid windowtext .5pt;mso-border-left-alt:solid windowtext .5pt;
  mso-border-alt:solid windowtext .5pt;padding:0cm 5.4pt 0cm 5.4pt'>
  <p class=MsoListParagraph style='text-indent:0cm;mso-char-indent-count:0'><span
  lang=EN-US><o:p>&nbsp;</o:p></span></p>
  </td>
 </tr>
</table>


