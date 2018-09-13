package com.steven.hicks.searchForms;

import com.steven.hicks.beans.ArtistList;
import com.steven.hicks.interfaces.SearchForm;
import com.steven.hicks.logic.queryBuilders.ArtistQueryBuilder;

/*
Helper class to pass around in the session
 */
public class ArtistSearchForm implements SearchForm
{
    private ArtistList m_artistList;
    private ArtistQueryBuilder m_queryBuilder;

    private String mbid = "";
    private String name = "";

    public ArtistSearchForm()
    {
        m_artistList = new ArtistList();
        m_artistList.setPage(1);
    }

    public ArtistList getArtistList()
    {
        return m_artistList;
    }

    public void setArtistList(ArtistList artistList)
    {
        m_artistList = artistList;
    }

    public ArtistQueryBuilder getQueryBuilder()
    {
        return m_queryBuilder;
    }

    public void setQueryBuilder(ArtistQueryBuilder queryBuilder)
    {
        m_queryBuilder = queryBuilder;
    }

    public String getMbid()
    {
        return mbid;
    }

    public void setMbid(String mbid)
    {
        this.mbid = mbid;
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
