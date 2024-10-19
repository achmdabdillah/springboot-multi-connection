package com.template.demo.model.PostgresModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.template.demo.model.BaseModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "transaction")
@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true, value = { "created", "updated", "deleted", "hibernate_lazy_initializer" })
public class Transaction extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer activityCode;
    private String insertBy;
    private String insertDate;
}
