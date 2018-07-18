package com.abead.entity;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/4/25 15:42
 */
@Alias("Blog")
public class Blog {
    private int id;
    private String title;
    private Author author;
    private List<Post> posts;



    public Blog(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
