package com.theladders.gwt.client.ui.pager;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.AbstractPager;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasRows;
import com.google.gwt.view.client.Range;

public class JobPager extends AbstractPager {
  interface Binder extends UiBinder<Widget, JobPager> {
  }

  @UiField
  SpanElement pageStart;
  @UiField
  SpanElement endIndex;
  @UiField
  SpanElement dataSize;

  @UiField
  ListBox pageSize;

  @UiField
  Anchor paginationBack;

  @UiField
  Anchor fastIndex1;
  @UiField
  Anchor fastIndex2;
  @UiField
  Anchor fastIndex3;
  @UiField
  Anchor fastIndex4;
  @UiField
  Anchor fastIndex5;

  @UiField
  Anchor paginationForward;

  private static Binder binder = GWT.create(Binder.class);

  public JobPager() {
    initWidget(binder.createAndBindUi(this));
    pageSize.setItemSelected(1, true);
  }

  @UiHandler("pageSize")
  void handlePageSize(ChangeEvent e) {
    setPageSize(Integer.parseInt(pageSize.getValue(pageSize.getSelectedIndex())));
  }

  @UiHandler("paginationBack")
  void handleBack(ClickEvent e) {
    previousPage();
  }

  @UiHandler("paginationForward")
  void handleForward(ClickEvent e) {
    nextPage();
  }

  @Override
  protected void onRangeOrRowCountChanged() {
    createText();
    resetQuickPageAnchors();
  }

  private void resetQuickPageAnchors() {
    // TODO Auto-generated method stub
    
  }

  protected void createText() {
    // Default text is 1 based.
    NumberFormat formatter = NumberFormat.getFormat("#,###");
    HasRows display = getDisplay();
    Range range = display.getVisibleRange();
    int pageStart = range.getStart() + 1;
    int pageSize = range.getLength();
    int dataSize = display.getRowCount();
    int endIndex = Math.min(dataSize, pageStart + pageSize - 1);
    endIndex = Math.max(pageStart, endIndex);

    this.pageStart.setInnerText(formatter.format(pageStart));
    this.endIndex.setInnerText(formatter.format(endIndex));
    this.dataSize.setInnerText(formatter.format(dataSize));
  }

}
