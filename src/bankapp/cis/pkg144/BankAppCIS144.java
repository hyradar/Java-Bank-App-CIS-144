package bankapp.cis.pkg144;
public class BankAppCIS144 {
    
    public static void main(String[] args) {
        // View / GUI Object
        Display GUI = new Display();
        
        //Create Bank Account from StartWindow Data
        BankAccount accountOne = GUI.displayStartWindow();
        
        //Account 2
        BankAccount accountTwo = new BankAccount(accountOne.getName());
        accountTwo.setBalance(accountOne.getBalance());
        
        
        //Handle UserChoice during Option Window
        while (true) {
            int userChoice = GUI.displayOptionWindow(accountOne);
            
            switch (userChoice) {
            //Deposit
            case 0 -> GUI.displayDepositWindow(accountOne);
            //Withdraw
            case 1 -> GUI.displayWithdrawWindow(accountOne);
            //Exit
            case 2 -> GUI.displayExitProgramWindow();
            }
        }
    }
}
