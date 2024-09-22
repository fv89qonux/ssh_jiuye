## 本项目实现的最终作用是基于SSH求职招聘网站
## 分为3个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 企业个人信息管理
 - 公告管理
 - 就业信息管理
 - 招聘会管理
 - 招聘文档管理
 - 留言管理
 - 管理员登录
### 第2个角色为企业角色，实现了如下功能：
 - 招聘信息管理
 - 查看应聘信息
### 第3个角色为用户角色，实现了如下功能：
 - 投递简历
 - 招聘会推荐
 - 查看信息
 - 查看就业新闻
 - 查看投递的企业
 - 用户首页
 - 面试资料下载
## 数据库设计如下：
# 数据库设计文档

**数据库名：** ssh_jiuye

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [t_admin](#t_admin) | 管理员表 |
| [t_doc](#t_doc) |  |
| [t_gonggao](#t_gonggao) |  |
| [t_liuyan](#t_liuyan) |  |
| [t_news](#t_news) |  |
| [t_stu](#t_stu) |  |
| [t_toudijianli](#t_toudijianli) |  |
| [t_user](#t_user) | 用户表 |
| [t_zhaopin](#t_zhaopin) |  |
| [t_zhaopinhui](#t_zhaopinhui) |  |

**表名：** <a id="t_admin">t_admin</a>

**说明：** 管理员表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | UserId |   int   | 10 |   0    |    N     |  Y   |       | 用户ID  |
|  2   | userName |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户名  |
|  3   | userPw |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 密码  |

**表名：** <a id="t_doc">t_doc</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | ID  |
|  2   | mingcheng |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名称  |
|  3   | fujian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 附件  |
|  4   | fujianYuanshiming |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 附件原名  |
|  5   | del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |

**表名：** <a id="t_gonggao">t_gonggao</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | gonggao_id |   int   | 10 |   0    |    N     |  Y   |       | 公告ID  |
|  2   | gonggao_title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 公告标题  |
|  3   | gonggao_content |   varchar   | 4000 |   0    |    Y     |  N   |   NULL    | 公告内容  |
|  4   | gonggao_data |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 公告日期  |

**表名：** <a id="t_liuyan">t_liuyan</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | liuyan_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | liuyan_title |   varchar   | 66 |   0    |    Y     |  N   |   NULL    |   |
|  3   | liuyan_content |   varchar   | 4000 |   0    |    Y     |  N   |   NULL    |   |
|  4   | liuyan_date |   varchar   | 250 |   0    |    Y     |  N   |   NULL    |   |
|  5   | liuyan_user |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_news">t_news</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | news_id |   int   | 10 |   0    |    N     |  Y   |       |   |
|  2   | news_title |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 新闻标题  |
|  3   | news_content |   text   | 65535 |   0    |    Y     |  N   |   NULL    | 新闻内容  |
|  4   | news_date |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |

**表名：** <a id="t_stu">t_stu</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | stu_id |   int   | 10 |   0    |    N     |  Y   |       | 学生id  |
|  2   | stu_xuehao |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  3   | stu_realname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | stu_sex |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | stu_age |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | login_name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  7   | login_pw |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  8   | del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |

**表名：** <a id="t_toudijianli">t_toudijianli</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | ID  |
|  2   | stuId |   int   | 10 |   0    |    Y     |  N   |   NULL    |   |
|  3   | zhaopinId |   int   | 10 |   0    |    Y     |  N   |   NULL    | 招聘信息ID  |
|  4   | shijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 时间  |
|  5   | fujian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 附件  |
|  6   | fujianYuanshiming |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 附件原名  |
|  7   | del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |

**表名：** <a id="t_user">t_user</a>

**说明：** 用户表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | user_id |   int   | 10 |   0    |    N     |  Y   |       | 用户ID  |
|  2   | user_name |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户名  |
|  3   | user_pw |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户密码  |
|  4   | user_realname |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户真实名字  |
|  5   | user_address |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户地址  |
|  6   | user_tel |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户电话  |
|  7   | user_email |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户邮箱  |
|  8   | user_qq |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 用户QQ  |
|  9   | user_del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |

**表名：** <a id="t_zhaopin">t_zhaopin</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | ID  |
|  2   | zhiwei |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 职位  |
|  3   | xuliyaoqiu |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  4   | daiyui |   varchar   | 4000 |   0    |    Y     |  N   |   NULL    |   |
|  5   | gongzuodidian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  6   | gongzuojingyan |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  7   | youxiaoqi |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  8   | qitashuoming |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  9   | zhaopinType |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  10   | fabushijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  11   | userid |   int   | 10 |   0    |    Y     |  N   |   NULL    | 用户ID  |
|  12   | del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |

**表名：** <a id="t_zhaopinhui">t_zhaopinhui</a>

**说明：** 

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | id |   int   | 10 |   0    |    N     |  Y   |       | ID  |
|  2   | mingcheng |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 名称  |
|  3   | shijian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 时间  |
|  4   | didian |   varchar   | 255 |   0    |    Y     |  N   |   NULL    |   |
|  5   | del |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 是否删除  |

