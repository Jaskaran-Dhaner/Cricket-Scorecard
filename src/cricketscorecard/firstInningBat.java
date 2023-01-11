/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricketscorecard;

/**
 *
 * @author DELL
 */
public class firstInningBat {
    
    static String batTeam1,batTeam2,bowlTeam1,bowlTeam2;
    public firstInningBat() {
        this.batTeam1 = batTeam1;
        this.batTeam2 = batTeam2;
        this.bowlTeam1 = bowlTeam1; 
        this.bowlTeam2 = bowlTeam2;
    }

    public static String getBatTeam1() {
        return batTeam1;
    }

    public static String getBatTeam2() {
        return batTeam2;
    }

    public static String getBowlTeam1() {
        return bowlTeam1;
    }

    public static String getBowlTeam2() {
        return bowlTeam2;
    }
    public firstInningBat(String team1, String team2){
        batTeam1 = team1;
        batTeam2 = team2;
        bowlTeam1 = team2;
        bowlTeam2 = team1;
    }
    
    
    
}
