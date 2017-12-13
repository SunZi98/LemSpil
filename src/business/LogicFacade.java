package business;

import data.SaveData;
import dataInterfaces.IData;
import dataInterfaces.ILogic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import javafx.scene.image.ImageView;

public class LogicFacade implements dataInterfaces.ILogic { //public class that implements ILogic interface located in the dataInterfaces package.

    private IData data; //Declare data of the IData type.
    private static ILogic logic; //Declare logic of the ILogic type.
    private final ArrayList<Prop> roomItems; //Delcare roomItems of the ArrayList type that holds Prop objects.
    private final Player player1; //Declare player1 of the Player type. 
    private final NPC tuborgManden; //Declare tuborgManden of the NPC type.

    //Declare different variables of the String type.
    private String name;
    private String roomName;
    private String text;

    //Declare different variables of the Boolean type.
    private Boolean enterFishmarket;
    private Boolean isBarEmpty;

    //Declare different variables of the long type.
    private long endTimeInMinutes;
    private long endTimeInSeconds;

    //Declare different variables of the int type.
    private int drunkPenalty;
    private int beefCount;
    private int score;

    //Declare different variables of the Room type.
    private final Room centrum;
    private final Room north;
    private final Room south;
    private final Room east;
    private final Room west;
    private final Room fruMadsensHouse;
    private final Room bar;
    private final Room taxi;
    private final Room fishMarket;
    private Room currentPlayerRoom;

    //Declare different variables of the Prop type
    private final Prop wallet;
    private final Prop beef;
    private final Prop key;
    private final Prop ciggarets;
    private final Prop timePotion;

    public LogicFacade() {

        //instantiate different objects of different types. 
        this.roomItems = new ArrayList();
        this.tuborgManden = new NPC();
        this.player1 = new Player();
        this.centrum = new Room("centrum");
        this.north = new Room("north");
        this.south = new Room("south");
        this.east = new Room("east");
        this.west = new Room("west");
        this.fruMadsensHouse = new Room("fru madsens house");
        this.bar = new Room("bar");
        this.taxi = new Room("taxi");
        this.fishMarket = new Room("the fish market");
        this.wallet = new Prop("Wallet", 25);
        this.beef = new Prop("beef", 25);
        this.key = new Prop("key", 0);
        this.ciggarets = new Prop("ciggarets", 25);
        this.timePotion = new Prop("time potion", 25);

        //Assign different variables a value.
        this.beefCount = 0;
        this.isBarEmpty = false;
        this.enterFishmarket = false;

        player1.setStartTime(System.currentTimeMillis()); //Set the currentTime to the player1 object.
        player1.setNewRoom(centrum); //Update player1 currentRoom via setNewRoom method.

        tuborgManden.setName("tuborgManden");//Set name String via setName method.
        tuborgManden.setNewRoom(bar);//Set currentRoom Room via setNewRoom method.

        //Add different rooms to roomExits ArrayList.
        centrum.setRoomExit(north);
        centrum.setRoomExit(east);
        centrum.setRoomExit(south);
        centrum.setRoomExit(west);
        west.setRoomExit(fruMadsensHouse);
        west.setRoomExit(centrum);
        north.setRoomExit(fishMarket);
        north.setRoomExit(centrum);
        east.setRoomExit(bar);
        east.setRoomExit(centrum);
        fruMadsensHouse.setRoomExit(west);
        bar.setRoomExit(east);
        south.setRoomExit(centrum);
        south.setRoomExit(taxi);
        taxi.setRoomExit(centrum);
        fishMarket.setRoomExit(north);

        //Set roomDescription String via setRoomDescription method. 
        centrum.setRoomDescription("Centrum");
        west.setRoomDescription("West");
        east.setRoomDescription("East");
        north.setRoomDescription("North");
        south.setRoomDescription("South ");
        fishMarket.setRoomDescription("You arrived at a fish market. Maybe you can buy some beefs for the cab driver here. ");

        //Add props to roomItems arrayList via addRoomItem method.
        centrum.addRoomItem(wallet);
        east.addRoomItem(ciggarets);
        north.addRoomItem(timePotion);
        bar.addRoomItem(key);

        //Set propDescription String via setPropDescription method.
        wallet.setPropDescription(" you can either keep the wallet for 25 coins or find the owner for a potential greater reward");
        beef.setPropDescription(" Give atleast 4 of these to the cab driver to get home");
        ciggarets.setPropDescription(" someone might be intrested in these");
        timePotion.setPropDescription(" Maybe i should try to drink it");
        key.setPropDescription(". Looks like a key for the fish market");

    }

