package dev.Legends.runnerZ.crwnClothing.Categories;



public class CategoryDTO {
    private Integer id;
    private String title;
    private String imageUrl;

    public CategoryDTO() {
    }

    public CategoryDTO(Integer id, String title, String imageUrl) {
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
