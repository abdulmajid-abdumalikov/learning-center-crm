package com.malikov.learningcentercrm.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Student extends BaseModel {
    private String name;
    private String phone;
    private UUID groupID;
}
