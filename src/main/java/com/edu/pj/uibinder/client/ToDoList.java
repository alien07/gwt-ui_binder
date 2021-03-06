package com.edu.pj.uibinder.client;

import com.edu.pj.uibinder.client.login.form.LogIn;
import com.edu.pj.uibinder.client.login.form.LogInPresenter;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.SimpleEventBus;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ToDoList implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	private final Messages messages = GWT.create(Messages.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		SimpleEventBus eventBus = new SimpleEventBus();
		LogIn loginView = new LogIn();
		LogInPresenter logInPresenter = new LogInPresenter(loginView, eventBus);
		// loginView.setPresenter(logInPresenter);
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		// RootPanel.get("nameFieldContainer").add(loginView);
		// RootPanel.get("sendButtonContainer").add(sendButton);
		// RootPanel.get("errorLabelContainer").add(errorLabel);
		// Start listening for events in the presenter
		logInPresenter.start(RootPanel.get("nameFieldContainer"));
	}
}
