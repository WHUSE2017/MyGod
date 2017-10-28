package com.itau.mygod.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.util.Log;

public class Webservice extends WebserviceHelp
{
     
    private static final String  Webservice_Tag="缃戠粶鏈嶅姟";
    
        /***
     * 鐢ㄦ埛鐧婚檰     
     * @param userPhone 鎵嬫満鍙�
     * @param password 瀵嗙爜
     * @return 1:鐧婚檰鎴愬姛 other:鐧婚檰澶辫触 姝ゆ柟娉曞湪鏈嶅姟鍣ㄤ腑鐨勬槧灏勪负login锛屾湇鍔″櫒寮�鍙戣�呮敞鎰廐ttpUtils.post(URL, Login, params);涓殑login灏辨槸鏈嶅姟鍣ㄤ腑鐨刱ey锛屼綘鎶婄櫥闄嗗姛鑳藉懡鍚嶄负login锛屽叾浠栫被浼硷紝涓嬮潰灏变笉涓�涓�璧樿堪浜嗐��
     */
    public static int login(String userPhone,String password)
    {
        JSONObject object;
        
        try     
        {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            
            params.add(new BasicNameValuePair("userPhone",userPhone));
            params.add(new BasicNameValuePair("password",password));
            
            object = HttpUtils.post(URL, Login, params);
        
               
            return object.optInt("results");
            
        }
        catch(Exception e)
        {
            Log.e(Webservice_Tag+Login, e.toString());
            return -1;
        }
        
    }
    /***
     * 鑾峰彇绉嶇被     
     * @return 
     */
    public static JSONObject getCategory()
    {
        JSONObject object;
        
        try     
        {
            
            object = HttpUtils.post(URL, GetCategory);
        
               
            return object;
            
        }
        catch(Exception e)
        {
            Log.e(Webservice_Tag+Login, e.toString());
            return null;
        }
        
    }
    /***
     * 鏍规嵁鍟嗗搧缂栧彿鑾峰彇鍟嗗搧 
     * @param ItemId 鍟嗗搧缂栧彿 
     * @return 
     */
    public static String getItemById(String ItemId)
    {
        JSONObject object;
        
        try     
        {
            
            object = HttpUtils.post(URL, GetCategory);
        
               
            return object.optString("results");
            
        }
        catch(Exception e)
        {
            Log.e(Webservice_Tag+Login, e.toString());
            return Fail;
        }
        
    }
    /***
     * 鏍规嵁鍟嗗搧缂栧彿鑾峰彇鍟嗗搧 
     * @param ItemId 鍟嗗搧缂栧彿 
     * @return 
     */
    public static String getUserById(String UserId)
    {
        JSONObject object;
        
        try     
        {
            
            object = HttpUtils.post(URL, GetCategory);
        
               
            return object.optString("results");
            
        }
        catch(Exception e)
        {
            Log.e(Webservice_Tag+Login, e.toString());
            return Fail;
        }
        
    }
}
