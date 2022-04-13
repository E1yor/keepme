package uz.wiut.keepme.dto;

import lombok.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ResponseDto<T> implements Serializable {
    private T data;
    private Boolean success;
    private NamingDto message;

    public ResponseDto(){
        this.success = Boolean.FALSE;
    }

}
