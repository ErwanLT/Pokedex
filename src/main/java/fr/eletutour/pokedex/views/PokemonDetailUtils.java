package fr.eletutour.pokedex.views;

import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class PokemonDetailUtils {

    public static VerticalLayout createLabelWithClassName(String text, String className) {
        VerticalLayout layout = new VerticalLayout(new H4(text));
        layout.addClassNames("type", "entete", className);
        return layout;
    }

    public static HorizontalLayout createEvolutionLayout(String evolutionType, String className) {
        HorizontalLayout layout = new HorizontalLayout(new H4(evolutionType));
        layout.addClassNames("type", className);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        layout.setWidthFull();
        return layout;
    }

    public static void addEvolutionStep(VerticalLayout evolutionLayout, String name, String spriteUrl, String condition, String className) {
        VerticalLayout evoStep = new VerticalLayout(FlexComponent.JustifyContentMode.CENTER);

        HorizontalLayout nameLayout = new HorizontalLayout(new H4(name));
        nameLayout.setWidthFull();
        nameLayout.addClassNames("type", className);
        nameLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        nameLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        HorizontalLayout spriteLayout = new HorizontalLayout();
        Image sprite = new Image(spriteUrl, name);
        spriteLayout.add(sprite);
        spriteLayout.setWidthFull();
        spriteLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        spriteLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        HorizontalLayout conditionLayout = new HorizontalLayout(new Span(condition));
        conditionLayout.setWidthFull();
        conditionLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        conditionLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        evoStep.add(nameLayout, spriteLayout, conditionLayout);
        evolutionLayout.add(evoStep);
    }
}
