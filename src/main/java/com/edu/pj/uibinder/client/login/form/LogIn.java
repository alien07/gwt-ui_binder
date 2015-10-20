/**
 * 
 */
package com.edu.pj.uibinder.client.login.form;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLoader;
import gwt.material.design.client.ui.MaterialTextBox;

/**
 * @author mprajak
 *
 */
public class LogIn extends Composite {

	private static LogInUiBinder uiBinder = GWT.create(LogInUiBinder.class);

	@UiTemplate("LogIn.ui.xml")
	interface LogInUiBinder extends UiBinder<Widget, LogIn> {

	}

	public LogIn() {
		initWidget(uiBinder.createAndBindUi(this));
		imgProfile.setType("circle");
	}

	@UiField
	MaterialImage imgProfile;

	@UiField
	MaterialTextBox txtEmail;

	@UiField
	MaterialTextBox txtPwd;

	@UiField
	MaterialButton btnLogIn;

	@UiField
	MaterialButton btnCancel;

	// ====================== Method ===============

	void onShowNavBarProgress() {
		MaterialLoader.showLoading(true);
		Timer t = new Timer() {

			@Override
			public void run() {
				MaterialLoader.showLoading(false);
			}
		};
		t.schedule(3000);
	}

	// ====================== Handler ===============
	@UiHandler("btnLogIn")
	void onClickLogin(ClickEvent e) {
		System.out.println("##onClickLogin");
		txtEmail.setValue("test event");
		txtPwd.clear();
		onShowNavBarProgress();
	}

	@UiHandler({ "btnCancel", "btnLogIn" })
	void onClickClear(ClickEvent e) {
		System.out.println("##onClickClear");
		txtEmail.clear();
		txtPwd.clear();
	}

}
