package com.rixar.payments.common.exceptions;

import com.rixar.payments.common.codes.RespCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RixarRuntimeException extends RuntimeException {

    RespCode responseCode;

    boolean printStackTrace;

    public RixarRuntimeException() {
        super("Exception during processing");
        this.printStackTrace = false;
    }

    public RixarRuntimeException(String msg) {
        super(msg);
        this.printStackTrace = false;
    }

    public RixarRuntimeException(String msg, boolean printStackTrace) {
        super(msg);
        this.printStackTrace = printStackTrace;
    }

    public RixarRuntimeException(String message, RespCode respCode) {
        super(message);
        this.responseCode = respCode;
        this.printStackTrace = false;
    }

    public RixarRuntimeException(String message, RespCode respCode, boolean printStackTrace) {
        super(message);
        this.responseCode = respCode;
        this.printStackTrace = printStackTrace;
    }




}
