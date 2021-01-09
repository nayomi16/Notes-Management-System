package lk.company.notesmanagementAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class NoteArchive {

    @Id
    @Column(name = "note_id")
    private String noteId;
    private String description;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Temporal(TemporalType.DATE)
    private Date archiveDate;




}
