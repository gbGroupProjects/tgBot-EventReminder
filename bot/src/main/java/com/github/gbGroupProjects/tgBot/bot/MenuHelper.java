package com.github.gbGroupProjects.tgBot.bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

/*
    пока набросок... todo: продумать релаизацию интерфейса по кнопкам
 */
public class MenuHelper {
    public static void sendMessageKbd(EventReminderTelegramBot bot, Update update, String text) {
        String message_text = update.getMessage().getText();
        long chat_id = update.getMessage().getChatId();
        //if (update.getMessage().getText().equals("/start")) {

        SendMessage message = new SendMessage(); // Create a message object object
        message.setChatId(update.getMessage().getChatId().toString());
        message.setText("You send " + text);
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline = new ArrayList<>();
        InlineKeyboardButton k1 = new InlineKeyboardButton();
        k1.setText("Подписаться");
        k1.setCallbackData("Подписаться");

        //k1.oneTimeKeyboard(true)   // optional
        //    .resizeKeyboard(true)    // optional
        //          selective(true);        // optional
        rowInline.add(k1);
        InlineKeyboardButton k2 = new InlineKeyboardButton();
        k2.setText("Отписаться");
        k2.setCallbackData("Отписаться");
        //k1.oneTimeKeyboard(true)   // optional
        //    .resizeKeyboard(true)    // optional
        //    .selective(true);        // optional
        rowInline.add(k2);

        // Set the keyboard to the markup
        rowsInline.add(rowInline);
        // Add it to the message
        markupInline.setKeyboard(rowsInline);
        message.setReplyMarkup(markupInline);
        try {
            bot.execute(message); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        //}
    }
}
