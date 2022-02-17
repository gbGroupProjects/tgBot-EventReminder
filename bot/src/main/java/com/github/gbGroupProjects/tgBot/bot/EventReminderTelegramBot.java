package com.github.gbGroupProjects.tgBot.bot;

import com.github.gbGroupProjects.tgBot.command.Command;
import com.github.gbGroupProjects.tgBot.model.Event;
import com.github.gbGroupProjects.tgBot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.toIntExact;

@Component
public class EventReminderTelegramBot extends TelegramLongPollingBot {
    @Value("${bot.username}")
    private String username;
    @Value("${bot.token}")
    private String token;

    private CommandContainer  commandContainer;

    @Autowired
    EventReminderTelegramBot(CommandContainer  commandContainer) {
        this.commandContainer = commandContainer;
    }

    public void onUpdateReceivedText(Update update) {
        String message = update.getMessage().getText().trim();
        String commandIdentifier = message.split(" ")[0].toLowerCase();
        //String responseMessage = "auto-reply (1.02): " + message;
        //if (!update.getMessage().getText().equals("/menu")) {
            Command command = commandContainer.defineCommand(commandIdentifier);
            String responseMessage = update.getMessage().getFrom().getId() + ":" + command.execute(update);

            sendMessage(update, responseMessage);
        //} else {
        //    sendMessageKbd(update, message);
        //}
        sendMessage(update, responseMessage);
    }

    //@Override
    public void _onUpdateReceived(Update update) {
        long userTelegramId = update.getMessage().getFrom().getId();
        if (commandContainer.getUserCommand().isUserTelegramIdUnique(userTelegramId)) {  // 1915453131
            String sResult = commandContainer.getUserCommand().execute(update);
            sendMessage(update, "+" + sResult + ">" );

     //       User u = commandContainer.getUserCommand().getUserByTelegramId(userTelegramId);
        } else {
       //     User u = commandContainer.getUserCommand().getUserByTelegramId(userTelegramId);
       //     sendMessage(update, "" + u.getName() + ">" );
        }

        //User user = commandContainer.getUserByTelegramId(userTelegramId);
        sendMessage(update, "" + getListUsers() + "" );

        if (update.hasMessage()) {
            if (update.getMessage().hasText()) {
                onUpdateReceivedText(update);
            } else if (update.hasCallbackQuery()) {
                String call_data = update.getCallbackQuery().getData();
                long message_id = update.getCallbackQuery().getMessage().getMessageId();
                long chat_id = update.getCallbackQuery().getMessage().getChatId();

            }
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            String telID = update.getMessage().getFrom().getId().toString();
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if (true || update.getMessage().getText().equals("/start")) {
                SendMessage message = new SendMessage(); // Create a message object object
                message.setChatId(update.getMessage().getChatId().toString());
                message.setText(telID + "> You send /start");
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                InlineKeyboardButton m = new InlineKeyboardButton();
                m.setText("Узнать события");
                m.setCallbackData("Действие_Кнопка_1");
                rowInline.add(m);
                InlineKeyboardButton m2 = new InlineKeyboardButton();
                m2.setText("Настройки");
                m2.setCallbackData("Действие_Кнопка_Настройки");
                rowInline.add(m2);
                InlineKeyboardButton m3 = new InlineKeyboardButton();
                m3.setText("Удалить(ся)");
                m3.setCallbackData("Действие_Кнопка_Удалиться");
                rowInline.add(m3);

                // Set the keyboard to the markup
                rowsInline.add(rowInline);
                // Add it to the message
                markupInline.setKeyboard(rowsInline);
                message.setReplyMarkup(markupInline);
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {

            }
        } else if (update.hasCallbackQuery()) {
            // Set variables
            String call_data = update.getCallbackQuery().getData();
            long message_id = update.getCallbackQuery().getMessage().getMessageId();
            long chat_id = update.getCallbackQuery().getMessage().getChatId();

            if (call_data.equals("Действие_Кнопка_1")) {
                String telID = update.getCallbackQuery().getFrom().getId().toString();
                String answer = telID + "> Событий на сегодня нет..";
                EditMessageText new_message = new EditMessageText();
                new_message.setChatId(update.getCallbackQuery().getMessage().getChatId().toString());
                new_message.setMessageId(toIntExact(message_id));
                new_message.setText(answer);

                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                InlineKeyboardButton m = new InlineKeyboardButton();
                m.setText("Ok");
                m.setCallbackData("Действие_Кнопка_OK");
                rowInline.add(m);
                InlineKeyboardButton m2 = new InlineKeyboardButton();
                m2.setText("Не может быть!!");
                m2.setCallbackData("Действие_Кнопка_НД");
                rowInline.add(m2);

                // Set the keyboard to the markup
                rowsInline.add(rowInline);
                // Add it to the message
                markupInline.setKeyboard(rowsInline);
                new_message.setReplyMarkup(markupInline);

                try {
                    execute(new_message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (call_data.equals("Действие_Кнопка_Настройки")) {
                upSend(update, "settings", message_id);
            } else if (call_data.equals("Действие_Кнопка_Удалиться")) {
                upSend(update, "удаляемся....\n" + getListUsers() , message_id);
            } else {
                upSend(update, "def: ok!", message_id);
            }
        }
    }

    private void upSend(Update update, String text, long message_id) {
        String telID = update.getCallbackQuery().getFrom().getId().toString();
        String answer = telID + ">" +text;
        EditMessageText new_message = new EditMessageText();
        new_message.setChatId(update.getCallbackQuery().getMessage().getChatId().toString());
        new_message.setMessageId(toIntExact(message_id));
        new_message.setText(answer);
        try {
            execute(new_message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    private String getListUsers() {
        List<User> ls = commandContainer.getUserCommand().getAllUsers();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--users---\n");
        for (User uu:ls ) {
            stringBuilder.append("[" + uu.getUserId() + "],{" + uu.getTelegramId() + "}," + uu.getName() + "\n");
        }
        return stringBuilder.toString() + "";
    }
    private String getListUserEvents(int userId) {
        List<Event> ls = commandContainer.getUserCommand().getAllUserEvents(userId);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-events of user ["+userId+"]---\n");
        for (Event ev:ls ) {
            stringBuilder.append("[" + ev.getEventId() + "],{" + ev.getDateOfEvent().toString() + "}," + ev.getCommentToDo() + "\n");
        }
        return stringBuilder.toString() + "";
    }

    private void sendMessage(Update update, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.enableHtml(true);
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            //todo add logging to the project.
            e.printStackTrace();
        }
    }
    @Override
    public String getBotUsername() {
        return username;
    }
    @Override
    public String getBotToken() {
        return token;
    }
}
