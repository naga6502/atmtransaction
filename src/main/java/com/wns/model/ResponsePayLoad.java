package com.wns.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponsePayLoad {
                private Object data;
                private boolean status = true;
                private String errorMessage;

                public ResponsePayLoad() {
                  //for future implementations
                }

                public ResponsePayLoad(boolean status, Object data, String errorMessage) {
                                this.status = status;
                                this.data = data;
                                this.errorMessage = errorMessage;
                }

                public ResponsePayLoad(Object data) {
                                this.data = data;
                }

                public ResponsePayLoad(boolean status, String errorMessage) {
                                this.status = status;
                                this.errorMessage = errorMessage;
                }

                public Object getData() {
                                return data;
                }

                public void setData(Object data) {
                                this.data = data;
                }

                public boolean getStatus() {
                                return status;
                }

                public void setStatus(boolean status) {
                                this.status = status;
                }

                public String getErrorMessage() {
                                return errorMessage;
                }

                public void setErrorMessage(String errorMessage) {
                                this.errorMessage = errorMessage;
                }

                public static ResponsePayLoad prepareResponsePayLoad(Object data) {
                                return new ResponsePayLoad(data);
                }

                public static ResponsePayLoad prepareErrorPayLoad(String errorMessage) {
                                return new ResponsePayLoad(false, errorMessage);
                }

                public static ResponsePayLoad prepareEmptyPayLoad(Object data, String warningMessage) {
                                return new ResponsePayLoad(true, data, warningMessage);
                }
}
