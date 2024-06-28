package com.malikov.learningcentercrm.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Group extends BaseModel {
    private String name;
    private UUID courseID;
    private UUID mentorID;
}
