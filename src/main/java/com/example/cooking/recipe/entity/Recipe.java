package com.example.cooking.recipe.entity;

import com.example.cooking.category.entity.Category;
import com.example.cooking.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Recipe {
    @Id
    private Integer id;
    private String name;
    private Integer duration;
    @ManyToMany
    private List<Category> categoryId;
    @ManyToMany
    private List<User> userId;
}
