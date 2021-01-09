package lk.company.notesmanagementAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class NoteDto {
    private String noteId;
    private String description;
    private String userId;

}
