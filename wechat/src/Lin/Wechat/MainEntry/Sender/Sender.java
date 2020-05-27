package Lin.Wechat.MainEntry.Sender;

import java.util.HashMap;

import Lin.Wechat.MainEntry.GlobalConfig;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;

public class Sender {

	public String sendMsg(String to, String msg, String at) {
		/*
		 * 请根据以下网址组装请求 
		 * https://www.wxext.cn/home/developer.html#/
		 */
		HashMap<Object, Object> map = new HashMap<>();
		map.put("method", "sendText");
		map.put("wxid", to);
		map.put("msg", msg);
		map.put("atid", at);
		map.put("pid", 0);
		return send(map);
	}

	public String send(HashMap<Object, Object> map) {
		// json封装
		String json = (new JSONObject(map)).toString();
		// 请求发送
		HttpRequest request = HttpRequest.post(GlobalConfig.apiHttp).body(json);
		// 回传结果
		return request.execute().body();
	}
}