    public static ILogic getInstance() { //Static method returns logic variable of the ILogic type.
        return logic;
    }

    public void injectData(IData data) { //Method instantiate this.data variable to data entered in method parameter. 
        this.data = data;
    }

    @Override //Override method from ILogic interface.
    public void setText(String text) { //Set text String variable to text entered in method parameter.
        this.text = text;
    }

    private void setCurrentPlayerRoom(Room room) { //Method with Room as parameter
        player1.setNewRoom(room); //Give player1 a new currentRoom via setNewRoom method defined in Player class.
    }

    @Override //Override method from ILogic interface.
    public void setIsBarEmpty(Boolean isBarEmpty) { //Give isBarEmpty variable a value that is entered in method parameter.
        this.isBarEmpty = isBarEmpty;
    }

    @Override //Override method from ILogic interface.
    public void setCurrentPlayerName(String playerName) { //Method with String as parameter
        player1.setName(playerName); //Give player1 a new name via setName method defined in Player class.
    }

    private void setIsSucessFull(Boolean isSucessFull) { //Give setIsSuccessFull a value that is entered in method parameter
        this.enterFishmarket = isSucessFull;
    }

    @Override //Override method from ILogic interface.
    public String getPlayerName() { //Method that takes no parameters
        return player1.getName(); //Returns player1's name variable value
    }

    @Override //Override method from ILogic interface.
    public Room getCurrentPlayerRoom() { //Method that returns player1's currentRoom variable value.
        return player1.getCurrentRoom();
    }

    private int getCurrency() { //Method that returns player1's playerCurrency variable value.
        return player1.getPlayerCurrency();
    }

    @Override //Override method from ILogic interface.
    public Boolean getIsSucessFull() { //Method that returns isSucessFulls value.
        return enterFishmarket;
    }

    @Override
    public int getBeefCount() { //Method that returns beefCount's value.
        return beefCount;
    }

    @Override //Override method from ILogic interface.
    public Boolean getIsBarEmpty() { //Method that returns isBarEmptys's value.
        return isBarEmpty;
    }

    @Override //Override method from ILogic interface.
    public long getElapsedTime() { //Method that returns player1's elapsed time 
        return player1.getStartTime() - player1.getEndTime(); //Get elapsed time by subtracting player1's startTime with player1's endTime.
    }

    @Override //Override method from ILogic interface.
    public long getStartTime() { //Method that returns player1's startTime's value.
        return player1.getStartTime(); //call getStartTime on Player object.
    }

    @Override //Override method from ILogic interface.
    public long getPlayerDrunk() { //Method that returns player1's playerDrunk's value.
        return player1.getPlayerDrunk(); //Call getPlayerDrunk on player Object.
    }

    @Override //Override method from ILogic interface.
    public String getText() { //Method that return text String value.
        return text;
    }

    private void move(Room room) { //Method that takes a Room as parameter
        checkTime(); //Call checkTime method
        player1.setNewRoom(room); //Set a new Room equal to the room entered in the method parameter
        tuborgManden.moveRandom(); //Call moveRandom method defined in Character class on tuborgManden object-
        if (tuborgManden.getCurrentRoom() == taxi) { //Check if tuborgManden's currentRoom is equal to taxi
            tuborgManden.setNewRoom(centrum); //If true set centrum as a new room for tuborgManden via setNewRoom method.
        }
        if (tuborgManden.getCurrentRoom() == fruMadsensHouse) { //Check if tuborgMandens's currentRoom is equal to fruMadsensHouse
            tuborgManden.setNewRoom(east); //If true set east as a new room for tuborgManden via setNewRoom method.
        }
        if (player1.getCurrentRoom() == tuborgManden.getCurrentRoom()) { //checks player1 and tuborgManden rooms are equal 
            setText("You met the turborg guy!"); //Call setText method to give text variable a new value.
            drink(); //if true call drink method
        }
    }

