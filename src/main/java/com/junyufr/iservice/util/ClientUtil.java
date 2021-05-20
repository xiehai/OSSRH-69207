package com.junyufr.iservice.util;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by junyuf on 2020/6/3.
 */
public class ClientUtil {


    public static String post(String url, String request,Integer connectTimeout,Integer readTimeout) throws Exception {
        if (url.startsWith("https://")) {
            return doPostHttps(url, request,connectTimeout,readTimeout);
        } else {
            return doPostHttp(url, request,connectTimeout,readTimeout);
        }
    }

    public static String doPostHttp(String urlStr, String request,Integer connectTimeout,Integer readTimeout) throws Exception {
        DataOutputStream objOutputStrm = null;
        OutputStream outStrm = null;
        InputStream inStrm = null;
        try {
            URL url = new URL(urlStr);
            // 此处的urlConnection对象实际上是根据URL的 // 请求协议(此处是http)生成的URLConnection类 // 的子类HttpURLConnection,故此处最好将其转化 // 为HttpURLConnection类型的对象,以便用到 // HttpURLConnection更多的API.如下:
            URLConnection rulConnection = url.openConnection();
            HttpURLConnection httpUrlConnection = (HttpURLConnection) rulConnection;
            //设置链接超时时间
            httpUrlConnection.setConnectTimeout(connectTimeout);
            //设置读取超时时间
            httpUrlConnection.setReadTimeout(readTimeout);
            // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在
            // http正文内，因此需要设为true, 默认情况下是false;
            httpUrlConnection.setDoOutput(true);
            // 设置是否从httpUrlConnection读入，默认情况下是true;
            httpUrlConnection.setDoInput(true);
            // Post 请求不能使用缓存
            httpUrlConnection.setUseCaches(false);
            // 设定传送的内容类型是可序列化的java对象
            // (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)
            httpUrlConnection.setRequestProperty("Content-type", "application/json");
            // 设定请求的方法为"POST"，默认是GET
            httpUrlConnection.setRequestMethod("POST");
            // 此处getOutputStream会隐含的进行connect(即：如同调用上面的connect()方法，

            // 所以在开发中不调用上述的connect()也可以)。
            outStrm = httpUrlConnection.getOutputStream();
            // 现在通过输出流对象构建对象输出流对象，以实现输出可序列化的对象。
            objOutputStrm = new DataOutputStream(outStrm);
            // 向对象输出流写出数据，这些数据将存到内存缓冲区中
            objOutputStrm.write(request.getBytes());
            // 刷新对象输出流，将任何字节都写入潜在的流中（些处为ObjectOutputStream）
            objOutputStrm.flush();
            // 调用HttpURLConnection连接对象的getInputStream()函数,
            // 将内存缓冲区中封装好的完整的HTTP请求电文发送到服务端。
            inStrm = httpUrlConnection.getInputStream(); // <===注意，实际发送请求的代码段就在这里
            BufferedReader read = new BufferedReader(new InputStreamReader(inStrm, "UTF-8"));
            StringBuffer jsonString = new StringBuffer();
            String line = "";
            while ((line = read.readLine()) != null) {
                jsonString.append(line);
            }
            String json = jsonString.toString();

            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (objOutputStrm != null)
                objOutputStrm.close();

            if (outStrm != null) {
                outStrm.close();
            }

            if (inStrm != null)
                inStrm.close();

        }

    }

    /**
     * HTTPS
     *
     * @param urlStr
     * @param reponse
     * @return
     *
     */
    public static String doPostHttps(String urlStr,String reponse,Integer connectTimeout,Integer readTimeout) throws Exception {

        long begin = System.currentTimeMillis();
        DataOutputStream objOutputStrm = null;
        OutputStream outStrm = null;
        InputStream inStrm = null;
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(new ClientUtil().new NullHostNameVerifier());
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            URL url = new URL(null, urlStr, new sun.net.www.protocol.https.Handler());
            // 此处的urlConnection对象实际上是根据URL的
            // 请求协议(此处是http)生成的URLConnection类
            // 的子类HttpURLConnection,故此处最好将其转化
            // 为HttpURLConnection类型的对象,以便用到
            // HttpURLConnection更多的API.如下:
            HttpsURLConnection httpUrlConnection = (HttpsURLConnection) url.openConnection();
            //设置链接超时时间
            httpUrlConnection.setConnectTimeout(connectTimeout);
            //设置读取超时时间
            httpUrlConnection.setReadTimeout(readTimeout);
            // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在
            // http正文内，因此需要设为true, 默认情况下是false;
            httpUrlConnection.setDoOutput(true);

            // 设置是否从httpUrlConnection读入，默认情况下是true;
            httpUrlConnection.setDoInput(true);

            // Post 请求不能使用缓存
            httpUrlConnection.setUseCaches(false);

            // 设定传送的内容类型是可序列化的java对象
            // (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)
            httpUrlConnection.setRequestProperty("Content-type", "application/json");

            // 设定请求的方法为"POST"，默认是GET
            httpUrlConnection.setRequestMethod("POST");

            // 此处getOutputStream会隐含的进行connect(即：如同调用上面的connect()方法，
            // 所以在开发中不调用上述的connect()也可以)。
            outStrm = httpUrlConnection.getOutputStream();

            // 现在通过输出流对象构建对象输出流对象，以实现输出可序列化的对象。
            objOutputStrm = new DataOutputStream(outStrm);

            // 向对象输出流写出数据，这些数据将存到内存缓冲区中
            objOutputStrm.write(reponse.getBytes());

            // 刷新对象输出流，将任何字节都写入潜在的流中（些处为ObjectOutputStream）
            objOutputStrm.flush();

            // 调用HttpURLConnection连接对象的getInputStream()函数,
            // 将内存缓冲区中封装好的完整的HTTP请求电文发送到服务端。
            inStrm = httpUrlConnection.getInputStream(); // <===注意，实际发送请求的代码段就在这里


            BufferedReader read = new BufferedReader(new InputStreamReader(inStrm, "UTF-8"));

            StringBuffer jsonString = new StringBuffer();
            String line = "";
            while ((line = read.readLine()) != null) {
                jsonString.append(line);
            }
            String json = jsonString.toString();

            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            System.out.println("-------------------共耗时：{}ms" + (System.currentTimeMillis()-begin));
            if (objOutputStrm != null)
                objOutputStrm.close();

            if (outStrm != null) {
                outStrm.close();
            }

            if (inStrm != null)
                inStrm.close();

        }

    }

    static TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            // TODO Auto-generated method stub
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            // TODO Auto-generated method stub
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            // TODO Auto-generated method stub
            return null;
        }
    }};

    public class NullHostNameVerifier implements HostnameVerifier {
        /*
         * (non-Javadoc)
         *
         * @see javax.net.ssl.HostnameVerifier#verify(java.lang.String,
         * javax.net.ssl.SSLSession)
         */
        @Override
        public boolean verify(String arg0, SSLSession arg1) {
            // TODO Auto-generated method stub
            return true;
        }
    }
}
