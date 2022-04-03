package com.stan.dal.pojo;

import java.io.Serializable;
import java.util.Date;

public class BookDO implements Serializable {
    private Long id;

    private String bookName;

    private String author;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public BookDO(Long id, String bookName, String author, Date createTime) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.createTime = createTime;
    }

    public BookDO() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bookName=").append(bookName);
        sb.append(", author=").append(author);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}