package uz.wiut.keepme.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class NamingDto implements Serializable {
    private String name_en;
    private String name_ru;
    private String name_uz_latn;
    private String name_uz_cyrl;
}
