package com.github.gbGroupProjects.tgBot.command;
import com.github.gbGroupProjects.tgBot.dao.CategoryDao;
import com.github.gbGroupProjects.tgBot.dao.UserDao;
import com.github.gbGroupProjects.tgBot.model.User;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;


@Service
public class AddUserCommand implements Command {

    public final static String REGUSER_MESSAGE = "Registering new user";

    private UserDao userDao;

    public AddUserCommand(UserDao u) {
        this.userDao = u;
    }

    @Override
    public String execute(Update update) {

        //add category
        User user = new User();
 //       User.setUserName("");
  //      Integer idOfNewCategory;
  //      try {
  //          idOfNewCategory = addNewCategory(category);
  //      } catch (Exception ex) {
   //         return ADD_MESSAGE_CATEGORY_DB_ERROR; }
   //     return ADD_CATEGORY_MESSAGE + idOfNewCategory;

        return REGUSER_MESSAGE;
    }


}

