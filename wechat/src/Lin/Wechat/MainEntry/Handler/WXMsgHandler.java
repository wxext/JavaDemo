package Lin.Wechat.MainEntry.Handler;

import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.io.IOUtils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import Lin.Wechat.MainEntry.Sender.Sender;

public class WXMsgHandler implements HttpHandler {
	public void handle(HttpExchange exchange) throws IOException {
		// 接收来自e小天的推送
		String response = IOUtils.toString(new InputStreamReader(exchange.getRequestBody(), "UTF-8"));
		
		// 打印接收回来的json
		System.out.println(response);
		
		//接收信息后 发送hi给filehelper这个WXID
		String send = new Sender().sendMsg("filehelper", "Hi", "");
		
		//查看回传结果
		System.out.println(send);
		
		/*
		 * 以下待开发者自行发挥
		 */
	}
}