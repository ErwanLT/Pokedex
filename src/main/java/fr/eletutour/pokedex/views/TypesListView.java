package fr.eletutour.pokedex.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import fr.eletutour.pokedex.model.Type;
import fr.eletutour.pokedex.service.PokemonService;

@Route(value = "types", layout = MainView.class)
@PageTitle(value = "Types")
public class TypesListView extends VerticalLayout {

    Grid<Type> grid = new Grid<>(Type.class);
    PokemonService pokemonService;

    public TypesListView(PokemonService pokemonService){
        this.pokemonService = pokemonService;
        setSizeFull();
        configureGrid();
        add(getContent());
        updateList();
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }


    private void updateList() {
        grid.setItems(pokemonService.findAllTypes());
    }

    private void configureGrid() {
        grid.addClassNames("contact-grid");
        grid.setSizeFull();
        grid.setColumns("name");

        grid.addComponentColumn(type ->
        {
            Image img = new Image(type.getImage(), type.getName());
            img.setHeight(40, Unit.PIXELS);
            img.setWidth(40, Unit.PIXELS);
            return img;
        }).setHeader("Sprite");

        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }
}
