package com.theladders.gwt.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.theladders.gwt.client.place.HomePlace;
import com.theladders.gwt.client.place.WelcomePlace;

public class HomeViewImpl extends Composite implements HomeView {
  private static HelloViewImplUiBinder uiBinder = GWT.create(HelloViewImplUiBinder.class);

  interface HelloViewImplUiBinder extends UiBinder<Widget, HomeViewImpl> {
  }

  @UiField
  TopPanelViewImpl topPanel;
  @UiField
  SimplePanel contentView;
  @UiField
  Anchor welcomePathLink;
  @UiField
  Anchor browseJobsLink;
  @UiField
  Anchor uploadResumeLink;

  private Presenter presenter;

  public HomeViewImpl() {
    initWidget(uiBinder.createAndBindUi(this));
  }

  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }

  @UiHandler("welcomePathLink")
  void onClickWelcome(ClickEvent e) {
    presenter.goTo(new WelcomePlace("Test"));
  }

  @UiHandler("browseJobsLink")
  void onClickBrowseJobs(ClickEvent e) {
    presenter.goTo(new HomePlace("hello"));
  }

  @UiHandler("uploadResumeLink")
  void onClickUpLoadResume(ClickEvent e) {
    Window.alert("Upload Resume!");
  }

  @Override
  public void setContentView(Widget widget) {
    contentView.clear();
    contentView.add(widget);
  }

  @Override
  public SimplePanel getDisplay() {
    return contentView;
  }
}
