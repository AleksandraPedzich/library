package com.pedzich.aleksandra.library.dto;

import com.pedzich.aleksandra.library.enums.Type;
import lombok.Data;

import java.util.List;

@Data
public class BookDTO {

    private Integer id;
    private String isbn;
    private String title;
    private Type type;
    private Integer authorId;
    private List<Integer> categoryIds;

    public BookDTO(String isbn, String title, Type type) {
        this.isbn = isbn;
        this.title = title;
        this.type = type;
    }
}
