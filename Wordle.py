def contains_char(string: str, char: str) -> bool:
  """returns true if char is in string"""
  assert len(char) == 1
  i: int = 0
  while i < len(string):
      if string[i] == char:
          return True # character is anywhere in string
      i = i + 1
  return False

WHITE_BOX: str = "\U00002B1C"
GREEN_BOX: str = "\U0001F7E9"
YELLOW_BOX: str = "\U0001F7E8"
def emojified(guess: str, secret: str) -> str:
  """returns string of emoji boxes"""
  assert len(guess) == len(secret)
  x: int = 0
  final: str = ""
  while x < len(secret):
      if guess[x] == secret[x]:
          final = final + GREEN_BOX
      else:
          if contains_char(secret, guess[x]):
              final = final + YELLOW_BOX
          else:
              final = final + WHITE_BOX
      x = x + 1
  return final

def input_guess(x: int) -> str:
  word: str = input(f"Enter a {x} character word: ")
  if len(word) != x:
      while len(word) != x:
          word = input(f"That wasn't {x} chars! Try again: ")
  return word

def main() -> None:
  """The entrypoint of the program and main game loop"""
  turns: int = 1
  CODES: str = "codes"
  your_guess: str = ""
  while turns <= 6 and your_guess != CODES:
      print(f"=== Turn {turns}/6 ===")
      your_guess = input_guess(5)
      print(emojified(your_guess, CODES)) # checks if length is correct and returns emoji boxes
      turns = turns + 1
  if your_guess == CODES:
      print(f"You won in {turns-1}/6 turns!")
  else:
      print("X/6 - Sorry, try again tomorrow!")

if __name__ == "__main__":
  main()
