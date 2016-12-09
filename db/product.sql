-- 产品实体，产品的属性表

-- 创建产品表
/*
  ID                  id
  全名                	fullName
  标题名(检索或分类用)  	titleName
  价格(原价)                	price
  促销价格              promotionPrice
  促销方式            	promotion.id
  简介                	introduction
  封面图片             coverPic
  封面大图（鼠标停留后）coverPicBig
  详细描述(url)          description
  是否上下架             putaway(0|1)
  起售日期               sellDate
  下架日期                soldOutDate
  特惠开始日期            preferentialStartDate
  特惠结束日期            preferentialEndDate

*/

CREATE TABLE 'product'(
  'id' int(10) unsigned NOT NULL auto_increment PRIMARY KEY,
  'fullName' VARCHAR(50) NOT NULL comment '全名',
  'titleName' VARCHAR(30) NOT NULL comment '标题名',
  'price' DECIMAL comment '价格(原价)',
  'promotionPrice' DECIMAL comment '促销价格',
  'promotionPriceId' INT(10) NOT NULL comment '促销方式，连接促销方式表id',
  'introduction' VARCHAR() comment '简介',
  'coverPic' VARCHAR() comment '封面图片url',
  'coverPicBig' VARCHAR() comment '封面图片大图（鼠标停留后展示）',
  'description' VARCHAR() comment '详细描述url',
  'putaway' BIT(1) DEFAULT 1 comment '是否上下架(0|1)默认下架',
  'sellDate' datetime comment '起售时间',
  'soldOutDate' datetime comment '下架时间',
  'preferentialStartDate' datetime comment '特惠开始日期',
  'preferentialEndDate' datetime comment '特惠结束日期',

) DEFAULT charset=utf8;
