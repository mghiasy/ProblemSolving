package InterviewQuestions;

public class BankRequests {
    //deposit x amount => add amount from account x
    //transfer x y amount => transfer amount from account x to account y
    //withdraw x amount => subtract amount from account x

    //balances = array of account balances for accountNo 1 to n
   public static int[] bankRequests(int[] balances, String[] requests) {
        String request="";

        for(int i=0;i<requests.length;++i){
            request=requests[i];
            String[] incommingRequest = request.split(" ");
            if(incommingRequest[0].equals("transfer")){
                int sourceAccount = Integer.parseInt(incommingRequest[1])-1;
                int destAccount = Integer.parseInt(incommingRequest[2])-1;
                int sum =Integer.parseInt(incommingRequest[3]);
                if(validAccountNum(sourceAccount, balances.length)&& validAccountNum(destAccount,                  balances.length) && balances[sourceAccount]>=sum) {
                    balances[sourceAccount]-=sum;
                    balances[destAccount]+=sum;
                }
                else{
                    return new int[] {-1*i};
                }
            }
            else if(incommingRequest[0].equals("deposit")){
                int sourceAccount = Integer.parseInt(incommingRequest[1])-1;
                int sum =Integer.parseInt(incommingRequest[2]);
                if(validAccountNum(sourceAccount, balances.length)){
                    balances[sourceAccount]+=sum;
                }
                else{
                    return new int[] {-1*i};
                }
            }
            else if(incommingRequest[0].equals("withdraw")){
                int sourceAccount = Integer.parseInt(incommingRequest[1])-1;
                int sum =Integer.parseInt(incommingRequest[2]);
                if(validAccountNum(sourceAccount, balances.length) && balances[sourceAccount]>=sum){
                    balances[sourceAccount]-=sum;
                }
                else{
                    return new int[] {-1*i};
                }
            }

        }
        return balances;
    }
    public static Boolean validAccountNum(int AccNumber, int balancesLength){
        return AccNumber>=1 && AccNumber<=balancesLength;

    }
    public static void main(String[] args) {
        int[] balances ={20, 1000, 500, 40, 90};
        String[] requests =
        {"deposit 3 400",
                "transfer 1 2 30",
                "withdraw 4 50"};
        bankRequests(balances,requests);
    }

}
