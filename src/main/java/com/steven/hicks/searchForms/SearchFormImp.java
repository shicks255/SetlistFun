package com.steven.hicks.searchForms;

public class SearchFormImp
{
    public ArtistSearchForm m_artistSearchForm;
    public SetlistSearchForm m_setlistSearchForm;
    public VenueSearchForm m_venueSearchForm;



    public SearchFormImp()
    {
        m_artistSearchForm = new ArtistSearchForm();
        m_setlistSearchForm = new SetlistSearchForm();
        m_venueSearchForm = new VenueSearchForm();
    }
}
