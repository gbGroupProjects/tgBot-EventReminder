package com.github.gbGroupProjects.tgBot.command;
import com.github.gbGroupProjects.tgBot.dao.CategoryDao;
import com.github.gbGroupProjects.tgBot.dao.UserDao;
import com.github.gbGroupProjects.tgBot.model.Event;
import com.github.gbGroupProjects.tgBot.model.User;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.List;

/*
 реализация диалога с польователем
 */
@Service
public class UserCommand implements Command {

    public final static String REGUSER_MESSAGE = "Answer to user";

    private final UserDao userDao;

    public UserCommand(UserDao u) {
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
    public List<Event> getAllUserEventsA(int userId) { return null; } // todo:  перенести в Эвенты?? userDao.getAllUserEvents(userId);  }

    @Override
    public String execute(Update update) {
        Long TelegramId = update.getMessage().getFrom().getId();


        return "answer";
    }
}

