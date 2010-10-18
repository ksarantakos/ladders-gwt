package com.theladders.gwt.client.ui.pager;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.AbstractPager;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.HasRows;
import com.google.gwt.view.client.Range;

public class JobPager extends AbstractPager {
  interface Binder extends UiBinder<Widget, JobPager> {
  }

  private static PagerResources DEFAULT_RESOURCES;

  private static PagerResources getDefaultResources() {
    if (DEFAULT_RESOURCES == null) {
      DEFAULT_RESOURCES = GWT.create(PagerResources.class);
    }
    return DEFAULT_RESOURCES;
  }

  @UiField
  SpanElement totalResults;

  @UiField
  Anchor paginationBack;

  @UiField
  Anchor paginationForward;

  private static Binder binder = GWT.create(Binder.class);

  public JobPager() {
    initWidget(binder.createAndBindUi(this));
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
    totalResults.setInnerText(createText());
  }

  protected String createText() {
    // Default text is 1 based.
    NumberFormat formatter = NumberFormat.getFormat("#,###");
    HasRows display = getDisplay();
    Range range = display.getVisibleRange();
    int pageStart = range.getStart() + 1;
    int pageSize = range.getLength();
    int dataSize = display.getRowCount();
    int endIndex = Math.min(dataSize, pageStart + pageSize - 1);
    endIndex = Math.max(pageStart, endIndex);
    boolean exact = display.isRowCountExact();
    return formatter.format(pageStart) + "-" + formatter.format(endIndex) + (exact ? " of " : " of over ")
        + formatter.format(dataSize);
  }

}
