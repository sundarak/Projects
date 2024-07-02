"""Choose Your Own Adventure TSwift Style!"""

import random
player: str 
points: int
EMOJI = "U+1F917"

    
def lyric() -> None:
    """Finish the lyric game."""
    global player
    global points
    print(f"Your current points: {points}")
    playing: bool = True
    while playing:
        # Q1
        print("Finish the Lyric: Cuz darling I'm a nightmare dressed like a ___________")
        if input() == "daydream":
            print(f"You got it right, {player}!")
            points += 20
        else:
            print("Wrong answer!")
        print(f"Your Points: {points}")

        # Q2
        print("Finish the Lyric: I just wanted you to know, that this is me _______")
        if input() == "trying":
            print("Right again!")
            points += 20
        else:
            print("Wrong answer!")
        print(f"Your Points: {points}")
        
        # Q3
        print("Finish the Lyric: I once believed love would be burning red, but it's __________")
        if input() == "golden":
            print(f"You are on fire, {player}!")
            points += 20
        else:
            print("Wrong answer!")
        print(f"Your Points: {points}")
        
        # Q4 
        print("Finish the Lyric: Walls of insincerity, shifting eyes and __________")
        if input() == "vacancy":
            print(f"Enchanted is such a bop! Nice job, {player}.")
            points += 20
        else:
            print("Wrong answer!")
        print(f"Your Points: {points}")

        # Q5
        print("Finish the Lyric: Never be so polite, you forget your ____________")
        if input() == "power":
            print(f"Awesome job, {player}!")
            points += 20
        else:
            print("Wrong answer!")
        print(f"Your Points: {points}")
        playing = False


def trivia() -> None:
    """Taylor Swift Trivia."""
    global player
    global points
    print(f"Your current points: {points}")
    print("Are you ready for the toughest trivia questions? Here you go!")

    playing: bool = True
    while playing:  
        # Q1
        print("Q1: Who told Betty that James was cheating on her?")
        print("A: Inez")
        print("B: Blake")
        print("C: Aisha")
        print("D: Danielle")
        if input() == "A":
            print("You got it right! Poor Betty tho.")
            points += 20
        else:
            print("Wrong! It was Inez. Betty didn't wanna beleive it at first.")
        print(f"Your points: {points}")

        # Q2
        print("Q2: Where did Taylor Swift kick off her iconic Eras Tour?")
        print("A: Dallas, TX")
        print("B: Glendale, AZ")
        print("C: Las Vegas, NV")
        print("D: Boston, MA")
        if input() == "B":
            print("You got it right!! Awesome job!")
            points += 20
        else:
            print("Wrong! Correct Answer: B (and she did a whopping 44 songs)")
        print(f"Your points: {points}")

        # Q3
        print("Q3: What is Taylor Swift's lucky number?")
        print("A: 256")
        print("B: 26")
        print("C: 8")
        print("D: 13")
        if input() == "D":
            print("She really does have a lucky number...")
            points += 20
        else:
            print("Wrong! Come on.. it's universal knowledge at this point...")
        print(f"Your points: {points}")

        # Q4
        print("Q4: Who did Taylor write the song 'All Too Well' about?")
        print("A: Harry Styles")
        print("B: John Mayer")
        print("C: Jake Gyllenhall")
        print("D: Joe Alwyn")
        if input() == "C":
            print("You got it right!! And that's why we don't like Jake Gyllenhall")
            points += 20
        else:
            print("Wrong! She wrote 10 mins of the song!!!")
        print(f"Your points: {points}")

        # Q5
        print("Q5: What is the name of Taylor Swift's latest album?")
        print("A: Speak Now")
        print("B: Folklore")
        print("C: Midnights")
        print("D: Reputation")
        if input() == "C":
            print("You got it right... if you didn't, you've been living under a rock. ")
            points += 20
        else:
            print("Wrong! You've been living under a rock.")
        print(f"Your points: {points}")
        playing = False


def main() -> None:
    """Main playing function."""
    playing: bool = True
    global points
    global player
    points = 0
    greet()
    print("How would you like to proceed?")
    print("A: Finish the Lyric")
    print("B: Trivia")
    print("C: Nah, I'm good so Imma exit")
    while playing:
        answer = input()
        if answer == "A":
            print(f"Good choice, {player}! Let's get into it.")
            lyric()
            print("Your total points:" + str(bonus(points)))
            playing = False
        elif answer == "B":
            print(f"You like a challenge, {player}! Ready for it?") 
            trivia()
            print("Your total points: " + str(bonus(points)))
            playing = False
        elif answer == "C":
            print("That's ok!")
            playing = False
        else:
            print("Please enter a valid answer")


def greet() -> None:
    """Greets the player and gets their name."""
    print("Dear Reader,")
    print("You are about to embark on a TSwift adventure to test if you are a Swiftie!")
    print("But first! Tell us your name so we can report your score to Tay Tay.")
    global player
    player = input()
    print(f"We'll soon see if you're one of us, {player}!")


def bonus(points: int) -> int:
    """Bonus really easy question that gives random pts if player gets it right."""
    print("Bonus question! If you get it right, you get a random number of points!")
    print("What year was she born in?")
    if input() == "1989":
        print("You got it right!!!" + str(EMOJI))
        points += random.randint(1000, 2000)
    return points

            
if __name__ == "__main__":
    main()
