package lk.company.notesmanagementAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note implements Serializable {

    @Id
    @Column(name = "note_id")
    private String noteId;
    private String description;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Temporal(TemporalType.DATE)
    private Date date;



}
