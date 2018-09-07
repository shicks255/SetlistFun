package com.steven.hicks.searchForms;

import com.steven.hicks.beans.SetlistList;
import com.steven.hicks.interfaces.SearchForm;
import com.steven.hicks.logic.queryBuilders.SetlistQueryBuilder;

public class SetlistSearchForm implements SearchForm
{
    public SetlistList m_setlistList;
    public SetlistQueryBuilder m_queryBuilder;
}
