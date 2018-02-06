package com.anirudh.codingchallenge;

/**
 * Created by Anirudh on 2/5/18.
 */

public class Guide
{
    private String startDate, endDate, name, url, urlToImg, city, state;

    public Guide(String name, String endDate, String city, String state, String urlToImg)
    {
        this.endDate = endDate;
        this.name = name;
        this.urlToImg = urlToImg;
        this.city = city;
        this.state = state;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrlToImg()
    {
        return urlToImg;
    }

    public void setUrlToImg(String urlToImg)
    {
        this.urlToImg = urlToImg;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }
}
