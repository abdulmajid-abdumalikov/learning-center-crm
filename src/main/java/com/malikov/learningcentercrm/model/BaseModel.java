package com.malikov.learningcentercrm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseModel {
    private UUID ID;
    private LocalDateTime createdAt;
}
