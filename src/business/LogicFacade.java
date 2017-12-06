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

public class LogicFacade implements dataInterfaces.ILogic {

    private ImageView imagepic;
    private IData data;
    public String name;
    public String roomName;
    private Prop propName;
    private ArrayList<Prop> roomItems = new ArrayList();
    private static ILogic logic;
    private Boolean isSucessFull = false;
    int drunkPenalty;
    long endTimeInMinutes;
    long endTimeInSeconds;
    int beefcount = 0;
    int score;
    
    private SaveData saveData = new SaveData();
    private Scanner input = new Scanner(System.in);
    private Room centrum = new Room("centrum");
    private Room north = new Room("north");
    private Room south = new Room("south");
    private Room east = new Room("east");
    private Room west = new Room("west");
    private Room fruMadsensHouse = new Room("fru madsens house");
    private Room bar = new Room("bar");
    private Room taxi = new Room("taxi");
    private Room fishMarket = new Room("the fish market");
    private Player player1 = new Player();
    private NPC tuborgManden = new NPC("Tuborg Manden", bar);
    private Room currentPlayerRoom;
    private String text;

    Prop wallet = new Prop("Wallet", 25);
    Prop beef = new Prop("beef", 25);
    Prop key = new Prop("key", 0);
    Prop ciggarets = new Prop("ciggarets", 25);
    Prop timePotion = new Prop("time potion", 25);

    public LogicFacade() {

        player1.setStartTime(System.currentTimeMillis());
        setCurrentPlayerRoom(centrum);

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

        centrum.setRoomDescription("Centrum");
        west.setRoomDescription("West");
        east.setRoomDescription("East");
        north.setRoomDescription("North");
        south.setRoomDescription("South ");
        fishMarket.setRoomDescription("You arrived at a fish market. Maybe you can buy some beefs for the cab driver here. ");

        centrum.addRoomItem(wallet);
        east.addRoomItem(ciggarets);
        south.addRoomItem(timePotion);
        bar.addRoomItem(key);

        wallet.setPropDescription(" you can either keep the wallet for 25 coins or find the owner for a potential greater reward");
        beef.setPropDescription(" Give atleast 4 of these to the cab driver to get home");
        ciggarets.setPropDescription(" someone might be intrested in these");
        timePotion.setPropDescription(" Maybe i should try to drink it");
        key.setPropDescription(". Looks like a key for the fish market");

        player1.addProp(beef);
//        player1.addProp(wallet);

    }

    @Override
    public void setCurrentPlayerRoom(Room room) {
        player1.setNewRoom(room);
    }

    @Override
    public String getPlayerName() {
        return player1.getName();
    }

    @Override
    public Room getCurrentPlayerRoom() {
        return player1.getCurrentRoom();
    }

    public void move(Room room) {
        checkTime();
        player1.setNewRoom(room);
        tuborgManden.move();
        if (tuborgManden.getCurrentRoom() == taxi) {
            tuborgManden.setNewRoom(centrum);
        }
        if (tuborgManden.getCurrentRoom() == fruMadsensHouse) {
            tuborgManden.setNewRoom(east);
        }
        if (player1.getCurrentRoom() == tuborgManden.getCurrentRoom()) {
            drink();
            setText("You met the turborg guy!");
        }
    }

    public void drink() {
        clearText();
        if (player1.getPlayerDrunk() < 4) { //checks if you already drank 4 times
            player1.addDrunk(); //increment playerDrunk by 1
            setText("You drunkometer is now at " + player1.getPlayerDrunk()); // prints how drunk you are
        } else {
            setText("Your drunkometer is at " + player1.getPlayerDrunk() + " you are too drunk"); //print if you drank 4 times already
            setText("You are too drunk");
        }

    }

    @Override
    public void moveCentrum() {
        clearText();
        move(centrum);
    }

    @Override
    public void moveNorth() {
        clearText();
        move(north);
    }

    @Override
    public void moveSouth() {
        clearText();
        move(south);
    }

    @Override
    public void moveEast() {
        clearText();
        move(east);
    }

    @Override
    public void moveWest() {
        clearText();
        move(west);
    }