    private void drink() { //Drink method
        if (player1.getPlayerDrunk() < 4) { //checks if you already drank 4 times
            player1.addDrunk(); //if true increment playerDrunk by 1
            addText("\n You drunkometer is now at " + player1.getPlayerDrunk()); // if true addText method is called
        } else {
            addText("\n Your drunkometer is at " + player1.getPlayerDrunk() + " you are too drunk"); //if false addText method is called 
        }

    }

    @Override //Override method from ILogic interface.
    public void moveCentrum() { //Void method
        clearText(); //call clearText method
        move(centrum); //Call move method and use centrum object as parameter.
    }

    @Override //Override method from ILogic interface.
    public void moveNorth() { //Void method
        clearText(); //call clearText method
        move(north); //Call method an use north object as parameter
    }

    @Override //Override method from ILogic interface.
    public void moveSouth() { //Void method
        clearText(); //call clearText method
        move(south); //Call method an use south object as parameter
    }

    @Override //Override method from ILogic interface.
    public void moveEast() { //Void method
        clearText(); //call clearText method
        move(east); //Call method an use east object as parameter
    }

    @Override //Override method from ILogic interface.
    public void moveWest() { //Void method
        clearText(); //call clearText method
        move(west); //Call method an use west object as parameter
    }

    @Override //Override method from ILogic interface.
    public void moveTaxi() { //Void method
        clearText(); //call clearText method
        move(taxi); //Call method an use taxi object as parameter
    }

    @Override //Override method from ILogic interface.
    public void moveFishMarket() { //Void method
        clearText(); //call clearText method
        if (player1.getBag().contains(key)) {
            setText("You have the key. Welcome to the fish market");
            setIsSucessFull(true);
            move(fishMarket); //Call method an use fishMarket object as parameter
            //addText(fishMarket.getRoomDescription());
        } else {
            setText("Looks you need a key to get in here."); //Call setText method.
        }
    }

    @Override //Override method from ILogic interface.
    public void moveHouse() { //Void method
        move(fruMadsensHouse); //Call method an use fruMadsensHouse object as parameter
    }

    @Override //Override method from ILogic interface.
    public void moveBar() { //Void method
        move(bar); //Call method an use bar object as parameter
    }

