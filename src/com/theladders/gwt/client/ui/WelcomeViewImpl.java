package com.theladders.gwt.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.theladders.gwt.client.ui.HomeView.Presenter;

public class WelcomeViewImpl extends Composite implements WelcomeView {
  interface Binder extends UiBinder<Widget, WelcomeViewImpl> {
  }

  private static final Binder binder = GWT.create(Binder.class);

  private Presenter presenter;

  public WelcomeViewImpl() {
    initWidget(binder.createAndBindUi(this));
  }

  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }
}
