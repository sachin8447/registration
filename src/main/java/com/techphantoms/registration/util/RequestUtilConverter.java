package com.techphantoms.registration.util;

import com.techphantoms.registration.entity.prms.RequestDetail;
import com.techphantoms.registration.modal.request.RequestModel;

import java.time.LocalDateTime;

public class RequestUtilConverter {
    public static RequestDetail convertRequestModelToRequestDetail(RequestModel requestModel) {
        RequestDetail requestDetail = new RequestDetail();
        requestDetail.setRequestDetailGuid(CommonUtil.getUUID());
        requestDetail.setFileNumber(CommonUtil.generateUniqueFileNumber());
        requestDetail.setDataXml(JAXBUtil.convertObjectToXml(requestModel,RequestModel.class));
        requestDetail.setDataJson(JSONUtil.convertObjectToJson(requestModel));
        requestDetail.setFormContentUri("");
        requestDetail.setSubmittedDate(LocalDateTime.now());
        requestDetail.setIsSubmitted(true);
        requestDetail.setSubmittedByGuid("");
        requestDetail.setIsActive(true);
        requestDetail.setCreatedBy("");
        requestDetail.setCreatedDate(LocalDateTime.now());
        requestDetail.setCreatedIpAddr(CommonUtil.getIpClientIpAddress());
        requestDetail.setCreatorRemarks("NEW");
        return requestDetail;
    }
}
