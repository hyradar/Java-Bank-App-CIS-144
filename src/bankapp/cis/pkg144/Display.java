package bankapp.cis.pkg144;
import javax.swing.*;

public class Display {
    
    public void displayNewBalanceWindow(BankAccount account, double oldBalance) {
        //Format Message
        String successMessage = "Your new balance is $" + account.getBalance() + "\n" + 
                                "Your previous balance was $" + oldBalance;
        
        //Display Message
        JOptionPane.showMessageDialog(null, 
                successMessage, "Withdraw Successful!",
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    public BankAccount displayStartWindow() {

      //Input Fields
      final JTextField xField = new JTextField(5);
      final JTextField yField = new JTextField(5);
    
      //JPanel and Vertical Box
      JPanel myPanel = new JPanel();
      Box box = Box.createVerticalBox();
      myPanel.add(box);
      
      //Account Display
      box.add(new JLabel("Enter Account Name:"));
      box.add(xField);
      
      //Balance Display
      box.add(new JLabel("Enter Account Balance:"));
      box.add(yField);

      //User Input
      int userInput = JOptionPane.showConfirmDialog(null,
              myPanel, 
              "Create your account", 
              JOptionPane.OK_CANCEL_OPTION);
      
      //Cancel is Clicked
      if (userInput == 2) { this.displayExitProgramWindow(); }
      
      //Okay is Clicked
      String accountName = xField.getText();
      double balance = Double.parseDouble(yField.getText());
      
      return new BankAccount(accountName, balance);
    }
    
    public void displayExitProgramWindow() {
        //Display Message
        JOptionPane.showMessageDialog(null, 
        "Exiting Program", "Program Termination",
        JOptionPane.INFORMATION_MESSAGE);
        
        //Exit Program
        System.exit(0);
    }
    
    public void displayErrorWindow(String message) {
        //Display Message   
        JOptionPane.showMessageDialog(null, message,
                                        "Error!", JOptionPane.ERROR_MESSAGE);
    }
    
    public double displayHowMuchWindow(String message, String title, BankAccount account) {

      // Get User Choice
      double userInput = Double.parseDouble(JOptionPane.showInputDialog(null, message, 
                                           title, JOptionPane.OK_CANCEL_OPTION));
      
      //Cancel is Clicked
      if (userInput == JOptionPane.CANCEL_OPTION) { this.displayOptionWindow(account); }
      
      // If Okay is Clicked
      return userInput;
    }
    
    public void displayWithdrawWindow(BankAccount account) {

        //Withdraw version of "How Much" Window
        double withdrawAmount = displayHowMuchWindow("Enter how much you'd like to withdraw", 
                                                    "Withdraw", account);
        
        //Verify Money is Depositable
        boolean moneyIsWithdrawable = account.verifyMoneyIsWithdrawable(withdrawAmount);
        
        //Withdraw Error, try again
        if (moneyIsWithdrawable) {
            
            //Withdraw and display new balance
            account.Withdraw(withdrawAmount);
            double oldBalance = withdrawAmount + account.getBalance();
            this.displayNewBalanceWindow(account, oldBalance);
        } else {
            //Display Error Message
            this.displayErrorWindow("You are trying to withdraw $" + withdrawAmount + 
                                    " but your current balance is $" + account.getBalance());
        }
    }
    
    public void displayDepositWindow(BankAccount account) {
      
        //Deposit version of "How Much" Window
        double depositAmount = displayHowMuchWindow("Enter how much you'd like to Deposit", 
                                                    "Deposit", account);       
        
        //Verify Money is Depositable
        boolean moneyIsDepositable = account.verifyMoneyIsDepositable(depositAmount);
        
        if (moneyIsDepositable) {
            
            //Deposit money and show new balance 
            account.Deposit(depositAmount);
            double oldBalance = account.getBalance() - depositAmount;
            this.displayNewBalanceWindow(account, oldBalance);
        } else {
            //Display Error Message
            this.displayErrorWindow("You cannot deposit more than $1000.00 at a time.");
        }
    }
    
    public int displayOptionWindow(BankAccount account) {
        String[] options = new String[] {"Deposit", "Withdraw", "Exit"};
        
        //Display Message and Return User Choice
        return JOptionPane.showOptionDialog(null, 
              "Account Name: " + account.getName() + "\n" +
              "Account Balance: " + account.getBalance() + "\n\n" +
              "What would you like to do?","Your Banking Options", 
              JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);
    }
}