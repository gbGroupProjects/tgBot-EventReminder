package com.github.gbGroupProjects.tgBot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class EventReminderTelegramBot extends TelegramLongPollingBot {
    @Value("${bot.username}")
    private String username;
    @Value("${bot.token}")
    private String token;

    public void onUpdateReceivedText(Update update) {
        String message = update.getMessage().getText().trim();
       // String commandIdentifier = message.split(" ")[0].toLowerCase();
        String responseMessage = "auto-reply (1.01): " + message;
        sendMessage(update, responseMessage);
    }

    @Override
    public void onUpdateReceived(Update update) {
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