    @Override
    public void moveTaxi() {
        clearText();
        move(taxi);
    }

    @Override
    public void moveFishMarket() {
        clearText();
        if (player1.getBag().contains(key)) {
            setText("You have the key. Welcome to the fish market");
            setIsSucessFull(true);
            move(fishMarket);
            //addText(fishMarket.getRoomDescription());
        } else {
            setText("Looks you need a key to get in here.");
        }
    }

    @Override
    public void moveHouse() {
        move(fruMadsensHouse);
    }

    @Override
    public void moveBar() {
        move(bar);
    }

    public static ILogic getInstance() {
        return logic;
    }

    @Override
    public void injectData(IData data) {
        this.data = data;
    }

    @Override
    public void save() {
        data.save();
    }

    @Override
    public void load() {
        data.load(player1, tuborgManden);
    }

    @Override
    public void handIn() {
        clearText();
        Random random = new Random();
        int count = 0;
        int fifty = 50;
        int nothing = 0;
        int randoms = random.nextBoolean() ? fifty : nothing;
        if (player1.getCurrentRoom() == south) {
            if (player1.getCurrentRoom().getRoomBehavior() == 1) {
                if (player1.getBag().contains(ciggarets)) {
                    setText("The man accepts your ciggarets and in return he gives you 25 coins");
                    player1.removeItem(ciggarets);
                    player1.addCurrency(25);
                    player1.getCurrentRoom().setRoomBehavior(0);
                } else {
                    setText("I have no ciggarets for you right now fam");
                }

            }
        }
        if (player1.getCurrentRoom() == west) {
            if (player1.getCurrentRoom().getRoomBehavior() == 1) {
                if (player1.getBag().contains(wallet)) {
                    if (randoms == 0) {
                        setText("The man gladlys accepts the wallet but you get nothing in return. Just a smile to continue your adventure");
                        player1.addCurrency(randoms);
                        player1.removeItem(wallet);
                        player1.getCurrentRoom().setRoomBehavior(0);
                    } else if (randoms == 50) {
                        setText("The man jumps of joy and as a reward for finding his wallet he gives you 50 coins.");
                        player1.addCurrency(50);
                        player1.removeItem(wallet);
                        player1.getCurrentRoom().setRoomBehavior(0);
                    }

                } else {
                    setText("You have nothing to hand in.");
                }
            } else {
                setText("You already returned the wallet");
            }
        }

        if (player1.getCurrentRoom() == taxi) {
            if (player1.getBag().contains(beef)) {
                count = 0;
                for (int i = player1.getBag().size(); i > 0; i--) {
                    if (player1.getBag().contains(beef)) {
                        player1.getBag().remove(beef);
                        count++;
                        beefcount++;
                    }
                }

                setText("You handed in " + count + " beefs to the taxi driver");

            } else {
                setText("You have no beefs to hand in");
            }
        }

        if (player1.getCurrentRoom() == centrum || player1.getCurrentRoom() == north || player1.getCurrentRoom() == fishMarket || player1.getCurrentRoom() == bar || player1.getCurrentRoom() == fruMadsensHouse || player1.getCurrentRoom() == east) {
            setText("you have nothing to hand in right now");

        }
    }

