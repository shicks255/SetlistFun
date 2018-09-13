package com.steven.hicks.searchForms;

import com.steven.hicks.beans.ArtistList;
import com.steven.hicks.interfaces.SearchForm;
import com.steven.hicks.logic.queryBuilders.ArtistQueryBuilder;

/*
Helper class to pass around in the session
 */
public class ArtistSearchForm implements SearchForm
{
    public ArtistList m_artistList;
    public ArtistQueryBuilder m_queryBuilder;

    public String mbid = "";
    public String name = "";

    public ArtistSearchForm()
    {
        m_artistList = new ArtistList();
        m_artistList.setPage(1);
    }

}
