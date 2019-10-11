package com.yuanzhi.tourism;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yuanzhi.tourism.common.CosineSimilarity;
import com.yuanzhi.tourism.common.FlightApi;
import com.yuanzhi.tourism.common.PhoneApi;
import com.yuanzhi.tourism.common.SceneApi;
import com.yuanzhi.tourism.entity.Scene;
import com.yuanzhi.tourism.service.SceneService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.yuanzhi.tourism.utils.IKSUtil.getStringList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TourismApplicationTests {

//	@Autowired
//	SceneService sceneService;

	@Test
	public void contextLoads() {

		//景点查询
//		SceneApi ad = new SceneApi();
//		String res = ad.getSceneApi("泰山");
//		com.alibaba.fastjson.JSONObject object = JSON.parseObject(res);
//		JSONArray jsarr = object.getJSONObject("showapi_res_body").getJSONObject("pagebean").getJSONArray("contentlist");
//		System.out.println(jsarr);
//		List<SceneApi> sceneApiList = new ArrayList<SceneApi>();
//		for (int i=1; i<=sceneApiList.size(); i++){
//			SceneApi sceneApi = new SceneApi();
//			JSONObject ao = jsarr.getJSONObject(i);
////			Scene scene = new Scene();
////			scene.setId(i);
////			scene.setAddress(jsarr.);
//			System.out.println(ao);
//		}

		//IKS分词测试
		String text = "我们一起去踢足球吧";
		String text1 = "我喜欢打篮球";
		CosineSimilarity cosineSimilarity = new CosineSimilarity();
		System.out.println(cosineSimilarity.cos(text, text1));//0.5773502691896258

	}

}
