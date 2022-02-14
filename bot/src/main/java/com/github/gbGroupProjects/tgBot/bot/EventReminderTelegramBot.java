package com.github.gbGroupProjects.tgBot.bot;

import com.github.gbGroupProjects.tgBot.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
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
            String responseMessage = command.execute(update);
            sendMessage(update, responseMessage);
        //} else {
        //    sendMessageKbd(update, message);
        //}
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
