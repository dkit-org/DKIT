package org.dkit.fxclient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContainerDTO{
    private String id;
    private String name;
    private String status;
}
