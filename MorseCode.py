#How it works: like an interactive game- first it takes you through the alphabet and you have to press the space bar according to the
#dots and dashes shown. Then it asks you if you want to continue learning the patterns or move on to a simple quiz. If you get anything
#wrong, you take the quiz again, then move on to different levels of the quiz- intermediate then advanced. The quizzes have morse to
#english and english to morse questions. Then the student moves on to encryption and decryption- starting with words then phrases
#then sentences

from pynput import keyboard
import time
import random

DOT_THRESHOLD = 0.1 
student = ""

Morse_Code_Dict = { 'A':'.-', 'B':'-...',
                    'C':'-.-.', 'D':'-..', 'E':'.',
                    'F':'..-.', 'G':'--.', 'H':'....',
                    'I':'..', 'J':'.---', 'K':'-.-',
                    'L':'.-..', 'M':'--', 'N':'-.',
                    'O':'---',  'P':'.--.', 'Q':'--.-',
                    'R':'.-.', 'S':'...', 'T':'-',
                    'U':'..-', 'V':'...-', 'W':'.--',
                    'X':'-..-', 'Y':'-.--', 'Z':'--..'
                    }

def greet() -> None:
    global student
    print("Welcome to Morse World! Please enter your name:")
    student = input()
    print(f"We are glad you chose us to help you learn Morse Code, {student}!")

def learn_morse_code():
    print("Let's learn Morse Code! We will give you each letter along with its Morse translation.")
    print("Please press the space bar- a quick press for a dot and a longer press for a dash.")
    for letter, code in Morse_Code_Dict.items():
        print(f"{letter}: {code}")
        time.sleep(2)  # Adjusted time for demo purposes

def beginner():
    all_questions = list(Morse_Code_Dict.keys())
    wrong_questions = all_questions.copy()
    
    while wrong_questions:
        right = 0
        wrong = 0
        current_questions = wrong_questions.copy()
        wrong_questions.clear()

        for _ in range(10):
            if not current_questions:
                break
            question = random.choice(current_questions)
            current_questions.remove(question)
            ans = Morse_Code_Dict[question]
            print(f"What is the Morse code for {question}?")
            input_code = record_morse_input() 
            if input_code == ans:
                right += 1
                print("Correct!")
            else:
                wrong += 1
                wrong_questions.append(question)
                print(f"Incorrect. The answer is {ans}")
        
        if wrong == 0:
            break
        else:
            print(f"You got {wrong} incorrect. Let's try this quiz again with those letters.")
    
    print("You got everything correct! Nice Job!")               

def intermediate():
    questions = {"SOS", "STAR", "MUSIC", "WORLD"}
    for question in questions:
        while True:
            print(f"Translate {question} into Morse Code")
            input_code = record_morse_input()
            if input_code == encrypt(question):
                print("Correct!")
                break
            else:
                print("Incorrect. Try again.")
    print("You got everything correct! Awesome Job!")

def advanced():
    phrase = "VIVA LAS VEGAS"
    print(f"Translate the phrase '{phrase}' into Morse code.")
    while True:
        user_input = record_morse_input()
        if user_input == encrypt(phrase):
            break
        else:
            print("Incorrect. Try again.")
    print("You got it right! You have now mastered Morse code.")

def quiz():
    print("There are three levels of this quiz. Let's start with the beginner one, where you will have to tap out Morse code for a corresponding letter.")
    beginner()
    print("In the intermediate quiz, you will have to translate words into Morse code.")
    intermediate()
    print("In the advanced quiz, we will truly test your knowledge of Morse code. You will have to translate a phrase.")
    advanced()

def encrypt(input_text):
    output = ""
    for letter in input_text:
        if letter != " ":
            output += Morse_Code_Dict[letter] + " "
        else:
            output += " "
    return output.strip()

def decrypt(input_text):
    output = ""
    input_text += " "
    letter = ""
    for symbol in input_text:
        if symbol != " ":
            letter += symbol
        else:
            if letter:
                if letter in Morse_Code_Dict.values():
                    output += list(Morse_Code_Dict.keys())[list(Morse_Code_Dict.values()).index(letter)]
                letter = ""
            else:
                output += " "
    return output

def record_morse_input():
    print("Use space bar for dot and a longer press for dash. Press '1' for space between letters. Press enter when done.")
    input_sequence = []
    start_time = None

    def on_press(key):
        nonlocal start_time
        if key == keyboard.Key.space:
            start_time = time.time()

    def on_release(key):
        nonlocal start_time, input_sequence
        if key == keyboard.Key.space:
            end_time = time.time()
            press_duration = end_time - start_time
            if press_duration < DOT_THRESHOLD:
                input_sequence.append(".")
                print(f"Recorded a dot. Press duration: {press_duration:.2f} seconds")
            else:
                input_sequence.append("-")
                print(f"Recorded a dash. Press duration: {press_duration:.2f} seconds")
        elif key == keyboard.KeyCode.from_char('1'):
            input_sequence.append(" ")
            print("Recorded a space.")
        elif key == keyboard.Key.enter:
            return False

    with keyboard.Listener(on_press=on_press, on_release=on_release) as listener:
        listener.join()

    return "".join(input_sequence)  

def interactive_learning_tool():
    greet()
    while True:
        print("What would you like to do today?")
        print("1. Learn Morse Code")
        print("2. Take the Morse Code quiz")
        print("3. Encrypt a message")
        print("4. Decrypt a message")
        print("5. Exit")
        choice = input()

        if choice == "1":
            learn_morse_code()
        elif choice == "2":
            quiz()
        elif choice == "3":
            print("Enter message to encrypt:")
            message = input()
            print("Encrypted message:", encrypt(message.upper()))
        elif choice == "4":
            print("Enter message to decrypt:")
            message = input()
            print("Decrypted message:", decrypt(message))
        elif choice == "5":
            print(f"Goodbye, {student}.")
            break
        else:
            print("Invalid choice. Try again.")

if __name__ == "__main__":
    interactive_learning_tool() 
