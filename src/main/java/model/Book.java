package model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.Transient;
// import java.time.Instant;



@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)
    private String title;
    private Float price;
    private String description;
    private String isbn;
    private Integer nbOfPages;
    private Boolean illustrations;
    @Enumerated(EnumType.STRING)
    private BookCategory category;
    @ElementCollection
    private List<String> tags = new ArrayList<>();

    public List<String> setTags(String string){
        tags.add(string);
        return tags;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<String> removeTag(String tag){
        tags.remove(tag);
        return tags;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public BookCategory getCategory() {
        return category;
    }

    // @Transient
    // private Instant instant;
    // public void setInstant(){
    //     this.instant = Instant.now();
    // }
    // public Instant getInstant() {
    //     return instant;
    // }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public Float getPrice() {
        return price;
    }
    
    public void setPrice(Float price) {
        this.price = price;
    }
    
    public String getDescription() {
        return description;
    
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public Integer getNbOfPages() {
        return nbOfPages;
    }
    
    public void setNbOfPages(Integer nbOfPages) {
        this.nbOfPages = nbOfPages;
    }
    
    public Boolean getIllustrations() {
        return illustrations;
    }
    
    public void setIllustrations(Boolean illustrations) {
        this.illustrations = illustrations;
    }
    
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", price=" + price + ", description=" + description + ", isbn="
                + isbn + ", nbOfPages=" + nbOfPages + ", illustrations=" + illustrations + "]";
    }
}

