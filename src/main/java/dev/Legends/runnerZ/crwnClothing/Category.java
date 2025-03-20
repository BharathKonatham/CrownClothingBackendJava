package dev.Legends.runnerZ.crwnClothing;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Category(
        Integer id,
        String title,
        //@JsonProperty("imageUrl")
        String image_url

) {
}
