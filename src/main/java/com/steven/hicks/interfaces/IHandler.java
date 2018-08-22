package com.steven.hicks.interfaces;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

public interface IHandler<T extends SearchForm>
{

    public String search(Class<? extends SearchForm> searchForm, BindingResult result, ModelMap model);


}
