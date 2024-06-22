package com.rating_backend.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private int id;
    private String name;
    private String location;
    private String about;

}
