package com.techphantoms.registration.modal.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class RequestModel implements Serializable {
    private String emailId;
    private  String mobileNumber;
    private String queryDescription;
}
