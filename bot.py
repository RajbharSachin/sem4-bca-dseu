import telebot

Token = "6388947069:AAERXihYIITrZ1kFJsP8lPq9tGq8IbIfL4o"

bot = telebot.TeleBot(Token)            

@bot.message_handler(['start'])
def start(message):
    bot.reply_to(message, "Welcome to CodeCraft")

bot.polling()

# to run  pip install pyTelegramBotAPI