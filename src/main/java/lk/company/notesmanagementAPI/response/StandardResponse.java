package lk.company.notesmanagementAPI.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StandardResponse {
    private int code;
    private String message;
    private Object data;


}

