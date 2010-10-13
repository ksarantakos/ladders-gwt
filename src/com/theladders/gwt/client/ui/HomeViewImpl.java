package com.theladders.gwt.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class HomeViewImpl extends Composite implements HomeView {
  private static HelloViewImplUiBinder uiBinder = GWT.create(HelloViewImplUiBinder.class);

  interface HelloViewImplUiBinder extends UiBinder<Widget, HomeViewImpl> {
  }

  // @UiField
  // TopPanelViewImpl topPanel;
  // @UiField
  // NavPanelViewImpl navPanel;
  // @UiField
  // WelcomeViewImpl welcome;

  private Listener listener;

  public HomeViewImpl() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public void setListener(Listener listener) {
    this.listener = listener;
  }

}
