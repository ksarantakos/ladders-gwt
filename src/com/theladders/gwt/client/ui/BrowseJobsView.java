package com.theladders.gwt.client.ui;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface BrowseJobsView extends IsWidget {
  void setPresenter(Presenter presenter);

  public interface Presenter {
    void goTo(Place place);
  }
}
