package com.steven.hicks.tags;

import com.steven.hicks.beans.ItemList;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Pagination extends TagSupport
{
    private ItemList listItem;

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
                    out.print("<b>" + i + "</b>");
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






    public ItemList getListItem()
    {
        return listItem;
    }

    public void setListItem(ItemList listItem)
    {
        this.listItem = listItem;
    }
}
