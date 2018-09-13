package com.steven.hicks.searchForms;

import com.steven.hicks.beans.SetlistList;
import com.steven.hicks.interfaces.SearchForm;
import com.steven.hicks.logic.queryBuilders.SetlistQueryBuilder;

public class SetlistSearchForm implements SearchForm
{
    private SetlistList m_setlistList;
    private SetlistQueryBuilder m_queryBuilder;

    public SetlistSearchForm()
    {
        m_setlistList = new SetlistList();
        m_setlistList.setPage(1);
    }

    public SetlistList getSetlistList()
    {
        return m_setlistList;
    }

    public void setSetlistList(SetlistList setlistList)
    {
        m_setlistList = setlistList;
    }

    public SetlistQueryBuilder getQueryBuilder()
    {
        return m_queryBuilder;
    }

    public void setQueryBuilder(SetlistQueryBuilder queryBuilder)
    {
        m_queryBuilder = queryBuilder;
    }
}
