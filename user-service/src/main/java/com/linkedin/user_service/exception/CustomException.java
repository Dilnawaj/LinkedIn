package com.linkedin.user_service.exception;

/*
 *  ***********************************************************************
 *  * 83incs CONFIDENTIAL
 *  * ***********************************************************************
 *  *
 *  *  [2017] - [2026] 83incs Ltd.
 *  *  All Rights Reserved.
 *  *
 *  * NOTICE:  All information contained herein is, and remains
 *  * the property of 83incs Ltd, IoT83 Ltd, its suppliers (if any), its subsidiaries (if any) and
 *  * Source Code Licensees (if any).  The intellectual and technical concepts contained
 *  * herein are proprietary to 83incs Ltd, IoT83 Ltd, its subsidiaries (if any) and
 *  * Source Code Licensees (if any) and may be covered by U.S. and Foreign Patents,
 *  * patents in process, and are protected by trade secret or copyright law.
 *  * Dissemination of this information or reproduction of this material
 *  * is strictly forbidden unless prior written permission is obtained
 *  * from 83incs Ltd or IoT83 Ltd.
 *  ****************************************************************************
 *
 */



import lombok.Data;

import java.time.LocalDateTime;

/**
 * The type Base url exception.
 */
@Data
public class CustomException extends RuntimeException {
    /**
     * The Code.
     */
    private final int code;
    /**
     * The Message.
     */
    private final String message;

    private LocalDateTime timeStamp;


    /**
     * Instantiates a new Base url exception.
     *
     * @param code    the code
     * @param message the message
     */


    public CustomException(int code, String message) {
        this.code = code;
        this.timeStamp = LocalDateTime.now();
        this.message = message;
    }
}