package com.study.lion.lesson.aboutTestNG;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.testng.Assert.assertEquals;

public class UserAuthorization {
    CloseableHttpClient httpClient = HttpClients.createDefault();
    CloseableHttpResponse httpResponse;

    @Test(description = "用户登录", dataProvider = "loginData", dataProviderClass = MyApiTestData.class)
    public void login(String username, String password) throws URISyntaxException, IOException {
        HttpUriRequest httpUriRequest = RequestBuilder.post().setUri(new URI("http://api.**.***.com/**"))
                .addParameter("username", username).addParameter("password", password).build();
        HttpClientContext localContext = HttpClientContext.create();// 创建本地HTTP上下文,用于获取请求头cookies等内容
        httpResponse = httpClient.execute(httpUriRequest, localContext);
        String strResult = EntityUtils.toString(httpResponse.getEntity());// 获得返回的结果
        JSONObject jsonObject = JSONObject.parseObject(strResult);
        assertEquals(jsonObject.get("message"), "登录成功");
    }

}
