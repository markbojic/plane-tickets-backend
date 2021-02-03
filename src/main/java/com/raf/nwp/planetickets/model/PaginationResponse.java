package com.raf.nwp.planetickets.model;

import lombok.Data;
import java.util.List;

@Data
public class PaginationResponse {
    private List<Ticket> tickets;
    private PageInfo pageInfo;
}
