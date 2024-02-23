package com.syntaxgenie.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceLink {

    private String referenceName;
    private String url;
    private Boolean isValidReferenceName;
    private Boolean isValidUrl;
}