package com.theladders.gwt.client.ui;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;
import com.theladders.gwt.client.content.ContactDatabase;
import com.theladders.gwt.client.content.ContactDatabase.Category;
import com.theladders.gwt.client.content.ContactDatabase.ContactInfo;

public class BrowseJobsViewImpl extends Composite implements BrowseJobsView {
  /**
   * The UiBinder interface used by this example.
   */

  interface Binder extends UiBinder<Widget, BrowseJobsViewImpl> {
  }

  /**
   * The main CellTable.
   */

  @UiField(provided = true)
  CellTable<ContactInfo> cellTable;

  /**
   * The pager used to change the range of data.
   */

  @UiField(provided = true)
  SimplePager pager;

  public BrowseJobsViewImpl() {
    // Create a CellTable.
    cellTable = new CellTable<ContactInfo>();

    // Create a Pager to control the table.
    SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
    pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
    pager.setDisplay(cellTable);

    // Add a selection model so we can select cells.
    final MultiSelectionModel<ContactInfo> selectionModel = new MultiSelectionModel<ContactInfo>();
    cellTable.setSelectionModel(selectionModel);

    // Initialize the columns.
    initTableColumns(selectionModel);

    // Set a key provider that provides a unique key for each contact. If key is
    // used to identify contacts when fields (such as the name and address)
    // change.
    // cellTable.setKeyProvider(ContactDatabase.ContactInfo.KEY_PROVIDER);
    // selectionModel.setKeyProvider(ContactDatabase.ContactInfo.KEY_PROVIDER);

    // Add the CellList to the adapter in the database.
    ContactDatabase.get().addDataDisplay(cellTable);

    // Create the UiBinder.
    Binder uiBinder = GWT.create(Binder.class);
    initWidget(uiBinder.createAndBindUi(this));
  }

  /**
   * Add the columns to the table.
   */
  private void initTableColumns(final SelectionModel<ContactInfo> selectionModel) {
    // Checkbox column. This table will uses a checkbox column for selection.
    // Alternatively, you can call cellTable.setSelectionEnabled(true) to enable
    // mouse selection.
    Column<ContactInfo, Boolean> checkColumn = new Column<ContactInfo, Boolean>(new CheckboxCell(true)) {
      @Override
      public Boolean getValue(ContactInfo object) {
        // Get the value from the selection model.
        return selectionModel.isSelected(object);
      }
    };
    checkColumn.setFieldUpdater(new FieldUpdater<ContactInfo, Boolean>() {
      public void update(int index, ContactInfo object, Boolean value) {
        // Called when the user clicks on a checkbox.
        selectionModel.setSelected(object, value);
      }
    });
    cellTable.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br>"));

    // First name.
    Column<ContactInfo, String> firstNameColumn = new Column<ContactInfo, String>(new EditTextCell()) {
      @Override
      public String getValue(ContactInfo object) {
        return object.getFirstName();
      }
    };
    cellTable.addColumn(firstNameColumn, "First Name");
    firstNameColumn.setFieldUpdater(new FieldUpdater<ContactInfo, String>() {
      public void update(int index, ContactInfo object, String value) {
        // Called when the user changes the value.
        object.setFirstName(value);
        ContactDatabase.get().refreshDisplays();
      }
    });

    // Last name.
    Column<ContactInfo, String> lastNameColumn = new Column<ContactInfo, String>(new EditTextCell()) {
      @Override
      public String getValue(ContactInfo object) {
        return object.getLastName();
      }
    };
    cellTable.addColumn(lastNameColumn, "Last Name");
    lastNameColumn.setFieldUpdater(new FieldUpdater<ContactInfo, String>() {
      public void update(int index, ContactInfo object, String value) {
        // Called when the user changes the value.
        object.setLastName(value);
        ContactDatabase.get().refreshDisplays();
      }
    });

    // Category.
    final Category[] categories = ContactDatabase.get().queryCategories();
    List<String> categoryNames = new ArrayList<String>();
    for (Category category : categories) {
      categoryNames.add(category.getDisplayName());
    }
    SelectionCell categoryCell = new SelectionCell(categoryNames);
    Column<ContactInfo, String> categoryColumn = new Column<ContactInfo, String>(categoryCell) {
      @Override
      public String getValue(ContactInfo object) {
        return object.getCategory().getDisplayName();
      }
    };
    cellTable.addColumn(categoryColumn, "Category");
    categoryColumn.setFieldUpdater(new FieldUpdater<ContactInfo, String>() {
      public void update(int index, ContactInfo object, String value) {
        for (Category category : categories) {
          if (category.getDisplayName().equals(value)) {
            object.setCategory(category);
          }
        }
        ContactDatabase.get().refreshDisplays();
      }
    });

    // Address.
    cellTable.addColumn(new Column<ContactInfo, String>(new TextCell()) {
      @Override
      public String getValue(ContactInfo object) {
        return object.getAddress();
      }
    }, "Address");
  }
}
