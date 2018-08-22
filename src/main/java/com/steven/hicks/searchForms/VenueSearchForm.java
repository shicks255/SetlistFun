package com.steven.hicks.searchForms;


import com.steven.hicks.beans.City;
import com.steven.hicks.interfaces.SearchForm;
import com.steven.hicks.logic.queryBuilders.VenueQueryBuilder;

public class VenueSearchForm implements SearchForm
{
    private VenueQueryBuilder m_queryBuilder;
    private City city;
    private String url = "";
    private String id = "";
    private String name = "";

    public VenueQueryBuilder getQueryBuilder()
    {
        return m_queryBuilder;
    }

    public void setQueryBuilder(VenueQueryBuilder queryBuilder)
    {
        m_queryBuilder = queryBuilder;
    }

    public City getCity()
    {
        return city;
    }

    public void setCity(City city)
    {
        this.city = city;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