    @Override //Override method from ILogic interface.
    public void handIn() { //Void method
        clearText(); //Call clearText mehod
        Random random = new Random(); //instantiate random variable of the Random type.
        int count = 0; //Declare count as int type and give it 0 as a value.
        int fifty = 50; //Declare fifty as int type and give it 50 as a value.
        int nothing = 0; //Declare nothing as int type and give it 0 as a value.
        int randoms = random.nextBoolean() ? fifty : nothing; // 50 / 50 of getting returning fifty's or nothing's value.
        if (player1.getCurrentRoom() == south) { //Checks if player1's currentRoom is equal to south
            if (player1.getCurrentRoom().getRoomBehavior() == 1) { //Checks if souths's roomBehavior is equal to 1
                if (player1.getBag().contains(ciggarets)) { //Checks if player1's bag contains ciggarets object.
                    setText("The man accepts your ciggarets and in return he gives you 25 coins"); //if true call setText method
                    player1.removeItem(ciggarets); //Call removeItem method to remove ciggarets from player1's bag ArrayList
                    player1.addCurrency(25); //Call addCurrency method to increment player1's playerCurrency by 25.
                    player1.getCurrentRoom().setRoomBehavior(0); //Set south's roomBehavior variable equal to 0.
                } else {
                    setText("I have no ciggarets for you right now fam"); //if False setText method is called-
                }

            }
        }
        if (player1.getCurrentRoom() == west) { //Checks if player1's currentRoom is equal to west
            if (player1.getCurrentRoom().getRoomBehavior() == 1) { //Checks if  west's roomBehavior is equal to 1
                if (player1.getBag().contains(wallet)) { //Checks if player1's bag contains wallet object.
                    if (randoms == 0) { // checks if randoms is equal to 0.
                        setText("The man gladlys accepts the wallet but you get nothing in return. Just a smile to continue your adventure"); //call SetText method
                        player1.addCurrency(randoms); //Increment player1's playerCurreny by randoms value.
                        player1.removeItem(wallet); //Call removeItem method to remove wallet object from player1's bag
                        player1.getCurrentRoom().setRoomBehavior(0); //Set west's roomBehavior to 0
                    } else if (randoms == 50) { //Checks if randoms value is equal to 50
                        setText("The man jumps of joy and as a reward for finding his wallet he gives you 50 coins."); //Call setText method
                        player1.addCurrency(randoms); //Increment player1's playerCurrency by randoms value
                        player1.removeItem(wallet); //Call removeItem method to remove wallet object from player1's bag
                        player1.getCurrentRoom().setRoomBehavior(0); //Set west's roomBehavior to 0
                    }

                } else {
                    setText("You have nothing to hand in."); //If bag does not contain wallet object
                }
            } else {
                setText("You already returned the wallet"); // If west's roomBehavior is requal to 0    
            }
        }

        if (player1.getCurrentRoom() == taxi) { //Checks if players1's currentRoom is equal to taxi object
            if (player1.getBag().contains(beef)) { //checks if player1's bag contains beef objects.
                count = 0; //set count to 0
                for (int i = player1.getBag().size(); i > 0; i--) { //For loop that iterates player1's bag size
                    if (player1.getBag().contains(beef)) { //Checks if player1's bag contains beef object
                        player1.getBag().remove(beef); //If true remove beef object from player1's bag
                        count++; //increment count variable's value by 1
                        beefCount++; //increment beefCount variable's value  by 1
                    }
                }

                setText("You handed in " + count + " beefs to the taxi driver"); // Call textText method

            } else {
                setText("You have no beefs to hand in"); //If player1's bag does not contains beef objects.
            }
        }

        /*
        *  Checks if player'1s currentRoom is equal to all other than taxi, south and west and then call setText 
         */
        if (player1.getCurrentRoom() == centrum || player1.getCurrentRoom() == north || player1.getCurrentRoom() == fishMarket || player1.getCurrentRoom() == bar || player1.getCurrentRoom() == fruMadsensHouse || player1.getCurrentRoom() == east) {
            setText("you have nothing to hand in right now");

        }
    }

    /*
    * This method checks player1's currentRoom and the room's roomBehavior and call the setText method accordingly
     */
    @Override //Override method from ILogic interface.
    public void talk() {
        clearText(); //Call clearText method
        if (player1.getCurrentRoom() == south) { //Checks if player1's currentRoom is equal to south
            if (south.getRoomBehavior() == 1) { //Checks if south's roomBehavior is equal to 0
                setText("I could really use a smoke. Do you have any ciggarets my friend? (Prees hand in button to give him your ciggarets");
            } else {
                setText("Thanks for the smoke fam!");
            }
        }

        if (player1.getCurrentRoom() == taxi) {
            if (taxi.getRoomBehavior() == 1) {
                setText("I can take you home for 4 beefs.(Type 'hand in' to give him your beefs.)");
                taxi.setRoomBehavior(0);
            } else {
                setText("I have not gotten 4 beefs from you yet, so i cant take you home until i do. (Type 'hand in' to give him your beefs.)");
            }
        }
        if (player1.getCurrentRoom() == fruMadsensHouse) {
            if (fruMadsensHouse.getRoomBehavior() == 1) {
                setText("Can you help me cut my hedge? (Type 'cut hedge' to help her)");
            } else {
                setText("There is nothing to do right now.");
            }
        }
        if (player1.getCurrentRoom() == bar) {
            if (bar.getRoomBehavior() == 1) {
                setText("Can you do the dishes for us? (Type 'do dishes' to do the dishes in the bar).");
            } else {
                setText("There is nothing to do right now.");
            }
        }
        if (player1.getCurrentRoom() == west) {
            if (west.getRoomBehavior() == 1) {
                setText("Did you find my wallet? (Type 'hand in' to give the man your wallet)");
            } else {
                setText("Thanks for the help with finding my wallet!");
            }
        }
        if (player1.getCurrentRoom() == fishMarket) {
            setText("Here you can buy beefs.");
        }

        if (player1.getCurrentRoom() == centrum || player1.getCurrentRoom() == north || player1.getCurrentRoom() == east) {
            setText("There is nothing to do right now.");
        }
    }

