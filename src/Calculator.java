public class Calculator implements Process {

    // Initialize final prompt Strings.
    protected final String PROMPT_1 = "In the Input line, please enter the first Integer: ";
    protected final String PROMPT_2 = "In the Input line, please enter the second Integer: ";

    // Initialize the GUI.
    protected GUI gui;

    // Declare the input SmallInt's.
    protected SmallInt firstInt;
    protected SmallInt secondInt;

    /**
     * Creates a new Calculator object.
     */
    public Calculator() {
        // Initialize a new GUI object.
        gui = new GUI(this);

        // Print the first prompt to the GUI.
        gui.print(PROMPT_1);
    }

    /**
     * Processes the inputted String. This method handles the parsing, adding, and displaying of results.
     */
    public void processInput(String s) {
        // Initialize final output prompts/messages.
        final String SUM_LINE = "_____________________";
        final String CLOSE_WINDOW_PROMPT = "The execution of this project has " +
                "been completed.\nPlease close this window when you are ready.";
        
        // Print the inputted value so that it can stay in the output screen.
        gui.println(s);

        // Check to see if firstInt is null, because then it has not been populated yet.
        if (firstInt == null) {
            // Define firstInt and set its value.
            firstInt = new SmallInt() {};
            firstInt.setValue(s);

            // Print out the prompt asking for the second integer.
            gui.print(PROMPT_2);
        } else {
            // Define secondInt and set its value.
            secondInt = new SmallInt() {};
            secondInt.setValue(s);

            // Compute the sum of the two values.
            int sum = firstInt.add(secondInt);

            // Print the results.
            gui.println(String.format("%40d\n+%38d\n%s\n%40d\n%s", firstInt.getValue(), secondInt.getValue(), SUM_LINE, sum, CLOSE_WINDOW_PROMPT));

            // Freeze the GUI so the only option is to close it.
            gui.freeze();
        }
    }

    public static void main(String argv[]) {
        Calculator calculator = new Calculator();
    }

}
