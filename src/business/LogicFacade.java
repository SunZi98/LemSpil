package business;

import data.SaveData;
import dataInterfaces.IData;
import dataInterfaces.ILogic;
import java.util.ArrayList;
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
        centrum.setRoomExit(taxi);
        west.setRoomExit(fruMadsensHouse);
        west.setRoomExit(centrum);
        north.setRoomExit(fishMarket);
        north.setRoomExit(centrum);
        east.setRoomExit(bar);
        east.setRoomExit(centrum);
        fruMadsensHouse.setRoomExit(west);
        bar.setRoomExit(east);
        south.setRoomExit(centrum);
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
        centrum.addRoomItem(wallet);
        east.addRoomItem(ciggarets);
        south.addRoomItem(timePotion);
        bar.addRoomItem(key);
        south.addRoomItem(timePotion);
        bar.addRoomItem(key);

        wallet.setPropDescription(" you can either keep the wallet for 25 coins or find the owner for a potential greater reward");
        beef.setPropDescription(" Give atleast 4 of these to the cab driver to get home");
        ciggarets.setPropDescription(" someone might be intrested in these");
        timePotion.setPropDescription(" Maybe i should try to drink it");
        key.setPropDescription(". Looks like a key for the fish market");

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
        player1.setNewRoom(room);
        tuborgMan.npcMove();
        if (tuborgManden.getNpcRoom() == taxi) {
            tuborgManden.setNpcRoom(centrum);
        }
        if (tuborgManden.getNpcRoom() == fruMadsensHouse) {
            tuborgManden.setNpcRoom(east);
        }
        if (player1.getCurrentPlayerRoom() == tuborgMan.getNpcRoom()) {
            player1.drink();
            System.out.println("You met the turborg guy!");
        }
    }

    @Override
    public void moveCentrum() {
        move(centrum);
    }

    @Override
    public void moveNorth() {
        move(north);
    }

    @Override
    public void moveSouth() {
        move(south);
    }

    @Override
    public void moveEast() {
        move(east);
    }

    @Override
    public void moveWest() {
        move(west);
    }

    @Override
    public void moveTaxi() {
        move(taxi);
    }

    @Override
    public void moveFishMarket() {
        move(fishMarket);
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
                        // beefcount++;
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
    public String getText() {
        return text;
    }

    @Override
    public void doAction() {

        while (true) {

            if (player1.getCurrentRoom() == fruMadsensHouse) {
                if (fruMadsensHouse.getRoomBehavior() == 1) {
                    player1.addCurrency(50);
                    setText("You cut Fru Madsens Hegde and was rewarded 50 coins ");
                    addText(" fru madsens kisses wyou on the cheek as a thanks");
                    fruMadsensHouse.setRoomBehavior(0);
                    break;
                } else {
                    setText("You already cut the hegde! ");
                    break;
                }
            }

            if (player1.getCurrentRoom() == fishMarket) {
                while (true) {
                      if (player1.getCurrentRoom() == fishMarket) {
                      }
                      
                    if (player1.getPlayerCurrency() < 25) {
                        System.out.println("You don't have enough money to buy a beef");
                        break;
                    } else {
                        player1.addProp(beef);
                        System.out.println("You brought a beef for 25 coins" + beef.getPropDescription());
                        player1.removeCurrency(25);
                        break;
                    }
                }
            }  
                System.out.println("nothing");
                break;
            

        }
    }
}