    /*
    This method prints where the player currently is and that Rooms roomexits. It also prints what tuborgManden curenntRoom is.
     */
    @Override //Override method from ILogic interface.
    public void map() {
        clearText();
        setText((player1.getName()) + " You are in " + player1.getCurrentRoom().getRoomName());
        addText("\nYou can go: ");
        for (Room StuffToPrint : player1.getCurrentRoom().getRoomExits()) { //for each loop to print currentRoom's roomExits
            addText("\n" + StuffToPrint.getRoomName());
        }
        addText("\nTuborg dude is in " + tuborgManden.getCurrentRoom());
    }

    @Override //Override method from ILogic interface.
    public void addText(String string) { //Add more text to text variable via String entered in method header
        this.text = this.text + string;
    }

    @Override //Override method from ILogic interface.
    public void clearText() { // method that set text variable to ("").. reducing the String. 
        setText("");
    }

    @Override //Override method from ILogic interface.
    public void help() { //Method that prints all hotkeys 
        clearText();
        setText("Controls: \nW = move North \nA = move East \nS = move South \nD = move West \nM = show map \nB = show bag \n T = talk \n E = do action");
    }

    @Override //Override method from ILogic interface.
    public void doAction() {// method that checks what room and that rooms roomBehavior and does something accordenly
        clearText(); //Call clearText method
        while (true) {
            if (player1.getCurrentRoom() == fruMadsensHouse) { //checks if player1's currentRoom is equal to fruMadsensHouse object
                if (fruMadsensHouse.getRoomBehavior() == 1) { //checks if fruMadsens roomBehavior is equal to 1
                    player1.addCurrency(50); //Increment palyerCurrency by 50
                    setText("You cut Fru Madsens Hegde and was rewarded 50 coins. fru Madsen kisses you on the cheek as a thanks");
                    fruMadsensHouse.setRoomBehavior(0); //Set roomBehavior to 0
                    break;
                } else {
                    setText("You already cut the hegde! "); //setText if roomBehavior is equal to 0
                    break;
                }
            }

            if (player1.getCurrentRoom() == fishMarket) { //checks if player1's currentRoom is equal to fishMarket object
                if (player1.getPlayerCurrency() < 25) { //checks if player1's playercurrency is below 25
                    setText("You don't have enough money to buy a beef"); //setText method is called
                    break;
                } else {
                    player1.addProp(beef); //Add beef object to player1's bag
                    setText("You brought a beef for 25 coins" + beef.getPropDescription()); //setText method is called
                    player1.removeCurrency(25);// remove 25 currency from player1's playerCurrency
                    break;
                }

            }
            if (player1.getCurrentRoom() == bar) { //checks if player1's currentRoom is equal to bar object
                if (bar.getRoomBehavior() == 1) {
                    setText("You cleaned the dishes and got 25 coins to your bag!"); //setText method is called.
                    player1.addCurrency(25);//Increment palyerCurrency by 25
                    bar.setRoomBehavior(0); //set bar objects roomBehavior to 0
                    break;
                } else {
                    setText("You already did the dishes!"); //if bar roomBehavior is equal to 0
                    break;
                }
            }
            setText("nothing"); //setText method is called
            break;

        }
    }

    /*
    This method add items to player1's bag depending on what player1's currentRoom is
     */
    @Override //Override method from ILogic interface.
    public void pickUp() {
        clearText();
        try {
            player1.addProp(player1.getCurrentRoom().getRoomItem().get(0)); //get currentRoom's ArrayList at index 0.
            setText("You picked up a " + player1.getCurrentRoom().getRoomItemsIndexZero());
            if (player1.getBag().contains(timePotion)) { //If you pickup a timePotion
                consume(); //call consume method
            }
            if (player1.getBag().contains(key)) { //if you pickup key 
                setIsBarEmpty(true); //set variable value to true.
            }
            player1.getCurrentRoom().getRoomItem().clear(); //remove all items from player1's currentRoom.

        } catch (RuntimeException e) { //catch RunTimeExeception
        }
    }

