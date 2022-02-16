package com.github.gbGroupProjects.tgBot.command;
import com.github.gbGroupProjects.tgBot.dao.CategoryDao;
import com.github.gbGroupProjects.tgBot.dao.UserDao;
import com.github.gbGroupProjects.tgBot.model.Event;
import com.github.gbGroupProjects.tgBot.model.User;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.List;

@Service
public class AddUserCommand implements Command {

    public final static String REGUSER_MESSAGE = "Registering new user";

    private UserDao userDao;

    public AddUserCommand(UserDao u) {
        this.userDao = u;
    }

    public boolean isUserTelegramIdUnique(long TelegramId) {
        return userDao.isUserTelegramIdUnique(TelegramId);
/*        try {
//            List<User> lst  = userDao.findAllUsers();
            return userDao.isUserTelegramIdUnique(TelegramId);
        }  catch (Exception var6) {
           String mes = var6.getLocalizedMessage();
        }
        return false;  */
    }

    public User getUserByTelegramId(long TelegramId) {
        return userDao.getUserByTelegramId(TelegramId);
    }

    public List<User> getAllUsers() {
        return userDao.findAllUsers();
    }
    public List<Event> getAllUserEvents(int userId) { return userDao.getAllUserEvents(userId);  }

    @Override
    public String execute(Update update) {
        //add category
        User user = new User();
        user.setTelegramId(update.getMessage().getFrom().getId());
        user.setName(update.getMessage().getFrom().getUserName());
        Integer idOfNewUser;
        try {
            idOfNewUser = userDao.addUser(user);
            return "user {"+update.getMessage().getFrom().getId()+"}: new id" + idOfNewUser + " Ok!";
        } catch (Exception ex) {
            return "Error add user ("+update.getMessage().getFrom().getId()+"):" + ex.getLocalizedMessage();
        }
        //return REGUSER_MESSAGE;
    }

}

