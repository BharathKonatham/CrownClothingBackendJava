package dev.Legends.runnerZ.crwnClothing.Categories;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity(name = "categories")
public class CategoryEntity {
    @Id
    @Column(name = "id")
    @SequenceGenerator(
            name = "category_seq_generator",
            sequenceName = "category_seq",     // actual DB sequence name
            allocationSize = 1             // increment by 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "caetegory_seq_generator")
    private Integer id;
    @Column(name = "title", length = 100, nullable = false)
    private String title;
    @Column(name = "image_url", length = 500)
    private String imageUrl;

    public CategoryEntity() {
    }

    public CategoryEntity(Integer id, String title, String imageUrl) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
