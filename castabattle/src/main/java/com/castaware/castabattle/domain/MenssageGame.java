package com.castaware.castabattle.domain;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class MenssageGame {
	 
    //Main code
    public void saveMessage(String status) {
    	
    	String message = status;
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage(message));
    }
    
}
