/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techm.adms.dt.web;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author KA43822
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.techm.adms.dt.web.ProjectService.class);
        resources.add(com.techm.adms.dt.web.MediaService.class);
        resources.add(com.techm.adms.dt.web.MediaDocumentsService.class);
        resources.add(com.techm.adms.dt.web.ObservationService.class);
        resources.add(com.techm.adms.dt.web.EmpathyHmwQuestionsService.class);
        resources.add(com.techm.adms.dt.web.IdeaService.class);
        resources.add(com.techm.adms.dt.web.IdeaFeedbackService.class);
        resources.add(com.techm.adms.dt.web.IdeaGroupService.class);
        resources.add(com.techm.adms.dt.web.PrototypeService.class);
        resources.add(com.techm.adms.dt.web.PrototypeFeedbackService.class);
        resources.add(com.techm.adms.dt.web.LoginService.class);
        resources.add(com.techm.adms.dt.web.UserAuthenticationService.class);
        resources.add(com.techm.adms.dt.web.NeedsOrInsightsService.class);
        resources.add(com.techm.adms.dt.web.EmpathyService.class);
        resources.add(com.techm.adms.dt.web.AssignIdeaGroupService.class);
        resources.add(com.techm.adms.dt.web.AssignHMWService.class);
        resources.add(com.techm.adms.dt.web.UploadService.class);
        resources.add(com.techm.adms.dt.web.RoleManagementService.class);
    }
    
}
