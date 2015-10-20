package com.edu.pj.uibinder.client.handler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;

public class LoginHanderler implements ClickHandler, Handler {

	public void onClick(ClickEvent event) {
		System.out.println("##onClick");
		// Window.alert(event.getSource() + " Clicked !");
	}

	public void onAttachOrDetach(AttachEvent event) {
		System.out.println(event.getSource() + " ##onAttachOrDetach");
	}

}
