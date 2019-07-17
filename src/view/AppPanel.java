package view;

import com.toedter.calendar.JDateChooser;
import model.App;
import model.Obj;
import model.SimpleModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.text.DateFormat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class AppPanel extends JPanel implements Observer {

    public Object getNUM;
    private App application;
    private Obj obj;
    private SimpleModel sm;

    private DefaultTableModel model;

    private com.toedter.calendar.JDateChooser dateChooser = new com.toedter.calendar.JDateChooser();

    private JTable table_1 = new JTable(getModel());


    public JDateChooser getDateChooser() {
        return dateChooser;
    }

    public AppPanel(App application,Color color) {
        this.application = application;
        setOpaque(true);
        setFocusable(true);
        application.addObserver(this);
        setVisible(true);
        setBackground(color);
        model = new DefaultTableModel(new Object[][]{}, new String[]{"PRIORITY", "EVENT", "DATE"});
        model.addRow(new Object[]{ 3, "Gym", 5/6/4});
    }

    public AppPanel(Color color) {
        setOpaque(true);
        setFocusable(true);
        application.addObserver(this);
        setVisible(true);
        setBackground(color);

    }

    ;

    public DefaultTableModel getModel() {
        return model;
    }


    public String askForDate(){
        String message ="Choose start date:\n";
        Object[] params = {message,dateChooser};
        String s = "";
        JOptionPane.showConfirmDialog(null, params, "Enter the event date", JOptionPane.DEFAULT_OPTION);
        while (dateChooser.getDate() == null) {
                JOptionPane.showConfirmDialog(null, params, "Please enter the event date again!", JOptionPane.DEFAULT_OPTION);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        s = sdf.format(((JDateChooser) params[1]).getDate());
        return s;
    }





    public void addData(int priority,String date,String eventName) {
        model.addRow(new Object[]{ priority, eventName, date});
        model.fireTableDataChanged();
        table_1.setModel(model);
    }


    public int askPriorityNumber(){
        int priority = 0;
        Integer[] nums  = {1,2,3,4,5};
        while (priority == 0){
            try{
                priority = (int) JOptionPane.showInputDialog(null, "Choose now...",
                        "Choose the priority of the event", JOptionPane.QUESTION_MESSAGE, null, // Use
                        // default
                        // icon
                        nums, // Array of choices
                        nums[0]);
            } catch (NullPointerException e){
                priority = 0;
            }
        }
        return priority;
    }


    public JTable getTable(){
        return table_1;
    }


    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }


    public void editATask () {

    }

    public void deleteATask () {

    }


    public void saveFileName () {

    }
    private void writeAll () throws IOException {


    }


    public String askForEvent() {
        String eventName = null;
        while (eventName == null){
            try{
                eventName = JOptionPane.showInputDialog(null,"Enter a name for the event:", "Event Name Input", JOptionPane.INFORMATION_MESSAGE);
            } catch (NullPointerException e){
                eventName = null;
            }
        }
        return eventName;
    }

    public void clearTable() {
        model.setRowCount(0);
    }

    public void getNUM() {
        System.out.println("row: " +table_1.getRowCount() + "\n");
        System.out.println("column: " +table_1.getColumnCount() + "\n");
    }


    public int Actualrows(DefaultTableModel m) {
        int row = 0;
        int i = 0;
        for (i = 0; i < m.getRowCount(); ++i) {

            try {
                if (!(m.getValueAt(i, 0).equals("")) && !(m.getValueAt(i, 1).equals(""))
                        && !(m.getValueAt(i, 2).equals(""))) {
                    row++;
                }

            } catch (NullPointerException e) {
                continue;
            }


        }
        return row;
    }
}
