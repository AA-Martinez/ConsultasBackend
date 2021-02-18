package com.nash;

public class GlobalVariables {

    static public Integer APPOINTMENT_OPEN_STATUS = 0;
    static public Integer APPOINTMENT_IN_PROCCESS_STATUS = 1;
    static public Integer APPOINTMENT_CLOSED_STATUS = 2;

    static public Integer NEW_APPOINTMENT_EVENT_TYPE = 0;
    static public Integer NEW_DOCTOR_IN_APPOINTMENT_EVENT_TYPE = 1;
    static public Integer DOCTOR_CREATES_NEW_TREATMENT_EVENT_TYPE = 2;
    static public Integer PATIENT_FINISHES_TREATMENT_EVENT_TYPE = 3;
    static public Integer PATIENT_UPLOADS_FILES_EVENT_TYPE = 4;
    static public Integer DOCTOR_UPLOADS_FILES_EVENT_TYPE = 5;
    static public Integer COMPANY_UPLOADS_FILES_EVENT_TYPE = 6;
    static public Integer PATIENT_CLOSES_APPOINTMENT_EVENT_TYPE = 7;
    static public Integer SYSTEM_CLOSES_APPOINTMENT_EVENT_TYPE = 8;
}
