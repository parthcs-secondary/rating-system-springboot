package com.rating_backend.rating.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ratings")
public class Ratings {

    @Id
    private String ratingId;
    private int userId;
    private int hotelId;
    private int rating;
    private String feedback;
}
