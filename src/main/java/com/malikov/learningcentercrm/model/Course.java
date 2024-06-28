package com.malikov.learningcentercrm.model;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course extends BaseModel{
    private String name;
    private String description;
    private Double price;

    public static Course map(ResultSet resultSet) throws SQLException {
        Course course = Course.builder()
                .name(resultSet.getString("name"))
                .description(resultSet.getString("description"))
                .price(resultSet.getDouble("price"))
                .build();
        course.setID(UUID.fromString(resultSet.getString("id")));
        return course;
    }
}
