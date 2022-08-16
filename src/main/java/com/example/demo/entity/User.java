package com.example.demo.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String email;
    private String companyname;
    private Integer yoe;
    private String title;
    private String ctc;
    private String base;
    private String cityname;
    private String wlb;
    private String question;
    @CreationTimestamp
    private Date createdDate;
    @UpdateTimestamp
    private Date updatedDate;

}