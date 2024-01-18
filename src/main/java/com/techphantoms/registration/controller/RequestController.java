package com.techphantoms.registration.controller;

import com.techphantoms.registration.modal.ReturnValue;
import com.techphantoms.registration.modal.request.RequestModel;
import com.techphantoms.registration.service.RequestProcessingService;
import com.techphantoms.registration.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @Autowired
    RequestProcessingService requestProcessingService;

    @PostMapping("/createNewRequest")
    public ReturnValue submitNewRequest(@ModelAttribute RequestModel requestModel){
        if(ValidationUtil.validateRequest(requestModel)){
           ReturnValue creationStatus =  requestProcessingService.createNewRequest(requestModel);
           return creationStatus;
        }else{
            return new ReturnValue(false,"Invalid Data");
        }
    }
}
