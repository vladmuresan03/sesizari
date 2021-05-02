package com.treloc.sesizari.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SesizareDTO {

    String ticketnumber;
    String titlu;
    String description;
    String isedited;
    String category;
    String categoryid;
    String latitude;
    String longitude;
    String createdon;
    String status;
    String resolvereason;
}
