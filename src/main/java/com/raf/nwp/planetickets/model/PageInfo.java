package com.raf.nwp.planetickets.model;

import lombok.Data;

@Data
public class PageInfo {
    private int maxPages;
    private int currPage;
    private int tixPerPage;
}
