package com.itau.mygod.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.util.Log;

public class Webservice extends WebserviceHelp
{
     
    private static final String  Webservice_Tag="网络服务";
    
        /***
     * 用户登陆    
     * @param usernum 学号
     * @param password 密码
     * @return 1:登陆成功 other:登录失败负login方法：httpUtils.post(URL, Login, params);
     */
    public static int login(String usernum,String password)
    {
        JSONObject object;
        
        try     
        {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            
            params.add(new BasicNameValuePair("userPhone",usernum));
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
     * 获取种类   
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
     * 通过id获得商品 
     * @param ItemId 商品id 
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
     * 通过id获得用户信息 
     * @param UserId 用户id 
     * @return 
     */
    public static String getUserById(String UserId)
    {
        JSONObject object;
        
        try     
        {
            
            object = HttpUtils.post(URL, GetUserById);
        
               
            return object.optString("results");
            
        }
        catch(Exception e)
        {
            Log.e(Webservice_Tag+Login, e.toString());
            return Fail;
        }
        
    }
}
