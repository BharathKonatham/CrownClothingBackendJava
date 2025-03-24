package dev.Legends.runnerZ.crwnClothing.Categories;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcCategoryRepository {


    private  static final Logger log = LoggerFactory.getLogger(JdbcCategoryRepository.class);
    private final JdbcClient jdbcClient;

    public JdbcCategoryRepository(JdbcClient jdbcClient) {

        this.jdbcClient = jdbcClient;
    }

    public List<Category> findAll(){

        return jdbcClient.sql("select * from categories").query(Category.class).list();
    }


    public Optional<Category> findById(Integer id){
        return jdbcClient.sql("SELECT id,title,image_url FROM categories WHERE id=:id")
                .param("id", id)
                .query(Category.class)
                .optional();
    }

    public Category create(Category category){
        var updated = jdbcClient.sql("INSERT INTO categories (id, title, image_url) VALUES (?,?,?)")
                .params(List.of(category.id(),category.title(),category.image_url()))
                .update();

        Assert.state(updated == 1,"failed to create run"+category.title());
        return category;
    }

    void upDate(Category category, Integer id){
        var updated = jdbcClient.sql("update categories set title=?,image_url=? where id=? ")
                .params(List.of(category.title(), category.image_url(),id))
                .update();
        System.out.println(updated);
        Assert.state(updated ==1,"failed to update run "+category.title());
    }

    void delete(Integer id){
        var updated = jdbcClient.sql("delete from categories where id=:id")
                .param("id",id)
                .update();
        Assert.state(updated ==1,"failed to delete Category"+id);

    }

    public int count(){

        return jdbcClient.sql("SELECT COUNT (*) FROM categories").query().listOfRows().size();
    }

    public  void saveAll(List<Category> categories){
//        categories.stream().forEach(this::create);

    }
//    public List<Run> findName(String name){
//        return jdbcClient.sql("select * from categories where title=:title")
//                .param("title",name)
//                .query(Run.class)
//                .list();
//    }
}
