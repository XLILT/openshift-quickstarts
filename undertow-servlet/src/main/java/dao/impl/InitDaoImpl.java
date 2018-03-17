package dao.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InitDaoImpl {
	public void init(Connection conn) throws SQLException {

		String sql="INSERT INTO `fatie` (`fid`, `titles`, `fcontent`, `userid`, `photo`, `time`, `username`) VALUES (20, '中国的哪方面比美国强？', '1. 美国非常不安全。美国是这样的，这个区域有钱就多交税警察多，就安全。没钱就警察少就不安全。比如底特律就没有警察。我在北京只要十一点回家爸妈就放心，在洛杉矶我天黑之后也就敢在westwood（夹在三个富人区中间）溜达溜达。洛杉矶downtown什么样呢？整条街道都弥漫着恶臭味，人行道完全没法走，全都是帐篷，我走路的话就只能走到马路的中央。', 6, '2017_9_1_16_53_41_id6_QQ截图20170901165256.png', '2017-9-1 16:53:41', '古天乐');";
		PreparedStatement ps=conn.prepareStatement(sql);
//		PreparedStatement ps=conn.prepareCall(sql);
		
		//ps.setInt(1, via.getUserid());
		//ps.setString(2, via.getPhoto());

		ps.execute();

		sql="INSERT INTO `fatie` (`fid`, `titles`, `fcontent`, `userid`, `photo`, `time`, `username`) VALUES (21, '我是陈意涵', '陈意涵（Ivy Chen），1982年11月12日出生于台湾省新北市，华语影视女演员。2006年，她因主演银幕处女作《单车上路》而正式出道。2007年，凭借励志剧《奋斗》被更多内地观众认识。2009年，因主演警匪剧《痞子英雄》而获得韩国首尔国际电视剧奖最佳女演员提名。2010年，凭借剧情片《听说》获得第12届台北电影节最佳女主角。2012年，凭借爱情片《爱LOVE》获得第49届台湾电影金马奖最佳女配角提名。2014年，她又凭借现代片《军中乐园》获得第51届台湾电影金马奖最佳女配角提名。', 7, '2017_9_1_16_55_44_id7_29517865894105ba816934950e43e547.jpg', '2017-9-1 16:55:44', '陈意涵');";
		ps=conn.prepareStatement(sql);		
		ps.execute();

		sql="INSERT INTO `fatie` (`fid`, `titles`, `fcontent`, `userid`, `photo`, `time`, `username`) VALUES (22, '你觉得哪些书值得我们去读？', '我在大学的时候，搜集了豆瓣top250的书单，看了不少书，但是很多没有留下什么深刻的印象，看书是好事，但是如果能够把书里的知识运用到现实当中，对自己以及身边的人有所助益就更好了。作为一个过来人，我很理解大家想要提升自己的愿望，今天就整理、推荐了一些豆瓣评分8分以上，广受我身边朋友、老师好评，并且我也觉得对我特别有帮助的书推荐给大家希望对你也能够有所帮助~', 7, '2017_9_1_16_57_31_id7_814f253234a906a1d422f3c4fe832fa1.jpg', '2017-9-1 16:57:31', '陈意涵');";
		ps=conn.prepareStatement(sql);		
		ps.execute();

		sql="INSERT INTO `fatie` (`fid`, `titles`, `fcontent`, `userid`, `photo`, `time`, `username`) VALUES (23, '北方雪景', '1. 孤舟蓑笠翁，独钓寒江雪。\r\n2. 云横秦岭家何在，雪拥蓝关马不前\r\n3. 地白风色寒，雪花大入手\r\n4. 夜深知雪重，时闻折竹声。\r\n5. 北风吹雪四更初，嘉瑞天教及岁除。\r\n6. 战退玉龙三百万，败鳞残甲满天飞。\r\n7. 帘外雪初飘，翠幌香凝火未消。\r\n8. 雪照山城玉指寒，一声羌管怨楼间。\r\n9. 雪里已知春信至，寒梅点缀琼枝腻。\r\n10. 落尽琼花天不惜，封他梅蕊玉无香。\r\n11. 白雪却嫌春色晚，故穿庭树作飞花。\r\n12. 草枯鹰眼疾，雪尽马蹄轻。\r\n13. 欲渡黄河冰塞川，将登太行雪满山。\r\n14. 北风卷地白草折，胡天八月即飞雪。\r\n15. 六出飞花入户时，坐看青竹变琼枝\r\n16. 玉砌红花树，香风不敢吹。\r\n17. 鸣笙起秋风，置酒飞冬雪。\r\n18. 窗含西岭千秋雪，门泊东吴万里船。\r\n19. 晨起开门雪满山，雪晴云淡日光寒。\r\n20. 飞雪带春风，裴回乱绕空。', 8, '2017_9_1_17_05_36_id8_5fcd5b59420bd9fcd2eacf4074c07dc6.png', '2017-9-1 17:05:36', '马亮南生');";
		ps=conn.prepareStatement(sql);		
		ps.execute();

		sql="INSERT INTO `fatie` (`fid`, `titles`, `fcontent`, `userid`, `photo`, `time`, `username`) VALUES (24, '有哪些常被认为是违法的其实是合法的事？', '那时候也快十二点了，只能第二天再处理了。第二天的时候，各种找终于把司机找到了，原本不接电话，说没有乘客把包落下，后来调了监控看到确实有包上车没包下车，司机才承认，后来出租车司机让过去拿包，但是包里的 7plus和几千块钱奖金都没了。', 6, '2017_9_1_17_14_08_id6_004911ba00be3bed8047fe2ef00192d5.jpg', '2017-9-1 17:14:08', '古天乐');";
		ps=conn.prepareStatement(sql);		
		ps.execute();

		sql="INSERT INTO `pinglun` (`pid`, `pcontent`, `userid`, `byid`, `time`) VALUES (11, '我觉得很多地方都比美国强，当然总的看来还是差距很大的。', 8, 20, '2017-9-1 17:07:20');";
		ps=conn.prepareStatement(sql);		
		ps.execute();

		sql="INSERT INTO `pinglun` (`pid`, `pcontent`, `userid`, `byid`, `time`) VALUES (12, '四大名著，其他的不晓得。。啊哈哈哈哈哈。。。。', 8, 22, '2017-9-1 17:08:18');";
		ps=conn.prepareStatement(sql);		
		ps.execute();

		sql="INSERT INTO `pinglun` (`pid`, `pcontent`, `userid`, `byid`, `time`) VALUES (13, '你好，我是小明。', 8, 21, '2017-9-1 17:08:47');";
		ps=conn.prepareStatement(sql);		
		ps.execute();

		sql="INSERT INTO `pinglun` (`pid`, `pcontent`, `userid`, `byid`, `time`) VALUES (14, '北方雪景很漂亮，1. 孤舟蓑笠翁，独钓寒江雪。 2. 云横秦岭家何在，雪拥蓝关马不前 3. 地白风色寒，雪花大入手 4. 夜深知雪重，时闻折竹声。 5. 北风吹雪四更初，嘉瑞天教及岁除。', 7, 23, '2017-9-1 17:09:43');";
		ps=conn.prepareStatement(sql);		
		ps.execute();

		sql="INSERT INTO `pinglun` (`pid`, `pcontent`, `userid`, `byid`, `time`) VALUES (16, '我可以给自己评论哦', 6, 24, '2017-9-1 17:15:41');";
		ps=conn.prepareStatement(sql);		
		ps.execute();

		sql="INSERT INTO `pinglun` (`pid`, `pcontent`, `userid`, `byid`, `time`) VALUES (17, '小伙子，不错哦。', 6, 23, '2017-9-1 17:16:05');";
		ps=conn.prepareStatement(sql);		
		ps.execute();

		sql="INSERT INTO `pinglun` (`pid`, `pcontent`, `userid`, `byid`, `time`) VALUES (18, '呀，，原来也可以给自己评论啊。', 7, 22, '2017-9-1 17:21:54');";
		ps=conn.prepareStatement(sql);		
		ps.execute();

		sql="INSERT INTO `user` (`userid`, `name`, `password`, `email`, `family`, `intro`, `time`) VALUES (6, '古天乐', '123', 'yuggbbbujbj@ww.com', '北京', '1970年10月21日出生于中国香港，中国香港男演员、歌手。', '2017-9-1 16:47:16');";
		ps=conn.prepareStatement(sql);		
		ps.execute();

		sql="INSERT INTO `user` (`userid`, `name`, `password`, `email`, `family`, `intro`, `time`) VALUES (7, '陈意涵', '123456', '927654672@qq.com', '中国台湾', '漂亮，美丽，人见人爱。', '2017-9-1 16:48:26');";
		ps=conn.prepareStatement(sql);		
		ps.execute();

		sql="INSERT INTO `user` (`userid`, `name`, `password`, `email`, `family`, `intro`, `time`) VALUES (8, '马亮南生', '1234', '767676767@gmail.com', '四川成都', '克己复礼，帅气无比。', '2017-9-1 17:01:17');";
		ps=conn.prepareStatement(sql);		
		ps.execute();		
	}
}