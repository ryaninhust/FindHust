/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package com.stip.find.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BlueBerry
 */
@Entity
@Table(name = "user_hub")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserHub.findAll", query = "SELECT u FROM UserHub u"),
    @NamedQuery(name = "UserHub.findByUid", query = "SELECT u FROM UserHub u WHERE u.uid = :uid"),
    @NamedQuery(name = "UserHub.findByName", query = "SELECT u FROM UserHub u WHERE u.name = :name"),
    @NamedQuery(name = "UserHub.findByDepartment", query = "SELECT u FROM UserHub u WHERE u.department = :department"),
    @NamedQuery(name = "UserHub.findByMajor", query = "SELECT u FROM UserHub u WHERE u.major = :major"),
    @NamedQuery(name = "UserHub.findByClasses", query = "SELECT u FROM UserHub u WHERE u.classes = :classes")})
public class UserHub implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "uid")
    private String uid;
    @Size(max = 15)
    @Column(name = "name")
    private String name;
    @Size(max = 50)
    @Column(name = "department")
    private String department;
    @Size(max = 50)
    @Column(name = "major")
    private String major;
    @Size(max = 50)
    @Column(name = "classes")
    private String classes;

    public UserHub() {
    }

    public UserHub(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserHub)) {
            return false;
        }
        UserHub other = (UserHub) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.stip.find.entity.UserHub[ uid=" + uid + " ]";
    }
    
}
