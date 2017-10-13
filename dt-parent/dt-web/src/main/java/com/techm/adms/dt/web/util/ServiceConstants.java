package com.techm.adms.dt.web.util;

/**
 * This interface is used to define Whale Service component constants
 * S001_MESSAGE_DESC
 * 
 * @CreatedBy TechM
 * @CreatedOn 07-Oct-2015 10:33:48 am
 */
public interface ServiceConstants {
    String PROJECT_SAVE_SUCCESS = "S1001";
    String PROJECT_DELETE_SUCCESS = "S1002";
    String PROJECT_SAVE_ERROR = "E1001";
    

    String MESSAGE_TYPE_SUCCESS = "success";
    String MESSAGE_TYPE_FAIL = "danger";
    String ERROR_TYPE = "E";
    // Temporary User
    String TEMP_USER = "User";

    // Wire List Constants
    String CONTENT_DISPOSITION = "content-disposition";
    String ATTACHMENT_FILENAME = "attachment; filename = ";
    String CACHE_CONTROL = "Cache-Control";
    String CACHE_STORE_REVALIDATE = "no-cache, no-store, must-revalidate";
    String CACHE_STORE = "no-cache, no-store";
    String PRAGMA = "Pragma";
    String NO_CACHE = "no-cache";
    String EXPIRES = "Expires";
    String TEXT_HTML = "text/html";
    
    int OBSERVATION_CATEGORY_DO_ID = 1;
    int OBSERVATION_CATEGORY_SAY_ID = 2;
    int OBSERVATION_CATEGORY_THINK_ID = 3;
    int OBSERVATION_CATEGORY_FEEL_ID = 4;
    
    String OBSERVATION_CATEGORY_SAY = "Say";
    String OBSERVATION_CATEGORY_DO = "DO";
    String OBSERVATION_CATEGORY_FEEL = "Feel";
    String OBSERVATION_CATEGORY_THINK = "Think";

}
