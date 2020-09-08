package com.test.pengine;


import com.google.gson.Gson;
import com.test.pengine.models.CheckoutRequest;
import com.test.pengine.service.PromotionCalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PengineApplicationTests {

	@Autowired
	private PromotionCalculatorService service;

	Gson gson = new Gson();

	@Test
	public void serviceShouldReturn_100_WhenRuleOneIsApplied() {
		String requestJson = "{\"rules\":[{\"rulePrice\":130,\"ruleItems\":[{\"skuId\":\"A\",\"count\":3}]},{\"rulePrice\":45,\"ruleItems\":[{\"skuId\":\"B\",\"count\":2}]},{\"rulePrice\":30,\"ruleItems\":[{\"skuId\":\"C\",\"count\":1},{\"skuId\":\"D\",\"count\":1}]}],\"priceMap\":{\"A\":50,\"B\":30,\"C\":20,\"D\":15},\"itemQuantityMap\":{\"A\":1,\"B\":1,\"C\":1}}";
		CheckoutRequest request = gson.fromJson(requestJson, CheckoutRequest.class);
		double totalPrice = service.getTotalAmountAfterPromotions(request);
		assertEquals(100, totalPrice, 0);

	}

	@Test
	public void serviceShouldReturn_370_WhenRuleTwoIsApplied() {
		String requestJson = "{\"rules\":[{\"rulePrice\":130,\"ruleItems\":[{\"skuId\":\"A\",\"count\":3}]},{\"rulePrice\":45,\"ruleItems\":[{\"skuId\":\"B\",\"count\":2}]},{\"rulePrice\":30,\"ruleItems\":[{\"skuId\":\"C\",\"count\":1},{\"skuId\":\"D\",\"count\":1}]}],\"priceMap\":{\"A\":50,\"B\":30,\"C\":20,\"D\":15},\"itemQuantityMap\":{\"A\":5,\"B\":5,\"C\":1}}";
		CheckoutRequest request = gson.fromJson(requestJson, CheckoutRequest.class);
		double totalPrice = service.getTotalAmountAfterPromotions(request);
		assertEquals(370, totalPrice, 0);

	}

	@Test
	public void serviceShouldReturn_280_WhenRuleThreeIsApplied() {
		String requestJson = "{\"rules\":[{\"rulePrice\":130,\"ruleItems\":[{\"skuId\":\"A\",\"count\":3}]},{\"rulePrice\":45,\"ruleItems\":[{\"skuId\":\"B\",\"count\":2}]},{\"rulePrice\":30,\"ruleItems\":[{\"skuId\":\"C\",\"count\":1},{\"skuId\":\"D\",\"count\":1}]}],\"priceMap\":{\"A\":50,\"B\":30,\"C\":20,\"D\":15},\"itemQuantityMap\":{\"A\":3,\"B\":5,\"C\":1,\"D\":1}}";
		CheckoutRequest request = gson.fromJson(requestJson, CheckoutRequest.class);
		double totalPrice = service.getTotalAmountAfterPromotions(request);
		assertEquals(280, totalPrice, 0);

	}
}
