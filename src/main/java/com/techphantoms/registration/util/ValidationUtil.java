package com.techphantoms.registration.util;

import com.techphantoms.registration.entity.prms.RequestDetail;
import com.techphantoms.registration.modal.request.RequestModel;

public class ValidationUtil {
    public static boolean validateRequest(RequestModel requestModel) {
        RequestDetail requestDetail = RequestUtilConverter.convertRequestModelToRequestDetail(requestModel);
        return true;
    }
}
