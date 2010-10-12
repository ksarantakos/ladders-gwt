package com.theladders.gwt.client.place;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.theladders.gwt.client.ClientFactory;
import com.theladders.gwt.client.ui.HelloView;

public class HelloActivity extends AbstractActivity implements
		HelloView.Listener {
	// Used to obtain views, eventBus, placeController
	// Alternatively, could be injected via GIN
	private ClientFactory clientFactory;
	// Name that will be appended to "Hello,"
	private String name;

	public interface HelloListener {
		void goTo(Place place);
	}

	public HelloActivity(HelloPlace place, ClientFactory clientFactory) {
		this.name = place.getHelloName();
		this.clientFactory = clientFactory;
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		HelloView helloView = clientFactory.getHelloView();
		helloView.setName(name);
		helloView.setListener(this);
		containerWidget.setWidget(helloView.asWidget());
	}

	/**
	 * Ask user before stopping this activity
	 */
	@Override
	public String mayStop() {
		return "Please hold on. This activity is stopping.";
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}

}