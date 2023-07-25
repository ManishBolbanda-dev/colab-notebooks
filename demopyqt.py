import sys
from PyQt5.QtWidgets import QApplication, QMainWindow, QTextEdit, QLineEdit, QVBoxLayout, QPushButton, QWidget


class ChatBotSimulator(QMainWindow):
    def __init__(self):
        super().__init__()

        self.init_ui()

        # Dictionary to store user inputs and bot responses
        self.conversation = {
            "hello": "Hello! How can I assist you?",
            "how are you": "I'm just a chat bot, but thanks for asking!",
            "bye": "Goodbye! Have a great day!",
            "default": "I'm sorry, I don't understand that. Please try again.",
        }

    def init_ui(self):
        self.setWindowTitle('Chat Bot Simulator')
        self.setGeometry(300, 200, 400, 500)

        # Create a text widget to display the conversation
        self.text_widget = QTextEdit(self)
        self.text_widget.setReadOnly(True)

        # Create an input field for the user to type messages
        self.input_field = QLineEdit(self)

        # Create a "Send" button to send user messages
        self.send_button = QPushButton("Send", self)
        self.send_button.clicked.connect(self.process_user_input)

        # Create a layout to arrange the widgets
        layout = QVBoxLayout()
        layout.addWidget(self.text_widget)
        layout.addWidget(self.input_field)
        layout.addWidget(self.send_button)

        # Create a central widget to set the layout
        central_widget = QWidget()
        central_widget.setLayout(layout)
        self.setCentralWidget(central_widget)

    def process_user_input(self):
        user_input = self.input_field.text().strip().lower()

        # Clear the input field
        self.input_field.clear()

        # Get the bot response from the conversation dictionary
        bot_response = self.conversation.get(user_input, self.conversation["default"])

        # Append the user's message and bot's response to the text widget
        self.text_widget.append(f"User: {user_input}")
        self.text_widget.append(f"Bot: {bot_response}")

    def show_message(self, message):
        self.text_widget.append(f"Bot: {message}")


if __name__ == '__main__':
    app = QApplication(sys.argv)
    window = ChatBotSimulator()
    window.show()
    sys.exit(app.exec_())
