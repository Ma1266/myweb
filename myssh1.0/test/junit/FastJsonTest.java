package junit;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.mwm.vo.User;

public class FastJsonTest {

	
	
	private static SerializerFeature[] features = {
			SerializerFeature.WriteMapNullValue,
			SerializerFeature.WriteNullStringAsEmpty };

	List<User> users=new ArrayList<User>();
	
	public static void main(String[] args) {
		FastJsonTest test=new FastJsonTest();
		System.out.println(test.getJson());
	}
	
	
	public String getJson() {
		User user=new User();
		user.setUsername("admin");
		String jsonString=JSON.toJSONStringWithDateFormat(user, "yyyy-MM-dd HH:mm:ss",features);
		return jsonString;
		
	}
}
