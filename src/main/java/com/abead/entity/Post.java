package com.abead.entity;

import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/4/25 15:36
 */
@Alias("Post")
public class Post {
    private int id;
    private String subject;
    private Author author;
    private List<Comment> comments;
    private List<Tag> tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
