package com.steven.hicks.searchForms;

public class SearchFormImp
{
    private ArtistSearchForm m_artistSearchForm;
    private SetlistSearchForm m_setlistSearchForm;
    private VenueSearchForm m_venueSearchForm;

    public SearchFormImp()
    {
        m_artistSearchForm = new ArtistSearchForm();
        m_setlistSearchForm = new SetlistSearchForm();
        m_venueSearchForm = new VenueSearchForm();
    }

    public ArtistSearchForm getArtistSearchForm()
    {
        return m_artistSearchForm;
    }

    public void setArtistSearchForm(ArtistSearchForm artistSearchForm)
    {
        m_artistSearchForm = artistSearchForm;
    }

    public SetlistSearchForm getSetlistSearchForm()
    {
        return m_setlistSearchForm;
    }

    public void setSetlistSearchForm(SetlistSearchForm setlistSearchForm)
    {
        m_setlistSearchForm = setlistSearchForm;
    }

    public VenueSearchForm getVenueSearchForm()
    {
        return m_venueSearchForm;
    }

    public void setVenueSearchForm(VenueSearchForm venueSearchForm)
    {
        m_venueSearchForm = venueSearchForm;
    }
}
