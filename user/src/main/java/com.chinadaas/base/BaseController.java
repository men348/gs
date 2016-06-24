package com.chinadaas.base;

import com.chinadaas.dto.CommonDTO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xie on 16/6/23.
 */
public class BaseController {

    protected Object getErrorDTO(BindingResult result) {
        CommonDTO dto = new CommonDTO();
        List<FieldError> errors = result.getFieldErrors();
        Map<String, String> errorMap = new LinkedHashMap<String, String>();
        StringBuilder msg = new StringBuilder();
        for (FieldError fieldError : errors) {
            if (msg.indexOf(fieldError.getDefaultMessage()) < 0) {
                msg.append(fieldError.getDefaultMessage());
                msg.append(".");
                msg.append("\n");
            }

            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return dto.setError(errorMap).setCode(400).setMsg(msg.toString()).toDTO();
    }


    protected Object getSuccessDTO(String name, Object data) {
        return new CommonDTO().setAttribute(name, data).toDTO();
    }

    protected Object getSuccessDTO() {
        return new CommonDTO().toDTO();
    }
}
