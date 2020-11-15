package HackerRank;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PasswordCracker {
    public static String passwordCracker(List<String> passwords, String loginAttempt) {
        // Write your code here
        String result = passwordCrackerHelp(passwords, loginAttempt);
        if (result.endsWith("@@")) {
            return "WRONG PASSWORD";
        }
        if (result.length() >= 1) {
            return result.substring(0, result.length() - 1);
        }
        return "WRONG PASSWORD";
    }

    public static String passwordCrackerHelp(List<String> passwords, String loginAttempt) {

        if (loginAttempt.length() == 0) return "";
        //String tempSubString = "";
//sort passwords based on length
       // List<String> sortedPass=passwords.stream().sorted((String x, String y) -> y.length()-x.length()).collect(Collectors.toList());
        List<String> possiblePass = new ArrayList<>();
        for (int i=0;i<passwords.size();++i) {//O(n)
            if (loginAttempt.length() >= passwords.get(i).length()) {
                String temp = loginAttempt.substring(0, passwords.get(i).length());//O(n)
                if (temp.equals(passwords.get(i))) {
                    //definitely in answer
                    possiblePass.add(loginAttempt.substring(0, passwords.get(i).length()));//O(n)
                }
            }
        }
        if (possiblePass.size() == 1) {
            loginAttempt = loginAttempt.substring(possiblePass.get(0).length());
            return possiblePass.get(0) + " " + passwordCrackerHelp(passwords, loginAttempt);
        }
        //
        else if (possiblePass.size() > 1) {
            //consider the second pass
            String tempCheckSubString = "";
            for (int k = 0; k < possiblePass.size(); ++k) {//O(n)
                tempCheckSubString = loginAttempt.substring(possiblePass.get(k).length());//O(n)
                if(validPassword(tempCheckSubString,passwords)){
                    return possiblePass.get(k)+ " " + passwordCrackerHelp(passwords, tempCheckSubString);
                }
            }
            return "@@";
        }
        return "@@";
    }

    private static boolean validPassword(String tempCheckSubString, List<String> passwords) {
        List<String> sortedPass=passwords.stream().sorted((String x, String y) -> y.length()-x.length()).collect(Collectors.toList());//O(nlogn)
        if(tempCheckSubString.length()==0){
            //definitely in answer
            return true;
        }
        else if(tempCheckSubString.length()<sortedPass.get(sortedPass.size()-1).length()){
            return  false;
        }
        for (int kk=0;kk<sortedPass.size();++kk) {//o(n)
            if (tempCheckSubString.length() >= sortedPass.get(kk).length()) {
                //check for next pass
                String temp = tempCheckSubString.substring(0, sortedPass.get(kk).length());
                if (temp.equals(sortedPass.get(kk))) {
                    //return possiblePass.get(k) + " " + passwordCrackerHelp(passwords, tempCheckSubString);
                    temp=tempCheckSubString.substring(temp.length());
                    if(validPassword(temp,sortedPass )){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String lt = "webarcodwebadamanweb";
        List ps = Arrays.asList("we", "web", "adaman", "barcod");

        String res = "vest love ends love vest love love love ends love vest ends open love open stop love open ends open open stop vest open love love ends vest open love vest open love stop ends vest vest stop ends ends vest ends love open ends stop stop stop vest stop vest stop love stop love stop ends vest vest stop open stop vest stop love vest stop stop open vest vest stop vest vest open vest open love vest love vest open ends love vest vest love vest vest ends open open open stop open ends love open open ends stop open stop stop stop ends ends stop vest stop love stop stop open love open open love ends vest ends ends stop open open ends ends stop stop love love open vest open open open stop ends love stop ends stop open open stop vest love ends love vest stop stop open vest stop stop vest love vest ends vest stop stop ends ends ends love stop stop love love stop open ends love love love ends love stop stop vest vest stop open vest vest ends vest open ends love vest vest vest love love open vest stop open ends ends love vest open love open vest love stop love stop vest love ends love open vest vest ends ends vest vest open open stop vest open open love open open stop vest open love love vest ends open ends open open vest open ends ends stop love stop open open stop open love love stop open love stop vest vest love vest love love ends stop vest stop love stop love love love vest stop stop love love love vest ends love stop vest vest vest love love stop open vest stop ends love open vest stop open vest love ends vest vest vest love stop love open ends ends ends stop love open ends vest vest stop open love love vest vest love ends vest ends vest stop open vest stop ends stop love open ends stop love open stop open ends vest open open stop stop stop ends open stop love stop love open love stop ends open love ends ends open love love ends open love stop ends open open vest stop open open love ends ends open ends ends open vest vest ends open ends love vest ends ends ends love stop ends stop open ends love open vest open ends love ends stop love vest vest stop open stop stop stop stop stop stop open love ends open open love vest love love vest ends vest ends ends love stop open vest ends vest love stop open open open open ends open open open stop open open open ends stop stop stop ends ends love stop open open open love vest ends vest ends love open open stop love vest vest open vest love stop ends vest vest open love vest open love love stop stop open vest love love stop vest" +
                "solo dsso open dsso solo open ends stop ends vest dsso dsso stop stop stop open solo vest solo solo solo solo solo solo stop love open love ends solo open ends solo stop open vest vest love stop stop love stop vest stop dsso dsso ends stop ends vest ends love dsso stop open love dsso solo dsso open ends solo open love stop stop stop solo dsso stop dsso vest solo vest open dsso open ends open solo dsso vest ends love love solo open ends solo open love ends stop vest vest love solo dsso vest vest open open stop solo stop stop solo stop dsso vest stop solo love open love dsso vest love vest dsso ends ends stop ends vest ends vest love stop dsso vest stop solo vest open dsso stop open open love solo vest open dsso open open love solo stop love love vest love ends vest solo love solo open solo vest open dsso open open stop open ends open love vest dsso ends ends love solo stop solo love dsso solo love open stop open vest vest open stop vest dsso solo vest solo dsso solo stop vest ends open solo dsso stop dsso open stop open vest open open solo solo solo dsso stop stop ends love love stop dsso ends ends dsso open stop vest love dsso stop love solo love stop open vest love stop love vest solo vest open solo love open solo vest open dsso love dsso stop vest stop dsso open solo love vest vest love stop love stop solo ends open solo love vest solo vest open dsso vest solo love solo open solo love love stop open ends love solo open ends solo vest dsso stop open open dsso dsso ends open ends ends open vest vest solo vest open love vest open ends solo ends stop love dsso vest stop open open vest dsso open open solo love love ends open open open dsso vest stop ends ends stop solo dsso solo open love stop solo love love love ends solo dsso love stop stop open dsso open solo open ends solo ends stop vest stop dsso open ends love vest open stop dsso dsso stop ends dsso stop ends dsso vest dsso vest solo ends solo solo solo love stop ends ends vest open dsso dsso stop ends solo love open ends solo vest love vest love solo love solo vest stop love solo ends vest vest stop dsso ends open open ends open solo open open stop solo open dsso stop solo ends stop love open stop ends dsso stop stop open dsso ends dsso dsso love love vest ends stop love ends vest ends solo dsso solo solo solo love dsso love solo stop solo ends stop open solo dsso love love love ends solo vest love vest vest dsso stop open solo vest open dsso stop ends ends dsso stop stop vest stop ends ends dsso open";
        String lt2 = "helloworld";
        List ps2 = Arrays.asList("hello", "planet");

        List ll = Arrays.asList(
                Arrays.asList("fjrg", "ckcapp", "zhhwync", "cgwkpsuzy", "prnqnyek", "tgfx", "rxiydd", "pgkujtpp", "lxhwbxi", "exsfzd"),

                Arrays.asList("kakd", "ipinec", "dwgjyba", "mmgtfbi", "wmvzl", "boam", "rjlf", "egqabmfzj", "naixxt", "iqgh"),

                Arrays.asList("qrotnywh", "cuws", "rdwhmnw", "vlcugoqo", "lhlyyjttfs", "gaglvy", "obsw", "mlfprlmpp", "qgajafqn", "onxpcc"),

                Arrays.asList("vgvvkhz", "crbwctsm", "vxyr", "azmdx", "zgvtks", "cvtv", "hqhkfwk", "jkpmh", "rddiuhn", "hzxwalpl"),

                Arrays.asList("ticixftt", "tzuu", "gfhez", "wdzrkid", "grpxoz", "ulyxqwvp", "motigcpg", "jxobm", "lmcuy", "fflhzuwtx"),
                Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")
        );


        ;

        String[] mm = {"fjrgfjrgprnqnyekexsfzdlxhwbxilxhwbxizhhwynccgwkpsuzy",
                "boamboamipineciqghkakdrjlfiqghrjlfmmgtfbinaixxt",
                "qgajafqngaglvyqrotnywhvlcugoqordwhmnwvlcugoqo",
                "zgvtksvxyrcrbwctsmjkpmhcrbwctsmrddiuhnzgvtksvxyr",
                "grpxozticixftttzuumotigcpgtzuuticixfttlmcuyticixftt",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
        };
//for(int i=0;i<= 5;++i) {
//    System.out.println(passwordCracker((List<String>)ll.get(i), mm[i]));
//}
        //System.out.println(res.equals(passwordCracker(ps,lt)) );
        System.out.println(passwordCracker(ps, lt));
    }
}
