package com.github.gbGroupProjects.tgBot.command;

import com.github.gbGroupProjects.tgBot.dao.CategoryDao;
//import com.github.gbGroupProjects.tgBot.model.Category;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class AddCategoryCommand implements Command {
    private CategoryDao categoryDao;

    public AddCategoryCommand(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public String execute(Update update) {
        return "";
    }
}
