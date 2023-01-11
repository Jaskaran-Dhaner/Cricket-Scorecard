/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricketscorecard;

/**
 *
 * @author DELL
 */
public class teamsName {
//    Declared For Testing Purpose Only MUst be Deleted For Running App From Start. and  BElow var decl must be uncommented.
    static String teamA=" Ateam";
    static  String teamB=" Bteam";
    public static String getTeamA() {
        return teamA;
    }

    public static String getTeamB() {
        return teamB;
    }

    public static int getOvers() {
//        return overs; comment only for twsting purpose;
            return overs;
    }
    
//       static String teamA,teamB;
       static int overs;
    public teamsName(String teamA, String teamB, int overs){
         this.teamA= teamA;
         this.teamB= teamB;
         this.overs= overs;
    }
    
    public teamsName(){
            String teamA1 = teamA;
        String teamB1 = teamB;
        int overs1 = overs;
    }
}
