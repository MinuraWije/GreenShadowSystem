package org.example.greenshadowsystem.customStatusCodes;

import com.example.NotesCollector_V2.dto.NoteStatus;
import com.example.NotesCollector_V2.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.greenshadowsystem.dto.VehicleStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedCustomErrorStatus implements VehicleStatus{
    private int statusCode;
    private String statusMessage;
}
