package leo.umc.apiPayload.exception.handler;

import leo.umc.apiPayload.code.BaseErrorCode;
import leo.umc.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
