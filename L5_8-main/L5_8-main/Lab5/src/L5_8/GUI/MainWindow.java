package L5_8.GUI;

import L5_8.data.Mus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;



public class MainWindow extends JFrame{
    private JTable jTable;
    private MyTableModel myTableModel;
    private JButton buttonDelete;
    private JButton buttonAdd;
    private JButton buttonSearch;
    private JScrollPane jScrollPane;

    public MainWindow(){
       setTitle("Список групп");
       setSize(800, 800);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       JPanel panelFlow = new JPanel();
       panelFlow.setLayout(new FlowLayout(FlowLayout.LEFT));

       this.buttonAdd = new JButton("Добавить");
        panelFlow.add(buttonAdd);

       this.buttonSearch = new JButton("Найти");
        panelFlow.add(buttonSearch);

       this.buttonDelete = new JButton("Удалить группу");
       panelFlow.add(buttonDelete);

       JPanel panelBorder = new JPanel(new BorderLayout());
       panelBorder.add(panelFlow, BorderLayout.NORTH);

       myTableModel = new MyTableModel(new Mus());

       jTable = new JTable();
       jTable.setModel(myTableModel);

       this.jScrollPane = new JScrollPane(jTable);
       this.add(jScrollPane);

       panelBorder.add(jScrollPane, BorderLayout.CENTER);



        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    myTableModel.delete(jTable.getSelectedRow());
                }catch(IndexOutOfBoundsException ex){
                    String message = "Выделите строку";
                    JOptionPane.showMessageDialog(null, message);
                }
            }
        });

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog();
                dialog.setModal(true);
                dialog.setSize(250, 270);
                dialog.setTitle("Добавление");
                dialog.setLocationRelativeTo(null);

                JPanel grid = new JPanel();
                grid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                GridLayout gridLayout = new GridLayout(6, 2, 0, 15);
                grid.setLayout(gridLayout);

                grid.add(new JLabel("Название группы:"));
                TextField textName = new TextField(20);
                grid.add(textName);


                grid.add(new JLabel("Год основания:"));
                TextField textYear = new TextField(20);
                grid.add(textYear);

                grid.add(new JLabel("Кол-во участников:"));
                TextField textParticipants = new TextField(20);
                grid.add(textParticipants);

                grid.add(new JLabel("Жанр:"));
                TextField textGanr = new TextField(20);
                grid.add(textGanr);


                grid.add(new JLabel("Популярность:"));

                JComboBox comboBoxType = new JComboBox();

                comboBoxType.addItem("Не популярная");
                comboBoxType.addItem("Популярная");

                grid.add(comboBoxType);
                grid.add(new JLabel(""));

                JButton buttonAddDialog = new JButton("Добавить");
                grid.add(buttonAddDialog);

                buttonAddDialog.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textName.setBackground(Color.WHITE);
                        textYear.setBackground(Color.WHITE);
                        textParticipants.setBackground(Color.WHITE);
                        textGanr.setBackground(Color.WHITE);
                        Color paleRed = new Color(251, 170, 170);
                        boolean yearEmpty = false;
                        boolean participantsEmpty = false;


                        try {
                            int year = -1;
                            int participants = -1;
                            String empty = "";
                            String name = textName.getText();
                            try{year = Integer.parseInt(textYear.getText());}
                            catch (NumberFormatException exception){
                                yearEmpty = true;
                            }

                            try{participants = Integer.parseInt(textParticipants.getText());}
                            catch (NumberFormatException exception){
                                participantsEmpty = true;
                            }

                            String ganr = textGanr.getText();
                            if(textName.getText().equals(empty)) throw new NumberFormatException();
                            if(yearEmpty || year <= -1) throw new NumberFormatException();
                            if(participantsEmpty || year <= -1) throw new NumberFormatException();
                            if(textGanr.getText().equals(empty)) throw new NumberFormatException();
                            if (comboBoxType.getSelectedItem().equals("Популярная")) {
                                myTableModel.addPopular(name, year, participants, ganr);
                            } else if (comboBoxType.getSelectedItem().equals("Не популярная")) {
                                myTableModel.addNotPopular(name, year, participants, ganr);
                            }
                            dialog.dispose();
                        }catch(NumberFormatException exception){
                            String empty = "";
                            if(textName.getText().equals(empty)) textName.setBackground(paleRed);
                            if(textYear.getText().equals(empty) || yearEmpty) textYear.setBackground(paleRed);
                            if(textParticipants.getText().equals(empty) || participantsEmpty) textParticipants.setBackground(paleRed);
                            if(textGanr.getText().equals(empty)) textGanr.setBackground(paleRed);
                        }
                    }
                });
                dialog.getContentPane().add(grid);
                dialog.setVisible(true);
            }
        });

        Frame f = new Frame();

        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog();
                dialog.setModal(true);
                dialog.setSize(400, 120);
                dialog.setTitle("Поиск");
                dialog.setLocationRelativeTo(null);

                JButton buttonSearch = new JButton("Искать");

                dialog.add(buttonSearch);
                JTextField textSearch = new JTextField(30);
                dialog.add(textSearch);

                JPanel panel = new JPanel();
                JPanel panel1 = new JPanel();
                JPanel panel2= new JPanel();

                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.setAlignmentX(Component.CENTER_ALIGNMENT);

                panel1.add(textSearch);
                panel2.add(buttonSearch);
                panel.add(panel1);
                panel.add(panel2);
                dialog.getContentPane().add(panel);

                buttonSearch.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String text = textSearch.getText();
                        String message = myTableModel.search(text);;
                        JOptionPane.showMessageDialog(null, message);
                    }
                });
                dialog.setVisible(true);
            }
        });
        setContentPane(panelBorder);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
