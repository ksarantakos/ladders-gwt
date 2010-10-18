package com.theladders.gwt.client.place;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.theladders.gwt.client.ClientFactory;
import com.theladders.gwt.client.ui.WelcomeView;

public class WelcomeActivity extends AbstractActivity implements WelcomeView.Presenter {
  private ClientFactory clientFactory;

  public WelcomeActivity(ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    WelcomeView view = clientFactory.getWelcomeView();
    panel.setWidget(view.asWidget());
    view.setPresenter(this);
  }

  @Override
  public void goTo(Place place) {
    clientFactory.getPlaceController().goTo(place);
  }

}
