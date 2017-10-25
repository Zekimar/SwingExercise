import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class tictactoe {
    boolean X = true;
    JFrame _frame = new JFrame("Tic-Tac-Toe");
    JButton[] _buttons = new JButton[9];
    JPanel _ttt = new JPanel();
	JPanel _newPanel = new JPanel();
    JButton _newGame = new JButton("New Game");
    public tictactoe(){
        _frame.setSize(400, 400);
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        _ttt.setLayout(new GridLayout(3, 3));
	    _newPanel.setLayout(new FlowLayout());
        _frame.add(_ttt, BorderLayout.NORTH);
	    _frame.add(_newPanel, BorderLayout.SOUTH);

        for (int j=0; j<9; j++) {
	    // Make a new button in the array location with text "_"
	    _buttons[j] = new JButton("_");
	    // Associate a new ButtonListener to the button (see below)
	    ActionListener buttonListener = new ButtonListener();
	    _buttons[j].addActionListener(buttonListener);
	    // Set the font on the button
	    _buttons[j].setFont(new Font("Courier", Font.PLAIN, 48));
	    // Add this button to the _ttt panel
	    _ttt.add(_buttons[j]);
        }
        ActionListener buttonListener = new ButtonListener();
        _newGame.setFont(new Font("Courier", Font.PLAIN, 48));
        _newGame.addActionListener(buttonListener);
        _newPanel.add(_newGame);
        _frame.setVisible(true);
    }

    class ButtonListener implements ActionListener {

	// Every time we click the button, it will perform
	// the following action.

	public void actionPerformed(ActionEvent e) {

	    JButton source = (JButton) e.getSource();
	    String currentText = source.getText();
        if (source == _newGame){
            for(JButton j: _buttons){
                j.setEnabled(true);
                j.setText("_");
            }
        }else{
	    if (currentText.equals("_") && X) {
		    source.setText("X");
            source.setEnabled(false);
            X = false;
        } else if (currentText.equals("_") && !X){
            source.setText("O");
            source.setEnabled(false);
            X = true;
        }else {
		    source.setText("_");
	    }
	}
}
}


    public static void main(String[] args){
        //System.out.println("test");
        new tictactoe();
    }
}
