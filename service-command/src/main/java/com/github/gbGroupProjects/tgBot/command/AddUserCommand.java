package com.github.gbGroupProjects.tgBot.command;
import com.github.gbGroupProjects.tgBot.dao.CategoryDao;
import com.github.gbGroupProjects.tgBot.dao.UserDao;
import com.github.gbGroupProjects.tgBot.model.User;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Service
public class AddUserCommand implements Command {

    public final static String REGUSER_MESSAGE = "Registering new user";

    private UserDao userDao;

    public AddUserCommand(UserDao u) {
        this.userDao = u;
    }

    public boolean isUserTelegramIdUnique(long TelegramId) {
        try {
            return userDao.isUserTelegramIdUnique(TelegramId);
        }  catch (Exception var6) {
           String mes = var6.getLocalizedMessage();
        }
        return false;
    }

    public User getUserByTelegramId(long TelegramId) {
        return userDao.getUserByTelegramId(TelegramId);
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

