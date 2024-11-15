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
@Table(name = "field_log")
public class FieldLog implements SuperEntity {
    @EmbeddedId
    private FieldLogID fieldLogID;
    private Date date;
    @ManyToOne
    @MapsId("fieldCode")
    @JoinColumn(name = "fieldCode", referencedColumnName = "fieldCode")
    private FieldEntity field;
    @ManyToOne
    @MapsId("logCode")
    @JoinColumn(name = "logCode", referencedColumnName = "logCode")
    private LogEntity log;
}
