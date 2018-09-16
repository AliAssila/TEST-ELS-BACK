package com.devtest.els.test.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
/**
 * A Salaried.
 */
@Document
public class Salaried {

    @Id
    private String id;

    private String fullname;

    private String address;

    private String category;

    private String description;

    public Salaried() {
        // Constructors
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salaried)) return false;
        Salaried salaried = (Salaried) o;
        return new EqualsBuilder().append(id, salaried.id)
                .append(fullname, salaried.fullname)
                .append(category, salaried.category)
                .append(address, salaried.address)
                .append(description, salaried.description).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(16, 32).append(id).append(fullname).append(category)
                .append(address).append(description).toHashCode();
    }

    @Override
    public String toString() {
        return "Salaried{" +
                "id='" + id + '\'' +
                ", fullname='" + fullname + '\'' +
                ", address='" + address + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
