package com.techphantoms.registration.service;

import com.techphantoms.registration.modal.ReturnValue;
import com.techphantoms.registration.modal.request.RequestModel;
import org.springframework.stereotype.Service;

@Service
public interface RequestProcessingService {
    ReturnValue createNewRequest(RequestModel requestModel);
}
