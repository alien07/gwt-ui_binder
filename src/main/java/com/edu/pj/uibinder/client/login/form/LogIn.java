/**
 * 
 */
package com.edu.pj.uibinder.client.login.form;

import com.edu.pj.uibinder.client.generic.CancelClickedEvent;
import com.edu.pj.uibinder.client.generic.LogInClickedEvent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialTextBox;

/**
 * @author mprajak
 *
 */
public class LogIn extends Composite {

	private static LogInUiBinder uiBinder = GWT.create(LogInUiBinder.class);

	private LogInPresenter presenter;

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

	public MaterialImage getImgProfile() {
		return imgProfile;
	}

	public void setImgProfile(MaterialImage imgProfile) {
		this.imgProfile = imgProfile;
	}

	public MaterialTextBox getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(MaterialTextBox txtEmail) {
		this.txtEmail = txtEmail;
	}

	public MaterialTextBox getTxtPwd() {
		return txtPwd;
	}

	public void setTxtPwd(MaterialTextBox txtPwd) {
		this.txtPwd = txtPwd;
	}

	public MaterialButton getBtnLogIn() {
		return btnLogIn;
	}

	public void setBtnLogIn(MaterialButton btnLogIn) {
		this.btnLogIn = btnLogIn;
	}

	public MaterialButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(MaterialButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public LogInPresenter getPresenter() {
		return presenter;
	}

	public void setPresenter(LogInPresenter presenter) {
		this.presenter = presenter;
	}

	// // ======================Ordered Handler===============

	@UiHandler("btnLogIn")
	void onClickLogin(ClickEvent e) {
		presenter.getEventBus().fireEvent(new LogInClickedEvent());
	}

	@UiHandler({ "btnCancel", "btnLogIn" })
	void onClickClear(ClickEvent e) {
		presenter.getEventBus().fireEvent(new CancelClickedEvent());
	}

}
