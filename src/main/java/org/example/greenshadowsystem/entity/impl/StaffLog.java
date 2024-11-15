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
@Table(name = "staff_log")
public class StaffLog implements SuperEntity {
    @EmbeddedId
    private StaffLogID staffLogID;
    private Date date;
    @ManyToOne
    @MapsId("staffId")
    @JoinColumn(name = "staffId", referencedColumnName = "staffId")
    private StaffEntity staff;
    @ManyToOne
    @MapsId("logCode")
    @JoinColumn(name = "logCode", referencedColumnName = "logCode")
    private StaffEntity logCode;
}
