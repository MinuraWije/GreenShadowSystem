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
@Table(name = "crop_log")
public class CropLog implements SuperEntity {
    @EmbeddedId
    private CropLogID cropLogID;
    private Date date;
    @ManyToOne
    @MapsId("logCode")
    @JoinColumn(name = "logCode", referencedColumnName = "logCode")
    private LogEntity log;
    @ManyToOne
    @MapsId("cropCode")
    @JoinColumn(name = "cropCode", referencedColumnName = "cropCode")
    private CropEntity crop;
}
