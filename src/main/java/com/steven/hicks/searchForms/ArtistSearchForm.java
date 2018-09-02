package com.steven.hicks.searchForms;

import com.steven.hicks.interfaces.SearchForm;
import com.steven.hicks.logic.queryBuilders.ArtistQueryBuilder;

public class ArtistSearchForm implements SearchForm
{
    private ArtistQueryBuilder m_queryBuilder;
    private String name = "";
    private String mbId = "";
    private String tmId = "";
    private String sort = "";
    private Integer pageNumber = 1;


    public ArtistQueryBuilder getQueryBuilder()
    {
        return m_queryBuilder;
    }

    public void setQueryBuilder(ArtistQueryBuilder queryBuilder)
    {
        m_queryBuilder = queryBuilder;
    }

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
}
