package leo.umc.apiPayload.exception.handler;

import leo.umc.apiPayload.code.BaseErrorCode;
import leo.umc.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}