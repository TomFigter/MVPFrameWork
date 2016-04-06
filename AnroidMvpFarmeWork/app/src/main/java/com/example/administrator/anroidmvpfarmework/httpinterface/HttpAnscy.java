package com.example.administrator.anroidmvpfarmework.httpinterface;

import android.util.Log;
import android.widget.Adapter;
import android.widget.BaseAdapter;

import com.example.administrator.anroidmvpfarmework.setget.ReDianData;
import com.example.administrator.anroidmvpfarmework.util.HttpUtil;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：LiShiChuang on 2016/2/20 09:02
 * 邮箱：lschuang@126.com
 */
public class HttpAnscy {
    private List<ReDianData> getdatalist;

    public HttpAnscy() {
    }

    public List<ReDianData> sendRequesWithHttpClient() {
        getdatalist = new ArrayList<>();
        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet("http://apis.haoservice.com/lifeservice/news/words?key=c5bccc07cefd40148daa8c5647c83469");
            HttpResponse httpResponse = client.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                //请求和响应都成功
                HttpEntity entity = httpResponse.getEntity();
                String response = EntityUtils.toString(entity, "utp-8");
                getdatalist = parseJSONWithJSONObject(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getdatalist;
    }

    private List<ReDianData> parseJSONWithJSONObject(String response) {
        List<ReDianData> reDianDataList = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(response);
            int code = object.getInt("error_code");
            String reason = object.getString("reason");
            if (code == 0 && reason.equals("成功")) {
                JSONArray jsonArray =object.getJSONArray("result");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    ReDianData reDianData = new ReDianData();
                    reDianData.setId(jsonObject.getString("Id"));
                    reDianData.setKeyword(jsonObject.getString("KeyWord"));
                    Log.d("获取的数据", "" + reDianData);
                    reDianDataList.add(reDianData);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return reDianDataList;
    }
}
