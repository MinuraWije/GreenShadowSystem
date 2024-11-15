package org.example.greenshadowsystem.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.entity.SuperEntity;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "fielded_staff")
public class FieldedStaff implements SuperEntity {
    @EmbeddedId
    private FieldedStaffID fieldedStaffID;
    private Date date;
    @Enumerated(EnumType.STRING)
    private Availability status;
    @ManyToOne
    @MapsId("staffId")
    @JoinColumn(name = "staffId", referencedColumnName = "staffId")
    private StaffEntity staff;
    @ManyToOne
    @MapsId("fieldCode")
    @JoinColumn(name = "fieldCode", referencedColumnName = "fieldCode")
    private FieldEntity field;
}
