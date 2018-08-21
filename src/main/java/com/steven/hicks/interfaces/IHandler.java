package com.steven.hicks.interfaces;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

public interface IHandler<T extends SearchForm>
{

    <T extends SearchForm> String search(T searchForm, BindingResult result, ModelMap model);


}
