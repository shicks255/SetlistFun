package com.steven.hicks.searchForms;

import com.steven.hicks.beans.ArtistList;
import com.steven.hicks.interfaces.SearchForm;

public class ArtistSearchForm implements SearchForm
{
    private ArtistList m_artistList;
    private String name = "";
    private String mbId = "";
    private String tmId = "";
    private String sort = "";
    private Integer pageNumber = 1;


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getMbId()
    {
        return mbId;
    }

    public void setMbId(String mbId)
    {
        this.mbId = mbId;
    }

    public String getTmId()
    {
        return tmId;
    }

    public void setTmId(String tmId)
    {
        this.tmId = tmId;
    }

    public String getSort()
    {
        return sort;
    }

    public void setSort(String sort)
    {
        this.sort = sort;
    }

    public Integer getPageNumber()
    {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber)
    {
        this.pageNumber = pageNumber;
    }

    public ArtistList getArtistList()
    {
        return m_artistList;
    }

    public void setArtistList(ArtistList artistList)
    {
        m_artistList = artistList;
    }
}
