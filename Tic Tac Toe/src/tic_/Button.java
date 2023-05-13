package tic_;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton {

    private int index;
    private Logic logic = new Logic();
    private MyFrame myFrame;

    public Button(int index, int x, int y, Logic logic, MyFrame myFrame) {
        this.index = index;
        this.setBounds(x * 100, y * 100, 100, 100);
        this.addActionListener(new MyKeyAdapter());
        this.logic = logic;
        this.myFrame = myFrame;
    }

    public void action(String text) {
        JOptionPane.showMessageDialog(null, text);
        //окошко которое показывает кто выиграл\проиграл
        logic.startPosition(); //очищаем наши позиции
        myFrame.update();
    }

    public boolean result(String symbol) {
        if (symbol == "X") {
            action("YOU LOST");
            return true;
        }
        if (symbol == "0") {
            action("YOU WON");
            return true;
        }
        if (symbol == "deadlock") {
            action("DRAW");
            return true;
        }
        return false;
    }

    // у каждой кнопки будет свой слушатель, по которому будет доступно поле index, так как он описан внетри кнопки button
    private class MyKeyAdapter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


            logic.positionUser(index);
            myFrame.update(); //здесь записываем нолик
           if( result(logic.result())){return;}

            logic.positionPC();
            myFrame.update(); //здесь записываем крестик
            if( result(logic.result())){
                return;}

        }
    }
}