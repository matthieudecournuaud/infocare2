package com.backend.infocare.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Company.
 */
@Entity
@Table(name = "company")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @NotNull
    @Size(min = 10, max = 15)
    @Column(name = "phone", length = 15, nullable = false)
    private String phone;

    @NotNull
    @Size(min = 14, max = 14)
    @Column(name = "siret", length = 14, nullable = false)
    private String siret;

    @NotNull
    @Size(max = 50)
    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Size(max = 100)
    @Column(name = "email", length = 100)
    private String email;

    @Size(max = 100)
    @Column(name = "contact_person", length = 100)
    private String contactPerson;

    @Size(max = 15)
    @Column(name = "contact_person_phone", length = 15)
    private String contactPersonPhone;

    @Size(max = 100)
    @Column(name = "contact_person_email", length = 100)
    private String contactPersonEmail;

    @Size(max = 50)
    @Column(name = "size", length = 50)
    private String size;

    @Size(max = 500)
    @Column(name = "notes", length = 500)
    private String notes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "company", "ticket" }, allowSetters = true)
    private Set<Material> materials = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Company id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Company name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public Company phone(String phone) {
        this.setPhone(phone);
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSiret() {
        return this.siret;
    }

    public Company siret(String siret) {
        this.setSiret(siret);
        return this;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getAddress() {
        return this.address;
    }

    public Company address(String address) {
        this.setAddress(address);
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public Company email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactPerson() {
        return this.contactPerson;
    }

    public Company contactPerson(String contactPerson) {
        this.setContactPerson(contactPerson);
        return this;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactPersonPhone() {
        return this.contactPersonPhone;
    }

    public Company contactPersonPhone(String contactPersonPhone) {
        this.setContactPersonPhone(contactPersonPhone);
        return this;
    }

    public void setContactPersonPhone(String contactPersonPhone) {
        this.contactPersonPhone = contactPersonPhone;
    }

    public String getContactPersonEmail() {
        return this.contactPersonEmail;
    }

    public Company contactPersonEmail(String contactPersonEmail) {
        this.setContactPersonEmail(contactPersonEmail);
        return this;
    }

    public void setContactPersonEmail(String contactPersonEmail) {
        this.contactPersonEmail = contactPersonEmail;
    }

    public String getSize() {
        return this.size;
    }

    public Company size(String size) {
        this.setSize(size);
        return this;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getNotes() {
        return this.notes;
    }

    public Company notes(String notes) {
        this.setNotes(notes);
        return this;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set<Material> getMaterials() {
        return this.materials;
    }

    public void setMaterials(Set<Material> materials) {
        if (this.materials != null) {
            this.materials.forEach(i -> i.setCompany(null));
        }
        if (materials != null) {
            materials.forEach(i -> i.setCompany(this));
        }
        this.materials = materials;
    }

    public Company materials(Set<Material> materials) {
        this.setMaterials(materials);
        return this;
    }

    public Company addMaterial(Material material) {
        this.materials.add(material);
        material.setCompany(this);
        return this;
    }

    public Company removeMaterial(Material material) {
        this.materials.remove(material);
        material.setCompany(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Company)) {
            return false;
        }
        return getId() != null && getId().equals(((Company) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Company{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", phone='" + getPhone() + "'" +
            ", siret='" + getSiret() + "'" +
            ", address='" + getAddress() + "'" +
            ", email='" + getEmail() + "'" +
            ", contactPerson='" + getContactPerson() + "'" +
            ", contactPersonPhone='" + getContactPersonPhone() + "'" +
            ", contactPersonEmail='" + getContactPersonEmail() + "'" +
            ", size='" + getSize() + "'" +
            ", notes='" + getNotes() + "'" +
            "}";
    }
}
