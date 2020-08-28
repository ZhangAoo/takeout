package com.all.vo;

import lombok.Data;

@Data
public class PageVO<T> {
    private T content;
    private Long size;
    private Long total;
}
