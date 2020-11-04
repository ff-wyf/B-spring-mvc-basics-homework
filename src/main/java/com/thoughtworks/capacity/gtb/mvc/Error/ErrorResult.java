package com.thoughtworks.capacity.gtb.mvc.Error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResult {

    private String errorCode;
    private String message;
}
