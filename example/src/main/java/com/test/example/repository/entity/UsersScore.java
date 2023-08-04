package com.test.example.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersScore {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;
  
  @Column(nullable = false)
  private Long number;
  
  @Column(nullable = false)
  private String userId;
  
  @Column(nullable = false)
  private Long deposit;
  
  @Column(nullable = false, columnDefinition = "integer default 0")
  private Integer score;
}
