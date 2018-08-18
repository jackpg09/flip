package com.flip.flipmvc.Models.Forms;

public class SearchForm {

    private String keyword = "Search";

    public SearchForm(){}

    public SearchForm(String keyword){
        this.keyword = keyword;
    }

    public String getKeyword() { return keyword; }

    public void setKeyword(String keyword) { this.keyword = keyword; }
}
