import java.util.*;

public class RockPaperScissors {

    ArrayList<GameChoice> choices = new ArrayList<>();
    Random random = new Random();
    boolean keepRunning = true;
    Scanner scanner = new Scanner(System.in);

    public void start() {
        initializeChoices();

        System.out.println("Starting Rock Paper Scissors...");

        while (keepRunning) {
            System.out.println("Please enter a choice Rock, Paper, or Scissors: ");

            GameChoice cpuChoice = getCpuGameChoice();
            GameChoice userChoice = getUserGameChoice();
            if (userChoice == GameChoice.INVALID){
                System.out.println("Sorry I didn't understand that.");
                continue;
            }

            completeTurn(userChoice, cpuChoice);
        }

        System.out.println("Game Over");
    }

    private void initializeChoices(){
        choices.add(GameChoice.ROCK);
        choices.add(GameChoice.PAPER);
        choices.add(GameChoice.SCISSORS);
    }

    private GameChoice getUserGameChoice(){
        String input = scanner.nextLine();
        return GameChoice.getGameChoiceForString(input);
    }

    private GameChoice getCpuGameChoice(){
        int randomIndex = random.nextInt(3);
        return choices.get(randomIndex);
    }

    private void completeTurn(GameChoice userChoice, GameChoice cpuChoice){
        System.out.println("User choice is " + userChoice);
        System.out.println("Cpu choice is " + cpuChoice);

        int gameStatus = userChoice.compare(cpuChoice);
        if (gameStatus == 0){
            System.out.println("Draw. Try Again");
        } else if (gameStatus > 0) {
            System.out.println("You Win!");
            keepRunning = false;
        } else {
            System.out.println("You Lose!");
            keepRunning = false;
        }
    }
}

enum GameChoice {
    ROCK, PAPER, SCISSORS, INVALID;

    public static GameChoice getGameChoiceForString(String choice) {
        if (Objects.equals(choice, "Rock")) {
            return ROCK;
        } else if (Objects.equals(choice, "Paper")) {
            return PAPER;
        } else if (Objects.equals(choice, "Scissors")) {
            return SCISSORS;
        } else {
            return INVALID;
        }
    }

    public int compare(GameChoice otherChoice) {
        if (Objects.equals(this, otherChoice)) {
            return 0;
        } else if (Objects.equals(this, ROCK)) {
            if (Objects.equals(otherChoice, SCISSORS)) {
                return 1;
            } else {
                return -1;
            }
        } else if (Objects.equals(this, SCISSORS)) {
            if (Objects.equals(otherChoice, PAPER)) {
                return 1;
            } else {
                return -1;
            }
        } else if (Objects.equals(this, PAPER)) {
            if (Objects.equals(otherChoice, ROCK)) {
                return 1;
            } else {
                return -1;
            }
        }

        return 0;
    }
}
