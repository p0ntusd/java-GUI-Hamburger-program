package se.umu.cs.apjava.maxdonalds;

import javax.swing.*;
import java.awt.*;

public class MaxDonaldsGuiBuilder {

    private JCheckBox withKetchupButton;
    private JCheckBox withMayoButton;
    private BurgerOrderModel burgerOrderModel;
    private ButtonGroup burgerGroup;
    private JCheckBox withAioliButton;
    private JCheckBox withTomatoButton;
    private JCheckBox withPicklesButton;
    private JCheckBox withLettuceButton;

    void buildGui() {
        burgerOrderModel = new BurgerOrderModel();
        var frame=new JFrame("MaxDonalds");

        JTextArea textArea = new JTextArea();
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        JComponent burgerPanel = buildBurgerPanel();
        JComponent orderPanel = buildOrderPanel(textArea);
        JComponent additionsPanel = buildSaucesPanel();
        JComponent vegetablesPanel = buildVegetablesPanel();
        JComponent favoritePanel = buildFavoritePanel();
        var topPanel=new JPanel();
        topPanel.setMinimumSize(new Dimension(1000,50));
        topPanel.add(burgerPanel);
        topPanel.add(vegetablesPanel);
        topPanel.add(additionsPanel);
        topPanel.add(favoritePanel);

        topPanel.add(orderPanel);
        frame.add(topPanel,BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1000,400));
        frame.setVisible(true);
    }

    private JComponent buildFavoritePanel() {
        var favoritePanel=new Box(BoxLayout.Y_AXIS);
        JLabel clickToAdd = new JLabel("Click to add:");
        favoritePanel.add(clickToAdd);

        var favoriteOneButton=new JButton("Favorite 1");
        favoriteOneButton.addActionListener(e-> burgerOrderModel.pickFavorite1());
        favoritePanel.add(favoriteOneButton);

        var favoriteTwoButton=new JButton("Favorite 2");
        favoriteTwoButton.addActionListener(e-> burgerOrderModel.pickFavorite2());
        favoritePanel.add(favoriteTwoButton);

        var favoriteThreeButton=new JButton("Favorite 3");
        favoriteThreeButton.addActionListener(e-> burgerOrderModel.pickFavorite3());
        favoritePanel.add(favoriteThreeButton);

        return favoritePanel;
    }

    private JComponent buildOrderPanel(JTextArea textArea) {
        Box orderPanel=new Box(BoxLayout.Y_AXIS);
        var printButton = new JButton("Print Order");
        printButton.addActionListener(e->{
            String orderString= burgerOrderModel.getOrderString();
            textArea.append(orderString);

        });
        var addButton = new JButton("Add Burger To Order");
        addButton.addActionListener(e->{
            burgerOrderModel.addBurgerToOrder();
            clearSelection();
        });
        orderPanel.add(addButton);
        orderPanel.add(printButton);
        orderPanel.add(Box.createGlue());
        return orderPanel;
    }

    private JComponent buildSaucesPanel() {
        var additionsPanel=new Box(BoxLayout.Y_AXIS);
        JLabel additions = new JLabel("Sauces");
        additions.setAlignmentX(Component.LEFT_ALIGNMENT);
        additionsPanel.add(additions);
        withKetchupButton = new JCheckBox("Ketchup");
        withKetchupButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        withKetchupButton.addChangeListener(e->
            burgerOrderModel.setWithKetchup(withKetchupButton.isSelected())
        );
        additionsPanel.add(withKetchupButton);
        withMayoButton = new JCheckBox("Mayo");
        withMayoButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        withMayoButton.addChangeListener(e->
            burgerOrderModel.setWithMayo(withMayoButton.isSelected())
        );
        additionsPanel.add(withMayoButton);
        withAioliButton = new JCheckBox("Aioli");
        withAioliButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        withAioliButton.addChangeListener(e->
            burgerOrderModel.setWithAioli(withAioliButton.isSelected())
        );
        additionsPanel.add(withAioliButton);
        JComponent withTextPanel = getTextPanel();
        additionsPanel.add(withTextPanel);
        additionsPanel.add(Box.createGlue());
        return additionsPanel;
    }

    private JComponent buildVegetablesPanel() {
        var additionsPanel=new Box(BoxLayout.Y_AXIS);
        JLabel additions = new JLabel("Vegetables");
        additions.setAlignmentX(Component.LEFT_ALIGNMENT);
        additionsPanel.add(additions);
        withLettuceButton = new JCheckBox("Lettuce");
        withLettuceButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        withLettuceButton.addChangeListener(e->
            burgerOrderModel.setWithLettuce(withLettuceButton.isSelected())
        );
        additionsPanel.add(withLettuceButton);
        withTomatoButton = new JCheckBox("Tomato");
        withTomatoButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        withTomatoButton.addChangeListener(e->
            burgerOrderModel.setWithTomato(withTomatoButton.isSelected())
        );
        additionsPanel.add(withTomatoButton);
        withPicklesButton = new JCheckBox("Pickles");
        withPicklesButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        withPicklesButton.addChangeListener(e->
            burgerOrderModel.setWithPickles(withPicklesButton.isSelected())
        );
        additionsPanel.add(withPicklesButton);
        JComponent withTextPanel = getTextPanel();
        additionsPanel.add(withTextPanel);
        additionsPanel.add(Box.createGlue());
        return additionsPanel;
    }

    private JComponent getTextPanel() {
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        layout.setHgap(0);
        layout.setVgap(0);
        var withTextPanel=new JPanel(layout);
        withTextPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        return withTextPanel;
    }

    private JComponent buildBurgerPanel() {
        var burgerPanel=new Box(BoxLayout.Y_AXIS);
        var chickenBurgerButton=new JRadioButton("ChickenBurger");
        chickenBurgerButton.addActionListener(e->
            burgerOrderModel.setType("Chicken")
        );
        var beefBurgerButton=new JRadioButton("BeefBurger");
        beefBurgerButton.addActionListener(e->
            burgerOrderModel.setType("Beef")
        );
        var fishBurgerButton=new JRadioButton("FishBurger");
        fishBurgerButton.addActionListener(e->
            burgerOrderModel.setType("Fish")
        );
        burgerGroup = new ButtonGroup();
        burgerGroup.add(beefBurgerButton);
        burgerGroup.add(chickenBurgerButton);
        burgerGroup.add(fishBurgerButton);
        burgerPanel.add(new JLabel("Basic Burgers"));
        burgerPanel.add(beefBurgerButton);
        burgerPanel.add(chickenBurgerButton);
        burgerPanel.add(fishBurgerButton);
        return burgerPanel;
    }

    private void clearSelection() {
        withKetchupButton.setSelected(false);
        withMayoButton.setSelected(false);
        withAioliButton.setSelected(false);
        withTomatoButton.setSelected(false);
        withPicklesButton.setSelected(false);
        withLettuceButton.setSelected(false);
        burgerGroup.clearSelection();
    }

}
