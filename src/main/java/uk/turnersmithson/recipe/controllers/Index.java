package uk.turnersmithson.recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.turnersmithson.recipe.domain.Category;
import uk.turnersmithson.recipe.domain.UnitOfMeasure;
import uk.turnersmithson.recipe.repositories.CategoryRepository;
import uk.turnersmithson.recipe.repositories.UnitOfMeasureRepository;

import java.util.Optional;

@Controller
public class Index {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public Index(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription( "Cup" );

        System.out.println( "Category Id = " + categoryOptional.get().getId() );
        System.out.println( "Unit Of Measure  = " + unitOfMeasureOptional.get().getId() );
        return "index";
    }
}