    @Override //Override method from ILogic interface.
    public void showBag() {
        clearText();
        if (player1.getBag().size() == 0) {
            setText("Your bag is empty! "); //prints if there is nothing in your bag
            addText("\n Currency: " + Integer.toString(player1.getPlayerCurrency())); //addText method is called and parse player1's playerCurreny to Strint type.
        } else {
            setText("Bag: ");
            Map<String, Integer> print = new HashMap<>();
            for (Prop StuffToPrint : player1.getBag()) { // iterate through bag
                if (print.containsKey(StuffToPrint.getPropName())) { //if bag contains propsname
                    print.put(StuffToPrint.getPropName(), print.get(StuffToPrint.getPropName()) + 1); //increment number of Prop object by 1

                } else {
                    print.put(StuffToPrint.getPropName(), 1); //put Prop object in hashmap
                }
            }
            for (String propName : print.keySet()) {
                addText("\n" + print.get(propName) + " " + propName + "(s)"); //add hashmap and propName to text
            }
            addText("\nCurrency: " + Integer.toString(player1.getPlayerCurrency())); //addText method is called
            addText("\n Drunk meter: " + player1.getPlayerDrunk()); //addText method is called
        }
    }

    private void consume() {
        if (player1.getBag().contains(timePotion)) { //Checks if player1's bag contains timePotion object
            player1.setStartTime(player1.getStartTime() + 60 * 1000); //set new startTime which is 1 minute ealier
            player1.getBag().remove(timePotion); //remove timepotion
            addText(" .You consumed the time potion and added 1 minute to your clock!"); //addText method is called
        }
    }

    private void checkTime() {
        drunkPenalty += player1.getPlayerDrunk(); //set drunkPenality to player1's playerDrunk + what is was before the increment
        if (player1.getStartTime() + 5 * 60 * 1000 < System.currentTimeMillis() + drunkPenalty * 1000) { //checks if the player used over 5 minutes
            scoreBoard(); //call lose method
        }
    }

    @Override //Override method from ILogic interface.
    public void scoreBoard() { //void method
        clearText(); //call clearText method
        endTimeInMinutes = ((System.currentTimeMillis() + drunkPenalty * 1000 - player1.getStartTime()) / 1000 / 60); //Update endTimeInMinutes variable
        endTimeInSeconds = ((System.currentTimeMillis() + drunkPenalty * 1000 - player1.getStartTime()) / 1000) % 60; //Update endTimeInSeconds variable
        if (beefCount >= 4) { //checks if beefCount is higher or equal to 4
            /*
            Prints the scoreboard accornding to how much time you used.
             */
            if (player1.getStartTime() + 1 * 60 * 1000 > System.currentTimeMillis() + drunkPenalty * 1000) {
                setText("You got 10 points and used " + endTimeInMinutes + " minutes and " + endTimeInSeconds + " seconds");
                score = 10;
            } else if (player1.getStartTime() + 2 * 60 * 1000 > System.currentTimeMillis() + drunkPenalty * 1000) {
                setText("You got 8 points! " + endTimeInMinutes + " minutes and " + endTimeInSeconds + " seconds");
                score = 8;
            } else if (player1.getStartTime() + 3 * 60 * 1000 > System.currentTimeMillis() + drunkPenalty * 1000) {
                setText("You got 6 points! " + endTimeInMinutes + " minutes and " + endTimeInSeconds + " seconds");
                score = 6;
            } else if (player1.getStartTime() + 4 * 60 * 1000 > System.currentTimeMillis() + drunkPenalty * 1000) {
                setText("You got 4 points! and used " + endTimeInMinutes + " minutes and " + endTimeInSeconds + " seconds");
                score = 4;
            } else {
                setText("You got 2 points! " + endTimeInMinutes + " minutes and " + endTimeInSeconds + " seconds");
                score = 2;
            }
        } else { //if beefCount is below 4
            setText("You got 0 points" + endTimeInMinutes + " minutes and " + endTimeInSeconds + " seconds");
            score = 0;
        }
    }
    
    @Override
    public int getScore(){
        return score;
    }

}
