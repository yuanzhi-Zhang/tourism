package com.yuanzhi.tourism;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yuanzhi.tourism.common.*;
import com.yuanzhi.tourism.entity.*;
import com.yuanzhi.tourism.service.HotelService;
import com.yuanzhi.tourism.service.SceneService;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.Word;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourismApplicationTests {

	@Autowired
	SceneService sceneService;
	@Autowired
	HotelService hotelService;

	/*@Test
	public void hotel(){
		HotelApi hotelApi = new HotelApi();
		String cityName = "江苏";
		String res = hotelApi.getHotelApi(cityName,"","");
		com.alibaba.fastjson.JSONObject object = JSON.parseObject(res);
		JSONArray jsarr = object.getJSONObject("showapi_res_body").getJSONObject("data").getJSONArray("hotelList");
		System.out.println(jsarr);
		List<Hotel> apidataList = new ArrayList<Hotel>();
		for (int i = 0; i < jsarr.size(); i++) {
			Hotel apidata = new Hotel();
			apidata.setHotelCity(cityName+"市");
			JSONObject ao = jsarr.getJSONObject(i);
			String name_en = ao.get("englishName") + "";
			apidata.setHotelNameEn(name_en);
			String name_zn = ao.get("chineseName") + "";
			apidata.setHotelNameZn(name_zn);
			String address = ao.get("address") + "";
			apidata.setHotelAddress(address);
			String price = ao.get("price") + "";
			apidata.setHotelPrice(price);
			String hotelId = ao.get("hotelId") + "";
			apidata.setHotelMainId(hotelId);
			String picture = ao.get("picture") + "";
			apidata.setHotelPicture(picture);
			String star = ao.get("star") + "";
			apidata.setHotelStar(star);
			String starName = ao.get("starName") + "";
			apidata.setHotelStarName(starName);
			hotelService.addHotel(apidata);
		}
		System.out.println(apidataList);

		*//*String resDetail = hotelApi.hotelDetail("637951");
		com.alibaba.fastjson.JSONObject object1 = JSON.parseObject(resDetail);
		JSONObject jsarr1 = object1.getJSONObject("showapi_res_body").getJSONObject("data");
		System.out.println(jsarr1);*//*
	}

	@Test
	public void contextLoads() {

		//景点查询
		SceneApi ad = new SceneApi();
		String res = ad.getSceneApi("武汉");
		com.alibaba.fastjson.JSONObject object = JSON.parseObject(res);
		JSONArray jsarr = object.getJSONObject("showapi_res_body").getJSONObject("pagebean").getJSONArray("contentlist");
		System.out.println(jsarr);
		List<Scene> apidataList = new ArrayList<Scene>();
		for (int i = 0; i < jsarr.size(); i++) {
			Scene apidata = new Scene();
			JSONObject ao = jsarr.getJSONObject(i);
			String name = ao.get("name") + "";
			apidata.setSceneName(name);
			String cityName = ao.get("cityName") + "";
			apidata.setSceneCityName(cityName);
			String areaName = ao.get("areaName") + "";
			apidata.setSceneAreaName(areaName);
			String proName = ao.get("proName") + "";
			apidata.setSceneProvinceName(proName);
			String summary = ao.get("summary") + "";
			apidata.setSceneSummary(summary);
			String star = ao.get("star") + "";
			apidata.setSceneStar(star);
			String price = ao.get("price") + "";
			apidata.setScenePrice(price);
			String address = ao.get("address") + "";
			apidata.setSceneAddress(address);
			String coupon = ao.get("coupon") + "";
			apidata.setSceneCoupon(coupon);
			String attention = ao.get("attention") + "";
			apidata.setSceneAttention(attention);
			String opentime = ao.get("opentime") + "";
			apidata.setSceneOpentime(opentime);
			JSONArray piclist = ao.getJSONArray("picList");
			StringBuilder pics = new StringBuilder("");
			for (int s = 0; s < piclist.size(); s++){
				JSONObject po = piclist.getJSONObject(s);
				if (s != piclist.size()-1){
					String picUrl = po.get("picUrl") + ",";
					pics.append(picUrl);
				}else if(s == piclist.size()-1) {
					String picUrl = po.get("picUrl") + "";
					pics.append(picUrl);
				}
			}
			apidata.setScenePics(pics.toString());
			sceneService.addScene(apidata);
		}
		System.out.println(apidataList);

	}*/

	@Test
	public void similar(){
		//IKS分词测试
		String text = "杭州四日深度游，大众小众文艺打卡地掠影";
		String text1 = "杭州四日欢乐游，大众小众文艺打卡地停留";
		String text2 = "丽江七日诗词诵，文艺青年看过来";
		String text3 = "今天小小和爸爸一起去摘草莓，小小说今天的草莓特别的酸，而且特别的小，关键价格还贵";
		String text4 = "今天小小和妈妈一起去草原里采草莓，今天的草莓味道特别好，而且价格还挺实惠的";
		CosineSimilarity cosineSimilarity = new CosineSimilarity();
		System.out.println(cosineSimilarity.cos(text, text1));//0.5773502691896258
		System.out.println(cosineSimilarity.cos(text, text2));//0.5773502691896258
		System.out.println(cosineSimilarity.cos(text3, text4));//0.5773502691896258

//		StringBuilder result = new StringBuilder();
		List<Word> words = WordSegmenter.seg("普吉岛购物攻略｜普吉岛最值得一逛的六家大型商场", SegmentationAlgorithm.FullSegmentation);  //过滤了停用词
		/*List<Word> words1 = WordSegmenter.seg("【贵州民族村寨精选】控拜苗寨：中国银饰艺术之乡", SegmentationAlgorithm.FullSegmentation);  //过滤了停用词
		List<Word> words2 = WordSegmenter.seg("距西安仅半小时车程的袁家村美食攻略", SegmentationAlgorithm.FullSegmentation);  //过滤了停用词
		List<Word> words3 = WordSegmenter.seg("有马温泉全攻略 | 玩法、交通、历史一网打尽", SegmentationAlgorithm.FullSegmentation);  //过滤了停用词
		List<Word> words4 = WordSegmenter.seg("普吉岛夜生活 | 酒吧、人妖秀、幻多奇乐园", SegmentationAlgorithm.FullSegmentation);  //过滤了停用词*/

		/*Set<String> expectedNature = new HashSet<String>() {{
			add("n");add("v");add("vd");add("vn");add("vf");
			add("vx");add("vi");add("vl");add("vg");
			add("nt");add("nz");add("nw");add("nl");
			add("ng");add("userDefine");add("wh");add("ff");
		}};
		String str = "2019.12.30遇上兵察察，丙察察进藏" ;
		Result result = ToAnalysis.parse(str); //分词结果的一个封装，主要是一个List<Term>的terms
		System.out.println(result.getTerms());

		List<Term> terms = result.getTerms(); //拿到terms
		System.out.println(terms.size());

		for(int i=0; i<terms.size(); i++) {
			String word = terms.get(i).getName(); //拿到词
			String natureStr = terms.get(i).getNatureStr(); //拿到词性
			if(expectedNature.contains(natureStr)) {
				System.out.println(word + ":" + natureStr);
			}
		}*/

//		result.append(word.getText()).append(" ");

//		List<Word> words1 = WordSegmenter.segWithStopWords("杨尚川是APDPlat应用级产品开发平台的作者");

		List<String>list = new ArrayList<>();
		for (int i = 0; i < words.toArray().length; i++) {
			list.add(words.get(i).toString());
		}
		System.out.println(list);
		/*System.out.println(words);
		System.out.println(words1);
		System.out.println(words2);
		System.out.println(words3);
		System.out.println(words4);*/
	}

}
