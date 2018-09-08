package com.steven.hicks.tags;

import com.steven.hicks.beans.ItemList;
import com.steven.hicks.interfaces.SearchForm;
import com.steven.hicks.searchForms.ArtistSearchForm;
import com.steven.hicks.searchForms.SetlistSearchForm;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Pagination extends TagSupport
{
    private ItemList listItem;
    private SearchForm m_searchForm;

    @Override
    public int doStartTag()
    {

        try(JspWriter out = pageContext.getOut())
        {
            int numberOfItems = listItem.getTotal();
            int itemsPerPage = listItem.getItemsPerPage();
            int totalPages = numberOfItems / itemsPerPage;

            out.print("<<");

            for (int i = 1; i <= totalPages; i++)
            {
                if (i == listItem.getPage())
                {
                    if (m_searchForm instanceof ArtistSearchForm)
                        out.print("<b><a href=/artist/changePage?pageNumber=" + i + ">" + i + "</a></b>");
                    if (m_searchForm instanceof SetlistSearchForm)
                        out.print("<b><a href=/artist/changeSetlistPage?pageNumber=" + i + ">" + i + "</a></b>");
                }
                else
                {
                    if (m_searchForm instanceof ArtistSearchForm)
                        out.print("<a href=/artist/changePage?pageNumber=" + i + ">" + i + "</a>");
                    if (m_searchForm instanceof SetlistSearchForm)
                        out.print("<a href=/artist/changeSetlistPage?pageNumber=" + i + ">" + i + "</a>");
                }
            }

            out.print(">>");
            out.flush();
        }
        catch (IOException e)
        {

        }


        return SKIP_BODY;
    }


    public SearchForm getSearchForm()
    {
        return m_searchForm;
    }

    public void setSearchForm(SearchForm searchForm)
    {
        m_searchForm = searchForm;
    }

    public ItemList getListItem()
    {
        return listItem;
    }

    public void setListItem(ItemList listItem)
    {
        this.listItem = listItem;
    }
}
