package com.treloc.sesizari.view;

import com.treloc.sesizari.api.PrimarieApi;
import com.treloc.sesizari.dto.SesizareDTO;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route()
public class WebView extends VerticalLayout {


    public WebView() {
        TextField searchField = new TextField("Here");
        Text text =  new Text("Welcome to MainView.");
        Button button = new Button("Search");
        button.addClickListener(event -> text.setText("Welcome to MainView." + searchField.getValue()) );
        add(searchField, button);

        add(text);

        PrimarieApi primarieApi = new PrimarieApi();

        Grid<SesizareDTO> grid = new Grid<>(SesizareDTO.class);
        grid.setItems(primarieApi.get());

        grid.removeColumnByKey("ticketnumber");

// The Grid<>(Person.class) sorts the properties and in order to
// reorder the properties we use the 'setColumns' method.
        grid.setColumns("titlu", "description", "isedited",
                "categoryid", "latitude", "longitude", "createdon", "status", "resolvereason" );
        add(grid);
    }
}