    @Override
    public void talk() {
        clearText();
        if (player1.getCurrentRoom() == south) {
            if (south.getRoomBehavior() == 1) {
                setText("I could really use a smoke. Do you have any ciggarets my friend? (Type 'hand in' to give the man your ciggarets)");
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

    @Override
    public void map() {
        clearText();
        setText("You are in " + player1.getCurrentRoom().toString());
        addText("\nYou can go: ");
        for (Room StuffToPrint : player1.getCurrentRoom().getRoomExits()) {
            addText("\n" + StuffToPrint.getRoomName());
        }
        addText("\nTuborg dude is in " + tuborgManden.getCurrentRoom());
    }

    @Override
    public void setText(String text) {
        this.text = text;

    }

    @Override
    public void addText(String string) {
        this.text = this.text + string;
    }

    @Override
    public void clearText() {
        setText("");
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void help() {
        clearText();
        setText("Controls: \nW = move North \nA = move East \nS = move South \nD = move West \nM = show map \nB = show bag \n T = talk \n E = do action");
    }

    @Override
    public void doAction() { //FIX
        clearText();
        while (true) {

            if (player1.getCurrentRoom() == fruMadsensHouse) {
                if (fruMadsensHouse.getRoomBehavior() == 1) {
                    player1.addCurrency(50);
                    setText("You cut Fru Madsens Hegde and was rewarded 50 coins. fru Madsen kisses you on the cheek as a thanks");
                    fruMadsensHouse.setRoomBehavior(0);
                    break;
                } else {
                    setText("You already cut the hegde! ");
                    break;
                }
            }

            if (player1.getCurrentRoom() == fishMarket) {

                if (player1.getPlayerCurrency() < 25) {
                    setText("You don't have enough money to buy a beef");
                    break;
                } else {
                    player1.addProp(beef);
                    setText("You brought a beef for 25 coins" + beef.getPropDescription());
                    player1.removeCurrency(25);
                    break;
                }

            }
            if (player1.getCurrentRoom() == bar) {
                if (bar.getRoomBehavior() == 1) {
                    setText("You cleaned the dishes and got 50 coins to your bag!");
                    player1.addCurrency(25);
                    fruMadsensHouse.setRoomBehavior(0);
                    break;
                } else {
                    setText("You already did the dishes!");
                    break;
                }
            }
            setText("nothing");
            break;

        }
    }

    @Override
    public void pickUp() {
        clearText();
        try {
            player1.addProp(player1.getCurrentRoom().getRoomItem().get(0));
            setText("You picked up a " + player1.getCurrentRoom().getRoomItems());
            if (player1.getBag().contains(timePotion)) {
                consume();
            }
            player1.getCurrentRoom().getRoomItem().clear();
        } catch (RuntimeException e) {
        }
    }

    @Override
    public void showBag() {
        clearText();
        if (player1.getBag().size() == 0) {
            setText("Your bag is empty! "); //prints if there is nothing in your bag
            addText("\n Currency: " + Integer.toString(player1.getPlayerCurrency()));
        } else {
            setText("Bag: ");
            Map<String, Integer> print = new HashMap<>();
            for (Prop StuffToPrint : player1.getBag()) { // iterate through bag
                if (print.containsKey(StuffToPrint.getPropName())) {
                    print.put(StuffToPrint.getPropName(), print.get(StuffToPrint.getPropName()) + 1);

                } else {
                    print.put(StuffToPrint.getPropName(), 1);
                }
            }
            for (String propName : print.keySet()) {
                addText("\n" + print.get(propName) + " " + propName + "(s)");
            }
            addText("\nCurrency: " + Integer.toString(player1.getPlayerCurrency()));
        }
    }

    @Override
    public String getRoomPropName() {
        return player1.getCurrentRoom().getRoomItems();
    }

    @Override
    public Boolean getIsSucessFull() {
        return isSucessFull;
    }

    @Override
    public void setIsSucessFull(Boolean isSucessFull) {
        this.isSucessFull = isSucessFull;
    }

    public void consume() {
        if (player1.getBag().contains(timePotion)) {
            player1.setStartTime(player1.getStartTime() + 60 * 1000);
            player1.getBag().remove(timePotion);
            addText(" .You consumed the time potion and added 1 minute to your clock!");
        }
    }

    @Override
    public void checkTime() {
        drunkPenalty += player1.getPlayerDrunk();
        if (player1.getStartTime() + 5 * 60 * 1000 < System.currentTimeMillis() + drunkPenalty * 1000) {
            lose();
        }
    }

    @Override
    public void lose() {
        scoreBoard();
    }

    @Override
    public void scoreBoard() {
        System.out.println("You lost");
        clearText();
        endTimeInMinutes = ((System.currentTimeMillis() + drunkPenalty * 1000 - player1.getStartTime()) / 1000 / 60);
        endTimeInSeconds = ((System.currentTimeMillis() + drunkPenalty * 1000 - player1.getStartTime()) / 1000) % 60;
        if (beefcount >= 4) {
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
        } else {
            setText("You got 0 points" + endTimeInMinutes + " minutes and " + endTimeInSeconds + " seconds");
            score = 0;
        }

    }

}
