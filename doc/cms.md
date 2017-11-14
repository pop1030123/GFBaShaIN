###芭莎android APP相关接口列表


#####1.首页的文章详情信息
http://bz.metshow.com/api/article/detail
<br>
方式：GET
<br>
请求参数 ：
```json
{
	"articleid": 30280
}
```
<br>
返回值：<br>
```json
{
	"code": 0,
	"isSuc": true,
	"message": "OK",
	"name": null,
	"nextpublishtime": null,
	"result": {
		"AdminId": 30040,
		"ArticleId": 30280,
		"ArticlePicturesStr": "[]",
		"ArticleType": 1,
		"Author": "时尚芭莎",
		"AuthorIco": "http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/30040\/20170712\/2433268D9EF97446E25EBA288472F190_md5_201707121435124995-400_400.jpg",
		"ChannelId": 3,
		"ChannelParentId": 0,
		"CommentCount4Extent": 0,
		"CommentListStr": "[]",
		"Content": " <meta http-equiv=Content-Type content=\"text\/html;charset=utf-8\"><meta name=\"viewport\" content=\"width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no\"><style> body{font-size:medium; margin-left: 20px; margin-right: 20px;color:#333333;font-family:Helvetica,FZLTXHJW--GB1-0,HYXiJianHeiJ;text-align:justify;text-justify:inter-ideograph;background-color: #ffffff;}img{width:100%;}p{line-height:24px;} #vote_sumbit{-webkit-appearance: none;}<\/style><script src='http:\/\/7xk8x7.com1.z0.glb.clouddn.com\/jquery-1.11.0.min.js'><\/script>\u000d\u000a          <script src='http:\/\/7xk8x7.com1.z0.glb.clouddn.com\/jquery.lazyload2.js'><\/script>\u000d\u000a          <script src='http:\/\/bz.metshow.com\/api\/js\/tmpl.js'><\/script>\u000d\u000a          <script src='http:\/\/bz.metshow.com\/api\/js\/detail2\/vote4app.js'><\/script>\u000d\u000a          <script src='http:\/\/bz.metshow.com\/api\/js\/detail2\/iosadapter.js?v=\"margin-left: 21px; margin-right: 21px; text-indent: 0px;\"'><\/script><script type=\"text\/html\" id=\"vote-tmpl\"><ul style=\"list-style-type: none;width: 95%;padding: 0;margin: 0 auto;\"><#var count=0;#>     <#for(var i=0;i<result.length;i++){#>         <#count=count+result[i].VoteCount;#>       <#}#><#for(var i=0;i<result.length;i++){#>  \u0009    <li style=\"width: 100%;background: #363B42;color: #fff;height: 2em;position: relative;margin-bottom: 1em;\">\u0009\u0009    <p style=\"position: absolute;left: 0;top: 0;height: 100%;background: #E94A54;width: <#=parseInt(result[i].VoteCount\/count*100)#>%;margin: 0;z-index: 0;\"><\/p>\u0009\u0009    <div style=\"position: absolute;width: 100%;height: 100%;left: 0;top: 0;\">\u0009\u0009\u0009    <p style=\"float: left;margin: 0;margin-left: 1em;line-height: 2em;\"><#=result[i].Title#><\/p>\u0009\u0009\u0009    <p style=\"float: right;margin: 0;margin-right: 1em;line-height: 2em;\"><#=parseInt(result[i].VoteCount\/count*100)#>%<\/p>\u0009\u0009    <\/div>\u0009    <\/li><#}#><\/ul><\/script><div class=\"metshowA\" style=\"padding-top:0px; padding-bottom:0px; padding-left:0px; padding-right:0px;\"><p>袁泉的齐刘海短发实在太深入人心了，甚至一度觉得短发更有女人味！没想到，这次出席活动的她又剪短了！短上加短，还真挺好看~<br\/><\/p><p><img style=\"background:url('http:\/\/bz.metshow.com\/api\/bzlogo2x.png') 50% 50% no-repeat;\" data-original=\"http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/F8753358357D437036C1338A0ACF7B8E_md5_201711140116230026-720_975.jpeg\" \/><\/p><p>袁泉新款短发再次让人惊艳了！刘海和鬓角部分结合，侧边头发轻別耳后，后边头发剪短了不少，整体气质更脱俗清新，充分诠释了“美酷”这两个字！<\/p><p><img style=\"background:url('http:\/\/bz.metshow.com\/api\/bzlogo2x.png') 50% 50% no-repeat;\" data-original=\"http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/C18A7AA567D4D28A38EA6FC5DBF7844A_md5_201711140116345331-720_963.jpeg\" \/><\/p><p>正面照气场爆棚~ 刘海做了很自然的凌乱纹理，温暖的发色光泽度满分！不得不承认袁泉才是行走的短发教科书，越短越美丽！<\/p><p><img style=\"background:url('http:\/\/bz.metshow.com\/api\/bzlogo2x.png') 50% 50% no-repeat;\" data-original=\"http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/33EF355F8CE15D0C0DB1104065758E1E_md5_201711140116440276-690_1037.jpeg\" \/><\/p><p>对比之前的Bob款短发，是不是觉得现在的露耳短发更利落有气质呢？当然都很美啦，本芭更喜欢袁泉新剪的短发，因为更能凸显她无比精致立体的五官，气质和气场都＋10086！<\/p><p><img style=\"background:url('http:\/\/bz.metshow.com\/api\/bzlogo2x.png') 50% 50% no-repeat;\" data-original=\"http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/02C8FCE0358FF08D4F80A33C5CE2677F_md5_201711140116538854-720_925.jpeg\" \/><\/p><p>爱短发的女明星还是很多的，孙俪娘娘的短发也是次次零失误，除了娘娘本来就美，刘海的造型是很重要的。可以剪的时候按照不规则的齐刘海来处理，日常打理时就把刘海侧分，效果会更自然。<\/p><p><img style=\"background:url('http:\/\/bz.metshow.com\/api\/bzlogo2x.png') 50% 50% no-repeat;\" data-original=\"http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/4276970F68BFD034F34A35494C8548F7_md5_201711140117056698-720_997.jpeg\" \/><\/p><p>王子文也爱短发，看似随意的刘海其实也暗藏玄机！太齐显得刻板，太短不能修饰脸型，太长又少了生气，到底怎么照顾好刘海呢？想剪短发的仙女们，重点来啦！<\/p><p style=\"text-align: center;\"><span style=\"background-color: rgb(230, 43, 80);\"><strong><span style=\"color: rgb(248, 249, 243); font-size: 20px;\">找到适合自己的刘海<\/span><\/strong><\/span><\/p><p style=\"text-align: center;\"><span style=\"background-color: rgb(230, 43, 80);\"><strong><span style=\"background-color: rgb(230, 43, 80); font-size: 20px;\"><\/span><\/strong><\/span><\/p><p style=\"text-align: center;\"><span style=\"background-color: rgb(230, 43, 80);\"><strong><span style=\"color: rgb(248, 249, 243); font-size: 20px;\">才能打造不会失败的短发<\/span><\/strong><\/span><\/p><span style=\"background-color: rgb(230, 43, 80);\"><strong><span style=\"background-color: rgb(230, 43, 80); font-size: 20px;\"><\/span><\/strong><\/span><p><img style=\"background:url('http:\/\/bz.metshow.com\/api\/bzlogo2x.png') 50% 50% no-repeat;\" data-original=\"http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/387D765279CA13D47AF8A2816C45D8C3_md5_201711140118105650-400_197.gif\" \/><\/p><p><strong><span style=\"color: rgb(230, 43, 80);\">Step1<\/span><\/strong><strong><span style=\"color: rgb(230, 43, 80);\">.<\/span><\/strong> 先将刘海分成三等份，两边稍多一点。<\/p><p><img style=\"background:url('http:\/\/bz.metshow.com\/api\/bzlogo2x.png') 50% 50% no-repeat;\" data-original=\"http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/6F84DD36B20D7547D6D79F7421101C19_md5_201711140118239099-400_197.gif\" \/><\/p><p><strong><span style=\"color: rgb(230, 43, 80);\">Step2<\/span><\/strong><span style=\"color: rgb(230, 43, 80);\"><strong>.<\/strong><\/span> 使用直板夹，往左上方用力，将右侧的刘海向内卷好。<\/p><p><img style=\"background:url('http:\/\/bz.metshow.com\/api\/bzlogo2x.png') 50% 50% no-repeat;\" data-original=\"http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/E90ED1BE2CADB2A13000724AE343B624_md5_201711140118238132-400_197.gif\" \/><\/p><p><strong><span style=\"color: rgb(230, 43, 80);\">Step3<\/span><\/strong><strong><span style=\"color: rgb(230, 43, 80);\">.<\/span><\/strong> 用同样的方法，将左侧刘海向内卷好。中间一缕头发轻轻向内卷。<br\/><\/p><p><img style=\"background:url('http:\/\/bz.metshow.com\/api\/bzlogo2x.png') 50% 50% no-repeat;\" data-original=\"http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/66BB266FD6487FB24D6BC3678AE299D4_md5_201711140118234626-400_195.gif\" \/><\/p><p><strong><span style=\"color: rgb(230, 43, 80);\">Step4<\/span><\/strong><strong><span style=\"color: rgb(230, 43, 80);\">.<\/span><\/strong> 用梳子梳开后调整自然。<\/p><p style=\"text-align: center;\"><span style=\"font-size: 20px; background-color: rgb(230, 43, 80);\"><strong><span style=\"font-size: 20px; color: rgb(248, 249, 243);\">剪短发不得不注意的Tips<\/span><\/strong><\/span><\/p><p style=\"text-align: center;\"><span style=\"background-color: rgb(230, 43, 80); font-size: 20px;\"><strong><\/strong><\/span><\/p><p><img style=\"background:url('http:\/\/bz.metshow.com\/api\/bzlogo2x.png') 50% 50% no-repeat;\" data-original=\"http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/CCF3980CF6A7094661A37DB6F89ED83F_md5_201711140119474524-564_712.jpeg\" \/><\/p><p><strong><span style=\"color: rgb(230, 43, 80);\">Tips1<\/span><\/strong><\/p><p>避免纯黑发色，大部分的人纯黑色短发都会显得沉闷，今年最推荐暖色系的染发，特别适合比较偏黄的肤色哦！<\/p><p><img style=\"background:url('http:\/\/bz.metshow.com\/api\/bzlogo2x.png') 50% 50% no-repeat;\" data-original=\"http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/AD51D7F39F941E40AFFC77143B6141CC_md5_201711140120062080-500_529.jpeg\" \/><\/p><p><strong><span style=\"color: rgb(230, 43, 80);\">Tips2<\/span><\/strong><\/p><p>打造发顶的蓬松感很关键，这样会看起来更时髦，短发最忌讳的就是坍塌的发顶啦！<\/p><p><img style=\"background:url('http:\/\/bz.metshow.com\/api\/bzlogo2x.png') 50% 50% no-repeat;\" data-original=\"http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/66CDEF9D5BFD5501540F8EB4DF95FDDD_md5_201711140120233124-720_1067.jpeg\" \/><\/p><p>蕴含檀香精油及雪松精油，带来美妙护发体验的同时，有效成分能够直达发芯，滋润秀发。X传导技术将啫喱造型物质导入秀发，塑造纹理，瞬间塑造丰满、亮泽的造型。<\/p><p><img style=\"background:url('http:\/\/bz.metshow.com\/api\/bzlogo2x.png') 50% 50% no-repeat;\" data-original=\"http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/C519BCEFBEAEFAB13438EF6D88C39B9A_md5_201711140120349093-720_774.jpeg\" \/><\/p><p>就算打理发量很少的刘海也会看起来超蓬松自然！味道也很好闻，沁人心脾不甜腻！<\/p><p><img style=\"background:url('http:\/\/bz.metshow.com\/api\/bzlogo2x.png') 50% 50% no-repeat;\" data-original=\"http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/7CDD6A0675267D052D4CFA2637E27355_md5_201711140120508516-640_740.jpeg\" \/><\/p><p>质地为乳霜状，抹上发丝之后可以为秀发充足的补充养分，令秀发柔顺不易毛躁。<\/p><p><img style=\"background:url('http:\/\/bz.metshow.com\/api\/bzlogo2x.png') 50% 50% no-repeat;\" data-original=\"http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/80A6A6A1DC373BBA8B5D67D26D2093F6_md5_201711140121044484-650_352.gif\" \/><\/p><p>好姐妹就是要一起剪短发一起穿尽美衣吃遍美食！记住本芭的几个小忠告，短发可以很女人很有气质，而且更有气场哦！<\/p><p>编辑\/YUKI<\/p><p>发布\/倪倪<\/p><p><strong><span style=\"color: rgb(230, 43, 80);\">搜索微信号bazaarin关注芭莎in个人微信号，做你身边的时尚老司机～<\/span><\/strong><\/p><p style=\"display:none;\" data-background=\"padding-top:0px; padding-bottom:0px; padding-left:0px; padding-right:0px;\"><br\/><\/p><\/div>",
		"CreateDate": "\/Date(1510622506000)\/",
		"FavCount4Extent": 0,
		"Flags": "",
		"GroupPic": null,
		"Ico": "http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/9B435CA431C0DFAAE96954FC44844614_md5_201711140121267195-720_400.jpeg",
		"IcoHeight": 400,
		"IcoWidth": 300,
		"IsOtherTag": null,
		"IsRecommend": null,
		"IsTop": 0,
		"IsVideo": null,
		"LocalId": null,
		"ProductInfoStr": "",
		"PublishDate": "\/Date(1510622480000)\/",
		"RefId": 0,
		"RefType": null,
		"Source": null,
		"State": 3,
		"Summary": "袁泉的齐刘海短发实在太深入人心了，甚至一度觉得短发更有女人味！没想到，这次出席活动的她又剪短了！短上加短，还真挺好看~",
		"Tags": "",
		"Title": "为什么袁泉剪短发会“上瘾”？头发越短人越美，气质和气场双双爆棚！",
		"TopEndDate": null,
		"TopStartDate": null,
		"TopicId": null,
		"UpUserListStr": "[{\"Avatar\":\"http:\/\/wx.qlogo.cn\/mmopen\/vi_32\/Q0j4TwGTfTJzgZYDSfnwe3sgzCriasCX0JCEWJazickKWqJMicvKdVlQxvQEic9ibgeUdUXR19mB1k11cqueffsednQ\/0\",\"UserId\":146779}]",
		"Url": "",
		"UserId": 0,
		"VideoUrl": "",
		"ViewCount": 499,
		"Activity": {
			"ActivityId": 0,
			"EndDate": null,
			"JoinCount": null,
			"StartDate": null,
			"ActivityState": 0,
			"IsJoin": 0
		},
		"ArticlePictures": [],
		"ChannelName": null,
		"CommentCount": 0,
		"ContentPics": ["http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/F8753358357D437036C1338A0ACF7B8E_md5_201711140116230026-720_975.jpeg", "http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/C18A7AA567D4D28A38EA6FC5DBF7844A_md5_201711140116345331-720_963.jpeg", "http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/33EF355F8CE15D0C0DB1104065758E1E_md5_201711140116440276-690_1037.jpeg", "http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/02C8FCE0358FF08D4F80A33C5CE2677F_md5_201711140116538854-720_925.jpeg", "http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/4276970F68BFD034F34A35494C8548F7_md5_201711140117056698-720_997.jpeg", "http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/387D765279CA13D47AF8A2816C45D8C3_md5_201711140118105650-400_197.gif", "http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/6F84DD36B20D7547D6D79F7421101C19_md5_201711140118239099-400_197.gif", "http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/E90ED1BE2CADB2A13000724AE343B624_md5_201711140118238132-400_197.gif", "http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/66BB266FD6487FB24D6BC3678AE299D4_md5_201711140118234626-400_195.gif", "http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/CCF3980CF6A7094661A37DB6F89ED83F_md5_201711140119474524-564_712.jpeg", "http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/AD51D7F39F941E40AFFC77143B6141CC_md5_201711140120062080-500_529.jpeg", "http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/66CDEF9D5BFD5501540F8EB4DF95FDDD_md5_201711140120233124-720_1067.jpeg", "http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/C519BCEFBEAEFAB13438EF6D88C39B9A_md5_201711140120349093-720_774.jpeg", "http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/7CDD6A0675267D052D4CFA2637E27355_md5_201711140120508516-640_740.jpeg", "http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/80A6A6A1DC373BBA8B5D67D26D2093F6_md5_201711140121044484-650_352.gif"],
		"FavCount": 0,
		"HotCommentList": [],
		"IsFav": 0,
		"IsJoin": 0,
		"IsRecTop": null,
		"IsUp": 0,
		"IsVip": 1,
		"NewCommentList": [],
		"OrderNum": 0,
		"PublishNum": null,
		"Rank": "",
		"RelatedArticles": [{
			"ArticleId": 30293,
			"ArticleType": 1,
			"FavCount": 0,
			"Ico": "http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171114\/039FF24247AE4C89A413D0F7C2CAC5D2_md5_201711141626033930-750_750.jpg",
			"Summary": "西班牙奢华抗衰护肤品牌NaturaBissé悦碧施推出黛梦极致赋活夜间修复双套组，让肌肤安享彻夜黛梦，尽显翌日赋活美肌。",
			"Title": "牛尔老师也是它的资深粉丝 西班牙皇室抗衰系列来上海了！",
			"UpCount": 0
		}, {
			"ArticleId": 30048,
			"ArticleType": 1,
			"FavCount": 11,
			"Ico": "http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171106\/F95042DDDA7A570C4AAD00079B8936FA_md5_201711062351448910-1600_1065.jpg",
			"Summary": "虽说现在离圣诞节还早，然而各大彩妆护肤品牌却相继公布今年圣诞限量版的消息。去年的YSL星辰大火了一把，今年大家都卯足了劲，结果就是都好好看啊！",
			"Title": "亮瞎眼的圣诞限量彩妆，谁才是你的终极梦想？",
			"UpCount": 0
		}, {
			"ArticleId": 30248,
			"ArticleType": 1,
			"FavCount": 78,
			"Ico": "http:\/\/bznewpicqiniu.createapp.cn\/@\/attached\/1\/20171112\/1AE9211B8AF2109FE43C9AA803354E11_md5_201711121713179819-1336_1296.png",
			"Summary": "Hello！Hello！小伙伴们，今天本芭又来了！昨天揭开的护肤榜单，你们还看得过瘾吗？今天本芭就来为大家揭晓\ud83d\udc49《时尚芭莎》携手国内消费大数据研究领军机构——",
			"Title": "美妆大赏芭莎美妆大奖不公正？不可能！打开你的化妆包就是这榜单！ ",
			"UpCount": 0
		}],
		"UpCount": 0,
		"Vote": []
	},
	"servertime": null
}
```




