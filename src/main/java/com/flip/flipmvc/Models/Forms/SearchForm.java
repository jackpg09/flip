package com.flip.flipmvc.Models.Forms;

import javax.validation.constraints.NotNull;

public class SearchForm {

    @NotNull
    private String keyword;

    public SearchForm(){}

    public SearchForm(String keyword){
        this.keyword = keyword;
    }

    public String getKeyword() { return keyword; }

    public void setKeyword(String keyword) { this.keyword = keyword; }
}
