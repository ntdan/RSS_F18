package com.example.ntdan.rss;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.GridView;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by ntdan on 4/21/2018.
 */
public class PhanTichRSS extends AsyncTask<String, String, String> {

    public ArrayList<RssItem> rssList;
    GridView grd;
    RssAdapeter adp;
    MainActivity context;

    public PhanTichRSS(GridView grd, RssAdapeter adp, MainActivity context) {
        this.grd = grd;
        this.adp = adp;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        rssList = new ArrayList<>();
    }

    @Override
    protected String doInBackground(String... rssChanleLink) {
        try
        {
            URL url = new URL(rssChanleLink[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
            DocumentBuilder dcp = fac.newDocumentBuilder();

            Document doc = dcp.parse(connection.getInputStream());
            NodeList l = doc.getElementsByTagName("item");
            for (int i =0; i < l.getLength(); i++)
            {
                RssItem item = new RssItem();
                item.setTitle(l.item(i).getChildNodes().item(1).getTextContent().substring(0,10)+"...");
                String des = l.item(i).getChildNodes().item(3).getTextContent();
                // su dung jsoup de xu ly CDATA
                //org.jsoup.nodes.Document jdoc = Jsoup.parse(des);
                //String link = jdoc.select("a").first().attr("href");

                //item.setUrl(link);

                //String imgURL = jdoc.select("img").first().attr("src");
                //URL url1 = new URL(imgURL);
                //HttpURLConnection connection1 = (HttpURLConnection) url1.openConnection();
                //InputStream input = connection1.getInputStream();
                //item.image = BitmapFactory.decodeStream(input);

                rssList.add(item);
            }
        }
        catch(Exception ex)
        {
            Log.d("ex:", ex.toString());
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        this.adp = new RssAdapeter(rssList, context);
        this.grd.setAdapter(adp);
    }
}
