package com.theladders.gwt.client;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.theladders.gwt.client.ui.BrowseJobsView;
import com.theladders.gwt.client.ui.HomeView;
import com.theladders.gwt.client.ui.WelcomeView;

public interface ClientFactory {
  EventBus getEventBus();

  PlaceController getPlaceController();

  HomeView getHomeView();

  BrowseJobsView getBrowseJobsView();

  WelcomeView getWelcomeView();
}
