package com.steven.hicks.tags;

import com.steven.hicks.beans.ItemList;
import com.steven.hicks.searchForms.ArtistSearchForm;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Pagination extends TagSupport
{
    private ItemList listItem;
    private ArtistSearchForm m_searchForm;

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
                    out.print("<b><a href=\"" + pageContext.getServletContext().getContextPath() + "artist/search?pageNumber=" + i + "\">" + i + "</a></b>");
                else
                    out.print(i);
            }

            out.print(">>");

            out.flush();
        }
        catch (IOException e)
        {

        }


        return SKIP_BODY;
    }


    public ArtistSearchForm getSearchForm()
    {
        return m_searchForm;
    }

    public void setSearchForm(ArtistSearchForm searchForm)
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
