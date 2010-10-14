package com.theladders.gwt.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.theladders.gwt.client.place.AppActivityMapper;
import com.theladders.gwt.client.place.AppPlaceHistoryMapper;
import com.theladders.gwt.client.place.HomePlace;
import com.theladders.gwt.client.ui.HomeView;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class LaddersGwt implements EntryPoint {
  private Place defaultPlace = new HomePlace("World!");
  private SimplePanel appWidget = new SimplePanel();

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    // Create ClientFactory using deferred binding so we can replace with
    // different
    // impls in gwt.xml
    ClientFactory clientFactory = GWT.create(ClientFactory.class);
    EventBus eventBus = clientFactory.getEventBus();
    PlaceController placeController = clientFactory.getPlaceController();
    HomeView homeView = clientFactory.getHomeView();
    
    // Start ActivityManager for the main widget with our ActivityMapper
    ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
    ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
    activityManager.setDisplay(homeView.getDisplay());

    // Start PlaceHistoryHandler with our PlaceHistoryMapper
    AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
    historyHandler.register(placeController, eventBus, defaultPlace);

    RootLayoutPanel.get().add(clientFactory.getHomeView());
    // Goes to place represented on URL or default place
    historyHandler.handleCurrentHistory();
  }
}
