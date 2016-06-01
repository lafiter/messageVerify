package com.chinasms.sms;

import java.io.*;
import java.net.*;
import java.util.Properties;
import java.util.Random;

public class Sender
{

    public Sender()
    {
    	InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config.properties"); 
    	Properties p = new Properties(); 
    	try { 
    	   p.load(inputStream);
    	} catch (IOException e1) { 
    	   e1.printStackTrace();    
    	}    
        comName = p.getProperty("username");
        comPwd = p.getProperty("password");
        Server = p.getProperty("serverUrl");
    }

    public Sender(String name, String pwd, int serverNum)
    {
    	InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config.properties"); 
    	Properties p = new Properties(); 
    	try { 
    	   p.load(inputStream);    
    	} catch (IOException e1) { 
    	   e1.printStackTrace();    
    	}
        comName = p.getProperty("username");
        comPwd = p.getProperty("password");
        if(serverNum == 2)
            Server = "http://www6.china-sms.com";
        else
            Server = p.getProperty("serverUrl");
    }

    /**
     * 
     * @param dst目标手机号
     * @param msg短信内容
     * @param time发送时间
     * @param subNo
     * @param txt短信类型
     * @return
     */
    public String massSend(String dst, String msg, String time)
    {
    	
        String sUrl = null;
        try
        {
            sUrl = Server + "/send/gsend.asp?name=" + comName + "&pwd=" + comPwd + "&dst=" + dst +"&txt=ccdx"+ "&msg=" + URLEncoder.encode(msg, "GB2312") + "&time=" + time ;//�������GB2312���򷢵��ֻ�����
         
        }
        catch(UnsupportedEncodingException uee)
        {
            System.out.println(uee.toString());
        }
        return getUrl(sUrl);
    }

    public String getUrl(String urlString)
    {
        StringBuffer sb = new StringBuffer();
        try
        {
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            for(String line = null; (line = reader.readLine()) != null;)
                sb.append(line + "\n");

            reader.close();
        }
        catch(IOException e)
        {
            System.out.println(e.toString());
        }
        return sb.toString();
    }

    private String comName;
    private String comPwd;
    private String Server;
}
