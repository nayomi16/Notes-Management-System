package lk.company.notesmanagementAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class NoteArchiveDto {
    private String noteId;
    private String description;
    private String userId;
    private Date archivedDate;

}
