package com.edu.pj.uibinder.client.login.form;

import com.edu.pj.uibinder.client.generic.CancelClickedEvent;
import com.edu.pj.uibinder.client.generic.LogInClickedEvent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.google.web.bindery.event.shared.binder.EventBinder;
import com.google.web.bindery.event.shared.binder.EventHandler;

import gwt.material.design.client.ui.MaterialLoader;

public class LogInPresenter {
	interface MyEventBider extends EventBinder<LogInPresenter> {
	}

	private static final MyEventBider eventBinder = GWT.create(MyEventBider.class);

	private final EventBus eventBus;
	private LogIn view;
	private HandlerRegistration eventRegistration;

	public LogInPresenter(LogIn view, EventBus eventBus) {
		this.view = view;
		view.setPresenter(this);
		this.eventBus = eventBus;
	}

	/**
	 * Causes this presenter to start listening for events on the event bus.
	 * This method should be called when this presenter becomes the active
	 * presenter.
	 */
	public void start(final HasWidgets container) {
		// It's also possible to bind handlers in the constructor. This is
		// useful for presenters that
		// should always be listening for events.
		eventRegistration = eventBinder.bindEventHandlers(this, eventBus);
		container.add(view);
	}

	/**
	 * Causes this presenter to stop listening for the events on the event bus.
	 * This method should be called when this presenter is no longer active.
	 */
	public void stop() {
		eventRegistration.removeHandler();
	}

	public EventBus getEventBus() {
		return eventBus;
	}

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
	@EventHandler
	void onClickLogin(LogInClickedEvent event) {
		System.out.println("##onClickLogin @EventHandler");
		view.getTxtEmail().setValue("test event");
		view.getTxtPwd().clear();
		onShowNavBarProgress();
	}

	@EventHandler
	void onClickClear(CancelClickedEvent event) {
		System.out.println("##onClickClear @EventHandler");
		view.getTxtEmail().clear();
		view.getTxtPwd().clear();
	}

}
