package com.lugew.winsimcloud.ppt.domain;

import com.lugew.winsim.entity.PageEntity;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends PageEntity {
    private String name;
    private String number;
    private Integer age;
    private String cc;
    private String a;
    private String b;
    private String c;
    private String d;
    private String device;
    private LocalDateTime preDateTime;
    private LocalDateTime postDateTime;
    private LocalDateTime opgDateTime;
    private LocalDateTime finalOpgDateTime;
    private LocalDateTime cephDateTime;
    private LocalDateTime finalCephDateTime;
}
