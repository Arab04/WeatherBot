package com.SringFramework.TelegramLongPollingBot;


import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;



public class Controller extends TelegramLongPollingBot{

	private Model model = new Model();
	
	public String getBotUsername() {
		return "weatherpro4_bot";
	}

	@Override
	public String getBotToken() {
		return "1313211090:AAGdyKRHUGdv2OIULn-z8wvMM6m1Om5UzIg";
	}
	
	public void onUpdateReceived(Update update) {
		Message message = update.getMessage();
		String name = update.getMessage().getChat().getFirstName();
		String userSurname = update.getMessage().getChat().getLastName();
		String userName = update.getMessage().getChat().getUserName();
		long id = update.getMessage().getChatId();
		
		
		if(message!=null && message.hasText()) {
			switch(message.getText()) {
			
			case "/start":
				sendMessage(message,"hello "+name+"\n this is weather Bot please type the name of the City",id);
				break;
				
			default:
				try {
					sendMessage(message, UrlConnector.request(message.getText(),model), id);
					DataBase.data(name, userSurname, userName, message.getText());
				} catch (Exception e) {
					e.printStackTrace();
					sendMessage(message,"Not found City",id);
				}
					
			}
		}
		
	}
	
	public void sendMessage(Message message, String text,long id) {
		SendMessage m = new SendMessage();
		m.enableMarkdown(true);
		m.setChatId(id);
		m.setReplyToMessageId(message.getMessageId());
		m.setText(text);
		
		try {
			execute(m);
		}
		
		catch(TelegramApiException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
