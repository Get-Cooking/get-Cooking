package com.example.cooking.step.entity;

import com.example.cooking.recipe.entity.Recipe;
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
public class Step {

    @Id
    private Integer id;
    @ManyToMany
    private List<Recipe> recipeId;
    private String detail;
    private String name;
    private int order;
}
