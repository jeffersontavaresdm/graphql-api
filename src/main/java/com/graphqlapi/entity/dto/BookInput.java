package com.graphqlapi.entity.dto;

public record BookInput(String title, String publisher, Long authorId) { }