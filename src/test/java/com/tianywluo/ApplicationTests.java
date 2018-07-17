package com.tianywluo;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tianywluo.entity.User;
import com.tianywluo.util.MD5Util;
import com.tianywluo.util.VerifyUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void isValidTest() {
		User user = new User();
		user.setPassword("&");
		user.setTelephone("18745678913");
		boolean isValid = new VerifyUtil().isValidTelephone(user);
		if (isValid) {
			System.out.println("格式正确");
		} else {
			System.out.println("格式不正确");
		}
		
	}
	
	@Test
	public void UUIDTest() {
		System.out.println(UUID.randomUUID().toString());
	}
	
	@Test
	public void MD5Test() {
		String str = "123456";
		String str1 = MD5Util.getMD5(str, "utf-8");
		String str2 = MD5Util.getMD5(str, "utf-8");
		System.out.println(str1);
		System.out.println(str2);
	}

}
